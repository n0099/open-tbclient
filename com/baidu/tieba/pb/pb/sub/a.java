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
    private static final int mcb = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
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
    private e lUJ;
    private View lVd;
    private LinearLayout lVf;
    private HeadImageView lVg;
    private i lWd;
    private ProgressBar mProgress;
    private p maJ;
    private aa mbB;
    private SubPbModel mby;
    private ArrayList<PostData> mcC;
    private RelativeLayout mcD;
    private ImageView mcE;
    private ImageView mcF;
    private c mcI;
    private SubPbView mcc;
    private View mcd;
    private NewSubPbActivity mce;
    private RelativeLayout mcf;
    private View mcj;
    private ThreadSkinView mcq;
    private d mcr;
    private View mcs;
    private View mcu;
    private View mcw;
    private BlankView mcx;
    private com.baidu.tbadk.core.dialog.b mcz;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eKl = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mcg = null;
    private LinearLayout mch = null;
    private HeadImageView mci = null;
    private TextView eLt = null;
    private ImageView mck = null;
    private TextView lXN = null;
    private TextView mcl = null;
    private TextView mcm = null;
    private EllipsizeRichTextView mcn = null;
    private TbImageView mco = null;
    private PlayVoiceBntNew amd = null;
    private TextView mcp = null;
    private MorePopupWindow mct = null;
    private com.baidu.tbadk.core.dialog.b mcv = null;
    private Dialog mcy = null;
    private com.baidu.tbadk.core.dialog.a lUO = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a mcA = null;
    private NewSubPbActivity.a mcB = null;
    private h kOT = null;
    private int fZf = 0;
    private int mcG = 2;
    private int mcH = 0;
    private boolean fEd = true;
    private boolean lNg = com.baidu.tbadk.a.d.bmF();
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
    protected AdapterView.OnItemLongClickListener mcJ = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) x.getItem(a.this.mcC, i);
            if (view != null && view.getTag() != null) {
                if (a.this.mbB == null) {
                    a.this.mbB = new aa(a.this.mce.getPageContext(), a.this.bdp);
                }
                a.this.mbB.SY();
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
                aa aaVar = a.this.mbB;
                int dmT = a.this.mby.dmT();
                if (!a.this.lNg || postData2 == null || !postData2.nss) {
                    z = false;
                }
                aaVar.a(sparseArray, dmT, z2, z);
                if (z2) {
                    a.this.mbB.dqZ().setVisibility(0);
                    a.this.mbB.dqZ().setTag(postData.getId());
                } else {
                    a.this.mbB.dqZ().setVisibility(8);
                }
                a.this.mbB.dqX().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener mcK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.mce != null && bg.checkUpIsLogin(a.this.mce.getPageContext().getPageActivity())) {
                if ((a.this.mce.kON == null || a.this.mby == null || a.this.mby.cDY() == null || a.this.mce.kON.pZ(a.this.mby.cDY().replyPrivateFlag)) && a.this.mby != null && a.this.kOT != null) {
                    a.this.due();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dug();
                        a.this.mby.duF();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kOT.setReplyId(str2);
                            a.this.kOT.DZ(str);
                        }
                    }
                    a.this.duf();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.mcc = null;
        this.mcd = null;
        this.gAY = null;
        this.lUJ = null;
        this.mce = null;
        this.fOl = null;
        this.mcf = null;
        this.mcj = null;
        this.mcr = null;
        this.mcw = null;
        this.bdp = null;
        this.mProgress = null;
        this.jAu = null;
        this.mcD = null;
        this.mcE = null;
        this.mcF = null;
        this.mce = newSubPbActivity;
        this.bdp = onClickListener;
        this.mcc = (SubPbView) LayoutInflater.from(this.mce.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.mcd = LayoutInflater.from(this.mce.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fOm = (LinearLayout) this.mcc.findViewById(R.id.navigation_bar_group);
        this.mcD = (RelativeLayout) this.mcc.findViewById(R.id.subpb_editor_tool_comment);
        this.jAu = (TextView) this.mcc.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jAu.setOnClickListener(this.bdp);
        this.mcE = (ImageView) this.mcc.findViewById(R.id.subpb_editor_tool_more_img);
        this.mcF = (ImageView) this.mcc.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.mcF.setOnClickListener(this.bdp);
        this.mcE.setOnClickListener(this.bdp);
        this.fOl = (NoNetworkView) this.mcc.findViewById(R.id.view_no_network);
        cKX();
        bZC();
        this.mcf = (RelativeLayout) this.mcc.findViewById(R.id.sub_pb_body_layout);
        this.gAY = (BdTypeListView) this.mcc.findViewById(R.id.new_sub_pb_list);
        this.mcq = (ThreadSkinView) LayoutInflater.from(this.mce.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gAY.addHeaderView(this.mcq);
        this.gAY.addHeaderView(this.mcd);
        this.iUJ = new TextView(newSubPbActivity.getActivity());
        this.iUJ.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gAY.addHeaderView(this.iUJ, 0);
        this.mcc.setTopView(this.iUJ);
        this.mcc.setNavigationView(this.fOm);
        this.mcc.setListView(this.gAY);
        this.mcc.setContentView(this.mcf);
        this.mcr = new d(this.mce.getPageContext());
        this.mcr.setLineGone();
        this.mcw = this.mcr.getView();
        this.gAY.setNextPage(this.mcr);
        this.mcr.setOnClickListener(this.bdp);
        this.gAY.setOnItemClickListener(this.mcK);
        this.gAY.setOnItemLongClickListener(this.mcJ);
        this.gAY.setOnTouchListener(this.fyb);
        this.lUJ = new e(newSubPbActivity.getPageContext());
        this.lUJ.createView();
        this.lUJ.setListPullRefreshListener(this.flR);
        this.lUJ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.mcc.findViewById(R.id.progress);
        this.lVd = this.mcc.findViewById(R.id.view_comment_top_line);
        this.lVf = (LinearLayout) this.mcc.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lVg = (HeadImageView) this.mcc.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lVg.setVisibility(0);
        this.lVg.setIsRound(true);
        this.lVg.setBorderWidth(l.getDimens(this.mce, R.dimen.L_X01));
        this.lVg.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lVg.setDefaultBgResource(0);
        this.lVg.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lVg.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mcd != null) {
            this.mcd.setVisibility(4);
        }
        this.mcj = com.baidu.tbadk.ala.b.bno().A(this.mce.getActivity(), 4);
        if (this.mcj != null) {
            this.mcj.setVisibility(8);
            this.mch.addView(this.mcj, 3);
        }
        this.mcI = new c(this.mce, this.gAY);
        this.mcI.setFromCDN(this.mIsFromCDN);
        this.mcI.C(this.bdp);
        this.mcI.MT();
    }

    public ListView getListView() {
        return this.gAY;
    }

    public void bZC() {
        this.mch = (LinearLayout) this.mcd.findViewById(R.id.subpb_head_user_info_root);
        this.mch.setOnClickListener(this.bdp);
        this.mci = (HeadImageView) this.mcd.findViewById(R.id.photo);
        this.mci.setRadius(l.getDimens(this.mce.getActivity(), R.dimen.tbds45));
        this.mci.setClickable(false);
        this.eLt = (TextView) this.mcd.findViewById(R.id.user_name);
        this.mck = (ImageView) this.mcd.findViewById(R.id.user_rank);
        this.mck.setVisibility(8);
        this.lXN = (TextView) this.mcd.findViewById(R.id.floor_owner);
        this.mcg = (TextView) this.mcd.findViewById(R.id.see_subject);
        this.mcg.setOnClickListener(this.bdp);
        this.mcl = (TextView) this.mcd.findViewById(R.id.floor);
        this.mcm = (TextView) this.mcd.findViewById(R.id.time);
        this.mcn = (EllipsizeRichTextView) this.mcd.findViewById(R.id.content_text);
        this.mcn.setOnClickListener(this.bdp);
        ao.setViewTextColor(this.mcn, R.color.CAM_X0105);
        this.mcn.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        this.mcn.setLineSpacing(0.0f, 1.25f);
        this.mco = (TbImageView) this.mcd.findViewById(R.id.sub_pb_image);
        this.mco.setOnClickListener(this.bdp);
        this.mcp = (TextView) this.mcd.findViewById(R.id.advert);
        this.amd = (PlayVoiceBntNew) this.mcd.findViewById(R.id.voice_btn);
        this.mcd.setOnTouchListener(this.fyb);
        this.mcd.setOnClickListener(this.bdp);
    }

    public void a(b.InterfaceC0578b interfaceC0578b, boolean z) {
        if (this.mcz != null) {
            this.mcz.dismiss();
            this.mcz = null;
        }
        this.mcz = new com.baidu.tbadk.core.dialog.b(this.mce.getPageContext().getPageActivity());
        if (z) {
            this.mcz.a(new String[]{this.mce.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0578b);
        } else {
            this.mcz.a(new String[]{this.mce.getPageContext().getString(R.string.save_to_emotion), this.mce.getPageContext().getString(R.string.save_to_local)}, interfaceC0578b);
        }
        this.mcz.d(this.mce.getPageContext());
        this.mcz.btZ();
    }

    public void dR(View view) {
        this.mcs = view;
    }

    public void cKX() {
        int dimens = l.getDimens(this.mce.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.mce.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.mcc.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mcx != null) {
                    a.this.mcc.onFinish();
                } else {
                    a.this.mce.finish();
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
        if (this.mcy == null) {
            this.mcy = new Dialog(this.mce.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mcy.setCanceledOnTouchOutside(true);
            this.mcy.setCancelable(true);
            this.mcu = LayoutInflater.from(this.mce.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.mce.getLayoutMode().onModeChanged(this.mcu);
            this.mcy.setContentView(this.mcu);
            WindowManager.LayoutParams attributes = this.mcy.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.mce.getPageContext().getPageActivity()) * 0.9d);
            this.mcy.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.mcy.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.mcy.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.mcy.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.mcy != null && (a.this.mcy instanceof Dialog)) {
                        g.b(a.this.mcy, a.this.mce.getPageContext());
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
                    if (a.this.mcy != null && (a.this.mcy instanceof Dialog)) {
                        g.b(a.this.mcy, a.this.mce.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.mcA != null) {
                        a.this.mcA.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.mcy != null && (a.this.mcy instanceof Dialog)) {
                        g.b(a.this.mcy, a.this.mce.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.mce.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.mcy, this.mce.getPageContext());
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
        this.lUO = new com.baidu.tbadk.core.dialog.a(this.mce.getPageContext().getPageActivity());
        this.lUO.pa(i3);
        this.lUO.setYesButtonTag(sparseArray);
        this.lUO.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.mcB != null) {
                    a.this.mcB.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lUO.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lUO.jH(true);
        this.lUO.b(this.mce.getPageContext());
        if (z) {
            this.lUO.btX();
        } else if (1 == this.mby.duX()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.mby.duX(), this.mby.duW(), this.mby.bNQ());
            hVar.ej(this.maJ.bFK().getId(), this.maJ.bFK().getName());
            hVar.setForumHeadUrl(this.mby.bNT());
            hVar.setUserLevel(this.mby.bNU());
            UserData userData = new UserData();
            userData.setIsManager(this.mby.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            h(sparseArray);
        }
    }

    private void h(final SparseArray<Object> sparseArray) {
        AntiData cDY;
        if (this.mce != null && sparseArray != null && this.mcd != null) {
            if (this.jOD == null) {
                this.jOD = new com.baidu.tieba.NEGFeedBack.f(this.mce.getPageContext(), this.mcd);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mby != null && (cDY = this.mby.cDY()) != null && cDY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDY.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.jOD.setDefaultReasonArray(new String[]{this.mce.getString(R.string.delete_thread_reason_1), this.mce.getString(R.string.delete_thread_reason_2), this.mce.getString(R.string.delete_thread_reason_3), this.mce.getString(R.string.delete_thread_reason_4), this.mce.getString(R.string.delete_thread_reason_5)});
            this.jOD.setData(atVar);
            this.jOD.Fh("4");
            this.jOD.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    String S = com.baidu.tbadk.core.util.at.S(jSONArray);
                    if (a.this.mcB != null) {
                        a.this.mcB.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cDY;
        if (this.mce != null && sparseArray != null && this.mcd != null) {
            if (this.lWd == null) {
                this.lWd = new i(this.mce.getPageContext(), this.mcd, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mby != null && (cDY = this.mby.cDY()) != null && cDY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDY.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.lWd.setDefaultReasonArray(new String[]{this.mce.getString(R.string.delete_thread_reason_1), this.mce.getString(R.string.delete_thread_reason_2), this.mce.getString(R.string.delete_thread_reason_3), this.mce.getString(R.string.delete_thread_reason_4), this.mce.getString(R.string.delete_thread_reason_5)});
            this.lWd.setData(atVar);
            this.lWd.Fh("4");
            this.lWd.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    String S = com.baidu.tbadk.core.util.at.S(jSONArray);
                    if (a.this.mcB != null) {
                        a.this.mcB.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
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
        this.mcA = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.mcB = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.mce.showToast(this.mce.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.mce.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bEI() != null) {
            this.kOT = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mcf.addView(hVar.bEI(), layoutParams);
            this.kOT.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    a.this.duz();
                }
            });
        }
    }

    public void due() {
        if (this.gAY != null) {
            this.mcH = this.gAY.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uP(boolean z) {
        if (this.mby == null || this.mby.duC() == null) {
            return false;
        }
        if (this.mby.dmT() != 0) {
            return false;
        }
        return (this.maJ == null || this.maJ.boO() == null || this.maJ.boO().brq() == null || !TextUtils.equals(this.maJ.boO().brq().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void duf() {
        if (this.mby != null) {
            if ((!dui() && this.mcw != null && this.mcw.isShown()) || x.isEmpty(this.mcC)) {
                this.mby.vW(false);
            } else {
                this.mby.vW(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.mby = subPbModel;
    }

    public void vT(boolean z) {
        if (this.mby != null && this.mby.duc() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mcx = new BlankView(this.mce.getPageContext().getPageActivity());
            this.fOm.addView(this.mcx, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.mcx.setVisibility(0);
            this.mcx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mce.finish();
                }
            });
            this.mcc.setBlankView(this.mcx);
        }
    }

    public void dug() {
        b(this.mce);
        this.gAY.setNextPage(this.mcr);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yg(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dui() && this.mcw != null && this.mcw.isShown()) {
                i = (this.mcH - this.mcG) - 1;
            } else {
                i = this.mcH - this.mcG;
            }
            int count = x.getCount(this.mcC);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(x.subList(this.mcC, 0, i));
            x.add(arrayList, postData2);
            x.add(arrayList, postData);
            this.gAY.smoothScrollToPosition(this.mcH + 2);
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
        return this.mcc;
    }

    public void dsG() {
        if (this.mct != null) {
            g.dismissPopupWindow(this.mct, this.mce.getPageContext().getPageActivity());
        }
        if (this.mcv != null) {
            this.mcv.dismiss();
        }
        if (this.lUO != null) {
            this.lUO.dismiss();
        }
        if (this.mcy != null) {
            g.b(this.mcy, this.mce.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mbB != null) {
            this.mbB.dismiss();
        }
    }

    public void duh() {
        this.gAY.setNextPage(this.mcr);
        this.mcr.startLoadData();
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
            if (this.fEd && this.mcd != null) {
                this.mcd.setVisibility(8);
                this.gAY.removeHeaderView(this.mcd);
                this.mcG = 1;
            }
            this.maJ = pVar;
            if (this.maJ.dnx() != null) {
                this.maJ.dnx().nss = true;
            }
            if (this.mcd != null) {
                this.mcd.setVisibility(0);
            }
            if (pVar.boO() != null && pVar.boO().bpZ()) {
                this.mcg.setText(R.string.view_original);
            } else {
                this.mcg.setText(R.string.view_subject);
            }
            if (pVar.dnx() != null) {
                this.fZf = pVar.dnx().dPd();
                if (this.fZf > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.mce.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fZf)));
                    if (this.mce != null) {
                        this.jAu.setText(this.mce.drQ());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.mce.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.mce.duc()) {
                    str = "PB";
                }
                if (pVar.dnx().brL() != null) {
                    this.mcq.setData(this.mce.getPageContext(), pVar.dnx().brL(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", pVar.bFK().getId(), pVar.bFK().getName(), pVar.boO().getId(), str));
                } else {
                    this.mcq.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.mcr.startLoadData();
                this.mcI.setHasMoreData(true);
            } else {
                this.mcr.endLoadData();
                this.mcI.setHasMoreData(false);
            }
            this.mcC = pVar.dnF();
            if (this.mcC == null || this.mcC.size() <= mcb) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.mcC.size() - mcb;
                HB(size);
                int firstVisiblePosition = this.gAY.getFirstVisiblePosition() - size;
                View childAt = this.gAY.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mcC);
            if (x.isEmpty(this.mcC)) {
                this.gAY.setNextPage(null);
                if (this.fEd) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.a.a());
                }
            } else {
                this.gAY.setNextPage(this.mcr);
            }
            com.baidu.tieba.pb.pb.sub.a.b bVar = new com.baidu.tieba.pb.pb.sub.a.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fEd) {
                arrayList.add(0, pVar.dnx());
            }
            this.mcI.a(this.maJ.boO(), arrayList);
            a(pVar, pVar.dnx(), pVar.Zp(), pVar.bnx(), i, z);
            if (i4 > 0) {
                this.gAY.setSelectionFromTop(i3, i2);
            } else if (z2 && !com.baidu.tbadk.core.util.at.isEmpty(this.mce.dud().dpV())) {
                String dpV = this.mce.dud().dpV();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dpV.equals(((PostData) arrayList.get(i6)).getId())) {
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
            if (this.maJ.dnC() > 1) {
                this.gAY.setPullRefresh(this.lUJ);
                this.mcc.setEnableDragExit(false);
                return;
            }
            this.gAY.setPullRefresh(null);
            this.mcc.setEnableDragExit(true);
        }
    }

    private void HB(int i) {
        if (this.mcC != null) {
            if (this.mcC.size() <= i) {
                this.mcC.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.mcC.iterator();
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

    public boolean dui() {
        return this.mcI.aKT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fEd) {
            if (!StringUtils.isNull(postData.dPk())) {
                this.mco.setVisibility(0);
                this.mco.startLoad(postData.dPk(), 10, true);
            } else {
                this.mco.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dPm = postData.dPm();
            if (dPm != null && dPm.nqZ) {
                this.mcp.setVisibility(0);
            } else {
                this.mcp.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.mcd.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.mcd.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.mcl.setText((CharSequence) null);
            this.eLt.setText((CharSequence) null);
            this.lXN.setVisibility(8);
            if (!this.fEd) {
                c(postData.brq());
                if (z) {
                    this.lXN.setVisibility(0);
                    ao.setViewTextColor(this.lXN, R.color.CAM_X0302);
                }
            }
            this.mcm.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            String format = String.format(this.mce.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dPd()));
            if (pVar.boO() != null && pVar.boO().bpZ()) {
                this.mcl.setText((CharSequence) null);
            } else {
                this.mcl.setText(format);
            }
            postData.brq().getUserTbVipInfoData();
            boolean a2 = a(this.mcn, postData.dPf());
            if (StringUtils.isNull(postData.dPk()) && !a2 && postData.bLe() != null) {
                this.amd.setVisibility(0);
                this.amd.setTag(postData.bLe());
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
            if (metaData.getAlaUserData() != null && this.mcj != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.mcj.setVisibility(8);
                } else {
                    this.mcj.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eJe = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.mcj.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ao.setViewTextColor(this.eLt, R.color.cp_cont_r);
            } else {
                ao.setViewTextColor(this.eLt, R.color.CAM_X0108);
            }
            this.mci.setVisibility(0);
            this.mci.setUserId(metaData.getUserId());
            this.mci.setUserName(metaData.getUserName());
            this.mci.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.mci, metaData);
            this.mci.startLoad(metaData.getAvater(), 28, false);
            this.mch.setTag(R.id.tag_user_id, metaData.getUserId());
            this.mch.setTag(R.id.tag_user_name, metaData.getUserName());
            this.mch.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bKW() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bKW().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.q(next.bLd());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.lL(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dXv());
                        continue;
                    case 17:
                        String str = next.bLh().mGifInfo.mSharpText;
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
        if (!tbRichTextData.bLl()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bLd() == null || tbRichTextData.bLd().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bLd());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mce.getPageContext().getString(R.string.refresh_view_button_text), this.eKl));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.mce.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.mcf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gAY.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kOT.bFQ();
        ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.mce.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void En(int i) {
        b(NoDataViewFactory.d.dY(null, this.mce.getResources().getString(R.string.refresh_view_title_text)));
        this.mcD.setVisibility(8);
    }

    public void Ji(String str) {
        b(NoDataViewFactory.d.dY(str, this.mce.getPageContext().getString(R.string.refresh_view_title_text)));
        this.mcD.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gAY.setVisibility(0);
            this.mcD.setVisibility(0);
            this.mcc.setOnTouchListener(null);
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
                String userId2 = postData.brq().getUserId();
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
            if (this.maJ != null && this.maJ.boO() != null && this.maJ.boO().brq() != null && postData.brq() != null) {
                String userId3 = this.maJ.boO().brq().getUserId();
                String userId4 = postData.brq().getUserId();
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
                    userId = postData.brq().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z = true;
                    }
                    int i2 = postData.dPd() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.brq() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.brq().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.brq().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.brq().getPortrait());
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
                        if (postData.brq() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.brq().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.brq().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.brq().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.brq() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brq().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.brq().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brq().getName_show());
                        }
                        if (this.maJ.boO() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.maJ.boO().getId());
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
            userId = postData.brq().getUserId();
            if (userId != null) {
                z3 = true;
                z = true;
            }
            if (postData.dPd() != 1) {
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
        if (this.mbB != null && this.mbB.dqX() != null) {
            if (z) {
                this.mbB.dqX().setText(R.string.remove_mark);
            } else {
                this.mbB.dqX().setText(R.string.mark);
            }
        }
    }

    public View duj() {
        return this.mcw;
    }

    public void onChangeSkinType(int i) {
        this.mce.getLayoutMode().setNightMode(i == 1);
        this.mce.getLayoutMode().onModeChanged(this.mcc);
        this.mce.getLayoutMode().onModeChanged(this.mcd);
        ao.setBackgroundColor(this.mcc, R.color.CAM_X0201);
        ao.setBackgroundColor(this.mcf, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.mce.getPageContext(), i);
        WebPManager.a(this.eKg, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.mcg != null) {
            ao.setViewTextColor(this.mcg, R.color.goto_see_subject_color);
        }
        this.fOl.onChangeSkinType(this.mce.getPageContext(), i);
        this.mce.getLayoutMode().onModeChanged(this.mcw);
        ao.setViewTextColor(this.mcn, R.color.CAM_X0105);
        this.mcn.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        if (this.kOT != null && this.kOT.bEI() != null) {
            this.kOT.bEI().onChangeSkinType(i);
        }
        this.mcr.changeSkin(i);
        this.amd.bxN();
        ao.setViewTextColor(this.jAu, R.color.CAM_X0110);
        ao.setViewTextColor(this.lXN, R.color.CAM_X0302);
        ao.setViewTextColor(this.eLt, R.color.CAM_X0108);
        this.jAu.setAlpha(0.95f);
        if (this.mcs != null) {
            com.baidu.tbadk.r.a.a(this.mce.getPageContext(), this.mcs);
        }
        if (this.mcI != null) {
            this.mcI.notifyDataSetChanged();
        }
        this.mce.getLayoutMode().onModeChanged(this.mcu);
        ao.setBackgroundColor(this.lVd, R.color.CAM_X0203);
        this.lVg.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lVf.setBackgroundDrawable(ao.aO(l.getDimens(this.mce, R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
    }

    public void duk() {
        this.mProgress.setVisibility(0);
    }

    public void dul() {
        this.gAY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mcr.endLoadData();
    }

    public void cBX() {
        this.gAY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mcr.cBX();
    }

    public boolean dum() {
        return this.mcc.dum();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mcI.c(onLongClickListener);
    }

    public View dun() {
        return this.mcd;
    }

    public TextView cLc() {
        return this.jAu;
    }

    public ImageView duo() {
        return this.mcE;
    }

    public ImageView dup() {
        return this.mcF;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void HC(int i) {
    }

    public View duq() {
        return this.mcg;
    }

    public View dur() {
        return this.mco;
    }

    public MorePopupWindow dus() {
        return this.mct;
    }

    public void showLoadingDialog() {
        if (this.iCD == null) {
            this.iCD = new com.baidu.tbadk.core.view.a(this.mce.getPageContext());
        }
        this.iCD.setDialogVisiable(true);
    }

    public void cni() {
        if (this.iCD != null) {
            this.iCD.setDialogVisiable(false);
        }
    }

    public TextView dut() {
        return this.mcn;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mcI.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.mcI != null) {
            this.mcI.notifyDataSetChanged();
        }
    }

    public aa duu() {
        return this.mbB;
    }

    public void cNv() {
    }

    public void cNw() {
    }

    public void cLD() {
        if (this.mcc != null) {
            this.mcc.onDestroy();
        }
        if (this.kOT != null) {
            this.kOT.onDestory();
        }
    }

    public void duv() {
        if (this.mce.isPaused()) {
        }
    }

    public View duw() {
        return this.mch;
    }

    private SpannableStringBuilder dZ(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.mce.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dux() {
        if (this.kOT == null || this.kOT.bEI() == null) {
            return 0;
        }
        return this.kOT.bEI().getHeight();
    }

    public int duy() {
        if (this.mcx == null) {
            return 0;
        }
        return this.mcx.getHeight();
    }

    public void duz() {
        if (this.jAu != null && this.kOT != null) {
            if (this.kOT.bFV()) {
                this.jAu.setText(R.string.draft_to_send);
            } else {
                this.jAu.setText(this.mce.drQ());
            }
        }
    }

    public void ve(boolean z) {
        if (this.lVg != null) {
            this.lVg.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.flR = cVar;
        if (this.lUJ != null) {
            this.lUJ.setListPullRefreshListener(cVar);
        }
    }
}
