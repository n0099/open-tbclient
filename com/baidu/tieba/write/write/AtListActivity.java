package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView eCe;
    private LinearLayout gvX;
    private Button gvY;
    private View gwc;
    private View gwd;
    private ImageView gwf;
    private TextView jrC;
    private TextView jrD;
    private AtSelectFriendList jrv;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> jru = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cMM = null;
    private BdListView Pj = null;
    private final Handler mHandler = new Handler();
    private a jrw = null;
    private b jrx = null;
    private com.baidu.tieba.write.model.b jry = null;
    private com.baidu.tieba.write.write.a jrz = null;
    private String jrA = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View jrB = null;
    private final int jrE = 5;
    private boolean jrF = true;
    private boolean jrG = false;
    private final Runnable jrH = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.EC(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a iOM = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                AtListActivity.this.EC(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.at_list_activity);
        initData(bundle);
        initUI();
        EC(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eCe.onChangeSkinType(getPageContext(), i);
        this.jrz.notifyDataSetChanged();
        al.getColor(d.C0277d.common_color_10221);
        al.k(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        al.k(this.gvY, d.f.post_button_bg);
        al.d(this.gvY, d.C0277d.cp_btn_a, 3);
        al.a(this.gwf, d.f.icon_search_bg_s, d.f.icon_search_bg);
        al.j(this.jrD, d.C0277d.navi_back_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br(int i) {
        if (i == 2) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.no_chat_friends));
            this.gvX.setVisibility(8);
        } else if (i == 1) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.no_search_friends));
            this.gvX.setVisibility(8);
        } else if (i == 0) {
            this.Pj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.jrF) {
                this.gvX.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.jrz.getItem(i);
        if (item != null) {
            if (this.jrF) {
                if (this.jrw == null && this.jrx == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.jrv.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.jrz.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.jrG) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new am("c12930").k(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(IntentConfig.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jrw != null) {
            this.jrw.cancel();
        }
        if (this.jrx != null) {
            this.jrx.cancel();
        }
        this.mHandler.removeCallbacks(this.jrH);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.no_chat_friends), null, true);
        this.jrB = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        aBy();
        this.eCe = (NoNetworkView) findViewById(d.g.view_no_network);
        this.eCe.a(this.iOM);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Pj = (BdListView) findViewById(d.g.list);
        this.jrz = new com.baidu.tieba.write.write.a(this, this.jrF);
        this.jrz.a(this);
        this.jrz.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.jrv.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Pj.setAdapter((ListAdapter) this.jrz);
        this.Pj.setOnItemClickListener(this);
        this.Pj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.gvX = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.gvY = (Button) this.mParent.findViewById(d.g.button_send);
        this.gvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.jrv.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        ur(0);
        this.jrv = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.jrv.setMaxCount(5);
        this.jrv.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Pj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        bxe();
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.jrD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.gwc != null && AtListActivity.this.gwc.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.gwc.setVisibility(8);
                    AtListActivity.this.jrC.setVisibility(0);
                    AtListActivity.this.gwd.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.jrC = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.gwd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.jrC.setVisibility(8);
                AtListActivity.this.gwd.setVisibility(8);
                AtListActivity.this.gwc.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.gwf = (ImageView) this.gwd.findViewById(d.g.new_friend_search);
        this.gwc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.gwc.setVisibility(8);
        this.mEditText = (EditText) this.gwc.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.jrA)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.jrH);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.jrH, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cMM.setVisibility(0);
                    } else {
                        AtListActivity.this.cMM.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.jrA = com.baidu.adp.lib.util.k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.c(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.cMM = (TextView) findViewById(d.g.search_bar_delete_button);
        this.cMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void bxe() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds80) + getResources().getDimensionPixelSize(d.e.ds16) + getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.Pj.requestFocus();
            }
        });
        this.Pj.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC(String str) {
        if (!isFinishing()) {
            this.jrz.setData(null);
            if (this.jrw != null) {
                this.jrw.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.jry.cpz() != null) {
                    ArrayList<MetaData> cpq = this.jry.cpz().cpq();
                    Iterator<MetaData> it = cpq.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (cpq != null && !cpq.isEmpty()) {
                        Br(0);
                    } else {
                        Br(1);
                    }
                    this.jrz.setData(cpq);
                } else {
                    this.jrz.setData(null);
                    if (this.jrx == null) {
                        this.jrx = new b();
                        this.jrx.setPriority(3);
                        this.jrx.execute("");
                    }
                }
            } else {
                this.jrw = new a();
                this.jrw.setPriority(2);
                this.jrw.execute(str);
                if (this.jrx == null && this.jry.cpz() == null) {
                    this.jrx = new b();
                    this.jrx.setPriority(3);
                    this.jrx.execute("");
                }
            }
            this.jrz.notifyDataSetInvalidated();
            this.Pj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.jry = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.jrF = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.jrG = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.jrF = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.jrG = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.jrv.f(metaData);
            ur(this.jrv.getItemLength());
            bxf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.jrv.h(metaData);
            ur(this.jrv.getItemLength());
            bxf();
        }
    }

    private void bxf() {
        if (this.jrv.getItemLength() > 0) {
            this.gvY.setEnabled(true);
        } else {
            this.gvY.setEnabled(false);
        }
    }

    private void ur(int i) {
        this.gvY.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String jrJ;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jrJ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.jrw = null;
            this.jrJ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.jrJ = strArr[0];
            this.mNetwork = new x();
            if (this.jrJ == null || this.jrJ.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.x("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.x("q", this.jrJ);
            if (AtListActivity.this.jrG) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String acg = this.mNetwork.acg();
            if (!this.mNetwork.acE().adD().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(acg, AtListActivity.this.jry.cpz());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.jrw = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.acE().adD().isRequestSuccess() && this.jrJ != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.jrJ)) {
                if (cVar == null || cVar.cps().isEmpty()) {
                    AtListActivity.this.Br(1);
                } else {
                    AtListActivity.this.Br(0);
                }
                AtListActivity.this.jry.a(cVar);
                AtListActivity.this.jrz.setData(cVar.cps());
                AtListActivity.this.jrz.notifyDataSetInvalidated();
                AtListActivity.this.Pj.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private x mNetwork;

        private b() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ji();
            }
            AtListActivity.this.jrx = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.jrG) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String acg = this.mNetwork.acg();
            if (!this.mNetwork.acE().adD().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Er(acg);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.jrx = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.gvX != null && AtListActivity.this.gvX.getVisibility() == 0) {
                AtListActivity.this.jrB.setVisibility(0);
            }
            if (this.mNetwork.acE().adD().isRequestSuccess()) {
                AtListActivity.this.jry.a(bVar);
                if (AtListActivity.this.jrz != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.jry.cpA() != null) {
                            if (bVar != null && bVar.cpr() != null && !bVar.cpr().isEmpty()) {
                                AtListActivity.this.Br(2);
                            }
                            AtListActivity.this.jry.cpA().v(bVar.cpr());
                            AtListActivity.this.jrz.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.cpq() == null || !bVar.cpq().isEmpty()) {
                            AtListActivity.this.Br(0);
                        } else {
                            AtListActivity.this.Br(2);
                        }
                        AtListActivity.this.jru = bVar.cpq();
                        AtListActivity.this.jrz.setData(AtListActivity.this.jru);
                        AtListActivity.this.jrz.notifyDataSetInvalidated();
                        AtListActivity.this.Pj.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    @Override // com.baidu.tieba.write.write.a.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.jrv.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.Pj == null) {
            return null;
        }
        return this.Pj.getPreLoadHandle();
    }
}
