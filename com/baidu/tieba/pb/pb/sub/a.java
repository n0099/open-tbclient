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
import com.baidu.tbadk.core.data.av;
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
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.ag;
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
import com.baidu.tieba.pb.data.q;
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
    private static final int mgN = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener bbI;
    private ImageView eHB;
    private NoNetworkView fLP;
    private LinearLayout fLQ;
    private f.c fjz;
    private BdTypeListView gzp;
    private com.baidu.tbadk.core.view.a iDU;
    private View iVX;
    private TextView jBI;
    private com.baidu.tieba.NEGFeedBack.f jRi;
    private MaskView lQg;
    private View lZJ;
    private LinearLayout lZL;
    private HeadImageView lZM;
    private e lZp;
    private ProgressBar mProgress;
    private i maM;
    private q mfv;
    private SubPbView mgO;
    private View mgP;
    private NewSubPbActivity mgQ;
    private RelativeLayout mgR;
    private View mgV;
    private SubPbModel mgk;
    private aa mgn;
    private ThreadSkinView mhc;
    private d mhd;
    private View mhe;
    private View mhg;
    private View mhi;
    private BlankView mhj;
    private com.baidu.tbadk.core.dialog.b mhl;
    private ArrayList<PostData> mho;
    private RelativeLayout mhp;
    private ImageView mhq;
    private ImageView mhr;
    private c mhu;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eHG = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mgS = null;
    private LinearLayout mgT = null;
    private HeadImageView mgU = null;
    private TextView eIO = null;
    private ImageView mgW = null;
    private TextView mcB = null;
    private TextView mgX = null;
    private TextView mgY = null;
    private EllipsizeRichTextView mgZ = null;
    private TbImageView mha = null;
    private PlayVoiceBntNew alb = null;
    private TextView mhb = null;
    private MorePopupWindow mhf = null;
    private com.baidu.tbadk.core.dialog.b mhh = null;
    private Dialog mhk = null;
    private com.baidu.tbadk.core.dialog.a lZu = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a mhm = null;
    private NewSubPbActivity.a mhn = null;
    private h kSF = null;
    private int fWM = 0;
    private int mhs = 2;
    private int mht = 0;
    private boolean fBK = true;
    private boolean lRN = com.baidu.tbadk.a.d.biY();
    private com.baidu.tieba.pb.a.c fvK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.8
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rm(false);
            a.this.rm(true);
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
    protected AdapterView.OnItemLongClickListener mhv = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.mho, i);
            if (view != null && view.getTag() != null) {
                if (a.this.mgn == null) {
                    a.this.mgn = new aa(a.this.mgQ.getPageContext(), a.this.bbI);
                }
                a.this.mgn.QE();
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
                boolean z2 = a.this.va(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                aa aaVar = a.this.mgn;
                int dlv = a.this.mgk.dlv();
                if (!a.this.lRN || postData2 == null || !postData2.nxV) {
                    z = false;
                }
                aaVar.a(sparseArray, dlv, z2, z);
                if (z2) {
                    a.this.mgn.dpD().setVisibility(0);
                    a.this.mgn.dpD().setTag(postData.getId());
                } else {
                    a.this.mgn.dpD().setVisibility(8);
                }
                a.this.mgn.dpB().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener mhw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.mgQ != null && bh.checkUpIsLogin(a.this.mgQ.getPageContext().getPageActivity())) {
                if ((a.this.mgQ.kSz == null || a.this.mgk == null || a.this.mgk.cBz() == null || a.this.mgQ.kSz.ox(a.this.mgk.cBz().replyPrivateFlag)) && a.this.mgk != null && a.this.kSF != null) {
                    a.this.dsI();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dsK();
                        a.this.mgk.dtj();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kSF.setReplyId(str2);
                            a.this.kSF.Dc(str);
                        }
                    }
                    a.this.dsJ();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.mgO = null;
        this.mgP = null;
        this.gzp = null;
        this.lZp = null;
        this.mgQ = null;
        this.fLP = null;
        this.mgR = null;
        this.mgV = null;
        this.mhd = null;
        this.mhi = null;
        this.bbI = null;
        this.mProgress = null;
        this.jBI = null;
        this.mhp = null;
        this.mhq = null;
        this.mhr = null;
        this.mgQ = newSubPbActivity;
        this.bbI = onClickListener;
        this.mgO = (SubPbView) LayoutInflater.from(this.mgQ.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.mgP = LayoutInflater.from(this.mgQ.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fLQ = (LinearLayout) this.mgO.findViewById(R.id.navigation_bar_group);
        this.mhp = (RelativeLayout) this.mgO.findViewById(R.id.subpb_editor_tool_comment);
        this.jBI = (TextView) this.mgO.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jBI.setOnClickListener(this.bbI);
        this.mhq = (ImageView) this.mgO.findViewById(R.id.subpb_editor_tool_more_img);
        this.mhr = (ImageView) this.mgO.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.mhr.setOnClickListener(this.bbI);
        this.mhq.setOnClickListener(this.bbI);
        this.fLP = (NoNetworkView) this.mgO.findViewById(R.id.view_no_network);
        cIA();
        bWw();
        this.mgR = (RelativeLayout) this.mgO.findViewById(R.id.sub_pb_body_layout);
        this.gzp = (BdTypeListView) this.mgO.findViewById(R.id.new_sub_pb_list);
        this.mhc = (ThreadSkinView) LayoutInflater.from(this.mgQ.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gzp.addHeaderView(this.mhc);
        this.gzp.addHeaderView(this.mgP);
        this.iVX = new TextView(newSubPbActivity.getActivity());
        this.iVX.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gzp.addHeaderView(this.iVX, 0);
        this.mgO.setTopView(this.iVX);
        this.mgO.setNavigationView(this.fLQ);
        this.mgO.setListView(this.gzp);
        this.mgO.setContentView(this.mgR);
        this.mhd = new d(this.mgQ.getPageContext());
        this.mhd.setLineGone();
        this.mhi = this.mhd.getView();
        this.gzp.setNextPage(this.mhd);
        this.mhd.setOnClickListener(this.bbI);
        this.gzp.setOnItemClickListener(this.mhw);
        this.gzp.setOnItemLongClickListener(this.mhv);
        this.gzp.setOnTouchListener(this.fvK);
        this.lZp = new e(newSubPbActivity.getPageContext());
        this.lZp.createView();
        this.lZp.setListPullRefreshListener(this.fjz);
        this.lZp.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.mgO.findViewById(R.id.progress);
        this.lQg = (MaskView) this.mgO.findViewById(R.id.mask_view);
        this.lZJ = this.mgO.findViewById(R.id.view_comment_top_line);
        this.lZL = (LinearLayout) this.mgO.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lZM = (HeadImageView) this.mgO.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lZM.setVisibility(0);
        this.lZM.setIsRound(true);
        this.lZM.setBorderWidth(l.getDimens(this.mgQ, R.dimen.L_X01));
        this.lZM.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lZM.setDefaultBgResource(0);
        this.lZM.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lZM.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mgP != null) {
            this.mgP.setVisibility(4);
        }
        this.mgV = com.baidu.tbadk.ala.b.bjQ().A(this.mgQ.getActivity(), 4);
        if (this.mgV != null) {
            this.mgV.setVisibility(8);
            this.mgT.addView(this.mgV, 3);
        }
        this.mhu = new c(this.mgQ, this.gzp);
        this.mhu.setFromCDN(this.mIsFromCDN);
        this.mhu.C(this.bbI);
        this.mhu.Kw();
    }

    public ListView getListView() {
        return this.gzp;
    }

    public void bWw() {
        this.mgT = (LinearLayout) this.mgP.findViewById(R.id.subpb_head_user_info_root);
        this.mgT.setOnClickListener(this.bbI);
        this.mgU = (HeadImageView) this.mgP.findViewById(R.id.photo);
        this.mgU.setRadius(l.getDimens(this.mgQ.getActivity(), R.dimen.tbds45));
        this.mgU.setClickable(false);
        this.eIO = (TextView) this.mgP.findViewById(R.id.user_name);
        this.mgW = (ImageView) this.mgP.findViewById(R.id.user_rank);
        this.mgW.setVisibility(8);
        this.mcB = (TextView) this.mgP.findViewById(R.id.floor_owner);
        this.mgS = (TextView) this.mgP.findViewById(R.id.see_subject);
        this.mgS.setOnClickListener(this.bbI);
        this.mgX = (TextView) this.mgP.findViewById(R.id.floor);
        this.mgY = (TextView) this.mgP.findViewById(R.id.time);
        this.mgZ = (EllipsizeRichTextView) this.mgP.findViewById(R.id.content_text);
        this.mgZ.setOnClickListener(this.bbI);
        ap.setViewTextColor(this.mgZ, R.color.CAM_X0105);
        this.mgZ.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.mgZ.setLineSpacing(0.0f, 1.25f);
        this.mha = (TbImageView) this.mgP.findViewById(R.id.sub_pb_image);
        this.mha.setOnClickListener(this.bbI);
        this.mhb = (TextView) this.mgP.findViewById(R.id.advert);
        this.alb = (PlayVoiceBntNew) this.mgP.findViewById(R.id.voice_btn);
        this.mgP.setOnTouchListener(this.fvK);
        this.mgP.setOnClickListener(this.bbI);
    }

    public void a(b.InterfaceC0558b interfaceC0558b, boolean z) {
        if (this.mhl != null) {
            this.mhl.dismiss();
            this.mhl = null;
        }
        this.mhl = new com.baidu.tbadk.core.dialog.b(this.mgQ.getPageContext().getPageActivity());
        if (z) {
            this.mhl.a(new String[]{this.mgQ.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0558b);
        } else {
            this.mhl.a(new String[]{this.mgQ.getPageContext().getString(R.string.save_to_emotion), this.mgQ.getPageContext().getString(R.string.save_to_local)}, interfaceC0558b);
        }
        this.mhl.d(this.mgQ.getPageContext());
        this.mhl.bqz();
    }

    public void dP(View view) {
        this.mhe = view;
    }

    public void cIA() {
        int dimens = l.getDimens(this.mgQ.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.mgQ.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.mgO.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mhj != null) {
                    a.this.mgO.onFinish();
                } else {
                    a.this.mgQ.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        this.eHB = backImageView;
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

    public void dL(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.mhk == null) {
            this.mhk = new Dialog(this.mgQ.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mhk.setCanceledOnTouchOutside(true);
            this.mhk.setCancelable(true);
            this.mhg = LayoutInflater.from(this.mgQ.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.mgQ.getLayoutMode().onModeChanged(this.mhg);
            this.mhk.setContentView(this.mhg);
            WindowManager.LayoutParams attributes = this.mhk.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.mgQ.getPageContext().getPageActivity()) * 0.9d);
            this.mhk.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.mhk.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.mhk.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.mhk.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.mhk != null && (a.this.mhk instanceof Dialog)) {
                        g.b(a.this.mhk, a.this.mgQ.getPageContext());
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
                    if (a.this.mhk != null && (a.this.mhk instanceof Dialog)) {
                        g.b(a.this.mhk, a.this.mgQ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.mhm != null) {
                        a.this.mhm.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.mhk != null && (a.this.mhk instanceof Dialog)) {
                        g.b(a.this.mhk, a.this.mgQ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.mgQ.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.mhk, this.mgQ.getPageContext());
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
        this.lZu = new com.baidu.tbadk.core.dialog.a(this.mgQ.getPageContext().getPageActivity());
        this.lZu.nx(i3);
        this.lZu.setYesButtonTag(sparseArray);
        this.lZu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.mhn != null) {
                    a.this.mhn.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lZu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lZu.jF(true);
        this.lZu.b(this.mgQ.getPageContext());
        if (z) {
            this.lZu.bqx();
        } else if (1 == this.mgk.dtB()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.mgk.dtB(), this.mgk.dtA(), this.mgk.bKy());
            hVar.eg(this.mfv.bCk().getId(), this.mfv.bCk().getName());
            hVar.setForumHeadUrl(this.mgk.bKB());
            hVar.setUserLevel(this.mgk.bKC());
            UserData userData = new UserData();
            userData.setIsManager(this.mgk.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            h(sparseArray);
        }
    }

    private void h(final SparseArray<Object> sparseArray) {
        AntiData cBz;
        if (this.mgQ != null && sparseArray != null && this.mgP != null) {
            if (this.jRi == null) {
                this.jRi = new com.baidu.tieba.NEGFeedBack.f(this.mgQ.getPageContext(), this.mgP);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mgk != null && (cBz = this.mgk.cBz()) != null && cBz.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBz.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray2);
            this.jRi.setDefaultReasonArray(new String[]{this.mgQ.getString(R.string.delete_thread_reason_1), this.mgQ.getString(R.string.delete_thread_reason_2), this.mgQ.getString(R.string.delete_thread_reason_3), this.mgQ.getString(R.string.delete_thread_reason_4), this.mgQ.getString(R.string.delete_thread_reason_5)});
            this.jRi.setData(avVar);
            this.jRi.Er("4");
            this.jRi.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    String R = au.R(jSONArray);
                    if (a.this.mhn != null) {
                        a.this.mhn.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cBz;
        if (this.mgQ != null && sparseArray != null && this.mgP != null) {
            if (this.maM == null) {
                this.maM = new i(this.mgQ.getPageContext(), this.mgP, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mgk != null && (cBz = this.mgk.cBz()) != null && cBz.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBz.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray2);
            this.maM.setDefaultReasonArray(new String[]{this.mgQ.getString(R.string.delete_thread_reason_1), this.mgQ.getString(R.string.delete_thread_reason_2), this.mgQ.getString(R.string.delete_thread_reason_3), this.mgQ.getString(R.string.delete_thread_reason_4), this.mgQ.getString(R.string.delete_thread_reason_5)});
            this.maM.setData(avVar);
            this.maM.Er("4");
            this.maM.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    String R = au.R(jSONArray);
                    if (a.this.mhn != null) {
                        a.this.mhn.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(final boolean z) {
        if (this.gzp != null) {
            if (!z) {
                this.gzp.setEnabled(z);
            } else {
                this.gzp.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gzp.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.mhm = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.mhn = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.mgQ.showToast(this.mgQ.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.mgQ.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bBh() != null) {
            this.kSF = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mgR.addView(hVar.bBh(), layoutParams);
            this.kSF.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    a.this.dtd();
                }
            });
        }
    }

    public void dsI() {
        if (this.gzp != null) {
            this.mht = this.gzp.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.mgk == null || this.mgk.dtg() == null) {
            return false;
        }
        if (this.mgk.dlv() != 0) {
            return false;
        }
        return (this.mfv == null || this.mfv.bln() == null || this.mfv.bln().bnQ() == null || !TextUtils.equals(this.mfv.bln().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dsJ() {
        if (this.mgk != null) {
            if ((!dsM() && this.mhi != null && this.mhi.isShown()) || com.baidu.tbadk.core.util.y.isEmpty(this.mho)) {
                this.mgk.wi(false);
            } else {
                this.mgk.wi(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.mgk = subPbModel;
    }

    public void wf(boolean z) {
        if (this.mgk != null && this.mgk.dsG() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mhj = new BlankView(this.mgQ.getPageContext().getPageActivity());
            this.fLQ.addView(this.mhj, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.mhj.setVisibility(0);
            this.mhj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mgQ.finish();
                }
            });
            this.mgO.setBlankView(this.mhj);
        }
    }

    public void dsK() {
        b(this.mgQ);
        this.gzp.setNextPage(this.mhd);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yv(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dsM() && this.mhi != null && this.mhi.isShown()) {
                i = (this.mht - this.mhs) - 1;
            } else {
                i = this.mht - this.mhs;
            }
            int count = com.baidu.tbadk.core.util.y.getCount(this.mho);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.y.subList(this.mho, 0, i));
            com.baidu.tbadk.core.util.y.add(arrayList, postData2);
            com.baidu.tbadk.core.util.y.add(arrayList, postData);
            this.gzp.smoothScrollToPosition(this.mht + 2);
            this.gzp.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gzp.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gzp.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.mgO;
    }

    public void drk() {
        if (this.mhf != null) {
            g.dismissPopupWindow(this.mhf, this.mgQ.getPageContext().getPageActivity());
        }
        if (this.mhh != null) {
            this.mhh.dismiss();
        }
        if (this.lZu != null) {
            this.lZu.dismiss();
        }
        if (this.mhk != null) {
            g.b(this.mhk, this.mgQ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mgn != null) {
            this.mgn.dismiss();
        }
    }

    public void dsL() {
        this.gzp.setNextPage(this.mhd);
        this.mhd.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fBK = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v77, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(q qVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (qVar != null) {
            if (this.fBK && this.mgP != null) {
                this.mgP.setVisibility(8);
                this.gzp.removeHeaderView(this.mgP);
                this.mhs = 1;
            }
            this.mfv = qVar;
            if (this.mfv.dlY() != null) {
                this.mfv.dlY().nxV = true;
            }
            if (this.mgP != null) {
                this.mgP.setVisibility(0);
            }
            if (qVar.bln() != null && qVar.bln().bmz()) {
                this.mgS.setText(R.string.view_original);
            } else {
                this.mgS.setText(R.string.view_subject);
            }
            if (qVar.dlY() != null) {
                this.fWM = qVar.dlY().dNF();
                if (this.fWM > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.mgQ.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fWM)));
                    if (this.mgQ != null) {
                        this.jBI.setText(this.mgQ.dqu());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.mgQ.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.mgQ.dsG()) {
                    str = "PB";
                }
                if (qVar.dlY().bol() != null) {
                    this.mhc.setData(this.mgQ.getPageContext(), qVar.dlY().bol(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", qVar.bCk().getId(), qVar.bCk().getName(), qVar.bln().getId(), str));
                } else {
                    this.mhc.setData(null, null, null);
                }
            }
            if (qVar.hasMore()) {
                this.mhd.startLoadData();
                this.mhu.setHasMoreData(true);
            } else {
                this.mhd.endLoadData();
                this.mhu.setHasMoreData(false);
            }
            this.mho = qVar.dmh();
            if (this.mho == null || this.mho.size() <= mgN) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.mho.size() - mgN;
                Go(size);
                int firstVisiblePosition = this.gzp.getFirstVisiblePosition() - size;
                View childAt = this.gzp.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mho);
            if (com.baidu.tbadk.core.util.y.isEmpty(this.mho)) {
                this.gzp.setNextPage(null);
                if (this.fBK) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.a.a());
                }
            } else {
                this.gzp.setNextPage(this.mhd);
            }
            com.baidu.tieba.pb.pb.sub.a.b bVar = new com.baidu.tieba.pb.pb.sub.a.b();
            bVar.setReplyNum(qVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fBK) {
                arrayList.add(0, qVar.dlY());
            }
            if (this.mgQ != null && this.mgQ.dsH() != null) {
                this.lQg.setVisibility(this.mgQ.dsH().dtC() ? 0 : 8);
            }
            this.mhu.a(this.mfv.bln(), arrayList);
            a(qVar, qVar.dlY(), qVar.Xg(), qVar.bjZ(), i, z);
            if (i4 > 0) {
                this.gzp.setSelectionFromTop(i3, i2);
            } else if (z2 && !au.isEmpty(this.mgQ.dsH().doz())) {
                String doz = this.mgQ.dsH().doz();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !doz.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gzp.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gzp.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gzp.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.mfv.dme() > 1) {
                this.gzp.setPullRefresh(this.lZp);
                this.mgO.setEnableDragExit(false);
                return;
            }
            this.gzp.setPullRefresh(null);
            this.mgO.setEnableDragExit(true);
        }
    }

    private void Go(int i) {
        if (this.mho != null) {
            if (this.mho.size() <= i) {
                this.mho.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.mho.iterator();
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

    public boolean dsM() {
        return this.mhu.aHt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(q qVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fBK) {
            if (!StringUtils.isNull(postData.dNM())) {
                this.mha.setVisibility(0);
                this.mha.startLoad(postData.dNM(), 10, true);
            } else {
                this.mha.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dNO = postData.dNO();
            if (dNO != null && dNO.nwB) {
                this.mhb.setVisibility(0);
            } else {
                this.mhb.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.mgP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.mgP.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.mgX.setText((CharSequence) null);
            this.eIO.setText((CharSequence) null);
            this.mcB.setVisibility(8);
            if (!this.fBK) {
                c(postData.bnQ());
                if (z) {
                    this.mcB.setVisibility(0);
                    ap.setViewTextColor(this.mcB, R.color.CAM_X0302);
                }
            }
            this.mgY.setText(au.getFormatTime(postData.getTime()));
            String format = String.format(this.mgQ.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dNF()));
            if (qVar.bln() != null && qVar.bln().bmz()) {
                this.mgX.setText((CharSequence) null);
            } else {
                this.mgX.setText(format);
            }
            postData.bnQ().getUserTbVipInfoData();
            boolean a2 = a(this.mgZ, postData.dNH());
            if (StringUtils.isNull(postData.dNM()) && !a2 && postData.bHH() != null) {
                this.alb.setVisibility(0);
                this.alb.setTag(postData.bHH());
                return;
            }
            this.alb.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ag.getTextLength(name_show) > 14) {
                str = ag.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.eIO.setText(dT(metaData.getSealPrefix(), str));
            } else {
                this.eIO.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.mgV != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.mgV.setVisibility(8);
                } else {
                    this.mgV.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eGA = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.mgV.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.eIO, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.eIO, R.color.CAM_X0108);
            }
            this.mgU.setVisibility(0);
            this.mgU.setUserId(metaData.getUserId());
            this.mgU.setUserName(metaData.getUserName());
            this.mgU.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.mgU, metaData);
            this.mgU.startLoad(metaData.getAvater(), 28, false);
            this.mgT.setTag(R.id.tag_user_id, metaData.getUserId());
            this.mgT.setTag(R.id.tag_user_name, metaData.getUserName());
            this.mgT.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bHz() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bHz().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.p(next.bHG());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.lL(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dVY());
                        continue;
                    case 17:
                        String str = next.bHK().mGifInfo.mSharpText;
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
        if (!tbRichTextData.bHO()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bHG() == null || tbRichTextData.bHG().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bHG());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mgQ.getPageContext().getString(R.string.refresh_view_button_text), this.eHG));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.mgQ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.mgR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gzp.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kSF.bCq();
        ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.mgQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void CY(int i) {
        b(NoDataViewFactory.d.dS(null, this.mgQ.getResources().getString(R.string.refresh_view_title_text)));
        this.mhp.setVisibility(8);
    }

    public void aY(String str, boolean z) {
        if (z) {
            b(NoDataViewFactory.d.dS("", str));
        } else {
            b(NoDataViewFactory.d.dS(str, this.mgQ.getPageContext().getString(R.string.refresh_view_title_text)));
        }
        this.mhp.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gzp.setVisibility(0);
            this.mhp.setVisibility(0);
            this.mgO.setOnTouchListener(null);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        this.eHG = onClickListener;
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
                String userId2 = postData.bnQ().getUserId();
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
            if (this.mfv != null && this.mfv.bln() != null && this.mfv.bln().bnQ() != null && postData.bnQ() != null) {
                String userId3 = this.mfv.bln().bnQ().getUserId();
                String userId4 = postData.bnQ().getUserId();
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
                    userId = postData.bnQ().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z = true;
                    }
                    int i2 = postData.dNF() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.bnQ() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnQ().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnQ().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnQ().getPortrait());
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
                        if (postData.bnQ() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnQ().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnQ().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnQ().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bnQ() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnQ().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnQ().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnQ().getName_show());
                        }
                        if (this.mfv.bln() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.mfv.bln().getId());
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
            userId = postData.bnQ().getUserId();
            if (userId != null) {
                z3 = true;
                z = true;
            }
            if (postData.dNF() != 1) {
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

    public void wg(boolean z) {
        if (this.mgn != null && this.mgn.dpB() != null) {
            if (z) {
                this.mgn.dpB().setText(R.string.remove_mark);
            } else {
                this.mgn.dpB().setText(R.string.mark);
            }
        }
    }

    public View dsN() {
        return this.mhi;
    }

    public void onChangeSkinType(int i) {
        this.mgQ.getLayoutMode().setNightMode(i == 1);
        this.mgQ.getLayoutMode().onModeChanged(this.mgO);
        this.mgQ.getLayoutMode().onModeChanged(this.mgP);
        ap.setBackgroundColor(this.mgO, R.color.CAM_X0201);
        ap.setBackgroundColor(this.mgR, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.mgQ.getPageContext(), i);
        WebPManager.a(this.eHB, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.mgS != null) {
            ap.setViewTextColor(this.mgS, R.color.goto_see_subject_color);
        }
        this.fLP.onChangeSkinType(this.mgQ.getPageContext(), i);
        this.mgQ.getLayoutMode().onModeChanged(this.mhi);
        ap.setViewTextColor(this.mgZ, R.color.CAM_X0105);
        this.mgZ.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        if (this.kSF != null && this.kSF.bBh() != null) {
            this.kSF.bBh().onChangeSkinType(i);
        }
        this.mhd.changeSkin(i);
        this.alb.buo();
        ap.setViewTextColor(this.jBI, R.color.CAM_X0110);
        ap.setViewTextColor(this.mcB, R.color.CAM_X0302);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0108);
        this.jBI.setAlpha(0.95f);
        if (this.mhe != null) {
            com.baidu.tbadk.r.a.a(this.mgQ.getPageContext(), this.mhe);
        }
        if (this.mhu != null) {
            this.mhu.notifyDataSetChanged();
        }
        this.mgQ.getLayoutMode().onModeChanged(this.mhg);
        ap.setBackgroundColor(this.lZJ, R.color.CAM_X0203);
        this.lZM.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lZL.setBackgroundDrawable(ap.aL(l.getDimens(this.mgQ, R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
    }

    public void dsO() {
        this.mProgress.setVisibility(0);
    }

    public void dsP() {
        this.gzp.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mhd.endLoadData();
    }

    public void czy() {
        this.gzp.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mhd.czy();
    }

    public boolean dsQ() {
        return this.mgO.dsQ();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mhu.c(onLongClickListener);
    }

    public View dsR() {
        return this.mgP;
    }

    public TextView cIF() {
        return this.jBI;
    }

    public ImageView dsS() {
        return this.mhq;
    }

    public ImageView dsT() {
        return this.mhr;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Gp(int i) {
    }

    public View dsU() {
        return this.mgS;
    }

    public View dsV() {
        return this.mha;
    }

    public MorePopupWindow dsW() {
        return this.mhf;
    }

    public void showLoadingDialog() {
        if (this.iDU == null) {
            this.iDU = new com.baidu.tbadk.core.view.a(this.mgQ.getPageContext());
        }
        this.iDU.setDialogVisiable(true);
    }

    public void ckx() {
        if (this.iDU != null) {
            this.iDU.setDialogVisiable(false);
        }
    }

    public TextView dsX() {
        return this.mgZ;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mhu.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.mhu != null) {
            this.mhu.notifyDataSetChanged();
        }
    }

    public aa dsY() {
        return this.mgn;
    }

    public void cKY() {
    }

    public void cKZ() {
    }

    public void cJg() {
        if (this.mgO != null) {
            this.mgO.onDestroy();
        }
        if (this.kSF != null) {
            this.kSF.onDestory();
        }
    }

    public void dsZ() {
        if (this.mgQ.isPaused()) {
        }
    }

    public View dta() {
        return this.mgT;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.mgQ.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dtb() {
        if (this.kSF == null || this.kSF.bBh() == null) {
            return 0;
        }
        return this.kSF.bBh().getHeight();
    }

    public int dtc() {
        if (this.mhj == null) {
            return 0;
        }
        return this.mhj.getHeight();
    }

    public void dtd() {
        if (this.jBI != null && this.kSF != null) {
            if (this.kSF.bCv()) {
                this.jBI.setText(R.string.draft_to_send);
            } else {
                this.jBI.setText(this.mgQ.dqu());
            }
        }
    }

    public void vp(boolean z) {
        if (this.lZM != null) {
            this.lZM.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fjz = cVar;
        if (this.lZp != null) {
            this.lZp.setListPullRefreshListener(cVar);
        }
    }
}
