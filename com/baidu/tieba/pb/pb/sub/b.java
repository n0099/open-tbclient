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
    private static final int hTK = TbadkCoreApplication.getInst().getListItemRule().alr();
    private RelativeLayout dIv;
    private com.baidu.tbadk.core.view.b eHw;
    private TextView fEg;
    private com.baidu.tieba.NEGFeedBack.e fQo;
    private View fba;
    private NoNetworkView fkO;
    private k hSq;
    private a hTC;
    private View hTL;
    private NewSubPbActivity hTM;
    private RelativeLayout hTN;
    private View hTR;
    private ThreadSkinView hTY;
    private e hTZ;
    private SubPbModel hTo;
    private y hTr;
    private View hUa;
    private View hUe;
    private com.baidu.tbadk.core.dialog.b hUg;
    private ArrayList<PostData> hUk;
    private String hUl;
    private RelativeLayout hUm;
    private ImageView hUn;
    private ImageView hUo;
    private d hUs;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bBr = null;
    private TbRichTextView.i hTt = null;
    private NavigationBar mNavigationBar = null;
    private View cdY = null;
    private TextView hTO = null;
    private LinearLayout hTP = null;
    private HeadImageView hTQ = null;
    private ClickableHeaderImageView hNK = null;
    private TextView cbW = null;
    private ImageView hTS = null;
    private TextView hNC = null;
    private TextView hTT = null;
    private TextView hTU = null;
    private EllipsizeRichTextView hTV = null;
    private TbImageView hTW = null;
    private PlayVoiceBntNew XR = null;
    private TextView hTX = null;
    private MorePopupWindow hUb = null;
    private am hUc = null;
    private com.baidu.tbadk.core.dialog.b hUd = null;
    private Dialog hUf = null;
    private com.baidu.tbadk.core.dialog.a hOk = null;
    private boolean hGG = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cnF = null;
    private NewSubPbActivity.a hUh = null;
    private NewSubPbActivity.a hUi = null;
    private g gPW = null;
    private String hUj = null;
    private int cKH = 0;
    private PostData hCi = null;
    private int hUp = 0;
    private int hUq = 2;
    private int hUr = 0;
    private boolean cre = true;
    private View.OnClickListener hGP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hTM.c(sparseArray);
                        return;
                    }
                    b.this.cA(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.hTM.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c ckh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
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
    protected AdapterView.OnItemLongClickListener hUt = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hUk, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hTr == null) {
                b.this.hTr = new y(b.this.hTM.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hTr.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean nZ = b.this.nZ(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.hTr.a(sparseArray, b.this.hTo.bPY(), nZ);
            if (nZ) {
                b.this.hTr.bTB().setVisibility(0);
                b.this.hTr.bTB().setTag(postData.getId());
            } else {
                b.this.hTr.bTB().setVisibility(8);
            }
            b.this.hTr.bTz().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hUu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cE(b.this.hTM.getPageContext().getPageActivity())) {
                if (b.this.hTM.gPO == null || b.this.hTo == null || b.this.hTo.biZ() == null || b.this.hTM.gPO.hZ(b.this.hTo.biZ().replyPrivateFlag)) {
                    if (b.this.hTC != null) {
                        b.this.hTC.bnW();
                    }
                    b.this.bWd();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hUk, i);
                        if (postData == null) {
                            b.this.hUl = null;
                        } else {
                            b.this.hUl = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gPW.setReplyId(str2);
                                b.this.gPW.qg(str);
                            }
                        }
                        b.this.bWe();
                        return;
                    }
                    b.this.bWf();
                    b.this.hTo.bWB();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dIv = null;
        this.hTL = null;
        this.mListView = null;
        this.hTM = null;
        this.fkO = null;
        this.hTN = null;
        this.hTR = null;
        this.hTZ = null;
        this.hUe = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fEg = null;
        this.hUm = null;
        this.hUn = null;
        this.hUo = null;
        this.hTM = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dIv = (RelativeLayout) LayoutInflater.from(this.hTM.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.hTL = LayoutInflater.from(this.hTM.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.hUm = (RelativeLayout) this.dIv.findViewById(R.id.subpb_editor_tool_comment);
        this.fEg = (TextView) this.dIv.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fEg.setOnClickListener(this.mCommonClickListener);
        this.hUn = (ImageView) this.dIv.findViewById(R.id.subpb_editor_tool_more_img);
        this.hUo = (ImageView) this.dIv.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.hUo.setOnClickListener(this.mCommonClickListener);
        this.hUn.setOnClickListener(this.mCommonClickListener);
        this.fkO = (NoNetworkView) this.dIv.findViewById(R.id.view_no_network);
        boe();
        bhN();
        this.hTN = (RelativeLayout) this.dIv.findViewById(R.id.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dIv.findViewById(R.id.new_sub_pb_list);
        this.hTY = (ThreadSkinView) LayoutInflater.from(this.hTM.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hTY);
        this.mListView.addHeaderView(this.hTL);
        this.fba = BdListViewHelper.a(this.hTM.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hTZ = new e(this.hTM.getPageContext());
        this.hTZ.ajv();
        this.hUe = this.hTZ.getView();
        this.mListView.setNextPage(this.hTZ);
        this.hTZ.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hUu);
        this.mListView.setOnItemLongClickListener(this.hUt);
        this.mListView.setOnTouchListener(this.ckh);
        this.mProgress = (ProgressBar) this.dIv.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hTL != null) {
            this.hTL.setVisibility(4);
        }
        if (this.hTN != null) {
            this.hTN.setVisibility(4);
        }
        this.hTR = com.baidu.tbadk.ala.b.Zl().n(this.hTM.getActivity(), 4);
        if (this.hTR != null) {
            this.hTR.setVisibility(8);
            this.hTP.addView(this.hTR, 3);
        }
        this.hUs = new d(this.hTM, this.mListView);
        this.hUs.setFromCDN(this.mIsFromCDN);
        this.hUs.v(this.mCommonClickListener);
        this.hUs.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bhN() {
        this.hTP = (LinearLayout) this.hTL.findViewById(R.id.subpb_head_user_info_root);
        this.hTP.setOnClickListener(this.mCommonClickListener);
        this.hTQ = (HeadImageView) this.hTL.findViewById(R.id.photo);
        this.hTQ.setRadius(l.g(this.hTM.getActivity(), R.dimen.ds30));
        this.hTQ.setClickable(false);
        this.hNK = (ClickableHeaderImageView) this.hTL.findViewById(R.id.god_user_photo);
        this.hNK.setGodIconMargin(0);
        this.hNK.setGodIconWidth(R.dimen.ds24);
        this.hNK.setRadius(l.g(this.hTM.getActivity(), R.dimen.ds30));
        this.hNK.setClickable(false);
        this.cbW = (TextView) this.hTL.findViewById(R.id.user_name);
        this.hTS = (ImageView) this.hTL.findViewById(R.id.user_rank);
        this.hTS.setVisibility(8);
        this.hNC = (TextView) this.hTL.findViewById(R.id.floor_owner);
        this.hTO = (TextView) this.hTL.findViewById(R.id.see_subject);
        this.hTO.setOnClickListener(this.mCommonClickListener);
        this.hTT = (TextView) this.hTL.findViewById(R.id.floor);
        this.hTU = (TextView) this.hTL.findViewById(R.id.time);
        this.hTV = (EllipsizeRichTextView) this.hTL.findViewById(R.id.content_text);
        this.hTV.setOnClickListener(this.mCommonClickListener);
        al.j(this.hTV, R.color.cp_cont_b);
        this.hTV.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
        this.hTV.setLineSpacing(0.0f, 1.25f);
        this.hTW = (TbImageView) this.hTL.findViewById(R.id.sub_pb_image);
        this.hTW.setOnClickListener(this.mCommonClickListener);
        this.hTX = (TextView) this.hTL.findViewById(R.id.advert);
        this.XR = (PlayVoiceBntNew) this.hTL.findViewById(R.id.voice_btn);
        this.hTL.setOnTouchListener(this.ckh);
        this.hTL.setOnClickListener(this.mCommonClickListener);
    }

    public void kt(boolean z) {
        if (this.fba != null && this.fba.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fba.getLayoutParams();
            if (z) {
                boi();
                layoutParams.height = l.g(this.hTM.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.g(this.hTM.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.fba.setLayoutParams(layoutParams);
        }
    }

    private void boi() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public void a(b.a aVar, boolean z) {
        if (this.hUg != null) {
            this.hUg.dismiss();
            this.hUg = null;
        }
        this.hUg = new com.baidu.tbadk.core.dialog.b(this.hTM.getPageContext().getPageActivity());
        if (z) {
            this.hUg.a(new String[]{this.hTM.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.hUg.a(new String[]{this.hTM.getPageContext().getString(R.string.save_to_emotion), this.hTM.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.hUg.d(this.hTM.getPageContext());
        this.hUg.afJ();
    }

    public void cE(View view) {
        this.hUa = view;
    }

    public View boj() {
        return this.fba;
    }

    public void boe() {
        int g = l.g(this.hTM.getPageContext().getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.hTM.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.dIv.findViewById(R.id.view_navigation_bar);
        this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cdY.getLayoutParams();
            layoutParams.height = g;
            layoutParams.width = g;
            layoutParams.leftMargin = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cdY != null && (this.cdY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cdY.getLayoutParams();
            layoutParams2.width = g;
            layoutParams2.height = g;
            this.cdY.setLayoutParams(layoutParams2);
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
        if (this.hUf == null) {
            this.hUf = new Dialog(this.hTM.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.hUf.setCanceledOnTouchOutside(true);
            this.hUf.setCancelable(true);
            View inflate = LayoutInflater.from(this.hTM.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.hTM.getLayoutMode().onModeChanged(inflate);
            this.hUf.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hUf.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.hTM.getPageContext().getPageActivity()) * 0.9d);
            this.hUf.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hUf.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.hUf.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.hUf.findViewById(R.id.disable_reply_btn);
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
                    if (b.this.hUf != null && (b.this.hUf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUf, b.this.hTM.getPageContext());
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
                    if (b.this.hUf != null && (b.this.hUf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUf, b.this.hTM.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hUh != null) {
                        b.this.hUh.m(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (b.this.hUf != null && (b.this.hUf instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hUf, b.this.hTM.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hTM.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hUf, this.hTM.getPageContext());
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
        this.hOk = new com.baidu.tbadk.core.dialog.a(this.hTM.getPageContext().getPageActivity());
        this.hOk.ho(i3);
        this.hOk.ab(sparseArray);
        this.hOk.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hUi != null) {
                    b.this.hUi.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hOk.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hOk.dM(true);
        this.hOk.b(this.hTM.getPageContext());
        if (z) {
            this.hOk.afG();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData biZ;
        if (this.hTM != null && sparseArray != null && this.hTL != null) {
            if (this.fQo == null) {
                this.fQo = new com.baidu.tieba.NEGFeedBack.e(this.hTM.getPageContext(), this.hTL);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hTo != null && (biZ = this.hTo.biZ()) != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fQo.setDefaultReasonArray(new String[]{this.hTM.getString(R.string.delete_thread_reason_1), this.hTM.getString(R.string.delete_thread_reason_2), this.hTM.getString(R.string.delete_thread_reason_3), this.hTM.getString(R.string.delete_thread_reason_4), this.hTM.getString(R.string.delete_thread_reason_5)});
            this.fQo.setData(ajVar);
            this.fQo.rr("4");
            this.fQo.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    String y = ap.y(jSONArray);
                    if (b.this.hUi != null) {
                        b.this.hUi.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), y});
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
        this.hUh = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hUi = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hTM.showToast(this.hTM.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.hTM.showToast(str);
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
                this.fba.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.hTM.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fba, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.aqS() != null) {
            this.gPW = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dIv.addView(gVar.aqS(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hTC = aVar;
    }

    public void bWd() {
        if (this.mListView != null) {
            this.hUr = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nZ(boolean z) {
        if (this.hTo == null || this.hTo.bWy() == null) {
            return false;
        }
        if (this.hTo.bPY() != 0) {
            return false;
        }
        return (this.hSq == null || this.hSq.abv() == null || this.hSq.abv().adv() == null || !TextUtils.equals(this.hSq.abv().adv().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bWe() {
        if (this.hTo != null) {
            if ((!bWh() && this.hUe != null && this.hUe.isShown()) || v.aa(this.hUk)) {
                this.hTo.pe(false);
            } else {
                this.hTo.pe(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hTo = subPbModel;
    }

    public void bWf() {
        b(this.hTM);
        this.mListView.setNextPage(this.hTZ);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.qN(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bWh() && this.hUe != null && this.hUe.isShown()) {
                i = (this.hUr - this.hUq) - 1;
            } else {
                i = this.hUr - this.hUq;
            }
            int Z = v.Z(this.hUk);
            if (i > Z) {
                i = Z;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hUk, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hUr + 2);
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

    public void bUT() {
        if (this.hUb != null) {
            com.baidu.adp.lib.g.g.a(this.hUb, this.hTM.getPageContext().getPageActivity());
        }
        if (this.hUd != null) {
            this.hUd.dismiss();
        }
        if (this.hOk != null) {
            this.hOk.dismiss();
        }
        if (this.hUf != null) {
            com.baidu.adp.lib.g.g.b(this.hUf, this.hTM.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hTr != null) {
            this.hTr.dismiss();
        }
    }

    public void bWg() {
        this.mListView.setNextPage(this.hTZ);
        this.hTZ.ajy();
    }

    public void nS(boolean z) {
        this.hGG = z;
    }

    public void setIsFromPb(boolean z) {
        this.cre = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (kVar != null) {
            if (this.cre && this.hTL != null) {
                this.hTL.setVisibility(8);
                this.mListView.removeHeaderView(this.hTL);
                this.hUq = 1;
            }
            this.hSq = kVar;
            if (this.hTL != null) {
                this.hTL.setVisibility(0);
            }
            if (this.hTN != null) {
                this.hTN.setVisibility(0);
            }
            if (kVar.bQv() != null) {
                this.hUj = kVar.bQv().getId();
                this.cKH = kVar.bQv().cmx();
                if (this.cKH > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hTM.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cKH)));
                    if (this.hTM != null) {
                        this.fEg.setText(this.hTM.bUj());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hTM.bWb() ? "PB" : null;
                if (kVar.bQv().adQ() != null) {
                    this.hTY.setData(this.hTM.getPageContext(), kVar.bQv().adQ(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", kVar.bQB().getId(), kVar.bQB().getName(), kVar.abv().getId(), str));
                } else {
                    this.hTY.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.hTZ.ajy();
                this.hUs.setHasMoreData(true);
            } else {
                this.hTZ.ajz();
                this.hUs.setHasMoreData(false);
            }
            this.hUk = kVar.bQz();
            if (this.hUk == null || this.hUk.size() <= hTK) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hUk.size() - hTK;
                xJ(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hUk);
            if (v.aa(this.hUk)) {
                this.mListView.setNextPage(null);
                if (this.cre) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hTZ);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.cre) {
                arrayList.add(0, kVar.bQv());
            }
            this.hUs.b(this.hSq.abv(), arrayList);
            a(kVar.bQv(), kVar.bDe(), kVar.ZC(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void xJ(int i) {
        if (this.hUk != null) {
            if (this.hUk.size() <= i) {
                this.hUk.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hUk.iterator();
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

    public boolean bWh() {
        return this.hUs.JO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.cre) {
            this.hCi = postData;
            if (!StringUtils.isNull(postData.cmE())) {
                this.hTW.setVisibility(0);
                this.hTW.startLoad(postData.cmE(), 10, true);
            } else {
                this.hTW.setVisibility(8);
            }
            i cmG = postData.cmG();
            if (cmG != null && cmG.iYn) {
                this.hTX.setVisibility(0);
            } else {
                this.hTX.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hTL.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hTL.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hTT.setText((CharSequence) null);
            this.cbW.setText((CharSequence) null);
            this.hNC.setVisibility(8);
            if (!this.cre) {
                c(postData.adv());
                if (z) {
                    this.hNC.setVisibility(0);
                    al.j(this.hNC, R.color.cp_link_tip_a);
                }
            }
            this.hTU.setText(ap.aC(postData.getTime()));
            this.hTT.setText(String.format(this.hTM.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cmx())));
            postData.adv().getUserTbVipInfoData();
            boolean a = a(this.hTV, postData.cmz());
            if (StringUtils.isNull(postData.cmE()) && !a && postData.axI() != null) {
                this.XR.setVisibility(0);
                this.XR.setTag(postData.axI());
                return;
            }
            this.XR.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bj(metaData.getSealPrefix()) + 2 : 0) + ab.qV(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.cbW.setText(bX(metaData.getSealPrefix(), name_show));
            } else {
                this.cbW.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.hTR != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hTR.setVisibility(8);
                } else {
                    this.hTR.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bzQ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hTR.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hNK.setVisibility(0);
                this.hTQ.setVisibility(8);
                this.hNK.setUserId(metaData.getUserId());
                this.hNK.setUserName(metaData.getUserName());
                this.hNK.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.cbW, R.color.cp_cont_r);
            } else {
                this.hNK.setVisibility(8);
                this.hTQ.setVisibility(0);
                this.hTQ.setUserId(metaData.getUserId());
                this.hTQ.setUserName(metaData.getUserName());
                this.hTQ.setDefaultResource(R.drawable.transparent_bg);
                this.hTQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.hTQ.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.cbW, R.color.cp_cont_c);
            }
            this.hTP.setTag(R.id.tag_user_id, metaData.getUserId());
            this.hTP.setTag(R.id.tag_user_name, metaData.getUserName());
            this.hTP.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.c.cvc());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hTM.getPageContext().getString(R.string.refresh_view_title_text), this.bBr));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hTM.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hTN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.g(pageActivity, R.dimen.ds250), l.g(pageActivity, R.dimen.ds480), l.g(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.hTN.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gPW.arP();
        al.l(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hTM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void oH(int i) {
        b(NoDataViewFactory.d.ad(i, R.string.refresh_view_title_text));
        if (this.hTC != null) {
            this.hTC.cC(this.dIv);
        }
        this.hUm.setVisibility(8);
    }

    public void uK(String str) {
        b(NoDataViewFactory.d.bW(str, this.hTM.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.hTC != null) {
            this.hTC.cC(this.dIv);
        }
        this.hUm.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hUm.setVisibility(0);
            this.dIv.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bBr = onClickListener;
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
            if (this.hSq != null && this.hSq.abv() != null && this.hSq.abv().adv() != null && postData.adv() != null) {
                String userId3 = this.hSq.abv().adv().getUserId();
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
                    if (postData.cmx() == 1) {
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
                        if (this.hSq.abv() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hSq.abv().getId());
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
            if (postData.cmx() == 1) {
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

    public void pc(boolean z) {
        if (this.hTr != null && this.hTr.bTz() != null) {
            if (z) {
                this.hTr.bTz().setText(R.string.remove_mark);
            } else {
                this.hTr.bTz().setText(R.string.mark);
            }
        }
    }

    public View bWi() {
        return this.hUe;
    }

    public void onChangeSkinType(int i) {
        this.hTM.getLayoutMode().setNightMode(i == 1);
        this.hTM.getLayoutMode().onModeChanged(this.dIv);
        this.hTM.getLayoutMode().onModeChanged(this.hTL);
        this.mNavigationBar.onChangeSkinType(this.hTM.getPageContext(), i);
        if (this.hTO != null) {
            al.j(this.hTO, R.color.goto_see_subject_color);
        }
        this.fkO.onChangeSkinType(this.hTM.getPageContext(), i);
        this.hTM.getLayoutMode().onModeChanged(this.hUe);
        al.j(this.hTV, R.color.cp_cont_b);
        this.hTV.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
        if (this.gPW != null && this.gPW.aqS() != null) {
            this.gPW.aqS().onChangeSkinType(i);
        }
        this.hTZ.iP(i);
        this.XR.bFE();
        al.j(this.fEg, R.color.cp_cont_e);
        al.j(this.hNC, R.color.cp_link_tip_a);
        al.j(this.cbW, R.color.cp_cont_c);
        this.fEg.setAlpha(0.95f);
        if (this.hUa != null) {
            com.baidu.tbadk.s.a.a(this.hTM.getPageContext(), this.hUa);
        }
        if (this.hUs != null) {
            this.hUs.notifyDataSetChanged();
        }
    }

    public void bWj() {
        this.mProgress.setVisibility(0);
    }

    public void bWk() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hTZ.ajz();
    }

    public void bgp() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hTZ.bgp();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnF = onLongClickListener;
        this.hUs.c(onLongClickListener);
    }

    public View bWl() {
        return this.hTL;
    }

    public TextView bok() {
        return this.fEg;
    }

    public ImageView bWm() {
        return this.hUn;
    }

    public ImageView bWn() {
        return this.hUo;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void xK(int i) {
    }

    public View bWo() {
        return this.hTO;
    }

    public View bWp() {
        return this.hTW;
    }

    public MorePopupWindow bWq() {
        return this.hUb;
    }

    public void showLoadingDialog() {
        if (this.eHw == null) {
            this.eHw = new com.baidu.tbadk.core.view.b(this.hTM.getPageContext());
        }
        this.eHw.ef(true);
    }

    public void aSG() {
        if (this.eHw != null) {
            this.eHw.ef(false);
        }
    }

    public TextView bWr() {
        return this.hTV;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hTt = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hUs.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hUs != null) {
            this.hUs.notifyDataSetChanged();
        }
    }

    public y bWs() {
        return this.hTr;
    }

    public void bql() {
    }

    public void bqm() {
    }

    public void onActivityDestroy() {
    }

    public void bWt() {
        if (this.hTM.isPaused()) {
        }
    }

    public View bWu() {
        return this.hTP;
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.hTM.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bWv() {
        if (this.gPW == null || this.gPW.aqS() == null) {
            return 0;
        }
        return this.gPW.aqS().getHeight();
    }
}
