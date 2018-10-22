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
    private NoNetworkView dgC;
    private ImageView eUA;
    private LinearLayout eUs;
    private Button eUt;
    private View eUx;
    private View eUy;
    private TextView hNE;
    private TextView hNF;
    private AtSelectFriendList hNx;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hNw = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bwH = null;
    private BdListView OE = null;
    private final Handler mHandler = new Handler();
    private a hNy = null;
    private b hNz = null;
    private com.baidu.tieba.write.model.b hNA = null;
    private com.baidu.tieba.write.write.a hNB = null;
    private String hNC = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hND = null;
    private final int hNG = 5;
    private boolean hNH = true;
    private boolean hNI = false;
    private final Runnable hNJ = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.xd(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a hlb = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (z) {
                AtListActivity.this.xd(null);
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
        xd(null);
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
        this.dgC.onChangeSkinType(getPageContext(), i);
        this.hNB.notifyDataSetChanged();
        al.getColor(e.d.common_color_10221);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        al.i(this.eUt, e.f.post_button_bg);
        al.c(this.eUt, e.d.cp_cont_i, 3);
        al.a(this.eUA, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.h(this.hNF, e.d.navi_back_text_color);
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
    public void wA(int i) {
        if (i == 2) {
            this.OE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.no_chat_friends));
            this.eUs.setVisibility(8);
        } else if (i == 1) {
            this.OE.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.no_search_friends));
            this.eUs.setVisibility(8);
        } else if (i == 0) {
            this.OE.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hNH) {
                this.eUs.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hNB.getItem(i);
        if (item != null) {
            if (this.hNH) {
                if (this.hNy == null && this.hNz == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hNx.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hNB.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.a(getPageContext().getPageActivity(), this.mEditText);
            if (this.hNI) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new am("c12930").h(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.hNy != null) {
            this.hNy.cancel();
        }
        if (this.hNz != null) {
            this.hNz.cancel();
        }
        this.mHandler.removeCallbacks(this.hNJ);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.no_chat_friends), null, true);
        this.hND = findViewById(e.g.at_candidate_border);
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
        axw();
        this.dgC = (NoNetworkView) findViewById(e.g.view_no_network);
        this.dgC.a(this.hlb);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.OE = (BdListView) findViewById(e.g.list);
        this.hNB = new com.baidu.tieba.write.write.a(this, this.hNH);
        this.hNB.a(this);
        this.hNB.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hNx.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.OE.setAdapter((ListAdapter) this.hNB);
        this.OE.setOnItemClickListener(this);
        this.OE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.eUs = (LinearLayout) this.mParent.findViewById(e.g.invite_candidate);
        this.eUt = (Button) this.mParent.findViewById(e.g.button_send);
        this.eUt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hNx.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        pK(0);
        this.hNx = (AtSelectFriendList) this.mParent.findViewById(e.g.candidate_list);
        this.hNx.setMaxCount(5);
        this.hNx.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.OE.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aUa();
    }

    private void axw() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.hNF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eUx != null && AtListActivity.this.eUx.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.eUx.setVisibility(8);
                    AtListActivity.this.hNE.setVisibility(0);
                    AtListActivity.this.eUy.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hNE = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.select_friend));
        this.eUy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hNE.setVisibility(8);
                AtListActivity.this.eUy.setVisibility(8);
                AtListActivity.this.eUx.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.eUA = (ImageView) this.eUy.findViewById(e.g.new_friend_search);
        this.eUx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eUx.setVisibility(8);
        this.mEditText = (EditText) this.eUx.findViewById(e.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hNC)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hNJ);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hNJ, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bwH.setVisibility(0);
                    } else {
                        AtListActivity.this.bwH.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hNC = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bwH = (TextView) findViewById(e.g.search_bar_delete_button);
        this.bwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aUa() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds80) + getResources().getDimensionPixelSize(e.C0175e.ds16) + getResources().getDimensionPixelSize(e.C0175e.ds16);
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
                AtListActivity.this.OE.requestFocus();
            }
        });
        this.OE.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(String str) {
        if (!isFinishing()) {
            this.hNB.setData(null);
            if (this.hNy != null) {
                this.hNy.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hNA.bME() != null) {
                    ArrayList<MetaData> bMv = this.hNA.bME().bMv();
                    Iterator<MetaData> it = bMv.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bMv != null && !bMv.isEmpty()) {
                        wA(0);
                    } else {
                        wA(1);
                    }
                    this.hNB.setData(bMv);
                } else {
                    this.hNB.setData(null);
                    if (this.hNz == null) {
                        this.hNz = new b();
                        this.hNz.setPriority(3);
                        this.hNz.execute("");
                    }
                }
            } else {
                this.hNy = new a();
                this.hNy.setPriority(2);
                this.hNy.execute(str);
                if (this.hNz == null && this.hNA.bME() == null) {
                    this.hNz = new b();
                    this.hNz.setPriority(3);
                    this.hNz.execute("");
                }
            }
            this.hNB.notifyDataSetInvalidated();
            this.OE.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hNA = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hNH = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hNI = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hNH = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hNI = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hNx.f(metaData);
            pK(this.hNx.getItemLength());
            aUb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hNx.h(metaData);
            pK(this.hNx.getItemLength());
            aUb();
        }
    }

    private void aUb() {
        if (this.hNx.getItemLength() > 0) {
            this.eUt.setEnabled(true);
        } else {
            this.eUt.setEnabled(false);
        }
    }

    private void pK(int i) {
        this.eUt.setText(String.format(getPageContext().getString(e.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hNL;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hNL = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hNy = null;
            this.hNL = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hNL = strArr[0];
            this.mNetwork = new x();
            if (this.hNL == null || this.hNL.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.x("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.x("q", this.hNL);
            if (AtListActivity.this.hNI) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String BA = this.mNetwork.BA();
            if (!this.mNetwork.BY().CX().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(BA, AtListActivity.this.hNA.bME());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hNy = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.BY().CX().isRequestSuccess() && this.hNL != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hNL)) {
                if (cVar == null || cVar.bMx().isEmpty()) {
                    AtListActivity.this.wA(1);
                } else {
                    AtListActivity.this.wA(0);
                }
                AtListActivity.this.hNA.a(cVar);
                AtListActivity.this.hNB.setData(cVar.bMx());
                AtListActivity.this.hNB.notifyDataSetInvalidated();
                AtListActivity.this.OE.setSelection(0);
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
            AtListActivity.this.hNz = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hNI) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String BA = this.mNetwork.BA();
            if (!this.mNetwork.BY().CX().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.wS(BA);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hNz = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eUs != null && AtListActivity.this.eUs.getVisibility() == 0) {
                AtListActivity.this.hND.setVisibility(0);
            }
            if (this.mNetwork.BY().CX().isRequestSuccess()) {
                AtListActivity.this.hNA.a(bVar);
                if (AtListActivity.this.hNB != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hNA.bMF() != null) {
                            if (bVar != null && bVar.bMw() != null && !bVar.bMw().isEmpty()) {
                                AtListActivity.this.wA(2);
                            }
                            AtListActivity.this.hNA.bMF().v(bVar.bMw());
                            AtListActivity.this.hNB.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bMv() == null || !bVar.bMv().isEmpty()) {
                            AtListActivity.this.wA(0);
                        } else {
                            AtListActivity.this.wA(2);
                        }
                        AtListActivity.this.hNw = bVar.bMv();
                        AtListActivity.this.hNB.setData(AtListActivity.this.hNw);
                        AtListActivity.this.hNB.notifyDataSetInvalidated();
                        AtListActivity.this.OE.setSelection(0);
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
            this.hNx.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.OE == null) {
            return null;
        }
        return this.OE.getPreLoadHandle();
    }
}
