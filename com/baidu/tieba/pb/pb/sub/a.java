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
    private static final int lIx = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aZX;
    private f.c eVA;
    private NoNetworkView fxC;
    private LinearLayout fxD;
    private BdTypeListView gih;
    private TextView iZI;
    private com.baidu.tbadk.core.view.a iey;
    private View iwP;
    private e jnL;
    private View lBJ;
    private LinearLayout lBL;
    private HeadImageView lBM;
    private com.baidu.tieba.pb.view.d lBq;
    private SubPbModel lHV;
    private ah lHY;
    private p lHf;
    private NewSubPbActivity lIA;
    private RelativeLayout lIB;
    private View lIF;
    private ThreadSkinView lIM;
    private d lIN;
    private View lIO;
    private View lIQ;
    private View lIS;
    private BlankView lIT;
    private com.baidu.tbadk.core.dialog.b lIV;
    private ArrayList<PostData> lIY;
    private RelativeLayout lIZ;
    private SubPbView lIy;
    private View lIz;
    private ImageView lJa;
    private ImageView lJb;
    private c lJe;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener evp = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lIC = null;
    private LinearLayout lID = null;
    private HeadImageView lIE = null;
    private TextView ewx = null;
    private ImageView lIG = null;
    private TextView lEr = null;
    private TextView lIH = null;
    private TextView lII = null;
    private EllipsizeRichTextView lIJ = null;
    private TbImageView lIK = null;
    private PlayVoiceBntNew akw = null;
    private TextView lIL = null;
    private MorePopupWindow lIP = null;
    private com.baidu.tbadk.core.dialog.b lIR = null;
    private Dialog lIU = null;
    private com.baidu.tbadk.core.dialog.a lBu = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lIW = null;
    private NewSubPbActivity.a lIX = null;
    private h kvE = null;
    private int fIl = 0;
    private int lJc = 2;
    private int lJd = 0;
    private boolean fnL = true;
    private boolean lrn = com.baidu.tbadk.a.d.bhV();
    private com.baidu.tieba.pb.a.c fhK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.7
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.qe(false);
            a.this.qe(true);
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
    protected AdapterView.OnItemLongClickListener lJf = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.lIY, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lHY == null) {
                    a.this.lHY = new ah(a.this.lIA.getPageContext(), a.this.aZX);
                }
                a.this.lHY.Qj();
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
                boolean z2 = a.this.uj(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.lHY;
                int diz = a.this.lHV.diz();
                if (!a.this.lrn || postData2 == null || !postData2.mXO) {
                    z = false;
                }
                ahVar.a(sparseArray, diz, z2, z);
                if (z2) {
                    a.this.lHY.dmy().setVisibility(0);
                    a.this.lHY.dmy().setTag(postData.getId());
                } else {
                    a.this.lHY.dmy().setVisibility(8);
                }
                a.this.lHY.dmw().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lJg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.lIA != null && bg.checkUpIsLogin(a.this.lIA.getPageContext().getPageActivity())) {
                if ((a.this.lIA.kvy == null || a.this.lHV == null || a.this.lHV.cxn() == null || a.this.lIA.kvy.oT(a.this.lHV.cxn().replyPrivateFlag)) && a.this.lHV != null && a.this.kvE != null) {
                    a.this.dpx();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dpz();
                        a.this.lHV.dpY();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kvE.setReplyId(str2);
                            a.this.kvE.DV(str);
                        }
                    }
                    a.this.dpy();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.lIy = null;
        this.lIz = null;
        this.gih = null;
        this.lBq = null;
        this.lIA = null;
        this.fxC = null;
        this.lIB = null;
        this.lIF = null;
        this.lIN = null;
        this.lIS = null;
        this.aZX = null;
        this.mProgress = null;
        this.iZI = null;
        this.lIZ = null;
        this.lJa = null;
        this.lJb = null;
        this.lIA = newSubPbActivity;
        this.aZX = onClickListener;
        this.lIy = (SubPbView) LayoutInflater.from(this.lIA.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.lIz = LayoutInflater.from(this.lIA.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fxD = (LinearLayout) this.lIy.findViewById(R.id.navigation_bar_group);
        this.lIZ = (RelativeLayout) this.lIy.findViewById(R.id.subpb_editor_tool_comment);
        this.iZI = (TextView) this.lIy.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.iZI.setOnClickListener(this.aZX);
        this.lJa = (ImageView) this.lIy.findViewById(R.id.subpb_editor_tool_more_img);
        this.lJb = (ImageView) this.lIy.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lJb.setOnClickListener(this.aZX);
        this.lJa.setOnClickListener(this.aZX);
        this.fxC = (NoNetworkView) this.lIy.findViewById(R.id.view_no_network);
        cDh();
        bTT();
        this.lIB = (RelativeLayout) this.lIy.findViewById(R.id.sub_pb_body_layout);
        this.gih = (BdTypeListView) this.lIy.findViewById(R.id.new_sub_pb_list);
        this.lIM = (ThreadSkinView) LayoutInflater.from(this.lIA.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gih.addHeaderView(this.lIM);
        this.gih.addHeaderView(this.lIz);
        this.iwP = new TextView(newSubPbActivity.getActivity());
        this.iwP.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gih.addHeaderView(this.iwP, 0);
        this.lIy.setTopView(this.iwP);
        this.lIy.setNavigationView(this.fxD);
        this.lIy.setListView(this.gih);
        this.lIy.setContentView(this.lIB);
        this.lIN = new d(this.lIA.getPageContext());
        this.lIN.setLineGone();
        this.lIS = this.lIN.getView();
        this.gih.setNextPage(this.lIN);
        this.lIN.setOnClickListener(this.aZX);
        this.gih.setOnItemClickListener(this.lJg);
        this.gih.setOnItemLongClickListener(this.lJf);
        this.gih.setOnTouchListener(this.fhK);
        this.lBq = new com.baidu.tieba.pb.view.d(newSubPbActivity.getPageContext());
        this.lBq.createView();
        this.lBq.setListPullRefreshListener(this.eVA);
        this.lBq.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.lIy.findViewById(R.id.progress);
        this.lBJ = this.lIy.findViewById(R.id.view_comment_top_line);
        this.lBL = (LinearLayout) this.lIy.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lBM = (HeadImageView) this.lIy.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lBM.setVisibility(0);
        this.lBM.setIsRound(true);
        this.lBM.setBorderWidth(l.getDimens(this.lIA, R.dimen.tbds1));
        this.lBM.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.lBM.setPlaceHolder(1);
        this.lBM.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lBM.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lIz != null) {
            this.lIz.setVisibility(4);
        }
        this.lIF = com.baidu.tbadk.ala.b.bim().q(this.lIA.getActivity(), 4);
        if (this.lIF != null) {
            this.lIF.setVisibility(8);
            this.lID.addView(this.lIF, 3);
        }
        this.lJe = new c(this.lIA, this.gih);
        this.lJe.setFromCDN(this.mIsFromCDN);
        this.lJe.B(this.aZX);
        this.lJe.LY();
    }

    public ListView getListView() {
        return this.gih;
    }

    public void bTT() {
        this.lID = (LinearLayout) this.lIz.findViewById(R.id.subpb_head_user_info_root);
        this.lID.setOnClickListener(this.aZX);
        this.lIE = (HeadImageView) this.lIz.findViewById(R.id.photo);
        this.lIE.setRadius(l.getDimens(this.lIA.getActivity(), R.dimen.tbds45));
        this.lIE.setClickable(false);
        this.ewx = (TextView) this.lIz.findViewById(R.id.user_name);
        this.lIG = (ImageView) this.lIz.findViewById(R.id.user_rank);
        this.lIG.setVisibility(8);
        this.lEr = (TextView) this.lIz.findViewById(R.id.floor_owner);
        this.lIC = (TextView) this.lIz.findViewById(R.id.see_subject);
        this.lIC.setOnClickListener(this.aZX);
        this.lIH = (TextView) this.lIz.findViewById(R.id.floor);
        this.lII = (TextView) this.lIz.findViewById(R.id.time);
        this.lIJ = (EllipsizeRichTextView) this.lIz.findViewById(R.id.content_text);
        this.lIJ.setOnClickListener(this.aZX);
        ap.setViewTextColor(this.lIJ, R.color.cp_cont_b);
        this.lIJ.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.lIJ.setLineSpacing(0.0f, 1.25f);
        this.lIK = (TbImageView) this.lIz.findViewById(R.id.sub_pb_image);
        this.lIK.setOnClickListener(this.aZX);
        this.lIL = (TextView) this.lIz.findViewById(R.id.advert);
        this.akw = (PlayVoiceBntNew) this.lIz.findViewById(R.id.voice_btn);
        this.lIz.setOnTouchListener(this.fhK);
        this.lIz.setOnClickListener(this.aZX);
    }

    public void a(b.InterfaceC0576b interfaceC0576b, boolean z) {
        if (this.lIV != null) {
            this.lIV.dismiss();
            this.lIV = null;
        }
        this.lIV = new com.baidu.tbadk.core.dialog.b(this.lIA.getPageContext().getPageActivity());
        if (z) {
            this.lIV.a(new String[]{this.lIA.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0576b);
        } else {
            this.lIV.a(new String[]{this.lIA.getPageContext().getString(R.string.save_to_emotion), this.lIA.getPageContext().getString(R.string.save_to_local)}, interfaceC0576b);
        }
        this.lIV.d(this.lIA.getPageContext());
        this.lIV.bpe();
    }

    public void dt(View view) {
        this.lIO = view;
    }

    public void cDh() {
        int dimens = l.getDimens(this.lIA.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.lIA.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.lIy.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lIT != null) {
                    a.this.lIy.onFinish();
                } else {
                    a.this.lIA.finish();
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

    public void dp(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.lIU == null) {
            this.lIU = new Dialog(this.lIA.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lIU.setCanceledOnTouchOutside(true);
            this.lIU.setCancelable(true);
            this.lIQ = LayoutInflater.from(this.lIA.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.lIA.getLayoutMode().onModeChanged(this.lIQ);
            this.lIU.setContentView(this.lIQ);
            WindowManager.LayoutParams attributes = this.lIU.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.lIA.getPageContext().getPageActivity()) * 0.9d);
            this.lIU.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lIU.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lIU.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lIU.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.lIU != null && (a.this.lIU instanceof Dialog)) {
                        g.b(a.this.lIU, a.this.lIA.getPageContext());
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
                    if (a.this.lIU != null && (a.this.lIU instanceof Dialog)) {
                        g.b(a.this.lIU, a.this.lIA.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lIW != null) {
                        a.this.lIW.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.lIU != null && (a.this.lIU instanceof Dialog)) {
                        g.b(a.this.lIU, a.this.lIA.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.lIA.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lIU, this.lIA.getPageContext());
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
        this.lBu = new com.baidu.tbadk.core.dialog.a(this.lIA.getPageContext().getPageActivity());
        this.lBu.ow(i3);
        this.lBu.setYesButtonTag(sparseArray);
        this.lBu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lIX != null) {
                    a.this.lIX.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lBu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lBu.iV(true);
        this.lBu.b(this.lIA.getPageContext());
        if (z) {
            this.lBu.bpc();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData cxn;
        if (this.lIA != null && sparseArray != null && this.lIz != null) {
            if (this.jnL == null) {
                this.jnL = new e(this.lIA.getPageContext(), this.lIz);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lHV != null && (cxn = this.lHV.cxn()) != null && cxn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cxn.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray2);
            this.jnL.setDefaultReasonArray(new String[]{this.lIA.getString(R.string.delete_thread_reason_1), this.lIA.getString(R.string.delete_thread_reason_2), this.lIA.getString(R.string.delete_thread_reason_3), this.lIA.getString(R.string.delete_thread_reason_4), this.lIA.getString(R.string.delete_thread_reason_5)});
            this.jnL.setData(arVar);
            this.jnL.EU("4");
            this.jnL.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    String R = at.R(jSONArray);
                    if (a.this.lIX != null) {
                        a.this.lIX.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(final boolean z) {
        if (this.gih != null) {
            if (!z) {
                this.gih.setEnabled(z);
            } else {
                this.gih.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gih.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lIW = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lIX = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.lIA.showToast(this.lIA.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.lIA.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bzx() != null) {
            this.kvE = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.lIB.addView(hVar.bzx(), layoutParams);
            this.kvE.a(new x.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    a.this.dpS();
                }
            });
        }
    }

    public void dpx() {
        if (this.gih != null) {
            this.lJd = this.gih.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uj(boolean z) {
        if (this.lHV == null || this.lHV.dpV() == null) {
            return false;
        }
        if (this.lHV.diz() != 0) {
            return false;
        }
        return (this.lHf == null || this.lHf.bjZ() == null || this.lHf.bjZ().bmA() == null || !TextUtils.equals(this.lHf.bjZ().bmA().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dpy() {
        if (this.lHV != null) {
            if ((!dpB() && this.lIS != null && this.lIS.isShown()) || y.isEmpty(this.lIY)) {
                this.lHV.vp(false);
            } else {
                this.lHV.vp(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lHV = subPbModel;
    }

    public void vm(boolean z) {
        if (this.lHV != null && this.lHV.dpv() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lIT = new BlankView(this.lIA.getPageContext().getPageActivity());
            this.fxD.addView(this.lIT, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lIT.setVisibility(0);
            this.lIT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lIA.finish();
                }
            });
            this.lIy.setBlankView(this.lIT);
        }
    }

    public void dpz() {
        b(this.lIA);
        this.gih.setNextPage(this.lIN);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.xt(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dpB() && this.lIS != null && this.lIS.isShown()) {
                i = (this.lJd - this.lJc) - 1;
            } else {
                i = this.lJd - this.lJc;
            }
            int count = y.getCount(this.lIY);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(y.subList(this.lIY, 0, i));
            y.add(arrayList, postData2);
            y.add(arrayList, postData);
            this.gih.smoothScrollToPosition(this.lJd + 2);
            this.gih.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gih.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gih.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.lIy;
    }

    public void dob() {
        if (this.lIP != null) {
            g.dismissPopupWindow(this.lIP, this.lIA.getPageContext().getPageActivity());
        }
        if (this.lIR != null) {
            this.lIR.dismiss();
        }
        if (this.lBu != null) {
            this.lBu.dismiss();
        }
        if (this.lIU != null) {
            g.b(this.lIU, this.lIA.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lHY != null) {
            this.lHY.dismiss();
        }
    }

    public void dpA() {
        this.gih.setNextPage(this.lIN);
        this.lIN.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fnL = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.fnL && this.lIz != null) {
                this.lIz.setVisibility(8);
                this.gih.removeHeaderView(this.lIz);
                this.lJc = 1;
            }
            this.lHf = pVar;
            if (this.lHf.dja() != null) {
                this.lHf.dja().mXO = true;
            }
            if (this.lIz != null) {
                this.lIz.setVisibility(0);
            }
            if (pVar.bjZ() != null && pVar.bjZ().blk()) {
                this.lIC.setText(R.string.view_original);
            } else {
                this.lIC.setText(R.string.view_subject);
            }
            if (pVar.dja() != null) {
                this.fIl = pVar.dja().dJZ();
                if (this.fIl > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.lIA.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fIl)));
                    if (this.lIA != null) {
                        this.iZI.setText(this.lIA.dno());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.lIA.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.lIA.dpv()) {
                    str = "PB";
                }
                if (pVar.dja().bmW() != null) {
                    this.lIM.setData(this.lIA.getPageContext(), pVar.dja().bmW(), com.baidu.tieba.tbadkCore.d.a.g("PB", "c0132", pVar.bAz().getId(), pVar.bAz().getName(), pVar.bjZ().getId(), str));
                } else {
                    this.lIM.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lIN.startLoadData();
                this.lJe.setHasMoreData(true);
            } else {
                this.lIN.endLoadData();
                this.lJe.setHasMoreData(false);
            }
            this.lIY = pVar.dji();
            if (this.lIY == null || this.lIY.size() <= lIx) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lIY.size() - lIx;
                Gt(size);
                int firstVisiblePosition = this.gih.getFirstVisiblePosition() - size;
                View childAt = this.gih.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lIY);
            if (y.isEmpty(this.lIY)) {
                this.gih.setNextPage(null);
                if (this.fnL) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.gih.setNextPage(this.lIN);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fnL) {
                arrayList.add(0, pVar.dja());
            }
            this.lJe.a(this.lHf.bjZ(), arrayList);
            a(pVar, pVar.dja(), pVar.Wq(), pVar.biv(), i, z);
            if (i4 > 0) {
                this.gih.setSelectionFromTop(i3, i2);
            } else if (z2 && !at.isEmpty(this.lIA.dpw().dlw())) {
                String dlw = this.lIA.dpw().dlw();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dlw.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gih.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gih.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gih.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.lHf.djf() > 1) {
                this.gih.setPullRefresh(this.lBq);
                this.lIy.setEnableDragExit(false);
                return;
            }
            this.gih.setPullRefresh(null);
            this.lIy.setEnableDragExit(true);
        }
    }

    private void Gt(int i) {
        if (this.lIY != null) {
            if (this.lIY.size() <= i) {
                this.lIY.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lIY.iterator();
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

    public boolean dpB() {
        return this.lJe.aGJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fnL) {
            if (!StringUtils.isNull(postData.dKg())) {
                this.lIK.setVisibility(0);
                this.lIK.startLoad(postData.dKg(), 10, true);
            } else {
                this.lIK.setVisibility(8);
            }
            i dKi = postData.dKi();
            if (dKi != null && dKi.mWy) {
                this.lIL.setVisibility(0);
            } else {
                this.lIL.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.lIz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.lIz.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.lIH.setText((CharSequence) null);
            this.ewx.setText((CharSequence) null);
            this.lEr.setVisibility(8);
            if (!this.fnL) {
                c(postData.bmA());
                if (z) {
                    this.lEr.setVisibility(0);
                    ap.setViewTextColor(this.lEr, R.color.cp_link_tip_a);
                }
            }
            this.lII.setText(at.getFormatTime(postData.getTime()));
            String format = String.format(this.lIA.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dJZ()));
            if (pVar.bjZ() != null && pVar.bjZ().blk()) {
                this.lIH.setText((CharSequence) null);
            } else {
                this.lIH.setText(format);
            }
            postData.bmA().getUserTbVipInfoData();
            boolean a2 = a(this.lIJ, postData.dKb());
            if (StringUtils.isNull(postData.dKg()) && !a2 && postData.bFQ() != null) {
                this.akw.setVisibility(0);
                this.akw.setTag(postData.bFQ());
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
                this.ewx.setText(dT(metaData.getSealPrefix(), str));
            } else {
                this.ewx.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.lIF != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.lIF.setVisibility(8);
                } else {
                    this.lIF.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eue = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.lIF.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.ewx, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.ewx, R.color.cp_cont_c);
            }
            this.lIE.setVisibility(0);
            this.lIE.setUserId(metaData.getUserId());
            this.lIE.setUserName(metaData.getUserName());
            this.lIE.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.lIE, metaData);
            this.lIE.startLoad(metaData.getAvater(), 28, false);
            this.lID.setTag(R.id.tag_user_id, metaData.getUserId());
            this.lID.setTag(R.id.tag_user_name, metaData.getUserName());
            this.lID.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bFI() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bFI().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.o(next.bFP());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.kU(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dSy());
                        continue;
                    case 17:
                        String str = next.bFT().mGifInfo.mSharpText;
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
        if (!tbRichTextData.bFY()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bFP() == null || tbRichTextData.bFP().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bFP());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.lIA.getPageContext().getString(R.string.refresh_view_button_text), this.evp));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.lIA.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.lIB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gih.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kvE.bAF();
        ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.lIA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void CQ(int i) {
        b(NoDataViewFactory.d.dS(null, this.lIA.getResources().getString(R.string.refresh_view_title_text)));
        this.lIZ.setVisibility(8);
    }

    public void IT(String str) {
        b(NoDataViewFactory.d.dS(str, this.lIA.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lIZ.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gih.setVisibility(0);
            this.lIZ.setVisibility(0);
            this.lIy.setOnTouchListener(null);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        this.evp = onClickListener;
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
                String userId2 = postData.bmA().getUserId();
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
            if (this.lHf != null && this.lHf.bjZ() != null && this.lHf.bjZ().bmA() != null && postData.bmA() != null) {
                String userId3 = this.lHf.bjZ().bmA().getUserId();
                String userId4 = postData.bmA().getUserId();
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
                    userId = postData.bmA().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dJZ() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.bmA() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bmA().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bmA().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bmA().getPortrait());
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
                        if (postData.bmA() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bmA().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bmA().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bmA().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bmA() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bmA().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bmA().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bmA().getName_show());
                        }
                        if (this.lHf.bjZ() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lHf.bjZ().getId());
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
            userId = postData.bmA().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dJZ() != 1) {
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

    public void vn(boolean z) {
        if (this.lHY != null && this.lHY.dmw() != null) {
            if (z) {
                this.lHY.dmw().setText(R.string.remove_mark);
            } else {
                this.lHY.dmw().setText(R.string.mark);
            }
        }
    }

    public View dpC() {
        return this.lIS;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.lIy, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.lIB, R.color.cp_bg_line_d);
        this.lIA.getLayoutMode().setNightMode(i == 1);
        this.lIA.getLayoutMode().onModeChanged(this.lIy);
        this.lIA.getLayoutMode().onModeChanged(this.lIz);
        this.mNavigationBar.onChangeSkinType(this.lIA.getPageContext(), i);
        if (this.lIC != null) {
            ap.setViewTextColor(this.lIC, R.color.goto_see_subject_color);
        }
        this.fxC.onChangeSkinType(this.lIA.getPageContext(), i);
        this.lIA.getLayoutMode().onModeChanged(this.lIS);
        ap.setViewTextColor(this.lIJ, R.color.cp_cont_b);
        this.lIJ.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        if (this.kvE != null && this.kvE.bzx() != null) {
            this.kvE.bzx().onChangeSkinType(i);
        }
        this.lIN.changeSkin(i);
        this.akw.changeSkin();
        ap.setViewTextColor(this.iZI, R.color.cp_cont_e);
        ap.setViewTextColor(this.lEr, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.ewx, R.color.cp_cont_c);
        this.iZI.setAlpha(0.95f);
        if (this.lIO != null) {
            com.baidu.tbadk.r.a.a(this.lIA.getPageContext(), this.lIO);
        }
        if (this.lJe != null) {
            this.lJe.notifyDataSetChanged();
        }
        this.lIA.getLayoutMode().onModeChanged(this.lIQ);
        ap.setBackgroundResource(this.lBJ, R.drawable.bottom_shadow);
        this.lBM.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.lBL.setBackgroundDrawable(ap.aO(l.getDimens(this.lIA, R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
    }

    public void dpD() {
        this.mProgress.setVisibility(0);
    }

    public void dpE() {
        this.gih.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lIN.endLoadData();
    }

    public void cvl() {
        this.gih.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lIN.cvl();
    }

    public boolean dpF() {
        return this.lIy.dpF();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lJe.c(onLongClickListener);
    }

    public View dpG() {
        return this.lIz;
    }

    public TextView cDm() {
        return this.iZI;
    }

    public ImageView dpH() {
        return this.lJa;
    }

    public ImageView dpI() {
        return this.lJb;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Gu(int i) {
    }

    public View dpJ() {
        return this.lIC;
    }

    public View dpK() {
        return this.lIK;
    }

    public MorePopupWindow dpL() {
        return this.lIP;
    }

    public void showLoadingDialog() {
        if (this.iey == null) {
            this.iey = new com.baidu.tbadk.core.view.a(this.lIA.getPageContext());
        }
        this.iey.setDialogVisiable(true);
    }

    public void chg() {
        if (this.iey != null) {
            this.iey.setDialogVisiable(false);
        }
    }

    public TextView dpM() {
        return this.lIJ;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lJe.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lJe != null) {
            this.lJe.notifyDataSetChanged();
        }
    }

    public ah dpN() {
        return this.lHY;
    }

    public void cFA() {
    }

    public void cFB() {
    }

    public void cDL() {
        this.lIy.onDestroy();
    }

    public void dpO() {
        if (this.lIA.isPaused()) {
        }
    }

    public View dpP() {
        return this.lID;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.lIA.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dpQ() {
        if (this.kvE == null || this.kvE.bzx() == null) {
            return 0;
        }
        return this.kvE.bzx().getHeight();
    }

    public int dpR() {
        if (this.lIT == null) {
            return 0;
        }
        return this.lIT.getHeight();
    }

    public void dpS() {
        if (this.iZI != null && this.kvE != null) {
            if (this.kvE.bAK()) {
                this.iZI.setText(R.string.draft_to_send);
            } else {
                this.iZI.setText(this.lIA.dno());
            }
        }
    }

    public void uy(boolean z) {
        if (this.lBM != null) {
            this.lBM.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eVA = cVar;
        if (this.lBq != null) {
            this.lBq.setListPullRefreshListener(cVar);
        }
    }
}
