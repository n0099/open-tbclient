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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
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
/* loaded from: classes16.dex */
public class a implements KeyboardEventLayout.a {
    private static final int kSh = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aRW;
    private NoNetworkView eUj;
    private LinearLayout eUk;
    private f.c eta;
    private BdTypeListView fCT;
    private View hIu;
    private com.baidu.tbadk.core.view.a hqa;
    private TextView ilu;
    private e izf;
    private com.baidu.tieba.pb.view.d kLd;
    private View kLw;
    private LinearLayout kLy;
    private HeadImageView kLz;
    private p kQQ;
    private SubPbModel kRF;
    private ah kRI;
    private View kSA;
    private View kSC;
    private BlankView kSD;
    private com.baidu.tbadk.core.dialog.b kSF;
    private ArrayList<PostData> kSI;
    private RelativeLayout kSJ;
    private ImageView kSK;
    private ImageView kSL;
    private c kSO;
    private SubPbView kSi;
    private View kSj;
    private NewSubPbActivity kSk;
    private RelativeLayout kSl;
    private View kSp;
    private ThreadSkinView kSw;
    private d kSx;
    private View kSy;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dSM = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kSm = null;
    private LinearLayout kSn = null;
    private HeadImageView kSo = null;
    private TextView dTU = null;
    private ImageView kSq = null;
    private TextView kOe = null;
    private TextView kSr = null;
    private TextView kSs = null;
    private EllipsizeRichTextView kSt = null;
    private TbImageView kSu = null;
    private PlayVoiceBntNew ajF = null;
    private TextView kSv = null;
    private MorePopupWindow kSz = null;
    private com.baidu.tbadk.core.dialog.b kSB = null;
    private Dialog kSE = null;
    private com.baidu.tbadk.core.dialog.a kLh = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a kSG = null;
    private NewSubPbActivity.a kSH = null;
    private h jFJ = null;
    private int feS = 0;
    private int kSM = 2;
    private int kSN = 0;
    private boolean eKX = true;
    private boolean kBf = com.baidu.tbadk.a.d.baf();
    private com.baidu.tieba.pb.a.c eFj = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.7
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.oS(false);
            a.this.oS(true);
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
    protected AdapterView.OnItemLongClickListener kSP = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.kSI, i);
            if (view != null && view.getTag() != null) {
                if (a.this.kRI == null) {
                    a.this.kRI = new ah(a.this.kSk.getPageContext(), a.this.aRW);
                }
                a.this.kRI.Nv();
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
                boolean z2 = a.this.sV(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.kRI;
                int cVB = a.this.kRF.cVB();
                if (!a.this.kBf || postData2 == null || !postData2.mfZ) {
                    z = false;
                }
                ahVar.a(sparseArray, cVB, z2, z);
                if (z2) {
                    a.this.kRI.cZD().setVisibility(0);
                    a.this.kRI.cZD().setTag(postData.getId());
                } else {
                    a.this.kRI.cZD().setVisibility(8);
                }
                a.this.kRI.cZB().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener kSQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.kSk != null && bg.checkUpIsLogin(a.this.kSk.getPageContext().getPageActivity())) {
                if ((a.this.kSk.jFD == null || a.this.kRF == null || a.this.kRF.ckU() == null || a.this.kSk.jFD.nP(a.this.kRF.ckU().replyPrivateFlag)) && a.this.kRF != null && a.this.jFJ != null) {
                    a.this.dcA();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dcC();
                        a.this.kRF.ddb();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.jFJ.setReplyId(str2);
                            a.this.jFJ.Cg(str);
                        }
                    }
                    a.this.dcB();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.kSi = null;
        this.kSj = null;
        this.fCT = null;
        this.kLd = null;
        this.kSk = null;
        this.eUj = null;
        this.kSl = null;
        this.kSp = null;
        this.kSx = null;
        this.kSC = null;
        this.aRW = null;
        this.mProgress = null;
        this.ilu = null;
        this.kSJ = null;
        this.kSK = null;
        this.kSL = null;
        this.kSk = newSubPbActivity;
        this.aRW = onClickListener;
        this.kSi = (SubPbView) LayoutInflater.from(this.kSk.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.kSj = LayoutInflater.from(this.kSk.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.eUk = (LinearLayout) this.kSi.findViewById(R.id.navigation_bar_group);
        this.kSJ = (RelativeLayout) this.kSi.findViewById(R.id.subpb_editor_tool_comment);
        this.ilu = (TextView) this.kSi.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.ilu.setOnClickListener(this.aRW);
        this.kSK = (ImageView) this.kSi.findViewById(R.id.subpb_editor_tool_more_img);
        this.kSL = (ImageView) this.kSi.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.kSL.setOnClickListener(this.aRW);
        this.kSK.setOnClickListener(this.aRW);
        this.eUj = (NoNetworkView) this.kSi.findViewById(R.id.view_no_network);
        cqP();
        bKV();
        this.kSl = (RelativeLayout) this.kSi.findViewById(R.id.sub_pb_body_layout);
        this.fCT = (BdTypeListView) this.kSi.findViewById(R.id.new_sub_pb_list);
        this.kSw = (ThreadSkinView) LayoutInflater.from(this.kSk.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.fCT.addHeaderView(this.kSw);
        this.fCT.addHeaderView(this.kSj);
        this.hIu = new TextView(newSubPbActivity.getActivity());
        this.hIu.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.fCT.addHeaderView(this.hIu, 0);
        this.kSi.setTopView(this.hIu);
        this.kSi.setNavigationView(this.eUk);
        this.kSi.setListView(this.fCT);
        this.kSi.setContentView(this.kSl);
        this.kSx = new d(this.kSk.getPageContext());
        this.kSx.setLineGone();
        this.kSC = this.kSx.getView();
        this.fCT.setNextPage(this.kSx);
        this.kSx.setOnClickListener(this.aRW);
        this.fCT.setOnItemClickListener(this.kSQ);
        this.fCT.setOnItemLongClickListener(this.kSP);
        this.fCT.setOnTouchListener(this.eFj);
        this.kLd = new com.baidu.tieba.pb.view.d(newSubPbActivity.getPageContext());
        this.kLd.createView();
        this.kLd.setListPullRefreshListener(this.eta);
        this.kLd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.kSi.findViewById(R.id.progress);
        this.kLw = this.kSi.findViewById(R.id.view_comment_top_line);
        this.kLy = (LinearLayout) this.kSi.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kLz = (HeadImageView) this.kSi.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kLz.setVisibility(0);
        this.kLz.setIsRound(true);
        this.kLz.setBorderWidth(l.getDimens(this.kSk, R.dimen.tbds1));
        this.kLz.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kLz.setPlaceHolder(1);
        this.kLz.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kLz.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kSj != null) {
            this.kSj.setVisibility(4);
        }
        this.kSp = com.baidu.tbadk.ala.b.bar().q(this.kSk.getActivity(), 4);
        if (this.kSp != null) {
            this.kSp.setVisibility(8);
            this.kSn.addView(this.kSp, 3);
        }
        this.kSO = new c(this.kSk, this.fCT);
        this.kSO.setFromCDN(this.mIsFromCDN);
        this.kSO.A(this.aRW);
        this.kSO.Jv();
    }

    public ListView getListView() {
        return this.fCT;
    }

    public void bKV() {
        this.kSn = (LinearLayout) this.kSj.findViewById(R.id.subpb_head_user_info_root);
        this.kSn.setOnClickListener(this.aRW);
        this.kSo = (HeadImageView) this.kSj.findViewById(R.id.photo);
        this.kSo.setRadius(l.getDimens(this.kSk.getActivity(), R.dimen.tbds45));
        this.kSo.setClickable(false);
        this.dTU = (TextView) this.kSj.findViewById(R.id.user_name);
        this.kSq = (ImageView) this.kSj.findViewById(R.id.user_rank);
        this.kSq.setVisibility(8);
        this.kOe = (TextView) this.kSj.findViewById(R.id.floor_owner);
        this.kSm = (TextView) this.kSj.findViewById(R.id.see_subject);
        this.kSm.setOnClickListener(this.aRW);
        this.kSr = (TextView) this.kSj.findViewById(R.id.floor);
        this.kSs = (TextView) this.kSj.findViewById(R.id.time);
        this.kSt = (EllipsizeRichTextView) this.kSj.findViewById(R.id.content_text);
        this.kSt.setOnClickListener(this.aRW);
        ap.setViewTextColor(this.kSt, R.color.cp_cont_b);
        this.kSt.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.kSt.setLineSpacing(0.0f, 1.25f);
        this.kSu = (TbImageView) this.kSj.findViewById(R.id.sub_pb_image);
        this.kSu.setOnClickListener(this.aRW);
        this.kSv = (TextView) this.kSj.findViewById(R.id.advert);
        this.ajF = (PlayVoiceBntNew) this.kSj.findViewById(R.id.voice_btn);
        this.kSj.setOnTouchListener(this.eFj);
        this.kSj.setOnClickListener(this.aRW);
    }

    public void a(b.InterfaceC0538b interfaceC0538b, boolean z) {
        if (this.kSF != null) {
            this.kSF.dismiss();
            this.kSF = null;
        }
        this.kSF = new com.baidu.tbadk.core.dialog.b(this.kSk.getPageContext().getPageActivity());
        if (z) {
            this.kSF.a(new String[]{this.kSk.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0538b);
        } else {
            this.kSF.a(new String[]{this.kSk.getPageContext().getString(R.string.save_to_emotion), this.kSk.getPageContext().getString(R.string.save_to_local)}, interfaceC0538b);
        }
        this.kSF.d(this.kSk.getPageContext());
        this.kSF.bhi();
    }

    public void cY(View view) {
        this.kSy = view;
    }

    public void cqP() {
        int dimens = l.getDimens(this.kSk.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.kSk.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.kSi.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kSD != null) {
                    a.this.kSi.onFinish();
                } else {
                    a.this.kSk.finish();
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

    public void cT(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.kSE == null) {
            this.kSE = new Dialog(this.kSk.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kSE.setCanceledOnTouchOutside(true);
            this.kSE.setCancelable(true);
            this.kSA = LayoutInflater.from(this.kSk.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.kSk.getLayoutMode().onModeChanged(this.kSA);
            this.kSE.setContentView(this.kSA);
            WindowManager.LayoutParams attributes = this.kSE.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.kSk.getPageContext().getPageActivity()) * 0.9d);
            this.kSE.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.kSE.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.kSE.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.kSE.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.kSE != null && (a.this.kSE instanceof Dialog)) {
                        g.b(a.this.kSE, a.this.kSk.getPageContext());
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
                    if (a.this.kSE != null && (a.this.kSE instanceof Dialog)) {
                        g.b(a.this.kSE, a.this.kSk.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.kSG != null) {
                        a.this.kSG.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.kSE != null && (a.this.kSE instanceof Dialog)) {
                        g.b(a.this.kSE, a.this.kSk.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.kSk.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.kSE, this.kSk.getPageContext());
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
        this.kLh = new com.baidu.tbadk.core.dialog.a(this.kSk.getPageContext().getPageActivity());
        this.kLh.nt(i3);
        this.kLh.setYesButtonTag(sparseArray);
        this.kLh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.kSH != null) {
                    a.this.kSH.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.kLh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kLh.ig(true);
        this.kLh.b(this.kSk.getPageContext());
        if (z) {
            this.kLh.bhg();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData ckU;
        if (this.kSk != null && sparseArray != null && this.kSj != null) {
            if (this.izf == null) {
                this.izf = new e(this.kSk.getPageContext(), this.kSj);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.kRF != null && (ckU = this.kRF.ckU()) != null && ckU.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckU.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray2);
            this.izf.setDefaultReasonArray(new String[]{this.kSk.getString(R.string.delete_thread_reason_1), this.kSk.getString(R.string.delete_thread_reason_2), this.kSk.getString(R.string.delete_thread_reason_3), this.kSk.getString(R.string.delete_thread_reason_4), this.kSk.getString(R.string.delete_thread_reason_5)});
            this.izf.setData(arVar);
            this.izf.Df("4");
            this.izf.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    String R = at.R(jSONArray);
                    if (a.this.kSH != null) {
                        a.this.kSH.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(final boolean z) {
        if (this.fCT != null) {
            if (!z) {
                this.fCT.setEnabled(z);
            } else {
                this.fCT.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fCT.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.kSG = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.kSH = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.kSk.showToast(this.kSk.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.kSk.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.brw() != null) {
            this.jFJ = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.kSl.addView(hVar.brw(), layoutParams);
            this.jFJ.a(new x.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    a.this.dcV();
                }
            });
        }
    }

    public void dcA() {
        if (this.fCT != null) {
            this.kSN = this.fCT.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sV(boolean z) {
        if (this.kRF == null || this.kRF.dcY() == null) {
            return false;
        }
        if (this.kRF.cVB() != 0) {
            return false;
        }
        return (this.kQQ == null || this.kQQ.bce() == null || this.kQQ.bce().beE() == null || !TextUtils.equals(this.kQQ.bce().beE().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dcB() {
        if (this.kRF != null) {
            if ((!dcE() && this.kSC != null && this.kSC.isShown()) || y.isEmpty(this.kSI)) {
                this.kRF.ua(false);
            } else {
                this.kRF.ua(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.kRF = subPbModel;
    }

    public void tX(boolean z) {
        if (this.kRF != null && this.kRF.dcy() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.kSD = new BlankView(this.kSk.getPageContext().getPageActivity());
            this.eUk.addView(this.kSD, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.kSD.setVisibility(0);
            this.kSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kSk.finish();
                }
            });
            this.kSi.setBlankView(this.kSD);
        }
    }

    public void dcC() {
        b(this.kSk);
        this.fCT.setNextPage(this.kSx);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.wd(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dcE() && this.kSC != null && this.kSC.isShown()) {
                i = (this.kSN - this.kSM) - 1;
            } else {
                i = this.kSN - this.kSM;
            }
            int count = y.getCount(this.kSI);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(y.subList(this.kSI, 0, i));
            y.add(arrayList, postData2);
            y.add(arrayList, postData);
            this.fCT.smoothScrollToPosition(this.kSN + 2);
            this.fCT.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fCT.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.fCT.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.kSi;
    }

    public void dbf() {
        if (this.kSz != null) {
            g.dismissPopupWindow(this.kSz, this.kSk.getPageContext().getPageActivity());
        }
        if (this.kSB != null) {
            this.kSB.dismiss();
        }
        if (this.kLh != null) {
            this.kLh.dismiss();
        }
        if (this.kSE != null) {
            g.b(this.kSE, this.kSk.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.kRI != null) {
            this.kRI.dismiss();
        }
    }

    public void dcD() {
        this.fCT.setNextPage(this.kSx);
        this.kSx.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.eKX = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.eKX && this.kSj != null) {
                this.kSj.setVisibility(8);
                this.fCT.removeHeaderView(this.kSj);
                this.kSM = 1;
            }
            this.kQQ = pVar;
            if (this.kQQ.cWi() != null) {
                this.kQQ.cWi().mfZ = true;
            }
            if (this.kSj != null) {
                this.kSj.setVisibility(0);
            }
            if (pVar.bce() != null && pVar.bce().bdo()) {
                this.kSm.setText(R.string.view_original);
            } else {
                this.kSm.setText(R.string.view_subject);
            }
            if (pVar.cWi() != null) {
                this.feS = pVar.cWi().dwK();
                if (this.feS > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.kSk.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.feS)));
                    if (this.kSk != null) {
                        this.ilu.setText(this.kSk.dat());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.kSk.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.kSk.dcy()) {
                    str = "PB";
                }
                if (pVar.cWi().bfa() != null) {
                    this.kSw.setData(this.kSk.getPageContext(), pVar.cWi().bfa(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", pVar.bst().getId(), pVar.bst().getName(), pVar.bce().getId(), str));
                } else {
                    this.kSw.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.kSx.startLoadData();
                this.kSO.setHasMoreData(true);
            } else {
                this.kSx.endLoadData();
                this.kSO.setHasMoreData(false);
            }
            this.kSI = pVar.cWm();
            if (this.kSI == null || this.kSI.size() <= kSh) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.kSI.size() - kSh;
                EG(size);
                int firstVisiblePosition = this.fCT.getFirstVisiblePosition() - size;
                View childAt = this.fCT.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kSI);
            if (y.isEmpty(this.kSI)) {
                this.fCT.setNextPage(null);
                if (this.eKX) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.fCT.setNextPage(this.kSx);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.eKX) {
                arrayList.add(0, pVar.cWi());
            }
            this.kSO.a(this.kQQ.bce(), arrayList);
            a(pVar, pVar.cWi(), pVar.cHD(), pVar.baA(), i, z);
            if (i4 > 0) {
                this.fCT.setSelectionFromTop(i3, i2);
            } else if (z2 && !at.isEmpty(this.kSk.dcz().cYB())) {
                String cYB = this.kSk.dcz().cYB();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !cYB.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.fCT.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.fCT.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.fCT.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.kQQ.cWj() > 1) {
                this.fCT.setPullRefresh(this.kLd);
                this.kSi.setEnableDragExit(false);
                return;
            }
            this.fCT.setPullRefresh(null);
            this.kSi.setEnableDragExit(true);
        }
    }

    private void EG(int i) {
        if (this.kSI != null) {
            if (this.kSI.size() <= i) {
                this.kSI.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.kSI.iterator();
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

    public boolean dcE() {
        return this.kSO.ayX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eKX) {
            if (!StringUtils.isNull(postData.dwR())) {
                this.kSu.setVisibility(0);
                this.kSu.startLoad(postData.dwR(), 10, true);
            } else {
                this.kSu.setVisibility(8);
            }
            i dwT = postData.dwT();
            if (dwT != null && dwT.meK) {
                this.kSv.setVisibility(0);
            } else {
                this.kSv.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.kSj.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.kSj.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.kSr.setText((CharSequence) null);
            this.dTU.setText((CharSequence) null);
            this.kOe.setVisibility(8);
            if (!this.eKX) {
                c(postData.beE());
                if (z) {
                    this.kOe.setVisibility(0);
                    ap.setViewTextColor(this.kOe, R.color.cp_link_tip_a);
                }
            }
            this.kSs.setText(at.getFormatTime(postData.getTime()));
            String format = String.format(this.kSk.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dwK()));
            if (pVar.bce() != null && pVar.bce().bdo()) {
                this.kSr.setText((CharSequence) null);
            } else {
                this.kSr.setText(format);
            }
            postData.beE().getUserTbVipInfoData();
            boolean a = a(this.kSt, postData.dwM());
            if (StringUtils.isNull(postData.dwR()) && !a && postData.bxF() != null) {
                this.ajF.setVisibility(0);
                this.ajF.setTag(postData.bxF());
                return;
            }
            this.ajF.setVisibility(8);
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
                this.dTU.setText(dF(metaData.getSealPrefix(), str));
            } else {
                this.dTU.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.kSp != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.kSp.setVisibility(8);
                } else {
                    this.kSp.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dRB = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.kSp.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.dTU, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.dTU, R.color.cp_cont_c);
            }
            this.kSo.setVisibility(0);
            this.kSo.setUserId(metaData.getUserId());
            this.kSo.setUserName(metaData.getUserName());
            this.kSo.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.kSo, metaData);
            this.kSo.startLoad(metaData.getAvater(), 28, false);
            this.kSn.setTag(R.id.tag_user_id, metaData.getUserId());
            this.kSn.setTag(R.id.tag_user_name, metaData.getUserName());
            this.kSn.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bxx() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bxx().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.n(next.bxE());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.jZ(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dFi());
                        continue;
                    case 17:
                        String str = next.bxI().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.n("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.bxN()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bxE() == null || tbRichTextData.bxE().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bxE());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.kSk.getPageContext().getString(R.string.refresh_view_button_text), this.dSM));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.kSk.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.kSl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.fCT.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.jFJ.bsz();
        ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.kSk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void Bd(int i) {
        b(NoDataViewFactory.d.dE(null, this.kSk.getResources().getString(R.string.refresh_view_title_text)));
        this.kSJ.setVisibility(8);
    }

    public void GT(String str) {
        b(NoDataViewFactory.d.dE(str, this.kSk.getPageContext().getString(R.string.refresh_view_title_text)));
        this.kSJ.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.fCT.setVisibility(0);
            this.kSJ.setVisibility(0);
            this.kSi.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSM = onClickListener;
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
                String userId2 = postData.beE().getUserId();
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
            if (this.kQQ != null && this.kQQ.bce() != null && this.kQQ.bce().beE() != null && postData.beE() != null) {
                String userId3 = this.kQQ.bce().beE().getUserId();
                String userId4 = postData.beE().getUserId();
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
                    userId = postData.beE().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dwK() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.beE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.beE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.beE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.beE().getPortrait());
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
                        if (postData.beE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.beE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.beE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.beE().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.beE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.beE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.beE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.beE().getName_show());
                        }
                        if (this.kQQ.bce() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kQQ.bce().getId());
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
            userId = postData.beE().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dwK() != 1) {
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

    public void tY(boolean z) {
        if (this.kRI != null && this.kRI.cZB() != null) {
            if (z) {
                this.kRI.cZB().setText(R.string.remove_mark);
            } else {
                this.kRI.cZB().setText(R.string.mark);
            }
        }
    }

    public View dcF() {
        return this.kSC;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.kSi, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.kSl, R.color.cp_bg_line_d);
        this.kSk.getLayoutMode().setNightMode(i == 1);
        this.kSk.getLayoutMode().onModeChanged(this.kSi);
        this.kSk.getLayoutMode().onModeChanged(this.kSj);
        this.mNavigationBar.onChangeSkinType(this.kSk.getPageContext(), i);
        if (this.kSm != null) {
            ap.setViewTextColor(this.kSm, R.color.goto_see_subject_color);
        }
        this.eUj.onChangeSkinType(this.kSk.getPageContext(), i);
        this.kSk.getLayoutMode().onModeChanged(this.kSC);
        ap.setViewTextColor(this.kSt, R.color.cp_cont_b);
        this.kSt.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        if (this.jFJ != null && this.jFJ.brw() != null) {
            this.jFJ.brw().onChangeSkinType(i);
        }
        this.kSx.changeSkin(i);
        this.ajF.changeSkin();
        ap.setViewTextColor(this.ilu, R.color.cp_cont_e);
        ap.setViewTextColor(this.kOe, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.dTU, R.color.cp_cont_c);
        this.ilu.setAlpha(0.95f);
        if (this.kSy != null) {
            com.baidu.tbadk.r.a.a(this.kSk.getPageContext(), this.kSy);
        }
        if (this.kSO != null) {
            this.kSO.notifyDataSetChanged();
        }
        this.kSk.getLayoutMode().onModeChanged(this.kSA);
        ap.setBackgroundResource(this.kLw, R.drawable.bottom_shadow);
        this.kLz.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kLy.setBackgroundDrawable(ap.aO(l.getDimens(this.kSk, R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
    }

    public void dcG() {
        this.mProgress.setVisibility(0);
    }

    public void dcH() {
        this.fCT.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kSx.endLoadData();
    }

    public void ciS() {
        this.fCT.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kSx.ciS();
    }

    public boolean dcI() {
        return this.kSi.dcI();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kSO.c(onLongClickListener);
    }

    public View dcJ() {
        return this.kSj;
    }

    public TextView cqU() {
        return this.ilu;
    }

    public ImageView dcK() {
        return this.kSK;
    }

    public ImageView dcL() {
        return this.kSL;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void EH(int i) {
    }

    public View dcM() {
        return this.kSm;
    }

    public View dcN() {
        return this.kSu;
    }

    public MorePopupWindow dcO() {
        return this.kSz;
    }

    public void showLoadingDialog() {
        if (this.hqa == null) {
            this.hqa = new com.baidu.tbadk.core.view.a(this.kSk.getPageContext());
        }
        this.hqa.setDialogVisiable(true);
    }

    public void bWr() {
        if (this.hqa != null) {
            this.hqa.setDialogVisiable(false);
        }
    }

    public TextView dcP() {
        return this.kSt;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kSO.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.kSO != null) {
            this.kSO.notifyDataSetChanged();
        }
    }

    public ah dcQ() {
        return this.kRI;
    }

    public void cte() {
    }

    public void ctf() {
    }

    public void crr() {
        this.kSi.onDestroy();
    }

    public void dcR() {
        if (this.kSk.isPaused()) {
        }
    }

    public View dcS() {
        return this.kSn;
    }

    private SpannableStringBuilder dF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.kSk.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dcT() {
        if (this.jFJ == null || this.jFJ.brw() == null) {
            return 0;
        }
        return this.jFJ.brw().getHeight();
    }

    public int dcU() {
        if (this.kSD == null) {
            return 0;
        }
        return this.kSD.getHeight();
    }

    public void dcV() {
        if (this.ilu != null && this.jFJ != null) {
            if (this.jFJ.bsE()) {
                this.ilu.setText(R.string.draft_to_send);
            } else {
                this.ilu.setText(this.kSk.dat());
            }
        }
    }

    public void tk(boolean z) {
        if (this.kLz != null) {
            this.kLz.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eta = cVar;
        if (this.kLd != null) {
            this.kLd.setListPullRefreshListener(cVar);
        }
    }
}
