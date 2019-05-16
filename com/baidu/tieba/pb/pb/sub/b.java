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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private static final int hTG = TbadkCoreApplication.getInst().getListItemRule().alr();
    private RelativeLayout dIu;
    private com.baidu.tbadk.core.view.b eHv;
    private TextView fEf;
    private com.baidu.tieba.NEGFeedBack.e fQl;
    private View faZ;
    private NoNetworkView fkN;
    private k hSm;
    private View hTH;
    private NewSubPbActivity hTI;
    private RelativeLayout hTJ;
    private View hTN;
    private ThreadSkinView hTU;
    private e hTV;
    private View hTW;
    private SubPbModel hTk;
    private y hTn;
    private a hTy;
    private View hUa;
    private com.baidu.tbadk.core.dialog.b hUc;
    private ArrayList<PostData> hUg;
    private String hUh;
    private RelativeLayout hUi;
    private ImageView hUj;
    private ImageView hUk;
    private d hUo;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bBp = null;
    private TbRichTextView.i hTp = null;
    private NavigationBar mNavigationBar = null;
    private View cdX = null;
    private TextView hTK = null;
    private LinearLayout hTL = null;
    private HeadImageView hTM = null;
    private ClickableHeaderImageView hNG = null;
    private TextView cbV = null;
    private ImageView hTO = null;
    private TextView hNy = null;
    private TextView hTP = null;
    private TextView hTQ = null;
    private EllipsizeRichTextView hTR = null;
    private TbImageView hTS = null;
    private PlayVoiceBntNew XS = null;
    private TextView hTT = null;
    private MorePopupWindow hTX = null;
    private am hTY = null;
    private com.baidu.tbadk.core.dialog.b hTZ = null;
    private Dialog hUb = null;
    private com.baidu.tbadk.core.dialog.a hOg = null;
    private boolean hGC = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cnE = null;
    private NewSubPbActivity.a hUd = null;
    private NewSubPbActivity.a hUe = null;
    private g gPS = null;
    private String hUf = null;
    private int cKG = 0;
    private PostData hCe = null;
    private int hUl = 0;
    private int hUm = 2;
    private int hUn = 0;
    private boolean crd = true;
    private View.OnClickListener hGL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hTI.c(sparseArray);
                        return;
                    }
                    b.this.cA(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.hTI.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c ckg = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            b.this.kr(false);
            b.this.bT(view);
            b.this.kr(true);
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
    protected AdapterView.OnItemLongClickListener hUp = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hUg, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hTn == null) {
                b.this.hTn = new y(b.this.hTI.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hTn.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean nY = b.this.nY(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.hTn.a(sparseArray, b.this.hTk.bPU(), nY);
            if (nY) {
                b.this.hTn.bTx().setVisibility(0);
                b.this.hTn.bTx().setTag(postData.getId());
            } else {
                b.this.hTn.bTx().setVisibility(8);
            }
            b.this.hTn.bTv().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hUq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cE(b.this.hTI.getPageContext().getPageActivity())) {
                if (b.this.hTI.gPK == null || b.this.hTk == null || b.this.hTk.biW() == null || b.this.hTI.gPK.hZ(b.this.hTk.biW().replyPrivateFlag)) {
                    if (b.this.hTy != null) {
                        b.this.hTy.bnT();
                    }
                    b.this.bVZ();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hUg, i);
                        if (postData == null) {
                            b.this.hUh = null;
                        } else {
                            b.this.hUh = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gPS.setReplyId(str2);
                                b.this.gPS.qh(str);
                            }
                        }
                        b.this.bWa();
                        return;
                    }
                    b.this.bWb();
                    b.this.hTk.bWx();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dIu = null;
        this.hTH = null;
        this.mListView = null;
        this.hTI = null;
        this.fkN = null;
        this.hTJ = null;
        this.hTN = null;
        this.hTV = null;
        this.hUa = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fEf = null;
        this.hUi = null;
        this.hUj = null;
        this.hUk = null;
        this.hTI = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dIu = (RelativeLayout) LayoutInflater.from(this.hTI.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.hTH = LayoutInflater.from(this.hTI.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.hUi = (RelativeLayout) this.dIu.findViewById(R.id.subpb_editor_tool_comment);
        this.fEf = (TextView) this.dIu.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fEf.setOnClickListener(this.mCommonClickListener);
        this.hUj = (ImageView) this.dIu.findViewById(R.id.subpb_editor_tool_more_img);
        this.hUk = (ImageView) this.dIu.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.hUk.setOnClickListener(this.mCommonClickListener);
        this.hUj.setOnClickListener(this.mCommonClickListener);
        this.fkN = (NoNetworkView) this.dIu.findViewById(R.id.view_no_network);
        bob();
        bhK();
        this.hTJ = (RelativeLayout) this.dIu.findViewById(R.id.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dIu.findViewById(R.id.new_sub_pb_list);
        this.hTU = (ThreadSkinView) LayoutInflater.from(this.hTI.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hTU);
        this.mListView.addHeaderView(this.hTH);
        this.faZ = BdListViewHelper.a(this.hTI.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hTV = new e(this.hTI.getPageContext());
        this.hTV.ajv();
        this.hUa = this.hTV.getView();
        this.mListView.setNextPage(this.hTV);
        this.hTV.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hUq);
        this.mListView.setOnItemLongClickListener(this.hUp);
        this.mListView.setOnTouchListener(this.ckg);
        this.mProgress = (ProgressBar) this.dIu.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hTH != null) {
            this.hTH.setVisibility(4);
        }
        if (this.hTJ != null) {
            this.hTJ.setVisibility(4);
        }
        this.hTN = com.baidu.tbadk.ala.b.Zl().n(this.hTI.getActivity(), 4);
        if (this.hTN != null) {
            this.hTN.setVisibility(8);
            this.hTL.addView(this.hTN, 3);
        }
        this.hUo = new d(this.hTI, this.mListView);
        this.hUo.setFromCDN(this.mIsFromCDN);
        this.hUo.v(this.mCommonClickListener);
        this.hUo.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bhK() {
        this.hTL = (LinearLayout) this.hTH.findViewById(R.id.subpb_head_user_info_root);
        this.hTL.setOnClickListener(this.mCommonClickListener);
        this.hTM = (HeadImageView) this.hTH.findViewById(R.id.photo);
        this.hTM.setRadius(l.g(this.hTI.getActivity(), R.dimen.ds30));
        this.hTM.setClickable(false);
        this.hNG = (ClickableHeaderImageView) this.hTH.findViewById(R.id.god_user_photo);
        this.hNG.setGodIconMargin(0);
        this.hNG.setGodIconWidth(R.dimen.ds24);
        this.hNG.setRadius(l.g(this.hTI.getActivity(), R.dimen.ds30));
        this.hNG.setClickable(false);
        this.cbV = (TextView) this.hTH.findViewById(R.id.user_name);
        this.hTO = (ImageView) this.hTH.findViewById(R.id.user_rank);
        this.hTO.setVisibility(8);
        this.hNy = (TextView) this.hTH.findViewById(R.id.floor_owner);
        this.hTK = (TextView) this.hTH.findViewById(R.id.see_subject);
        this.hTK.setOnClickListener(this.mCommonClickListener);
        this.hTP = (TextView) this.hTH.findViewById(R.id.floor);
        this.hTQ = (TextView) this.hTH.findViewById(R.id.time);
        this.hTR = (EllipsizeRichTextView) this.hTH.findViewById(R.id.content_text);
        this.hTR.setOnClickListener(this.mCommonClickListener);
        al.j(this.hTR, R.color.cp_cont_b);
        this.hTR.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
        this.hTR.setLineSpacing(0.0f, 1.25f);
        this.hTS = (TbImageView) this.hTH.findViewById(R.id.sub_pb_image);
        this.hTS.setOnClickListener(this.mCommonClickListener);
        this.hTT = (TextView) this.hTH.findViewById(R.id.advert);
        this.XS = (PlayVoiceBntNew) this.hTH.findViewById(R.id.voice_btn);
        this.hTH.setOnTouchListener(this.ckg);
        this.hTH.setOnClickListener(this.mCommonClickListener);
    }

    public void kt(boolean z) {
        if (this.faZ != null && this.faZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.faZ.getLayoutParams();
            if (z) {
                bof();
                layoutParams.height = l.g(this.hTI.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.g(this.hTI.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.faZ.setLayoutParams(layoutParams);
        }
    }

    private void bof() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public void a(b.a aVar, boolean z) {
        if (this.hUc != null) {
            this.hUc.dismiss();
            this.hUc = null;
        }
        this.hUc = new com.baidu.tbadk.core.dialog.b(this.hTI.getPageContext().getPageActivity());
        if (z) {
            this.hUc.a(new String[]{this.hTI.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.hUc.a(new String[]{this.hTI.getPageContext().getString(R.string.save_to_emotion), this.hTI.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.hUc.d(this.hTI.getPageContext());
        this.hUc.afJ();
    }

    public void cE(View view) {
        this.hTW = view;
    }

    public View bog() {
        return this.faZ;
    }

    public void bob() {
        int g = l.g(this.hTI.getPageContext().getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.hTI.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.dIu.findViewById(R.id.view_navigation_bar);
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cdX.getLayoutParams();
            layoutParams.height = g;
            layoutParams.width = g;
            layoutParams.leftMargin = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cdX != null && (this.cdX.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cdX.getLayoutParams();
            layoutParams2.width = g;
            layoutParams2.height = g;
            this.cdX.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_back, R.drawable.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aJz() {
        return this.mNavigationBar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.hUb == null) {
            this.hUb = new Dialog(this.hTI.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hUb.setCanceledOnTouchOutside(true);
            this.hUb.setCancelable(true);
            View inflate = LayoutInflater.from(this.hTI.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.hTI.getLayoutMode().onModeChanged(inflate);
            this.hUb.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hUb.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.hTI.getPageContext().getPageActivity()) * 0.9d);
            this.hUb.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hUb.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.hUb.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.hUb.findViewById(R.id.disable_reply_btn);
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
                    if (b.this.hUb != null && (b.this.hUb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUb, b.this.hTI.getPageContext());
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
                    if (b.this.hUb != null && (b.this.hUb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUb, b.this.hTI.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hUd != null) {
                        b.this.hUd.m(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (b.this.hUb != null && (b.this.hUb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUb, b.this.hTI.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hTI.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hUb, this.hTI.getPageContext());
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
        this.hOg = new com.baidu.tbadk.core.dialog.a(this.hTI.getPageContext().getPageActivity());
        this.hOg.ho(i3);
        this.hOg.ab(sparseArray);
        this.hOg.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hUe != null) {
                    b.this.hUe.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hOg.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hOg.dM(true);
        this.hOg.b(this.hTI.getPageContext());
        if (z) {
            this.hOg.afG();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData biW;
        if (this.hTI != null && sparseArray != null && this.hTH != null) {
            if (this.fQl == null) {
                this.fQl = new com.baidu.tieba.NEGFeedBack.e(this.hTI.getPageContext(), this.hTH);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hTk != null && (biW = this.hTk.biW()) != null && biW.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biW.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fQl.setDefaultReasonArray(new String[]{this.hTI.getString(R.string.delete_thread_reason_1), this.hTI.getString(R.string.delete_thread_reason_2), this.hTI.getString(R.string.delete_thread_reason_3), this.hTI.getString(R.string.delete_thread_reason_4), this.hTI.getString(R.string.delete_thread_reason_5)});
            this.fQl.setData(ajVar);
            this.fQl.rs("4");
            this.fQl.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    String y = ap.y(jSONArray);
                    if (b.this.hUe != null) {
                        b.this.hUe.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), y});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(final boolean z) {
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
        this.hUd = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hUe = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hTI.showToast(this.hTI.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.hTI.showToast(str);
        }
    }

    public void bT(View view) {
        if (this.faZ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.faZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.faZ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.faZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.hTI.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.faZ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.aqS() != null) {
            this.gPS = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dIu.addView(gVar.aqS(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hTy = aVar;
    }

    public void bVZ() {
        if (this.mListView != null) {
            this.hUn = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nY(boolean z) {
        if (this.hTk == null || this.hTk.bWu() == null) {
            return false;
        }
        if (this.hTk.bPU() != 0) {
            return false;
        }
        return (this.hSm == null || this.hSm.abv() == null || this.hSm.abv().adv() == null || !TextUtils.equals(this.hSm.abv().adv().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bWa() {
        if (this.hTk != null) {
            if ((!bWd() && this.hUa != null && this.hUa.isShown()) || v.aa(this.hUg)) {
                this.hTk.pd(false);
            } else {
                this.hTk.pd(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hTk = subPbModel;
    }

    public void bWb() {
        b(this.hTI);
        this.mListView.setNextPage(this.hTV);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.qM(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bWd() && this.hUa != null && this.hUa.isShown()) {
                i = (this.hUn - this.hUm) - 1;
            } else {
                i = this.hUn - this.hUm;
            }
            int Z = v.Z(this.hUg);
            if (i > Z) {
                i = Z;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hUg, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hUn + 2);
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
        return this.dIu;
    }

    public void bUP() {
        if (this.hTX != null) {
            com.baidu.adp.lib.g.g.a(this.hTX, this.hTI.getPageContext().getPageActivity());
        }
        if (this.hTZ != null) {
            this.hTZ.dismiss();
        }
        if (this.hOg != null) {
            this.hOg.dismiss();
        }
        if (this.hUb != null) {
            com.baidu.adp.lib.g.g.b(this.hUb, this.hTI.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hTn != null) {
            this.hTn.dismiss();
        }
    }

    public void bWc() {
        this.mListView.setNextPage(this.hTV);
        this.hTV.ajy();
    }

    public void nR(boolean z) {
        this.hGC = z;
    }

    public void setIsFromPb(boolean z) {
        this.crd = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (kVar != null) {
            if (this.crd && this.hTH != null) {
                this.hTH.setVisibility(8);
                this.mListView.removeHeaderView(this.hTH);
                this.hUm = 1;
            }
            this.hSm = kVar;
            if (this.hTH != null) {
                this.hTH.setVisibility(0);
            }
            if (this.hTJ != null) {
                this.hTJ.setVisibility(0);
            }
            if (kVar.bQr() != null) {
                this.hUf = kVar.bQr().getId();
                this.cKG = kVar.bQr().cmu();
                if (this.cKG > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hTI.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cKG)));
                    if (this.hTI != null) {
                        this.fEf.setText(this.hTI.bUf());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hTI.bVX() ? "PB" : null;
                if (kVar.bQr().adQ() != null) {
                    this.hTU.setData(this.hTI.getPageContext(), kVar.bQr().adQ(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", kVar.bQx().getId(), kVar.bQx().getName(), kVar.abv().getId(), str));
                } else {
                    this.hTU.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.hTV.ajy();
                this.hUo.setHasMoreData(true);
            } else {
                this.hTV.ajz();
                this.hUo.setHasMoreData(false);
            }
            this.hUg = kVar.bQv();
            if (this.hUg == null || this.hUg.size() <= hTG) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hUg.size() - hTG;
                xJ(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hUg);
            if (v.aa(this.hUg)) {
                this.mListView.setNextPage(null);
                if (this.crd) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hTV);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.crd) {
                arrayList.add(0, kVar.bQr());
            }
            this.hUo.b(this.hSm.abv(), arrayList);
            a(kVar.bQr(), kVar.bDa(), kVar.ZC(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void xJ(int i) {
        if (this.hUg != null) {
            if (this.hUg.size() <= i) {
                this.hUg.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hUg.iterator();
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

    public boolean bWd() {
        return this.hUo.JO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.crd) {
            this.hCe = postData;
            if (!StringUtils.isNull(postData.cmB())) {
                this.hTS.setVisibility(0);
                this.hTS.startLoad(postData.cmB(), 10, true);
            } else {
                this.hTS.setVisibility(8);
            }
            i cmD = postData.cmD();
            if (cmD != null && cmD.iYh) {
                this.hTT.setVisibility(0);
            } else {
                this.hTT.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hTH.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hTH.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hTP.setText((CharSequence) null);
            this.cbV.setText((CharSequence) null);
            this.hNy.setVisibility(8);
            if (!this.crd) {
                c(postData.adv());
                if (z) {
                    this.hNy.setVisibility(0);
                    al.j(this.hNy, R.color.cp_link_tip_a);
                }
            }
            this.hTQ.setText(ap.aC(postData.getTime()));
            this.hTP.setText(String.format(this.hTI.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cmu())));
            postData.adv().getUserTbVipInfoData();
            boolean a = a(this.hTR, postData.cmw());
            if (StringUtils.isNull(postData.cmB()) && !a && postData.axH() != null) {
                this.XS.setVisibility(0);
                this.XS.setTag(postData.axH());
                return;
            }
            this.XS.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bj(metaData.getSealPrefix()) + 2 : 0) + ab.qW(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.cbV.setText(bX(metaData.getSealPrefix(), name_show));
            } else {
                this.cbV.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.hTN != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hTN.setVisibility(8);
                } else {
                    this.hTN.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bzQ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hTN.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hNG.setVisibility(0);
                this.hTM.setVisibility(8);
                this.hNG.setUserId(metaData.getUserId());
                this.hNG.setUserName(metaData.getUserName());
                this.hNG.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.cbV, R.color.cp_cont_r);
            } else {
                this.hNG.setVisibility(8);
                this.hTM.setVisibility(0);
                this.hTM.setUserId(metaData.getUserId());
                this.hTM.setUserName(metaData.getUserName());
                this.hTM.setDefaultResource(R.drawable.transparent_bg);
                this.hTM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.hTM.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.cbV, R.color.cp_cont_c);
            }
            this.hTL.setTag(R.id.tag_user_id, metaData.getUserId());
            this.hTL.setTag(R.id.tag_user_name, metaData.getUserName());
            this.hTL.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.axy() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.axy().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.axG());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fR(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cvb());
                        continue;
                    case 17:
                        String str = next.axK().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.append("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.axP()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.axG() == null || tbRichTextData.axG().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.axG());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hTI.getPageContext().getString(R.string.refresh_view_title_text), this.bBp));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hTI.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hTJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.g(pageActivity, R.dimen.ds250), l.g(pageActivity, R.dimen.ds480), l.g(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.hTJ.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gPS.arP();
        al.l(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hTI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void oH(int i) {
        b(NoDataViewFactory.d.ad(i, R.string.refresh_view_title_text));
        if (this.hTy != null) {
            this.hTy.cC(this.dIu);
        }
        this.hUi.setVisibility(8);
    }

    public void uL(String str) {
        b(NoDataViewFactory.d.bW(str, this.hTI.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.hTy != null) {
            this.hTy.cC(this.dIu);
        }
        this.hUi.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hUi.setVisibility(0);
            this.dIu.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBp = onClickListener;
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
                String userId2 = postData.adv().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.hSm != null && this.hSm.abv() != null && this.hSm.abv().adv() != null && postData.adv() != null) {
                String userId3 = this.hSm.abv().adv().getUserId();
                String userId4 = postData.adv().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.adv().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.cmu() == 1) {
                        i2 = 0;
                    }
                    if (com.baidu.tieba.pb.pb.main.ap.m(postData)) {
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
                        if (postData.adv() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.adv().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.adv().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.adv().getPortrait());
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
                        if (postData.adv() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.adv().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.adv().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.adv().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.adv() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.adv().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.adv().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.adv().getName_show());
                        }
                        if (this.hSm.abv() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hSm.abv().getId());
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
            userId = postData.adv().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.cmu() == 1) {
            }
            if (com.baidu.tieba.pb.pb.main.ap.m(postData)) {
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

    public void pb(boolean z) {
        if (this.hTn != null && this.hTn.bTv() != null) {
            if (z) {
                this.hTn.bTv().setText(R.string.remove_mark);
            } else {
                this.hTn.bTv().setText(R.string.mark);
            }
        }
    }

    public View bWe() {
        return this.hUa;
    }

    public void onChangeSkinType(int i) {
        this.hTI.getLayoutMode().setNightMode(i == 1);
        this.hTI.getLayoutMode().onModeChanged(this.dIu);
        this.hTI.getLayoutMode().onModeChanged(this.hTH);
        this.mNavigationBar.onChangeSkinType(this.hTI.getPageContext(), i);
        if (this.hTK != null) {
            al.j(this.hTK, R.color.goto_see_subject_color);
        }
        this.fkN.onChangeSkinType(this.hTI.getPageContext(), i);
        this.hTI.getLayoutMode().onModeChanged(this.hUa);
        al.j(this.hTR, R.color.cp_cont_b);
        this.hTR.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
        if (this.gPS != null && this.gPS.aqS() != null) {
            this.gPS.aqS().onChangeSkinType(i);
        }
        this.hTV.iP(i);
        this.XS.bFA();
        al.j(this.fEf, R.color.cp_cont_e);
        al.j(this.hNy, R.color.cp_link_tip_a);
        al.j(this.cbV, R.color.cp_cont_c);
        this.fEf.setAlpha(0.95f);
        if (this.hTW != null) {
            com.baidu.tbadk.s.a.a(this.hTI.getPageContext(), this.hTW);
        }
        if (this.hUo != null) {
            this.hUo.notifyDataSetChanged();
        }
    }

    public void bWf() {
        this.mProgress.setVisibility(0);
    }

    public void bWg() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hTV.ajz();
    }

    public void bgm() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hTV.bgm();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnE = onLongClickListener;
        this.hUo.c(onLongClickListener);
    }

    public View bWh() {
        return this.hTH;
    }

    public TextView boh() {
        return this.fEf;
    }

    public ImageView bWi() {
        return this.hUj;
    }

    public ImageView bWj() {
        return this.hUk;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void xK(int i) {
    }

    public View bWk() {
        return this.hTK;
    }

    public View bWl() {
        return this.hTS;
    }

    public MorePopupWindow bWm() {
        return this.hTX;
    }

    public void showLoadingDialog() {
        if (this.eHv == null) {
            this.eHv = new com.baidu.tbadk.core.view.b(this.hTI.getPageContext());
        }
        this.eHv.ef(true);
    }

    public void aSD() {
        if (this.eHv != null) {
            this.eHv.ef(false);
        }
    }

    public TextView bWn() {
        return this.hTR;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hTp = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hUo.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hUo != null) {
            this.hUo.notifyDataSetChanged();
        }
    }

    public y bWo() {
        return this.hTn;
    }

    public void bqg() {
    }

    public void bqh() {
    }

    public void onActivityDestroy() {
    }

    public void bWp() {
        if (this.hTI.isPaused()) {
        }
    }

    public View bWq() {
        return this.hTL;
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.hTI.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bWr() {
        if (this.gPS == null || this.gPS.aqS() == null) {
            return 0;
        }
        return this.gPS.aqS().getHeight();
    }
}
