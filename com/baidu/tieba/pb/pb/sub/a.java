package com.baidu.tieba.pb.pb.sub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.pb.view.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class a implements KeyboardEventLayout.a {
    private static final int lWL = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener bbH;
    private ImageView eAD;
    private NoNetworkView fEG;
    private LinearLayout fEH;
    private f.c fci;
    private BdTypeListView gpZ;
    private View iIy;
    private com.baidu.tbadk.core.view.a iqj;
    private com.baidu.tieba.NEGFeedBack.f jCb;
    private TextView jnW;
    private View lPQ;
    private LinearLayout lPS;
    private HeadImageView lPT;
    private e lPx;
    private i lQQ;
    private p lVu;
    private SubPbView lWM;
    private View lWN;
    private NewSubPbActivity lWO;
    private RelativeLayout lWP;
    private View lWT;
    private SubPbModel lWj;
    private ah lWm;
    private ThreadSkinView lXa;
    private d lXb;
    private View lXc;
    private View lXe;
    private View lXg;
    private BlankView lXh;
    private com.baidu.tbadk.core.dialog.b lXj;
    private ArrayList<PostData> lXm;
    private RelativeLayout lXn;
    private ImageView lXo;
    private ImageView lXp;
    private c lXs;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eAI = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lWQ = null;
    private LinearLayout lWR = null;
    private HeadImageView lWS = null;
    private TextView eBQ = null;
    private ImageView lWU = null;
    private TextView lSB = null;
    private TextView lWV = null;
    private TextView lWW = null;
    private EllipsizeRichTextView lWX = null;
    private TbImageView lWY = null;
    private PlayVoiceBntNew alB = null;
    private TextView lWZ = null;
    private MorePopupWindow lXd = null;
    private com.baidu.tbadk.core.dialog.b lXf = null;
    private Dialog lXi = null;
    private com.baidu.tbadk.core.dialog.a lPB = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lXk = null;
    private NewSubPbActivity.a lXl = null;
    private h kJK = null;
    private int fPC = 0;
    private int lXq = 2;
    private int lXr = 0;
    private boolean fux = true;
    private boolean lHR = com.baidu.tbadk.a.d.bkr();
    private com.baidu.tieba.pb.a.c fos = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.8
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.qI(false);
            a.this.qI(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener lXt = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.lXm, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lWm == null) {
                    a.this.lWm = new ah(a.this.lWO.getPageContext(), a.this.bbH);
                }
                a.this.lWm.RU();
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    return true;
                }
                PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                boolean z2 = a.this.uO(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.lWm;
                int dnj = a.this.lWj.dnj();
                if (!a.this.lHR || postData2 == null || !postData2.nmG) {
                    z = false;
                }
                ahVar.a(sparseArray, dnj, z2, z);
                if (z2) {
                    a.this.lWm.drn().setVisibility(0);
                    a.this.lWm.drn().setTag(postData.getId());
                } else {
                    a.this.lWm.drn().setVisibility(8);
                }
                a.this.lWm.drl().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lXu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.lWO != null && bh.checkUpIsLogin(a.this.lWO.getPageContext().getPageActivity())) {
                if ((a.this.lWO.kJE == null || a.this.lWj == null || a.this.lWj.cBf() == null || a.this.lWO.kJE.pP(a.this.lWj.cBf().replyPrivateFlag)) && a.this.lWj != null && a.this.kJK != null) {
                    a.this.dup();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dur();
                        a.this.lWj.duQ();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kJK.setReplyId(str2);
                            a.this.kJK.Ec(str);
                        }
                    }
                    a.this.duq();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.lWM = null;
        this.lWN = null;
        this.gpZ = null;
        this.lPx = null;
        this.lWO = null;
        this.fEG = null;
        this.lWP = null;
        this.lWT = null;
        this.lXb = null;
        this.lXg = null;
        this.bbH = null;
        this.mProgress = null;
        this.jnW = null;
        this.lXn = null;
        this.lXo = null;
        this.lXp = null;
        this.lWO = newSubPbActivity;
        this.bbH = onClickListener;
        this.lWM = (SubPbView) LayoutInflater.from(this.lWO.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.lWN = LayoutInflater.from(this.lWO.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fEH = (LinearLayout) this.lWM.findViewById(R.id.navigation_bar_group);
        this.lXn = (RelativeLayout) this.lWM.findViewById(R.id.subpb_editor_tool_comment);
        this.jnW = (TextView) this.lWM.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jnW.setOnClickListener(this.bbH);
        this.lXo = (ImageView) this.lWM.findViewById(R.id.subpb_editor_tool_more_img);
        this.lXp = (ImageView) this.lWM.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lXp.setOnClickListener(this.bbH);
        this.lXo.setOnClickListener(this.bbH);
        this.fEG = (NoNetworkView) this.lWM.findViewById(R.id.view_no_network);
        cHX();
        bWX();
        this.lWP = (RelativeLayout) this.lWM.findViewById(R.id.sub_pb_body_layout);
        this.gpZ = (BdTypeListView) this.lWM.findViewById(R.id.new_sub_pb_list);
        this.lXa = (ThreadSkinView) LayoutInflater.from(this.lWO.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gpZ.addHeaderView(this.lXa);
        this.gpZ.addHeaderView(this.lWN);
        this.iIy = new TextView(newSubPbActivity.getActivity());
        this.iIy.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gpZ.addHeaderView(this.iIy, 0);
        this.lWM.setTopView(this.iIy);
        this.lWM.setNavigationView(this.fEH);
        this.lWM.setListView(this.gpZ);
        this.lWM.setContentView(this.lWP);
        this.lXb = new d(this.lWO.getPageContext());
        this.lXb.setLineGone();
        this.lXg = this.lXb.getView();
        this.gpZ.setNextPage(this.lXb);
        this.lXb.setOnClickListener(this.bbH);
        this.gpZ.setOnItemClickListener(this.lXu);
        this.gpZ.setOnItemLongClickListener(this.lXt);
        this.gpZ.setOnTouchListener(this.fos);
        this.lPx = new e(newSubPbActivity.getPageContext());
        this.lPx.createView();
        this.lPx.setListPullRefreshListener(this.fci);
        this.lPx.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.lWM.findViewById(R.id.progress);
        this.lPQ = this.lWM.findViewById(R.id.view_comment_top_line);
        this.lPS = (LinearLayout) this.lWM.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lPT = (HeadImageView) this.lWM.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lPT.setVisibility(0);
        this.lPT.setIsRound(true);
        this.lPT.setBorderWidth(l.getDimens(this.lWO, R.dimen.L_X01));
        this.lPT.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lPT.setDefaultBgResource(0);
        this.lPT.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lPT.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lWN != null) {
            this.lWN.setVisibility(4);
        }
        this.lWT = com.baidu.tbadk.ala.b.bkP().z(this.lWO.getActivity(), 4);
        if (this.lWT != null) {
            this.lWT.setVisibility(8);
            this.lWR.addView(this.lWT, 3);
        }
        this.lXs = new c(this.lWO, this.gpZ);
        this.lXs.setFromCDN(this.mIsFromCDN);
        this.lXs.B(this.bbH);
        this.lXs.Nt();
    }

    public ListView getListView() {
        return this.gpZ;
    }

    public void bWX() {
        this.lWR = (LinearLayout) this.lWN.findViewById(R.id.subpb_head_user_info_root);
        this.lWR.setOnClickListener(this.bbH);
        this.lWS = (HeadImageView) this.lWN.findViewById(R.id.photo);
        this.lWS.setRadius(l.getDimens(this.lWO.getActivity(), R.dimen.tbds45));
        this.lWS.setClickable(false);
        this.eBQ = (TextView) this.lWN.findViewById(R.id.user_name);
        this.lWU = (ImageView) this.lWN.findViewById(R.id.user_rank);
        this.lWU.setVisibility(8);
        this.lSB = (TextView) this.lWN.findViewById(R.id.floor_owner);
        this.lWQ = (TextView) this.lWN.findViewById(R.id.see_subject);
        this.lWQ.setOnClickListener(this.bbH);
        this.lWV = (TextView) this.lWN.findViewById(R.id.floor);
        this.lWW = (TextView) this.lWN.findViewById(R.id.time);
        this.lWX = (EllipsizeRichTextView) this.lWN.findViewById(R.id.content_text);
        this.lWX.setOnClickListener(this.bbH);
        ap.setViewTextColor(this.lWX, R.color.CAM_X0105);
        this.lWX.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.lWX.setLineSpacing(0.0f, 1.25f);
        this.lWY = (TbImageView) this.lWN.findViewById(R.id.sub_pb_image);
        this.lWY.setOnClickListener(this.bbH);
        this.lWZ = (TextView) this.lWN.findViewById(R.id.advert);
        this.alB = (PlayVoiceBntNew) this.lWN.findViewById(R.id.voice_btn);
        this.lWN.setOnTouchListener(this.fos);
        this.lWN.setOnClickListener(this.bbH);
    }

    public void a(b.InterfaceC0586b interfaceC0586b, boolean z) {
        if (this.lXj != null) {
            this.lXj.dismiss();
            this.lXj = null;
        }
        this.lXj = new com.baidu.tbadk.core.dialog.b(this.lWO.getPageContext().getPageActivity());
        if (z) {
            this.lXj.a(new String[]{this.lWO.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0586b);
        } else {
            this.lXj.a(new String[]{this.lWO.getPageContext().getString(R.string.save_to_emotion), this.lWO.getPageContext().getString(R.string.save_to_local)}, interfaceC0586b);
        }
        this.lXj.d(this.lWO.getPageContext());
        this.lXj.brx();
    }

    public void dH(View view) {
        this.lXc = view;
    }

    public void cHX() {
        int dimens = l.getDimens(this.lWO.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.lWO.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.lWM.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lXh != null) {
                    a.this.lWM.onFinish();
                } else {
                    a.this.lWO.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        this.eAD = backImageView;
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            layoutParams.leftMargin = dimens2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = dimens;
            layoutParams2.height = dimens;
            this.mBack.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.hideBottomLine();
    }

    public void dD(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.lXi == null) {
            this.lXi = new Dialog(this.lWO.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lXi.setCanceledOnTouchOutside(true);
            this.lXi.setCancelable(true);
            this.lXe = LayoutInflater.from(this.lWO.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.lWO.getLayoutMode().onModeChanged(this.lXe);
            this.lXi.setContentView(this.lXe);
            WindowManager.LayoutParams attributes = this.lXi.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.lWO.getPageContext().getPageActivity()) * 0.9d);
            this.lXi.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lXi.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lXi.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lXi.findViewById(R.id.disable_reply_btn);
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if ("".equals(sparseArray.get(R.id.tag_del_post_id)) || i == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lXi != null && (a.this.lXi instanceof Dialog)) {
                        g.b(a.this.lXi, a.this.lWO.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(R.id.tag_forbid_user_name)) && "".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lXi != null && (a.this.lXi instanceof Dialog)) {
                        g.b(a.this.lXi, a.this.lWO.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lXk != null) {
                        a.this.lXk.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(R.string.un_mute);
            } else {
                textView3.setText(R.string.mute);
            }
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lXi != null && (a.this.lXi instanceof Dialog)) {
                        g.b(a.this.lXi, a.this.lWO.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.lWO.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lXi, this.lWO.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.lPB = new com.baidu.tbadk.core.dialog.a(this.lWO.getPageContext().getPageActivity());
        this.lPB.oQ(i3);
        this.lPB.setYesButtonTag(sparseArray);
        this.lPB.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lXl != null) {
                    a.this.lXl.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lPB.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lPB.jl(true);
        this.lPB.b(this.lWO.getPageContext());
        if (z) {
            this.lPB.brv();
        } else if (1 == this.lWj.dvi()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lWj.dvi(), this.lWj.dvh(), this.lWj.bLy());
            hVar.ek(this.lVu.bDp().getId(), this.lVu.bDp().getName());
            hVar.setForumHeadUrl(this.lWj.bLB());
            hVar.setUserLevel(this.lWj.bLC());
            UserData userData = new UserData();
            userData.setIsManager(this.lWj.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData cBf;
        if (this.lWO != null && sparseArray != null && this.lWN != null) {
            if (this.jCb == null) {
                this.jCb = new com.baidu.tieba.NEGFeedBack.f(this.lWO.getPageContext(), this.lWN);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lWj != null && (cBf = this.lWj.cBf()) != null && cBf.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBf.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.jCb.setDefaultReasonArray(new String[]{this.lWO.getString(R.string.delete_thread_reason_1), this.lWO.getString(R.string.delete_thread_reason_2), this.lWO.getString(R.string.delete_thread_reason_3), this.lWO.getString(R.string.delete_thread_reason_4), this.lWO.getString(R.string.delete_thread_reason_5)});
            this.jCb.setData(atVar);
            this.jCb.Fj("4");
            this.jCb.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    String S = au.S(jSONArray);
                    if (a.this.lXl != null) {
                        a.this.lXl.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cBf;
        if (this.lWO != null && sparseArray != null && this.lWN != null) {
            if (this.lQQ == null) {
                this.lQQ = new i(this.lWO.getPageContext(), this.lWN, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lWj != null && (cBf = this.lWj.cBf()) != null && cBf.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBf.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.lQQ.setDefaultReasonArray(new String[]{this.lWO.getString(R.string.delete_thread_reason_1), this.lWO.getString(R.string.delete_thread_reason_2), this.lWO.getString(R.string.delete_thread_reason_3), this.lWO.getString(R.string.delete_thread_reason_4), this.lWO.getString(R.string.delete_thread_reason_5)});
            this.lQQ.setData(atVar);
            this.lQQ.Fj("4");
            this.lQQ.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    String S = au.S(jSONArray);
                    if (a.this.lXl != null) {
                        a.this.lXl.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI(final boolean z) {
        if (this.gpZ != null) {
            if (!z) {
                this.gpZ.setEnabled(z);
            } else {
                this.gpZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gpZ.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lXk = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lXl = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.lWO.showToast(this.lWO.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.lWO.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bCn() != null) {
            this.kJK = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.lWP.addView(hVar.bCn(), layoutParams);
            this.kJK.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void a(WriteData writeData) {
                    a.this.duK();
                }
            });
        }
    }

    public void dup() {
        if (this.gpZ != null) {
            this.lXr = this.gpZ.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uO(boolean z) {
        if (this.lWj == null || this.lWj.duN() == null) {
            return false;
        }
        if (this.lWj.dnj() != 0) {
            return false;
        }
        return (this.lVu == null || this.lVu.bmn() == null || this.lVu.bmn().boP() == null || !TextUtils.equals(this.lVu.bmn().boP().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void duq() {
        if (this.lWj != null) {
            if ((!dut() && this.lXg != null && this.lXg.isShown()) || com.baidu.tbadk.core.util.y.isEmpty(this.lXm)) {
                this.lWj.vV(false);
            } else {
                this.lWj.vV(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lWj = subPbModel;
    }

    public void vS(boolean z) {
        if (this.lWj != null && this.lWj.dun() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lXh = new BlankView(this.lWO.getPageContext().getPageActivity());
            this.fEH.addView(this.lXh, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lXh.setVisibility(0);
            this.lXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lWO.finish();
                }
            });
            this.lWM.setBlankView(this.lXh);
        }
    }

    public void dur() {
        b(this.lWO);
        this.gpZ.setNextPage(this.lXb);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yb(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dut() && this.lXg != null && this.lXg.isShown()) {
                i = (this.lXr - this.lXq) - 1;
            } else {
                i = this.lXr - this.lXq;
            }
            int count = com.baidu.tbadk.core.util.y.getCount(this.lXm);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.y.subList(this.lXm, 0, i));
            com.baidu.tbadk.core.util.y.add(arrayList, postData2);
            com.baidu.tbadk.core.util.y.add(arrayList, postData);
            this.gpZ.smoothScrollToPosition(this.lXr + 2);
            this.gpZ.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gpZ.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gpZ.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.lWM;
    }

    public void dsS() {
        if (this.lXd != null) {
            g.dismissPopupWindow(this.lXd, this.lWO.getPageContext().getPageActivity());
        }
        if (this.lXf != null) {
            this.lXf.dismiss();
        }
        if (this.lPB != null) {
            this.lPB.dismiss();
        }
        if (this.lXi != null) {
            g.b(this.lXi, this.lWO.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lWm != null) {
            this.lWm.dismiss();
        }
    }

    public void dus() {
        this.gpZ.setNextPage(this.lXb);
        this.lXb.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fux = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.fux && this.lWN != null) {
                this.lWN.setVisibility(8);
                this.gpZ.removeHeaderView(this.lWN);
                this.lXq = 1;
            }
            this.lVu = pVar;
            if (this.lVu.dnN() != null) {
                this.lVu.dnN().nmG = true;
            }
            if (this.lWN != null) {
                this.lWN.setVisibility(0);
            }
            if (pVar.bmn() != null && pVar.bmn().bnz()) {
                this.lWQ.setText(R.string.view_original);
            } else {
                this.lWQ.setText(R.string.view_subject);
            }
            if (pVar.dnN() != null) {
                this.fPC = pVar.dnN().dPh();
                if (this.fPC > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.lWO.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fPC)));
                    if (this.lWO != null) {
                        this.jnW.setText(this.lWO.dse());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.lWO.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.lWO.dun()) {
                    str = "PB";
                }
                if (pVar.dnN().bpl() != null) {
                    this.lXa.setData(this.lWO.getPageContext(), pVar.dnN().bpl(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", pVar.bDp().getId(), pVar.bDp().getName(), pVar.bmn().getId(), str));
                } else {
                    this.lXa.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lXb.startLoadData();
                this.lXs.setHasMoreData(true);
            } else {
                this.lXb.endLoadData();
                this.lXs.setHasMoreData(false);
            }
            this.lXm = pVar.dnV();
            if (this.lXm == null || this.lXm.size() <= lWL) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lXm.size() - lWL;
                HI(size);
                int firstVisiblePosition = this.gpZ.getFirstVisiblePosition() - size;
                View childAt = this.gpZ.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lXm);
            if (com.baidu.tbadk.core.util.y.isEmpty(this.lXm)) {
                this.gpZ.setNextPage(null);
                if (this.fux) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.gpZ.setNextPage(this.lXb);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fux) {
                arrayList.add(0, pVar.dnN());
            }
            this.lXs.a(this.lVu.bmn(), arrayList);
            a(pVar, pVar.dnN(), pVar.Yh(), pVar.bkY(), i, z);
            if (i4 > 0) {
                this.gpZ.setSelectionFromTop(i3, i2);
            } else if (z2 && !au.isEmpty(this.lWO.duo().dqj())) {
                String dqj = this.lWO.duo().dqj();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dqj.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gpZ.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gpZ.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gpZ.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.lVu.dnS() > 1) {
                this.gpZ.setPullRefresh(this.lPx);
                this.lWM.setEnableDragExit(false);
                return;
            }
            this.gpZ.setPullRefresh(null);
            this.lWM.setEnableDragExit(true);
        }
    }

    private void HI(int i) {
        if (this.lXm != null) {
            if (this.lXm.size() <= i) {
                this.lXm.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lXm.iterator();
            while (it.hasNext()) {
                it.next();
                i2++;
                it.remove();
                if (i2 >= i) {
                    return;
                }
            }
        }
    }

    public boolean dut() {
        return this.lXs.aJj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fux) {
            if (!StringUtils.isNull(postData.dPo())) {
                this.lWY.setVisibility(0);
                this.lWY.startLoad(postData.dPo(), 10, true);
            } else {
                this.lWY.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dPq = postData.dPq();
            if (dPq != null && dPq.nlr) {
                this.lWZ.setVisibility(0);
            } else {
                this.lWZ.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.lWN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.lWN.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.lWV.setText((CharSequence) null);
            this.eBQ.setText((CharSequence) null);
            this.lSB.setVisibility(8);
            if (!this.fux) {
                c(postData.boP());
                if (z) {
                    this.lSB.setVisibility(0);
                    ap.setViewTextColor(this.lSB, R.color.CAM_X0302);
                }
            }
            this.lWW.setText(au.getFormatTime(postData.getTime()));
            String format = String.format(this.lWO.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dPh()));
            if (pVar.bmn() != null && pVar.bmn().bnz()) {
                this.lWV.setText((CharSequence) null);
            } else {
                this.lWV.setText(format);
            }
            postData.boP().getUserTbVipInfoData();
            boolean a2 = a(this.lWX, postData.dPj());
            if (StringUtils.isNull(postData.dPo()) && !a2 && postData.bIK() != null) {
                this.alB.setVisibility(0);
                this.alB.setTag(postData.bIK());
                return;
            }
            this.alB.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ae.getTextLength(name_show) > 14) {
                str = ae.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.eBQ.setText(ea(metaData.getSealPrefix(), str));
            } else {
                this.eBQ.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.lWT != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.lWT.setVisibility(8);
                } else {
                    this.lWT.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ezB = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.lWT.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.eBQ, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.eBQ, R.color.CAM_X0108);
            }
            this.lWS.setVisibility(0);
            this.lWS.setUserId(metaData.getUserId());
            this.lWS.setUserName(metaData.getUserName());
            this.lWS.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.lWS, metaData);
            this.lWS.startLoad(metaData.getAvater(), 28, false);
            this.lWR.setTag(R.id.tag_user_id, metaData.getUserId());
            this.lWR.setTag(R.id.tag_user_name, metaData.getUserName());
            this.lWR.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bIC() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bIC().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.q(next.bIJ());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.lp(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dXS());
                        continue;
                    case 17:
                        String str = next.bIN().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.q("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.bIR()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bIJ() == null || tbRichTextData.bIJ().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bIJ());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.lWO.getPageContext().getString(R.string.refresh_view_button_text), this.eAI));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.lWO.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.lWP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gpZ.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kJK.bDv();
        ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.lWO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void Ed(int i) {
        b(NoDataViewFactory.d.dZ(null, this.lWO.getResources().getString(R.string.refresh_view_title_text)));
        this.lXn.setVisibility(8);
    }

    public void Jk(String str) {
        b(NoDataViewFactory.d.dZ(str, this.lWO.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lXn.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gpZ.setVisibility(0);
            this.lXn.setVisibility(0);
            this.lWM.setOnTouchListener(null);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        this.eAI = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                if (i != 3) {
                    z = true;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                String userId2 = postData.boP().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = false;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.lVu != null && this.lVu.bmn() != null && this.lVu.bmn().boP() != null && postData.boP() != null) {
                String userId3 = this.lVu.bmn().boP().getUserId();
                String userId4 = postData.boP().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = false;
                        z3 = true;
                        z4 = true;
                    } else {
                        z5 = true;
                        z3 = false;
                        z4 = true;
                    }
                    userId = postData.boP().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dPh() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.boP() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.boP().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.boP().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.boP().getPortrait());
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.boP() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.boP().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.boP().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.boP().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.boP() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.boP().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.boP().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.boP().getName_show());
                        }
                        if (this.lVu.bmn() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lVu.bmn().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.boP().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dPh() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void vT(boolean z) {
        if (this.lWm != null && this.lWm.drl() != null) {
            if (z) {
                this.lWm.drl().setText(R.string.remove_mark);
            } else {
                this.lWm.drl().setText(R.string.mark);
            }
        }
    }

    public View duu() {
        return this.lXg;
    }

    public void onChangeSkinType(int i) {
        this.lWO.getLayoutMode().setNightMode(i == 1);
        this.lWO.getLayoutMode().onModeChanged(this.lWM);
        this.lWO.getLayoutMode().onModeChanged(this.lWN);
        ap.setBackgroundColor(this.lWM, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lWP, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.lWO.getPageContext(), i);
        WebPManager.a(this.eAD, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.lWQ != null) {
            ap.setViewTextColor(this.lWQ, R.color.goto_see_subject_color);
        }
        this.fEG.onChangeSkinType(this.lWO.getPageContext(), i);
        this.lWO.getLayoutMode().onModeChanged(this.lXg);
        ap.setViewTextColor(this.lWX, R.color.CAM_X0105);
        this.lWX.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        if (this.kJK != null && this.kJK.bCn() != null) {
            this.kJK.bCn().onChangeSkinType(i);
        }
        this.lXb.changeSkin(i);
        this.alB.bvs();
        ap.setViewTextColor(this.jnW, R.color.CAM_X0110);
        ap.setViewTextColor(this.lSB, R.color.CAM_X0302);
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0108);
        this.jnW.setAlpha(0.95f);
        if (this.lXc != null) {
            com.baidu.tbadk.r.a.a(this.lWO.getPageContext(), this.lXc);
        }
        if (this.lXs != null) {
            this.lXs.notifyDataSetChanged();
        }
        this.lWO.getLayoutMode().onModeChanged(this.lXe);
        ap.setBackgroundColor(this.lPQ, R.color.CAM_X0203);
        this.lPT.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lPS.setBackgroundDrawable(ap.aR(l.getDimens(this.lWO, R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
    }

    public void duv() {
        this.mProgress.setVisibility(0);
    }

    public void duw() {
        this.gpZ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lXb.endLoadData();
    }

    public void cze() {
        this.gpZ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lXb.cze();
    }

    public boolean dux() {
        return this.lWM.dux();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lXs.c(onLongClickListener);
    }

    public View duy() {
        return this.lWN;
    }

    public TextView cIc() {
        return this.jnW;
    }

    public ImageView duz() {
        return this.lXo;
    }

    public ImageView duA() {
        return this.lXp;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void HJ(int i) {
    }

    public View duB() {
        return this.lWQ;
    }

    public View duC() {
        return this.lWY;
    }

    public MorePopupWindow duD() {
        return this.lXd;
    }

    public void showLoadingDialog() {
        if (this.iqj == null) {
            this.iqj = new com.baidu.tbadk.core.view.a(this.lWO.getPageContext());
        }
        this.iqj.setDialogVisiable(true);
    }

    public void cku() {
        if (this.iqj != null) {
            this.iqj.setDialogVisiable(false);
        }
    }

    public TextView duE() {
        return this.lWX;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lXs.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lXs != null) {
            this.lXs.notifyDataSetChanged();
        }
    }

    public ah duF() {
        return this.lWm;
    }

    public void cKv() {
    }

    public void cKw() {
    }

    public void cID() {
        if (this.lWM != null) {
            this.lWM.onDestroy();
        }
        if (this.kJK != null) {
            this.kJK.onDestory();
        }
    }

    public void duG() {
        if (this.lWO.isPaused()) {
        }
    }

    public View duH() {
        return this.lWR;
    }

    private SpannableStringBuilder ea(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.lWO.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int duI() {
        if (this.kJK == null || this.kJK.bCn() == null) {
            return 0;
        }
        return this.kJK.bCn().getHeight();
    }

    public int duJ() {
        if (this.lXh == null) {
            return 0;
        }
        return this.lXh.getHeight();
    }

    public void duK() {
        if (this.jnW != null && this.kJK != null) {
            if (this.kJK.bDA()) {
                this.jnW.setText(R.string.draft_to_send);
            } else {
                this.jnW.setText(this.lWO.dse());
            }
        }
    }

    public void vd(boolean z) {
        if (this.lPT != null) {
            this.lPT.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fci = cVar;
        if (this.lPx != null) {
            this.lPx.setListPullRefreshListener(cVar);
        }
    }
}
