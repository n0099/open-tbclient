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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
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
import com.baidu.tbadk.util.ab;
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
    private static final int hZX = TbadkCoreApplication.getInst().getListItemRule().amw();
    private RelativeLayout dMd;
    private com.baidu.tbadk.core.view.b eMs;
    private TextView fJe;
    private com.baidu.tieba.NEGFeedBack.e fVl;
    private View fga;
    private NoNetworkView fpM;
    private k hYD;
    private SubPbModel hZB;
    private y hZE;
    private a hZP;
    private View hZY;
    private NewSubPbActivity hZZ;
    private ImageView iaA;
    private ImageView iaB;
    private d iaF;
    private RelativeLayout iaa;
    private View iae;
    private ThreadSkinView ial;
    private e iam;
    private View ian;
    private View iar;
    private com.baidu.tbadk.core.dialog.b iat;
    private ArrayList<PostData> iax;
    private String iay;
    private RelativeLayout iaz;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bCn = null;
    private TbRichTextView.i hZG = null;
    private NavigationBar mNavigationBar = null;
    private View cfb = null;
    private TextView iab = null;
    private LinearLayout iac = null;
    private HeadImageView iad = null;
    private ClickableHeaderImageView hTX = null;
    private TextView ccZ = null;
    private ImageView iaf = null;
    private TextView hTP = null;
    private TextView iag = null;
    private TextView iah = null;
    private EllipsizeRichTextView iai = null;
    private TbImageView iaj = null;
    private PlayVoiceBntNew Ym = null;
    private TextView iak = null;
    private MorePopupWindow iao = null;
    private am iap = null;
    private com.baidu.tbadk.core.dialog.b iaq = null;
    private Dialog ias = null;
    private com.baidu.tbadk.core.dialog.a hUx = null;
    private boolean hMT = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener coR = null;
    private NewSubPbActivity.a iau = null;
    private NewSubPbActivity.a iav = null;
    private g gWg = null;
    private String iaw = null;
    private int cMb = 0;
    private PostData hIv = null;
    private int iaC = 0;
    private int iaD = 2;
    private int iaE = 0;
    private boolean csr = true;
    private View.OnClickListener hNc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hZZ.c(sparseArray);
                        return;
                    }
                    b.this.cD(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.hZZ.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c clt = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            b.this.kB(false);
            b.this.bV(view);
            b.this.kB(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener iaG = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.iax, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hZE == null) {
                b.this.hZE = new y(b.this.hZZ.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hZE.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean on = b.this.on(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.hZE.a(sparseArray, b.this.hZB.bSJ(), on);
            if (on) {
                b.this.hZE.bWo().setVisibility(0);
                b.this.hZE.bWo().setTag(postData.getId());
            } else {
                b.this.hZE.bWo().setVisibility(8);
            }
            b.this.hZE.bWm().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener iaH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bd.cF(b.this.hZZ.getPageContext().getPageActivity())) {
                if (b.this.hZZ.gVY == null || b.this.hZB == null || b.this.hZB.blb() == null || b.this.hZZ.gVY.m19if(b.this.hZB.blb().replyPrivateFlag)) {
                    if (b.this.hZP != null) {
                        b.this.hZP.bpX();
                    }
                    b.this.bYR();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.iax, i);
                        if (postData == null) {
                            b.this.iay = null;
                        } else {
                            b.this.iay = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gWg.setReplyId(str2);
                                b.this.gWg.qx(str);
                            }
                        }
                        b.this.bYS();
                        return;
                    }
                    b.this.bYT();
                    b.this.hZB.bZp();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dMd = null;
        this.hZY = null;
        this.mListView = null;
        this.hZZ = null;
        this.fpM = null;
        this.iaa = null;
        this.iae = null;
        this.iam = null;
        this.iar = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fJe = null;
        this.iaz = null;
        this.iaA = null;
        this.iaB = null;
        this.hZZ = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dMd = (RelativeLayout) LayoutInflater.from(this.hZZ.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.hZY = LayoutInflater.from(this.hZZ.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.iaz = (RelativeLayout) this.dMd.findViewById(R.id.subpb_editor_tool_comment);
        this.fJe = (TextView) this.dMd.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fJe.setOnClickListener(this.mCommonClickListener);
        this.iaA = (ImageView) this.dMd.findViewById(R.id.subpb_editor_tool_more_img);
        this.iaB = (ImageView) this.dMd.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iaB.setOnClickListener(this.mCommonClickListener);
        this.iaA.setOnClickListener(this.mCommonClickListener);
        this.fpM = (NoNetworkView) this.dMd.findViewById(R.id.view_no_network);
        bqf();
        bjQ();
        this.iaa = (RelativeLayout) this.dMd.findViewById(R.id.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dMd.findViewById(R.id.new_sub_pb_list);
        this.ial = (ThreadSkinView) LayoutInflater.from(this.hZZ.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.ial);
        this.mListView.addHeaderView(this.hZY);
        this.fga = BdListViewHelper.a(this.hZZ.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.iam = new e(this.hZZ.getPageContext());
        this.iam.akA();
        this.iar = this.iam.getView();
        this.mListView.setNextPage(this.iam);
        this.iam.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.iaH);
        this.mListView.setOnItemLongClickListener(this.iaG);
        this.mListView.setOnTouchListener(this.clt);
        this.mProgress = (ProgressBar) this.dMd.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hZY != null) {
            this.hZY.setVisibility(4);
        }
        if (this.iaa != null) {
            this.iaa.setVisibility(4);
        }
        this.iae = com.baidu.tbadk.ala.b.aak().n(this.hZZ.getActivity(), 4);
        if (this.iae != null) {
            this.iae.setVisibility(8);
            this.iac.addView(this.iae, 3);
        }
        this.iaF = new d(this.hZZ, this.mListView);
        this.iaF.setFromCDN(this.mIsFromCDN);
        this.iaF.v(this.mCommonClickListener);
        this.iaF.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bjQ() {
        this.iac = (LinearLayout) this.hZY.findViewById(R.id.subpb_head_user_info_root);
        this.iac.setOnClickListener(this.mCommonClickListener);
        this.iad = (HeadImageView) this.hZY.findViewById(R.id.photo);
        this.iad.setRadius(l.g(this.hZZ.getActivity(), R.dimen.ds30));
        this.iad.setClickable(false);
        this.hTX = (ClickableHeaderImageView) this.hZY.findViewById(R.id.god_user_photo);
        this.hTX.setGodIconMargin(0);
        this.hTX.setGodIconWidth(R.dimen.ds24);
        this.hTX.setRadius(l.g(this.hZZ.getActivity(), R.dimen.ds30));
        this.hTX.setClickable(false);
        this.ccZ = (TextView) this.hZY.findViewById(R.id.user_name);
        this.iaf = (ImageView) this.hZY.findViewById(R.id.user_rank);
        this.iaf.setVisibility(8);
        this.hTP = (TextView) this.hZY.findViewById(R.id.floor_owner);
        this.iab = (TextView) this.hZY.findViewById(R.id.see_subject);
        this.iab.setOnClickListener(this.mCommonClickListener);
        this.iag = (TextView) this.hZY.findViewById(R.id.floor);
        this.iah = (TextView) this.hZY.findViewById(R.id.time);
        this.iai = (EllipsizeRichTextView) this.hZY.findViewById(R.id.content_text);
        this.iai.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.am.j(this.iai, R.color.cp_cont_b);
        this.iai.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        this.iai.setLineSpacing(0.0f, 1.25f);
        this.iaj = (TbImageView) this.hZY.findViewById(R.id.sub_pb_image);
        this.iaj.setOnClickListener(this.mCommonClickListener);
        this.iak = (TextView) this.hZY.findViewById(R.id.advert);
        this.Ym = (PlayVoiceBntNew) this.hZY.findViewById(R.id.voice_btn);
        this.hZY.setOnTouchListener(this.clt);
        this.hZY.setOnClickListener(this.mCommonClickListener);
    }

    public void kD(boolean z) {
        if (this.fga != null && this.fga.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fga.getLayoutParams();
            if (z) {
                bqj();
                layoutParams.height = l.g(this.hZZ.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.g(this.hZZ.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.fga.setLayoutParams(layoutParams);
        }
    }

    private void bqj() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public void a(b.a aVar, boolean z) {
        if (this.iat != null) {
            this.iat.dismiss();
            this.iat = null;
        }
        this.iat = new com.baidu.tbadk.core.dialog.b(this.hZZ.getPageContext().getPageActivity());
        if (z) {
            this.iat.a(new String[]{this.hZZ.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.iat.a(new String[]{this.hZZ.getPageContext().getString(R.string.save_to_emotion), this.hZZ.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.iat.d(this.hZZ.getPageContext());
        this.iat.agL();
    }

    public void cH(View view) {
        this.ian = view;
    }

    public View bqk() {
        return this.fga;
    }

    public void bqf() {
        int g = l.g(this.hZZ.getPageContext().getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.hZZ.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.dMd.findViewById(R.id.view_navigation_bar);
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cfb.getLayoutParams();
            layoutParams.height = g;
            layoutParams.width = g;
            layoutParams.leftMargin = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cfb != null && (this.cfb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cfb.getLayoutParams();
            layoutParams2.width = g;
            layoutParams2.height = g;
            this.cfb.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_back, R.drawable.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aLh() {
        return this.mNavigationBar;
    }

    public void cD(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ias == null) {
            this.ias = new Dialog(this.hZZ.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.ias.setCanceledOnTouchOutside(true);
            this.ias.setCancelable(true);
            View inflate = LayoutInflater.from(this.hZZ.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.hZZ.getLayoutMode().onModeChanged(inflate);
            this.ias.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ias.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.hZZ.getPageContext().getPageActivity()) * 0.9d);
            this.ias.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ias.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.ias.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.ias.findViewById(R.id.disable_reply_btn);
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
                    if (b.this.ias != null && (b.this.ias instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ias, b.this.hZZ.getPageContext());
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
                    if (b.this.ias != null && (b.this.ias instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ias, b.this.hZZ.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.iau != null) {
                        b.this.iau.m(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (b.this.ias != null && (b.this.ias instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ias, b.this.hZZ.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hZZ.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ias, this.hZZ.getPageContext());
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
        this.hUx = new com.baidu.tbadk.core.dialog.a(this.hZZ.getPageContext().getPageActivity());
        this.hUx.hu(i3);
        this.hUx.ab(sparseArray);
        this.hUx.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.iav != null) {
                    b.this.iav.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hUx.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hUx.dQ(true);
        this.hUx.b(this.hZZ.getPageContext());
        if (z) {
            this.hUx.agI();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData blb;
        if (this.hZZ != null && sparseArray != null && this.hZY != null) {
            if (this.fVl == null) {
                this.fVl = new com.baidu.tieba.NEGFeedBack.e(this.hZZ.getPageContext(), this.hZY);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hZB != null && (blb = this.hZB.blb()) != null && blb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = blb.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fVl.setDefaultReasonArray(new String[]{this.hZZ.getString(R.string.delete_thread_reason_1), this.hZZ.getString(R.string.delete_thread_reason_2), this.hZZ.getString(R.string.delete_thread_reason_3), this.hZZ.getString(R.string.delete_thread_reason_4), this.hZZ.getString(R.string.delete_thread_reason_5)});
            this.fVl.setData(ajVar);
            this.fVl.rJ("4");
            this.fVl.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    String y = aq.y(jSONArray);
                    if (b.this.iav != null) {
                        b.this.iav.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), y});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(final boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mListView.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.iau = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.iav = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hZZ.showToast(this.hZZ.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.hZZ.showToast(str);
        }
    }

    public void bV(View view) {
        if (this.fga != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fga.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fga);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fga.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.hZZ.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fga, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.arY() != null) {
            this.gWg = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dMd.addView(gVar.arY(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hZP = aVar;
    }

    public void bYR() {
        if (this.mListView != null) {
            this.iaE = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean on(boolean z) {
        if (this.hZB == null || this.hZB.bZm() == null) {
            return false;
        }
        if (this.hZB.bSJ() != 0) {
            return false;
        }
        return (this.hYD == null || this.hYD.acx() == null || this.hYD.acx().aex() == null || !TextUtils.equals(this.hYD.acx().aex().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bYS() {
        if (this.hZB != null) {
            if ((!bYV() && this.iar != null && this.iar.isShown()) || v.aa(this.iax)) {
                this.hZB.ps(false);
            } else {
                this.hZB.ps(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hZB = subPbModel;
    }

    public void bYT() {
        b(this.hZZ);
        this.mListView.setNextPage(this.iam);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.rc(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bYV() && this.iar != null && this.iar.isShown()) {
                i = (this.iaE - this.iaD) - 1;
            } else {
                i = this.iaE - this.iaD;
            }
            int Z = v.Z(this.iax);
            if (i > Z) {
                i = Z;
            }
            ArrayList arrayList = new ArrayList(v.c(this.iax, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.iaE + 2);
            this.mListView.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.dMd;
    }

    public void bXH() {
        if (this.iao != null) {
            com.baidu.adp.lib.g.g.a(this.iao, this.hZZ.getPageContext().getPageActivity());
        }
        if (this.iaq != null) {
            this.iaq.dismiss();
        }
        if (this.hUx != null) {
            this.hUx.dismiss();
        }
        if (this.ias != null) {
            com.baidu.adp.lib.g.g.b(this.ias, this.hZZ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hZE != null) {
            this.hZE.dismiss();
        }
    }

    public void bYU() {
        this.mListView.setNextPage(this.iam);
        this.iam.akD();
    }

    public void og(boolean z) {
        this.hMT = z;
    }

    public void setIsFromPb(boolean z) {
        this.csr = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (kVar != null) {
            if (this.csr && this.hZY != null) {
                this.hZY.setVisibility(8);
                this.mListView.removeHeaderView(this.hZY);
                this.iaD = 1;
            }
            this.hYD = kVar;
            if (this.hZY != null) {
                this.hZY.setVisibility(0);
            }
            if (this.iaa != null) {
                this.iaa.setVisibility(0);
            }
            if (kVar.bTg() != null) {
                this.iaw = kVar.bTg().getId();
                this.cMb = kVar.bTg().cpp();
                if (this.cMb > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hZZ.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cMb)));
                    if (this.hZZ != null) {
                        this.fJe.setText(this.hZZ.bWW());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hZZ.bYP() ? "PB" : null;
                if (kVar.bTg().aeS() != null) {
                    this.ial.setData(this.hZZ.getPageContext(), kVar.bTg().aeS(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", kVar.bTm().getId(), kVar.bTm().getName(), kVar.acx().getId(), str));
                } else {
                    this.ial.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.iam.akD();
                this.iaF.setHasMoreData(true);
            } else {
                this.iam.akE();
                this.iaF.setHasMoreData(false);
            }
            this.iax = kVar.bTk();
            if (this.iax == null || this.iax.size() <= hZX) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.iax.size() - hZX;
                yn(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iax);
            if (v.aa(this.iax)) {
                this.mListView.setNextPage(null);
                if (this.csr) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.iam);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.csr) {
                arrayList.add(0, kVar.bTg());
            }
            this.iaF.b(this.hYD.acx(), arrayList);
            a(kVar.bTg(), kVar.bFL(), kVar.aaB(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void yn(int i) {
        if (this.iax != null) {
            if (this.iax.size() <= i) {
                this.iax.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.iax.iterator();
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

    public boolean bYV() {
        return this.iaF.KB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.csr) {
            this.hIv = postData;
            if (!StringUtils.isNull(postData.cpw())) {
                this.iaj.setVisibility(0);
                this.iaj.startLoad(postData.cpw(), 10, true);
            } else {
                this.iaj.setVisibility(8);
            }
            i cpy = postData.cpy();
            if (cpy != null && cpy.jeE) {
                this.iak.setVisibility(0);
            } else {
                this.iak.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hZY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hZY.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iag.setText((CharSequence) null);
            this.ccZ.setText((CharSequence) null);
            this.hTP.setVisibility(8);
            if (!this.csr) {
                c(postData.aex());
                if (z) {
                    this.hTP.setVisibility(0);
                    com.baidu.tbadk.core.util.am.j(this.hTP, R.color.cp_link_tip_a);
                }
            }
            this.iah.setText(aq.aD(postData.getTime()));
            this.iag.setText(String.format(this.hZZ.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cpp())));
            postData.aex().getUserTbVipInfoData();
            boolean a = a(this.iai, postData.cpr());
            if (StringUtils.isNull(postData.cpw()) && !a && postData.ayU() != null) {
                this.Ym.setVisibility(0);
                this.Ym.setTag(postData.ayU());
                return;
            }
            this.Ym.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bk(metaData.getSealPrefix()) + 2 : 0) + ab.rn(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.ccZ.setText(bY(metaData.getSealPrefix(), name_show));
            } else {
                this.ccZ.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.iae != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iae.setVisibility(8);
                } else {
                    this.iae.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bAN = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iae.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hTX.setVisibility(0);
                this.iad.setVisibility(8);
                this.hTX.setUserId(metaData.getUserId());
                this.hTX.setUserName(metaData.getUserName());
                this.hTX.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.j(this.ccZ, R.color.cp_cont_r);
            } else {
                this.hTX.setVisibility(8);
                this.iad.setVisibility(0);
                this.iad.setUserId(metaData.getUserId());
                this.iad.setUserName(metaData.getUserName());
                this.iad.setDefaultResource(R.drawable.transparent_bg);
                this.iad.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iad.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.j(this.ccZ, R.color.cp_cont_c);
            }
            this.iac.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iac.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iac.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.ayL() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.ayL().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.k(next.ayT());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fV(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cxR());
                        continue;
                    case 17:
                        String str = next.ayX().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.k("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.azc()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.ayT() == null || tbRichTextData.ayT().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.ayT());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hZZ.getPageContext().getString(R.string.refresh_view_title_text), this.bCn));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hZZ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iaa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.g(pageActivity, R.dimen.ds250), l.g(pageActivity, R.dimen.ds480), l.g(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.iaa.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gWg.asV();
        com.baidu.tbadk.core.util.am.l(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hZZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void oW(int i) {
        b(NoDataViewFactory.d.ag(i, R.string.refresh_view_title_text));
        if (this.hZP != null) {
            this.hZP.cF(this.dMd);
        }
        this.iaz.setVisibility(8);
    }

    public void vp(String str) {
        b(NoDataViewFactory.d.bX(str, this.hZZ.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.hZP != null) {
            this.hZP.cF(this.dMd);
        }
        this.iaz.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.iaz.setVisibility(0);
            this.dMd.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
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
                String userId2 = postData.aex().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.hYD != null && this.hYD.acx() != null && this.hYD.acx().aex() != null && postData.aex() != null) {
                String userId3 = this.hYD.acx().aex().getUserId();
                String userId4 = postData.aex().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aex().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.cpp() == 1) {
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
                        if (postData.aex() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aex().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aex().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aex().getPortrait());
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
                        if (postData.aex() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aex().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aex().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aex().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aex() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aex().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aex().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aex().getName_show());
                        }
                        if (this.hYD.acx() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hYD.acx().getId());
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
            userId = postData.aex().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.cpp() == 1) {
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

    public void pq(boolean z) {
        if (this.hZE != null && this.hZE.bWm() != null) {
            if (z) {
                this.hZE.bWm().setText(R.string.remove_mark);
            } else {
                this.hZE.bWm().setText(R.string.mark);
            }
        }
    }

    public View bYW() {
        return this.iar;
    }

    public void onChangeSkinType(int i) {
        this.hZZ.getLayoutMode().setNightMode(i == 1);
        this.hZZ.getLayoutMode().onModeChanged(this.dMd);
        this.hZZ.getLayoutMode().onModeChanged(this.hZY);
        this.mNavigationBar.onChangeSkinType(this.hZZ.getPageContext(), i);
        if (this.iab != null) {
            com.baidu.tbadk.core.util.am.j(this.iab, R.color.goto_see_subject_color);
        }
        this.fpM.onChangeSkinType(this.hZZ.getPageContext(), i);
        this.hZZ.getLayoutMode().onModeChanged(this.iar);
        com.baidu.tbadk.core.util.am.j(this.iai, R.color.cp_cont_b);
        this.iai.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        if (this.gWg != null && this.gWg.arY() != null) {
            this.gWg.arY().onChangeSkinType(i);
        }
        this.iam.iV(i);
        this.Ym.bIl();
        com.baidu.tbadk.core.util.am.j(this.fJe, R.color.cp_cont_e);
        com.baidu.tbadk.core.util.am.j(this.hTP, R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.j(this.ccZ, R.color.cp_cont_c);
        this.fJe.setAlpha(0.95f);
        if (this.ian != null) {
            com.baidu.tbadk.s.a.a(this.hZZ.getPageContext(), this.ian);
        }
        if (this.iaF != null) {
            this.iaF.notifyDataSetChanged();
        }
    }

    public void bYX() {
        this.mProgress.setVisibility(0);
    }

    public void bYY() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iam.akE();
    }

    public void bis() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iam.bis();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.coR = onLongClickListener;
        this.iaF.c(onLongClickListener);
    }

    public View bYZ() {
        return this.hZY;
    }

    public TextView bql() {
        return this.fJe;
    }

    public ImageView bZa() {
        return this.iaA;
    }

    public ImageView bZb() {
        return this.iaB;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void yo(int i) {
    }

    public View bZc() {
        return this.iab;
    }

    public View bZd() {
        return this.iaj;
    }

    public MorePopupWindow bZe() {
        return this.iao;
    }

    public void showLoadingDialog() {
        if (this.eMs == null) {
            this.eMs = new com.baidu.tbadk.core.view.b(this.hZZ.getPageContext());
        }
        this.eMs.ej(true);
    }

    public void aUz() {
        if (this.eMs != null) {
            this.eMs.ej(false);
        }
    }

    public TextView bZf() {
        return this.iai;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hZG = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.iaF.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.iaF != null) {
            this.iaF.notifyDataSetChanged();
        }
    }

    public y bZg() {
        return this.hZE;
    }

    public void bsm() {
    }

    public void bsn() {
    }

    public void aFO() {
    }

    public void bZh() {
        if (this.hZZ.isPaused()) {
        }
    }

    public View bZi() {
        return this.iac;
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.hZZ.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bZj() {
        if (this.gWg == null || this.gWg.arY() == null) {
            return 0;
        }
        return this.gWg.arY().getHeight();
    }
}
