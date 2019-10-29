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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b implements KeyboardEventLayout.a {
    private static final int ibA = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener ZX;
    private BdTypeListView dvB;
    private com.baidu.tbadk.core.view.b eWx;
    private RelativeLayout ecG;
    private TextView fLb;
    private com.baidu.tieba.NEGFeedBack.e fXn;
    private View flb;
    private NoNetworkView frk;
    private k iad;
    private View ibB;
    private NewSubPbActivity ibC;
    private RelativeLayout ibD;
    private View ibH;
    private ThreadSkinView ibO;
    private e ibP;
    private View ibQ;
    private View ibS;
    private View ibV;
    private com.baidu.tbadk.core.dialog.b ibX;
    private SubPbModel ibe;
    private y ibh;
    private a ibs;
    private ArrayList<PostData> icb;
    private String icc;
    private RelativeLayout icd;
    private ImageView ice;
    private ImageView icf;
    private d icj;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bVg = null;
    private TbRichTextView.i ibj = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ibE = null;
    private LinearLayout ibF = null;
    private HeadImageView ibG = null;
    private ClickableHeaderImageView hVy = null;
    private TextView csn = null;
    private ImageView ibI = null;
    private TextView hVq = null;
    private TextView ibJ = null;
    private TextView ibK = null;
    private EllipsizeRichTextView ibL = null;
    private TbImageView ibM = null;
    private PlayVoiceBntNew Ii = null;
    private TextView ibN = null;
    private MorePopupWindow ibR = null;
    private am ibT = null;
    private com.baidu.tbadk.core.dialog.b ibU = null;
    private Dialog ibW = null;
    private com.baidu.tbadk.core.dialog.a hVY = null;
    private boolean hOp = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener mLongClickListener = null;
    private NewSubPbActivity.a ibY = null;
    private NewSubPbActivity.a ibZ = null;
    private g gWT = null;
    private String ica = null;
    private int cWq = 0;
    private PostData hJR = null;
    private int icg = 0;
    private int ich = 2;
    private int ici = 0;
    private boolean cFB = true;
    private View.OnClickListener hOy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        b.this.ibC.b(sparseArray);
                        return;
                    }
                    b.this.cA(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.ibC.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c czv = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            b.this.kr(false);
            b.this.bT(view);
            b.this.kr(true);
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
    protected AdapterView.OnItemLongClickListener ick = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(b.this.icb, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.ibh == null) {
                b.this.ibh = new y(b.this.ibC.getPageContext(), b.this.ZX);
            }
            b.this.ibh.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean oa = b.this.oa(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.ibh.a(sparseArray, b.this.ibe.bQL(), oa);
            if (oa) {
                b.this.ibh.bUt().setVisibility(0);
                b.this.ibh.bUt().setTag(postData.getId());
            } else {
                b.this.ibh.bUt().setVisibility(8);
            }
            b.this.ibh.bUr().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener icl = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.checkUpIsLogin(b.this.ibC.getPageContext().getPageActivity())) {
                if (b.this.ibC.gWL == null || b.this.ibe == null || b.this.ibe.biZ() == null || b.this.ibC.gWL.iq(b.this.ibe.biZ().replyPrivateFlag)) {
                    if (b.this.ibs != null) {
                        b.this.ibs.boa();
                    }
                    b.this.bWZ();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.getItem(b.this.icb, i);
                        if (postData == null) {
                            b.this.icc = null;
                        } else {
                            b.this.icc = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gWT.setReplyId(str2);
                                b.this.gWT.pR(str);
                            }
                        }
                        b.this.bXa();
                        return;
                    }
                    b.this.bXb();
                    b.this.ibe.bXx();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ecG = null;
        this.ibB = null;
        this.dvB = null;
        this.ibC = null;
        this.frk = null;
        this.ibD = null;
        this.ibH = null;
        this.ibP = null;
        this.ibV = null;
        this.ZX = null;
        this.mProgress = null;
        this.fLb = null;
        this.icd = null;
        this.ice = null;
        this.icf = null;
        this.ibC = newSubPbActivity;
        this.ZX = onClickListener;
        this.ecG = (RelativeLayout) LayoutInflater.from(this.ibC.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.ibB = LayoutInflater.from(this.ibC.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.icd = (RelativeLayout) this.ecG.findViewById(R.id.subpb_editor_tool_comment);
        this.fLb = (TextView) this.ecG.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fLb.setOnClickListener(this.ZX);
        this.ice = (ImageView) this.ecG.findViewById(R.id.subpb_editor_tool_more_img);
        this.icf = (ImageView) this.ecG.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.icf.setOnClickListener(this.ZX);
        this.ice.setOnClickListener(this.ZX);
        this.frk = (NoNetworkView) this.ecG.findViewById(R.id.view_no_network);
        boi();
        bWY();
        this.ibD = (RelativeLayout) this.ecG.findViewById(R.id.sub_pb_body_layout);
        this.dvB = (BdTypeListView) this.ecG.findViewById(R.id.new_sub_pb_list);
        this.ibO = (ThreadSkinView) LayoutInflater.from(this.ibC.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.dvB.addHeaderView(this.ibO);
        this.dvB.addHeaderView(this.ibB);
        this.flb = BdListViewHelper.a(this.ibC.getActivity(), this.dvB, BdListViewHelper.HeadType.DEFAULT);
        this.ibP = new e(this.ibC.getPageContext());
        this.ibP.setLineGone();
        this.ibV = this.ibP.getView();
        this.dvB.setNextPage(this.ibP);
        this.ibP.setOnClickListener(this.ZX);
        this.dvB.setOnItemClickListener(this.icl);
        this.dvB.setOnItemLongClickListener(this.ick);
        this.dvB.setOnTouchListener(this.czv);
        this.mProgress = (ProgressBar) this.ecG.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ibB != null) {
            this.ibB.setVisibility(4);
        }
        if (this.ibD != null) {
            this.ibD.setVisibility(4);
        }
        this.ibH = com.baidu.tbadk.ala.b.afc().l(this.ibC.getActivity(), 4);
        if (this.ibH != null) {
            this.ibH.setVisibility(8);
            this.ibF.addView(this.ibH, 3);
        }
        this.icj = new d(this.ibC, this.dvB);
        this.icj.setFromCDN(this.mIsFromCDN);
        this.icj.w(this.ZX);
        this.icj.sX();
    }

    public ListView getListView() {
        return this.dvB;
    }

    public void bWY() {
        this.ibF = (LinearLayout) this.ibB.findViewById(R.id.subpb_head_user_info_root);
        this.ibF.setOnClickListener(this.ZX);
        this.ibG = (HeadImageView) this.ibB.findViewById(R.id.photo);
        this.ibG.setRadius(l.getDimens(this.ibC.getActivity(), R.dimen.ds30));
        this.ibG.setClickable(false);
        this.hVy = (ClickableHeaderImageView) this.ibB.findViewById(R.id.god_user_photo);
        this.hVy.setGodIconMargin(0);
        this.hVy.setGodIconWidth(R.dimen.ds24);
        this.hVy.setRadius(l.getDimens(this.ibC.getActivity(), R.dimen.ds30));
        this.hVy.setClickable(false);
        this.csn = (TextView) this.ibB.findViewById(R.id.user_name);
        this.ibI = (ImageView) this.ibB.findViewById(R.id.user_rank);
        this.ibI.setVisibility(8);
        this.hVq = (TextView) this.ibB.findViewById(R.id.floor_owner);
        this.ibE = (TextView) this.ibB.findViewById(R.id.see_subject);
        this.ibE.setOnClickListener(this.ZX);
        this.ibJ = (TextView) this.ibB.findViewById(R.id.floor);
        this.ibK = (TextView) this.ibB.findViewById(R.id.time);
        this.ibL = (EllipsizeRichTextView) this.ibB.findViewById(R.id.content_text);
        this.ibL.setOnClickListener(this.ZX);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.ibL, (int) R.color.cp_cont_b);
        this.ibL.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        this.ibL.setLineSpacing(0.0f, 1.25f);
        this.ibM = (TbImageView) this.ibB.findViewById(R.id.sub_pb_image);
        this.ibM.setOnClickListener(this.ZX);
        this.ibN = (TextView) this.ibB.findViewById(R.id.advert);
        this.Ii = (PlayVoiceBntNew) this.ibB.findViewById(R.id.voice_btn);
        this.ibB.setOnTouchListener(this.czv);
        this.ibB.setOnClickListener(this.ZX);
    }

    public void kt(boolean z) {
        if (this.flb != null && this.flb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.flb.getLayoutParams();
            if (z) {
                bom();
                layoutParams.height = l.getDimens(this.ibC.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.getDimens(this.ibC.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.flb.setLayoutParams(layoutParams);
        }
    }

    private void bom() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(b.a aVar, boolean z) {
        if (this.ibX != null) {
            this.ibX.dismiss();
            this.ibX = null;
        }
        this.ibX = new com.baidu.tbadk.core.dialog.b(this.ibC.getPageContext().getPageActivity());
        if (z) {
            this.ibX.a(new String[]{this.ibC.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.ibX.a(new String[]{this.ibC.getPageContext().getString(R.string.save_to_emotion), this.ibC.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.ibX.d(this.ibC.getPageContext());
        this.ibX.akP();
    }

    public void cF(View view) {
        this.ibQ = view;
    }

    public View beD() {
        return this.flb;
    }

    public void boi() {
        int dimens = l.getDimens(this.ibC.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.ibC.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.ecG.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
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
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mNavigationBar.hideBottomLine();
    }

    public NavigationBar aKR() {
        return this.mNavigationBar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ibW == null) {
            this.ibW = new Dialog(this.ibC.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.ibW.setCanceledOnTouchOutside(true);
            this.ibW.setCancelable(true);
            this.ibS = LayoutInflater.from(this.ibC.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.ibC.getLayoutMode().onModeChanged(this.ibS);
            this.ibW.setContentView(this.ibS);
            WindowManager.LayoutParams attributes = this.ibW.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.ibC.getPageContext().getPageActivity()) * 0.9d);
            this.ibW.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ibW.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.ibW.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.ibW.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ibW != null && (b.this.ibW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibW, b.this.ibC.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ibW != null && (b.this.ibW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibW, b.this.ibC.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.ibY != null) {
                        b.this.ibY.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ibW != null && (b.this.ibW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibW, b.this.ibC.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.ibC.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ibW, this.ibC.getPageContext());
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
        this.hVY = new com.baidu.tbadk.core.dialog.a(this.ibC.getPageContext().getPageActivity());
        this.hVY.hU(i3);
        this.hVY.setYesButtonTag(sparseArray);
        this.hVY.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.ibZ != null) {
                    b.this.ibZ.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hVY.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hVY.eg(true);
        this.hVY.b(this.ibC.getPageContext());
        if (z) {
            this.hVY.akO();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData biZ;
        if (this.ibC != null && sparseArray != null && this.ibB != null) {
            if (this.fXn == null) {
                this.fXn = new com.baidu.tieba.NEGFeedBack.e(this.ibC.getPageContext(), this.ibB);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.ibe != null && (biZ = this.ibe.biZ()) != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.setFeedBackReasonMap(sparseArray2);
            this.fXn.setDefaultReasonArray(new String[]{this.ibC.getString(R.string.delete_thread_reason_1), this.ibC.getString(R.string.delete_thread_reason_2), this.ibC.getString(R.string.delete_thread_reason_3), this.ibC.getString(R.string.delete_thread_reason_4), this.ibC.getString(R.string.delete_thread_reason_5)});
            this.fXn.setData(ajVar);
            this.fXn.qE("4");
            this.fXn.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void K(JSONArray jSONArray) {
                    String G = aq.G(jSONArray);
                    if (b.this.ibZ != null) {
                        b.this.ibZ.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), G});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(final boolean z) {
        if (this.dvB != null) {
            if (!z) {
                this.dvB.setEnabled(z);
            } else {
                this.dvB.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.dvB.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.ibY = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.ibZ = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.ibC.showToast(this.ibC.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.ibC.showToast(str);
        }
    }

    public void bT(View view) {
        if (this.flb != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.flb.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.dvB != null) {
                    this.dvB.removeHeaderView(this.flb);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.flb.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ibC.getActivity(), R.dimen.ds98)));
            } else if (this.dvB != null) {
                this.dvB.addHeaderView(this.flb, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.atZ() != null) {
            this.gWT = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ecG.addView(gVar.atZ(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.ibs = aVar;
    }

    public void bWZ() {
        if (this.dvB != null) {
            this.ici = this.dvB.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oa(boolean z) {
        if (this.ibe == null || this.ibe.bXu() == null) {
            return false;
        }
        if (this.ibe.bQL() != 0) {
            return false;
        }
        return (this.iad == null || this.iad.agI() == null || this.iad.agI().aiG() == null || !TextUtils.equals(this.iad.agI().aiG().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bXa() {
        if (this.ibe != null) {
            if ((!bXd() && this.ibV != null && this.ibV.isShown()) || v.isEmpty(this.icb)) {
                this.ibe.pf(false);
            } else {
                this.ibe.pf(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.ibe = subPbModel;
    }

    public void bXb() {
        b(this.ibC);
        this.dvB.setNextPage(this.ibP);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.qP(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bXd() && this.ibV != null && this.ibV.isShown()) {
                i = (this.ici - this.ich) - 1;
            } else {
                i = this.ici - this.ich;
            }
            int count = v.getCount(this.icb);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(v.subList(this.icb, 0, i));
            v.add(arrayList, postData2);
            v.add(arrayList, postData);
            this.dvB.smoothScrollToPosition(this.ici + 2);
            this.dvB.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.dvB.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.dvB.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ecG;
    }

    public void bVN() {
        if (this.ibR != null) {
            com.baidu.adp.lib.g.g.dismissPopupWindow(this.ibR, this.ibC.getPageContext().getPageActivity());
        }
        if (this.ibU != null) {
            this.ibU.dismiss();
        }
        if (this.hVY != null) {
            this.hVY.dismiss();
        }
        if (this.ibW != null) {
            com.baidu.adp.lib.g.g.b(this.ibW, this.ibC.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.ibh != null) {
            this.ibh.dismiss();
        }
    }

    public void bXc() {
        this.dvB.setNextPage(this.ibP);
        this.ibP.startLoadData();
    }

    public void nT(boolean z) {
        this.hOp = z;
    }

    public void setIsFromPb(boolean z) {
        this.cFB = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (kVar != null) {
            if (this.cFB && this.ibB != null) {
                this.ibB.setVisibility(8);
                this.dvB.removeHeaderView(this.ibB);
                this.ich = 1;
            }
            this.iad = kVar;
            if (this.ibB != null) {
                this.ibB.setVisibility(0);
            }
            if (this.ibD != null) {
                this.ibD.setVisibility(0);
            }
            if (kVar.bRi() != null) {
                this.ica = kVar.bRi().getId();
                this.cWq = kVar.bRi().cop();
                if (this.cWq > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.ibC.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cWq)));
                    if (this.ibC != null) {
                        this.fLb.setText(this.ibC.bVc());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.ibC.bWW() ? "PB" : null;
                if (kVar.bRi().ajb() != null) {
                    this.ibO.setData(this.ibC.getPageContext(), kVar.bRi().ajb(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bRo().getId(), kVar.bRo().getName(), kVar.agI().getId(), str));
                } else {
                    this.ibO.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.ibP.startLoadData();
                this.icj.setHasMoreData(true);
            } else {
                this.ibP.endLoadData();
                this.icj.setHasMoreData(false);
            }
            this.icb = kVar.bRm();
            if (this.icb == null || this.icb.size() <= ibA) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.icb.size() - ibA;
                wY(size);
                int firstVisiblePosition = this.dvB.getFirstVisiblePosition() - size;
                View childAt = this.dvB.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.icb);
            if (v.isEmpty(this.icb)) {
                this.dvB.setNextPage(null);
                if (this.cFB) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.dvB.setNextPage(this.ibP);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.cFB) {
                arrayList.add(0, kVar.bRi());
            }
            this.icj.b(this.iad.agI(), arrayList);
            a(kVar.bRi(), kVar.bDy(), kVar.afm(), i, z);
            if (i4 > 0) {
                this.dvB.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void wY(int i) {
        if (this.icb != null) {
            if (this.icb.size() <= i) {
                this.icb.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.icb.iterator();
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

    public boolean bXd() {
        return this.icj.Py();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.cFB) {
            this.hJR = postData;
            if (!StringUtils.isNull(postData.cow())) {
                this.ibM.setVisibility(0);
                this.ibM.startLoad(postData.cow(), 10, true);
            } else {
                this.ibM.setVisibility(8);
            }
            i coy = postData.coy();
            if (coy != null && coy.jhU) {
                this.ibN.setVisibility(0);
            } else {
                this.ibN.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.ibB.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.ibB.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.ibJ.setText((CharSequence) null);
            this.csn.setText((CharSequence) null);
            this.hVq.setVisibility(8);
            if (!this.cFB) {
                c(postData.aiG());
                if (z) {
                    this.hVq.setVisibility(0);
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.hVq, (int) R.color.cp_link_tip_a);
                }
            }
            this.ibK.setText(aq.getFormatTime(postData.getTime()));
            this.ibJ.setText(String.format(this.ibC.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cop())));
            postData.aiG().getUserTbVipInfoData();
            boolean a = a(this.ibL, postData.cor());
            if (StringUtils.isNull(postData.cow()) && !a && postData.azr() != null) {
                this.Ii.setVisibility(0);
                this.Ii.setTag(postData.azr());
                return;
            }
            this.Ii.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.byteLength(metaData.getSealPrefix()) + 2 : 0) + aa.getTextLength(name_show) > 14) {
                name_show = aa.subString(name_show, 0, 14) + StringHelper.STRING_MORE;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.csn.setText(bV(metaData.getSealPrefix(), name_show));
            } else {
                this.csn.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.ibH != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.ibH.setVisibility(8);
                } else {
                    this.ibH.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bTT = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.ibH.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hVy.setVisibility(0);
                this.ibG.setVisibility(8);
                this.hVy.setUserId(metaData.getUserId());
                this.hVy.setUserName(metaData.getUserName());
                this.hVy.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.csn, (int) R.color.cp_cont_r);
            } else {
                this.hVy.setVisibility(8);
                this.ibG.setVisibility(0);
                this.ibG.setUserId(metaData.getUserId());
                this.ibG.setUserName(metaData.getUserName());
                this.ibG.setDefaultResource(R.drawable.transparent_bg);
                this.ibG.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.ibG.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.csn, (int) R.color.cp_cont_c);
            }
            this.ibF.setTag(R.id.tag_user_id, metaData.getUserId());
            this.ibF.setTag(R.id.tag_user_name, metaData.getUserName());
            this.ibF.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.azh() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.azh().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.i(next.azq());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fN(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cwP());
                        continue;
                    case 17:
                        String str = next.azu().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.i("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.azz()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.azq() == null || tbRichTextData.azq().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.azq());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ibC.getPageContext().getString(R.string.refresh_view_title_text), this.bVg));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.ibC.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.ibD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.getDimens(pageActivity, R.dimen.ds250), l.getDimens(pageActivity, R.dimen.ds480), l.getDimens(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.ibD.setVisibility(0);
        this.dvB.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gWT.auV();
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.ibC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void uc(int i) {
        b(NoDataViewFactory.d.ak(i, R.string.refresh_view_title_text));
        if (this.ibs != null) {
            this.ibs.cD(this.ecG);
        }
        this.icd.setVisibility(8);
    }

    public void us(String str) {
        b(NoDataViewFactory.d.bU(str, this.ibC.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.ibs != null) {
            this.ibs.cD(this.ecG);
        }
        this.icd.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dvB.setVisibility(0);
            this.icd.setVisibility(0);
            this.ecG.setOnTouchListener(null);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.bVg = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            boolean z6 = false;
            boolean z7 = false;
            if (i != 0) {
                if (i != 3) {
                    z6 = true;
                    z7 = true;
                }
                String userId2 = postData.aiG().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.iad != null && this.iad.agI() != null && this.iad.agI().aiG() != null && postData.aiG() != null) {
                String userId3 = this.iad.agI().aiG().getUserId();
                String userId4 = postData.aiG().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aiG().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.cop() == 1) {
                        i2 = 0;
                    }
                    if (ap.m(postData)) {
                        z4 = z6;
                    } else {
                        z2 = false;
                        z = false;
                        z4 = false;
                    }
                    if (!z4) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aiG() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aiG().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiG().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiG().getPortrait());
                        }
                    } else {
                        z5 = false;
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                    }
                    if (!z2) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.aiG() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aiG().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiG().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiG().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aiG() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiG().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiG().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiG().getName_show());
                        }
                        if (this.iad.agI() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iad.agI().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z2) {
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
            z = false;
            z2 = z7;
            z3 = false;
            userId = postData.aiG().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.cop() == 1) {
            }
            if (ap.m(postData)) {
            }
            if (!z4) {
            }
            if (!z2) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z4) {
            }
            if (!z) {
            }
            if (!z2) {
            }
        }
    }

    public void pd(boolean z) {
        if (this.ibh != null && this.ibh.bUr() != null) {
            if (z) {
                this.ibh.bUr().setText(R.string.remove_mark);
            } else {
                this.ibh.bUr().setText(R.string.mark);
            }
        }
    }

    public View bXe() {
        return this.ibV;
    }

    public void onChangeSkinType(int i) {
        this.ibC.getLayoutMode().setNightMode(i == 1);
        this.ibC.getLayoutMode().onModeChanged(this.ecG);
        this.ibC.getLayoutMode().onModeChanged(this.ibB);
        this.mNavigationBar.onChangeSkinType(this.ibC.getPageContext(), i);
        if (this.ibE != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.ibE, (int) R.color.goto_see_subject_color);
        }
        this.frk.onChangeSkinType(this.ibC.getPageContext(), i);
        this.ibC.getLayoutMode().onModeChanged(this.ibV);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.ibL, (int) R.color.cp_cont_b);
        this.ibL.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        if (this.gWT != null && this.gWT.atZ() != null) {
            this.gWT.atZ().onChangeSkinType(i);
        }
        this.ibP.changeSkin(i);
        this.Ii.bnq();
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fLb, (int) R.color.cp_cont_e);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hVq, (int) R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.csn, (int) R.color.cp_cont_c);
        this.fLb.setAlpha(0.95f);
        if (this.ibQ != null) {
            com.baidu.tbadk.s.a.a(this.ibC.getPageContext(), this.ibQ);
        }
        if (this.icj != null) {
            this.icj.notifyDataSetChanged();
        }
        this.ibC.getLayoutMode().onModeChanged(this.ibS);
    }

    public void bXf() {
        this.mProgress.setVisibility(0);
    }

    public void bXg() {
        this.dvB.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ibP.endLoadData();
    }

    public void bhd() {
        this.dvB.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ibP.bhd();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        this.icj.c(onLongClickListener);
    }

    public View bXh() {
        return this.ibB;
    }

    public TextView bon() {
        return this.fLb;
    }

    public ImageView bXi() {
        return this.ice;
    }

    public ImageView bXj() {
        return this.icf;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void wZ(int i) {
    }

    public View bXk() {
        return this.ibE;
    }

    public View bXl() {
        return this.ibM;
    }

    public MorePopupWindow bXm() {
        return this.ibR;
    }

    public void showLoadingDialog() {
        if (this.eWx == null) {
            this.eWx = new com.baidu.tbadk.core.view.b(this.ibC.getPageContext());
        }
        this.eWx.setDialogVisiable(true);
    }

    public void aVW() {
        if (this.eWx != null) {
            this.eWx.setDialogVisiable(false);
        }
    }

    public TextView bXn() {
        return this.ibL;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.ibj = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.icj.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.icj != null) {
            this.icj.notifyDataSetChanged();
        }
    }

    public y bXo() {
        return this.ibh;
    }

    public void bqp() {
    }

    public void bqq() {
    }

    public void aGH() {
    }

    public void bXp() {
        if (this.ibC.isPaused()) {
        }
    }

    public View bXq() {
        return this.ibF;
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.ibC.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bXr() {
        if (this.gWT == null || this.gWT.atZ() == null) {
            return 0;
        }
        return this.gWT.atZ().getHeight();
    }
}
