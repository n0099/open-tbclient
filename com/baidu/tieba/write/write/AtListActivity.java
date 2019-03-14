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
    private NoNetworkView eCt;
    private LinearLayout gwk;
    private Button gwl;
    private View gwp;
    private View gwq;
    private ImageView gws;
    private AtSelectFriendList jrF;
    private TextView jrM;
    private TextView jrN;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> jrE = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cMK = null;
    private BdListView Pj = null;
    private final Handler mHandler = new Handler();
    private a jrG = null;
    private b jrH = null;
    private com.baidu.tieba.write.model.b jrI = null;
    private com.baidu.tieba.write.write.a jrJ = null;
    private String jrK = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View jrL = null;
    private final int jrO = 5;
    private boolean jrP = true;
    private boolean jrQ = false;
    private final Runnable jrR = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.ED(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a iOY = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                AtListActivity.this.ED(null);
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
        ED(null);
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
        this.eCt.onChangeSkinType(getPageContext(), i);
        this.jrJ.notifyDataSetChanged();
        al.getColor(d.C0277d.common_color_10221);
        al.k(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        al.k(this.gwl, d.f.post_button_bg);
        al.d(this.gwl, d.C0277d.cp_btn_a, 3);
        al.a(this.gws, d.f.icon_search_bg_s, d.f.icon_search_bg);
        al.j(this.jrN, d.C0277d.navi_back_text_color);
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
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.no_chat_friends));
            this.gwk.setVisibility(8);
        } else if (i == 1) {
            this.Pj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.no_search_friends));
            this.gwk.setVisibility(8);
        } else if (i == 0) {
            this.Pj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.jrP) {
                this.gwk.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.jrJ.getItem(i);
        if (item != null) {
            if (this.jrP) {
                if (this.jrG == null && this.jrH == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.jrF.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.jrJ.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.jrQ) {
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
        if (this.jrG != null) {
            this.jrG.cancel();
        }
        if (this.jrH != null) {
            this.jrH.cancel();
        }
        this.mHandler.removeCallbacks(this.jrR);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds320)), NoDataViewFactory.d.hU(d.j.no_chat_friends), null, true);
        this.jrL = findViewById(d.g.at_candidate_border);
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
        aBB();
        this.eCt = (NoNetworkView) findViewById(d.g.view_no_network);
        this.eCt.a(this.iOY);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.Pj = (BdListView) findViewById(d.g.list);
        this.jrJ = new com.baidu.tieba.write.write.a(this, this.jrP);
        this.jrJ.a(this);
        this.jrJ.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.jrF.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Pj.setAdapter((ListAdapter) this.jrJ);
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
        this.gwk = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.gwl = (Button) this.mParent.findViewById(d.g.button_send);
        this.gwl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.jrF.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        uv(0);
        this.jrF = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.jrF.setMaxCount(5);
        this.jrF.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
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
        bxh();
    }

    private void aBB() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.jrN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.gwp != null && AtListActivity.this.gwp.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.gwp.setVisibility(8);
                    AtListActivity.this.jrM.setVisibility(0);
                    AtListActivity.this.gwq.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.jrM = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.gwq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.jrM.setVisibility(8);
                AtListActivity.this.gwq.setVisibility(8);
                AtListActivity.this.gwp.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.gws = (ImageView) this.gwq.findViewById(d.g.new_friend_search);
        this.gwp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.gwp.setVisibility(8);
        this.mEditText = (EditText) this.gwp.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.jrK)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.jrR);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.jrR, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cMK.setVisibility(0);
                    } else {
                        AtListActivity.this.cMK.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.jrK = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.cMK = (TextView) findViewById(d.g.search_bar_delete_button);
        this.cMK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void bxh() {
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
    public void ED(String str) {
        if (!isFinishing()) {
            this.jrJ.setData(null);
            if (this.jrG != null) {
                this.jrG.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.jrI.cpB() != null) {
                    ArrayList<MetaData> cps = this.jrI.cpB().cps();
                    Iterator<MetaData> it = cps.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (cps != null && !cps.isEmpty()) {
                        Bv(0);
                    } else {
                        Bv(1);
                    }
                    this.jrJ.setData(cps);
                } else {
                    this.jrJ.setData(null);
                    if (this.jrH == null) {
                        this.jrH = new b();
                        this.jrH.setPriority(3);
                        this.jrH.execute("");
                    }
                }
            } else {
                this.jrG = new a();
                this.jrG.setPriority(2);
                this.jrG.execute(str);
                if (this.jrH == null && this.jrI.cpB() == null) {
                    this.jrH = new b();
                    this.jrH.setPriority(3);
                    this.jrH.execute("");
                }
            }
            this.jrJ.notifyDataSetInvalidated();
            this.Pj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.jrI = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.jrP = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.jrQ = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.jrP = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.jrQ = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.jrF.f(metaData);
            uv(this.jrF.getItemLength());
            bxi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.jrF.h(metaData);
            uv(this.jrF.getItemLength());
            bxi();
        }
    }

    private void bxi() {
        if (this.jrF.getItemLength() > 0) {
            this.gwl.setEnabled(true);
        } else {
            this.gwl.setEnabled(false);
        }
    }

    private void uv(int i) {
        this.gwl.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String jrT;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.jrT = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.jrG = null;
            this.jrT = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.jrT = strArr[0];
            this.mNetwork = new x();
            if (this.jrT == null || this.jrT.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.x("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.x("q", this.jrT);
            if (AtListActivity.this.jrQ) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String acj = this.mNetwork.acj();
            if (!this.mNetwork.acH().adG().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(acj, AtListActivity.this.jrI.cpB());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.jrG = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.acH().adG().isRequestSuccess() && this.jrT != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.jrT)) {
                if (cVar == null || cVar.cpu().isEmpty()) {
                    AtListActivity.this.Bv(1);
                } else {
                    AtListActivity.this.Bv(0);
                }
                AtListActivity.this.jrI.a(cVar);
                AtListActivity.this.jrJ.setData(cVar.cpu());
                AtListActivity.this.jrJ.notifyDataSetInvalidated();
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
            AtListActivity.this.jrH = null;
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
            if (AtListActivity.this.jrQ) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String acj = this.mNetwork.acj();
            if (!this.mNetwork.acH().adG().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Es(acj);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.jrH = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.gwk != null && AtListActivity.this.gwk.getVisibility() == 0) {
                AtListActivity.this.jrL.setVisibility(0);
            }
            if (this.mNetwork.acH().adG().isRequestSuccess()) {
                AtListActivity.this.jrI.a(bVar);
                if (AtListActivity.this.jrJ != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.jrI.cpC() != null) {
                            if (bVar != null && bVar.cpt() != null && !bVar.cpt().isEmpty()) {
                                AtListActivity.this.Bv(2);
                            }
                            AtListActivity.this.jrI.cpC().v(bVar.cpt());
                            AtListActivity.this.jrJ.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.cps() == null || !bVar.cps().isEmpty()) {
                            AtListActivity.this.Bv(0);
                        } else {
                            AtListActivity.this.Bv(2);
                        }
                        AtListActivity.this.jrE = bVar.cps();
                        AtListActivity.this.jrJ.setData(AtListActivity.this.jrE);
                        AtListActivity.this.jrJ.notifyDataSetInvalidated();
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
            this.jrF.g(metaData);
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
