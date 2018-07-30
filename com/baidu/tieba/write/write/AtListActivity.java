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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.y;
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
    private NoNetworkView cSy;
    private View eFC;
    private View eFD;
    private ImageView eFF;
    private LinearLayout eFx;
    private Button eFy;
    private AtSelectFriendList hxL;
    private TextView hxS;
    private TextView hxT;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hxK = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bmI = null;
    private BdListView LO = null;
    private final Handler mHandler = new Handler();
    private a hxM = null;
    private b hxN = null;
    private com.baidu.tieba.write.model.b hxO = null;
    private com.baidu.tieba.write.write.a hxP = null;
    private String hxQ = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hxR = null;
    private final int hxU = 5;
    private boolean hxV = true;
    private boolean hxW = false;
    private final Runnable hxX = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.vN(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a gVQ = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                AtListActivity.this.vN(null);
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
        vN(null);
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
        this.cSy.onChangeSkinType(getPageContext(), i);
        this.hxP.notifyDataSetChanged();
        am.getColor(d.C0140d.common_color_10221);
        am.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        am.i(this.eFy, d.f.post_button_bg);
        am.c(this.eFy, d.C0140d.cp_cont_i, 3);
        am.a(this.eFF, d.f.icon_search_bg_s, d.f.icon_search_bg);
        am.h(this.hxT, d.C0140d.navi_back_text_color);
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
    public void vD(int i) {
        if (i == 2) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.no_chat_friends));
            this.eFx.setVisibility(8);
        } else if (i == 1) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.no_search_friends));
            this.eFx.setVisibility(8);
        } else if (i == 0) {
            this.LO.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hxV) {
                this.eFx.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hxP.getItem(i);
        if (item != null) {
            if (this.hxV) {
                if (this.hxM == null && this.hxN == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hxL.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hxP.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.a(getPageContext().getPageActivity(), this.mEditText);
            if (this.hxW) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new an("c12930").f(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.hxM != null) {
            this.hxM.cancel();
        }
        if (this.hxN != null) {
            this.hxN.cancel();
        }
        this.mHandler.removeCallbacks(this.hxX);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds320)), NoDataViewFactory.d.du(d.j.no_chat_friends), null, true);
        this.hxR = findViewById(d.g.at_candidate_border);
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
        asl();
        this.cSy = (NoNetworkView) findViewById(d.g.view_no_network);
        this.cSy.a(this.gVQ);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.LO = (BdListView) findViewById(d.g.list);
        this.hxP = new com.baidu.tieba.write.write.a(this, this.hxV);
        this.hxP.a(this);
        this.hxP.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hxL.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.LO.setAdapter((ListAdapter) this.hxP);
        this.LO.setOnItemClickListener(this);
        this.LO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.eFx = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.eFy = (Button) this.mParent.findViewById(d.g.button_send);
        this.eFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hxL.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        oI(0);
        this.hxL = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hxL.setMaxCount(5);
        this.hxL.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.LO.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aOA();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hxT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eFC != null && AtListActivity.this.eFC.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.eFC.setVisibility(8);
                    AtListActivity.this.hxS.setVisibility(0);
                    AtListActivity.this.eFD.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hxS = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.eFD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hxS.setVisibility(8);
                AtListActivity.this.eFD.setVisibility(8);
                AtListActivity.this.eFC.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.eFF = (ImageView) this.eFD.findViewById(d.g.new_friend_search);
        this.eFC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eFC.setVisibility(8);
        this.mEditText = (EditText) this.eFC.findViewById(d.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hxQ)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hxX);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hxX, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bmI.setVisibility(0);
                    } else {
                        AtListActivity.this.bmI.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hxQ = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bmI = (TextView) findViewById(d.g.search_bar_delete_button);
        this.bmI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aOA() {
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
                AtListActivity.this.LO.requestFocus();
            }
        });
        this.LO.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vN(String str) {
        if (!isFinishing()) {
            this.hxP.setData(null);
            if (this.hxM != null) {
                this.hxM.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hxO.bGy() != null) {
                    ArrayList<MetaData> bGp = this.hxO.bGy().bGp();
                    Iterator<MetaData> it = bGp.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bGp != null && !bGp.isEmpty()) {
                        vD(0);
                    } else {
                        vD(1);
                    }
                    this.hxP.setData(bGp);
                } else {
                    this.hxP.setData(null);
                    if (this.hxN == null) {
                        this.hxN = new b();
                        this.hxN.setPriority(3);
                        this.hxN.execute("");
                    }
                }
            } else {
                this.hxM = new a();
                this.hxM.setPriority(2);
                this.hxM.execute(str);
                if (this.hxN == null && this.hxO.bGy() == null) {
                    this.hxN = new b();
                    this.hxN.setPriority(3);
                    this.hxN.execute("");
                }
            }
            this.hxP.notifyDataSetInvalidated();
            this.LO.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hxO = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hxV = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hxW = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hxV = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hxW = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hxL.f(metaData);
            oI(this.hxL.getItemLength());
            aOB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hxL.h(metaData);
            oI(this.hxL.getItemLength());
            aOB();
        }
    }

    private void aOB() {
        if (this.hxL.getItemLength() > 0) {
            this.eFy.setEnabled(true);
        } else {
            this.eFy.setEnabled(false);
        }
    }

    private void oI(int i) {
        this.eFy.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hxZ;
        private y mNetwork;

        private a() {
            this.mNetwork = null;
            this.hxZ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hxM = null;
            this.hxZ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hxZ = strArr[0];
            this.mNetwork = new y();
            if (this.hxZ == null || this.hxZ.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.o("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.o("q", this.hxZ);
            if (AtListActivity.this.hxW) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yq = this.mNetwork.yq();
            if (!this.mNetwork.yO().zN().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(yq, AtListActivity.this.hxO.bGy());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hxM = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.yO().zN().isRequestSuccess() && this.hxZ != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hxZ)) {
                if (cVar == null || cVar.bGr().isEmpty()) {
                    AtListActivity.this.vD(1);
                } else {
                    AtListActivity.this.vD(0);
                }
                AtListActivity.this.hxO.a(cVar);
                AtListActivity.this.hxP.setData(cVar.bGr());
                AtListActivity.this.hxP.notifyDataSetInvalidated();
                AtListActivity.this.LO.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private y mNetwork;

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
                this.mNetwork.hN();
            }
            AtListActivity.this.hxN = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new y();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hxW) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yq = this.mNetwork.yq();
            if (!this.mNetwork.yO().zN().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.vE(yq);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hxN = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eFx != null && AtListActivity.this.eFx.getVisibility() == 0) {
                AtListActivity.this.hxR.setVisibility(0);
            }
            if (this.mNetwork.yO().zN().isRequestSuccess()) {
                AtListActivity.this.hxO.a(bVar);
                if (AtListActivity.this.hxP != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hxO.bGz() != null) {
                            if (bVar != null && bVar.bGq() != null && !bVar.bGq().isEmpty()) {
                                AtListActivity.this.vD(2);
                            }
                            AtListActivity.this.hxO.bGz().r(bVar.bGq());
                            AtListActivity.this.hxP.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bGp() == null || !bVar.bGp().isEmpty()) {
                            AtListActivity.this.vD(0);
                        } else {
                            AtListActivity.this.vD(2);
                        }
                        AtListActivity.this.hxK = bVar.bGp();
                        AtListActivity.this.hxP.setData(AtListActivity.this.hxK);
                        AtListActivity.this.hxP.notifyDataSetInvalidated();
                        AtListActivity.this.LO.setSelection(0);
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
            this.hxL.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.LO == null) {
            return null;
        }
        return this.LO.getPreLoadHandle();
    }
}
