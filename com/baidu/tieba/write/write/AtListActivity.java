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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView dpl;
    private LinearLayout eRc;
    private Button eRd;
    private View eRh;
    private View eRi;
    private ImageView eRk;
    private AtSelectFriendList hJN;
    private TextView hJU;
    private TextView hJV;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    protected ArrayList<MetaData> hJM = new ArrayList<>();
    private EditText rD = null;
    private TextView bSo = null;
    private BdListView auZ = null;
    private final Handler mHandler = new Handler();
    private a hJO = null;
    private b hJP = null;
    private com.baidu.tieba.write.model.b hJQ = null;
    private com.baidu.tieba.write.write.a hJR = null;
    private String hJS = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hJT = null;
    private final int hJW = 5;
    private boolean hJX = true;
    private boolean hJY = false;
    private final Runnable hJZ = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uH(k.a(AtListActivity.this.rD.getText(), ""));
        }
    };
    private NoNetworkView.a hil = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                AtListActivity.this.uH(null);
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
        uH(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpl.onChangeSkinType(getPageContext(), i);
        this.hJR.notifyDataSetChanged();
        aj.getColor(d.C0141d.common_color_10221);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.s(this.eRd, d.f.post_button_bg);
        aj.e(this.eRd, d.C0141d.cp_cont_i, 3);
        aj.a(this.eRk, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.r(this.hJV, d.C0141d.navi_back_text_color);
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
    public void xJ(int i) {
        if (i == 2) {
            this.auZ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.no_chat_friends));
            this.eRc.setVisibility(8);
        } else if (i == 1) {
            this.auZ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.no_search_friends));
            this.eRc.setVisibility(8);
        } else if (i == 0) {
            this.auZ.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hJX) {
                this.eRc.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hJR.getItem(i);
        if (item != null) {
            if (this.hJX) {
                if (this.hJO == null && this.hJP == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hJN.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hJR.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.a(getPageContext().getPageActivity(), this.rD);
            if (this.hJY) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new ak("c12930").f("obj_id", item.getUserIdLong()));
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
        if (this.hJO != null) {
            this.hJO.cancel();
        }
        if (this.hJP != null) {
            this.hJP.cancel();
        }
        this.mHandler.removeCallbacks(this.hJZ);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_chat_friends), null, true);
        this.hJT = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rD);
                    return false;
                }
                return false;
            }
        });
        awO();
        this.dpl = (NoNetworkView) findViewById(d.g.view_no_network);
        this.dpl.a(this.hil);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.auZ = (BdListView) findViewById(d.g.list);
        this.hJR = new com.baidu.tieba.write.write.a(this, this.hJX);
        this.hJR.a(this);
        this.hJR.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hJN.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.auZ.setAdapter((ListAdapter) this.hJR);
        this.auZ.setOnItemClickListener(this);
        this.auZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rD);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.rD.getParent() != null) {
            ((View) this.rD.getParent()).setFocusable(true);
            ((View) this.rD.getParent()).setFocusableInTouchMode(true);
        }
        this.eRc = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.eRd = (Button) this.mParent.findViewById(d.g.button_send);
        this.eRd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hJN.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rD);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qH(0);
        this.hJN = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hJN.setMaxCount(5);
        this.hJN.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.auZ.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aNg();
    }

    private void awO() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hJV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eRh != null && AtListActivity.this.eRh.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rD);
                    AtListActivity.this.eRh.setVisibility(8);
                    AtListActivity.this.hJU.setVisibility(0);
                    AtListActivity.this.eRi.setVisibility(0);
                    AtListActivity.this.rD.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rD);
                AtListActivity.this.finish();
            }
        });
        this.hJU = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.eRi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hJU.setVisibility(8);
                AtListActivity.this.eRi.setVisibility(8);
                AtListActivity.this.eRh.setVisibility(0);
                AtListActivity.this.rD.requestFocus();
            }
        });
        this.eRk = (ImageView) this.eRi.findViewById(d.g.new_friend_search);
        this.eRh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eRh.setVisibility(8);
        this.rD = (EditText) this.eRh.findViewById(d.g.search_bar_edit);
        this.rD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hJS)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hJZ);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hJZ, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bSo.setVisibility(0);
                    } else {
                        AtListActivity.this.bSo.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hJS = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.rD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.bSo = (TextView) findViewById(d.g.search_bar_delete_button);
        this.bSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.rD.getText().clear();
            }
        });
    }

    private void aNg() {
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
                AtListActivity.this.auZ.requestFocus();
            }
        });
        this.auZ.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(String str) {
        if (!isFinishing()) {
            this.hJR.setData(null);
            if (this.hJO != null) {
                this.hJO.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hJQ.bGX() != null) {
                    ArrayList<MetaData> bGM = this.hJQ.bGX().bGM();
                    Iterator<MetaData> it = bGM.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bGM != null && !bGM.isEmpty()) {
                        xJ(0);
                    } else {
                        xJ(1);
                    }
                    this.hJR.setData(bGM);
                } else {
                    this.hJR.setData(null);
                    if (this.hJP == null) {
                        this.hJP = new b();
                        this.hJP.setPriority(3);
                        this.hJP.execute("");
                    }
                }
            } else {
                this.hJO = new a();
                this.hJO.setPriority(2);
                this.hJO.execute(str);
                if (this.hJP == null && this.hJQ.bGX() == null) {
                    this.hJP = new b();
                    this.hJP.setPriority(3);
                    this.hJP.execute("");
                }
            }
            this.hJR.notifyDataSetInvalidated();
            this.auZ.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hJQ = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hJX = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hJY = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hJX = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hJY = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hJN.f(metaData);
            qH(this.hJN.getItemLength());
            aNh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hJN.h(metaData);
            qH(this.hJN.getItemLength());
            aNh();
        }
    }

    private void aNh() {
        if (this.hJN.getItemLength() > 0) {
            this.eRd.setEnabled(true);
        } else {
            this.eRd.setEnabled(false);
        }
    }

    private void qH(int i) {
        this.eRd.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hKb;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hKb = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hJO = null;
            this.hKb = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hKb = strArr[0];
            this.mNetwork = new x();
            if (this.hKb == null || this.hKb.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.n(WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, this.hKb);
            if (AtListActivity.this.hJY) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String Cb = this.mNetwork.Cb();
            if (!this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(Cb, AtListActivity.this.hJQ.bGX());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hJO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Cz().Dx().isRequestSuccess() && this.hKb != null && k.a(AtListActivity.this.rD.getText(), "").equals(this.hKb)) {
                if (cVar == null || cVar.bGO().isEmpty()) {
                    AtListActivity.this.xJ(1);
                } else {
                    AtListActivity.this.xJ(0);
                }
                AtListActivity.this.hJQ.a(cVar);
                AtListActivity.this.hJR.setData(cVar.bGO());
                AtListActivity.this.hJR.notifyDataSetInvalidated();
                AtListActivity.this.auZ.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
                this.mNetwork.mS();
            }
            AtListActivity.this.hJP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hJY) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String Cb = this.mNetwork.Cb();
            if (!this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.uu(Cb);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hJP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eRc != null && AtListActivity.this.eRc.getVisibility() == 0) {
                AtListActivity.this.hJT.setVisibility(0);
            }
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                AtListActivity.this.hJQ.a(bVar);
                if (AtListActivity.this.hJR != null) {
                    if (k.a(AtListActivity.this.rD.getText(), "").length() != 0) {
                        if (AtListActivity.this.hJQ.bGY() != null) {
                            if (bVar != null && bVar.bGN() != null && !bVar.bGN().isEmpty()) {
                                AtListActivity.this.xJ(2);
                            }
                            AtListActivity.this.hJQ.bGY().n(bVar.bGN());
                            AtListActivity.this.hJR.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bGM() == null || !bVar.bGM().isEmpty()) {
                            AtListActivity.this.xJ(0);
                        } else {
                            AtListActivity.this.xJ(2);
                        }
                        AtListActivity.this.hJM = bVar.bGM();
                        AtListActivity.this.hJR.setData(AtListActivity.this.hJM);
                        AtListActivity.this.hJR.notifyDataSetInvalidated();
                        AtListActivity.this.auZ.setSelection(0);
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
            this.hJN.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.auZ == null) {
            return null;
        }
        return this.auZ.getPreLoadHandle();
    }
}
