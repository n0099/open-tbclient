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
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView eYL;
    private LinearLayout gWj;
    private Button gWk;
    private View gWo;
    private View gWp;
    private ImageView gWr;
    private AtSelectFriendList jVg;
    private TextView jVm;
    private TextView jVn;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ArrayList<MetaData> jVf = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cXw = null;
    private BdListView Nj = null;
    private final Handler mHandler = new Handler();
    private a jVh = null;
    private com.baidu.tieba.write.model.b jVi = null;
    private com.baidu.tieba.write.write.a jVj = null;
    private String jVk = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View jVl = null;
    private final int jVo = 5;
    private boolean jVp = true;
    private boolean jVq = false;
    private final Runnable jVr = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.Hv(com.baidu.adp.lib.util.k.a(AtListActivity.this.mEditText.getText(), ""));
        }
    };
    private NoNetworkView.a jrx = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (z) {
                AtListActivity.this.refreshData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_list_activity);
        initData(bundle);
        initUI();
        refreshData();
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
        this.eYL.onChangeSkinType(getPageContext(), i);
        this.jVj.notifyDataSetChanged();
        am.getColor(R.color.common_color_10221);
        am.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        am.k(this.gWk, R.drawable.post_button_bg);
        am.f(this.gWk, R.color.cp_cont_a, 3);
        SvgManager.ajv().a(this.gWr, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.j(this.jVn, R.color.navi_back_text_color);
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
        this.mNoDataView.akI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn(int i) {
        if (i == 2) {
            this.Nj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.no_chat_friends));
            this.gWj.setVisibility(8);
        } else if (i == 1) {
            this.Nj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.no_search_friends));
            this.gWj.setVisibility(8);
        } else if (i == 0) {
            this.Nj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.jVp) {
                this.gWj.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.jVj.getItem(i);
        if (item != null) {
            if (this.jVp) {
                if (this.jVh == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.jVg.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.jVj.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.b(getPageContext().getPageActivity(), this.mEditText);
            if (this.jVq) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new an("c12930").n(VideoPlayActivityConfig.OBJ_ID, item.getUserIdLong()));
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
        if (this.jVh != null) {
            this.jVh.cancel();
        }
        this.mHandler.removeCallbacks(this.jVr);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iQ(R.string.no_chat_friends), null, true);
        this.jVl = findViewById(R.id.at_candidate_border);
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
        aJX();
        this.eYL = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eYL.a(this.jrx);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.Nj = (BdListView) findViewById(R.id.list);
        this.jVj = new com.baidu.tieba.write.write.a(this, this.jVp);
        this.jVj.a(this);
        this.jVj.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.jVg.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.Nj.setAdapter((ListAdapter) this.jVj);
        this.Nj.setOnItemClickListener(this);
        this.Nj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
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
        this.gWj = (LinearLayout) this.mParent.findViewById(R.id.invite_candidate);
        this.gWk = (Button) this.mParent.findViewById(R.id.button_send);
        this.gWk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.jVg.getDataList());
                intent.putExtras(bundle);
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        wf(0);
        this.jVg = (AtSelectFriendList) this.mParent.findViewById(R.id.candidate_list);
        this.jVg.setMaxCount(5);
        this.jVg.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Nj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        bIz();
    }

    private void aJX() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.jVn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.gWo != null && AtListActivity.this.gWo.getVisibility() == 0) {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                    AtListActivity.this.gWo.setVisibility(8);
                    AtListActivity.this.jVm.setVisibility(0);
                    AtListActivity.this.gWp.setVisibility(0);
                    AtListActivity.this.mEditText.getText().clear();
                    return;
                }
                l.b(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.mEditText);
                AtListActivity.this.finish();
            }
        });
        this.jVm = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.gWp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.jVm.setVisibility(8);
                AtListActivity.this.gWp.setVisibility(8);
                AtListActivity.this.gWo.setVisibility(0);
                AtListActivity.this.mEditText.requestFocus();
            }
        });
        this.gWr = (ImageView) this.gWp.findViewById(R.id.new_friend_search);
        this.gWo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gWo.setVisibility(8);
        this.mEditText = (EditText) this.gWo.findViewById(R.id.search_bar_edit);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = com.baidu.adp.lib.util.k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.jVk)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.jVr);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.jVr, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.cXw.setVisibility(0);
                    } else {
                        AtListActivity.this.cXw.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.jVk = com.baidu.adp.lib.util.k.a(charSequence, null);
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
        this.cXw = (TextView) findViewById(R.id.search_bar_delete_button);
        this.cXw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.mEditText.getText().clear();
            }
        });
    }

    private void bIz() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds80) + getResources().getDimensionPixelSize(R.dimen.ds16) + getResources().getDimensionPixelSize(R.dimen.ds16);
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
                AtListActivity.this.Nj.requestFocus();
            }
        });
        this.Nj.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (!isFinishing()) {
            this.jVj.setData(null);
            if (this.jVi.cBO() != null) {
                ArrayList<MetaData> cBG = this.jVi.cBO().cBG();
                Iterator<MetaData> it = cBG.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!v.aa(cBG)) {
                    Dn(0);
                } else {
                    Dn(1);
                }
                this.jVj.setData(cBG);
            } else {
                this.jVj.setData(null);
                if (this.jVh == null) {
                    this.jVh = new a();
                    this.jVh.setPriority(3);
                    this.jVh.execute("");
                }
            }
            this.jVj.notifyDataSetInvalidated();
            this.Nj.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            this.mProgress.setVisibility(0);
            this.jVj.setData(null);
            if (!v.aa(this.jVf)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.jVf;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.jVf.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getName_show() != null && next.getName_show().contains(str)) {
                            arrayList2.add(next);
                        }
                    }
                    arrayList = arrayList2;
                }
            }
            this.mProgress.setVisibility(8);
            if (!v.aa(arrayList)) {
                Dn(0);
            } else {
                Dn(1);
            }
            this.jVj.setData(arrayList);
            this.jVj.notifyDataSetInvalidated();
            this.Nj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.jVi = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.jVp = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.jVq = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.jVp = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.jVq = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.jVg.f(metaData);
            wf(this.jVg.getItemLength());
            bIA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.jVg.h(metaData);
            wf(this.jVg.getItemLength());
            bIA();
        }
    }

    private void bIA() {
        if (this.jVg.getItemLength() > 0) {
            this.gWk.setEnabled(true);
        } else {
            this.gWk.setEnabled(false);
        }
    }

    private void wf(int i) {
        this.gWk.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private x mNetwork;

        private a() {
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
                this.mNetwork.ik();
            }
            AtListActivity.this.jVh = null;
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
            if (AtListActivity.this.jVq) {
                this.mNetwork.o("from", "1");
            } else {
                this.mNetwork.o("from", "0");
            }
            String aim = this.mNetwork.aim();
            if (!this.mNetwork.aiK().ajN().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Hk(aim);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.jVh = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.gWj != null && AtListActivity.this.gWj.getVisibility() == 0) {
                AtListActivity.this.jVl.setVisibility(0);
            }
            if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
                AtListActivity.this.jVi.a(bVar);
                if (AtListActivity.this.jVj != null) {
                    if (bVar == null || bVar.cBG() == null || !bVar.cBG().isEmpty()) {
                        AtListActivity.this.Dn(0);
                    } else {
                        AtListActivity.this.Dn(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.jVf = bVar.cBG();
                    }
                    AtListActivity.this.jVj.setData(AtListActivity.this.jVf);
                    AtListActivity.this.jVj.notifyDataSetInvalidated();
                    AtListActivity.this.Nj.setSelection(0);
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
            this.jVg.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public p onGetPreLoadListView() {
        if (this.Nj == null) {
            return null;
        }
        return this.Nj.getPreLoadHandle();
    }
}
