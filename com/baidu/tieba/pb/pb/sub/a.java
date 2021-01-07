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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.aa;
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
/* loaded from: classes2.dex */
public class a implements KeyboardEventLayout.a {
    private static final int mca = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener bdp;
    private ImageView eKg;
    private NoNetworkView fOl;
    private LinearLayout fOm;
    private f.c flR;
    private BdTypeListView gAY;
    private com.baidu.tbadk.core.view.a iCD;
    private View iUJ;
    private TextView jAu;
    private com.baidu.tieba.NEGFeedBack.f jOD;
    private e lUI;
    private View lVc;
    private LinearLayout lVe;
    private HeadImageView lVf;
    private i lWc;
    private ProgressBar mProgress;
    private p maI;
    private aa mbA;
    private SubPbModel mbx;
    private ArrayList<PostData> mcB;
    private RelativeLayout mcC;
    private ImageView mcD;
    private ImageView mcE;
    private c mcH;
    private SubPbView mcb;
    private View mcc;
    private NewSubPbActivity mcd;
    private RelativeLayout mce;
    private View mci;
    private ThreadSkinView mcp;
    private d mcq;
    private View mcr;
    private View mct;
    private View mcv;
    private BlankView mcw;
    private com.baidu.tbadk.core.dialog.b mcy;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eKl = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mcf = null;
    private LinearLayout mcg = null;
    private HeadImageView mch = null;
    private TextView eLt = null;
    private ImageView mcj = null;
    private TextView lXM = null;
    private TextView mck = null;
    private TextView mcl = null;
    private EllipsizeRichTextView mcm = null;
    private TbImageView mcn = null;
    private PlayVoiceBntNew amd = null;
    private TextView mco = null;
    private MorePopupWindow mcs = null;
    private com.baidu.tbadk.core.dialog.b mcu = null;
    private Dialog mcx = null;
    private com.baidu.tbadk.core.dialog.a lUN = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a mcz = null;
    private NewSubPbActivity.a mcA = null;
    private h kOT = null;
    private int fZf = 0;
    private int mcF = 2;
    private int mcG = 0;
    private boolean fEd = true;
    private boolean lNf = com.baidu.tbadk.a.d.bmG();
    private com.baidu.tieba.pb.a.c fyb = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.8
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rg(false);
            a.this.rg(true);
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
    protected AdapterView.OnItemLongClickListener mcI = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) x.getItem(a.this.mcB, i);
            if (view != null && view.getTag() != null) {
                if (a.this.mbA == null) {
                    a.this.mbA = new aa(a.this.mcd.getPageContext(), a.this.bdp);
                }
                a.this.mbA.SY();
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
                boolean z2 = a.this.uP(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                aa aaVar = a.this.mbA;
                int dmU = a.this.mbx.dmU();
                if (!a.this.lNf || postData2 == null || !postData2.nsr) {
                    z = false;
                }
                aaVar.a(sparseArray, dmU, z2, z);
                if (z2) {
                    a.this.mbA.dra().setVisibility(0);
                    a.this.mbA.dra().setTag(postData.getId());
                } else {
                    a.this.mbA.dra().setVisibility(8);
                }
                a.this.mbA.dqY().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener mcJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.mcd != null && bg.checkUpIsLogin(a.this.mcd.getPageContext().getPageActivity())) {
                if ((a.this.mcd.kON == null || a.this.mbx == null || a.this.mbx.cDZ() == null || a.this.mcd.kON.pZ(a.this.mbx.cDZ().replyPrivateFlag)) && a.this.mbx != null && a.this.kOT != null) {
                    a.this.duf();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.duh();
                        a.this.mbx.duG();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kOT.setReplyId(str2);
                            a.this.kOT.DY(str);
                        }
                    }
                    a.this.dug();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.mcb = null;
        this.mcc = null;
        this.gAY = null;
        this.lUI = null;
        this.mcd = null;
        this.fOl = null;
        this.mce = null;
        this.mci = null;
        this.mcq = null;
        this.mcv = null;
        this.bdp = null;
        this.mProgress = null;
        this.jAu = null;
        this.mcC = null;
        this.mcD = null;
        this.mcE = null;
        this.mcd = newSubPbActivity;
        this.bdp = onClickListener;
        this.mcb = (SubPbView) LayoutInflater.from(this.mcd.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.mcc = LayoutInflater.from(this.mcd.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fOm = (LinearLayout) this.mcb.findViewById(R.id.navigation_bar_group);
        this.mcC = (RelativeLayout) this.mcb.findViewById(R.id.subpb_editor_tool_comment);
        this.jAu = (TextView) this.mcb.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jAu.setOnClickListener(this.bdp);
        this.mcD = (ImageView) this.mcb.findViewById(R.id.subpb_editor_tool_more_img);
        this.mcE = (ImageView) this.mcb.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.mcE.setOnClickListener(this.bdp);
        this.mcD.setOnClickListener(this.bdp);
        this.fOl = (NoNetworkView) this.mcb.findViewById(R.id.view_no_network);
        cKY();
        bZD();
        this.mce = (RelativeLayout) this.mcb.findViewById(R.id.sub_pb_body_layout);
        this.gAY = (BdTypeListView) this.mcb.findViewById(R.id.new_sub_pb_list);
        this.mcp = (ThreadSkinView) LayoutInflater.from(this.mcd.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gAY.addHeaderView(this.mcp);
        this.gAY.addHeaderView(this.mcc);
        this.iUJ = new TextView(newSubPbActivity.getActivity());
        this.iUJ.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gAY.addHeaderView(this.iUJ, 0);
        this.mcb.setTopView(this.iUJ);
        this.mcb.setNavigationView(this.fOm);
        this.mcb.setListView(this.gAY);
        this.mcb.setContentView(this.mce);
        this.mcq = new d(this.mcd.getPageContext());
        this.mcq.setLineGone();
        this.mcv = this.mcq.getView();
        this.gAY.setNextPage(this.mcq);
        this.mcq.setOnClickListener(this.bdp);
        this.gAY.setOnItemClickListener(this.mcJ);
        this.gAY.setOnItemLongClickListener(this.mcI);
        this.gAY.setOnTouchListener(this.fyb);
        this.lUI = new e(newSubPbActivity.getPageContext());
        this.lUI.createView();
        this.lUI.setListPullRefreshListener(this.flR);
        this.lUI.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.mcb.findViewById(R.id.progress);
        this.lVc = this.mcb.findViewById(R.id.view_comment_top_line);
        this.lVe = (LinearLayout) this.mcb.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lVf = (HeadImageView) this.mcb.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lVf.setVisibility(0);
        this.lVf.setIsRound(true);
        this.lVf.setBorderWidth(l.getDimens(this.mcd, R.dimen.L_X01));
        this.lVf.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lVf.setDefaultBgResource(0);
        this.lVf.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lVf.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mcc != null) {
            this.mcc.setVisibility(4);
        }
        this.mci = com.baidu.tbadk.ala.b.bnp().A(this.mcd.getActivity(), 4);
        if (this.mci != null) {
            this.mci.setVisibility(8);
            this.mcg.addView(this.mci, 3);
        }
        this.mcH = new c(this.mcd, this.gAY);
        this.mcH.setFromCDN(this.mIsFromCDN);
        this.mcH.C(this.bdp);
        this.mcH.MT();
    }

    public ListView getListView() {
        return this.gAY;
    }

    public void bZD() {
        this.mcg = (LinearLayout) this.mcc.findViewById(R.id.subpb_head_user_info_root);
        this.mcg.setOnClickListener(this.bdp);
        this.mch = (HeadImageView) this.mcc.findViewById(R.id.photo);
        this.mch.setRadius(l.getDimens(this.mcd.getActivity(), R.dimen.tbds45));
        this.mch.setClickable(false);
        this.eLt = (TextView) this.mcc.findViewById(R.id.user_name);
        this.mcj = (ImageView) this.mcc.findViewById(R.id.user_rank);
        this.mcj.setVisibility(8);
        this.lXM = (TextView) this.mcc.findViewById(R.id.floor_owner);
        this.mcf = (TextView) this.mcc.findViewById(R.id.see_subject);
        this.mcf.setOnClickListener(this.bdp);
        this.mck = (TextView) this.mcc.findViewById(R.id.floor);
        this.mcl = (TextView) this.mcc.findViewById(R.id.time);
        this.mcm = (EllipsizeRichTextView) this.mcc.findViewById(R.id.content_text);
        this.mcm.setOnClickListener(this.bdp);
        ao.setViewTextColor(this.mcm, R.color.CAM_X0105);
        this.mcm.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        this.mcm.setLineSpacing(0.0f, 1.25f);
        this.mcn = (TbImageView) this.mcc.findViewById(R.id.sub_pb_image);
        this.mcn.setOnClickListener(this.bdp);
        this.mco = (TextView) this.mcc.findViewById(R.id.advert);
        this.amd = (PlayVoiceBntNew) this.mcc.findViewById(R.id.voice_btn);
        this.mcc.setOnTouchListener(this.fyb);
        this.mcc.setOnClickListener(this.bdp);
    }

    public void a(b.InterfaceC0578b interfaceC0578b, boolean z) {
        if (this.mcy != null) {
            this.mcy.dismiss();
            this.mcy = null;
        }
        this.mcy = new com.baidu.tbadk.core.dialog.b(this.mcd.getPageContext().getPageActivity());
        if (z) {
            this.mcy.a(new String[]{this.mcd.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0578b);
        } else {
            this.mcy.a(new String[]{this.mcd.getPageContext().getString(R.string.save_to_emotion), this.mcd.getPageContext().getString(R.string.save_to_local)}, interfaceC0578b);
        }
        this.mcy.d(this.mcd.getPageContext());
        this.mcy.bua();
    }

    public void dR(View view) {
        this.mcr = view;
    }

    public void cKY() {
        int dimens = l.getDimens(this.mcd.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.mcd.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.mcb.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mcw != null) {
                    a.this.mcb.onFinish();
                } else {
                    a.this.mcd.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        this.eKg = backImageView;
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

    public void dN(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.mcx == null) {
            this.mcx = new Dialog(this.mcd.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mcx.setCanceledOnTouchOutside(true);
            this.mcx.setCancelable(true);
            this.mct = LayoutInflater.from(this.mcd.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.mcd.getLayoutMode().onModeChanged(this.mct);
            this.mcx.setContentView(this.mct);
            WindowManager.LayoutParams attributes = this.mcx.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.mcd.getPageContext().getPageActivity()) * 0.9d);
            this.mcx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.mcx.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.mcx.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.mcx.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.mcx != null && (a.this.mcx instanceof Dialog)) {
                        g.b(a.this.mcx, a.this.mcd.getPageContext());
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
                    if (a.this.mcx != null && (a.this.mcx instanceof Dialog)) {
                        g.b(a.this.mcx, a.this.mcd.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.mcz != null) {
                        a.this.mcz.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.mcx != null && (a.this.mcx instanceof Dialog)) {
                        g.b(a.this.mcx, a.this.mcd.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.mcd.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.mcx, this.mcd.getPageContext());
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
        this.lUN = new com.baidu.tbadk.core.dialog.a(this.mcd.getPageContext().getPageActivity());
        this.lUN.pa(i3);
        this.lUN.setYesButtonTag(sparseArray);
        this.lUN.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.mcA != null) {
                    a.this.mcA.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lUN.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lUN.jH(true);
        this.lUN.b(this.mcd.getPageContext());
        if (z) {
            this.lUN.btY();
        } else if (1 == this.mbx.duY()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.mbx.duY(), this.mbx.duX(), this.mbx.bNR());
            hVar.ej(this.maI.bFL().getId(), this.maI.bFL().getName());
            hVar.setForumHeadUrl(this.mbx.bNU());
            hVar.setUserLevel(this.mbx.bNV());
            UserData userData = new UserData();
            userData.setIsManager(this.mbx.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            h(sparseArray);
        }
    }

    private void h(final SparseArray<Object> sparseArray) {
        AntiData cDZ;
        if (this.mcd != null && sparseArray != null && this.mcc != null) {
            if (this.jOD == null) {
                this.jOD = new com.baidu.tieba.NEGFeedBack.f(this.mcd.getPageContext(), this.mcc);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mbx != null && (cDZ = this.mbx.cDZ()) != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.jOD.setDefaultReasonArray(new String[]{this.mcd.getString(R.string.delete_thread_reason_1), this.mcd.getString(R.string.delete_thread_reason_2), this.mcd.getString(R.string.delete_thread_reason_3), this.mcd.getString(R.string.delete_thread_reason_4), this.mcd.getString(R.string.delete_thread_reason_5)});
            this.jOD.setData(atVar);
            this.jOD.Fg("4");
            this.jOD.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    String S = com.baidu.tbadk.core.util.at.S(jSONArray);
                    if (a.this.mcA != null) {
                        a.this.mcA.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cDZ;
        if (this.mcd != null && sparseArray != null && this.mcc != null) {
            if (this.lWc == null) {
                this.lWc = new i(this.mcd.getPageContext(), this.mcc, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mbx != null && (cDZ = this.mbx.cDZ()) != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.lWc.setDefaultReasonArray(new String[]{this.mcd.getString(R.string.delete_thread_reason_1), this.mcd.getString(R.string.delete_thread_reason_2), this.mcd.getString(R.string.delete_thread_reason_3), this.mcd.getString(R.string.delete_thread_reason_4), this.mcd.getString(R.string.delete_thread_reason_5)});
            this.lWc.setData(atVar);
            this.lWc.Fg("4");
            this.lWc.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    String S = com.baidu.tbadk.core.util.at.S(jSONArray);
                    if (a.this.mcA != null) {
                        a.this.mcA.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(final boolean z) {
        if (this.gAY != null) {
            if (!z) {
                this.gAY.setEnabled(z);
            } else {
                this.gAY.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gAY.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.mcz = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.mcA = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.mcd.showToast(this.mcd.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.mcd.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bEJ() != null) {
            this.kOT = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mce.addView(hVar.bEJ(), layoutParams);
            this.kOT.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    a.this.duA();
                }
            });
        }
    }

    public void duf() {
        if (this.gAY != null) {
            this.mcG = this.gAY.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uP(boolean z) {
        if (this.mbx == null || this.mbx.duD() == null) {
            return false;
        }
        if (this.mbx.dmU() != 0) {
            return false;
        }
        return (this.maI == null || this.maI.boP() == null || this.maI.boP().brr() == null || !TextUtils.equals(this.maI.boP().brr().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dug() {
        if (this.mbx != null) {
            if ((!duj() && this.mcv != null && this.mcv.isShown()) || x.isEmpty(this.mcB)) {
                this.mbx.vW(false);
            } else {
                this.mbx.vW(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.mbx = subPbModel;
    }

    public void vT(boolean z) {
        if (this.mbx != null && this.mbx.dud() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mcw = new BlankView(this.mcd.getPageContext().getPageActivity());
            this.fOm.addView(this.mcw, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.mcw.setVisibility(0);
            this.mcw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mcd.finish();
                }
            });
            this.mcb.setBlankView(this.mcw);
        }
    }

    public void duh() {
        b(this.mcd);
        this.gAY.setNextPage(this.mcq);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yg(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!duj() && this.mcv != null && this.mcv.isShown()) {
                i = (this.mcG - this.mcF) - 1;
            } else {
                i = this.mcG - this.mcF;
            }
            int count = x.getCount(this.mcB);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(x.subList(this.mcB, 0, i));
            x.add(arrayList, postData2);
            x.add(arrayList, postData);
            this.gAY.smoothScrollToPosition(this.mcG + 2);
            this.gAY.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gAY.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.mcb;
    }

    public void dsH() {
        if (this.mcs != null) {
            g.dismissPopupWindow(this.mcs, this.mcd.getPageContext().getPageActivity());
        }
        if (this.mcu != null) {
            this.mcu.dismiss();
        }
        if (this.lUN != null) {
            this.lUN.dismiss();
        }
        if (this.mcx != null) {
            g.b(this.mcx, this.mcd.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mbA != null) {
            this.mbA.dismiss();
        }
    }

    public void dui() {
        this.gAY.setNextPage(this.mcq);
        this.mcq.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fEd = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.fEd && this.mcc != null) {
                this.mcc.setVisibility(8);
                this.gAY.removeHeaderView(this.mcc);
                this.mcF = 1;
            }
            this.maI = pVar;
            if (this.maI.dny() != null) {
                this.maI.dny().nsr = true;
            }
            if (this.mcc != null) {
                this.mcc.setVisibility(0);
            }
            if (pVar.boP() != null && pVar.boP().bqa()) {
                this.mcf.setText(R.string.view_original);
            } else {
                this.mcf.setText(R.string.view_subject);
            }
            if (pVar.dny() != null) {
                this.fZf = pVar.dny().dPe();
                if (this.fZf > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.mcd.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fZf)));
                    if (this.mcd != null) {
                        this.jAu.setText(this.mcd.drR());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.mcd.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.mcd.dud()) {
                    str = "PB";
                }
                if (pVar.dny().brM() != null) {
                    this.mcp.setData(this.mcd.getPageContext(), pVar.dny().brM(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", pVar.bFL().getId(), pVar.bFL().getName(), pVar.boP().getId(), str));
                } else {
                    this.mcp.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.mcq.startLoadData();
                this.mcH.setHasMoreData(true);
            } else {
                this.mcq.endLoadData();
                this.mcH.setHasMoreData(false);
            }
            this.mcB = pVar.dnG();
            if (this.mcB == null || this.mcB.size() <= mca) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.mcB.size() - mca;
                HB(size);
                int firstVisiblePosition = this.gAY.getFirstVisiblePosition() - size;
                View childAt = this.gAY.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mcB);
            if (x.isEmpty(this.mcB)) {
                this.gAY.setNextPage(null);
                if (this.fEd) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.a.a());
                }
            } else {
                this.gAY.setNextPage(this.mcq);
            }
            com.baidu.tieba.pb.pb.sub.a.b bVar = new com.baidu.tieba.pb.pb.sub.a.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fEd) {
                arrayList.add(0, pVar.dny());
            }
            this.mcH.a(this.maI.boP(), arrayList);
            a(pVar, pVar.dny(), pVar.Zq(), pVar.bny(), i, z);
            if (i4 > 0) {
                this.gAY.setSelectionFromTop(i3, i2);
            } else if (z2 && !com.baidu.tbadk.core.util.at.isEmpty(this.mcd.due().dpW())) {
                String dpW = this.mcd.due().dpW();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dpW.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gAY.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gAY.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gAY.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.maI.dnD() > 1) {
                this.gAY.setPullRefresh(this.lUI);
                this.mcb.setEnableDragExit(false);
                return;
            }
            this.gAY.setPullRefresh(null);
            this.mcb.setEnableDragExit(true);
        }
    }

    private void HB(int i) {
        if (this.mcB != null) {
            if (this.mcB.size() <= i) {
                this.mcB.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.mcB.iterator();
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

    public boolean duj() {
        return this.mcH.aKU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fEd) {
            if (!StringUtils.isNull(postData.dPl())) {
                this.mcn.setVisibility(0);
                this.mcn.startLoad(postData.dPl(), 10, true);
            } else {
                this.mcn.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dPn = postData.dPn();
            if (dPn != null && dPn.nqY) {
                this.mco.setVisibility(0);
            } else {
                this.mco.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.mcc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.mcc.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.mck.setText((CharSequence) null);
            this.eLt.setText((CharSequence) null);
            this.lXM.setVisibility(8);
            if (!this.fEd) {
                c(postData.brr());
                if (z) {
                    this.lXM.setVisibility(0);
                    ao.setViewTextColor(this.lXM, R.color.CAM_X0302);
                }
            }
            this.mcl.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            String format = String.format(this.mcd.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dPe()));
            if (pVar.boP() != null && pVar.boP().bqa()) {
                this.mck.setText((CharSequence) null);
            } else {
                this.mck.setText(format);
            }
            postData.brr().getUserTbVipInfoData();
            boolean a2 = a(this.mcm, postData.dPg());
            if (StringUtils.isNull(postData.dPl()) && !a2 && postData.bLf() != null) {
                this.amd.setVisibility(0);
                this.amd.setTag(postData.bLf());
                return;
            }
            this.amd.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ad.getTextLength(name_show) > 14) {
                str = ad.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.eLt.setText(dZ(metaData.getSealPrefix(), str));
            } else {
                this.eLt.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.mci != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.mci.setVisibility(8);
                } else {
                    this.mci.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eJe = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.mci.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ao.setViewTextColor(this.eLt, R.color.cp_cont_r);
            } else {
                ao.setViewTextColor(this.eLt, R.color.CAM_X0108);
            }
            this.mch.setVisibility(0);
            this.mch.setUserId(metaData.getUserId());
            this.mch.setUserName(metaData.getUserName());
            this.mch.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.mch, metaData);
            this.mch.startLoad(metaData.getAvater(), 28, false);
            this.mcg.setTag(R.id.tag_user_id, metaData.getUserId());
            this.mcg.setTag(R.id.tag_user_name, metaData.getUserName());
            this.mcg.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bKX() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bKX().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.q(next.bLe());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.lL(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dXw());
                        continue;
                    case 17:
                        String str = next.bLi().mGifInfo.mSharpText;
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
        if (!tbRichTextData.bLm()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bLe() == null || tbRichTextData.bLe().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bLe());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mcd.getPageContext().getString(R.string.refresh_view_button_text), this.eKl));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.mcd.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.mce, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gAY.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kOT.bFR();
        ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.mcd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void En(int i) {
        b(NoDataViewFactory.d.dY(null, this.mcd.getResources().getString(R.string.refresh_view_title_text)));
        this.mcC.setVisibility(8);
    }

    public void Jh(String str) {
        b(NoDataViewFactory.d.dY(str, this.mcd.getPageContext().getString(R.string.refresh_view_title_text)));
        this.mcC.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gAY.setVisibility(0);
            this.mcC.setVisibility(0);
            this.mcb.setOnTouchListener(null);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        this.eKl = onClickListener;
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
        String userId;
        boolean z5;
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
                String userId2 = postData.brr().getUserId();
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
            if (this.maI != null && this.maI.boP() != null && this.maI.boP().brr() != null && postData.brr() != null) {
                String userId3 = this.maI.boP().brr().getUserId();
                String userId4 = postData.brr().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z = true;
                    } else {
                        z3 = true;
                        z4 = false;
                        z = true;
                    }
                    userId = postData.brr().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z = true;
                    }
                    int i2 = postData.dPe() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.brr() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.brr().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.brr().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.brr().getPortrait());
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        z5 = true;
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.brr() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.brr().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.brr().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.brr().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.brr() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brr().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.brr().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brr().getName_show());
                        }
                        if (this.maI.boP() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.maI.boP().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = false;
            userId = postData.brr().getUserId();
            if (userId != null) {
                z3 = true;
                z = true;
            }
            if (postData.dPe() != 1) {
            }
            if (!z2) {
            }
            if (!z) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z2) {
            }
            if (!z4) {
            }
            if (!z) {
            }
        }
    }

    public void vU(boolean z) {
        if (this.mbA != null && this.mbA.dqY() != null) {
            if (z) {
                this.mbA.dqY().setText(R.string.remove_mark);
            } else {
                this.mbA.dqY().setText(R.string.mark);
            }
        }
    }

    public View duk() {
        return this.mcv;
    }

    public void onChangeSkinType(int i) {
        this.mcd.getLayoutMode().setNightMode(i == 1);
        this.mcd.getLayoutMode().onModeChanged(this.mcb);
        this.mcd.getLayoutMode().onModeChanged(this.mcc);
        ao.setBackgroundColor(this.mcb, R.color.CAM_X0201);
        ao.setBackgroundColor(this.mce, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.mcd.getPageContext(), i);
        WebPManager.a(this.eKg, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.mcf != null) {
            ao.setViewTextColor(this.mcf, R.color.goto_see_subject_color);
        }
        this.fOl.onChangeSkinType(this.mcd.getPageContext(), i);
        this.mcd.getLayoutMode().onModeChanged(this.mcv);
        ao.setViewTextColor(this.mcm, R.color.CAM_X0105);
        this.mcm.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        if (this.kOT != null && this.kOT.bEJ() != null) {
            this.kOT.bEJ().onChangeSkinType(i);
        }
        this.mcq.changeSkin(i);
        this.amd.bxO();
        ao.setViewTextColor(this.jAu, R.color.CAM_X0110);
        ao.setViewTextColor(this.lXM, R.color.CAM_X0302);
        ao.setViewTextColor(this.eLt, R.color.CAM_X0108);
        this.jAu.setAlpha(0.95f);
        if (this.mcr != null) {
            com.baidu.tbadk.r.a.a(this.mcd.getPageContext(), this.mcr);
        }
        if (this.mcH != null) {
            this.mcH.notifyDataSetChanged();
        }
        this.mcd.getLayoutMode().onModeChanged(this.mct);
        ao.setBackgroundColor(this.lVc, R.color.CAM_X0203);
        this.lVf.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lVe.setBackgroundDrawable(ao.aO(l.getDimens(this.mcd, R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
    }

    public void dul() {
        this.mProgress.setVisibility(0);
    }

    public void dum() {
        this.gAY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mcq.endLoadData();
    }

    public void cBY() {
        this.gAY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mcq.cBY();
    }

    public boolean dun() {
        return this.mcb.dun();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mcH.c(onLongClickListener);
    }

    public View duo() {
        return this.mcc;
    }

    public TextView cLd() {
        return this.jAu;
    }

    public ImageView dup() {
        return this.mcD;
    }

    public ImageView duq() {
        return this.mcE;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void HC(int i) {
    }

    public View dur() {
        return this.mcf;
    }

    public View dus() {
        return this.mcn;
    }

    public MorePopupWindow dut() {
        return this.mcs;
    }

    public void showLoadingDialog() {
        if (this.iCD == null) {
            this.iCD = new com.baidu.tbadk.core.view.a(this.mcd.getPageContext());
        }
        this.iCD.setDialogVisiable(true);
    }

    public void cnj() {
        if (this.iCD != null) {
            this.iCD.setDialogVisiable(false);
        }
    }

    public TextView duu() {
        return this.mcm;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mcH.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.mcH != null) {
            this.mcH.notifyDataSetChanged();
        }
    }

    public aa duv() {
        return this.mbA;
    }

    public void cNw() {
    }

    public void cNx() {
    }

    public void cLE() {
        if (this.mcb != null) {
            this.mcb.onDestroy();
        }
        if (this.kOT != null) {
            this.kOT.onDestory();
        }
    }

    public void duw() {
        if (this.mcd.isPaused()) {
        }
    }

    public View dux() {
        return this.mcg;
    }

    private SpannableStringBuilder dZ(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.mcd.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int duy() {
        if (this.kOT == null || this.kOT.bEJ() == null) {
            return 0;
        }
        return this.kOT.bEJ().getHeight();
    }

    public int duz() {
        if (this.mcw == null) {
            return 0;
        }
        return this.mcw.getHeight();
    }

    public void duA() {
        if (this.jAu != null && this.kOT != null) {
            if (this.kOT.bFW()) {
                this.jAu.setText(R.string.draft_to_send);
            } else {
                this.jAu.setText(this.mcd.drR());
            }
        }
    }

    public void ve(boolean z) {
        if (this.lVf != null) {
            this.lVf.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.flR = cVar;
        if (this.lUI != null) {
            this.lUI.setListPullRefreshListener(cVar);
        }
    }
}
