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
import com.baidu.tieba.e;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView cYm;
    private LinearLayout eMJ;
    private Button eMK;
    private View eMO;
    private View eMP;
    private ImageView eMR;
    private AtSelectFriendList hGk;
    private TextView hGr;
    private TextView hGs;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hGj = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bsA = null;
    private BdListView Op = null;
    private final Handler mHandler = new Handler();
    private a hGl = null;
    private b hGm = null;
    private com.baidu.tieba.write.model.b hGn = null;
    private com.baidu.tieba.write.write.a hGo = null;
    private String hGp = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hGq = null;
    private final int hGt = 5;
    private boolean hGu = true;
    private boolean hGv = false;
    private final Runnable hGw = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.wC(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a hdJ = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (z) {
                AtListActivity.this.wC(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.at_list_activity);
        initData(bundle);
        initUI();
        wC(null);
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
        this.cYm.onChangeSkinType(getPageContext(), i);
        this.hGo.notifyDataSetChanged();
        al.getColor(e.d.common_color_10221);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        al.i(this.eMK, e.f.post_button_bg);
        al.c(this.eMK, e.d.cp_cont_i, 3);
        al.a(this.eMR, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.h(this.hGs, e.d.navi_back_text_color);
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
    public void wd(int i) {
        if (i == 2) {
            this.Op.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.no_chat_friends));
            this.eMJ.setVisibility(8);
        } else if (i == 1) {
            this.Op.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.no_search_friends));
            this.eMJ.setVisibility(8);
        } else if (i == 0) {
            this.Op.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hGu) {
                this.eMJ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hGo.getItem(i);
        if (item != null) {
            if (this.hGu) {
                if (this.hGl == null && this.hGm == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hGk.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hGo.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.a(getPageContext().getPageActivity(), this.mEditText);
            if (this.hGv) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new am("c12930").g(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.hGl != null) {
            this.hGl.cancel();
        }
        if (this.hGm != null) {
            this.hGm.cancel();
        }
        this.mHandler.removeCallbacks(this.hGw);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0141e.ds320)), NoDataViewFactory.d.dE(e.j.no_chat_friends), null, true);
        this.hGq = findViewById(e.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        atZ();
        this.cYm = (NoNetworkView) findViewById(e.g.view_no_network);
        this.cYm.a(this.hdJ);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.Op = (BdListView) findViewById(e.g.list);
        this.hGo = new com.baidu.tieba.write.write.a(this, this.hGu);
        this.hGo.a(this);
        this.hGo.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hGk.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Op.setAdapter((ListAdapter) this.hGo);
        this.Op.setOnItemClickListener(this);
        this.Op.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.eMJ = (LinearLayout) this.mParent.findViewById(e.g.invite_candidate);
        this.eMK = (Button) this.mParent.findViewById(e.g.button_send);
        this.eMK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hGk.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        pm(0);
        this.hGk = (AtSelectFriendList) this.mParent.findViewById(e.g.candidate_list);
        this.hGk.setMaxCount(5);
        this.hGk.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Op.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aQM();
    }

    private void atZ() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.hGs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eMO != null && AtListActivity.this.eMO.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.eMO.setVisibility(8);
                    AtListActivity.this.hGr.setVisibility(0);
                    AtListActivity.this.eMP.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hGr = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.select_friend));
        this.eMP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hGr.setVisibility(8);
                AtListActivity.this.eMP.setVisibility(8);
                AtListActivity.this.eMO.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.eMR = (ImageView) this.eMP.findViewById(e.g.new_friend_search);
        this.eMO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eMO.setVisibility(8);
        this.mEditText = (EditText) this.eMO.findViewById(e.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hGp)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hGw);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hGw, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bsA.setVisibility(0);
                    } else {
                        AtListActivity.this.bsA.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hGp = com.baidu.adp.lib.util.k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.bsA = (TextView) findViewById(e.g.search_bar_delete_button);
        this.bsA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aQM() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds80) + getResources().getDimensionPixelSize(e.C0141e.ds16) + getResources().getDimensionPixelSize(e.C0141e.ds16);
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
                AtListActivity.this.Op.requestFocus();
            }
        });
        this.Op.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC(String str) {
        if (!isFinishing()) {
            this.hGo.setData(null);
            if (this.hGl != null) {
                this.hGl.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hGn.bJs() != null) {
                    ArrayList<MetaData> bJj = this.hGn.bJs().bJj();
                    Iterator<MetaData> it = bJj.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bJj != null && !bJj.isEmpty()) {
                        wd(0);
                    } else {
                        wd(1);
                    }
                    this.hGo.setData(bJj);
                } else {
                    this.hGo.setData(null);
                    if (this.hGm == null) {
                        this.hGm = new b();
                        this.hGm.setPriority(3);
                        this.hGm.execute("");
                    }
                }
            } else {
                this.hGl = new a();
                this.hGl.setPriority(2);
                this.hGl.execute(str);
                if (this.hGm == null && this.hGn.bJs() == null) {
                    this.hGm = new b();
                    this.hGm.setPriority(3);
                    this.hGm.execute("");
                }
            }
            this.hGo.notifyDataSetInvalidated();
            this.Op.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hGn = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hGu = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hGv = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hGu = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hGv = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hGk.f(metaData);
            pm(this.hGk.getItemLength());
            aQN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hGk.h(metaData);
            pm(this.hGk.getItemLength());
            aQN();
        }
    }

    private void aQN() {
        if (this.hGk.getItemLength() > 0) {
            this.eMK.setEnabled(true);
        } else {
            this.eMK.setEnabled(false);
        }
    }

    private void pm(int i) {
        this.eMK.setText(String.format(getPageContext().getString(e.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hGy;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hGy = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hGl = null;
            this.hGy = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hGy = strArr[0];
            this.mNetwork = new x();
            if (this.hGy == null || this.hGy.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.u("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.u("q", this.hGy);
            if (AtListActivity.this.hGv) {
                this.mNetwork.u("from", "1");
            } else {
                this.mNetwork.u("from", "0");
            }
            String zt = this.mNetwork.zt();
            if (!this.mNetwork.zR().AQ().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(zt, AtListActivity.this.hGn.bJs());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hGl = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.zR().AQ().isRequestSuccess() && this.hGy != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hGy)) {
                if (cVar == null || cVar.bJl().isEmpty()) {
                    AtListActivity.this.wd(1);
                } else {
                    AtListActivity.this.wd(0);
                }
                AtListActivity.this.hGn.a(cVar);
                AtListActivity.this.hGo.setData(cVar.bJl());
                AtListActivity.this.hGo.notifyDataSetInvalidated();
                AtListActivity.this.Op.setSelection(0);
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
                this.mNetwork.iT();
            }
            AtListActivity.this.hGm = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hGv) {
                this.mNetwork.u("from", "1");
            } else {
                this.mNetwork.u("from", "0");
            }
            String zt = this.mNetwork.zt();
            if (!this.mNetwork.zR().AQ().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.wr(zt);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hGm = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eMJ != null && AtListActivity.this.eMJ.getVisibility() == 0) {
                AtListActivity.this.hGq.setVisibility(0);
            }
            if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                AtListActivity.this.hGn.a(bVar);
                if (AtListActivity.this.hGo != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hGn.bJt() != null) {
                            if (bVar != null && bVar.bJk() != null && !bVar.bJk().isEmpty()) {
                                AtListActivity.this.wd(2);
                            }
                            AtListActivity.this.hGn.bJt().v(bVar.bJk());
                            AtListActivity.this.hGo.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bJj() == null || !bVar.bJj().isEmpty()) {
                            AtListActivity.this.wd(0);
                        } else {
                            AtListActivity.this.wd(2);
                        }
                        AtListActivity.this.hGj = bVar.bJj();
                        AtListActivity.this.hGo.setData(AtListActivity.this.hGj);
                        AtListActivity.this.hGo.notifyDataSetInvalidated();
                        AtListActivity.this.Op.setSelection(0);
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
            this.hGk.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.Op == null) {
            return null;
        }
        return this.Op.getPreLoadHandle();
    }
}
