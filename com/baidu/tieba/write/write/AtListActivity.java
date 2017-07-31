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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.g;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView bES;
    private LinearLayout dCE;
    private Button dCF;
    private View dCJ;
    private View dCK;
    private ImageView dCM;
    private AtSelectFriendList gEU;
    private TextView gFb;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    protected ArrayList<MetaData> gET = new ArrayList<>();
    private EditText dza = null;
    private TextView ceH = null;
    private BdListView JC = null;
    private final Handler mHandler = new Handler();
    private a gEV = null;
    private b gEW = null;
    private com.baidu.tieba.write.model.b gEX = null;
    private com.baidu.tieba.write.write.a gEY = null;
    private String gEZ = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gFa = null;
    private final int gFc = 5;
    private boolean gFd = true;
    private final Runnable gFe = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.tg(com.baidu.adp.lib.util.j.a(AtListActivity.this.dza.getText(), ""));
        }
    };
    private NoNetworkView.a goH = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                AtListActivity.this.tg(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.at_list_activity);
        initData(bundle);
        initUI();
        tg(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bES.onChangeSkinType(getPageContext(), i);
        this.gEY.notifyDataSetChanged();
        ai.getColor(d.e.common_color_10221);
        ai.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        ai.j(this.dCF, d.g.post_button_bg);
        ai.c(this.dCF, d.e.cp_cont_i, 3);
        ai.b(this.dCM, d.g.icon_search_bg_s, d.g.icon_search_bg);
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
    public void uz(int i) {
        if (i == 2) {
            this.JC.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dk(d.l.no_chat_friends));
            this.dCE.setVisibility(8);
        } else if (i == 1) {
            this.JC.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dk(d.l.no_search_friends));
            this.dCE.setVisibility(8);
        } else if (i == 0) {
            this.JC.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gFd) {
                this.dCE.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gEY.getItem(i);
        if (item != null) {
            if (this.gFd) {
                if (this.gEV == null && this.gEW == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.gEU.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gEY.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(IntentConfig.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            k.b(getPageContext().getPageActivity(), this.dza);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gEV != null) {
            this.gEV.cancel();
        }
        if (this.gEW != null) {
            this.gEW.cancel();
        }
        this.mHandler.removeCallbacks(this.gFe);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(getActivity(), d.f.ds320)), NoDataViewFactory.d.dk(d.l.no_chat_friends), null, true);
        this.gFa = findViewById(d.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dza);
                    return false;
                }
                return false;
            }
        });
        VW();
        this.bES = (NoNetworkView) findViewById(d.h.view_no_network);
        this.bES.a(this.goH);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.JC = (BdListView) findViewById(d.h.list);
        this.gEY = new com.baidu.tieba.write.write.a(this, this.gFd);
        this.gEY.a(this);
        this.gEY.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.gEU.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.l.invite_friend_exceed_max_count), 5), d.g.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.JC.setAdapter((ListAdapter) this.gEY);
        this.JC.setOnItemClickListener(this);
        this.JC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dza);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dza.getParent() != null) {
            ((View) this.dza.getParent()).setFocusable(true);
            ((View) this.dza.getParent()).setFocusableInTouchMode(true);
        }
        this.dCE = (LinearLayout) this.mParent.findViewById(d.h.invite_candidate);
        this.dCF = (Button) this.mParent.findViewById(d.h.button_send);
        this.dCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.gEU.getDataList());
                intent.putExtras(bundle);
                k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dza);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        mK(0);
        this.gEU = (AtSelectFriendList) this.mParent.findViewById(d.h.candidate_list);
        this.gEU.setMaxCount(5);
        this.gEU.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.JC.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        azd();
    }

    private void VW() {
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.dCJ != null && AtListActivity.this.dCJ.getVisibility() == 0) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dza);
                    AtListActivity.this.dCJ.setVisibility(8);
                    AtListActivity.this.gFb.setVisibility(0);
                    AtListActivity.this.dCK.setVisibility(0);
                    AtListActivity.this.dza.getText().clear();
                    return;
                }
                k.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.dza);
                AtListActivity.this.finish();
            }
        });
        this.gFb = this.mNavigationBar.setTitleText(getPageContext().getString(d.l.select_friend));
        this.dCK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.gFb.setVisibility(8);
                AtListActivity.this.dCK.setVisibility(8);
                AtListActivity.this.dCJ.setVisibility(0);
                AtListActivity.this.dza.requestFocus();
            }
        });
        this.dCM = (ImageView) this.dCK.findViewById(d.h.new_friend_search);
        this.dCJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dCJ.setVisibility(8);
        this.dza = (EditText) this.dCJ.findViewById(d.h.search_bar_edit);
        this.dza.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.j.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.gEZ)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.gFe);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.gFe, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.ceH.setVisibility(0);
                    } else {
                        AtListActivity.this.ceH.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.gEZ = com.baidu.adp.lib.util.j.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.dza.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    k.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    k.c(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.ceH = (TextView) findViewById(d.h.search_bar_delete_button);
        this.ceH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.dza.getText().clear();
            }
        });
    }

    private void azd() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds80) + getResources().getDimensionPixelSize(d.f.ds16) + getResources().getDimensionPixelSize(d.f.ds16);
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
                AtListActivity.this.JC.requestFocus();
            }
        });
        this.JC.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg(String str) {
        if (!isFinishing()) {
            this.gEY.setData(null);
            if (this.gEV != null) {
                this.gEV.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gEX.byE() != null) {
                    ArrayList<MetaData> byy = this.gEX.byE().byy();
                    Iterator<MetaData> it = byy.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (byy != null && !byy.isEmpty()) {
                        uz(0);
                    } else {
                        uz(1);
                    }
                    this.gEY.setData(byy);
                } else {
                    this.gEY.setData(null);
                    if (this.gEW == null) {
                        this.gEW = new b();
                        this.gEW.setPriority(3);
                        this.gEW.execute("");
                    }
                }
            } else {
                this.gEV = new a();
                this.gEV.setPriority(2);
                this.gEV.execute(str);
                if (this.gEW == null && this.gEX.byE() == null) {
                    this.gEW = new b();
                    this.gEW.setPriority(3);
                    this.gEW.execute("");
                }
            }
            this.gEY.notifyDataSetInvalidated();
            this.JC.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gEX = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.gFd = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gFd = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.gEU.f(metaData);
            mK(this.gEU.getItemLength());
            aze();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.gEU.h(metaData);
            mK(this.gEU.getItemLength());
            aze();
        }
    }

    private void aze() {
        if (this.gEU.getItemLength() > 0) {
            this.dCF.setEnabled(true);
        } else {
            this.dCF.setEnabled(false);
        }
    }

    private void mK(int i) {
        this.dCF.setText(String.format(getPageContext().getString(d.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gFg;
        private w mNetwork;

        private a() {
            this.mNetwork = null;
            this.gFg = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gEV = null;
            this.gFg = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gFg = strArr[0];
            this.mNetwork = new w();
            if (this.gFg != null && this.gFg.length() > 0) {
                this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gFg);
                String uO = this.mNetwork.uO();
                if (this.mNetwork.vl().wi().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b byE = AtListActivity.this.gEX.byE();
                    if (byE != null) {
                        dVar.e(uO, byE.byz());
                        return dVar;
                    }
                    dVar.e(uO, null);
                    return dVar;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.d dVar) {
            AtListActivity.this.gEV = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vl().wi().isRequestSuccess() && this.gFg != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dza.getText(), "").equals(this.gFg)) {
                if (dVar == null || dVar.byA().isEmpty()) {
                    AtListActivity.this.uz(1);
                } else {
                    AtListActivity.this.uz(0);
                }
                AtListActivity.this.gEX.a(dVar);
                AtListActivity.this.gEY.setData(dVar.byA());
                AtListActivity.this.gEY.notifyDataSetInvalidated();
                AtListActivity.this.JC.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private w mNetwork;

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
                this.mNetwork.fA();
            }
            AtListActivity.this.gEW = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new w();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            String uO = this.mNetwork.uO();
            if (!this.mNetwork.vl().wi().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.sV(uO);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gEW = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dCE != null && AtListActivity.this.dCE.getVisibility() == 0) {
                AtListActivity.this.gFa.setVisibility(0);
            }
            if (this.mNetwork.vl().wi().isRequestSuccess()) {
                AtListActivity.this.gEX.a(bVar);
                if (AtListActivity.this.gEY != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dza.getText(), "").length() != 0) {
                        if (AtListActivity.this.gEX.byF() != null) {
                            if (bVar != null && bVar.byz() != null && !bVar.byz().isEmpty()) {
                                AtListActivity.this.uz(2);
                            }
                            AtListActivity.this.gEX.byF().k(bVar.byz());
                            AtListActivity.this.gEY.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.byy() == null || !bVar.byy().isEmpty()) {
                            AtListActivity.this.uz(0);
                        } else {
                            AtListActivity.this.uz(2);
                        }
                        AtListActivity.this.gET = bVar.byy();
                        AtListActivity.this.gEY.setData(AtListActivity.this.gET);
                        AtListActivity.this.gEY.notifyDataSetInvalidated();
                        AtListActivity.this.JC.setSelection(0);
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
            this.gEU.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public g onGetPreLoadListView() {
        return this.JC;
    }
}
