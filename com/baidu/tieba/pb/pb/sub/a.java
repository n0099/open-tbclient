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
    private static final int lWJ = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener bbH;
    private ImageView eAD;
    private NoNetworkView fEG;
    private LinearLayout fEH;
    private f.c fci;
    private BdTypeListView gpX;
    private View iIw;
    private com.baidu.tbadk.core.view.a iqh;
    private com.baidu.tieba.NEGFeedBack.f jBZ;
    private TextView jnU;
    private View lPO;
    private LinearLayout lPQ;
    private HeadImageView lPR;
    private e lPv;
    private i lQO;
    private p lVs;
    private SubPbView lWK;
    private View lWL;
    private NewSubPbActivity lWM;
    private RelativeLayout lWN;
    private View lWR;
    private ThreadSkinView lWY;
    private d lWZ;
    private SubPbModel lWh;
    private ah lWk;
    private View lXa;
    private View lXc;
    private View lXe;
    private BlankView lXf;
    private com.baidu.tbadk.core.dialog.b lXh;
    private ArrayList<PostData> lXk;
    private RelativeLayout lXl;
    private ImageView lXm;
    private ImageView lXn;
    private c lXq;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eAI = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lWO = null;
    private LinearLayout lWP = null;
    private HeadImageView lWQ = null;
    private TextView eBQ = null;
    private ImageView lWS = null;
    private TextView lSz = null;
    private TextView lWT = null;
    private TextView lWU = null;
    private EllipsizeRichTextView lWV = null;
    private TbImageView lWW = null;
    private PlayVoiceBntNew alB = null;
    private TextView lWX = null;
    private MorePopupWindow lXb = null;
    private com.baidu.tbadk.core.dialog.b lXd = null;
    private Dialog lXg = null;
    private com.baidu.tbadk.core.dialog.a lPz = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lXi = null;
    private NewSubPbActivity.a lXj = null;
    private h kJI = null;
    private int fPC = 0;
    private int lXo = 2;
    private int lXp = 0;
    private boolean fux = true;
    private boolean lHP = com.baidu.tbadk.a.d.bkr();
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
    protected AdapterView.OnItemLongClickListener lXr = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.lXk, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lWk == null) {
                    a.this.lWk = new ah(a.this.lWM.getPageContext(), a.this.bbH);
                }
                a.this.lWk.RU();
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
                ah ahVar = a.this.lWk;
                int dni = a.this.lWh.dni();
                if (!a.this.lHP || postData2 == null || !postData2.nmE) {
                    z = false;
                }
                ahVar.a(sparseArray, dni, z2, z);
                if (z2) {
                    a.this.lWk.drm().setVisibility(0);
                    a.this.lWk.drm().setTag(postData.getId());
                } else {
                    a.this.lWk.drm().setVisibility(8);
                }
                a.this.lWk.drk().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lXs = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.lWM != null && bh.checkUpIsLogin(a.this.lWM.getPageContext().getPageActivity())) {
                if ((a.this.lWM.kJC == null || a.this.lWh == null || a.this.lWh.cBe() == null || a.this.lWM.kJC.pP(a.this.lWh.cBe().replyPrivateFlag)) && a.this.lWh != null && a.this.kJI != null) {
                    a.this.duo();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.duq();
                        a.this.lWh.duP();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kJI.setReplyId(str2);
                            a.this.kJI.Ec(str);
                        }
                    }
                    a.this.dup();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.lWK = null;
        this.lWL = null;
        this.gpX = null;
        this.lPv = null;
        this.lWM = null;
        this.fEG = null;
        this.lWN = null;
        this.lWR = null;
        this.lWZ = null;
        this.lXe = null;
        this.bbH = null;
        this.mProgress = null;
        this.jnU = null;
        this.lXl = null;
        this.lXm = null;
        this.lXn = null;
        this.lWM = newSubPbActivity;
        this.bbH = onClickListener;
        this.lWK = (SubPbView) LayoutInflater.from(this.lWM.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.lWL = LayoutInflater.from(this.lWM.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fEH = (LinearLayout) this.lWK.findViewById(R.id.navigation_bar_group);
        this.lXl = (RelativeLayout) this.lWK.findViewById(R.id.subpb_editor_tool_comment);
        this.jnU = (TextView) this.lWK.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jnU.setOnClickListener(this.bbH);
        this.lXm = (ImageView) this.lWK.findViewById(R.id.subpb_editor_tool_more_img);
        this.lXn = (ImageView) this.lWK.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lXn.setOnClickListener(this.bbH);
        this.lXm.setOnClickListener(this.bbH);
        this.fEG = (NoNetworkView) this.lWK.findViewById(R.id.view_no_network);
        cHW();
        bWW();
        this.lWN = (RelativeLayout) this.lWK.findViewById(R.id.sub_pb_body_layout);
        this.gpX = (BdTypeListView) this.lWK.findViewById(R.id.new_sub_pb_list);
        this.lWY = (ThreadSkinView) LayoutInflater.from(this.lWM.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gpX.addHeaderView(this.lWY);
        this.gpX.addHeaderView(this.lWL);
        this.iIw = new TextView(newSubPbActivity.getActivity());
        this.iIw.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gpX.addHeaderView(this.iIw, 0);
        this.lWK.setTopView(this.iIw);
        this.lWK.setNavigationView(this.fEH);
        this.lWK.setListView(this.gpX);
        this.lWK.setContentView(this.lWN);
        this.lWZ = new d(this.lWM.getPageContext());
        this.lWZ.setLineGone();
        this.lXe = this.lWZ.getView();
        this.gpX.setNextPage(this.lWZ);
        this.lWZ.setOnClickListener(this.bbH);
        this.gpX.setOnItemClickListener(this.lXs);
        this.gpX.setOnItemLongClickListener(this.lXr);
        this.gpX.setOnTouchListener(this.fos);
        this.lPv = new e(newSubPbActivity.getPageContext());
        this.lPv.createView();
        this.lPv.setListPullRefreshListener(this.fci);
        this.lPv.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.lWK.findViewById(R.id.progress);
        this.lPO = this.lWK.findViewById(R.id.view_comment_top_line);
        this.lPQ = (LinearLayout) this.lWK.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lPR = (HeadImageView) this.lWK.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lPR.setVisibility(0);
        this.lPR.setIsRound(true);
        this.lPR.setBorderWidth(l.getDimens(this.lWM, R.dimen.L_X01));
        this.lPR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lPR.setDefaultBgResource(0);
        this.lPR.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lPR.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lWL != null) {
            this.lWL.setVisibility(4);
        }
        this.lWR = com.baidu.tbadk.ala.b.bkP().z(this.lWM.getActivity(), 4);
        if (this.lWR != null) {
            this.lWR.setVisibility(8);
            this.lWP.addView(this.lWR, 3);
        }
        this.lXq = new c(this.lWM, this.gpX);
        this.lXq.setFromCDN(this.mIsFromCDN);
        this.lXq.B(this.bbH);
        this.lXq.Nt();
    }

    public ListView getListView() {
        return this.gpX;
    }

    public void bWW() {
        this.lWP = (LinearLayout) this.lWL.findViewById(R.id.subpb_head_user_info_root);
        this.lWP.setOnClickListener(this.bbH);
        this.lWQ = (HeadImageView) this.lWL.findViewById(R.id.photo);
        this.lWQ.setRadius(l.getDimens(this.lWM.getActivity(), R.dimen.tbds45));
        this.lWQ.setClickable(false);
        this.eBQ = (TextView) this.lWL.findViewById(R.id.user_name);
        this.lWS = (ImageView) this.lWL.findViewById(R.id.user_rank);
        this.lWS.setVisibility(8);
        this.lSz = (TextView) this.lWL.findViewById(R.id.floor_owner);
        this.lWO = (TextView) this.lWL.findViewById(R.id.see_subject);
        this.lWO.setOnClickListener(this.bbH);
        this.lWT = (TextView) this.lWL.findViewById(R.id.floor);
        this.lWU = (TextView) this.lWL.findViewById(R.id.time);
        this.lWV = (EllipsizeRichTextView) this.lWL.findViewById(R.id.content_text);
        this.lWV.setOnClickListener(this.bbH);
        ap.setViewTextColor(this.lWV, R.color.CAM_X0105);
        this.lWV.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.lWV.setLineSpacing(0.0f, 1.25f);
        this.lWW = (TbImageView) this.lWL.findViewById(R.id.sub_pb_image);
        this.lWW.setOnClickListener(this.bbH);
        this.lWX = (TextView) this.lWL.findViewById(R.id.advert);
        this.alB = (PlayVoiceBntNew) this.lWL.findViewById(R.id.voice_btn);
        this.lWL.setOnTouchListener(this.fos);
        this.lWL.setOnClickListener(this.bbH);
    }

    public void a(b.InterfaceC0586b interfaceC0586b, boolean z) {
        if (this.lXh != null) {
            this.lXh.dismiss();
            this.lXh = null;
        }
        this.lXh = new com.baidu.tbadk.core.dialog.b(this.lWM.getPageContext().getPageActivity());
        if (z) {
            this.lXh.a(new String[]{this.lWM.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0586b);
        } else {
            this.lXh.a(new String[]{this.lWM.getPageContext().getString(R.string.save_to_emotion), this.lWM.getPageContext().getString(R.string.save_to_local)}, interfaceC0586b);
        }
        this.lXh.d(this.lWM.getPageContext());
        this.lXh.brx();
    }

    public void dH(View view) {
        this.lXa = view;
    }

    public void cHW() {
        int dimens = l.getDimens(this.lWM.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.lWM.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.lWK.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lXf != null) {
                    a.this.lWK.onFinish();
                } else {
                    a.this.lWM.finish();
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
        if (this.lXg == null) {
            this.lXg = new Dialog(this.lWM.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lXg.setCanceledOnTouchOutside(true);
            this.lXg.setCancelable(true);
            this.lXc = LayoutInflater.from(this.lWM.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.lWM.getLayoutMode().onModeChanged(this.lXc);
            this.lXg.setContentView(this.lXc);
            WindowManager.LayoutParams attributes = this.lXg.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.lWM.getPageContext().getPageActivity()) * 0.9d);
            this.lXg.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lXg.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lXg.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lXg.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.lXg != null && (a.this.lXg instanceof Dialog)) {
                        g.b(a.this.lXg, a.this.lWM.getPageContext());
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
                    if (a.this.lXg != null && (a.this.lXg instanceof Dialog)) {
                        g.b(a.this.lXg, a.this.lWM.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lXi != null) {
                        a.this.lXi.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.lXg != null && (a.this.lXg instanceof Dialog)) {
                        g.b(a.this.lXg, a.this.lWM.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.lWM.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lXg, this.lWM.getPageContext());
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
        this.lPz = new com.baidu.tbadk.core.dialog.a(this.lWM.getPageContext().getPageActivity());
        this.lPz.oQ(i3);
        this.lPz.setYesButtonTag(sparseArray);
        this.lPz.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lXj != null) {
                    a.this.lXj.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lPz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lPz.jl(true);
        this.lPz.b(this.lWM.getPageContext());
        if (z) {
            this.lPz.brv();
        } else if (1 == this.lWh.dvh()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lWh.dvh(), this.lWh.dvg(), this.lWh.bLx());
            hVar.ek(this.lVs.bDp().getId(), this.lVs.bDp().getName());
            hVar.setForumHeadUrl(this.lWh.bLA());
            hVar.setUserLevel(this.lWh.bLB());
            UserData userData = new UserData();
            userData.setIsManager(this.lWh.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData cBe;
        if (this.lWM != null && sparseArray != null && this.lWL != null) {
            if (this.jBZ == null) {
                this.jBZ = new com.baidu.tieba.NEGFeedBack.f(this.lWM.getPageContext(), this.lWL);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lWh != null && (cBe = this.lWh.cBe()) != null && cBe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBe.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.jBZ.setDefaultReasonArray(new String[]{this.lWM.getString(R.string.delete_thread_reason_1), this.lWM.getString(R.string.delete_thread_reason_2), this.lWM.getString(R.string.delete_thread_reason_3), this.lWM.getString(R.string.delete_thread_reason_4), this.lWM.getString(R.string.delete_thread_reason_5)});
            this.jBZ.setData(atVar);
            this.jBZ.Fj("4");
            this.jBZ.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    String S = au.S(jSONArray);
                    if (a.this.lXj != null) {
                        a.this.lXj.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cBe;
        if (this.lWM != null && sparseArray != null && this.lWL != null) {
            if (this.lQO == null) {
                this.lQO = new i(this.lWM.getPageContext(), this.lWL, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lWh != null && (cBe = this.lWh.cBe()) != null && cBe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBe.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.lQO.setDefaultReasonArray(new String[]{this.lWM.getString(R.string.delete_thread_reason_1), this.lWM.getString(R.string.delete_thread_reason_2), this.lWM.getString(R.string.delete_thread_reason_3), this.lWM.getString(R.string.delete_thread_reason_4), this.lWM.getString(R.string.delete_thread_reason_5)});
            this.lQO.setData(atVar);
            this.lQO.Fj("4");
            this.lQO.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    String S = au.S(jSONArray);
                    if (a.this.lXj != null) {
                        a.this.lXj.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI(final boolean z) {
        if (this.gpX != null) {
            if (!z) {
                this.gpX.setEnabled(z);
            } else {
                this.gpX.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gpX.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lXi = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lXj = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.lWM.showToast(this.lWM.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.lWM.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bCn() != null) {
            this.kJI = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.lWN.addView(hVar.bCn(), layoutParams);
            this.kJI.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void a(WriteData writeData) {
                    a.this.duJ();
                }
            });
        }
    }

    public void duo() {
        if (this.gpX != null) {
            this.lXp = this.gpX.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uO(boolean z) {
        if (this.lWh == null || this.lWh.duM() == null) {
            return false;
        }
        if (this.lWh.dni() != 0) {
            return false;
        }
        return (this.lVs == null || this.lVs.bmn() == null || this.lVs.bmn().boP() == null || !TextUtils.equals(this.lVs.bmn().boP().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dup() {
        if (this.lWh != null) {
            if ((!dus() && this.lXe != null && this.lXe.isShown()) || com.baidu.tbadk.core.util.y.isEmpty(this.lXk)) {
                this.lWh.vV(false);
            } else {
                this.lWh.vV(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lWh = subPbModel;
    }

    public void vS(boolean z) {
        if (this.lWh != null && this.lWh.dum() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lXf = new BlankView(this.lWM.getPageContext().getPageActivity());
            this.fEH.addView(this.lXf, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lXf.setVisibility(0);
            this.lXf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lWM.finish();
                }
            });
            this.lWK.setBlankView(this.lXf);
        }
    }

    public void duq() {
        b(this.lWM);
        this.gpX.setNextPage(this.lWZ);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yb(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dus() && this.lXe != null && this.lXe.isShown()) {
                i = (this.lXp - this.lXo) - 1;
            } else {
                i = this.lXp - this.lXo;
            }
            int count = com.baidu.tbadk.core.util.y.getCount(this.lXk);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.y.subList(this.lXk, 0, i));
            com.baidu.tbadk.core.util.y.add(arrayList, postData2);
            com.baidu.tbadk.core.util.y.add(arrayList, postData);
            this.gpX.smoothScrollToPosition(this.lXp + 2);
            this.gpX.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gpX.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gpX.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.lWK;
    }

    public void dsR() {
        if (this.lXb != null) {
            g.dismissPopupWindow(this.lXb, this.lWM.getPageContext().getPageActivity());
        }
        if (this.lXd != null) {
            this.lXd.dismiss();
        }
        if (this.lPz != null) {
            this.lPz.dismiss();
        }
        if (this.lXg != null) {
            g.b(this.lXg, this.lWM.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lWk != null) {
            this.lWk.dismiss();
        }
    }

    public void dur() {
        this.gpX.setNextPage(this.lWZ);
        this.lWZ.startLoadData();
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
            if (this.fux && this.lWL != null) {
                this.lWL.setVisibility(8);
                this.gpX.removeHeaderView(this.lWL);
                this.lXo = 1;
            }
            this.lVs = pVar;
            if (this.lVs.dnM() != null) {
                this.lVs.dnM().nmE = true;
            }
            if (this.lWL != null) {
                this.lWL.setVisibility(0);
            }
            if (pVar.bmn() != null && pVar.bmn().bnz()) {
                this.lWO.setText(R.string.view_original);
            } else {
                this.lWO.setText(R.string.view_subject);
            }
            if (pVar.dnM() != null) {
                this.fPC = pVar.dnM().dPg();
                if (this.fPC > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.lWM.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fPC)));
                    if (this.lWM != null) {
                        this.jnU.setText(this.lWM.dsd());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.lWM.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.lWM.dum()) {
                    str = "PB";
                }
                if (pVar.dnM().bpl() != null) {
                    this.lWY.setData(this.lWM.getPageContext(), pVar.dnM().bpl(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", pVar.bDp().getId(), pVar.bDp().getName(), pVar.bmn().getId(), str));
                } else {
                    this.lWY.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lWZ.startLoadData();
                this.lXq.setHasMoreData(true);
            } else {
                this.lWZ.endLoadData();
                this.lXq.setHasMoreData(false);
            }
            this.lXk = pVar.dnU();
            if (this.lXk == null || this.lXk.size() <= lWJ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lXk.size() - lWJ;
                HI(size);
                int firstVisiblePosition = this.gpX.getFirstVisiblePosition() - size;
                View childAt = this.gpX.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lXk);
            if (com.baidu.tbadk.core.util.y.isEmpty(this.lXk)) {
                this.gpX.setNextPage(null);
                if (this.fux) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.gpX.setNextPage(this.lWZ);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fux) {
                arrayList.add(0, pVar.dnM());
            }
            this.lXq.a(this.lVs.bmn(), arrayList);
            a(pVar, pVar.dnM(), pVar.Yh(), pVar.bkY(), i, z);
            if (i4 > 0) {
                this.gpX.setSelectionFromTop(i3, i2);
            } else if (z2 && !au.isEmpty(this.lWM.dun().dqi())) {
                String dqi = this.lWM.dun().dqi();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dqi.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gpX.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gpX.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gpX.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.lVs.dnR() > 1) {
                this.gpX.setPullRefresh(this.lPv);
                this.lWK.setEnableDragExit(false);
                return;
            }
            this.gpX.setPullRefresh(null);
            this.lWK.setEnableDragExit(true);
        }
    }

    private void HI(int i) {
        if (this.lXk != null) {
            if (this.lXk.size() <= i) {
                this.lXk.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lXk.iterator();
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

    public boolean dus() {
        return this.lXq.aJj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fux) {
            if (!StringUtils.isNull(postData.dPn())) {
                this.lWW.setVisibility(0);
                this.lWW.startLoad(postData.dPn(), 10, true);
            } else {
                this.lWW.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dPp = postData.dPp();
            if (dPp != null && dPp.nlp) {
                this.lWX.setVisibility(0);
            } else {
                this.lWX.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.lWL.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.lWL.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.lWT.setText((CharSequence) null);
            this.eBQ.setText((CharSequence) null);
            this.lSz.setVisibility(8);
            if (!this.fux) {
                c(postData.boP());
                if (z) {
                    this.lSz.setVisibility(0);
                    ap.setViewTextColor(this.lSz, R.color.CAM_X0302);
                }
            }
            this.lWU.setText(au.getFormatTime(postData.getTime()));
            String format = String.format(this.lWM.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dPg()));
            if (pVar.bmn() != null && pVar.bmn().bnz()) {
                this.lWT.setText((CharSequence) null);
            } else {
                this.lWT.setText(format);
            }
            postData.boP().getUserTbVipInfoData();
            boolean a2 = a(this.lWV, postData.dPi());
            if (StringUtils.isNull(postData.dPn()) && !a2 && postData.bIK() != null) {
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
            if (metaData.getAlaUserData() != null && this.lWR != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.lWR.setVisibility(8);
                } else {
                    this.lWR.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ezB = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.lWR.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.eBQ, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.eBQ, R.color.CAM_X0108);
            }
            this.lWQ.setVisibility(0);
            this.lWQ.setUserId(metaData.getUserId());
            this.lWQ.setUserName(metaData.getUserName());
            this.lWQ.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.lWQ, metaData);
            this.lWQ.startLoad(metaData.getAvater(), 28, false);
            this.lWP.setTag(R.id.tag_user_id, metaData.getUserId());
            this.lWP.setTag(R.id.tag_user_name, metaData.getUserName());
            this.lWP.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.c.dXR());
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
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.lWM.getPageContext().getString(R.string.refresh_view_button_text), this.eAI));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.lWM.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.lWN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gpX.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kJI.bDv();
        ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.lWM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void Ed(int i) {
        b(NoDataViewFactory.d.dZ(null, this.lWM.getResources().getString(R.string.refresh_view_title_text)));
        this.lXl.setVisibility(8);
    }

    public void Jk(String str) {
        b(NoDataViewFactory.d.dZ(str, this.lWM.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lXl.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gpX.setVisibility(0);
            this.lXl.setVisibility(0);
            this.lWK.setOnTouchListener(null);
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
            if (this.lVs != null && this.lVs.bmn() != null && this.lVs.bmn().boP() != null && postData.boP() != null) {
                String userId3 = this.lVs.bmn().boP().getUserId();
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
                    int i2 = postData.dPg() != 1 ? 0 : 1;
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
                        if (this.lVs.bmn() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lVs.bmn().getId());
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
            if (postData.dPg() != 1) {
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
        if (this.lWk != null && this.lWk.drk() != null) {
            if (z) {
                this.lWk.drk().setText(R.string.remove_mark);
            } else {
                this.lWk.drk().setText(R.string.mark);
            }
        }
    }

    public View dut() {
        return this.lXe;
    }

    public void onChangeSkinType(int i) {
        this.lWM.getLayoutMode().setNightMode(i == 1);
        this.lWM.getLayoutMode().onModeChanged(this.lWK);
        this.lWM.getLayoutMode().onModeChanged(this.lWL);
        ap.setBackgroundColor(this.lWK, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lWN, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.lWM.getPageContext(), i);
        WebPManager.a(this.eAD, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.lWO != null) {
            ap.setViewTextColor(this.lWO, R.color.goto_see_subject_color);
        }
        this.fEG.onChangeSkinType(this.lWM.getPageContext(), i);
        this.lWM.getLayoutMode().onModeChanged(this.lXe);
        ap.setViewTextColor(this.lWV, R.color.CAM_X0105);
        this.lWV.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        if (this.kJI != null && this.kJI.bCn() != null) {
            this.kJI.bCn().onChangeSkinType(i);
        }
        this.lWZ.changeSkin(i);
        this.alB.bvs();
        ap.setViewTextColor(this.jnU, R.color.CAM_X0110);
        ap.setViewTextColor(this.lSz, R.color.CAM_X0302);
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0108);
        this.jnU.setAlpha(0.95f);
        if (this.lXa != null) {
            com.baidu.tbadk.r.a.a(this.lWM.getPageContext(), this.lXa);
        }
        if (this.lXq != null) {
            this.lXq.notifyDataSetChanged();
        }
        this.lWM.getLayoutMode().onModeChanged(this.lXc);
        ap.setBackgroundColor(this.lPO, R.color.CAM_X0203);
        this.lPR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lPQ.setBackgroundDrawable(ap.aR(l.getDimens(this.lWM, R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
    }

    public void duu() {
        this.mProgress.setVisibility(0);
    }

    public void duv() {
        this.gpX.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lWZ.endLoadData();
    }

    public void czd() {
        this.gpX.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lWZ.czd();
    }

    public boolean duw() {
        return this.lWK.duw();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lXq.c(onLongClickListener);
    }

    public View dux() {
        return this.lWL;
    }

    public TextView cIb() {
        return this.jnU;
    }

    public ImageView duy() {
        return this.lXm;
    }

    public ImageView duz() {
        return this.lXn;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void HJ(int i) {
    }

    public View duA() {
        return this.lWO;
    }

    public View duB() {
        return this.lWW;
    }

    public MorePopupWindow duC() {
        return this.lXb;
    }

    public void showLoadingDialog() {
        if (this.iqh == null) {
            this.iqh = new com.baidu.tbadk.core.view.a(this.lWM.getPageContext());
        }
        this.iqh.setDialogVisiable(true);
    }

    public void ckt() {
        if (this.iqh != null) {
            this.iqh.setDialogVisiable(false);
        }
    }

    public TextView duD() {
        return this.lWV;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lXq.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lXq != null) {
            this.lXq.notifyDataSetChanged();
        }
    }

    public ah duE() {
        return this.lWk;
    }

    public void cKu() {
    }

    public void cKv() {
    }

    public void cIC() {
        if (this.lWK != null) {
            this.lWK.onDestroy();
        }
        if (this.kJI != null) {
            this.kJI.onDestory();
        }
    }

    public void duF() {
        if (this.lWM.isPaused()) {
        }
    }

    public View duG() {
        return this.lWP;
    }

    private SpannableStringBuilder ea(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.lWM.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int duH() {
        if (this.kJI == null || this.kJI.bCn() == null) {
            return 0;
        }
        return this.kJI.bCn().getHeight();
    }

    public int duI() {
        if (this.lXf == null) {
            return 0;
        }
        return this.lXf.getHeight();
    }

    public void duJ() {
        if (this.jnU != null && this.kJI != null) {
            if (this.kJI.bDA()) {
                this.jnU.setText(R.string.draft_to_send);
            } else {
                this.jnU.setText(this.lWM.dsd());
            }
        }
    }

    public void vd(boolean z) {
        if (this.lPR != null) {
            this.lPR.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fci = cVar;
        if (this.lPv != null) {
            this.lPv.setListPullRefreshListener(cVar);
        }
    }
}
