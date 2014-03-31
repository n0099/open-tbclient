package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tbadk.core.d {
    public static final int REQUEST_MARK = 102;
    public static final int REQUSET_CHANGE = 101;
    public static final int REQUSET_MY_BAR = 103;
    public static final int REQUSET_MY_MENTION = 104;
    public static final String TAG_ID = "un";
    public static final String TAG_MSG_PAGE = "tab_msg";
    public static final String TAG_NAME = "name";
    public static final String TAG_SELF = "self";
    public static final String TAG_TAB_PAGE = "tab_page";
    private static final String USER_ICON_WEBVIEW = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/135_1";
    private static boolean isNeedRefreshOnResume = false;
    private List<View> lsViews;
    private com.baidu.tbadk.core.e mContext;
    private af mHeadView;
    private aj mPersonCenterView;
    private ab vPagerItem1;
    private ab vPagerItem2;
    private com.baidu.tieba.model.av mModel = null;
    private com.baidu.tieba.model.e mBlackListModel = null;
    private Boolean mIsHost = false;
    private PersonChangeData mPersonChangeData = null;
    private AlertDialog mClickPhotoDialog = null;
    private com.baidu.tbadk.core.dialog.d mMoreDialog = null;
    private AlertDialog mBlackListAlertDialog = null;
    private boolean toShowMoreDialog = false;
    private boolean isloading = false;
    private final com.baidu.adp.framework.c.g mListener = new bm(this, 0);
    private final com.baidu.adp.framework.c.g messageListener = new bp(this, 2001124);

    public boolean isIsloading() {
        return this.isloading;
    }

    public void setIsloading(boolean z) {
        this.isloading = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        initModel(bundle);
        this.mIsHost = Boolean.valueOf(this.mModel.f());
        initHeadItemView();
        return initView(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mModel.n();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        com.baidu.adp.framework.c.a().a(104102, this.mListener);
        com.baidu.adp.framework.c.a().a(104104, this.mListener);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.adp.framework.c.a().b(this.mListener);
        if (this.mBlackListModel != null) {
            this.mBlackListModel.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
        if (this.mModel.e() != null && this.mModel.e().length() > 0 && this.mIsHost.booleanValue()) {
            initReceiver();
        }
        com.baidu.tieba.util.k.a((Boolean) true);
        if (this.mModel.e() != null && this.mModel.e().length() > 0) {
            fresh();
        }
        this.mPersonChangeData = new PersonChangeData();
    }

    private View initView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.person_center_view, (ViewGroup) null);
    }

    private void initUI() {
        this.mPersonCenterView = new aj(this.mContext, this);
        initClickPhotoDialog();
        this.mPersonCenterView.setScrollToBottomListener(new bq(this));
        this.mPersonCenterView.setExpandListRefreshListener(new br(this));
        this.mPersonCenterView.setLoadMoreOnClickListener(new bs(this));
    }

    private void initReceiver() {
        com.baidu.adp.framework.c.a().a(this.messageListener);
    }

    private void unRegister() {
        com.baidu.adp.framework.c.a().b(this.messageListener);
    }

    private void initModel(Bundle bundle) {
        this.mBlackListModel = new com.baidu.tieba.model.e();
        this.mModel = new com.baidu.tieba.model.av(this.mContext);
        this.mModel.c();
        if (getActivity() instanceof com.baidu.tbadk.core.e) {
            this.mBlackListModel.setUniqueId(((com.baidu.tbadk.core.e) getActivity()).a());
            this.mModel.setUniqueId(((com.baidu.tbadk.core.e) getActivity()).a());
        }
        this.mModel.a(new bt(this));
        if (bundle != null) {
            this.mModel.b(bundle.getBoolean(TAG_SELF, true));
            this.mModel.a(bundle.getString(TAG_ID));
            this.mModel.c(bundle.getString(TAG_NAME));
            this.mModel.c(bundle.getBoolean(TAG_TAB_PAGE, false));
            this.mModel.d(bundle.getBoolean(TAG_MSG_PAGE, false));
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.mModel.b(arguments.getBoolean(TAG_SELF, true));
                this.mModel.a(arguments.getString(TAG_ID));
                this.mModel.c(arguments.getString(TAG_NAME));
                this.mModel.c(arguments.getBoolean(TAG_TAB_PAGE, false));
                this.mModel.d(arguments.getBoolean(TAG_MSG_PAGE, false));
            }
        }
        checkUserMaskType();
        this.mModel.setLoadDataCallBack(new bu(this));
    }

    private void initHeadItemView() {
        this.lsViews = null;
        this.lsViews = new ArrayList();
        if (this.mIsHost.booleanValue()) {
            this.vPagerItem1 = new ab(this.mContext, this, 1);
        } else {
            this.vPagerItem1 = new ab(this.mContext, this, 3);
        }
        this.vPagerItem2 = new ab(this.mContext, this, 2);
        this.lsViews.add(this.vPagerItem1);
        this.lsViews.add(this.vPagerItem2);
        this.mHeadView = new af(this.mContext, this);
        this.mHeadView.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.i.a((Context) this.mContext, 270.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadItemView() {
        this.lsViews = null;
        this.lsViews = new ArrayList();
        if (this.mModel.f()) {
            this.vPagerItem1.a(this.mModel, 1);
        } else {
            this.vPagerItem1.a(this.mModel, 3);
        }
        this.vPagerItem2.a(this.mModel, 2);
        this.lsViews.add(this.vPagerItem1);
        this.lsViews.add(this.vPagerItem2);
    }

    public List<View> getLsViews() {
        return this.lsViews;
    }

    public af getHeadView() {
        return this.mHeadView;
    }

    public void fresh() {
        if (this.mPersonCenterView != null) {
            this.mPersonCenterView.b();
        }
        this.mModel.a(true, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.mModel.a(false, true, 2);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mModel != null) {
            bundle.putBoolean(TAG_SELF, this.mModel.f());
            bundle.putString(TAG_ID, this.mModel.e());
            bundle.putString(TAG_NAME, this.mModel.j());
            bundle.putBoolean(TAG_TAB_PAGE, this.mModel.l());
            bundle.putBoolean(TAG_MSG_PAGE, this.mModel.m());
        }
    }

    public static void setRefreshFlag(boolean z) {
        isNeedRefreshOnResume = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        boolean z = false;
        super.onResume();
        if (isNeedRefreshOnResume) {
            fresh();
            isNeedRefreshOnResume = false;
        } else if (isShow()) {
            this.mIsHost = Boolean.valueOf(this.mModel.f());
            if (this.mModel.e() == null || this.mModel.e().length() <= 0) {
                TiebaStatic.a(this.mContext, "home_login_show", "loginshow", 1, new Object[0]);
                if (TbadkApplication.E() != null) {
                    this.mModel.b(true);
                    this.mModel.a(TbadkApplication.E());
                    this.mModel.c(TbadkApplication.O());
                    initReceiver();
                    fresh();
                    return;
                }
                return;
            }
            if (this.mIsHost.booleanValue()) {
                if (com.baidu.tbadk.coreExtra.messageCenter.a.a().k() != this.mModel.k()) {
                    this.mModel.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
                    z = true;
                }
                if (z && this.mModel.k() > 0) {
                    this.mModel.a(this.mModel.k());
                    this.mHeadView.a(true);
                }
            }
            this.vPagerItem1.a();
            this.mHeadView.a();
            this.mPersonCenterView.f();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void onChangeSkinType(int i) {
        this.mPersonCenterView.a(i);
        this.mHeadView.a(i);
        this.vPagerItem1.a(i);
        this.vPagerItem2.a(i);
    }

    @Override // com.baidu.tbadk.core.d
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.mContext.b(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBlackListAlertDialog() {
        String format;
        String userName = this.mModel.g() != null ? this.mModel.g().getUserName() : null;
        if (userName != null) {
            if (this.mBlackListAlertDialog == null) {
                createBlackListAlertDialog();
            }
            if (this.mBlackListModel.a() == 1) {
                format = String.format(getString(com.baidu.tieba.a.k.black_list_ensure_toremove_text), userName);
            } else {
                format = String.format(getString(com.baidu.tieba.a.k.remove_black_alert), userName);
            }
            this.mBlackListAlertDialog.setMessage(format);
            this.mBlackListAlertDialog.show();
        }
    }

    private void createBlackListAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setPositiveButton(getString(com.baidu.tieba.a.k.confirm), new bv(this));
        builder.setNegativeButton(getString(com.baidu.tieba.a.k.cancel), new bw(this));
        this.mBlackListAlertDialog = builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMoreDialog() {
        createMoreDialog();
        this.mMoreDialog.b();
    }

    private void createMoreDialog() {
        this.mMoreDialog = new com.baidu.tbadk.core.dialog.d(this.mContext);
        this.mMoreDialog.a(new Object[]{this.mContext.getString(this.mBlackListModel.a() == 1 ? com.baidu.tieba.a.k.delete_to_black_list : com.baidu.tieba.a.k.add_to_black_list), new Object[]{this.mContext.getString(com.baidu.tieba.a.k.cancel), 1}}, new bn(this)).a(com.baidu.tbadk.core.dialog.f.a).b(80).a();
    }

    private void onMoreButClick() {
        if (this.mBlackListModel.a() == 2) {
            checkUserMaskType();
            this.toShowMoreDialog = true;
            return;
        }
        showMoreDialog();
    }

    private void checkUserMaskType() {
        int a = com.baidu.adp.lib.f.b.a(this.mModel.e(), -1);
        if (a > 0 && !this.mModel.f()) {
            this.mBlackListModel.a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToBigImage() {
        if (this.mModel != null && this.mModel.g() != null) {
            PersonImageActivity.a(this.mContext, generateImageUrl(this.mContext, this.mModel.g().getPortraitH()));
        }
    }

    private String generateImageUrl(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void startAttention() {
        this.mModel.h();
    }

    private void StartChat() {
        TiebaStatic.a(this.mContext, "enter_chat", "personclick", 1, new Object[0]);
        try {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new com.baidu.tbadk.core.b.ah(this.mContext, Long.parseLong(this.mModel.g().getUserId()), this.mModel.g().getUserName(), this.mModel.g().getPortrait(), this.mModel.g().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.mModel != null) {
            if (this.mModel.e() != null && this.mModel.e().length() > 0 && this.mModel.f()) {
                unRegister();
            }
            this.mModel.n();
        }
        com.baidu.tieba.util.k.a((Boolean) true);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                onChangeInfoResult(intent);
            } else if (i == 11003 || i == 12007) {
                if (TbadkApplication.E() != null) {
                    this.mModel.b(true);
                    this.mModel.a(TbadkApplication.E());
                    this.mModel.c(TbadkApplication.O());
                    initReceiver();
                    fresh();
                }
            } else if (i == 11028) {
                StartChat();
            } else if (i == 11035) {
                this.mModel.h();
            } else if (i == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(getActivity(), 12002, 12009, intent.getData(), TbadkApplication.N());
                }
            } else if (i == 12001) {
                EditHeadActivity.a(getActivity(), 12001, 12010, null, TbadkApplication.N());
            } else if (i == 12010 || i == 12009) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                r.a(true);
                if (this.mModel.g() != null) {
                    this.mModel.i();
                    com.baidu.tbadk.imageManager.e.a().a(this.mModel.g().getPortrait());
                }
                fresh();
            }
        } else if (i2 == 0) {
            if (i == 12009) {
                com.baidu.tbadk.core.util.az.b(getActivity());
            } else if (i == 12010) {
                com.baidu.tbadk.core.util.az.a(getActivity());
            }
        }
    }

    private void onChangeInfoResult(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.mModel.g() != null) {
            this.mModel.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.mPersonChangeData != null) {
                    this.mPersonChangeData.setPhotoChanged(true);
                }
                r.a(true);
                if (this.mModel.g() != null) {
                    this.mModel.i();
                    com.baidu.tbadk.imageManager.e.a().a(this.mModel.g().getPortrait());
                }
            }
            fresh();
        }
    }

    private void initClickPhotoDialog() {
        String[] strArr = {getString(com.baidu.tieba.a.k.hd_photo), getString(com.baidu.tieba.a.k.take_photo), getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setTitle(getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new bo(this));
        if (this.mClickPhotoDialog == null) {
            this.mClickPhotoDialog = builder.create();
            this.mClickPhotoDialog.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNotify(com.baidu.adp.framework.message.f<?> fVar) {
        if (fVar != null) {
            if (!(fVar instanceof NewsNotifyMessage)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            int d = ((NewsNotifyMessage) fVar).d();
            if (this.mModel != null && d > 0) {
                this.mModel.a(d);
                this.mHeadView.a(true);
                this.mHeadView.a();
                this.mPersonCenterView.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.mHeadView.getBackBtn().getId()) {
            this.mContext.finish();
        } else if (view.getId() == this.mHeadView.getEditBtn().getId()) {
            if (!this.mModel.f()) {
                onMoreButClick();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.mModel.g() != null) {
                personChangeData.setName(this.mModel.g().getName_show());
                personChangeData.setIntro(this.mModel.g().getIntro());
                personChangeData.setSex(this.mModel.g().getSex());
                personChangeData.setPortrait(this.mModel.g().getPortrait());
            }
            PersonChangeActivity.a(this.mContext, REQUSET_CHANGE, personChangeData, true);
            com.baidu.tbadk.core.g.a(this.mContext, "person_editprofile_click");
        } else if (view.getId() == this.vPagerItem1.getAttentionBtn().getId()) {
            if (this.mModel.g() != null) {
                if (TbadkApplication.E() == null || TbadkApplication.E().length() <= 0) {
                    LoginActivity.a((Activity) this.mContext, this.mContext.getResources().getString(com.baidu.tieba.a.k.login_to_attention), true, 11035);
                } else if (!this.mModel.f()) {
                    this.mModel.h();
                } else {
                    AntiHelper.a(this.mContext, this.mModel.d(), AntiHelper.OperationType.ACCOUNT_RESTORE, AntiHelper.PageType.PERSON_INFO);
                }
            }
        } else if (view.getId() == this.vPagerItem1.getSendBtn().getId()) {
            if (this.mModel.g() != null) {
                if (TbadkApplication.E() == null || TbadkApplication.E().length() <= 0) {
                    LoginActivity.a((Activity) this.mContext, this.mContext.getResources().getString(com.baidu.tieba.a.k.login_to_chat), true, 11028);
                } else if (!this.mModel.f()) {
                    StartChat();
                }
            }
        } else if (view.getId() == this.vPagerItem1.getUserIcon().getId()) {
            if (this.mModel.g() != null) {
                if (this.mModel.f()) {
                    if (this.mClickPhotoDialog != null) {
                        this.mClickPhotoDialog.show();
                        return;
                    }
                    return;
                }
                jumpToBigImage();
            }
        } else if (view.getId() == this.vPagerItem1.getUserIconView1().getId() || view.getId() == this.vPagerItem1.getUserIconView2().getId()) {
            if (this.mModel.g() != null) {
                TbWebViewActivity.b(this.mContext, this.mContext.getString(com.baidu.tieba.a.k.user_icon_intro), String.valueOf(USER_ICON_WEBVIEW) + "?st_type=person_user_icon");
            }
        } else if (view.getId() == this.mHeadView.getAttentionId()) {
            if (this.mModel != null && this.mModel.g() != null) {
                if (this.mModel.f()) {
                    com.baidu.tbadk.core.g.a(this.mContext, "person_self_attentionper_click");
                } else {
                    com.baidu.tbadk.core.g.a(this.mContext, "person_guid_attentionper_click");
                }
                PersonListActivity.a(this.mContext, true, this.mModel.g().getUserId(), this.mModel.g() != null ? this.mModel.g().getSex() : 0);
            }
        } else if (view.getId() == this.mHeadView.getPostId()) {
            if (this.mModel != null && this.mModel.g() != null) {
                if (this.mModel.f()) {
                    com.baidu.tbadk.core.g.a(this.mContext, "person_self_thread_click");
                } else {
                    com.baidu.tbadk.core.g.a(this.mContext, "person_guid_thread_click");
                }
                PersonPostActivity.a(this.mContext, this.mModel.g().getUserId(), this.mModel.g().getSex(), this.mModel.g().getPortrait());
            }
        } else if (view.getId() == this.mHeadView.getFansId()) {
            if (this.mModel != null && this.mModel.g() != null) {
                if (this.mModel.f()) {
                    com.baidu.tbadk.core.g.a(this.mContext, "person_self_attentionme_click");
                } else {
                    com.baidu.tbadk.core.g.a(this.mContext, "person_guid_attentionme_click");
                }
                this.mHeadView.a(false);
                this.mHeadView.a();
                this.mPersonCenterView.f();
                PersonListActivity.a(this.mContext, false, this.mModel.g().getUserId(), this.mModel.g() != null ? this.mModel.g().getSex() : 0);
            }
        } else if (view.getId() == this.mHeadView.getForumId()) {
            if (this.mModel != null && this.mModel.g() != null) {
                if (this.mModel.f()) {
                    EditBarActivity.a(this.mContext, REQUSET_MY_BAR, null, this.mModel.g() != null ? this.mModel.g().getSex() : 0);
                    com.baidu.tbadk.core.g.a(this.mContext, "person_self_attentionbar_click");
                    return;
                }
                EditBarActivity.a(this.mContext, REQUSET_MY_BAR, this.mModel.g().getUserId(), this.mModel.g() != null ? this.mModel.g().getSex() : 0);
                com.baidu.tbadk.core.g.a(this.mContext, "person_guid_attentionbar_click");
            }
        } else if (view.getId() == this.vPagerItem1.getUserVipView() && this.mModel.g() != null) {
            TbWebViewActivity.a(this.mContext, getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/tbeannote");
        }
    }
}
