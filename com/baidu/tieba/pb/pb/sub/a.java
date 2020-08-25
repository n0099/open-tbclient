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
    private static final int kSa = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aRU;
    private NoNetworkView eUf;
    private LinearLayout eUg;
    private f.c esW;
    private BdTypeListView fCP;
    private View hIo;
    private com.baidu.tbadk.core.view.a hpW;
    private TextView ilo;
    private e iyZ;
    private com.baidu.tieba.pb.view.d kKW;
    private View kLp;
    private LinearLayout kLr;
    private HeadImageView kLs;
    private p kQJ;
    private ah kRB;
    private SubPbModel kRy;
    private ArrayList<PostData> kSB;
    private RelativeLayout kSC;
    private ImageView kSD;
    private ImageView kSE;
    private c kSH;
    private SubPbView kSb;
    private View kSc;
    private NewSubPbActivity kSd;
    private RelativeLayout kSe;
    private View kSi;
    private ThreadSkinView kSp;
    private d kSq;
    private View kSr;
    private View kSt;
    private View kSv;
    private BlankView kSw;
    private com.baidu.tbadk.core.dialog.b kSy;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dSI = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kSf = null;
    private LinearLayout kSg = null;
    private HeadImageView kSh = null;
    private TextView dTQ = null;
    private ImageView kSj = null;
    private TextView kNX = null;
    private TextView kSk = null;
    private TextView kSl = null;
    private EllipsizeRichTextView kSm = null;
    private TbImageView kSn = null;
    private PlayVoiceBntNew ajD = null;
    private TextView kSo = null;
    private MorePopupWindow kSs = null;
    private com.baidu.tbadk.core.dialog.b kSu = null;
    private Dialog kSx = null;
    private com.baidu.tbadk.core.dialog.a kLa = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a kSz = null;
    private NewSubPbActivity.a kSA = null;
    private h jFD = null;
    private int feO = 0;
    private int kSF = 2;
    private int kSG = 0;
    private boolean eKT = true;
    private boolean kAY = com.baidu.tbadk.a.d.baf();
    private com.baidu.tieba.pb.a.c eFf = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.7
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.oQ(false);
            a.this.oQ(true);
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
    protected AdapterView.OnItemLongClickListener kSI = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.kSB, i);
            if (view != null && view.getTag() != null) {
                if (a.this.kRB == null) {
                    a.this.kRB = new ah(a.this.kSd.getPageContext(), a.this.aRU);
                }
                a.this.kRB.Nv();
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
                boolean z2 = a.this.sT(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.kRB;
                int cVA = a.this.kRy.cVA();
                if (!a.this.kAY || postData2 == null || !postData2.mfK) {
                    z = false;
                }
                ahVar.a(sparseArray, cVA, z2, z);
                if (z2) {
                    a.this.kRB.cZC().setVisibility(0);
                    a.this.kRB.cZC().setTag(postData.getId());
                } else {
                    a.this.kRB.cZC().setVisibility(8);
                }
                a.this.kRB.cZA().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener kSJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.kSd != null && bg.checkUpIsLogin(a.this.kSd.getPageContext().getPageActivity())) {
                if ((a.this.kSd.jFx == null || a.this.kRy == null || a.this.kRy.ckT() == null || a.this.kSd.jFx.nP(a.this.kRy.ckT().replyPrivateFlag)) && a.this.kRy != null && a.this.jFD != null) {
                    a.this.dcz();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dcB();
                        a.this.kRy.dda();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.jFD.setReplyId(str2);
                            a.this.jFD.Cf(str);
                        }
                    }
                    a.this.dcA();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.kSb = null;
        this.kSc = null;
        this.fCP = null;
        this.kKW = null;
        this.kSd = null;
        this.eUf = null;
        this.kSe = null;
        this.kSi = null;
        this.kSq = null;
        this.kSv = null;
        this.aRU = null;
        this.mProgress = null;
        this.ilo = null;
        this.kSC = null;
        this.kSD = null;
        this.kSE = null;
        this.kSd = newSubPbActivity;
        this.aRU = onClickListener;
        this.kSb = (SubPbView) LayoutInflater.from(this.kSd.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.kSc = LayoutInflater.from(this.kSd.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.eUg = (LinearLayout) this.kSb.findViewById(R.id.navigation_bar_group);
        this.kSC = (RelativeLayout) this.kSb.findViewById(R.id.subpb_editor_tool_comment);
        this.ilo = (TextView) this.kSb.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.ilo.setOnClickListener(this.aRU);
        this.kSD = (ImageView) this.kSb.findViewById(R.id.subpb_editor_tool_more_img);
        this.kSE = (ImageView) this.kSb.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.kSE.setOnClickListener(this.aRU);
        this.kSD.setOnClickListener(this.aRU);
        this.eUf = (NoNetworkView) this.kSb.findViewById(R.id.view_no_network);
        cqO();
        bKU();
        this.kSe = (RelativeLayout) this.kSb.findViewById(R.id.sub_pb_body_layout);
        this.fCP = (BdTypeListView) this.kSb.findViewById(R.id.new_sub_pb_list);
        this.kSp = (ThreadSkinView) LayoutInflater.from(this.kSd.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.fCP.addHeaderView(this.kSp);
        this.fCP.addHeaderView(this.kSc);
        this.hIo = new TextView(newSubPbActivity.getActivity());
        this.hIo.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.fCP.addHeaderView(this.hIo, 0);
        this.kSb.setTopView(this.hIo);
        this.kSb.setNavigationView(this.eUg);
        this.kSb.setListView(this.fCP);
        this.kSb.setContentView(this.kSe);
        this.kSq = new d(this.kSd.getPageContext());
        this.kSq.setLineGone();
        this.kSv = this.kSq.getView();
        this.fCP.setNextPage(this.kSq);
        this.kSq.setOnClickListener(this.aRU);
        this.fCP.setOnItemClickListener(this.kSJ);
        this.fCP.setOnItemLongClickListener(this.kSI);
        this.fCP.setOnTouchListener(this.eFf);
        this.kKW = new com.baidu.tieba.pb.view.d(newSubPbActivity.getPageContext());
        this.kKW.createView();
        this.kKW.setListPullRefreshListener(this.esW);
        this.kKW.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.kSb.findViewById(R.id.progress);
        this.kLp = this.kSb.findViewById(R.id.view_comment_top_line);
        this.kLr = (LinearLayout) this.kSb.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kLs = (HeadImageView) this.kSb.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kLs.setVisibility(0);
        this.kLs.setIsRound(true);
        this.kLs.setBorderWidth(l.getDimens(this.kSd, R.dimen.tbds1));
        this.kLs.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kLs.setPlaceHolder(1);
        this.kLs.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kLs.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kSc != null) {
            this.kSc.setVisibility(4);
        }
        this.kSi = com.baidu.tbadk.ala.b.bar().q(this.kSd.getActivity(), 4);
        if (this.kSi != null) {
            this.kSi.setVisibility(8);
            this.kSg.addView(this.kSi, 3);
        }
        this.kSH = new c(this.kSd, this.fCP);
        this.kSH.setFromCDN(this.mIsFromCDN);
        this.kSH.A(this.aRU);
        this.kSH.Jv();
    }

    public ListView getListView() {
        return this.fCP;
    }

    public void bKU() {
        this.kSg = (LinearLayout) this.kSc.findViewById(R.id.subpb_head_user_info_root);
        this.kSg.setOnClickListener(this.aRU);
        this.kSh = (HeadImageView) this.kSc.findViewById(R.id.photo);
        this.kSh.setRadius(l.getDimens(this.kSd.getActivity(), R.dimen.tbds45));
        this.kSh.setClickable(false);
        this.dTQ = (TextView) this.kSc.findViewById(R.id.user_name);
        this.kSj = (ImageView) this.kSc.findViewById(R.id.user_rank);
        this.kSj.setVisibility(8);
        this.kNX = (TextView) this.kSc.findViewById(R.id.floor_owner);
        this.kSf = (TextView) this.kSc.findViewById(R.id.see_subject);
        this.kSf.setOnClickListener(this.aRU);
        this.kSk = (TextView) this.kSc.findViewById(R.id.floor);
        this.kSl = (TextView) this.kSc.findViewById(R.id.time);
        this.kSm = (EllipsizeRichTextView) this.kSc.findViewById(R.id.content_text);
        this.kSm.setOnClickListener(this.aRU);
        ap.setViewTextColor(this.kSm, R.color.cp_cont_b);
        this.kSm.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.kSm.setLineSpacing(0.0f, 1.25f);
        this.kSn = (TbImageView) this.kSc.findViewById(R.id.sub_pb_image);
        this.kSn.setOnClickListener(this.aRU);
        this.kSo = (TextView) this.kSc.findViewById(R.id.advert);
        this.ajD = (PlayVoiceBntNew) this.kSc.findViewById(R.id.voice_btn);
        this.kSc.setOnTouchListener(this.eFf);
        this.kSc.setOnClickListener(this.aRU);
    }

    public void a(b.InterfaceC0538b interfaceC0538b, boolean z) {
        if (this.kSy != null) {
            this.kSy.dismiss();
            this.kSy = null;
        }
        this.kSy = new com.baidu.tbadk.core.dialog.b(this.kSd.getPageContext().getPageActivity());
        if (z) {
            this.kSy.a(new String[]{this.kSd.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0538b);
        } else {
            this.kSy.a(new String[]{this.kSd.getPageContext().getString(R.string.save_to_emotion), this.kSd.getPageContext().getString(R.string.save_to_local)}, interfaceC0538b);
        }
        this.kSy.d(this.kSd.getPageContext());
        this.kSy.bhi();
    }

    public void cY(View view) {
        this.kSr = view;
    }

    public void cqO() {
        int dimens = l.getDimens(this.kSd.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.kSd.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.kSb.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kSw != null) {
                    a.this.kSb.onFinish();
                } else {
                    a.this.kSd.finish();
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
        if (this.kSx == null) {
            this.kSx = new Dialog(this.kSd.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kSx.setCanceledOnTouchOutside(true);
            this.kSx.setCancelable(true);
            this.kSt = LayoutInflater.from(this.kSd.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.kSd.getLayoutMode().onModeChanged(this.kSt);
            this.kSx.setContentView(this.kSt);
            WindowManager.LayoutParams attributes = this.kSx.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.kSd.getPageContext().getPageActivity()) * 0.9d);
            this.kSx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.kSx.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.kSx.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.kSx.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.kSx != null && (a.this.kSx instanceof Dialog)) {
                        g.b(a.this.kSx, a.this.kSd.getPageContext());
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
                    if (a.this.kSx != null && (a.this.kSx instanceof Dialog)) {
                        g.b(a.this.kSx, a.this.kSd.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.kSz != null) {
                        a.this.kSz.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.kSx != null && (a.this.kSx instanceof Dialog)) {
                        g.b(a.this.kSx, a.this.kSd.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.kSd.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.kSx, this.kSd.getPageContext());
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
        this.kLa = new com.baidu.tbadk.core.dialog.a(this.kSd.getPageContext().getPageActivity());
        this.kLa.nt(i3);
        this.kLa.setYesButtonTag(sparseArray);
        this.kLa.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.kSA != null) {
                    a.this.kSA.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.kLa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kLa.m39if(true);
        this.kLa.b(this.kSd.getPageContext());
        if (z) {
            this.kLa.bhg();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData ckT;
        if (this.kSd != null && sparseArray != null && this.kSc != null) {
            if (this.iyZ == null) {
                this.iyZ = new e(this.kSd.getPageContext(), this.kSc);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.kRy != null && (ckT = this.kRy.ckT()) != null && ckT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckT.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray2);
            this.iyZ.setDefaultReasonArray(new String[]{this.kSd.getString(R.string.delete_thread_reason_1), this.kSd.getString(R.string.delete_thread_reason_2), this.kSd.getString(R.string.delete_thread_reason_3), this.kSd.getString(R.string.delete_thread_reason_4), this.kSd.getString(R.string.delete_thread_reason_5)});
            this.iyZ.setData(arVar);
            this.iyZ.De("4");
            this.iyZ.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    String R = at.R(jSONArray);
                    if (a.this.kSA != null) {
                        a.this.kSA.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(final boolean z) {
        if (this.fCP != null) {
            if (!z) {
                this.fCP.setEnabled(z);
            } else {
                this.fCP.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fCP.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.kSz = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.kSA = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.kSd.showToast(this.kSd.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.kSd.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.brv() != null) {
            this.jFD = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.kSe.addView(hVar.brv(), layoutParams);
            this.jFD.a(new x.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    a.this.dcU();
                }
            });
        }
    }

    public void dcz() {
        if (this.fCP != null) {
            this.kSG = this.fCP.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sT(boolean z) {
        if (this.kRy == null || this.kRy.dcX() == null) {
            return false;
        }
        if (this.kRy.cVA() != 0) {
            return false;
        }
        return (this.kQJ == null || this.kQJ.bce() == null || this.kQJ.bce().beE() == null || !TextUtils.equals(this.kQJ.bce().beE().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dcA() {
        if (this.kRy != null) {
            if ((!dcD() && this.kSv != null && this.kSv.isShown()) || y.isEmpty(this.kSB)) {
                this.kRy.tY(false);
            } else {
                this.kRy.tY(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.kRy = subPbModel;
    }

    public void tV(boolean z) {
        if (this.kRy != null && this.kRy.dcx() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.kSw = new BlankView(this.kSd.getPageContext().getPageActivity());
            this.eUg.addView(this.kSw, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.kSw.setVisibility(0);
            this.kSw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kSd.finish();
                }
            });
            this.kSb.setBlankView(this.kSw);
        }
    }

    public void dcB() {
        b(this.kSd);
        this.fCP.setNextPage(this.kSq);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.wb(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dcD() && this.kSv != null && this.kSv.isShown()) {
                i = (this.kSG - this.kSF) - 1;
            } else {
                i = this.kSG - this.kSF;
            }
            int count = y.getCount(this.kSB);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(y.subList(this.kSB, 0, i));
            y.add(arrayList, postData2);
            y.add(arrayList, postData);
            this.fCP.smoothScrollToPosition(this.kSG + 2);
            this.fCP.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fCP.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.fCP.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.kSb;
    }

    public void dbe() {
        if (this.kSs != null) {
            g.dismissPopupWindow(this.kSs, this.kSd.getPageContext().getPageActivity());
        }
        if (this.kSu != null) {
            this.kSu.dismiss();
        }
        if (this.kLa != null) {
            this.kLa.dismiss();
        }
        if (this.kSx != null) {
            g.b(this.kSx, this.kSd.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.kRB != null) {
            this.kRB.dismiss();
        }
    }

    public void dcC() {
        this.fCP.setNextPage(this.kSq);
        this.kSq.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.eKT = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.eKT && this.kSc != null) {
                this.kSc.setVisibility(8);
                this.fCP.removeHeaderView(this.kSc);
                this.kSF = 1;
            }
            this.kQJ = pVar;
            if (this.kQJ.cWh() != null) {
                this.kQJ.cWh().mfK = true;
            }
            if (this.kSc != null) {
                this.kSc.setVisibility(0);
            }
            if (pVar.bce() != null && pVar.bce().bdo()) {
                this.kSf.setText(R.string.view_original);
            } else {
                this.kSf.setText(R.string.view_subject);
            }
            if (pVar.cWh() != null) {
                this.feO = pVar.cWh().dwF();
                if (this.feO > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.kSd.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.feO)));
                    if (this.kSd != null) {
                        this.ilo.setText(this.kSd.das());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.kSd.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.kSd.dcx()) {
                    str = "PB";
                }
                if (pVar.cWh().bfa() != null) {
                    this.kSp.setData(this.kSd.getPageContext(), pVar.cWh().bfa(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", pVar.bss().getId(), pVar.bss().getName(), pVar.bce().getId(), str));
                } else {
                    this.kSp.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.kSq.startLoadData();
                this.kSH.setHasMoreData(true);
            } else {
                this.kSq.endLoadData();
                this.kSH.setHasMoreData(false);
            }
            this.kSB = pVar.cWl();
            if (this.kSB == null || this.kSB.size() <= kSa) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.kSB.size() - kSa;
                EG(size);
                int firstVisiblePosition = this.fCP.getFirstVisiblePosition() - size;
                View childAt = this.fCP.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kSB);
            if (y.isEmpty(this.kSB)) {
                this.fCP.setNextPage(null);
                if (this.eKT) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.fCP.setNextPage(this.kSq);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.eKT) {
                arrayList.add(0, pVar.cWh());
            }
            this.kSH.a(this.kQJ.bce(), arrayList);
            a(pVar, pVar.cWh(), pVar.cHC(), pVar.baA(), i, z);
            if (i4 > 0) {
                this.fCP.setSelectionFromTop(i3, i2);
            } else if (z2 && !at.isEmpty(this.kSd.dcy().cYA())) {
                String cYA = this.kSd.dcy().cYA();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !cYA.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.fCP.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.fCP.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.fCP.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.kQJ.cWi() > 1) {
                this.fCP.setPullRefresh(this.kKW);
                this.kSb.setEnableDragExit(false);
                return;
            }
            this.fCP.setPullRefresh(null);
            this.kSb.setEnableDragExit(true);
        }
    }

    private void EG(int i) {
        if (this.kSB != null) {
            if (this.kSB.size() <= i) {
                this.kSB.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.kSB.iterator();
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

    public boolean dcD() {
        return this.kSH.ayX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eKT) {
            if (!StringUtils.isNull(postData.dwM())) {
                this.kSn.setVisibility(0);
                this.kSn.startLoad(postData.dwM(), 10, true);
            } else {
                this.kSn.setVisibility(8);
            }
            i dwO = postData.dwO();
            if (dwO != null && dwO.mev) {
                this.kSo.setVisibility(0);
            } else {
                this.kSo.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.kSc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.kSc.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.kSk.setText((CharSequence) null);
            this.dTQ.setText((CharSequence) null);
            this.kNX.setVisibility(8);
            if (!this.eKT) {
                c(postData.beE());
                if (z) {
                    this.kNX.setVisibility(0);
                    ap.setViewTextColor(this.kNX, R.color.cp_link_tip_a);
                }
            }
            this.kSl.setText(at.getFormatTime(postData.getTime()));
            String format = String.format(this.kSd.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dwF()));
            if (pVar.bce() != null && pVar.bce().bdo()) {
                this.kSk.setText((CharSequence) null);
            } else {
                this.kSk.setText(format);
            }
            postData.beE().getUserTbVipInfoData();
            boolean a = a(this.kSm, postData.dwH());
            if (StringUtils.isNull(postData.dwM()) && !a && postData.bxE() != null) {
                this.ajD.setVisibility(0);
                this.ajD.setTag(postData.bxE());
                return;
            }
            this.ajD.setVisibility(8);
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
                this.dTQ.setText(dF(metaData.getSealPrefix(), str));
            } else {
                this.dTQ.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.kSi != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.kSi.setVisibility(8);
                } else {
                    this.kSi.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dRx = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.kSi.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.dTQ, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.dTQ, R.color.cp_cont_c);
            }
            this.kSh.setVisibility(0);
            this.kSh.setUserId(metaData.getUserId());
            this.kSh.setUserName(metaData.getUserName());
            this.kSh.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.kSh, metaData);
            this.kSh.startLoad(metaData.getAvater(), 28, false);
            this.kSg.setTag(R.id.tag_user_id, metaData.getUserId());
            this.kSg.setTag(R.id.tag_user_name, metaData.getUserName());
            this.kSg.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bxw() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bxw().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.n(next.bxD());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.jX(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dEZ());
                        continue;
                    case 17:
                        String str = next.bxH().mGifInfo.mSharpText;
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
        if (!tbRichTextData.bxM()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bxD() == null || tbRichTextData.bxD().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bxD());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.kSd.getPageContext().getString(R.string.refresh_view_button_text), this.dSI));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.kSd.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.kSe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.fCP.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.jFD.bsy();
        ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.kSd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void Bd(int i) {
        b(NoDataViewFactory.d.dE(null, this.kSd.getResources().getString(R.string.refresh_view_title_text)));
        this.kSC.setVisibility(8);
    }

    public void GS(String str) {
        b(NoDataViewFactory.d.dE(str, this.kSd.getPageContext().getString(R.string.refresh_view_title_text)));
        this.kSC.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.fCP.setVisibility(0);
            this.kSC.setVisibility(0);
            this.kSb.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSI = onClickListener;
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
            if (this.kQJ != null && this.kQJ.bce() != null && this.kQJ.bce().beE() != null && postData.beE() != null) {
                String userId3 = this.kQJ.bce().beE().getUserId();
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
                    int i2 = postData.dwF() != 1 ? 0 : 1;
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
                        if (this.kQJ.bce() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kQJ.bce().getId());
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
            if (postData.dwF() != 1) {
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

    public void tW(boolean z) {
        if (this.kRB != null && this.kRB.cZA() != null) {
            if (z) {
                this.kRB.cZA().setText(R.string.remove_mark);
            } else {
                this.kRB.cZA().setText(R.string.mark);
            }
        }
    }

    public View dcE() {
        return this.kSv;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.kSb, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.kSe, R.color.cp_bg_line_d);
        this.kSd.getLayoutMode().setNightMode(i == 1);
        this.kSd.getLayoutMode().onModeChanged(this.kSb);
        this.kSd.getLayoutMode().onModeChanged(this.kSc);
        this.mNavigationBar.onChangeSkinType(this.kSd.getPageContext(), i);
        if (this.kSf != null) {
            ap.setViewTextColor(this.kSf, R.color.goto_see_subject_color);
        }
        this.eUf.onChangeSkinType(this.kSd.getPageContext(), i);
        this.kSd.getLayoutMode().onModeChanged(this.kSv);
        ap.setViewTextColor(this.kSm, R.color.cp_cont_b);
        this.kSm.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        if (this.jFD != null && this.jFD.brv() != null) {
            this.jFD.brv().onChangeSkinType(i);
        }
        this.kSq.changeSkin(i);
        this.ajD.changeSkin();
        ap.setViewTextColor(this.ilo, R.color.cp_cont_e);
        ap.setViewTextColor(this.kNX, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.dTQ, R.color.cp_cont_c);
        this.ilo.setAlpha(0.95f);
        if (this.kSr != null) {
            com.baidu.tbadk.r.a.a(this.kSd.getPageContext(), this.kSr);
        }
        if (this.kSH != null) {
            this.kSH.notifyDataSetChanged();
        }
        this.kSd.getLayoutMode().onModeChanged(this.kSt);
        ap.setBackgroundResource(this.kLp, R.drawable.bottom_shadow);
        this.kLs.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kLr.setBackgroundDrawable(ap.aO(l.getDimens(this.kSd, R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
    }

    public void dcF() {
        this.mProgress.setVisibility(0);
    }

    public void dcG() {
        this.fCP.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kSq.endLoadData();
    }

    public void ciR() {
        this.fCP.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kSq.ciR();
    }

    public boolean dcH() {
        return this.kSb.dcH();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kSH.c(onLongClickListener);
    }

    public View dcI() {
        return this.kSc;
    }

    public TextView cqT() {
        return this.ilo;
    }

    public ImageView dcJ() {
        return this.kSD;
    }

    public ImageView dcK() {
        return this.kSE;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void EH(int i) {
    }

    public View dcL() {
        return this.kSf;
    }

    public View dcM() {
        return this.kSn;
    }

    public MorePopupWindow dcN() {
        return this.kSs;
    }

    public void showLoadingDialog() {
        if (this.hpW == null) {
            this.hpW = new com.baidu.tbadk.core.view.a(this.kSd.getPageContext());
        }
        this.hpW.setDialogVisiable(true);
    }

    public void bWq() {
        if (this.hpW != null) {
            this.hpW.setDialogVisiable(false);
        }
    }

    public TextView dcO() {
        return this.kSm;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kSH.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.kSH != null) {
            this.kSH.notifyDataSetChanged();
        }
    }

    public ah dcP() {
        return this.kRB;
    }

    public void ctd() {
    }

    public void cte() {
    }

    public void crq() {
        this.kSb.onDestroy();
    }

    public void dcQ() {
        if (this.kSd.isPaused()) {
        }
    }

    public View dcR() {
        return this.kSg;
    }

    private SpannableStringBuilder dF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.kSd.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dcS() {
        if (this.jFD == null || this.jFD.brv() == null) {
            return 0;
        }
        return this.jFD.brv().getHeight();
    }

    public int dcT() {
        if (this.kSw == null) {
            return 0;
        }
        return this.kSw.getHeight();
    }

    public void dcU() {
        if (this.ilo != null && this.jFD != null) {
            if (this.jFD.bsD()) {
                this.ilo.setText(R.string.draft_to_send);
            } else {
                this.ilo.setText(this.kSd.das());
            }
        }
    }

    public void ti(boolean z) {
        if (this.kLs != null) {
            this.kLs.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.esW = cVar;
        if (this.kKW != null) {
            this.kKW.setListPullRefreshListener(cVar);
        }
    }
}
