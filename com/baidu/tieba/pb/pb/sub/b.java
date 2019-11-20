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
    private static final int iaJ = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener ZF;
    private BdTypeListView duK;
    private com.baidu.tbadk.core.view.b eVG;
    private RelativeLayout ebP;
    private TextView fKk;
    private com.baidu.tieba.NEGFeedBack.e fWw;
    private View fkk;
    private NoNetworkView fqt;
    private k hZm;
    private a iaB;
    private View iaK;
    private NewSubPbActivity iaL;
    private RelativeLayout iaM;
    private View iaQ;
    private ThreadSkinView iaX;
    private e iaY;
    private View iaZ;
    private SubPbModel ian;
    private y iaq;
    private View ibb;
    private View ibe;
    private com.baidu.tbadk.core.dialog.b ibg;
    private ArrayList<PostData> ibk;
    private String ibl;
    private RelativeLayout ibm;
    private ImageView ibn;
    private ImageView ibo;
    private d ibs;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bUp = null;
    private TbRichTextView.i ias = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView iaN = null;
    private LinearLayout iaO = null;
    private HeadImageView iaP = null;
    private ClickableHeaderImageView hUH = null;
    private TextView crw = null;
    private ImageView iaR = null;
    private TextView hUz = null;
    private TextView iaS = null;
    private TextView iaT = null;
    private EllipsizeRichTextView iaU = null;
    private TbImageView iaV = null;
    private PlayVoiceBntNew HH = null;
    private TextView iaW = null;
    private MorePopupWindow iba = null;
    private am ibc = null;
    private com.baidu.tbadk.core.dialog.b ibd = null;
    private Dialog ibf = null;
    private com.baidu.tbadk.core.dialog.a hVh = null;
    private boolean hNy = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener mLongClickListener = null;
    private NewSubPbActivity.a ibh = null;
    private NewSubPbActivity.a ibi = null;
    private g gWc = null;
    private String ibj = null;
    private int cVz = 0;
    private PostData hJa = null;
    private int ibp = 0;
    private int ibq = 2;
    private int ibr = 0;
    private boolean cEK = true;
    private View.OnClickListener hNH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.iaL.b(sparseArray);
                        return;
                    }
                    b.this.cA(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.iaL.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cyE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
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
    protected AdapterView.OnItemLongClickListener ibt = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(b.this.ibk, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.iaq == null) {
                b.this.iaq = new y(b.this.iaL.getPageContext(), b.this.ZF);
            }
            b.this.iaq.showDialog();
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
            b.this.iaq.a(sparseArray, b.this.ian.bQJ(), oa);
            if (oa) {
                b.this.iaq.bUr().setVisibility(0);
                b.this.iaq.bUr().setTag(postData.getId());
            } else {
                b.this.iaq.bUr().setVisibility(8);
            }
            b.this.iaq.bUp().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener ibu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.checkUpIsLogin(b.this.iaL.getPageContext().getPageActivity())) {
                if (b.this.iaL.gVU == null || b.this.ian == null || b.this.ian.biX() == null || b.this.iaL.gVU.ip(b.this.ian.biX().replyPrivateFlag)) {
                    if (b.this.iaB != null) {
                        b.this.iaB.bnY();
                    }
                    b.this.bWX();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.getItem(b.this.ibk, i);
                        if (postData == null) {
                            b.this.ibl = null;
                        } else {
                            b.this.ibl = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gWc.setReplyId(str2);
                                b.this.gWc.pR(str);
                            }
                        }
                        b.this.bWY();
                        return;
                    }
                    b.this.bWZ();
                    b.this.ian.bXv();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ebP = null;
        this.iaK = null;
        this.duK = null;
        this.iaL = null;
        this.fqt = null;
        this.iaM = null;
        this.iaQ = null;
        this.iaY = null;
        this.ibe = null;
        this.ZF = null;
        this.mProgress = null;
        this.fKk = null;
        this.ibm = null;
        this.ibn = null;
        this.ibo = null;
        this.iaL = newSubPbActivity;
        this.ZF = onClickListener;
        this.ebP = (RelativeLayout) LayoutInflater.from(this.iaL.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iaK = LayoutInflater.from(this.iaL.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.ibm = (RelativeLayout) this.ebP.findViewById(R.id.subpb_editor_tool_comment);
        this.fKk = (TextView) this.ebP.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fKk.setOnClickListener(this.ZF);
        this.ibn = (ImageView) this.ebP.findViewById(R.id.subpb_editor_tool_more_img);
        this.ibo = (ImageView) this.ebP.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.ibo.setOnClickListener(this.ZF);
        this.ibn.setOnClickListener(this.ZF);
        this.fqt = (NoNetworkView) this.ebP.findViewById(R.id.view_no_network);
        bog();
        bWW();
        this.iaM = (RelativeLayout) this.ebP.findViewById(R.id.sub_pb_body_layout);
        this.duK = (BdTypeListView) this.ebP.findViewById(R.id.new_sub_pb_list);
        this.iaX = (ThreadSkinView) LayoutInflater.from(this.iaL.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.duK.addHeaderView(this.iaX);
        this.duK.addHeaderView(this.iaK);
        this.fkk = BdListViewHelper.a(this.iaL.getActivity(), this.duK, BdListViewHelper.HeadType.DEFAULT);
        this.iaY = new e(this.iaL.getPageContext());
        this.iaY.setLineGone();
        this.ibe = this.iaY.getView();
        this.duK.setNextPage(this.iaY);
        this.iaY.setOnClickListener(this.ZF);
        this.duK.setOnItemClickListener(this.ibu);
        this.duK.setOnItemLongClickListener(this.ibt);
        this.duK.setOnTouchListener(this.cyE);
        this.mProgress = (ProgressBar) this.ebP.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iaK != null) {
            this.iaK.setVisibility(4);
        }
        if (this.iaM != null) {
            this.iaM.setVisibility(4);
        }
        this.iaQ = com.baidu.tbadk.ala.b.afa().l(this.iaL.getActivity(), 4);
        if (this.iaQ != null) {
            this.iaQ.setVisibility(8);
            this.iaO.addView(this.iaQ, 3);
        }
        this.ibs = new d(this.iaL, this.duK);
        this.ibs.setFromCDN(this.mIsFromCDN);
        this.ibs.w(this.ZF);
        this.ibs.sY();
    }

    public ListView getListView() {
        return this.duK;
    }

    public void bWW() {
        this.iaO = (LinearLayout) this.iaK.findViewById(R.id.subpb_head_user_info_root);
        this.iaO.setOnClickListener(this.ZF);
        this.iaP = (HeadImageView) this.iaK.findViewById(R.id.photo);
        this.iaP.setRadius(l.getDimens(this.iaL.getActivity(), R.dimen.ds30));
        this.iaP.setClickable(false);
        this.hUH = (ClickableHeaderImageView) this.iaK.findViewById(R.id.god_user_photo);
        this.hUH.setGodIconMargin(0);
        this.hUH.setGodIconWidth(R.dimen.ds24);
        this.hUH.setRadius(l.getDimens(this.iaL.getActivity(), R.dimen.ds30));
        this.hUH.setClickable(false);
        this.crw = (TextView) this.iaK.findViewById(R.id.user_name);
        this.iaR = (ImageView) this.iaK.findViewById(R.id.user_rank);
        this.iaR.setVisibility(8);
        this.hUz = (TextView) this.iaK.findViewById(R.id.floor_owner);
        this.iaN = (TextView) this.iaK.findViewById(R.id.see_subject);
        this.iaN.setOnClickListener(this.ZF);
        this.iaS = (TextView) this.iaK.findViewById(R.id.floor);
        this.iaT = (TextView) this.iaK.findViewById(R.id.time);
        this.iaU = (EllipsizeRichTextView) this.iaK.findViewById(R.id.content_text);
        this.iaU.setOnClickListener(this.ZF);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iaU, (int) R.color.cp_cont_b);
        this.iaU.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        this.iaU.setLineSpacing(0.0f, 1.25f);
        this.iaV = (TbImageView) this.iaK.findViewById(R.id.sub_pb_image);
        this.iaV.setOnClickListener(this.ZF);
        this.iaW = (TextView) this.iaK.findViewById(R.id.advert);
        this.HH = (PlayVoiceBntNew) this.iaK.findViewById(R.id.voice_btn);
        this.iaK.setOnTouchListener(this.cyE);
        this.iaK.setOnClickListener(this.ZF);
    }

    public void kt(boolean z) {
        if (this.fkk != null && this.fkk.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fkk.getLayoutParams();
            if (z) {
                bok();
                layoutParams.height = l.getDimens(this.iaL.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.getDimens(this.iaL.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.fkk.setLayoutParams(layoutParams);
        }
    }

    private void bok() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(b.a aVar, boolean z) {
        if (this.ibg != null) {
            this.ibg.dismiss();
            this.ibg = null;
        }
        this.ibg = new com.baidu.tbadk.core.dialog.b(this.iaL.getPageContext().getPageActivity());
        if (z) {
            this.ibg.a(new String[]{this.iaL.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.ibg.a(new String[]{this.iaL.getPageContext().getString(R.string.save_to_emotion), this.iaL.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.ibg.d(this.iaL.getPageContext());
        this.ibg.akN();
    }

    public void cF(View view) {
        this.iaZ = view;
    }

    public View beB() {
        return this.fkk;
    }

    public void bog() {
        int dimens = l.getDimens(this.iaL.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.iaL.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.ebP.findViewById(R.id.view_navigation_bar);
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
            SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.mNavigationBar.hideBottomLine();
    }

    public NavigationBar aKP() {
        return this.mNavigationBar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ibf == null) {
            this.ibf = new Dialog(this.iaL.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.ibf.setCanceledOnTouchOutside(true);
            this.ibf.setCancelable(true);
            this.ibb = LayoutInflater.from(this.iaL.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iaL.getLayoutMode().onModeChanged(this.ibb);
            this.ibf.setContentView(this.ibb);
            WindowManager.LayoutParams attributes = this.ibf.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.iaL.getPageContext().getPageActivity()) * 0.9d);
            this.ibf.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ibf.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.ibf.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.ibf.findViewById(R.id.disable_reply_btn);
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
                    if (b.this.ibf != null && (b.this.ibf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibf, b.this.iaL.getPageContext());
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
                    if (b.this.ibf != null && (b.this.ibf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibf, b.this.iaL.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.ibh != null) {
                        b.this.ibh.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (b.this.ibf != null && (b.this.ibf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibf, b.this.iaL.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.iaL.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ibf, this.iaL.getPageContext());
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
        this.hVh = new com.baidu.tbadk.core.dialog.a(this.iaL.getPageContext().getPageActivity());
        this.hVh.hT(i3);
        this.hVh.setYesButtonTag(sparseArray);
        this.hVh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.ibi != null) {
                    b.this.ibi.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hVh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hVh.eg(true);
        this.hVh.b(this.iaL.getPageContext());
        if (z) {
            this.hVh.akM();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData biX;
        if (this.iaL != null && sparseArray != null && this.iaK != null) {
            if (this.fWw == null) {
                this.fWw = new com.baidu.tieba.NEGFeedBack.e(this.iaL.getPageContext(), this.iaK);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.ian != null && (biX = this.ian.biX()) != null && biX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biX.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.setFeedBackReasonMap(sparseArray2);
            this.fWw.setDefaultReasonArray(new String[]{this.iaL.getString(R.string.delete_thread_reason_1), this.iaL.getString(R.string.delete_thread_reason_2), this.iaL.getString(R.string.delete_thread_reason_3), this.iaL.getString(R.string.delete_thread_reason_4), this.iaL.getString(R.string.delete_thread_reason_5)});
            this.fWw.setData(ajVar);
            this.fWw.qE("4");
            this.fWw.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void K(JSONArray jSONArray) {
                    String G = aq.G(jSONArray);
                    if (b.this.ibi != null) {
                        b.this.ibi.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), G});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(final boolean z) {
        if (this.duK != null) {
            if (!z) {
                this.duK.setEnabled(z);
            } else {
                this.duK.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.duK.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.ibh = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.ibi = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iaL.showToast(this.iaL.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iaL.showToast(str);
        }
    }

    public void bT(View view) {
        if (this.fkk != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fkk.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.duK != null) {
                    this.duK.removeHeaderView(this.fkk);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fkk.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iaL.getActivity(), R.dimen.ds98)));
            } else if (this.duK != null) {
                this.duK.addHeaderView(this.fkk, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.atX() != null) {
            this.gWc = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ebP.addView(gVar.atX(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.iaB = aVar;
    }

    public void bWX() {
        if (this.duK != null) {
            this.ibr = this.duK.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oa(boolean z) {
        if (this.ian == null || this.ian.bXs() == null) {
            return false;
        }
        if (this.ian.bQJ() != 0) {
            return false;
        }
        return (this.hZm == null || this.hZm.agG() == null || this.hZm.agG().aiE() == null || !TextUtils.equals(this.hZm.agG().aiE().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bWY() {
        if (this.ian != null) {
            if ((!bXb() && this.ibe != null && this.ibe.isShown()) || v.isEmpty(this.ibk)) {
                this.ian.pf(false);
            } else {
                this.ian.pf(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.ian = subPbModel;
    }

    public void bWZ() {
        b(this.iaL);
        this.duK.setNextPage(this.iaY);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.qP(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bXb() && this.ibe != null && this.ibe.isShown()) {
                i = (this.ibr - this.ibq) - 1;
            } else {
                i = this.ibr - this.ibq;
            }
            int count = v.getCount(this.ibk);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(v.subList(this.ibk, 0, i));
            v.add(arrayList, postData2);
            v.add(arrayList, postData);
            this.duK.smoothScrollToPosition(this.ibr + 2);
            this.duK.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.duK.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.duK.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ebP;
    }

    public void bVL() {
        if (this.iba != null) {
            com.baidu.adp.lib.g.g.dismissPopupWindow(this.iba, this.iaL.getPageContext().getPageActivity());
        }
        if (this.ibd != null) {
            this.ibd.dismiss();
        }
        if (this.hVh != null) {
            this.hVh.dismiss();
        }
        if (this.ibf != null) {
            com.baidu.adp.lib.g.g.b(this.ibf, this.iaL.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iaq != null) {
            this.iaq.dismiss();
        }
    }

    public void bXa() {
        this.duK.setNextPage(this.iaY);
        this.iaY.startLoadData();
    }

    public void nT(boolean z) {
        this.hNy = z;
    }

    public void setIsFromPb(boolean z) {
        this.cEK = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (kVar != null) {
            if (this.cEK && this.iaK != null) {
                this.iaK.setVisibility(8);
                this.duK.removeHeaderView(this.iaK);
                this.ibq = 1;
            }
            this.hZm = kVar;
            if (this.iaK != null) {
                this.iaK.setVisibility(0);
            }
            if (this.iaM != null) {
                this.iaM.setVisibility(0);
            }
            if (kVar.bRg() != null) {
                this.ibj = kVar.bRg().getId();
                this.cVz = kVar.bRg().con();
                if (this.cVz > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iaL.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cVz)));
                    if (this.iaL != null) {
                        this.fKk.setText(this.iaL.bVa());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.iaL.bWU() ? "PB" : null;
                if (kVar.bRg().aiZ() != null) {
                    this.iaX.setData(this.iaL.getPageContext(), kVar.bRg().aiZ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bRm().getId(), kVar.bRm().getName(), kVar.agG().getId(), str));
                } else {
                    this.iaX.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.iaY.startLoadData();
                this.ibs.setHasMoreData(true);
            } else {
                this.iaY.endLoadData();
                this.ibs.setHasMoreData(false);
            }
            this.ibk = kVar.bRk();
            if (this.ibk == null || this.ibk.size() <= iaJ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.ibk.size() - iaJ;
                wX(size);
                int firstVisiblePosition = this.duK.getFirstVisiblePosition() - size;
                View childAt = this.duK.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.ibk);
            if (v.isEmpty(this.ibk)) {
                this.duK.setNextPage(null);
                if (this.cEK) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.duK.setNextPage(this.iaY);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.cEK) {
                arrayList.add(0, kVar.bRg());
            }
            this.ibs.b(this.hZm.agG(), arrayList);
            a(kVar.bRg(), kVar.bDw(), kVar.afk(), i, z);
            if (i4 > 0) {
                this.duK.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void wX(int i) {
        if (this.ibk != null) {
            if (this.ibk.size() <= i) {
                this.ibk.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.ibk.iterator();
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

    public boolean bXb() {
        return this.ibs.Pz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.cEK) {
            this.hJa = postData;
            if (!StringUtils.isNull(postData.cou())) {
                this.iaV.setVisibility(0);
                this.iaV.startLoad(postData.cou(), 10, true);
            } else {
                this.iaV.setVisibility(8);
            }
            i cow = postData.cow();
            if (cow != null && cow.jhd) {
                this.iaW.setVisibility(0);
            } else {
                this.iaW.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iaK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iaK.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iaS.setText((CharSequence) null);
            this.crw.setText((CharSequence) null);
            this.hUz.setVisibility(8);
            if (!this.cEK) {
                c(postData.aiE());
                if (z) {
                    this.hUz.setVisibility(0);
                    com.baidu.tbadk.core.util.am.setViewTextColor(this.hUz, (int) R.color.cp_link_tip_a);
                }
            }
            this.iaT.setText(aq.getFormatTime(postData.getTime()));
            this.iaS.setText(String.format(this.iaL.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.con())));
            postData.aiE().getUserTbVipInfoData();
            boolean a = a(this.iaU, postData.cop());
            if (StringUtils.isNull(postData.cou()) && !a && postData.azp() != null) {
                this.HH.setVisibility(0);
                this.HH.setTag(postData.azp());
                return;
            }
            this.HH.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.byteLength(metaData.getSealPrefix()) + 2 : 0) + aa.getTextLength(name_show) > 14) {
                name_show = aa.subString(name_show, 0, 14) + StringHelper.STRING_MORE;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.crw.setText(bV(metaData.getSealPrefix(), name_show));
            } else {
                this.crw.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.iaQ != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iaQ.setVisibility(8);
                } else {
                    this.iaQ.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bTc = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iaQ.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hUH.setVisibility(0);
                this.iaP.setVisibility(8);
                this.hUH.setUserId(metaData.getUserId());
                this.hUH.setUserName(metaData.getUserName());
                this.hUH.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.crw, (int) R.color.cp_cont_r);
            } else {
                this.hUH.setVisibility(8);
                this.iaP.setVisibility(0);
                this.iaP.setUserId(metaData.getUserId());
                this.iaP.setUserName(metaData.getUserName());
                this.iaP.setDefaultResource(R.drawable.transparent_bg);
                this.iaP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iaP.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.crw, (int) R.color.cp_cont_c);
            }
            this.iaO.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iaO.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iaO.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.azf() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.azf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.i(next.azo());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fN(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cwN());
                        continue;
                    case 17:
                        String str = next.azs().mGifInfo.mSharpText;
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
        if (!tbRichTextData.azx()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.azo() == null || tbRichTextData.azo().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.azo());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iaL.getPageContext().getString(R.string.refresh_view_title_text), this.bUp));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iaL.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iaM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.getDimens(pageActivity, R.dimen.ds250), l.getDimens(pageActivity, R.dimen.ds480), l.getDimens(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.iaM.setVisibility(0);
        this.duK.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gWc.auT();
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iaL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ub(int i) {
        b(NoDataViewFactory.d.ai(i, R.string.refresh_view_title_text));
        if (this.iaB != null) {
            this.iaB.cD(this.ebP);
        }
        this.ibm.setVisibility(8);
    }

    public void us(String str) {
        b(NoDataViewFactory.d.bU(str, this.iaL.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.iaB != null) {
            this.iaB.cD(this.ebP);
        }
        this.ibm.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.duK.setVisibility(0);
            this.ibm.setVisibility(0);
            this.ebP.setOnTouchListener(null);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        this.bUp = onClickListener;
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
                String userId2 = postData.aiE().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.hZm != null && this.hZm.agG() != null && this.hZm.agG().aiE() != null && postData.aiE() != null) {
                String userId3 = this.hZm.agG().aiE().getUserId();
                String userId4 = postData.aiE().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aiE().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.con() == 1) {
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
                        if (postData.aiE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aiE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiE().getPortrait());
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
                        if (postData.aiE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aiE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aiE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aiE().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aiE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aiE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aiE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aiE().getName_show());
                        }
                        if (this.hZm.agG() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hZm.agG().getId());
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
            userId = postData.aiE().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.con() == 1) {
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
        if (this.iaq != null && this.iaq.bUp() != null) {
            if (z) {
                this.iaq.bUp().setText(R.string.remove_mark);
            } else {
                this.iaq.bUp().setText(R.string.mark);
            }
        }
    }

    public View bXc() {
        return this.ibe;
    }

    public void onChangeSkinType(int i) {
        this.iaL.getLayoutMode().setNightMode(i == 1);
        this.iaL.getLayoutMode().onModeChanged(this.ebP);
        this.iaL.getLayoutMode().onModeChanged(this.iaK);
        this.mNavigationBar.onChangeSkinType(this.iaL.getPageContext(), i);
        if (this.iaN != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iaN, (int) R.color.goto_see_subject_color);
        }
        this.fqt.onChangeSkinType(this.iaL.getPageContext(), i);
        this.iaL.getLayoutMode().onModeChanged(this.ibe);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.iaU, (int) R.color.cp_cont_b);
        this.iaU.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        if (this.gWc != null && this.gWc.atX() != null) {
            this.gWc.atX().onChangeSkinType(i);
        }
        this.iaY.changeSkin(i);
        this.HH.bno();
        com.baidu.tbadk.core.util.am.setViewTextColor(this.fKk, (int) R.color.cp_cont_e);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hUz, (int) R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.crw, (int) R.color.cp_cont_c);
        this.fKk.setAlpha(0.95f);
        if (this.iaZ != null) {
            com.baidu.tbadk.s.a.a(this.iaL.getPageContext(), this.iaZ);
        }
        if (this.ibs != null) {
            this.ibs.notifyDataSetChanged();
        }
        this.iaL.getLayoutMode().onModeChanged(this.ibb);
    }

    public void bXd() {
        this.mProgress.setVisibility(0);
    }

    public void bXe() {
        this.duK.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iaY.endLoadData();
    }

    public void bhb() {
        this.duK.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iaY.bhb();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        this.ibs.c(onLongClickListener);
    }

    public View bXf() {
        return this.iaK;
    }

    public TextView bol() {
        return this.fKk;
    }

    public ImageView bXg() {
        return this.ibn;
    }

    public ImageView bXh() {
        return this.ibo;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void wY(int i) {
    }

    public View bXi() {
        return this.iaN;
    }

    public View bXj() {
        return this.iaV;
    }

    public MorePopupWindow bXk() {
        return this.iba;
    }

    public void showLoadingDialog() {
        if (this.eVG == null) {
            this.eVG = new com.baidu.tbadk.core.view.b(this.iaL.getPageContext());
        }
        this.eVG.setDialogVisiable(true);
    }

    public void aVU() {
        if (this.eVG != null) {
            this.eVG.setDialogVisiable(false);
        }
    }

    public TextView bXl() {
        return this.iaU;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.ias = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ibs.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.ibs != null) {
            this.ibs.notifyDataSetChanged();
        }
    }

    public y bXm() {
        return this.iaq;
    }

    public void bqn() {
    }

    public void bqo() {
    }

    public void aGF() {
    }

    public void bXn() {
        if (this.iaL.isPaused()) {
        }
    }

    public View bXo() {
        return this.iaO;
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.iaL.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bXp() {
        if (this.gWc == null || this.gWc.atX() == null) {
            return 0;
        }
        return this.gWc.atX().getHeight();
    }
}
