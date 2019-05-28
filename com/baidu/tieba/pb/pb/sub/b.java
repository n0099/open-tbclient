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
    private static final int hTJ = TbadkCoreApplication.getInst().getListItemRule().alr();
    private RelativeLayout dIv;
    private com.baidu.tbadk.core.view.b eHw;
    private TextView fEg;
    private com.baidu.tieba.NEGFeedBack.e fQm;
    private View fba;
    private NoNetworkView fkO;
    private k hSp;
    private a hTB;
    private View hTK;
    private NewSubPbActivity hTL;
    private RelativeLayout hTM;
    private View hTQ;
    private ThreadSkinView hTX;
    private e hTY;
    private View hTZ;
    private SubPbModel hTn;
    private y hTq;
    private View hUd;
    private com.baidu.tbadk.core.dialog.b hUf;
    private ArrayList<PostData> hUj;
    private String hUk;
    private RelativeLayout hUl;
    private ImageView hUm;
    private ImageView hUn;
    private d hUr;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bBp = null;
    private TbRichTextView.i hTs = null;
    private NavigationBar mNavigationBar = null;
    private View cdX = null;
    private TextView hTN = null;
    private LinearLayout hTO = null;
    private HeadImageView hTP = null;
    private ClickableHeaderImageView hNJ = null;
    private TextView cbV = null;
    private ImageView hTR = null;
    private TextView hNB = null;
    private TextView hTS = null;
    private TextView hTT = null;
    private EllipsizeRichTextView hTU = null;
    private TbImageView hTV = null;
    private PlayVoiceBntNew XS = null;
    private TextView hTW = null;
    private MorePopupWindow hUa = null;
    private am hUb = null;
    private com.baidu.tbadk.core.dialog.b hUc = null;
    private Dialog hUe = null;
    private com.baidu.tbadk.core.dialog.a hOj = null;
    private boolean hGF = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cnE = null;
    private NewSubPbActivity.a hUg = null;
    private NewSubPbActivity.a hUh = null;
    private g gPU = null;
    private String hUi = null;
    private int cKG = 0;
    private PostData hCh = null;
    private int hUo = 0;
    private int hUp = 2;
    private int hUq = 0;
    private boolean crd = true;
    private View.OnClickListener hGO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hTL.c(sparseArray);
                        return;
                    }
                    b.this.cA(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.hTL.c(sparseArray);
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
    protected AdapterView.OnItemLongClickListener hUs = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hUj, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hTq == null) {
                b.this.hTq = new y(b.this.hTL.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hTq.showDialog();
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
            b.this.hTq.a(sparseArray, b.this.hTn.bPX(), nY);
            if (nY) {
                b.this.hTq.bTA().setVisibility(0);
                b.this.hTq.bTA().setTag(postData.getId());
            } else {
                b.this.hTq.bTA().setVisibility(8);
            }
            b.this.hTq.bTy().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hUt = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cE(b.this.hTL.getPageContext().getPageActivity())) {
                if (b.this.hTL.gPM == null || b.this.hTn == null || b.this.hTn.biZ() == null || b.this.hTL.gPM.hZ(b.this.hTn.biZ().replyPrivateFlag)) {
                    if (b.this.hTB != null) {
                        b.this.hTB.bnW();
                    }
                    b.this.bWc();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hUj, i);
                        if (postData == null) {
                            b.this.hUk = null;
                        } else {
                            b.this.hUk = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gPU.setReplyId(str2);
                                b.this.gPU.qh(str);
                            }
                        }
                        b.this.bWd();
                        return;
                    }
                    b.this.bWe();
                    b.this.hTn.bWA();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dIv = null;
        this.hTK = null;
        this.mListView = null;
        this.hTL = null;
        this.fkO = null;
        this.hTM = null;
        this.hTQ = null;
        this.hTY = null;
        this.hUd = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fEg = null;
        this.hUl = null;
        this.hUm = null;
        this.hUn = null;
        this.hTL = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dIv = (RelativeLayout) LayoutInflater.from(this.hTL.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.hTK = LayoutInflater.from(this.hTL.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.hUl = (RelativeLayout) this.dIv.findViewById(R.id.subpb_editor_tool_comment);
        this.fEg = (TextView) this.dIv.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fEg.setOnClickListener(this.mCommonClickListener);
        this.hUm = (ImageView) this.dIv.findViewById(R.id.subpb_editor_tool_more_img);
        this.hUn = (ImageView) this.dIv.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.hUn.setOnClickListener(this.mCommonClickListener);
        this.hUm.setOnClickListener(this.mCommonClickListener);
        this.fkO = (NoNetworkView) this.dIv.findViewById(R.id.view_no_network);
        boe();
        bhN();
        this.hTM = (RelativeLayout) this.dIv.findViewById(R.id.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dIv.findViewById(R.id.new_sub_pb_list);
        this.hTX = (ThreadSkinView) LayoutInflater.from(this.hTL.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hTX);
        this.mListView.addHeaderView(this.hTK);
        this.fba = BdListViewHelper.a(this.hTL.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hTY = new e(this.hTL.getPageContext());
        this.hTY.ajv();
        this.hUd = this.hTY.getView();
        this.mListView.setNextPage(this.hTY);
        this.hTY.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hUt);
        this.mListView.setOnItemLongClickListener(this.hUs);
        this.mListView.setOnTouchListener(this.ckg);
        this.mProgress = (ProgressBar) this.dIv.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hTK != null) {
            this.hTK.setVisibility(4);
        }
        if (this.hTM != null) {
            this.hTM.setVisibility(4);
        }
        this.hTQ = com.baidu.tbadk.ala.b.Zl().n(this.hTL.getActivity(), 4);
        if (this.hTQ != null) {
            this.hTQ.setVisibility(8);
            this.hTO.addView(this.hTQ, 3);
        }
        this.hUr = new d(this.hTL, this.mListView);
        this.hUr.setFromCDN(this.mIsFromCDN);
        this.hUr.v(this.mCommonClickListener);
        this.hUr.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bhN() {
        this.hTO = (LinearLayout) this.hTK.findViewById(R.id.subpb_head_user_info_root);
        this.hTO.setOnClickListener(this.mCommonClickListener);
        this.hTP = (HeadImageView) this.hTK.findViewById(R.id.photo);
        this.hTP.setRadius(l.g(this.hTL.getActivity(), R.dimen.ds30));
        this.hTP.setClickable(false);
        this.hNJ = (ClickableHeaderImageView) this.hTK.findViewById(R.id.god_user_photo);
        this.hNJ.setGodIconMargin(0);
        this.hNJ.setGodIconWidth(R.dimen.ds24);
        this.hNJ.setRadius(l.g(this.hTL.getActivity(), R.dimen.ds30));
        this.hNJ.setClickable(false);
        this.cbV = (TextView) this.hTK.findViewById(R.id.user_name);
        this.hTR = (ImageView) this.hTK.findViewById(R.id.user_rank);
        this.hTR.setVisibility(8);
        this.hNB = (TextView) this.hTK.findViewById(R.id.floor_owner);
        this.hTN = (TextView) this.hTK.findViewById(R.id.see_subject);
        this.hTN.setOnClickListener(this.mCommonClickListener);
        this.hTS = (TextView) this.hTK.findViewById(R.id.floor);
        this.hTT = (TextView) this.hTK.findViewById(R.id.time);
        this.hTU = (EllipsizeRichTextView) this.hTK.findViewById(R.id.content_text);
        this.hTU.setOnClickListener(this.mCommonClickListener);
        al.j(this.hTU, R.color.cp_cont_b);
        this.hTU.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
        this.hTU.setLineSpacing(0.0f, 1.25f);
        this.hTV = (TbImageView) this.hTK.findViewById(R.id.sub_pb_image);
        this.hTV.setOnClickListener(this.mCommonClickListener);
        this.hTW = (TextView) this.hTK.findViewById(R.id.advert);
        this.XS = (PlayVoiceBntNew) this.hTK.findViewById(R.id.voice_btn);
        this.hTK.setOnTouchListener(this.ckg);
        this.hTK.setOnClickListener(this.mCommonClickListener);
    }

    public void kt(boolean z) {
        if (this.fba != null && this.fba.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fba.getLayoutParams();
            if (z) {
                boi();
                layoutParams.height = l.g(this.hTL.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.g(this.hTL.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.fba.setLayoutParams(layoutParams);
        }
    }

    private void boi() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public void a(b.a aVar, boolean z) {
        if (this.hUf != null) {
            this.hUf.dismiss();
            this.hUf = null;
        }
        this.hUf = new com.baidu.tbadk.core.dialog.b(this.hTL.getPageContext().getPageActivity());
        if (z) {
            this.hUf.a(new String[]{this.hTL.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.hUf.a(new String[]{this.hTL.getPageContext().getString(R.string.save_to_emotion), this.hTL.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.hUf.d(this.hTL.getPageContext());
        this.hUf.afJ();
    }

    public void cE(View view) {
        this.hTZ = view;
    }

    public View boj() {
        return this.fba;
    }

    public void boe() {
        int g = l.g(this.hTL.getPageContext().getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.hTL.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.dIv.findViewById(R.id.view_navigation_bar);
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

    public NavigationBar aJC() {
        return this.mNavigationBar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.hUe == null) {
            this.hUe = new Dialog(this.hTL.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hUe.setCanceledOnTouchOutside(true);
            this.hUe.setCancelable(true);
            View inflate = LayoutInflater.from(this.hTL.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.hTL.getLayoutMode().onModeChanged(inflate);
            this.hUe.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hUe.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.hTL.getPageContext().getPageActivity()) * 0.9d);
            this.hUe.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hUe.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.hUe.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.hUe.findViewById(R.id.disable_reply_btn);
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
                    if (b.this.hUe != null && (b.this.hUe instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUe, b.this.hTL.getPageContext());
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
                    if (b.this.hUe != null && (b.this.hUe instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUe, b.this.hTL.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hUg != null) {
                        b.this.hUg.m(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (b.this.hUe != null && (b.this.hUe instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUe, b.this.hTL.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hTL.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hUe, this.hTL.getPageContext());
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
        this.hOj = new com.baidu.tbadk.core.dialog.a(this.hTL.getPageContext().getPageActivity());
        this.hOj.ho(i3);
        this.hOj.ab(sparseArray);
        this.hOj.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hUh != null) {
                    b.this.hUh.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hOj.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hOj.dM(true);
        this.hOj.b(this.hTL.getPageContext());
        if (z) {
            this.hOj.afG();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData biZ;
        if (this.hTL != null && sparseArray != null && this.hTK != null) {
            if (this.fQm == null) {
                this.fQm = new com.baidu.tieba.NEGFeedBack.e(this.hTL.getPageContext(), this.hTK);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hTn != null && (biZ = this.hTn.biZ()) != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fQm.setDefaultReasonArray(new String[]{this.hTL.getString(R.string.delete_thread_reason_1), this.hTL.getString(R.string.delete_thread_reason_2), this.hTL.getString(R.string.delete_thread_reason_3), this.hTL.getString(R.string.delete_thread_reason_4), this.hTL.getString(R.string.delete_thread_reason_5)});
            this.fQm.setData(ajVar);
            this.fQm.rs("4");
            this.fQm.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    String y = ap.y(jSONArray);
                    if (b.this.hUh != null) {
                        b.this.hUh.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), y});
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
        this.hUg = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hUh = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hTL.showToast(this.hTL.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.hTL.showToast(str);
        }
    }

    public void bT(View view) {
        if (this.fba != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fba.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fba);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fba.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.hTL.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fba, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.aqS() != null) {
            this.gPU = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dIv.addView(gVar.aqS(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hTB = aVar;
    }

    public void bWc() {
        if (this.mListView != null) {
            this.hUq = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nY(boolean z) {
        if (this.hTn == null || this.hTn.bWx() == null) {
            return false;
        }
        if (this.hTn.bPX() != 0) {
            return false;
        }
        return (this.hSp == null || this.hSp.abv() == null || this.hSp.abv().adv() == null || !TextUtils.equals(this.hSp.abv().adv().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bWd() {
        if (this.hTn != null) {
            if ((!bWg() && this.hUd != null && this.hUd.isShown()) || v.aa(this.hUj)) {
                this.hTn.pd(false);
            } else {
                this.hTn.pd(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hTn = subPbModel;
    }

    public void bWe() {
        b(this.hTL);
        this.mListView.setNextPage(this.hTY);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.qM(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bWg() && this.hUd != null && this.hUd.isShown()) {
                i = (this.hUq - this.hUp) - 1;
            } else {
                i = this.hUq - this.hUp;
            }
            int Z = v.Z(this.hUj);
            if (i > Z) {
                i = Z;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hUj, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hUq + 2);
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
        return this.dIv;
    }

    public void bUS() {
        if (this.hUa != null) {
            com.baidu.adp.lib.g.g.a(this.hUa, this.hTL.getPageContext().getPageActivity());
        }
        if (this.hUc != null) {
            this.hUc.dismiss();
        }
        if (this.hOj != null) {
            this.hOj.dismiss();
        }
        if (this.hUe != null) {
            com.baidu.adp.lib.g.g.b(this.hUe, this.hTL.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hTq != null) {
            this.hTq.dismiss();
        }
    }

    public void bWf() {
        this.mListView.setNextPage(this.hTY);
        this.hTY.ajy();
    }

    public void nR(boolean z) {
        this.hGF = z;
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
            if (this.crd && this.hTK != null) {
                this.hTK.setVisibility(8);
                this.mListView.removeHeaderView(this.hTK);
                this.hUp = 1;
            }
            this.hSp = kVar;
            if (this.hTK != null) {
                this.hTK.setVisibility(0);
            }
            if (this.hTM != null) {
                this.hTM.setVisibility(0);
            }
            if (kVar.bQu() != null) {
                this.hUi = kVar.bQu().getId();
                this.cKG = kVar.bQu().cmw();
                if (this.cKG > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hTL.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cKG)));
                    if (this.hTL != null) {
                        this.fEg.setText(this.hTL.bUi());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hTL.bWa() ? "PB" : null;
                if (kVar.bQu().adQ() != null) {
                    this.hTX.setData(this.hTL.getPageContext(), kVar.bQu().adQ(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", kVar.bQA().getId(), kVar.bQA().getName(), kVar.abv().getId(), str));
                } else {
                    this.hTX.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.hTY.ajy();
                this.hUr.setHasMoreData(true);
            } else {
                this.hTY.ajz();
                this.hUr.setHasMoreData(false);
            }
            this.hUj = kVar.bQy();
            if (this.hUj == null || this.hUj.size() <= hTJ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hUj.size() - hTJ;
                xJ(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hUj);
            if (v.aa(this.hUj)) {
                this.mListView.setNextPage(null);
                if (this.crd) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hTY);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.crd) {
                arrayList.add(0, kVar.bQu());
            }
            this.hUr.b(this.hSp.abv(), arrayList);
            a(kVar.bQu(), kVar.bDd(), kVar.ZC(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void xJ(int i) {
        if (this.hUj != null) {
            if (this.hUj.size() <= i) {
                this.hUj.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hUj.iterator();
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

    public boolean bWg() {
        return this.hUr.JO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.crd) {
            this.hCh = postData;
            if (!StringUtils.isNull(postData.cmD())) {
                this.hTV.setVisibility(0);
                this.hTV.startLoad(postData.cmD(), 10, true);
            } else {
                this.hTV.setVisibility(8);
            }
            i cmF = postData.cmF();
            if (cmF != null && cmF.iYj) {
                this.hTW.setVisibility(0);
            } else {
                this.hTW.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hTK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hTK.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hTS.setText((CharSequence) null);
            this.cbV.setText((CharSequence) null);
            this.hNB.setVisibility(8);
            if (!this.crd) {
                c(postData.adv());
                if (z) {
                    this.hNB.setVisibility(0);
                    al.j(this.hNB, R.color.cp_link_tip_a);
                }
            }
            this.hTT.setText(ap.aC(postData.getTime()));
            this.hTS.setText(String.format(this.hTL.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cmw())));
            postData.adv().getUserTbVipInfoData();
            boolean a = a(this.hTU, postData.cmy());
            if (StringUtils.isNull(postData.cmD()) && !a && postData.axI() != null) {
                this.XS.setVisibility(0);
                this.XS.setTag(postData.axI());
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
            if (metaData.getAlaUserData() != null && this.hTQ != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hTQ.setVisibility(8);
                } else {
                    this.hTQ.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bzQ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hTQ.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hNJ.setVisibility(0);
                this.hTP.setVisibility(8);
                this.hNJ.setUserId(metaData.getUserId());
                this.hNJ.setUserName(metaData.getUserName());
                this.hNJ.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.cbV, R.color.cp_cont_r);
            } else {
                this.hNJ.setVisibility(8);
                this.hTP.setVisibility(0);
                this.hTP.setUserId(metaData.getUserId());
                this.hTP.setUserName(metaData.getUserName());
                this.hTP.setDefaultResource(R.drawable.transparent_bg);
                this.hTP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.hTP.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.cbV, R.color.cp_cont_c);
            }
            this.hTO.setTag(R.id.tag_user_id, metaData.getUserId());
            this.hTO.setTag(R.id.tag_user_name, metaData.getUserName());
            this.hTO.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.axz() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.axz().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.axH());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fR(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cvd());
                        continue;
                    case 17:
                        String str = next.axL().mGifInfo.mSharpText;
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
        if (!tbRichTextData.axQ()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.axH() == null || tbRichTextData.axH().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.axH());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hTL.getPageContext().getString(R.string.refresh_view_title_text), this.bBp));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hTL.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hTM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.g(pageActivity, R.dimen.ds250), l.g(pageActivity, R.dimen.ds480), l.g(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.hTM.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gPU.arP();
        al.l(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hTL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void oH(int i) {
        b(NoDataViewFactory.d.ad(i, R.string.refresh_view_title_text));
        if (this.hTB != null) {
            this.hTB.cC(this.dIv);
        }
        this.hUl.setVisibility(8);
    }

    public void uL(String str) {
        b(NoDataViewFactory.d.bW(str, this.hTL.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.hTB != null) {
            this.hTB.cC(this.dIv);
        }
        this.hUl.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hUl.setVisibility(0);
            this.dIv.setOnTouchListener(null);
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
            if (this.hSp != null && this.hSp.abv() != null && this.hSp.abv().adv() != null && postData.adv() != null) {
                String userId3 = this.hSp.abv().adv().getUserId();
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
                    if (postData.cmw() == 1) {
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
                        if (this.hSp.abv() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hSp.abv().getId());
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
            if (postData.cmw() == 1) {
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
        if (this.hTq != null && this.hTq.bTy() != null) {
            if (z) {
                this.hTq.bTy().setText(R.string.remove_mark);
            } else {
                this.hTq.bTy().setText(R.string.mark);
            }
        }
    }

    public View bWh() {
        return this.hUd;
    }

    public void onChangeSkinType(int i) {
        this.hTL.getLayoutMode().setNightMode(i == 1);
        this.hTL.getLayoutMode().onModeChanged(this.dIv);
        this.hTL.getLayoutMode().onModeChanged(this.hTK);
        this.mNavigationBar.onChangeSkinType(this.hTL.getPageContext(), i);
        if (this.hTN != null) {
            al.j(this.hTN, R.color.goto_see_subject_color);
        }
        this.fkO.onChangeSkinType(this.hTL.getPageContext(), i);
        this.hTL.getLayoutMode().onModeChanged(this.hUd);
        al.j(this.hTU, R.color.cp_cont_b);
        this.hTU.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
        if (this.gPU != null && this.gPU.aqS() != null) {
            this.gPU.aqS().onChangeSkinType(i);
        }
        this.hTY.iP(i);
        this.XS.bFD();
        al.j(this.fEg, R.color.cp_cont_e);
        al.j(this.hNB, R.color.cp_link_tip_a);
        al.j(this.cbV, R.color.cp_cont_c);
        this.fEg.setAlpha(0.95f);
        if (this.hTZ != null) {
            com.baidu.tbadk.s.a.a(this.hTL.getPageContext(), this.hTZ);
        }
        if (this.hUr != null) {
            this.hUr.notifyDataSetChanged();
        }
    }

    public void bWi() {
        this.mProgress.setVisibility(0);
    }

    public void bWj() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hTY.ajz();
    }

    public void bgp() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hTY.bgp();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnE = onLongClickListener;
        this.hUr.c(onLongClickListener);
    }

    public View bWk() {
        return this.hTK;
    }

    public TextView bok() {
        return this.fEg;
    }

    public ImageView bWl() {
        return this.hUm;
    }

    public ImageView bWm() {
        return this.hUn;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void xK(int i) {
    }

    public View bWn() {
        return this.hTN;
    }

    public View bWo() {
        return this.hTV;
    }

    public MorePopupWindow bWp() {
        return this.hUa;
    }

    public void showLoadingDialog() {
        if (this.eHw == null) {
            this.eHw = new com.baidu.tbadk.core.view.b(this.hTL.getPageContext());
        }
        this.eHw.ef(true);
    }

    public void aSG() {
        if (this.eHw != null) {
            this.eHw.ef(false);
        }
    }

    public TextView bWq() {
        return this.hTU;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hTs = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hUr.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hUr != null) {
            this.hUr.notifyDataSetChanged();
        }
    }

    public y bWr() {
        return this.hTq;
    }

    public void bqj() {
    }

    public void bqk() {
    }

    public void onActivityDestroy() {
    }

    public void bWs() {
        if (this.hTL.isPaused()) {
        }
    }

    public View bWt() {
        return this.hTO;
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.hTL.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bWu() {
        if (this.gPU == null || this.gPU.aqS() == null) {
            return 0;
        }
        return this.gPU.aqS().getHeight();
    }
}
