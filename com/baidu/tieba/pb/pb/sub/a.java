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
import com.baidu.tbadk.core.data.as;
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
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class a implements KeyboardEventLayout.a {
    private static final int lIP = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aYm;
    private f.c eUM;
    private ImageView etB;
    private NoNetworkView fwR;
    private LinearLayout fwS;
    private BdTypeListView ghN;
    private com.baidu.tbadk.core.view.a ifn;
    private View ixE;
    private TextView jau;
    private e jox;
    private com.baidu.tieba.pb.view.d lBI;
    private View lCb;
    private LinearLayout lCd;
    private HeadImageView lCe;
    private p lHx;
    private SubPbView lIQ;
    private View lIR;
    private NewSubPbActivity lIS;
    private RelativeLayout lIT;
    private View lIX;
    private SubPbModel lIn;
    private ah lIq;
    private ThreadSkinView lJe;
    private d lJf;
    private View lJg;
    private View lJi;
    private View lJk;
    private BlankView lJl;
    private com.baidu.tbadk.core.dialog.b lJn;
    private ArrayList<PostData> lJq;
    private RelativeLayout lJr;
    private ImageView lJs;
    private ImageView lJt;
    private c lJw;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener etG = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lIU = null;
    private LinearLayout lIV = null;
    private HeadImageView lIW = null;
    private TextView euO = null;
    private ImageView lIY = null;
    private TextView lEI = null;
    private TextView lIZ = null;
    private TextView lJa = null;
    private EllipsizeRichTextView lJb = null;
    private TbImageView lJc = null;
    private PlayVoiceBntNew akA = null;
    private TextView lJd = null;
    private MorePopupWindow lJh = null;
    private com.baidu.tbadk.core.dialog.b lJj = null;
    private Dialog lJm = null;
    private com.baidu.tbadk.core.dialog.a lBM = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lJo = null;
    private NewSubPbActivity.a lJp = null;
    private h kwo = null;
    private int fHP = 0;
    private int lJu = 2;
    private int lJv = 0;
    private boolean fmT = true;
    private boolean lrD = com.baidu.tbadk.a.d.bhn();
    private com.baidu.tieba.pb.a.c fgS = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.7
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.qh(false);
            a.this.qh(true);
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
    protected AdapterView.OnItemLongClickListener lJx = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.lJq, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lIq == null) {
                    a.this.lIq = new ah(a.this.lIS.getPageContext(), a.this.aYm);
                }
                a.this.lIq.PA();
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
                boolean z2 = a.this.um(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.lIq;
                int dhW = a.this.lIn.dhW();
                if (!a.this.lrD || postData2 == null || !postData2.mYG) {
                    z = false;
                }
                ahVar.a(sparseArray, dhW, z2, z);
                if (z2) {
                    a.this.lIq.dlV().setVisibility(0);
                    a.this.lIq.dlV().setTag(postData.getId());
                } else {
                    a.this.lIq.dlV().setVisibility(8);
                }
                a.this.lIq.dlT().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lJy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.lIS != null && bh.checkUpIsLogin(a.this.lIS.getPageContext().getPageActivity())) {
                if ((a.this.lIS.kwi == null || a.this.lIn == null || a.this.lIn.cwP() == null || a.this.lIS.kwi.pp(a.this.lIn.cwP().replyPrivateFlag)) && a.this.lIn != null && a.this.kwo != null) {
                    a.this.doX();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.doZ();
                        a.this.lIn.dpy();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kwo.setReplyId(str2);
                            a.this.kwo.Du(str);
                        }
                    }
                    a.this.doY();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.lIQ = null;
        this.lIR = null;
        this.ghN = null;
        this.lBI = null;
        this.lIS = null;
        this.fwR = null;
        this.lIT = null;
        this.lIX = null;
        this.lJf = null;
        this.lJk = null;
        this.aYm = null;
        this.mProgress = null;
        this.jau = null;
        this.lJr = null;
        this.lJs = null;
        this.lJt = null;
        this.lIS = newSubPbActivity;
        this.aYm = onClickListener;
        this.lIQ = (SubPbView) LayoutInflater.from(this.lIS.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.lIR = LayoutInflater.from(this.lIS.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fwS = (LinearLayout) this.lIQ.findViewById(R.id.navigation_bar_group);
        this.lJr = (RelativeLayout) this.lIQ.findViewById(R.id.subpb_editor_tool_comment);
        this.jau = (TextView) this.lIQ.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jau.setOnClickListener(this.aYm);
        this.lJs = (ImageView) this.lIQ.findViewById(R.id.subpb_editor_tool_more_img);
        this.lJt = (ImageView) this.lIQ.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lJt.setOnClickListener(this.aYm);
        this.lJs.setOnClickListener(this.aYm);
        this.fwR = (NoNetworkView) this.lIQ.findViewById(R.id.view_no_network);
        cCL();
        bTm();
        this.lIT = (RelativeLayout) this.lIQ.findViewById(R.id.sub_pb_body_layout);
        this.ghN = (BdTypeListView) this.lIQ.findViewById(R.id.new_sub_pb_list);
        this.lJe = (ThreadSkinView) LayoutInflater.from(this.lIS.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.ghN.addHeaderView(this.lJe);
        this.ghN.addHeaderView(this.lIR);
        this.ixE = new TextView(newSubPbActivity.getActivity());
        this.ixE.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.ghN.addHeaderView(this.ixE, 0);
        this.lIQ.setTopView(this.ixE);
        this.lIQ.setNavigationView(this.fwS);
        this.lIQ.setListView(this.ghN);
        this.lIQ.setContentView(this.lIT);
        this.lJf = new d(this.lIS.getPageContext());
        this.lJf.setLineGone();
        this.lJk = this.lJf.getView();
        this.ghN.setNextPage(this.lJf);
        this.lJf.setOnClickListener(this.aYm);
        this.ghN.setOnItemClickListener(this.lJy);
        this.ghN.setOnItemLongClickListener(this.lJx);
        this.ghN.setOnTouchListener(this.fgS);
        this.lBI = new com.baidu.tieba.pb.view.d(newSubPbActivity.getPageContext());
        this.lBI.createView();
        this.lBI.setListPullRefreshListener(this.eUM);
        this.lBI.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.lIQ.findViewById(R.id.progress);
        this.lCb = this.lIQ.findViewById(R.id.view_comment_top_line);
        this.lCd = (LinearLayout) this.lIQ.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lCe = (HeadImageView) this.lIQ.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lCe.setVisibility(0);
        this.lCe.setIsRound(true);
        this.lCe.setBorderWidth(l.getDimens(this.lIS, R.dimen.L_X01));
        this.lCe.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lCe.setDefaultBgResource(0);
        this.lCe.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lCe.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lIR != null) {
            this.lIR.setVisibility(4);
        }
        this.lIX = com.baidu.tbadk.ala.b.bhG().q(this.lIS.getActivity(), 4);
        if (this.lIX != null) {
            this.lIX.setVisibility(8);
            this.lIV.addView(this.lIX, 3);
        }
        this.lJw = new c(this.lIS, this.ghN);
        this.lJw.setFromCDN(this.mIsFromCDN);
        this.lJw.B(this.aYm);
        this.lJw.Lp();
    }

    public ListView getListView() {
        return this.ghN;
    }

    public void bTm() {
        this.lIV = (LinearLayout) this.lIR.findViewById(R.id.subpb_head_user_info_root);
        this.lIV.setOnClickListener(this.aYm);
        this.lIW = (HeadImageView) this.lIR.findViewById(R.id.photo);
        this.lIW.setRadius(l.getDimens(this.lIS.getActivity(), R.dimen.tbds45));
        this.lIW.setClickable(false);
        this.euO = (TextView) this.lIR.findViewById(R.id.user_name);
        this.lIY = (ImageView) this.lIR.findViewById(R.id.user_rank);
        this.lIY.setVisibility(8);
        this.lEI = (TextView) this.lIR.findViewById(R.id.floor_owner);
        this.lIU = (TextView) this.lIR.findViewById(R.id.see_subject);
        this.lIU.setOnClickListener(this.aYm);
        this.lIZ = (TextView) this.lIR.findViewById(R.id.floor);
        this.lJa = (TextView) this.lIR.findViewById(R.id.time);
        this.lJb = (EllipsizeRichTextView) this.lIR.findViewById(R.id.content_text);
        this.lJb.setOnClickListener(this.aYm);
        ap.setViewTextColor(this.lJb, R.color.CAM_X0105);
        this.lJb.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.lJb.setLineSpacing(0.0f, 1.25f);
        this.lJc = (TbImageView) this.lIR.findViewById(R.id.sub_pb_image);
        this.lJc.setOnClickListener(this.aYm);
        this.lJd = (TextView) this.lIR.findViewById(R.id.advert);
        this.akA = (PlayVoiceBntNew) this.lIR.findViewById(R.id.voice_btn);
        this.lIR.setOnTouchListener(this.fgS);
        this.lIR.setOnClickListener(this.aYm);
    }

    public void a(b.InterfaceC0574b interfaceC0574b, boolean z) {
        if (this.lJn != null) {
            this.lJn.dismiss();
            this.lJn = null;
        }
        this.lJn = new com.baidu.tbadk.core.dialog.b(this.lIS.getPageContext().getPageActivity());
        if (z) {
            this.lJn.a(new String[]{this.lIS.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0574b);
        } else {
            this.lJn.a(new String[]{this.lIS.getPageContext().getString(R.string.save_to_emotion), this.lIS.getPageContext().getString(R.string.save_to_local)}, interfaceC0574b);
        }
        this.lJn.d(this.lIS.getPageContext());
        this.lJn.boi();
    }

    public void dx(View view) {
        this.lJg = view;
    }

    public void cCL() {
        int dimens = l.getDimens(this.lIS.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.lIS.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.lIQ.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lJl != null) {
                    a.this.lIQ.onFinish();
                } else {
                    a.this.lIS.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        this.etB = backImageView;
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

    public void dt(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.lJm == null) {
            this.lJm = new Dialog(this.lIS.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lJm.setCanceledOnTouchOutside(true);
            this.lJm.setCancelable(true);
            this.lJi = LayoutInflater.from(this.lIS.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.lIS.getLayoutMode().onModeChanged(this.lJi);
            this.lJm.setContentView(this.lJi);
            WindowManager.LayoutParams attributes = this.lJm.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.lIS.getPageContext().getPageActivity()) * 0.9d);
            this.lJm.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lJm.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lJm.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lJm.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lJm != null && (a.this.lJm instanceof Dialog)) {
                        g.b(a.this.lJm, a.this.lIS.getPageContext());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lJm != null && (a.this.lJm instanceof Dialog)) {
                        g.b(a.this.lJm, a.this.lIS.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lJo != null) {
                        a.this.lJo.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lJm != null && (a.this.lJm instanceof Dialog)) {
                        g.b(a.this.lJm, a.this.lIS.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.lIS.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lJm, this.lIS.getPageContext());
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
        this.lBM = new com.baidu.tbadk.core.dialog.a(this.lIS.getPageContext().getPageActivity());
        this.lBM.os(i3);
        this.lBM.setYesButtonTag(sparseArray);
        this.lBM.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lJp != null) {
                    a.this.lJp.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lBM.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lBM.iW(true);
        this.lBM.b(this.lIS.getPageContext());
        if (z) {
            this.lBM.bog();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData cwP;
        if (this.lIS != null && sparseArray != null && this.lIR != null) {
            if (this.jox == null) {
                this.jox = new e(this.lIS.getPageContext(), this.lIR);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lIn != null && (cwP = this.lIn.cwP()) != null && cwP.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cwP.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            as asVar = new as();
            asVar.setFeedBackReasonMap(sparseArray2);
            this.jox.setDefaultReasonArray(new String[]{this.lIS.getString(R.string.delete_thread_reason_1), this.lIS.getString(R.string.delete_thread_reason_2), this.lIS.getString(R.string.delete_thread_reason_3), this.lIS.getString(R.string.delete_thread_reason_4), this.lIS.getString(R.string.delete_thread_reason_5)});
            this.jox.setData(asVar);
            this.jox.Ev("4");
            this.jox.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    String R = au.R(jSONArray);
                    if (a.this.lJp != null) {
                        a.this.lJp.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(final boolean z) {
        if (this.ghN != null) {
            if (!z) {
                this.ghN.setEnabled(z);
            } else {
                this.ghN.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ghN.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lJo = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lJp = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.lIS.showToast(this.lIS.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.lIS.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.byN() != null) {
            this.kwo = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.lIT.addView(hVar.byN(), layoutParams);
            this.kwo.a(new x.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    a.this.dps();
                }
            });
        }
    }

    public void doX() {
        if (this.ghN != null) {
            this.lJv = this.ghN.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean um(boolean z) {
        if (this.lIn == null || this.lIn.dpv() == null) {
            return false;
        }
        if (this.lIn.dhW() != 0) {
            return false;
        }
        return (this.lHx == null || this.lHx.bjd() == null || this.lHx.bjd().blC() == null || !TextUtils.equals(this.lHx.bjd().blC().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void doY() {
        if (this.lIn != null) {
            if ((!dpb() && this.lJk != null && this.lJk.isShown()) || y.isEmpty(this.lJq)) {
                this.lIn.vs(false);
            } else {
                this.lIn.vs(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lIn = subPbModel;
    }

    public void vp(boolean z) {
        if (this.lIn != null && this.lIn.doV() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lJl = new BlankView(this.lIS.getPageContext().getPageActivity());
            this.fwS.addView(this.lJl, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lJl.setVisibility(0);
            this.lJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lIS.finish();
                }
            });
            this.lIQ.setBlankView(this.lJl);
        }
    }

    public void doZ() {
        b(this.lIS);
        this.ghN.setNextPage(this.lJf);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.xx(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dpb() && this.lJk != null && this.lJk.isShown()) {
                i = (this.lJv - this.lJu) - 1;
            } else {
                i = this.lJv - this.lJu;
            }
            int count = y.getCount(this.lJq);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(y.subList(this.lJq, 0, i));
            y.add(arrayList, postData2);
            y.add(arrayList, postData);
            this.ghN.smoothScrollToPosition(this.lJv + 2);
            this.ghN.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ghN.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.ghN.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.lIQ;
    }

    public void dnA() {
        if (this.lJh != null) {
            g.dismissPopupWindow(this.lJh, this.lIS.getPageContext().getPageActivity());
        }
        if (this.lJj != null) {
            this.lJj.dismiss();
        }
        if (this.lBM != null) {
            this.lBM.dismiss();
        }
        if (this.lJm != null) {
            g.b(this.lJm, this.lIS.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lIq != null) {
            this.lIq.dismiss();
        }
    }

    public void dpa() {
        this.ghN.setNextPage(this.lJf);
        this.lJf.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fmT = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.fmT && this.lIR != null) {
                this.lIR.setVisibility(8);
                this.ghN.removeHeaderView(this.lIR);
                this.lJu = 1;
            }
            this.lHx = pVar;
            if (this.lHx.dix() != null) {
                this.lHx.dix().mYG = true;
            }
            if (this.lIR != null) {
                this.lIR.setVisibility(0);
            }
            if (pVar.bjd() != null && pVar.bjd().bkm()) {
                this.lIU.setText(R.string.view_original);
            } else {
                this.lIU.setText(R.string.view_subject);
            }
            if (pVar.dix() != null) {
                this.fHP = pVar.dix().dJQ();
                if (this.fHP > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.lIS.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fHP)));
                    if (this.lIS != null) {
                        this.jau.setText(this.lIS.dmM());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.lIS.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.lIS.doV()) {
                    str = "PB";
                }
                if (pVar.dix().blY() != null) {
                    this.lJe.setData(this.lIS.getPageContext(), pVar.dix().blY(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", pVar.bzP().getId(), pVar.bzP().getName(), pVar.bjd().getId(), str));
                } else {
                    this.lJe.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lJf.startLoadData();
                this.lJw.setHasMoreData(true);
            } else {
                this.lJf.endLoadData();
                this.lJw.setHasMoreData(false);
            }
            this.lJq = pVar.diF();
            if (this.lJq == null || this.lJq.size() <= lIP) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lJq.size() - lIP;
                GR(size);
                int firstVisiblePosition = this.ghN.getFirstVisiblePosition() - size;
                View childAt = this.ghN.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lJq);
            if (y.isEmpty(this.lJq)) {
                this.ghN.setNextPage(null);
                if (this.fmT) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.ghN.setNextPage(this.lJf);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fmT) {
                arrayList.add(0, pVar.dix());
            }
            this.lJw.a(this.lHx.bjd(), arrayList);
            a(pVar, pVar.dix(), pVar.VH(), pVar.bhP(), i, z);
            if (i4 > 0) {
                this.ghN.setSelectionFromTop(i3, i2);
            } else if (z2 && !au.isEmpty(this.lIS.doW().dkT())) {
                String dkT = this.lIS.doW().dkT();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dkT.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.ghN.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.ghN.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.ghN.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.lHx.diC() > 1) {
                this.ghN.setPullRefresh(this.lBI);
                this.lIQ.setEnableDragExit(false);
                return;
            }
            this.ghN.setPullRefresh(null);
            this.lIQ.setEnableDragExit(true);
        }
    }

    private void GR(int i) {
        if (this.lJq != null) {
            if (this.lJq.size() <= i) {
                this.lJq.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lJq.iterator();
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

    public boolean dpb() {
        return this.lJw.aGb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fmT) {
            if (!StringUtils.isNull(postData.dJX())) {
                this.lJc.setVisibility(0);
                this.lJc.startLoad(postData.dJX(), 10, true);
            } else {
                this.lJc.setVisibility(8);
            }
            i dJZ = postData.dJZ();
            if (dJZ != null && dJZ.mXr) {
                this.lJd.setVisibility(0);
            } else {
                this.lJd.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.lIR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.lIR.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.lIZ.setText((CharSequence) null);
            this.euO.setText((CharSequence) null);
            this.lEI.setVisibility(8);
            if (!this.fmT) {
                c(postData.blC());
                if (z) {
                    this.lEI.setVisibility(0);
                    ap.setViewTextColor(this.lEI, R.color.CAM_X0302);
                }
            }
            this.lJa.setText(au.getFormatTime(postData.getTime()));
            String format = String.format(this.lIS.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dJQ()));
            if (pVar.bjd() != null && pVar.bjd().bkm()) {
                this.lIZ.setText((CharSequence) null);
            } else {
                this.lIZ.setText(format);
            }
            postData.blC().getUserTbVipInfoData();
            boolean a2 = a(this.lJb, postData.dJS());
            if (StringUtils.isNull(postData.dJX()) && !a2 && postData.bFj() != null) {
                this.akA.setVisibility(0);
                this.akA.setTag(postData.bFj());
                return;
            }
            this.akA.setVisibility(8);
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
                this.euO.setText(dT(metaData.getSealPrefix(), str));
            } else {
                this.euO.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.lIX != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.lIX.setVisibility(8);
                } else {
                    this.lIX.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.esy = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.lIX.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.euO, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.euO, R.color.CAM_X0108);
            }
            this.lIW.setVisibility(0);
            this.lIW.setUserId(metaData.getUserId());
            this.lIW.setUserName(metaData.getUserName());
            this.lIW.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.lIW, metaData);
            this.lIW.startLoad(metaData.getAvater(), 28, false);
            this.lIV.setTag(R.id.tag_user_id, metaData.getUserId());
            this.lIV.setTag(R.id.tag_user_name, metaData.getUserName());
            this.lIV.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bFb() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bFb().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.p(next.bFi());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.kV(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dSx());
                        continue;
                    case 17:
                        String str = next.bFm().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.p("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.bFr()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bFi() == null || tbRichTextData.bFi().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bFi());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.lIS.getPageContext().getString(R.string.refresh_view_button_text), this.etG));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.lIS.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.lIT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.ghN.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kwo.bzV();
        ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.lIS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void Do(int i) {
        b(NoDataViewFactory.d.dS(null, this.lIS.getResources().getString(R.string.refresh_view_title_text)));
        this.lJr.setVisibility(8);
    }

    public void Iu(String str) {
        b(NoDataViewFactory.d.dS(str, this.lIS.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lJr.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ghN.setVisibility(0);
            this.lJr.setVisibility(0);
            this.lIQ.setOnTouchListener(null);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        this.etG = onClickListener;
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
                String userId2 = postData.blC().getUserId();
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
            if (this.lHx != null && this.lHx.bjd() != null && this.lHx.bjd().blC() != null && postData.blC() != null) {
                String userId3 = this.lHx.bjd().blC().getUserId();
                String userId4 = postData.blC().getUserId();
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
                    userId = postData.blC().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dJQ() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.blC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.blC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.blC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.blC().getPortrait());
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
                        if (postData.blC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.blC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.blC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.blC().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.blC() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.blC().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.blC().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.blC().getName_show());
                        }
                        if (this.lHx.bjd() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lHx.bjd().getId());
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
            userId = postData.blC().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dJQ() != 1) {
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

    public void vq(boolean z) {
        if (this.lIq != null && this.lIq.dlT() != null) {
            if (z) {
                this.lIq.dlT().setText(R.string.remove_mark);
            } else {
                this.lIq.dlT().setText(R.string.mark);
            }
        }
    }

    public View dpc() {
        return this.lJk;
    }

    public void onChangeSkinType(int i) {
        this.lIS.getLayoutMode().setNightMode(i == 1);
        this.lIS.getLayoutMode().onModeChanged(this.lIQ);
        this.lIS.getLayoutMode().onModeChanged(this.lIR);
        ap.setBackgroundColor(this.lIQ, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lIT, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.lIS.getPageContext(), i);
        WebPManager.a(this.etB, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.lIU != null) {
            ap.setViewTextColor(this.lIU, R.color.goto_see_subject_color);
        }
        this.fwR.onChangeSkinType(this.lIS.getPageContext(), i);
        this.lIS.getLayoutMode().onModeChanged(this.lJk);
        ap.setViewTextColor(this.lJb, R.color.CAM_X0105);
        this.lJb.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        if (this.kwo != null && this.kwo.byN() != null) {
            this.kwo.byN().onChangeSkinType(i);
        }
        this.lJf.changeSkin(i);
        this.akA.changeSkin();
        ap.setViewTextColor(this.jau, R.color.CAM_X0110);
        ap.setViewTextColor(this.lEI, R.color.CAM_X0302);
        ap.setViewTextColor(this.euO, R.color.CAM_X0108);
        this.jau.setAlpha(0.95f);
        if (this.lJg != null) {
            com.baidu.tbadk.r.a.a(this.lIS.getPageContext(), this.lJg);
        }
        if (this.lJw != null) {
            this.lJw.notifyDataSetChanged();
        }
        this.lIS.getLayoutMode().onModeChanged(this.lJi);
        ap.setBackgroundColor(this.lCb, R.color.CAM_X0203);
        this.lCe.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lCd.setBackgroundDrawable(ap.aP(l.getDimens(this.lIS, R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
    }

    public void dpd() {
        this.mProgress.setVisibility(0);
    }

    public void dpe() {
        this.ghN.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lJf.endLoadData();
    }

    public void cuO() {
        this.ghN.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lJf.cuO();
    }

    public boolean dpf() {
        return this.lIQ.dpf();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lJw.c(onLongClickListener);
    }

    public View dpg() {
        return this.lIR;
    }

    public TextView cCQ() {
        return this.jau;
    }

    public ImageView dph() {
        return this.lJs;
    }

    public ImageView dpi() {
        return this.lJt;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void GS(int i) {
    }

    public View dpj() {
        return this.lIU;
    }

    public View dpk() {
        return this.lJc;
    }

    public MorePopupWindow dpl() {
        return this.lJh;
    }

    public void showLoadingDialog() {
        if (this.ifn == null) {
            this.ifn = new com.baidu.tbadk.core.view.a(this.lIS.getPageContext());
        }
        this.ifn.setDialogVisiable(true);
    }

    public void cgz() {
        if (this.ifn != null) {
            this.ifn.setDialogVisiable(false);
        }
    }

    public TextView dpm() {
        return this.lJb;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lJw.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lJw != null) {
            this.lJw.notifyDataSetChanged();
        }
    }

    public ah dpn() {
        return this.lIq;
    }

    public void cFf() {
    }

    public void cFg() {
    }

    public void cDp() {
        if (this.lIQ != null) {
            this.lIQ.onDestroy();
        }
        if (this.kwo != null) {
            this.kwo.onDestory();
        }
    }

    public void dpo() {
        if (this.lIS.isPaused()) {
        }
    }

    public View dpp() {
        return this.lIV;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.lIS.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dpq() {
        if (this.kwo == null || this.kwo.byN() == null) {
            return 0;
        }
        return this.kwo.byN().getHeight();
    }

    public int dpr() {
        if (this.lJl == null) {
            return 0;
        }
        return this.lJl.getHeight();
    }

    public void dps() {
        if (this.jau != null && this.kwo != null) {
            if (this.kwo.bAa()) {
                this.jau.setText(R.string.draft_to_send);
            } else {
                this.jau.setText(this.lIS.dmM());
            }
        }
    }

    public void uB(boolean z) {
        if (this.lCe != null) {
            this.lCe.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eUM = cVar;
        if (this.lBI != null) {
            this.lBI.setListPullRefreshListener(cVar);
        }
    }
}
