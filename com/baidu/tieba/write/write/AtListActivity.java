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
import com.baidu.tieba.f;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView cSv;
    private ImageView eFB;
    private LinearLayout eFt;
    private Button eFu;
    private View eFy;
    private View eFz;
    private AtSelectFriendList hxN;
    private TextView hxU;
    private TextView hxV;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hxM = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bmM = null;
    private BdListView LO = null;
    private final Handler mHandler = new Handler();
    private a hxO = null;
    private b hxP = null;
    private com.baidu.tieba.write.model.b hxQ = null;
    private com.baidu.tieba.write.write.a hxR = null;
    private String hxS = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hxT = null;
    private final int hxW = 5;
    private boolean hxX = true;
    private boolean hxY = false;
    private final Runnable hxZ = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.vR(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a gVS = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            if (z) {
                AtListActivity.this.vR(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.at_list_activity);
        initData(bundle);
        initUI();
        vR(null);
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
        this.cSv.onChangeSkinType(getPageContext(), i);
        this.hxR.notifyDataSetChanged();
        am.getColor(f.d.common_color_10221);
        am.i(this.mListFooter, f.C0146f.invite_friend_list_item_bg_color);
        am.i(this.eFu, f.C0146f.post_button_bg);
        am.c(this.eFu, f.d.cp_cont_i, 3);
        am.a(this.eFB, f.C0146f.icon_search_bg_s, f.C0146f.icon_search_bg);
        am.h(this.hxV, f.d.navi_back_text_color);
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
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.no_chat_friends));
            this.eFt.setVisibility(8);
        } else if (i == 1) {
            this.LO.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.no_search_friends));
            this.eFt.setVisibility(8);
        } else if (i == 0) {
            this.LO.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hxX) {
                this.eFt.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hxR.getItem(i);
        if (item != null) {
            if (this.hxX) {
                if (this.hxO == null && this.hxP == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hxN.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(f.j.invite_friend_exceed_max_count), 5), f.C0146f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hxR.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.a(getPageContext().getPageActivity(), this.mEditText);
            if (this.hxY) {
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
        if (this.hxO != null) {
            this.hxO.cancel();
        }
        if (this.hxP != null) {
            this.hxP.cancel();
        }
        this.mHandler.removeCallbacks(this.hxZ);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(f.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), f.e.ds320)), NoDataViewFactory.d.dt(f.j.no_chat_friends), null, true);
        this.hxT = findViewById(f.g.at_candidate_border);
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
        this.cSv = (NoNetworkView) findViewById(f.g.view_no_network);
        this.cSv.a(this.gVS);
        this.mProgress = (ProgressBar) findViewById(f.g.progress);
        this.LO = (BdListView) findViewById(f.g.list);
        this.hxR = new com.baidu.tieba.write.write.a(this, this.hxX);
        this.hxR.a(this);
        this.hxR.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hxN.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(f.j.invite_friend_exceed_max_count), 5), f.C0146f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.LO.setAdapter((ListAdapter) this.hxR);
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
        this.eFt = (LinearLayout) this.mParent.findViewById(f.g.invite_candidate);
        this.eFu = (Button) this.mParent.findViewById(f.g.button_send);
        this.eFu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hxN.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        oI(0);
        this.hxN = (AtSelectFriendList) this.mParent.findViewById(f.g.candidate_list);
        this.hxN.setMaxCount(5);
        this.hxN.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
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
        aOx();
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.hxV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(f.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eFy != null && AtListActivity.this.eFy.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.eFy.setVisibility(8);
                    AtListActivity.this.hxU.setVisibility(0);
                    AtListActivity.this.eFz.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hxU = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(f.j.select_friend));
        this.eFz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hxU.setVisibility(8);
                AtListActivity.this.eFz.setVisibility(8);
                AtListActivity.this.eFy.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.eFB = (ImageView) this.eFz.findViewById(f.g.new_friend_search);
        this.eFy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eFy.setVisibility(8);
        this.mEditText = (EditText) this.eFy.findViewById(f.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hxS)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hxZ);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hxZ, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bmM.setVisibility(0);
                    } else {
                        AtListActivity.this.bmM.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hxS = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bmM = (TextView) findViewById(f.g.search_bar_delete_button);
        this.bmM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aOx() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds80) + getResources().getDimensionPixelSize(f.e.ds16) + getResources().getDimensionPixelSize(f.e.ds16);
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
    public void vR(String str) {
        if (!isFinishing()) {
            this.hxR.setData(null);
            if (this.hxO != null) {
                this.hxO.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hxQ.bGC() != null) {
                    ArrayList<MetaData> bGt = this.hxQ.bGC().bGt();
                    Iterator<MetaData> it = bGt.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bGt != null && !bGt.isEmpty()) {
                        vD(0);
                    } else {
                        vD(1);
                    }
                    this.hxR.setData(bGt);
                } else {
                    this.hxR.setData(null);
                    if (this.hxP == null) {
                        this.hxP = new b();
                        this.hxP.setPriority(3);
                        this.hxP.execute("");
                    }
                }
            } else {
                this.hxO = new a();
                this.hxO.setPriority(2);
                this.hxO.execute(str);
                if (this.hxP == null && this.hxQ.bGC() == null) {
                    this.hxP = new b();
                    this.hxP.setPriority(3);
                    this.hxP.execute("");
                }
            }
            this.hxR.notifyDataSetInvalidated();
            this.LO.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hxQ = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hxX = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hxY = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hxX = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hxY = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hxN.f(metaData);
            oI(this.hxN.getItemLength());
            aOy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hxN.h(metaData);
            oI(this.hxN.getItemLength());
            aOy();
        }
    }

    private void aOy() {
        if (this.hxN.getItemLength() > 0) {
            this.eFu.setEnabled(true);
        } else {
            this.eFu.setEnabled(false);
        }
    }

    private void oI(int i) {
        this.eFu.setText(String.format(getPageContext().getString(f.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hyb;
        private y mNetwork;

        private a() {
            this.mNetwork = null;
            this.hyb = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hxO = null;
            this.hyb = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hyb = strArr[0];
            this.mNetwork = new y();
            if (this.hyb == null || this.hyb.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.o("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.o("q", this.hyb);
            if (AtListActivity.this.hxY) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yo = this.mNetwork.yo();
            if (!this.mNetwork.yM().zL().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(yo, AtListActivity.this.hxQ.bGC());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hxO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.yM().zL().isRequestSuccess() && this.hyb != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hyb)) {
                if (cVar == null || cVar.bGv().isEmpty()) {
                    AtListActivity.this.vD(1);
                } else {
                    AtListActivity.this.vD(0);
                }
                AtListActivity.this.hxQ.a(cVar);
                AtListActivity.this.hxR.setData(cVar.bGv());
                AtListActivity.this.hxR.notifyDataSetInvalidated();
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
            AtListActivity.this.hxP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new y();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hxY) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String yo = this.mNetwork.yo();
            if (!this.mNetwork.yM().zL().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.vI(yo);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hxP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eFt != null && AtListActivity.this.eFt.getVisibility() == 0) {
                AtListActivity.this.hxT.setVisibility(0);
            }
            if (this.mNetwork.yM().zL().isRequestSuccess()) {
                AtListActivity.this.hxQ.a(bVar);
                if (AtListActivity.this.hxR != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hxQ.bGD() != null) {
                            if (bVar != null && bVar.bGu() != null && !bVar.bGu().isEmpty()) {
                                AtListActivity.this.vD(2);
                            }
                            AtListActivity.this.hxQ.bGD().r(bVar.bGu());
                            AtListActivity.this.hxR.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bGt() == null || !bVar.bGt().isEmpty()) {
                            AtListActivity.this.vD(0);
                        } else {
                            AtListActivity.this.vD(2);
                        }
                        AtListActivity.this.hxM = bVar.bGt();
                        AtListActivity.this.hxR.setData(AtListActivity.this.hxM);
                        AtListActivity.this.hxR.notifyDataSetInvalidated();
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
            this.hxN.g(metaData);
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
