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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
import com.baidu.tbadk.util.af;
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
/* loaded from: classes22.dex */
public class a implements KeyboardEventLayout.a {
    private static final int lCB = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aYF;
    private f.c ePL;
    private NoNetworkView frK;
    private LinearLayout frL;
    private BdTypeListView gcr;
    private com.baidu.tbadk.core.view.a hYx;
    private TextView iTL;
    private View iqS;
    private e jhM;
    private SubPbModel lBZ;
    private p lBj;
    private SubPbView lCC;
    private View lCD;
    private NewSubPbActivity lCE;
    private RelativeLayout lCF;
    private View lCJ;
    private ThreadSkinView lCQ;
    private d lCR;
    private View lCS;
    private View lCU;
    private View lCW;
    private BlankView lCX;
    private com.baidu.tbadk.core.dialog.b lCZ;
    private ah lCc;
    private ArrayList<PostData> lDc;
    private RelativeLayout lDd;
    private ImageView lDe;
    private ImageView lDf;
    private c lDi;
    private View lvM;
    private LinearLayout lvO;
    private HeadImageView lvP;
    private com.baidu.tieba.pb.view.d lvt;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener epw = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lCG = null;
    private LinearLayout lCH = null;
    private HeadImageView lCI = null;
    private TextView eqE = null;
    private ImageView lCK = null;
    private TextView lyv = null;
    private TextView lCL = null;
    private TextView lCM = null;
    private EllipsizeRichTextView lCN = null;
    private TbImageView lCO = null;
    private PlayVoiceBntNew akw = null;
    private TextView lCP = null;
    private MorePopupWindow lCT = null;
    private com.baidu.tbadk.core.dialog.b lCV = null;
    private Dialog lCY = null;
    private com.baidu.tbadk.core.dialog.a lvx = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lDa = null;
    private NewSubPbActivity.a lDb = null;
    private h kpI = null;
    private int fCv = 0;
    private int lDg = 2;
    private int lDh = 0;
    private boolean fhR = true;
    private boolean llm = com.baidu.tbadk.a.d.bfv();
    private com.baidu.tieba.pb.a.c fbT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.7
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.pV(false);
            a.this.pV(true);
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
    protected AdapterView.OnItemLongClickListener lDj = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.lDc, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lCc == null) {
                    a.this.lCc = new ah(a.this.lCE.getPageContext(), a.this.aYF);
                }
                a.this.lCc.PJ();
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
                boolean z2 = a.this.ua(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.lCc;
                int dfX = a.this.lBZ.dfX();
                if (!a.this.llm || postData2 == null || !postData2.mRL) {
                    z = false;
                }
                ahVar.a(sparseArray, dfX, z2, z);
                if (z2) {
                    a.this.lCc.djW().setVisibility(0);
                    a.this.lCc.djW().setTag(postData.getId());
                } else {
                    a.this.lCc.djW().setVisibility(8);
                }
                a.this.lCc.djU().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lDk = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.lCE != null && bg.checkUpIsLogin(a.this.lCE.getPageContext().getPageActivity())) {
                if ((a.this.lCE.kpC == null || a.this.lBZ == null || a.this.lBZ.cuM() == null || a.this.lCE.kpC.oJ(a.this.lBZ.cuM().replyPrivateFlag)) && a.this.lBZ != null && a.this.kpI != null) {
                    a.this.dmU();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dmW();
                        a.this.lBZ.dnw();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kpI.setReplyId(str2);
                            a.this.kpI.DH(str);
                        }
                    }
                    a.this.dmV();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.lCC = null;
        this.lCD = null;
        this.gcr = null;
        this.lvt = null;
        this.lCE = null;
        this.frK = null;
        this.lCF = null;
        this.lCJ = null;
        this.lCR = null;
        this.lCW = null;
        this.aYF = null;
        this.mProgress = null;
        this.iTL = null;
        this.lDd = null;
        this.lDe = null;
        this.lDf = null;
        this.lCE = newSubPbActivity;
        this.aYF = onClickListener;
        this.lCC = (SubPbView) LayoutInflater.from(this.lCE.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.lCD = LayoutInflater.from(this.lCE.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.frL = (LinearLayout) this.lCC.findViewById(R.id.navigation_bar_group);
        this.lDd = (RelativeLayout) this.lCC.findViewById(R.id.subpb_editor_tool_comment);
        this.iTL = (TextView) this.lCC.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.iTL.setOnClickListener(this.aYF);
        this.lDe = (ImageView) this.lCC.findViewById(R.id.subpb_editor_tool_more_img);
        this.lDf = (ImageView) this.lCC.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lDf.setOnClickListener(this.aYF);
        this.lDe.setOnClickListener(this.aYF);
        this.frK = (NoNetworkView) this.lCC.findViewById(R.id.view_no_network);
        cAG();
        bRu();
        this.lCF = (RelativeLayout) this.lCC.findViewById(R.id.sub_pb_body_layout);
        this.gcr = (BdTypeListView) this.lCC.findViewById(R.id.new_sub_pb_list);
        this.lCQ = (ThreadSkinView) LayoutInflater.from(this.lCE.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gcr.addHeaderView(this.lCQ);
        this.gcr.addHeaderView(this.lCD);
        this.iqS = new TextView(newSubPbActivity.getActivity());
        this.iqS.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gcr.addHeaderView(this.iqS, 0);
        this.lCC.setTopView(this.iqS);
        this.lCC.setNavigationView(this.frL);
        this.lCC.setListView(this.gcr);
        this.lCC.setContentView(this.lCF);
        this.lCR = new d(this.lCE.getPageContext());
        this.lCR.setLineGone();
        this.lCW = this.lCR.getView();
        this.gcr.setNextPage(this.lCR);
        this.lCR.setOnClickListener(this.aYF);
        this.gcr.setOnItemClickListener(this.lDk);
        this.gcr.setOnItemLongClickListener(this.lDj);
        this.gcr.setOnTouchListener(this.fbT);
        this.lvt = new com.baidu.tieba.pb.view.d(newSubPbActivity.getPageContext());
        this.lvt.createView();
        this.lvt.setListPullRefreshListener(this.ePL);
        this.lvt.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.lCC.findViewById(R.id.progress);
        this.lvM = this.lCC.findViewById(R.id.view_comment_top_line);
        this.lvO = (LinearLayout) this.lCC.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lvP = (HeadImageView) this.lCC.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lvP.setVisibility(0);
        this.lvP.setIsRound(true);
        this.lvP.setBorderWidth(l.getDimens(this.lCE, R.dimen.tbds1));
        this.lvP.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.lvP.setPlaceHolder(1);
        this.lvP.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lvP.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lCD != null) {
            this.lCD.setVisibility(4);
        }
        this.lCJ = com.baidu.tbadk.ala.b.bfM().q(this.lCE.getActivity(), 4);
        if (this.lCJ != null) {
            this.lCJ.setVisibility(8);
            this.lCH.addView(this.lCJ, 3);
        }
        this.lDi = new c(this.lCE, this.gcr);
        this.lDi.setFromCDN(this.mIsFromCDN);
        this.lDi.A(this.aYF);
        this.lDi.Ly();
    }

    public ListView getListView() {
        return this.gcr;
    }

    public void bRu() {
        this.lCH = (LinearLayout) this.lCD.findViewById(R.id.subpb_head_user_info_root);
        this.lCH.setOnClickListener(this.aYF);
        this.lCI = (HeadImageView) this.lCD.findViewById(R.id.photo);
        this.lCI.setRadius(l.getDimens(this.lCE.getActivity(), R.dimen.tbds45));
        this.lCI.setClickable(false);
        this.eqE = (TextView) this.lCD.findViewById(R.id.user_name);
        this.lCK = (ImageView) this.lCD.findViewById(R.id.user_rank);
        this.lCK.setVisibility(8);
        this.lyv = (TextView) this.lCD.findViewById(R.id.floor_owner);
        this.lCG = (TextView) this.lCD.findViewById(R.id.see_subject);
        this.lCG.setOnClickListener(this.aYF);
        this.lCL = (TextView) this.lCD.findViewById(R.id.floor);
        this.lCM = (TextView) this.lCD.findViewById(R.id.time);
        this.lCN = (EllipsizeRichTextView) this.lCD.findViewById(R.id.content_text);
        this.lCN.setOnClickListener(this.aYF);
        ap.setViewTextColor(this.lCN, R.color.cp_cont_b);
        this.lCN.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.lCN.setLineSpacing(0.0f, 1.25f);
        this.lCO = (TbImageView) this.lCD.findViewById(R.id.sub_pb_image);
        this.lCO.setOnClickListener(this.aYF);
        this.lCP = (TextView) this.lCD.findViewById(R.id.advert);
        this.akw = (PlayVoiceBntNew) this.lCD.findViewById(R.id.voice_btn);
        this.lCD.setOnTouchListener(this.fbT);
        this.lCD.setOnClickListener(this.aYF);
    }

    public void a(b.InterfaceC0564b interfaceC0564b, boolean z) {
        if (this.lCZ != null) {
            this.lCZ.dismiss();
            this.lCZ = null;
        }
        this.lCZ = new com.baidu.tbadk.core.dialog.b(this.lCE.getPageContext().getPageActivity());
        if (z) {
            this.lCZ.a(new String[]{this.lCE.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0564b);
        } else {
            this.lCZ.a(new String[]{this.lCE.getPageContext().getString(R.string.save_to_emotion), this.lCE.getPageContext().getString(R.string.save_to_local)}, interfaceC0564b);
        }
        this.lCZ.d(this.lCE.getPageContext());
        this.lCZ.bmE();
    }

    /* renamed from: do  reason: not valid java name */
    public void m41do(View view) {
        this.lCS = view;
    }

    public void cAG() {
        int dimens = l.getDimens(this.lCE.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.lCE.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.lCC.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lCX != null) {
                    a.this.lCC.onFinish();
                } else {
                    a.this.lCE.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
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

    public void dk(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.lCY == null) {
            this.lCY = new Dialog(this.lCE.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lCY.setCanceledOnTouchOutside(true);
            this.lCY.setCancelable(true);
            this.lCU = LayoutInflater.from(this.lCE.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.lCE.getLayoutMode().onModeChanged(this.lCU);
            this.lCY.setContentView(this.lCU);
            WindowManager.LayoutParams attributes = this.lCY.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.lCE.getPageContext().getPageActivity()) * 0.9d);
            this.lCY.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lCY.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lCY.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lCY.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.lCY != null && (a.this.lCY instanceof Dialog)) {
                        g.b(a.this.lCY, a.this.lCE.getPageContext());
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
                    if (a.this.lCY != null && (a.this.lCY instanceof Dialog)) {
                        g.b(a.this.lCY, a.this.lCE.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lDa != null) {
                        a.this.lDa.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.lCY != null && (a.this.lCY instanceof Dialog)) {
                        g.b(a.this.lCY, a.this.lCE.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.lCE.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lCY, this.lCE.getPageContext());
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
        this.lvx = new com.baidu.tbadk.core.dialog.a(this.lCE.getPageContext().getPageActivity());
        this.lvx.om(i3);
        this.lvx.setYesButtonTag(sparseArray);
        this.lvx.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lDb != null) {
                    a.this.lDb.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lvx.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lvx.iM(true);
        this.lvx.b(this.lCE.getPageContext());
        if (z) {
            this.lvx.bmC();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData cuM;
        if (this.lCE != null && sparseArray != null && this.lCD != null) {
            if (this.jhM == null) {
                this.jhM = new e(this.lCE.getPageContext(), this.lCD);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lBZ != null && (cuM = this.lBZ.cuM()) != null && cuM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cuM.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray2);
            this.jhM.setDefaultReasonArray(new String[]{this.lCE.getString(R.string.delete_thread_reason_1), this.lCE.getString(R.string.delete_thread_reason_2), this.lCE.getString(R.string.delete_thread_reason_3), this.lCE.getString(R.string.delete_thread_reason_4), this.lCE.getString(R.string.delete_thread_reason_5)});
            this.jhM.setData(arVar);
            this.jhM.EG("4");
            this.jhM.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    String R = at.R(jSONArray);
                    if (a.this.lDb != null) {
                        a.this.lDb.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(final boolean z) {
        if (this.gcr != null) {
            if (!z) {
                this.gcr.setEnabled(z);
            } else {
                this.gcr.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gcr.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lDa = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lDb = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.lCE.showToast(this.lCE.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.lCE.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bwY() != null) {
            this.kpI = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.lCF.addView(hVar.bwY(), layoutParams);
            this.kpI.a(new x.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    a.this.dnp();
                }
            });
        }
    }

    public void dmU() {
        if (this.gcr != null) {
            this.lDh = this.gcr.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ua(boolean z) {
        if (this.lBZ == null || this.lBZ.dnt() == null) {
            return false;
        }
        if (this.lBZ.dfX() != 0) {
            return false;
        }
        return (this.lBj == null || this.lBj.bhz() == null || this.lBj.bhz().bka() == null || !TextUtils.equals(this.lBj.bhz().bka().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dmV() {
        if (this.lBZ != null) {
            if ((!dmY() && this.lCW != null && this.lCW.isShown()) || y.isEmpty(this.lDc)) {
                this.lBZ.vg(false);
            } else {
                this.lBZ.vg(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lBZ = subPbModel;
    }

    public void vd(boolean z) {
        if (this.lBZ != null && this.lBZ.dmS() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lCX = new BlankView(this.lCE.getPageContext().getPageActivity());
            this.frL.addView(this.lCX, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lCX.setVisibility(0);
            this.lCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lCE.finish();
                }
            });
            this.lCC.setBlankView(this.lCX);
        }
    }

    public void dmW() {
        b(this.lCE);
        this.gcr.setNextPage(this.lCR);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.xk(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dmY() && this.lCW != null && this.lCW.isShown()) {
                i = (this.lDh - this.lDg) - 1;
            } else {
                i = this.lDh - this.lDg;
            }
            int count = y.getCount(this.lDc);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(y.subList(this.lDc, 0, i));
            y.add(arrayList, postData2);
            y.add(arrayList, postData);
            this.gcr.smoothScrollToPosition(this.lDh + 2);
            this.gcr.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gcr.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gcr.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.lCC;
    }

    public void dly() {
        if (this.lCT != null) {
            g.dismissPopupWindow(this.lCT, this.lCE.getPageContext().getPageActivity());
        }
        if (this.lCV != null) {
            this.lCV.dismiss();
        }
        if (this.lvx != null) {
            this.lvx.dismiss();
        }
        if (this.lCY != null) {
            g.b(this.lCY, this.lCE.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lCc != null) {
            this.lCc.dismiss();
        }
    }

    public void dmX() {
        this.gcr.setNextPage(this.lCR);
        this.lCR.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fhR = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.fhR && this.lCD != null) {
                this.lCD.setVisibility(8);
                this.gcr.removeHeaderView(this.lCD);
                this.lDg = 1;
            }
            this.lBj = pVar;
            if (this.lBj.dgy() != null) {
                this.lBj.dgy().mRL = true;
            }
            if (this.lCD != null) {
                this.lCD.setVisibility(0);
            }
            if (pVar.bhz() != null && pVar.bhz().biK()) {
                this.lCG.setText(R.string.view_original);
            } else {
                this.lCG.setText(R.string.view_subject);
            }
            if (pVar.dgy() != null) {
                this.fCv = pVar.dgy().dHx();
                if (this.fCv > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.lCE.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fCv)));
                    if (this.lCE != null) {
                        this.iTL.setText(this.lCE.dkM());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.lCE.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.lCE.dmS()) {
                    str = "PB";
                }
                if (pVar.dgy().bkw() != null) {
                    this.lCQ.setData(this.lCE.getPageContext(), pVar.dgy().bkw(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", pVar.bya().getId(), pVar.bya().getName(), pVar.bhz().getId(), str));
                } else {
                    this.lCQ.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lCR.startLoadData();
                this.lDi.setHasMoreData(true);
            } else {
                this.lCR.endLoadData();
                this.lDi.setHasMoreData(false);
            }
            this.lDc = pVar.dgG();
            if (this.lDc == null || this.lDc.size() <= lCB) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lDc.size() - lCB;
                Gg(size);
                int firstVisiblePosition = this.gcr.getFirstVisiblePosition() - size;
                View childAt = this.gcr.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lDc);
            if (y.isEmpty(this.lDc)) {
                this.gcr.setNextPage(null);
                if (this.fhR) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.gcr.setNextPage(this.lCR);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fhR) {
                arrayList.add(0, pVar.dgy());
            }
            this.lDi.a(this.lBj.bhz(), arrayList);
            a(pVar, pVar.dgy(), pVar.TQ(), pVar.bfV(), i, z);
            if (i4 > 0) {
                this.gcr.setSelectionFromTop(i3, i2);
            } else if (z2 && !at.isEmpty(this.lCE.dmT().diU())) {
                String diU = this.lCE.dmT().diU();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !diU.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gcr.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gcr.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gcr.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.lBj.dgD() > 1) {
                this.gcr.setPullRefresh(this.lvt);
                this.lCC.setEnableDragExit(false);
                return;
            }
            this.gcr.setPullRefresh(null);
            this.lCC.setEnableDragExit(true);
        }
    }

    private void Gg(int i) {
        if (this.lDc != null) {
            if (this.lDc.size() <= i) {
                this.lDc.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lDc.iterator();
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

    public boolean dmY() {
        return this.lDi.aEj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fhR) {
            if (!StringUtils.isNull(postData.dHE())) {
                this.lCO.setVisibility(0);
                this.lCO.startLoad(postData.dHE(), 10, true);
            } else {
                this.lCO.setVisibility(8);
            }
            i dHG = postData.dHG();
            if (dHG != null && dHG.mQv) {
                this.lCP.setVisibility(0);
            } else {
                this.lCP.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.lCD.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.lCD.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.lCL.setText((CharSequence) null);
            this.eqE.setText((CharSequence) null);
            this.lyv.setVisibility(8);
            if (!this.fhR) {
                c(postData.bka());
                if (z) {
                    this.lyv.setVisibility(0);
                    ap.setViewTextColor(this.lyv, R.color.cp_link_tip_a);
                }
            }
            this.lCM.setText(at.getFormatTime(postData.getTime()));
            String format = String.format(this.lCE.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dHx()));
            if (pVar.bhz() != null && pVar.bhz().biK()) {
                this.lCL.setText((CharSequence) null);
            } else {
                this.lCL.setText(format);
            }
            postData.bka().getUserTbVipInfoData();
            boolean a2 = a(this.lCN, postData.dHz());
            if (StringUtils.isNull(postData.dHE()) && !a2 && postData.bDr() != null) {
                this.akw.setVisibility(0);
                this.akw.setTag(postData.bDr());
                return;
            }
            this.akw.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + af.getTextLength(name_show) > 14) {
                str = af.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.eqE.setText(dT(metaData.getSealPrefix(), str));
            } else {
                this.eqE.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.lCJ != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.lCJ.setVisibility(8);
                } else {
                    this.lCJ.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eol = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.lCJ.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.eqE, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.eqE, R.color.cp_cont_c);
            }
            this.lCI.setVisibility(0);
            this.lCI.setUserId(metaData.getUserId());
            this.lCI.setUserName(metaData.getUserName());
            this.lCI.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.lCI, metaData);
            this.lCI.startLoad(metaData.getAvater(), 28, false);
            this.lCH.setTag(R.id.tag_user_id, metaData.getUserId());
            this.lCH.setTag(R.id.tag_user_name, metaData.getUserName());
            this.lCH.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bDj() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bDj().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.o(next.bDq());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.kL(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dPW());
                        continue;
                    case 17:
                        String str = next.bDu().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.o("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.bDz()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bDq() == null || tbRichTextData.bDq().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bDq());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.lCE.getPageContext().getString(R.string.refresh_view_button_text), this.epw));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.lCE.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.lCF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gcr.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kpI.byg();
        ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.lCE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void CD(int i) {
        b(NoDataViewFactory.d.dS(null, this.lCE.getResources().getString(R.string.refresh_view_title_text)));
        this.lDd.setVisibility(8);
    }

    public void IC(String str) {
        b(NoDataViewFactory.d.dS(str, this.lCE.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lDd.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gcr.setVisibility(0);
            this.lDd.setVisibility(0);
            this.lCC.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.epw = onClickListener;
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
                String userId2 = postData.bka().getUserId();
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
            if (this.lBj != null && this.lBj.bhz() != null && this.lBj.bhz().bka() != null && postData.bka() != null) {
                String userId3 = this.lBj.bhz().bka().getUserId();
                String userId4 = postData.bka().getUserId();
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
                    userId = postData.bka().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dHx() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.bka() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bka().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bka().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bka().getPortrait());
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
                        if (postData.bka() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bka().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bka().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bka().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bka() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bka().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bka().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bka().getName_show());
                        }
                        if (this.lBj.bhz() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lBj.bhz().getId());
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
            userId = postData.bka().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dHx() != 1) {
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

    public void ve(boolean z) {
        if (this.lCc != null && this.lCc.djU() != null) {
            if (z) {
                this.lCc.djU().setText(R.string.remove_mark);
            } else {
                this.lCc.djU().setText(R.string.mark);
            }
        }
    }

    public View dmZ() {
        return this.lCW;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.lCC, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.lCF, R.color.cp_bg_line_d);
        this.lCE.getLayoutMode().setNightMode(i == 1);
        this.lCE.getLayoutMode().onModeChanged(this.lCC);
        this.lCE.getLayoutMode().onModeChanged(this.lCD);
        this.mNavigationBar.onChangeSkinType(this.lCE.getPageContext(), i);
        if (this.lCG != null) {
            ap.setViewTextColor(this.lCG, R.color.goto_see_subject_color);
        }
        this.frK.onChangeSkinType(this.lCE.getPageContext(), i);
        this.lCE.getLayoutMode().onModeChanged(this.lCW);
        ap.setViewTextColor(this.lCN, R.color.cp_cont_b);
        this.lCN.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        if (this.kpI != null && this.kpI.bwY() != null) {
            this.kpI.bwY().onChangeSkinType(i);
        }
        this.lCR.changeSkin(i);
        this.akw.changeSkin();
        ap.setViewTextColor(this.iTL, R.color.cp_cont_e);
        ap.setViewTextColor(this.lyv, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.eqE, R.color.cp_cont_c);
        this.iTL.setAlpha(0.95f);
        if (this.lCS != null) {
            com.baidu.tbadk.r.a.a(this.lCE.getPageContext(), this.lCS);
        }
        if (this.lDi != null) {
            this.lDi.notifyDataSetChanged();
        }
        this.lCE.getLayoutMode().onModeChanged(this.lCU);
        ap.setBackgroundResource(this.lvM, R.drawable.bottom_shadow);
        this.lvP.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.lvO.setBackgroundDrawable(ap.aO(l.getDimens(this.lCE, R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
    }

    public void dna() {
        this.mProgress.setVisibility(0);
    }

    public void dnb() {
        this.gcr.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lCR.endLoadData();
    }

    public void csK() {
        this.gcr.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lCR.csK();
    }

    public boolean dnc() {
        return this.lCC.dnc();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lDi.c(onLongClickListener);
    }

    public View dnd() {
        return this.lCD;
    }

    public TextView cAL() {
        return this.iTL;
    }

    public ImageView dne() {
        return this.lDe;
    }

    public ImageView dnf() {
        return this.lDf;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Gh(int i) {
    }

    public View dng() {
        return this.lCG;
    }

    public View dnh() {
        return this.lCO;
    }

    public MorePopupWindow dni() {
        return this.lCT;
    }

    public void showLoadingDialog() {
        if (this.hYx == null) {
            this.hYx = new com.baidu.tbadk.core.view.a(this.lCE.getPageContext());
        }
        this.hYx.setDialogVisiable(true);
    }

    public void ceD() {
        if (this.hYx != null) {
            this.hYx.setDialogVisiable(false);
        }
    }

    public TextView dnj() {
        return this.lCN;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lDi.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lDi != null) {
            this.lDi.notifyDataSetChanged();
        }
    }

    public ah dnk() {
        return this.lCc;
    }

    public void cCZ() {
    }

    public void cDa() {
    }

    public void cBk() {
        this.lCC.onDestroy();
    }

    public void dnl() {
        if (this.lCE.isPaused()) {
        }
    }

    public View dnm() {
        return this.lCH;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.lCE.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dnn() {
        if (this.kpI == null || this.kpI.bwY() == null) {
            return 0;
        }
        return this.kpI.bwY().getHeight();
    }

    public int dno() {
        if (this.lCX == null) {
            return 0;
        }
        return this.lCX.getHeight();
    }

    public void dnp() {
        if (this.iTL != null && this.kpI != null) {
            if (this.kpI.byl()) {
                this.iTL.setText(R.string.draft_to_send);
            } else {
                this.iTL.setText(this.lCE.dkM());
            }
        }
    }

    public void up(boolean z) {
        if (this.lvP != null) {
            this.lvP.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.ePL = cVar;
        if (this.lvt != null) {
            this.lvt.setListPullRefreshListener(cVar);
        }
    }
}
