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
    private NoNetworkView eCx;
    private LinearLayout gwl;
    private Button gwm;
    private View gwq;
    private View gwr;
    private ImageView gwt;
    private AtSelectFriendList jrN;
    private TextView jrU;
    private TextView jrV;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> jrM = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cMN = null;
    private BdListView Pi = null;
    private final Handler mHandler = new Handler();
    private a jrO = null;
    private b jrP = null;
    private com.baidu.tieba.write.model.b jrQ = null;
    private com.baidu.tieba.write.write.a jrR = null;
    private String jrS = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View jrT = null;
    private final int jrW = 5;
    private boolean jrX = true;
    private boolean jrY = false;
    private final Runnable jrZ = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.EF(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a iPg = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                AtListActivity.this.EF(null);
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
        EF(null);
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
        this.eCx.onChangeSkinType(getPageContext(), i);
        this.jrR.notifyDataSetChanged();
        al.getColor(d.C0236d.common_color_10221);
        al.k(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        al.k(this.gwm, d.f.post_button_bg);
        al.d(this.gwm, d.C0236d.cp_btn_a, 3);
        al.a(this.gwt, d.f.icon_search_bg_s, d.f.icon_search_bg);
        al.j(this.jrV, d.C0236d.navi_back_text_color);
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
    public void Bv(int i) {
        if (i == 2) {
            this.Pi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.no_chat_friends));
            this.gwl.setVisibility(8);
        } else if (i == 1) {
            this.Pi.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.no_search_friends));
            this.gwl.setVisibility(8);
        } else if (i == 0) {
            this.Pi.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.jrX) {
                this.gwl.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.jrR.getItem(i);
        if (item != null) {
            if (this.jrX) {
                if (this.jrO == null && this.jrP == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.jrN.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.jrR.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.jrY) {
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
        if (this.jrO != null) {
            this.jrO.cancel();
        }
        if (this.jrP != null) {
            this.jrP.cancel();
        }
        this.mHandler.removeCallbacks(this.jrZ);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds320)), NoDataViewFactory.d.hU(d.j.no_chat_friends), null, true);
        this.jrT = findViewById(d.g.at_candidate_border);
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
        aBC();
        this.eCx = (NoNetworkView) findViewById(d.g.view_no_network);
        this.eCx.a(this.iPg);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Pi = (BdListView) findViewById(d.g.list);
        this.jrR = new com.baidu.tieba.write.write.a(this, this.jrX);
        this.jrR.a(this);
        this.jrR.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.jrN.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Pi.setAdapter((ListAdapter) this.jrR);
        this.Pi.setOnItemClickListener(this);
        this.Pi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.gwl = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.gwm = (Button) this.mParent.findViewById(d.g.button_send);
        this.gwm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.jrN.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        uv(0);
        this.jrN = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.jrN.setMaxCount(5);
        this.jrN.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Pi.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        bxi();
    }

    private void aBC() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.jrV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.gwq != null && AtListActivity.this.gwq.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.gwq.setVisibility(8);
                    AtListActivity.this.jrU.setVisibility(0);
                    AtListActivity.this.gwr.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.jrU = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.gwr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.jrU.setVisibility(8);
                AtListActivity.this.gwr.setVisibility(8);
                AtListActivity.this.gwq.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.gwt = (ImageView) this.gwr.findViewById(d.g.new_friend_search);
        this.gwq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.gwq.setVisibility(8);
        this.mEditText = (EditText) this.gwq.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.jrS)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.jrZ);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.jrZ, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cMN.setVisibility(0);
                    } else {
                        AtListActivity.this.cMN.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.jrS = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.cMN = (TextView) findViewById(d.g.search_bar_delete_button);
        this.cMN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void bxi() {
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
                AtListActivity.this.Pi.requestFocus();
            }
        });
        this.Pi.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EF(String str) {
        if (!isFinishing()) {
            this.jrR.setData(null);
            if (this.jrO != null) {
                this.jrO.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.jrQ.cpy() != null) {
                    ArrayList<MetaData> cpp = this.jrQ.cpy().cpp();
                    Iterator<MetaData> it = cpp.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (cpp != null && !cpp.isEmpty()) {
                        Bv(0);
                    } else {
                        Bv(1);
                    }
                    this.jrR.setData(cpp);
                } else {
                    this.jrR.setData(null);
                    if (this.jrP == null) {
                        this.jrP = new b();
                        this.jrP.setPriority(3);
                        this.jrP.execute("");
                    }
                }
            } else {
                this.jrO = new a();
                this.jrO.setPriority(2);
                this.jrO.execute(str);
                if (this.jrP == null && this.jrQ.cpy() == null) {
                    this.jrP = new b();
                    this.jrP.setPriority(3);
                    this.jrP.execute("");
                }
            }
            this.jrR.notifyDataSetInvalidated();
            this.Pi.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.jrQ = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.jrX = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.jrY = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.jrX = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.jrY = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.jrN.f(metaData);
            uv(this.jrN.getItemLength());
            bxj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.jrN.h(metaData);
            uv(this.jrN.getItemLength());
            bxj();
        }
    }

    private void bxj() {
        if (this.jrN.getItemLength() > 0) {
            this.gwm.setEnabled(true);
        } else {
            this.gwm.setEnabled(false);
        }
    }

    private void uv(int i) {
        this.gwm.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String jsb;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jsb = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.jrO = null;
            this.jsb = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.jsb = strArr[0];
            this.mNetwork = new x();
            if (this.jsb == null || this.jsb.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.x("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.x("q", this.jsb);
            if (AtListActivity.this.jrY) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String acj = this.mNetwork.acj();
            if (!this.mNetwork.acH().adG().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(acj, AtListActivity.this.jrQ.cpy());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.jrO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.acH().adG().isRequestSuccess() && this.jsb != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.jsb)) {
                if (cVar == null || cVar.cpr().isEmpty()) {
                    AtListActivity.this.Bv(1);
                } else {
                    AtListActivity.this.Bv(0);
                }
                AtListActivity.this.jrQ.a(cVar);
                AtListActivity.this.jrR.setData(cVar.cpr());
                AtListActivity.this.jrR.notifyDataSetInvalidated();
                AtListActivity.this.Pi.setSelection(0);
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
            AtListActivity.this.jrP = null;
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
            if (AtListActivity.this.jrY) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String acj = this.mNetwork.acj();
            if (!this.mNetwork.acH().adG().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Eu(acj);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.jrP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.gwl != null && AtListActivity.this.gwl.getVisibility() == 0) {
                AtListActivity.this.jrT.setVisibility(0);
            }
            if (this.mNetwork.acH().adG().isRequestSuccess()) {
                AtListActivity.this.jrQ.a(bVar);
                if (AtListActivity.this.jrR != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.jrQ.cpz() != null) {
                            if (bVar != null && bVar.cpq() != null && !bVar.cpq().isEmpty()) {
                                AtListActivity.this.Bv(2);
                            }
                            AtListActivity.this.jrQ.cpz().v(bVar.cpq());
                            AtListActivity.this.jrR.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.cpp() == null || !bVar.cpp().isEmpty()) {
                            AtListActivity.this.Bv(0);
                        } else {
                            AtListActivity.this.Bv(2);
                        }
                        AtListActivity.this.jrM = bVar.cpp();
                        AtListActivity.this.jrR.setData(AtListActivity.this.jrM);
                        AtListActivity.this.jrR.notifyDataSetInvalidated();
                        AtListActivity.this.Pi.setSelection(0);
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
            this.jrN.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.Pi == null) {
            return null;
        }
        return this.Pi.getPreLoadHandle();
    }
}
