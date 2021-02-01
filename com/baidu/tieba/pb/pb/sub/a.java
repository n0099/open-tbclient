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
    private static final int mgy = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener bbI;
    private ImageView eHB;
    private NoNetworkView fLP;
    private LinearLayout fLQ;
    private f.c fjz;
    private BdTypeListView gzb;
    private com.baidu.tbadk.core.view.a iDG;
    private View iVJ;
    private TextView jBu;
    private com.baidu.tieba.NEGFeedBack.f jQU;
    private MaskView lPR;
    private e lZa;
    private View lZu;
    private LinearLayout lZw;
    private HeadImageView lZx;
    private ProgressBar mProgress;
    private i maw;
    private SubPbModel mfV;
    private aa mfY;
    private q mfg;
    private View mgA;
    private NewSubPbActivity mgB;
    private RelativeLayout mgC;
    private View mgG;
    private ThreadSkinView mgN;
    private d mgO;
    private View mgP;
    private View mgR;
    private View mgT;
    private BlankView mgU;
    private com.baidu.tbadk.core.dialog.b mgW;
    private ArrayList<PostData> mgZ;
    private SubPbView mgz;
    private RelativeLayout mha;
    private ImageView mhb;
    private ImageView mhc;
    private c mhf;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eHG = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView mgD = null;
    private LinearLayout mgE = null;
    private HeadImageView mgF = null;
    private TextView eIO = null;
    private ImageView mgH = null;
    private TextView mcm = null;
    private TextView mgI = null;
    private TextView mgJ = null;
    private EllipsizeRichTextView mgK = null;
    private TbImageView mgL = null;
    private PlayVoiceBntNew alb = null;
    private TextView mgM = null;
    private MorePopupWindow mgQ = null;
    private com.baidu.tbadk.core.dialog.b mgS = null;
    private Dialog mgV = null;
    private com.baidu.tbadk.core.dialog.a lZf = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a mgX = null;
    private NewSubPbActivity.a mgY = null;
    private h kSr = null;
    private int fWM = 0;
    private int mhd = 2;
    private int mhe = 0;
    private boolean fBK = true;
    private boolean lRy = com.baidu.tbadk.a.d.biY();
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
    protected AdapterView.OnItemLongClickListener mhg = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.mgZ, i);
            if (view != null && view.getTag() != null) {
                if (a.this.mfY == null) {
                    a.this.mfY = new aa(a.this.mgB.getPageContext(), a.this.bbI);
                }
                a.this.mfY.QE();
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
                aa aaVar = a.this.mfY;
                int dlo = a.this.mfV.dlo();
                if (!a.this.lRy || postData2 == null || !postData2.nxv) {
                    z = false;
                }
                aaVar.a(sparseArray, dlo, z2, z);
                if (z2) {
                    a.this.mfY.dpw().setVisibility(0);
                    a.this.mfY.dpw().setTag(postData.getId());
                } else {
                    a.this.mfY.dpw().setVisibility(8);
                }
                a.this.mfY.dpu().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener mhh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.mgB != null && bh.checkUpIsLogin(a.this.mgB.getPageContext().getPageActivity())) {
                if ((a.this.mgB.kSl == null || a.this.mfV == null || a.this.mfV.cBs() == null || a.this.mgB.kSl.ox(a.this.mfV.cBs().replyPrivateFlag)) && a.this.mfV != null && a.this.kSr != null) {
                    a.this.dsB();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dsD();
                        a.this.mfV.dtc();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kSr.setReplyId(str2);
                            a.this.kSr.De(str);
                        }
                    }
                    a.this.dsC();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.mgz = null;
        this.mgA = null;
        this.gzb = null;
        this.lZa = null;
        this.mgB = null;
        this.fLP = null;
        this.mgC = null;
        this.mgG = null;
        this.mgO = null;
        this.mgT = null;
        this.bbI = null;
        this.mProgress = null;
        this.jBu = null;
        this.mha = null;
        this.mhb = null;
        this.mhc = null;
        this.mgB = newSubPbActivity;
        this.bbI = onClickListener;
        this.mgz = (SubPbView) LayoutInflater.from(this.mgB.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.mgA = LayoutInflater.from(this.mgB.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fLQ = (LinearLayout) this.mgz.findViewById(R.id.navigation_bar_group);
        this.mha = (RelativeLayout) this.mgz.findViewById(R.id.subpb_editor_tool_comment);
        this.jBu = (TextView) this.mgz.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jBu.setOnClickListener(this.bbI);
        this.mhb = (ImageView) this.mgz.findViewById(R.id.subpb_editor_tool_more_img);
        this.mhc = (ImageView) this.mgz.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.mhc.setOnClickListener(this.bbI);
        this.mhb.setOnClickListener(this.bbI);
        this.fLP = (NoNetworkView) this.mgz.findViewById(R.id.view_no_network);
        cIt();
        bWp();
        this.mgC = (RelativeLayout) this.mgz.findViewById(R.id.sub_pb_body_layout);
        this.gzb = (BdTypeListView) this.mgz.findViewById(R.id.new_sub_pb_list);
        this.mgN = (ThreadSkinView) LayoutInflater.from(this.mgB.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gzb.addHeaderView(this.mgN);
        this.gzb.addHeaderView(this.mgA);
        this.iVJ = new TextView(newSubPbActivity.getActivity());
        this.iVJ.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gzb.addHeaderView(this.iVJ, 0);
        this.mgz.setTopView(this.iVJ);
        this.mgz.setNavigationView(this.fLQ);
        this.mgz.setListView(this.gzb);
        this.mgz.setContentView(this.mgC);
        this.mgO = new d(this.mgB.getPageContext());
        this.mgO.setLineGone();
        this.mgT = this.mgO.getView();
        this.gzb.setNextPage(this.mgO);
        this.mgO.setOnClickListener(this.bbI);
        this.gzb.setOnItemClickListener(this.mhh);
        this.gzb.setOnItemLongClickListener(this.mhg);
        this.gzb.setOnTouchListener(this.fvK);
        this.lZa = new e(newSubPbActivity.getPageContext());
        this.lZa.createView();
        this.lZa.setListPullRefreshListener(this.fjz);
        this.lZa.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.mgz.findViewById(R.id.progress);
        this.lPR = (MaskView) this.mgz.findViewById(R.id.mask_view);
        this.lZu = this.mgz.findViewById(R.id.view_comment_top_line);
        this.lZw = (LinearLayout) this.mgz.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lZx = (HeadImageView) this.mgz.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lZx.setVisibility(0);
        this.lZx.setIsRound(true);
        this.lZx.setBorderWidth(l.getDimens(this.mgB, R.dimen.L_X01));
        this.lZx.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lZx.setDefaultBgResource(0);
        this.lZx.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lZx.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.mgA != null) {
            this.mgA.setVisibility(4);
        }
        this.mgG = com.baidu.tbadk.ala.b.bjQ().A(this.mgB.getActivity(), 4);
        if (this.mgG != null) {
            this.mgG.setVisibility(8);
            this.mgE.addView(this.mgG, 3);
        }
        this.mhf = new c(this.mgB, this.gzb);
        this.mhf.setFromCDN(this.mIsFromCDN);
        this.mhf.C(this.bbI);
        this.mhf.Kw();
    }

    public ListView getListView() {
        return this.gzb;
    }

    public void bWp() {
        this.mgE = (LinearLayout) this.mgA.findViewById(R.id.subpb_head_user_info_root);
        this.mgE.setOnClickListener(this.bbI);
        this.mgF = (HeadImageView) this.mgA.findViewById(R.id.photo);
        this.mgF.setRadius(l.getDimens(this.mgB.getActivity(), R.dimen.tbds45));
        this.mgF.setClickable(false);
        this.eIO = (TextView) this.mgA.findViewById(R.id.user_name);
        this.mgH = (ImageView) this.mgA.findViewById(R.id.user_rank);
        this.mgH.setVisibility(8);
        this.mcm = (TextView) this.mgA.findViewById(R.id.floor_owner);
        this.mgD = (TextView) this.mgA.findViewById(R.id.see_subject);
        this.mgD.setOnClickListener(this.bbI);
        this.mgI = (TextView) this.mgA.findViewById(R.id.floor);
        this.mgJ = (TextView) this.mgA.findViewById(R.id.time);
        this.mgK = (EllipsizeRichTextView) this.mgA.findViewById(R.id.content_text);
        this.mgK.setOnClickListener(this.bbI);
        ap.setViewTextColor(this.mgK, R.color.CAM_X0105);
        this.mgK.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.mgK.setLineSpacing(0.0f, 1.25f);
        this.mgL = (TbImageView) this.mgA.findViewById(R.id.sub_pb_image);
        this.mgL.setOnClickListener(this.bbI);
        this.mgM = (TextView) this.mgA.findViewById(R.id.advert);
        this.alb = (PlayVoiceBntNew) this.mgA.findViewById(R.id.voice_btn);
        this.mgA.setOnTouchListener(this.fvK);
        this.mgA.setOnClickListener(this.bbI);
    }

    public void a(b.InterfaceC0558b interfaceC0558b, boolean z) {
        if (this.mgW != null) {
            this.mgW.dismiss();
            this.mgW = null;
        }
        this.mgW = new com.baidu.tbadk.core.dialog.b(this.mgB.getPageContext().getPageActivity());
        if (z) {
            this.mgW.a(new String[]{this.mgB.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0558b);
        } else {
            this.mgW.a(new String[]{this.mgB.getPageContext().getString(R.string.save_to_emotion), this.mgB.getPageContext().getString(R.string.save_to_local)}, interfaceC0558b);
        }
        this.mgW.d(this.mgB.getPageContext());
        this.mgW.bqz();
    }

    public void dP(View view) {
        this.mgP = view;
    }

    public void cIt() {
        int dimens = l.getDimens(this.mgB.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.mgB.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.mgz.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mgU != null) {
                    a.this.mgz.onFinish();
                } else {
                    a.this.mgB.finish();
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
        if (this.mgV == null) {
            this.mgV = new Dialog(this.mgB.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mgV.setCanceledOnTouchOutside(true);
            this.mgV.setCancelable(true);
            this.mgR = LayoutInflater.from(this.mgB.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.mgB.getLayoutMode().onModeChanged(this.mgR);
            this.mgV.setContentView(this.mgR);
            WindowManager.LayoutParams attributes = this.mgV.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.mgB.getPageContext().getPageActivity()) * 0.9d);
            this.mgV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.mgV.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.mgV.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.mgV.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.mgV != null && (a.this.mgV instanceof Dialog)) {
                        g.b(a.this.mgV, a.this.mgB.getPageContext());
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
                    if (a.this.mgV != null && (a.this.mgV instanceof Dialog)) {
                        g.b(a.this.mgV, a.this.mgB.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.mgX != null) {
                        a.this.mgX.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.mgV != null && (a.this.mgV instanceof Dialog)) {
                        g.b(a.this.mgV, a.this.mgB.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.mgB.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.mgV, this.mgB.getPageContext());
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
        this.lZf = new com.baidu.tbadk.core.dialog.a(this.mgB.getPageContext().getPageActivity());
        this.lZf.nx(i3);
        this.lZf.setYesButtonTag(sparseArray);
        this.lZf.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.mgY != null) {
                    a.this.mgY.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lZf.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lZf.jF(true);
        this.lZf.b(this.mgB.getPageContext());
        if (z) {
            this.lZf.bqx();
        } else if (1 == this.mfV.dtu()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.mfV.dtu(), this.mfV.dtt(), this.mfV.bKt());
            hVar.eg(this.mfg.bCk().getId(), this.mfg.bCk().getName());
            hVar.setForumHeadUrl(this.mfV.bKw());
            hVar.setUserLevel(this.mfV.bKx());
            UserData userData = new UserData();
            userData.setIsManager(this.mfV.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            h(sparseArray);
        }
    }

    private void h(final SparseArray<Object> sparseArray) {
        AntiData cBs;
        if (this.mgB != null && sparseArray != null && this.mgA != null) {
            if (this.jQU == null) {
                this.jQU = new com.baidu.tieba.NEGFeedBack.f(this.mgB.getPageContext(), this.mgA);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mfV != null && (cBs = this.mfV.cBs()) != null && cBs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBs.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray2);
            this.jQU.setDefaultReasonArray(new String[]{this.mgB.getString(R.string.delete_thread_reason_1), this.mgB.getString(R.string.delete_thread_reason_2), this.mgB.getString(R.string.delete_thread_reason_3), this.mgB.getString(R.string.delete_thread_reason_4), this.mgB.getString(R.string.delete_thread_reason_5)});
            this.jQU.setData(avVar);
            this.jQU.Et("4");
            this.jQU.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    String R = au.R(jSONArray);
                    if (a.this.mgY != null) {
                        a.this.mgY.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cBs;
        if (this.mgB != null && sparseArray != null && this.mgA != null) {
            if (this.maw == null) {
                this.maw = new i(this.mgB.getPageContext(), this.mgA, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.mfV != null && (cBs = this.mfV.cBs()) != null && cBs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBs.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray2);
            this.maw.setDefaultReasonArray(new String[]{this.mgB.getString(R.string.delete_thread_reason_1), this.mgB.getString(R.string.delete_thread_reason_2), this.mgB.getString(R.string.delete_thread_reason_3), this.mgB.getString(R.string.delete_thread_reason_4), this.mgB.getString(R.string.delete_thread_reason_5)});
            this.maw.setData(avVar);
            this.maw.Et("4");
            this.maw.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    String R = au.R(jSONArray);
                    if (a.this.mgY != null) {
                        a.this.mgY.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(final boolean z) {
        if (this.gzb != null) {
            if (!z) {
                this.gzb.setEnabled(z);
            } else {
                this.gzb.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gzb.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.mgX = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.mgY = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.mgB.showToast(this.mgB.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.mgB.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bBh() != null) {
            this.kSr = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mgC.addView(hVar.bBh(), layoutParams);
            this.kSr.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    a.this.dsW();
                }
            });
        }
    }

    public void dsB() {
        if (this.gzb != null) {
            this.mhe = this.gzb.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.mfV == null || this.mfV.dsZ() == null) {
            return false;
        }
        if (this.mfV.dlo() != 0) {
            return false;
        }
        return (this.mfg == null || this.mfg.bln() == null || this.mfg.bln().bnQ() == null || !TextUtils.equals(this.mfg.bln().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dsC() {
        if (this.mfV != null) {
            if ((!dsF() && this.mgT != null && this.mgT.isShown()) || com.baidu.tbadk.core.util.y.isEmpty(this.mgZ)) {
                this.mfV.wi(false);
            } else {
                this.mfV.wi(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.mfV = subPbModel;
    }

    public void wf(boolean z) {
        if (this.mfV != null && this.mfV.dsz() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mgU = new BlankView(this.mgB.getPageContext().getPageActivity());
            this.fLQ.addView(this.mgU, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.mgU.setVisibility(0);
            this.mgU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mgB.finish();
                }
            });
            this.mgz.setBlankView(this.mgU);
        }
    }

    public void dsD() {
        b(this.mgB);
        this.gzb.setNextPage(this.mgO);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yv(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dsF() && this.mgT != null && this.mgT.isShown()) {
                i = (this.mhe - this.mhd) - 1;
            } else {
                i = this.mhe - this.mhd;
            }
            int count = com.baidu.tbadk.core.util.y.getCount(this.mgZ);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.y.subList(this.mgZ, 0, i));
            com.baidu.tbadk.core.util.y.add(arrayList, postData2);
            com.baidu.tbadk.core.util.y.add(arrayList, postData);
            this.gzb.smoothScrollToPosition(this.mhe + 2);
            this.gzb.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gzb.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gzb.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.mgz;
    }

    public void drd() {
        if (this.mgQ != null) {
            g.dismissPopupWindow(this.mgQ, this.mgB.getPageContext().getPageActivity());
        }
        if (this.mgS != null) {
            this.mgS.dismiss();
        }
        if (this.lZf != null) {
            this.lZf.dismiss();
        }
        if (this.mgV != null) {
            g.b(this.mgV, this.mgB.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mfY != null) {
            this.mfY.dismiss();
        }
    }

    public void dsE() {
        this.gzb.setNextPage(this.mgO);
        this.mgO.startLoadData();
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
            if (this.fBK && this.mgA != null) {
                this.mgA.setVisibility(8);
                this.gzb.removeHeaderView(this.mgA);
                this.mhd = 1;
            }
            this.mfg = qVar;
            if (this.mfg.dlR() != null) {
                this.mfg.dlR().nxv = true;
            }
            if (this.mgA != null) {
                this.mgA.setVisibility(0);
            }
            if (qVar.bln() != null && qVar.bln().bmz()) {
                this.mgD.setText(R.string.view_original);
            } else {
                this.mgD.setText(R.string.view_subject);
            }
            if (qVar.dlR() != null) {
                this.fWM = qVar.dlR().dNx();
                if (this.fWM > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.mgB.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fWM)));
                    if (this.mgB != null) {
                        this.jBu.setText(this.mgB.dqn());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.mgB.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.mgB.dsz()) {
                    str = "PB";
                }
                if (qVar.dlR().bol() != null) {
                    this.mgN.setData(this.mgB.getPageContext(), qVar.dlR().bol(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", qVar.bCk().getId(), qVar.bCk().getName(), qVar.bln().getId(), str));
                } else {
                    this.mgN.setData(null, null, null);
                }
            }
            if (qVar.hasMore()) {
                this.mgO.startLoadData();
                this.mhf.setHasMoreData(true);
            } else {
                this.mgO.endLoadData();
                this.mhf.setHasMoreData(false);
            }
            this.mgZ = qVar.dma();
            if (this.mgZ == null || this.mgZ.size() <= mgy) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.mgZ.size() - mgy;
                Go(size);
                int firstVisiblePosition = this.gzb.getFirstVisiblePosition() - size;
                View childAt = this.gzb.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mgZ);
            if (com.baidu.tbadk.core.util.y.isEmpty(this.mgZ)) {
                this.gzb.setNextPage(null);
                if (this.fBK) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.a.a());
                }
            } else {
                this.gzb.setNextPage(this.mgO);
            }
            com.baidu.tieba.pb.pb.sub.a.b bVar = new com.baidu.tieba.pb.pb.sub.a.b();
            bVar.setReplyNum(qVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fBK) {
                arrayList.add(0, qVar.dlR());
            }
            if (this.mgB != null && this.mgB.dsA() != null) {
                this.lPR.setVisibility(this.mgB.dsA().dtv() ? 0 : 8);
            }
            this.mhf.a(this.mfg.bln(), arrayList);
            a(qVar, qVar.dlR(), qVar.Xg(), qVar.bjZ(), i, z);
            if (i4 > 0) {
                this.gzb.setSelectionFromTop(i3, i2);
            } else if (z2 && !au.isEmpty(this.mgB.dsA().dos())) {
                String dos = this.mgB.dsA().dos();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dos.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gzb.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gzb.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gzb.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.mfg.dlX() > 1) {
                this.gzb.setPullRefresh(this.lZa);
                this.mgz.setEnableDragExit(false);
                return;
            }
            this.gzb.setPullRefresh(null);
            this.mgz.setEnableDragExit(true);
        }
    }

    private void Go(int i) {
        if (this.mgZ != null) {
            if (this.mgZ.size() <= i) {
                this.mgZ.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.mgZ.iterator();
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

    public boolean dsF() {
        return this.mhf.aHt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(q qVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fBK) {
            if (!StringUtils.isNull(postData.dNE())) {
                this.mgL.setVisibility(0);
                this.mgL.startLoad(postData.dNE(), 10, true);
            } else {
                this.mgL.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dNG = postData.dNG();
            if (dNG != null && dNG.nwb) {
                this.mgM.setVisibility(0);
            } else {
                this.mgM.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.mgA.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.mgA.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.mgI.setText((CharSequence) null);
            this.eIO.setText((CharSequence) null);
            this.mcm.setVisibility(8);
            if (!this.fBK) {
                c(postData.bnQ());
                if (z) {
                    this.mcm.setVisibility(0);
                    ap.setViewTextColor(this.mcm, R.color.CAM_X0302);
                }
            }
            this.mgJ.setText(au.getFormatTime(postData.getTime()));
            String format = String.format(this.mgB.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dNx()));
            if (qVar.bln() != null && qVar.bln().bmz()) {
                this.mgI.setText((CharSequence) null);
            } else {
                this.mgI.setText(format);
            }
            postData.bnQ().getUserTbVipInfoData();
            boolean a2 = a(this.mgK, postData.dNz());
            if (StringUtils.isNull(postData.dNE()) && !a2 && postData.bHH() != null) {
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
            if (metaData.getAlaUserData() != null && this.mgG != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.mgG.setVisibility(8);
                } else {
                    this.mgG.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eGA = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.mgG.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.eIO, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.eIO, R.color.CAM_X0108);
            }
            this.mgF.setVisibility(0);
            this.mgF.setUserId(metaData.getUserId());
            this.mgF.setUserName(metaData.getUserName());
            this.mgF.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.mgF, metaData);
            this.mgF.startLoad(metaData.getAvater(), 28, false);
            this.mgE.setTag(R.id.tag_user_id, metaData.getUserId());
            this.mgE.setTag(R.id.tag_user_name, metaData.getUserName());
            this.mgE.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.c.dVQ());
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
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mgB.getPageContext().getString(R.string.refresh_view_button_text), this.eHG));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.mgB.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.mgC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gzb.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kSr.bCq();
        ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.mgB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void CY(int i) {
        b(NoDataViewFactory.d.dS(null, this.mgB.getResources().getString(R.string.refresh_view_title_text)));
        this.mha.setVisibility(8);
    }

    public void aY(String str, boolean z) {
        if (z) {
            b(NoDataViewFactory.d.dS("", str));
        } else {
            b(NoDataViewFactory.d.dS(str, this.mgB.getPageContext().getString(R.string.refresh_view_title_text)));
        }
        this.mha.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gzb.setVisibility(0);
            this.mha.setVisibility(0);
            this.mgz.setOnTouchListener(null);
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
            if (this.mfg != null && this.mfg.bln() != null && this.mfg.bln().bnQ() != null && postData.bnQ() != null) {
                String userId3 = this.mfg.bln().bnQ().getUserId();
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
                    int i2 = postData.dNx() != 1 ? 0 : 1;
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
                        if (this.mfg.bln() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.mfg.bln().getId());
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
            if (postData.dNx() != 1) {
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
        if (this.mfY != null && this.mfY.dpu() != null) {
            if (z) {
                this.mfY.dpu().setText(R.string.remove_mark);
            } else {
                this.mfY.dpu().setText(R.string.mark);
            }
        }
    }

    public View dsG() {
        return this.mgT;
    }

    public void onChangeSkinType(int i) {
        this.mgB.getLayoutMode().setNightMode(i == 1);
        this.mgB.getLayoutMode().onModeChanged(this.mgz);
        this.mgB.getLayoutMode().onModeChanged(this.mgA);
        ap.setBackgroundColor(this.mgz, R.color.CAM_X0201);
        ap.setBackgroundColor(this.mgC, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.mgB.getPageContext(), i);
        WebPManager.a(this.eHB, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.mgD != null) {
            ap.setViewTextColor(this.mgD, R.color.goto_see_subject_color);
        }
        this.fLP.onChangeSkinType(this.mgB.getPageContext(), i);
        this.mgB.getLayoutMode().onModeChanged(this.mgT);
        ap.setViewTextColor(this.mgK, R.color.CAM_X0105);
        this.mgK.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        if (this.kSr != null && this.kSr.bBh() != null) {
            this.kSr.bBh().onChangeSkinType(i);
        }
        this.mgO.changeSkin(i);
        this.alb.buo();
        ap.setViewTextColor(this.jBu, R.color.CAM_X0110);
        ap.setViewTextColor(this.mcm, R.color.CAM_X0302);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0108);
        this.jBu.setAlpha(0.95f);
        if (this.mgP != null) {
            com.baidu.tbadk.r.a.a(this.mgB.getPageContext(), this.mgP);
        }
        if (this.mhf != null) {
            this.mhf.notifyDataSetChanged();
        }
        this.mgB.getLayoutMode().onModeChanged(this.mgR);
        ap.setBackgroundColor(this.lZu, R.color.CAM_X0203);
        this.lZx.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lZw.setBackgroundDrawable(ap.aL(l.getDimens(this.mgB, R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
    }

    public void dsH() {
        this.mProgress.setVisibility(0);
    }

    public void dsI() {
        this.gzb.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mgO.endLoadData();
    }

    public void czr() {
        this.gzb.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.mgO.czr();
    }

    public boolean dsJ() {
        return this.mgz.dsJ();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mhf.c(onLongClickListener);
    }

    public View dsK() {
        return this.mgA;
    }

    public TextView cIy() {
        return this.jBu;
    }

    public ImageView dsL() {
        return this.mhb;
    }

    public ImageView dsM() {
        return this.mhc;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Gp(int i) {
    }

    public View dsN() {
        return this.mgD;
    }

    public View dsO() {
        return this.mgL;
    }

    public MorePopupWindow dsP() {
        return this.mgQ;
    }

    public void showLoadingDialog() {
        if (this.iDG == null) {
            this.iDG = new com.baidu.tbadk.core.view.a(this.mgB.getPageContext());
        }
        this.iDG.setDialogVisiable(true);
    }

    public void ckq() {
        if (this.iDG != null) {
            this.iDG.setDialogVisiable(false);
        }
    }

    public TextView dsQ() {
        return this.mgK;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.mhf.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.mhf != null) {
            this.mhf.notifyDataSetChanged();
        }
    }

    public aa dsR() {
        return this.mfY;
    }

    public void cKR() {
    }

    public void cKS() {
    }

    public void cIZ() {
        if (this.mgz != null) {
            this.mgz.onDestroy();
        }
        if (this.kSr != null) {
            this.kSr.onDestory();
        }
    }

    public void dsS() {
        if (this.mgB.isPaused()) {
        }
    }

    public View dsT() {
        return this.mgE;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.mgB.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dsU() {
        if (this.kSr == null || this.kSr.bBh() == null) {
            return 0;
        }
        return this.kSr.bBh().getHeight();
    }

    public int dsV() {
        if (this.mgU == null) {
            return 0;
        }
        return this.mgU.getHeight();
    }

    public void dsW() {
        if (this.jBu != null && this.kSr != null) {
            if (this.kSr.bCv()) {
                this.jBu.setText(R.string.draft_to_send);
            } else {
                this.jBu.setText(this.mgB.dqn());
            }
        }
    }

    public void vp(boolean z) {
        if (this.lZx != null) {
            this.lZx.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fjz = cVar;
        if (this.lZa != null) {
            this.lZa.setListPullRefreshListener(cVar);
        }
    }
}
