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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.j;
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
    private static final int hBF = TbadkCoreApplication.getInst().getListItemRule().ags();
    private RelativeLayout dxU;
    private View eKP;
    private NoNetworkView eUC;
    private com.baidu.tbadk.core.view.b erO;
    private TextView fnK;
    private com.baidu.tieba.NEGFeedBack.e fzr;
    private j hAn;
    private View hBG;
    private NewSubPbActivity hBH;
    private RelativeLayout hBI;
    private View hBM;
    private ThreadSkinView hBT;
    private e hBU;
    private View hBV;
    private View hBZ;
    private SubPbModel hBi;
    private y hBl;
    private a hBx;
    private com.baidu.tbadk.core.dialog.b hCb;
    private ArrayList<PostData> hCf;
    private String hCg;
    private RelativeLayout hCh;
    private ImageView hCi;
    private ImageView hCj;
    private d hCn;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bul = null;
    private TbRichTextView.i hBn = null;
    private NavigationBar mNavigationBar = null;
    private View bWb = null;
    private TextView hBJ = null;
    private LinearLayout hBK = null;
    private HeadImageView hBL = null;
    private ClickableHeaderImageView hvX = null;
    private TextView bUa = null;
    private ImageView hBN = null;
    private TextView hvP = null;
    private TextView hBO = null;
    private TextView hBP = null;
    private EllipsizeRichTextView hBQ = null;
    private TbImageView hBR = null;
    private PlayVoiceBntNew ZZ = null;
    private TextView hBS = null;
    private MorePopupWindow hBW = null;
    private am hBX = null;
    private com.baidu.tbadk.core.dialog.b hBY = null;
    private Dialog hCa = null;
    private com.baidu.tbadk.core.dialog.a hwx = null;
    private boolean hoZ = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cfw = null;
    private NewSubPbActivity.a hCc = null;
    private NewSubPbActivity.a hCd = null;
    private g gyF = null;
    private String hCe = null;
    private int cCx = 0;
    private PostData hkD = null;
    private int hCk = 0;
    private int hCl = 2;
    private int hCm = 0;
    private boolean ciU = true;
    private View.OnClickListener hpi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 1);
                        b.this.hBH.c(sparseArray);
                        return;
                    }
                    b.this.cs(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.hBH.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cca = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            b.this.jF(false);
            b.this.bL(view);
            b.this.jF(true);
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
    protected AdapterView.OnItemLongClickListener hCo = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hCf, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hBl == null) {
                b.this.hBl = new y(b.this.hBH.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hBl.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean nj = b.this.nj(sparseArray.get(d.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.hBl.a(sparseArray, b.this.hBi.bIi(), nj);
            if (nj) {
                b.this.hBl.bLG().setVisibility(0);
                b.this.hBl.bLG().setTag(postData.getId());
            } else {
                b.this.hBl.bLG().setVisibility(8);
            }
            b.this.hBl.bLE().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hCp = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cZ(b.this.hBH.getPageContext().getPageActivity())) {
                if (b.this.hBH.gyx == null || b.this.hBi == null || b.this.hBi.bbG() == null || b.this.hBH.gyx.hl(b.this.hBi.bbG().replyPrivateFlag)) {
                    if (b.this.hBx != null) {
                        b.this.hBx.bgC();
                    }
                    b.this.bOg();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hCf, i);
                        if (postData == null) {
                            b.this.hCg = null;
                        } else {
                            b.this.hCg = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.gyF.setReplyId(str2);
                                b.this.gyF.oZ(str);
                            }
                        }
                        b.this.bOh();
                        return;
                    }
                    b.this.bOi();
                    b.this.hBi.bOE();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dxU = null;
        this.hBG = null;
        this.mListView = null;
        this.hBH = null;
        this.eUC = null;
        this.hBI = null;
        this.hBM = null;
        this.hBU = null;
        this.hBZ = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fnK = null;
        this.hCh = null;
        this.hCi = null;
        this.hCj = null;
        this.hBH = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dxU = (RelativeLayout) LayoutInflater.from(this.hBH.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.hBG = LayoutInflater.from(this.hBH.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.hCh = (RelativeLayout) this.dxU.findViewById(d.g.subpb_editor_tool_comment);
        this.fnK = (TextView) this.dxU.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.fnK.setOnClickListener(this.mCommonClickListener);
        this.hCi = (ImageView) this.dxU.findViewById(d.g.subpb_editor_tool_more_img);
        this.hCj = (ImageView) this.dxU.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.hCj.setOnClickListener(this.mCommonClickListener);
        this.hCi.setOnClickListener(this.mCommonClickListener);
        this.eUC = (NoNetworkView) this.dxU.findViewById(d.g.view_no_network);
        bgK();
        bar();
        this.hBI = (RelativeLayout) this.dxU.findViewById(d.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dxU.findViewById(d.g.new_sub_pb_list);
        this.hBT = (ThreadSkinView) LayoutInflater.from(this.hBH.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hBT);
        this.mListView.addHeaderView(this.hBG);
        this.eKP = BdListViewHelper.a(this.hBH.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hBU = new e(this.hBH.getPageContext());
        this.hBU.aew();
        this.hBZ = this.hBU.getView();
        this.mListView.setNextPage(this.hBU);
        this.hBU.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hCp);
        this.mListView.setOnItemLongClickListener(this.hCo);
        this.mListView.setOnTouchListener(this.cca);
        this.mProgress = (ProgressBar) this.dxU.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hBG != null) {
            this.hBG.setVisibility(4);
        }
        if (this.hBI != null) {
            this.hBI.setVisibility(4);
        }
        this.hBM = com.baidu.tbadk.ala.b.UH().n(this.hBH.getActivity(), 4);
        if (this.hBM != null) {
            this.hBM.setVisibility(8);
            this.hBK.addView(this.hBM, 3);
        }
        this.hCn = new d(this.hBH, this.mListView);
        this.hCn.setFromCDN(this.mIsFromCDN);
        this.hCn.t(this.mCommonClickListener);
        this.hCn.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bar() {
        this.hBK = (LinearLayout) this.hBG.findViewById(d.g.subpb_head_user_info_root);
        this.hBK.setOnClickListener(this.mCommonClickListener);
        this.hBL = (HeadImageView) this.hBG.findViewById(d.g.photo);
        this.hBL.setRadius(l.h(this.hBH.getActivity(), d.e.ds30));
        this.hBL.setClickable(false);
        this.hvX = (ClickableHeaderImageView) this.hBG.findViewById(d.g.god_user_photo);
        this.hvX.setGodIconMargin(0);
        this.hvX.setGodIconWidth(d.e.ds24);
        this.hvX.setRadius(l.h(this.hBH.getActivity(), d.e.ds30));
        this.hvX.setClickable(false);
        this.bUa = (TextView) this.hBG.findViewById(d.g.user_name);
        this.hBN = (ImageView) this.hBG.findViewById(d.g.user_rank);
        this.hBN.setVisibility(8);
        this.hvP = (TextView) this.hBG.findViewById(d.g.floor_owner);
        this.hBJ = (TextView) this.hBG.findViewById(d.g.see_subject);
        this.hBJ.setOnClickListener(this.mCommonClickListener);
        this.hBO = (TextView) this.hBG.findViewById(d.g.floor);
        this.hBP = (TextView) this.hBG.findViewById(d.g.time);
        this.hBQ = (EllipsizeRichTextView) this.hBG.findViewById(d.g.content_text);
        this.hBQ.setOnClickListener(this.mCommonClickListener);
        al.j(this.hBQ, d.C0277d.cp_cont_b);
        this.hBQ.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
        this.hBQ.setLineSpacing(0.0f, 1.25f);
        this.hBR = (TbImageView) this.hBG.findViewById(d.g.sub_pb_image);
        this.hBR.setOnClickListener(this.mCommonClickListener);
        this.hBS = (TextView) this.hBG.findViewById(d.g.advert);
        this.ZZ = (PlayVoiceBntNew) this.hBG.findViewById(d.g.voice_btn);
        this.hBG.setOnTouchListener(this.cca);
        this.hBG.setOnClickListener(this.mCommonClickListener);
    }

    public void jH(boolean z) {
        if (this.eKP != null && this.eKP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eKP.getLayoutParams();
            if (z) {
                bgO();
                layoutParams.height = l.h(this.hBH.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.h(this.hBH.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.eKP.setLayoutParams(layoutParams);
        }
    }

    private void bgO() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0225b interfaceC0225b, boolean z) {
        if (this.hCb != null) {
            this.hCb.dismiss();
            this.hCb = null;
        }
        this.hCb = new com.baidu.tbadk.core.dialog.b(this.hBH.getPageContext().getPageActivity());
        if (z) {
            this.hCb.a(new String[]{this.hBH.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0225b);
        } else {
            this.hCb.a(new String[]{this.hBH.getPageContext().getString(d.j.save_to_emotion), this.hBH.getPageContext().getString(d.j.save_to_local)}, interfaceC0225b);
        }
        this.hCb.d(this.hBH.getPageContext());
        this.hCb.aaZ();
    }

    public void cw(View view) {
        this.hBV = view;
    }

    public View bgP() {
        return this.eKP;
    }

    public void bgK() {
        int h = l.h(this.hBH.getPageContext().getPageActivity(), d.e.ds88);
        int h2 = l.h(this.hBH.getPageContext().getPageActivity(), d.e.ds2);
        this.mNavigationBar = (NavigationBar) this.dxU.findViewById(d.g.view_navigation_bar);
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWb.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bWb != null && (this.bWb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bWb.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.bWb.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aDm() {
        return this.mNavigationBar;
    }

    public void cs(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.hCa == null) {
            this.hCa = new Dialog(this.hBH.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hCa.setCanceledOnTouchOutside(true);
            this.hCa.setCancelable(true);
            View inflate = LayoutInflater.from(this.hBH.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.hBH.getLayoutMode().onModeChanged(inflate);
            this.hCa.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hCa.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.hBH.getPageContext().getPageActivity()) * 0.9d);
            this.hCa.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hCa.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.hCa.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.hCa.findViewById(d.g.disable_reply_btn);
        int i = -1;
        if (sparseArray.get(d.g.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue();
        }
        if ("".equals(sparseArray.get(d.g.tag_del_post_id)) || i == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hCa != null && (b.this.hCa instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCa, b.this.hBH.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) && "".equals(sparseArray.get(d.g.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray3.put(d.g.tag_forbid_user_name_show, sparseArray.get(d.g.tag_forbid_user_name_show));
            sparseArray3.put(d.g.tag_forbid_user_portrait, sparseArray.get(d.g.tag_forbid_user_portrait));
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hCa != null && (b.this.hCa instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCa, b.this.hBH.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hCc != null) {
                        b.this.hCc.m(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show), sparseArray4.get(d.g.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.j.un_mute);
            } else {
                textView3.setText(d.j.mute);
            }
            sparseArray4.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray4.put(d.g.tag_user_mute_mute_nameshow, sparseArray.get(d.g.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hCa != null && (b.this.hCa instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCa, b.this.hBH.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hBH.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hCa, this.hBH.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = d.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.j.report_thread_confirm;
            } else {
                i3 = d.j.del_thread_confirm;
            }
        }
        this.hwx = new com.baidu.tbadk.core.dialog.a(this.hBH.getPageContext().getPageActivity());
        this.hwx.gC(i3);
        this.hwx.Z(sparseArray);
        this.hwx.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hCd != null) {
                    b.this.hCd.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hwx.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwx.dq(true);
        this.hwx.b(this.hBH.getPageContext());
        if (z) {
            this.hwx.aaW();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bbG;
        if (this.hBH != null && sparseArray != null && this.hBG != null) {
            if (this.fzr == null) {
                this.fzr = new com.baidu.tieba.NEGFeedBack.e(this.hBH.getPageContext(), this.hBG);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hBi != null && (bbG = this.hBi.bbG()) != null && bbG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbG.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fzr.setDefaultReasonArray(new String[]{this.hBH.getString(d.j.delete_thread_reason_1), this.hBH.getString(d.j.delete_thread_reason_2), this.hBH.getString(d.j.delete_thread_reason_3), this.hBH.getString(d.j.delete_thread_reason_4), this.hBH.getString(d.j.delete_thread_reason_5)});
            this.fzr.setData(ajVar);
            this.fzr.qj("4");
            this.fzr.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    String x = ap.x(jSONArray);
                    if (b.this.hCd != null) {
                        b.this.hCd.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type), x});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jF(final boolean z) {
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
        this.hCc = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hCd = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hBH.showToast(this.hBH.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.hBH.showToast(str);
        }
    }

    public void bL(View view) {
        if (this.eKP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eKP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.eKP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eKP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.hBH.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.eKP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.alP() != null) {
            this.gyF = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dxU.addView(gVar.alP(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hBx = aVar;
    }

    public void bOg() {
        if (this.mListView != null) {
            this.hCm = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBi == null || this.hBi.bOB() == null) {
            return false;
        }
        if (this.hBi.bIi() != 0) {
            return false;
        }
        return (this.hAn == null || this.hAn.WO() == null || this.hAn.WO().YO() == null || !TextUtils.equals(this.hAn.WO().YO().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bOh() {
        if (this.hBi != null) {
            if ((!bOk() && this.hBZ != null && this.hBZ.isShown()) || v.T(this.hCf)) {
                this.hBi.oo(false);
            } else {
                this.hBi.oo(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hBi = subPbModel;
    }

    public void bOi() {
        b(this.hBH);
        this.mListView.setNextPage(this.hBU);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.pX(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bOk() && this.hBZ != null && this.hBZ.isShown()) {
                i = (this.hCm - this.hCl) - 1;
            } else {
                i = this.hCm - this.hCl;
            }
            int S = v.S(this.hCf);
            if (i > S) {
                i = S;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hCf, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hCm + 2);
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
        return this.dxU;
    }

    public void bMX() {
        if (this.hBW != null) {
            com.baidu.adp.lib.g.g.a(this.hBW, this.hBH.getPageContext().getPageActivity());
        }
        if (this.hBY != null) {
            this.hBY.dismiss();
        }
        if (this.hwx != null) {
            this.hwx.dismiss();
        }
        if (this.hCa != null) {
            com.baidu.adp.lib.g.g.b(this.hCa, this.hBH.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hBl != null) {
            this.hBl.dismiss();
        }
    }

    public void bOj() {
        this.mListView.setNextPage(this.hBU);
        this.hBU.aez();
    }

    public void nc(boolean z) {
        this.hoZ = z;
    }

    public void setIsFromPb(boolean z) {
        this.ciU = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.ciU && this.hBG != null) {
                this.hBG.setVisibility(8);
                this.mListView.removeHeaderView(this.hBG);
                this.hCl = 1;
            }
            this.hAn = jVar;
            if (this.hBG != null) {
                this.hBG.setVisibility(0);
            }
            if (this.hBI != null) {
                this.hBI.setVisibility(0);
            }
            if (jVar.bIA() != null) {
                this.hCe = jVar.bIA().getId();
                this.cCx = jVar.bIA().cep();
                if (this.cCx > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hBH.getResources().getString(d.j.subpb_floor_reply), Integer.valueOf(this.cCx)));
                    if (this.hBH != null) {
                        this.fnK.setText(this.hBH.bMo());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hBH.bOe() ? "PB" : null;
                if (jVar.bIA().Zj() != null) {
                    this.hBT.setData(this.hBH.getPageContext(), jVar.bIA().Zj(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bIG().getId(), jVar.bIG().getName(), jVar.WO().getId(), str));
                } else {
                    this.hBT.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.hBU.aez();
                this.hCn.setHasMoreData(true);
            } else {
                this.hBU.aeA();
                this.hCn.setHasMoreData(false);
            }
            this.hCf = jVar.bIE();
            if (this.hCf == null || this.hCf.size() <= hBF) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hCf.size() - hBF;
                wD(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hCf);
            if (v.T(this.hCf)) {
                this.mListView.setNextPage(null);
                if (this.ciU) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hBU);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.ciU) {
                arrayList.add(0, jVar.bIA());
            }
            this.hCn.b(this.hAn.WO(), arrayList);
            a(jVar.bIA(), jVar.bvr(), jVar.UY(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void wD(int i) {
        if (this.hCf != null) {
            if (this.hCf.size() <= i) {
                this.hCf.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hCf.iterator();
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

    public boolean bOk() {
        return this.hCn.Hy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.ciU) {
            this.hkD = postData;
            if (!StringUtils.isNull(postData.cew())) {
                this.hBR.setVisibility(0);
                this.hBR.startLoad(postData.cew(), 10, true);
            } else {
                this.hBR.setVisibility(8);
            }
            i cey = postData.cey();
            if (cey != null && cey.iFt) {
                this.hBS.setVisibility(0);
            } else {
                this.hBS.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hBG.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hBG.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hBO.setText((CharSequence) null);
            this.bUa.setText((CharSequence) null);
            this.hvP.setVisibility(8);
            if (!this.ciU) {
                c(postData.YO());
                if (z) {
                    this.hvP.setVisibility(0);
                    al.j(this.hvP, d.C0277d.cp_link_tip_a);
                }
            }
            this.hBP.setText(ap.ao(postData.getTime()));
            this.hBO.setText(String.format(this.hBH.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.cep())));
            postData.YO().getUserTbVipInfoData();
            boolean a = a(this.hBQ, postData.cer());
            if (StringUtils.isNull(postData.cew()) && !a && postData.asC() != null) {
                this.ZZ.setVisibility(0);
                this.ZZ.setTag(postData.asC());
                return;
            }
            this.ZZ.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + ab.pN(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bUa.setText(bN(metaData.getSealPrefix(), name_show));
            } else {
                this.bUa.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.hBM != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hBM.setVisibility(8);
                } else {
                    this.hBM.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsM = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hBM.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hvX.setVisibility(0);
                this.hBL.setVisibility(8);
                this.hvX.setUserId(metaData.getUserId());
                this.hvX.setUserName(metaData.getUserName());
                this.hvX.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bUa, d.C0277d.cp_cont_r);
            } else {
                this.hvX.setVisibility(8);
                this.hBL.setVisibility(0);
                this.hBL.setUserId(metaData.getUserId());
                this.hBL.setUserName(metaData.getUserName());
                this.hBL.setDefaultResource(d.f.transparent_bg);
                this.hBL.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.hBL.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bUa, d.C0277d.cp_cont_c);
            }
            this.hBK.setTag(d.g.tag_user_id, metaData.getUserId());
            this.hBK.setTag(d.g.tag_user_name, metaData.getUserName());
            this.hBK.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.ast() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.ast().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.asB());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fu(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cmY());
                        continue;
                    case 17:
                        String str = next.asF().mGifInfo.mSharpText;
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
        if (!tbRichTextData.asK()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.asB() == null || tbRichTextData.asB().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.asB());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hBH.getPageContext().getString(d.j.refresh_view_title_text), this.bul));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hBH.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hBI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.new_pic_emotion_07, l.h(pageActivity, d.e.ds250), l.h(pageActivity, d.e.ds480), l.h(pageActivity, d.e.ds360)), dVar, a);
        }
        this.hBI.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gyF.amM();
        al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hBH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void nQ(int i) {
        b(NoDataViewFactory.d.ad(i, d.j.refresh_view_title_text));
        if (this.hBx != null) {
            this.hBx.cu(this.dxU);
        }
        this.hCh.setVisibility(8);
    }

    public void vj(String str) {
        b(NoDataViewFactory.d.bM(str, this.hBH.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.hBx != null) {
            this.hBx.cu(this.dxU);
        }
        this.hCh.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hCh.setVisibility(0);
            this.dxU.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bul = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0266  */
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
        boolean z7;
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
                String userId2 = postData.YO().getUserId();
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
            if (this.hAn != null && this.hAn.WO() != null && this.hAn.WO().YO() != null && postData.YO() != null) {
                String userId3 = this.hAn.WO().YO().getUserId();
                String userId4 = postData.YO().getUserId();
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
                    userId = postData.YO().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.cep() != 1 ? 0 : 1;
                    if (com.baidu.tieba.pb.pb.main.ap.m(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                        if (postData.YO() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.YO().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.YO().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.YO().getPortrait());
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                    } else {
                        sparseArray.put(d.g.tag_forbid_user_name, "");
                        sparseArray.put(d.g.tag_forbid_user_name_show, "");
                        sparseArray.put(d.g.tag_forbid_user_portrait, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_del_post_is_self, true);
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(d.g.tag_del_post_is_self, false);
                        sparseArray.put(d.g.tag_del_post_type, 0);
                        sparseArray.put(d.g.tag_del_post_id, "");
                    }
                    sparseArray.put(d.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.YO() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.YO().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.YO().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.YO().getPortrait());
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.YO() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YO().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.YO().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YO().getName_show());
                        }
                        if (this.hAn.WO() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hAn.WO().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(d.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.YO().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.cep() != 1) {
            }
            if (com.baidu.tieba.pb.pb.main.ap.m(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(d.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void om(boolean z) {
        if (this.hBl != null && this.hBl.bLE() != null) {
            if (z) {
                this.hBl.bLE().setText(d.j.remove_mark);
            } else {
                this.hBl.bLE().setText(d.j.mark);
            }
        }
    }

    public View bOl() {
        return this.hBZ;
    }

    public void onChangeSkinType(int i) {
        this.hBH.getLayoutMode().setNightMode(i == 1);
        this.hBH.getLayoutMode().onModeChanged(this.dxU);
        this.hBH.getLayoutMode().onModeChanged(this.hBG);
        this.mNavigationBar.onChangeSkinType(this.hBH.getPageContext(), i);
        if (this.hBJ != null) {
            al.j(this.hBJ, d.C0277d.goto_see_subject_color);
        }
        this.eUC.onChangeSkinType(this.hBH.getPageContext(), i);
        this.hBH.getLayoutMode().onModeChanged(this.hBZ);
        al.j(this.hBQ, d.C0277d.cp_cont_b);
        this.hBQ.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
        if (this.gyF != null && this.gyF.alP() != null) {
            this.gyF.alP().onChangeSkinType(i);
        }
        this.hBU.ib(i);
        this.ZZ.bxS();
        al.j(this.fnK, d.C0277d.cp_cont_e);
        al.j(this.hvP, d.C0277d.cp_link_tip_a);
        al.j(this.bUa, d.C0277d.cp_cont_c);
        this.fnK.setAlpha(0.95f);
        if (this.hBV != null) {
            com.baidu.tbadk.r.a.a(this.hBH.getPageContext(), this.hBV);
        }
        if (this.hCn != null) {
            this.hCn.notifyDataSetChanged();
        }
    }

    public void bOm() {
        this.mProgress.setVisibility(0);
    }

    public void bOn() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hBU.aeA();
    }

    public void aYS() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hBU.aYS();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfw = onLongClickListener;
        this.hCn.c(onLongClickListener);
    }

    public View bOo() {
        return this.hBG;
    }

    public TextView bgQ() {
        return this.fnK;
    }

    public ImageView bOp() {
        return this.hCi;
    }

    public ImageView bOq() {
        return this.hCj;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void wE(int i) {
    }

    public View bOr() {
        return this.hBJ;
    }

    public View bOs() {
        return this.hBR;
    }

    public MorePopupWindow bOt() {
        return this.hBW;
    }

    public void showLoadingDialog() {
        if (this.erO == null) {
            this.erO = new com.baidu.tbadk.core.view.b(this.hBH.getPageContext());
        }
        this.erO.dJ(true);
    }

    public void aMt() {
        if (this.erO != null) {
            this.erO.dJ(false);
        }
    }

    public TextView bOu() {
        return this.hBQ;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hBn = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCn.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hCn != null) {
            this.hCn.notifyDataSetChanged();
        }
    }

    public y bOv() {
        return this.hBl;
    }

    public void biO() {
    }

    public void biP() {
    }

    public void onActivityDestroy() {
    }

    public void bOw() {
        if (this.hBH.isPaused()) {
        }
    }

    public View bOx() {
        return this.hBK;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return n.a((Context) this.hBH.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bOy() {
        if (this.gyF == null || this.gyF.alP() == null) {
            return 0;
        }
        return this.gyF.alP().getHeight();
    }
}
