package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class AtListActivity extends SuspendedActivity implements AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a, a.b {
    private EditText cCD;
    private Intent ggB;
    private TextView ghT;
    private LinearLayout kRE;
    private Button kRF;
    private View kRJ;
    private View kRK;
    private ImageView kRM;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private AtSelectFriendList olb;
    private TextView olh;
    protected ArrayList<MetaData> ola = new ArrayList<>();
    private BdListView Yj = null;
    private a olc = null;
    private com.baidu.tieba.write.model.a old = null;
    private com.baidu.tieba.write.write.a ole = null;
    private String olf = null;
    private RelativeLayout lzu = null;
    private View olg = null;
    private final int oli = 5;
    private boolean olj = true;
    private boolean olk = false;
    private boolean oll = false;
    private final Handler mHandler = new Handler();
    private final Runnable olm = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.VD(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.cCD.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bER();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEL() {
        View childAt;
        return this.Yj != null && this.Yj.getFirstVisiblePosition() == 0 && (childAt = this.Yj.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEM() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.cCD);
        if (this.kRJ == null || this.kRJ.getVisibility() != 0) {
            return true;
        }
        this.kRJ.setVisibility(8);
        this.olh.setVisibility(0);
        this.kRK.setVisibility(0);
        this.cCD.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rz(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEN() {
        return this.ggB;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bER() {
        if (!isFinishing()) {
            this.ole.setData(null);
            if (this.old.dXy() != null) {
                ArrayList<MetaData> dXu = this.old.dXy().dXu();
                Iterator<MetaData> it = dXu.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!y.isEmpty(dXu)) {
                    Lz(0);
                } else {
                    Lz(1);
                }
                this.ole.setData(dXu);
            } else {
                this.ole.setData(null);
                if (this.olc == null) {
                    this.olc = new a();
                    this.olc.setPriority(3);
                    this.olc.execute("");
                }
            }
            this.ole.notifyDataSetInvalidated();
            this.Yj.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lzu);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.ole.notifyDataSetChanged();
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ap.setBackgroundResource(this.kRF, R.drawable.post_button_bg);
        com.baidu.tbadk.core.elementsMaven.c.br(this.kRF).oh(R.string.J_X03).setBackGroundColor(R.color.CAM_X0302);
        ap.setViewTextColor(this.kRF, R.color.CAM_X0101, 3);
        this.kRM.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        ap.setViewTextColor(this.mContainer, R.color.CAM_X0201);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.bua();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lz(int i) {
        if (i == 2) {
            this.Yj.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_chat_friends)));
            this.kRE.setVisibility(8);
        } else if (i == 1) {
            this.Yj.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_search_friends)));
            this.kRE.setVisibility(8);
        } else if (i == 0) {
            this.Yj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.olj) {
                this.kRE.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.ole.getItem(i);
        if (item != null) {
            if (this.olj) {
                if (this.olc == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.olb.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.ole.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.cCD);
            if (this.olk) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new ar("c12930").v("obj_id", item.getUserIdLong()));
            }
            if (this.oll) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.ggB = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.ggB.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.olc != null) {
            this.olc.cancel();
        }
        this.mHandler.removeCallbacks(this.olm);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.lzu = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.lzu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.olg = findViewById(R.id.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cCD);
                    return false;
                }
                return false;
            }
        });
        bEP();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.Yj = (BdListView) findViewById(R.id.list);
        this.ole = new com.baidu.tieba.write.write.a(this, this.olj);
        this.ole.a(this);
        this.ole.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.olb.getItemLength()) {
                            AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                            tbCheckBox.setChecked(false);
                            ((MetaData) obj).setChecked(false);
                            return;
                        }
                        AtListActivity.this.d((MetaData) obj);
                        return;
                    }
                    AtListActivity.this.e((MetaData) obj);
                }
            }
        });
        this.Yj.setAdapter((ListAdapter) this.ole);
        this.Yj.setOnItemClickListener(this);
        this.Yj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cCD);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra("keyboard", false) && this.cCD.getParent() != null) {
            ((View) this.cCD.getParent()).setFocusable(true);
            ((View) this.cCD.getParent()).setFocusableInTouchMode(true);
        }
        this.kRE = (LinearLayout) this.lzu.findViewById(R.id.invite_candidate);
        this.kRF = (Button) this.lzu.findViewById(R.id.button_send);
        this.kRF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.ggB = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.olb.getDataList());
                AtListActivity.this.ggB.putExtras(bundle);
                l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cCD);
                AtListActivity.this.finish();
            }
        });
        Dt(0);
        this.olb = (AtSelectFriendList) this.lzu.findViewById(R.id.candidate_list);
        this.olb.setMaxCount(5);
        this.olb.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.Yj.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cZc();
    }

    private void bEP() {
        this.olh = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.kRK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.olh.setVisibility(8);
                AtListActivity.this.kRK.setVisibility(8);
                AtListActivity.this.kRJ.setVisibility(0);
                AtListActivity.this.cCD.requestFocus();
            }
        });
        this.kRM = (ImageView) this.kRK.findViewById(R.id.new_friend_search);
        this.kRJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kRJ.setVisibility(8);
        this.cCD = (EditText) this.kRJ.findViewById(R.id.search_bar_edit);
        this.cCD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.olf)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.olm);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.olm, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.ghT.setVisibility(0);
                    } else {
                        AtListActivity.this.ghT.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.olf = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.cCD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.showSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.ghT = (TextView) findViewById(R.id.search_bar_delete_button);
        this.ghT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.cCD.getText().clear();
            }
        });
    }

    private void cZc() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds80) + getResources().getDimensionPixelSize(R.dimen.ds16) + getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.Yj.requestFocus();
            }
        });
        this.Yj.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VD(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.ole.setData(null);
            if (!y.isEmpty(this.ola)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.ola;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.ola.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getName_show() != null && next.getName_show().contains(str)) {
                            arrayList2.add(next);
                        }
                    }
                    arrayList = arrayList2;
                }
            }
            hideLoadingView(this.mContainer);
            if (!y.isEmpty(arrayList)) {
                Lz(0);
            } else {
                Lz(1);
            }
            this.ole.setData(arrayList);
            this.ole.notifyDataSetInvalidated();
            this.Yj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.old = new com.baidu.tieba.write.model.a();
        if (bundle != null) {
            this.olj = bundle.getBoolean("is_need_multiple");
            this.olk = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.oll = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.olj = getIntent().getBooleanExtra("is_need_multiple", true);
        this.olk = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.oll = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.olb.f(metaData);
            Dt(this.olb.getItemLength());
            cZd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.olb.h(metaData);
            Dt(this.olb.getItemLength());
            cZd();
        }
    }

    private void cZd() {
        if (this.olb.getItemLength() > 0) {
            this.kRF.setEnabled(true);
        } else {
            this.kRF.setEnabled(false);
        }
    }

    private void Dt(int i) {
        this.kRF.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private aa mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.showLoadingView(AtListActivity.this.mContainer);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            AtListActivity.this.olc = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ad */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new aa();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + Config.FREIND_LIST_ADDRESS);
            if (!AtListActivity.this.olk) {
                if (AtListActivity.this.oll) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.bsu().bte().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Vv(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.olc = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            AtListActivity.this.hideNetRefreshView(AtListActivity.this.mContainer);
            if (AtListActivity.this.kRE != null && AtListActivity.this.kRE.getVisibility() == 0) {
                AtListActivity.this.olg.setVisibility(0);
            }
            if (this.mNetwork.bsu().bte().isRequestSuccess()) {
                AtListActivity.this.old.a(bVar);
                if (AtListActivity.this.ole != null) {
                    if (bVar == null || bVar.dXu() == null || !bVar.dXu().isEmpty()) {
                        AtListActivity.this.Lz(0);
                    } else {
                        AtListActivity.this.Lz(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.ola = bVar.dXu();
                    }
                    AtListActivity.this.ole.setData(AtListActivity.this.ola);
                    AtListActivity.this.ole.notifyDataSetInvalidated();
                    AtListActivity.this.Yj.setSelection(0);
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
                AtListActivity.this.showNetRefreshView(AtListActivity.this.mContainer, AtListActivity.this.getString(R.string.refresh_view_title_text), null, AtListActivity.this.getString(R.string.refresh_view_button_text), true, AtListActivity.this.getNetRefreshListener());
            }
            super.onPostExecute(bVar);
        }
    }

    @Override // com.baidu.tieba.write.write.a.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.olb.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public q onGetPreLoadListView() {
        if (this.Yj == null) {
            return null;
        }
        return this.Yj.getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (l.isNetOk()) {
            bER();
        }
    }
}
