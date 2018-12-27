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
    private NoNetworkView drf;
    private LinearLayout ffq;
    private Button ffr;
    private View ffv;
    private View ffw;
    private ImageView ffy;
    private AtSelectFriendList hZC;
    private TextView hZJ;
    private TextView hZK;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hZB = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bAS = null;
    private BdListView OF = null;
    private final Handler mHandler = new Handler();
    private a hZD = null;
    private b hZE = null;
    private com.baidu.tieba.write.model.b hZF = null;
    private com.baidu.tieba.write.write.a hZG = null;
    private String hZH = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hZI = null;
    private final int hZL = 5;
    private boolean hZM = true;
    private boolean hZN = false;
    private final Runnable hZO = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.xO(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a hxj = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                AtListActivity.this.xO(null);
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
        xO(null);
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
        this.drf.onChangeSkinType(getPageContext(), i);
        this.hZG.notifyDataSetChanged();
        al.getColor(e.d.common_color_10221);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        al.i(this.ffr, e.f.post_button_bg);
        al.c(this.ffr, e.d.cp_cont_i, 3);
        al.a(this.ffy, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.h(this.hZK, e.d.navi_back_text_color);
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
    public void xD(int i) {
        if (i == 2) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_chat_friends));
            this.ffq.setVisibility(8);
        } else if (i == 1) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_search_friends));
            this.ffq.setVisibility(8);
        } else if (i == 0) {
            this.OF.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hZM) {
                this.ffq.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hZG.getItem(i);
        if (item != null) {
            if (this.hZM) {
                if (this.hZD == null && this.hZE == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hZC.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hZG.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.hZN) {
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
        if (this.hZD != null) {
            this.hZD.cancel();
        }
        if (this.hZE != null) {
            this.hZE.cancel();
        }
        this.mHandler.removeCallbacks(this.hZO);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_chat_friends), null, true);
        this.hZI = findViewById(e.g.at_candidate_border);
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
        azu();
        this.drf = (NoNetworkView) findViewById(e.g.view_no_network);
        this.drf.a(this.hxj);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.OF = (BdListView) findViewById(e.g.list);
        this.hZG = new com.baidu.tieba.write.write.a(this, this.hZM);
        this.hZG.a(this);
        this.hZG.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hZC.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.OF.setAdapter((ListAdapter) this.hZG);
        this.OF.setOnItemClickListener(this);
        this.OF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.ffq = (LinearLayout) this.mParent.findViewById(e.g.invite_candidate);
        this.ffr = (Button) this.mParent.findViewById(e.g.button_send);
        this.ffr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hZC.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qK(0);
        this.hZC = (AtSelectFriendList) this.mParent.findViewById(e.g.candidate_list);
        this.hZC.setMaxCount(5);
        this.hZC.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.OF.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aWc();
    }

    private void azu() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.hZK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.ffv != null && AtListActivity.this.ffv.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.ffv.setVisibility(8);
                    AtListActivity.this.hZJ.setVisibility(0);
                    AtListActivity.this.ffw.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hZJ = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.select_friend));
        this.ffw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hZJ.setVisibility(8);
                AtListActivity.this.ffw.setVisibility(8);
                AtListActivity.this.ffv.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.ffy = (ImageView) this.ffw.findViewById(e.g.new_friend_search);
        this.ffv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.ffv.setVisibility(8);
        this.mEditText = (EditText) this.ffv.findViewById(e.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hZH)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hZO);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hZO, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bAS.setVisibility(0);
                    } else {
                        AtListActivity.this.bAS.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hZH = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bAS = (TextView) findViewById(e.g.search_bar_delete_button);
        this.bAS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aWc() {
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
                AtListActivity.this.OF.requestFocus();
            }
        });
        this.OF.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(String str) {
        if (!isFinishing()) {
            this.hZG.setData(null);
            if (this.hZD != null) {
                this.hZD.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hZF.bOZ() != null) {
                    ArrayList<MetaData> bOQ = this.hZF.bOZ().bOQ();
                    Iterator<MetaData> it = bOQ.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bOQ != null && !bOQ.isEmpty()) {
                        xD(0);
                    } else {
                        xD(1);
                    }
                    this.hZG.setData(bOQ);
                } else {
                    this.hZG.setData(null);
                    if (this.hZE == null) {
                        this.hZE = new b();
                        this.hZE.setPriority(3);
                        this.hZE.execute("");
                    }
                }
            } else {
                this.hZD = new a();
                this.hZD.setPriority(2);
                this.hZD.execute(str);
                if (this.hZE == null && this.hZF.bOZ() == null) {
                    this.hZE = new b();
                    this.hZE.setPriority(3);
                    this.hZE.execute("");
                }
            }
            this.hZG.notifyDataSetInvalidated();
            this.OF.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hZF = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hZM = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hZN = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hZM = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hZN = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hZC.f(metaData);
            qK(this.hZC.getItemLength());
            aWd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hZC.h(metaData);
            qK(this.hZC.getItemLength());
            aWd();
        }
    }

    private void aWd() {
        if (this.hZC.getItemLength() > 0) {
            this.ffr.setEnabled(true);
        } else {
            this.ffr.setEnabled(false);
        }
    }

    private void qK(int i) {
        this.ffr.setText(String.format(getPageContext().getString(e.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hZQ;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hZQ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hZD = null;
            this.hZQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hZQ = strArr[0];
            this.mNetwork = new x();
            if (this.hZQ == null || this.hZQ.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.x("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.x("q", this.hZQ);
            if (AtListActivity.this.hZN) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String CL = this.mNetwork.CL();
            if (!this.mNetwork.Dj().Ei().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(CL, AtListActivity.this.hZF.bOZ());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hZD = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Dj().Ei().isRequestSuccess() && this.hZQ != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hZQ)) {
                if (cVar == null || cVar.bOS().isEmpty()) {
                    AtListActivity.this.xD(1);
                } else {
                    AtListActivity.this.xD(0);
                }
                AtListActivity.this.hZF.a(cVar);
                AtListActivity.this.hZG.setData(cVar.bOS());
                AtListActivity.this.hZG.notifyDataSetInvalidated();
                AtListActivity.this.OF.setSelection(0);
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
            AtListActivity.this.hZE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hZN) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String CL = this.mNetwork.CL();
            if (!this.mNetwork.Dj().Ei().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.xD(CL);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hZE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.ffq != null && AtListActivity.this.ffq.getVisibility() == 0) {
                AtListActivity.this.hZI.setVisibility(0);
            }
            if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                AtListActivity.this.hZF.a(bVar);
                if (AtListActivity.this.hZG != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hZF.bPa() != null) {
                            if (bVar != null && bVar.bOR() != null && !bVar.bOR().isEmpty()) {
                                AtListActivity.this.xD(2);
                            }
                            AtListActivity.this.hZF.bPa().u(bVar.bOR());
                            AtListActivity.this.hZG.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bOQ() == null || !bVar.bOQ().isEmpty()) {
                            AtListActivity.this.xD(0);
                        } else {
                            AtListActivity.this.xD(2);
                        }
                        AtListActivity.this.hZB = bVar.bOQ();
                        AtListActivity.this.hZG.setData(AtListActivity.this.hZB);
                        AtListActivity.this.hZG.notifyDataSetInvalidated();
                        AtListActivity.this.OF.setSelection(0);
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
            this.hZC.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (this.OF == null) {
            return null;
        }
        return this.OF.getPreLoadHandle();
    }
}
