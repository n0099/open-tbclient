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
    private NoNetworkView drO;
    private LinearLayout fgd;
    private Button fge;
    private View fgi;
    private View fgj;
    private ImageView fgl;
    private AtSelectFriendList iaJ;
    private TextView iaQ;
    private TextView iaR;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> iaI = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bBF = null;
    private BdListView OQ = null;
    private final Handler mHandler = new Handler();
    private a iaK = null;
    private b iaL = null;
    private com.baidu.tieba.write.model.b iaM = null;
    private com.baidu.tieba.write.write.a iaN = null;
    private String iaO = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View iaP = null;
    private final int iaS = 5;
    private boolean iaT = true;
    private boolean iaU = false;
    private final Runnable iaV = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.ye(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a hyq = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                AtListActivity.this.ye(null);
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
        ye(null);
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
        this.drO.onChangeSkinType(getPageContext(), i);
        this.iaN.notifyDataSetChanged();
        al.getColor(e.d.common_color_10221);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        al.i(this.fge, e.f.post_button_bg);
        al.c(this.fge, e.d.cp_cont_i, 3);
        al.a(this.fgl, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.h(this.iaR, e.d.navi_back_text_color);
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
    public void xF(int i) {
        if (i == 2) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_chat_friends));
            this.fgd.setVisibility(8);
        } else if (i == 1) {
            this.OQ.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_search_friends));
            this.fgd.setVisibility(8);
        } else if (i == 0) {
            this.OQ.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.iaT) {
                this.fgd.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.iaN.getItem(i);
        if (item != null) {
            if (this.iaT) {
                if (this.iaK == null && this.iaL == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.iaJ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.iaN.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.iaU) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new am("c12930").i(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.iaK != null) {
            this.iaK.cancel();
        }
        if (this.iaL != null) {
            this.iaL.cancel();
        }
        this.mHandler.removeCallbacks(this.iaV);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_chat_friends), null, true);
        this.iaP = findViewById(e.g.at_candidate_border);
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
        azR();
        this.drO = (NoNetworkView) findViewById(e.g.view_no_network);
        this.drO.a(this.hyq);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.OQ = (BdListView) findViewById(e.g.list);
        this.iaN = new com.baidu.tieba.write.write.a(this, this.iaT);
        this.iaN.a(this);
        this.iaN.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.iaJ.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.OQ.setAdapter((ListAdapter) this.iaN);
        this.OQ.setOnItemClickListener(this);
        this.OQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.fgd = (LinearLayout) this.mParent.findViewById(e.g.invite_candidate);
        this.fge = (Button) this.mParent.findViewById(e.g.button_send);
        this.fge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.iaJ.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qL(0);
        this.iaJ = (AtSelectFriendList) this.mParent.findViewById(e.g.candidate_list);
        this.iaJ.setMaxCount(5);
        this.iaJ.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.OQ.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aWC();
    }

    private void azR() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.iaR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.fgi != null && AtListActivity.this.fgi.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.fgi.setVisibility(8);
                    AtListActivity.this.iaQ.setVisibility(0);
                    AtListActivity.this.fgj.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.iaQ = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.select_friend));
        this.fgj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.iaQ.setVisibility(8);
                AtListActivity.this.fgj.setVisibility(8);
                AtListActivity.this.fgi.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.fgl = (ImageView) this.fgj.findViewById(e.g.new_friend_search);
        this.fgi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.fgi.setVisibility(8);
        this.mEditText = (EditText) this.fgi.findViewById(e.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.iaO)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.iaV);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.iaV, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bBF.setVisibility(0);
                    } else {
                        AtListActivity.this.bBF.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.iaO = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bBF = (TextView) findViewById(e.g.search_bar_delete_button);
        this.bBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aWC() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds80) + getResources().getDimensionPixelSize(e.C0210e.ds16) + getResources().getDimensionPixelSize(e.C0210e.ds16);
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
                AtListActivity.this.OQ.requestFocus();
            }
        });
        this.OQ.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ye(String str) {
        if (!isFinishing()) {
            this.iaN.setData(null);
            if (this.iaK != null) {
                this.iaK.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.iaM.bPH() != null) {
                    ArrayList<MetaData> bPy = this.iaM.bPH().bPy();
                    Iterator<MetaData> it = bPy.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bPy != null && !bPy.isEmpty()) {
                        xF(0);
                    } else {
                        xF(1);
                    }
                    this.iaN.setData(bPy);
                } else {
                    this.iaN.setData(null);
                    if (this.iaL == null) {
                        this.iaL = new b();
                        this.iaL.setPriority(3);
                        this.iaL.execute("");
                    }
                }
            } else {
                this.iaK = new a();
                this.iaK.setPriority(2);
                this.iaK.execute(str);
                if (this.iaL == null && this.iaM.bPH() == null) {
                    this.iaL = new b();
                    this.iaL.setPriority(3);
                    this.iaL.execute("");
                }
            }
            this.iaN.notifyDataSetInvalidated();
            this.OQ.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.iaM = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.iaT = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.iaU = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.iaT = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.iaU = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.iaJ.f(metaData);
            qL(this.iaJ.getItemLength());
            aWD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.iaJ.h(metaData);
            qL(this.iaJ.getItemLength());
            aWD();
        }
    }

    private void aWD() {
        if (this.iaJ.getItemLength() > 0) {
            this.fge.setEnabled(true);
        } else {
            this.fge.setEnabled(false);
        }
    }

    private void qL(int i) {
        this.fge.setText(String.format(getPageContext().getString(e.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String iaX;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.iaX = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.iaK = null;
            this.iaX = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.iaX = strArr[0];
            this.mNetwork = new x();
            if (this.iaX == null || this.iaX.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.x("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.x("q", this.iaX);
            if (AtListActivity.this.iaU) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String CY = this.mNetwork.CY();
            if (!this.mNetwork.Dw().Ev().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(CY, AtListActivity.this.iaM.bPH());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.iaK = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Dw().Ev().isRequestSuccess() && this.iaX != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.iaX)) {
                if (cVar == null || cVar.bPA().isEmpty()) {
                    AtListActivity.this.xF(1);
                } else {
                    AtListActivity.this.xF(0);
                }
                AtListActivity.this.iaM.a(cVar);
                AtListActivity.this.iaN.setData(cVar.bPA());
                AtListActivity.this.iaN.notifyDataSetInvalidated();
                AtListActivity.this.OQ.setSelection(0);
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
                this.mNetwork.jg();
            }
            AtListActivity.this.iaL = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.iaU) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String CY = this.mNetwork.CY();
            if (!this.mNetwork.Dw().Ev().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.xT(CY);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.iaL = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.fgd != null && AtListActivity.this.fgd.getVisibility() == 0) {
                AtListActivity.this.iaP.setVisibility(0);
            }
            if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
                AtListActivity.this.iaM.a(bVar);
                if (AtListActivity.this.iaN != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.iaM.bPI() != null) {
                            if (bVar != null && bVar.bPz() != null && !bVar.bPz().isEmpty()) {
                                AtListActivity.this.xF(2);
                            }
                            AtListActivity.this.iaM.bPI().u(bVar.bPz());
                            AtListActivity.this.iaN.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bPy() == null || !bVar.bPy().isEmpty()) {
                            AtListActivity.this.xF(0);
                        } else {
                            AtListActivity.this.xF(2);
                        }
                        AtListActivity.this.iaI = bVar.bPy();
                        AtListActivity.this.iaN.setData(AtListActivity.this.iaI);
                        AtListActivity.this.iaN.notifyDataSetInvalidated();
                        AtListActivity.this.OQ.setSelection(0);
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
            this.iaJ.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.OQ == null) {
            return null;
        }
        return this.OQ.getPreLoadHandle();
    }
}
