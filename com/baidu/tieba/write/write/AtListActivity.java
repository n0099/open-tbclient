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
/* loaded from: classes8.dex */
public class AtListActivity extends SuspendedActivity implements AdapterView.OnItemClickListener, com.baidu.tbadk.suspended.a, a.b {
    private EditText cBd;
    private Intent geT;
    private TextView ggl;
    private LinearLayout kPo;
    private Button kPp;
    private View kPt;
    private View kPu;
    private ImageView kPw;
    private RelativeLayout mContainer;
    private LinearLayout mContentView;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private TextView oiC;
    private AtSelectFriendList oiw;
    protected ArrayList<MetaData> oiv = new ArrayList<>();
    private BdListView WO = null;
    private a oix = null;
    private com.baidu.tieba.write.model.a oiy = null;
    private com.baidu.tieba.write.write.a oiz = null;
    private String oiA = null;
    private RelativeLayout lxd = null;
    private View oiB = null;
    private final int oiD = 5;
    private boolean oiE = true;
    private boolean oiF = false;
    private boolean oiG = false;
    private final Handler mHandler = new Handler();
    private final Runnable oiH = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.Vk(com.baidu.adp.lib.util.k.charSequence2String(AtListActivity.this.cBd.getText(), ""));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        bEN();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEH() {
        View childAt;
        return this.WO != null && this.WO.getFirstVisiblePosition() == 0 && (childAt = this.WO.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEI() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), this.cBd);
        if (this.kPt == null || this.kPt.getVisibility() != 0) {
            return true;
        }
        this.kPt.setVisibility(8);
        this.oiC.setVisibility(0);
        this.kPu.setVisibility(0);
        this.cBd.getText().clear();
        return false;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rx(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
        return this.geT;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bEN() {
        if (!isFinishing()) {
            this.oiz.setData(null);
            if (this.oiy.dXi() != null) {
                ArrayList<MetaData> dXe = this.oiy.dXi().dXe();
                Iterator<MetaData> it = dXe.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                if (!y.isEmpty(dXe)) {
                    Lu(0);
                } else {
                    Lu(1);
                }
                this.oiz.setData(dXe);
            } else {
                this.oiz.setData(null);
                if (this.oix == null) {
                    this.oix = new a();
                    this.oix.setPriority(3);
                    this.oix.execute("");
                }
            }
            this.oiz.notifyDataSetInvalidated();
            this.WO.setSelection(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lxd);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.oiz.notifyDataSetChanged();
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        ap.setBackgroundResource(this.kPp, R.drawable.post_button_bg);
        com.baidu.tbadk.core.elementsMaven.c.br(this.kPp).og(R.string.J_X03).setBackGroundColor(R.color.CAM_X0302);
        ap.setViewTextColor(this.kPp, R.color.CAM_X0101, 3);
        this.kPw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
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
        this.mNoDataView.btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu(int i) {
        if (i == 2) {
            this.WO.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_chat_friends)));
            this.kPo.setVisibility(8);
        } else if (i == 1) {
            this.WO.setVisibility(8);
            hideNetRefreshView(this.mContainer);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_search_friends)));
            this.kPo.setVisibility(8);
        } else if (i == 0) {
            this.WO.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.oiE) {
                this.kPo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.oiz.getItem(i);
        if (item != null) {
            if (this.oiE) {
                if (this.oix == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.oiw.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.oiz.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.cBd);
            if (this.oiF) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new ar("c12930").v("obj_id", item.getUserIdLong()));
            }
            if (this.oiG) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new com.baidu.tbadk.data.b(item.getUk(), item.getName_show())));
            }
            this.geT = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.geT.putExtras(bundle);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.oix != null) {
            this.oix.cancel();
        }
        this.mHandler.removeCallbacks(this.oiH);
        hideLoadingView(this.mContainer);
        super.onDestroy();
    }

    private void initUI() {
        this.lxd = (RelativeLayout) findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.lxd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, l.getDimens(getActivity(), R.dimen.ds320)), NoDataViewFactory.d.dS(null, getResources().getString(R.string.no_chat_friends)), null, true);
        this.oiB = findViewById(R.id.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cBd);
                    return false;
                }
                return false;
            }
        });
        bEL();
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        this.WO = (BdListView) findViewById(R.id.list);
        this.oiz = new com.baidu.tieba.write.write.a(this, this.oiE);
        this.oiz.a(this);
        this.oiz.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj instanceof MetaData) {
                    if (z) {
                        if (5 <= AtListActivity.this.oiw.getItemLength()) {
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
        this.WO.setAdapter((ListAdapter) this.oiz);
        this.WO.setOnItemClickListener(this);
        this.WO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cBd);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra("keyboard", false) && this.cBd.getParent() != null) {
            ((View) this.cBd.getParent()).setFocusable(true);
            ((View) this.cBd.getParent()).setFocusableInTouchMode(true);
        }
        this.kPo = (LinearLayout) this.lxd.findViewById(R.id.invite_candidate);
        this.kPp = (Button) this.lxd.findViewById(R.id.button_send);
        this.kPp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.geT = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.oiw.getDataList());
                AtListActivity.this.geT.putExtras(bundle);
                l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.cBd);
                AtListActivity.this.finish();
            }
        });
        Dq(0);
        this.oiw = (AtSelectFriendList) this.lxd.findViewById(R.id.candidate_list);
        this.oiw.setMaxCount(5);
        this.oiw.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.WO.findViewWithTag(obj);
                    if (findViewWithTag instanceof TbCheckBox) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        cYO();
    }

    private void bEL() {
        this.oiC = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
        this.kPu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.oiC.setVisibility(8);
                AtListActivity.this.kPu.setVisibility(8);
                AtListActivity.this.kPt.setVisibility(0);
                AtListActivity.this.cBd.requestFocus();
            }
        });
        this.kPw = (ImageView) this.kPu.findViewById(R.id.new_friend_search);
        this.kPt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kPt.setVisibility(8);
        this.cBd = (EditText) this.kPt.findViewById(R.id.search_bar_edit);
        this.cBd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (!charSequence2String.equals(AtListActivity.this.oiA)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.oiH);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.oiH, 300L);
                    }
                    if (charSequence2String.length() > 0) {
                        AtListActivity.this.ggl.setVisibility(0);
                    } else {
                        AtListActivity.this.ggl.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.oiA = com.baidu.adp.lib.util.k.charSequence2String(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.cBd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.showSoftKeyPad(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.ggl = (TextView) findViewById(R.id.search_bar_delete_button);
        this.ggl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.cBd.getText().clear();
            }
        });
    }

    private void cYO() {
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
                AtListActivity.this.WO.requestFocus();
            }
        });
        this.WO.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vk(String str) {
        ArrayList<MetaData> arrayList = null;
        if (!isFinishing()) {
            showLoadingView(this.mContainer);
            this.oiz.setData(null);
            if (!y.isEmpty(this.oiv)) {
                if (str == null || str.length() == 0) {
                    arrayList = this.oiv;
                } else {
                    ArrayList<MetaData> arrayList2 = new ArrayList<>();
                    Iterator<MetaData> it = this.oiv.iterator();
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
                Lu(0);
            } else {
                Lu(1);
            }
            this.oiz.setData(arrayList);
            this.oiz.notifyDataSetInvalidated();
            this.WO.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.oiy = new com.baidu.tieba.write.model.a();
        if (bundle != null) {
            this.oiE = bundle.getBoolean("is_need_multiple");
            this.oiF = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            this.oiG = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
            return;
        }
        this.oiE = getIntent().getBooleanExtra("is_need_multiple", true);
        this.oiF = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
        this.oiG = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.oiw.f(metaData);
            Dq(this.oiw.getItemLength());
            cYP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.oiw.h(metaData);
            Dq(this.oiw.getItemLength());
            cYP();
        }
    }

    private void cYP() {
        if (this.oiw.getItemLength() > 0) {
            this.kPp.setEnabled(true);
        } else {
            this.kPp.setEnabled(false);
        }
    }

    private void Dq(int i) {
        this.kPp.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            AtListActivity.this.oix = null;
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
            if (!AtListActivity.this.oiF) {
                if (AtListActivity.this.oiG) {
                    this.mNetwork.addPostData("from", "2");
                } else {
                    this.mNetwork.addPostData("from", "0");
                }
            } else {
                this.mNetwork.addPostData("from", "1");
            }
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.bsr().btb().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.Vc(postNetData);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.oix = null;
            AtListActivity.this.hideLoadingView(AtListActivity.this.mContainer);
            AtListActivity.this.hideNetRefreshView(AtListActivity.this.mContainer);
            if (AtListActivity.this.kPo != null && AtListActivity.this.kPo.getVisibility() == 0) {
                AtListActivity.this.oiB.setVisibility(0);
            }
            if (this.mNetwork.bsr().btb().isRequestSuccess()) {
                AtListActivity.this.oiy.a(bVar);
                if (AtListActivity.this.oiz != null) {
                    if (bVar == null || bVar.dXe() == null || !bVar.dXe().isEmpty()) {
                        AtListActivity.this.Lu(0);
                    } else {
                        AtListActivity.this.Lu(2);
                    }
                    if (bVar != null) {
                        AtListActivity.this.oiv = bVar.dXe();
                    }
                    AtListActivity.this.oiz.setData(AtListActivity.this.oiv);
                    AtListActivity.this.oiz.notifyDataSetInvalidated();
                    AtListActivity.this.WO.setSelection(0);
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
            this.oiw.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public q onGetPreLoadListView() {
        if (this.WO == null) {
            return null;
        }
        return this.WO.getPreLoadHandle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (l.isNetOk()) {
            bEN();
        }
    }
}
