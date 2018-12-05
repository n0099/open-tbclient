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
    private NoNetworkView dop;
    private Button fcA;
    private View fcE;
    private View fcF;
    private ImageView fcH;
    private LinearLayout fcz;
    private AtSelectFriendList hWr;
    private TextView hWy;
    private TextView hWz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> hWq = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bAP = null;
    private BdListView OF = null;
    private final Handler mHandler = new Handler();
    private a hWs = null;
    private b hWt = null;
    private com.baidu.tieba.write.model.b hWu = null;
    private com.baidu.tieba.write.write.a hWv = null;
    private String hWw = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hWx = null;
    private final int hWA = 5;
    private boolean hWB = true;
    private boolean hWC = false;
    private final Runnable hWD = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.xL(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a htX = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                AtListActivity.this.xL(null);
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
        xL(null);
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
        this.dop.onChangeSkinType(getPageContext(), i);
        this.hWv.notifyDataSetChanged();
        al.getColor(e.d.common_color_10221);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        al.i(this.fcA, e.f.post_button_bg);
        al.c(this.fcA, e.d.cp_cont_i, 3);
        al.a(this.fcH, e.f.icon_search_bg_s, e.f.icon_search_bg);
        al.h(this.hWz, e.d.navi_back_text_color);
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
    public void xq(int i) {
        if (i == 2) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_chat_friends));
            this.fcz.setVisibility(8);
        } else if (i == 1) {
            this.OF.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_search_friends));
            this.fcz.setVisibility(8);
        } else if (i == 0) {
            this.OF.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hWB) {
                this.fcz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hWv.getItem(i);
        if (item != null) {
            if (this.hWB) {
                if (this.hWs == null && this.hWt == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hWr.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hWv.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.hWC) {
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
        if (this.hWs != null) {
            this.hWs.cancel();
        }
        if (this.hWt != null) {
            this.hWt.cancel();
        }
        this.mHandler.removeCallbacks(this.hWD);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_chat_friends), null, true);
        this.hWx = findViewById(e.g.at_candidate_border);
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
        ayF();
        this.dop = (NoNetworkView) findViewById(e.g.view_no_network);
        this.dop.a(this.htX);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.OF = (BdListView) findViewById(e.g.list);
        this.hWv = new com.baidu.tieba.write.write.a(this, this.hWB);
        this.hWv.a(this);
        this.hWv.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hWr.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(e.j.invite_friend_exceed_max_count), 5), e.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.OF.setAdapter((ListAdapter) this.hWv);
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
        this.fcz = (LinearLayout) this.mParent.findViewById(e.g.invite_candidate);
        this.fcA = (Button) this.mParent.findViewById(e.g.button_send);
        this.fcA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hWr.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qx(0);
        this.hWr = (AtSelectFriendList) this.mParent.findViewById(e.g.candidate_list);
        this.hWr.setMaxCount(5);
        this.hWr.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
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
        aVp();
    }

    private void ayF() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.hWz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.fcE != null && AtListActivity.this.fcE.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.fcE.setVisibility(8);
                    AtListActivity.this.hWy.setVisibility(0);
                    AtListActivity.this.fcF.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.hWy = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.select_friend));
        this.fcF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hWy.setVisibility(8);
                AtListActivity.this.fcF.setVisibility(8);
                AtListActivity.this.fcE.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.fcH = (ImageView) this.fcF.findViewById(e.g.new_friend_search);
        this.fcE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.fcE.setVisibility(8);
        this.mEditText = (EditText) this.fcE.findViewById(e.g.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hWw)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hWD);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hWD, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bAP.setVisibility(0);
                    } else {
                        AtListActivity.this.bAP.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hWw = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.bAP = (TextView) findViewById(e.g.search_bar_delete_button);
        this.bAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void aVp() {
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
    public void xL(String str) {
        if (!isFinishing()) {
            this.hWv.setData(null);
            if (this.hWs != null) {
                this.hWs.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hWu.bOj() != null) {
                    ArrayList<MetaData> bOa = this.hWu.bOj().bOa();
                    Iterator<MetaData> it = bOa.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bOa != null && !bOa.isEmpty()) {
                        xq(0);
                    } else {
                        xq(1);
                    }
                    this.hWv.setData(bOa);
                } else {
                    this.hWv.setData(null);
                    if (this.hWt == null) {
                        this.hWt = new b();
                        this.hWt.setPriority(3);
                        this.hWt.execute("");
                    }
                }
            } else {
                this.hWs = new a();
                this.hWs.setPriority(2);
                this.hWs.execute(str);
                if (this.hWt == null && this.hWu.bOj() == null) {
                    this.hWt = new b();
                    this.hWt.setPriority(3);
                    this.hWt.execute("");
                }
            }
            this.hWv.notifyDataSetInvalidated();
            this.OF.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hWu = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hWB = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hWC = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hWB = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hWC = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hWr.f(metaData);
            qx(this.hWr.getItemLength());
            aVq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hWr.h(metaData);
            qx(this.hWr.getItemLength());
            aVq();
        }
    }

    private void aVq() {
        if (this.hWr.getItemLength() > 0) {
            this.fcA.setEnabled(true);
        } else {
            this.fcA.setEnabled(false);
        }
    }

    private void qx(int i) {
        this.fcA.setText(String.format(getPageContext().getString(e.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hWF;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hWF = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hWs = null;
            this.hWF = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hWF = strArr[0];
            this.mNetwork = new x();
            if (this.hWF == null || this.hWF.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.x("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.x("q", this.hWF);
            if (AtListActivity.this.hWC) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String CL = this.mNetwork.CL();
            if (!this.mNetwork.Dj().Ei().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(CL, AtListActivity.this.hWu.bOj());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hWs = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Dj().Ei().isRequestSuccess() && this.hWF != null && com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").equals(this.hWF)) {
                if (cVar == null || cVar.bOc().isEmpty()) {
                    AtListActivity.this.xq(1);
                } else {
                    AtListActivity.this.xq(0);
                }
                AtListActivity.this.hWu.a(cVar);
                AtListActivity.this.hWv.setData(cVar.bOc());
                AtListActivity.this.hWv.notifyDataSetInvalidated();
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
            AtListActivity.this.hWt = null;
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
            if (AtListActivity.this.hWC) {
                this.mNetwork.x("from", "1");
            } else {
                this.mNetwork.x("from", "0");
            }
            String CL = this.mNetwork.CL();
            if (!this.mNetwork.Dj().Ei().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.xA(CL);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hWt = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.fcz != null && AtListActivity.this.fcz.getVisibility() == 0) {
                AtListActivity.this.hWx.setVisibility(0);
            }
            if (this.mNetwork.Dj().Ei().isRequestSuccess()) {
                AtListActivity.this.hWu.a(bVar);
                if (AtListActivity.this.hWv != null) {
                    if (com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), "").length() != 0) {
                        if (AtListActivity.this.hWu.bOk() != null) {
                            if (bVar != null && bVar.bOb() != null && !bVar.bOb().isEmpty()) {
                                AtListActivity.this.xq(2);
                            }
                            AtListActivity.this.hWu.bOk().u(bVar.bOb());
                            AtListActivity.this.hWv.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bOa() == null || !bVar.bOa().isEmpty()) {
                            AtListActivity.this.xq(0);
                        } else {
                            AtListActivity.this.xq(2);
                        }
                        AtListActivity.this.hWq = bVar.bOa();
                        AtListActivity.this.hWv.setData(AtListActivity.this.hWq);
                        AtListActivity.this.hWv.notifyDataSetInvalidated();
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
            this.hWr.g(metaData);
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
