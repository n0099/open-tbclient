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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class b implements KeyboardEventLayout.a {
    private static final int gbi = TbadkCoreApplication.getInst().getListItemRule().FK();
    private com.baidu.tbadk.core.view.d cXS;
    private RelativeLayout ceh;
    private TextView dQw;
    private View dnP;
    private NoNetworkView dxG;
    private com.baidu.tieba.NEGFeedBack.e eaJ;
    private y fMn;
    private View fWf;
    private com.baidu.tbadk.core.dialog.b fWi;
    private j fZO;
    private SubPbModel gaO;
    private View gbA;
    private ArrayList<PostData> gbE;
    private String gbF;
    private RelativeLayout gbG;
    private ImageView gbH;
    private ImageView gbI;
    private d gbM;
    private a gbc;
    private View gbj;
    private NewSubPbActivity gbk;
    private RelativeLayout gbl;
    private View gbp;
    private ThreadSkinView gbw;
    private e gbx;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener ajs = null;
    private TbRichTextView.i gaS = null;
    private NavigationBar mNavigationBar = null;
    private View aJu = null;
    private TextView gbm = null;
    private LinearLayout gbn = null;
    private HeadImageView gbo = null;
    private ClickableHeaderImageView fVy = null;
    private TextView aHt = null;
    private ImageView gbq = null;
    private TextView fVq = null;
    private TextView gbr = null;
    private TextView gbs = null;
    private EllipsizeRichTextView gbt = null;
    private TbImageView gbu = null;
    private PlayVoiceBntNew cOq = null;
    private TextView gbv = null;
    private MorePopupWindow gby = null;
    private am gbz = null;
    private com.baidu.tbadk.core.dialog.b fWh = null;
    private Dialog fVW = null;
    private com.baidu.tbadk.core.dialog.a fVY = null;
    private boolean fOu = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aRU = null;
    private NewSubPbActivity.a gbB = null;
    private NewSubPbActivity.a gbC = null;
    private g eYw = null;
    private String gbD = null;
    private int bnt = 0;
    private PostData fJY = null;
    private int gbJ = 0;
    private int gbK = 2;
    private int gbL = 0;
    private boolean aVi = true;
    private View.OnClickListener fOC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(e.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(e.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(e.g.tag_from, 1);
                        b.this.gbk.b(sparseArray);
                        return;
                    }
                    b.this.bC(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.gbk.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c boq = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.hc(false);
            b.this.aQ(view);
            b.this.hc(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener gbN = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.gbE, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fMn == null) {
                b.this.fMn = new y(b.this.gbk.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fMn.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean kD = b.this.kD(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.fMn.a(sparseArray, b.this.gaO.beF(), kD);
            if (kD) {
                b.this.fMn.bia().setVisibility(0);
                b.this.fMn.bia().setTag(postData.getId());
            } else {
                b.this.fMn.bia().setVisibility(8);
            }
            b.this.fMn.bhY().setVisibility(8);
            b.this.fMn.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener gbO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bG(b.this.gbk.getPageContext().getPageActivity())) {
                if (b.this.gbk.eYo == null || b.this.gaO == null || b.this.gaO.ayn() == null || b.this.gbk.eYo.dw(b.this.gaO.ayn().replyPrivateFlag)) {
                    if (b.this.gbc != null) {
                        b.this.gbc.aDo();
                    }
                    b.this.bkB();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.gbE, i);
                        if (postData == null) {
                            b.this.gbF = null;
                        } else {
                            b.this.gbF = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eYw.setReplyId(str2);
                                b.this.eYw.hG(str);
                            }
                        }
                        b.this.bkC();
                        return;
                    }
                    b.this.bkD();
                    b.this.gaO.bkY();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ceh = null;
        this.gbj = null;
        this.mListView = null;
        this.gbk = null;
        this.dxG = null;
        this.gbl = null;
        this.gbp = null;
        this.gbx = null;
        this.gbA = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dQw = null;
        this.gbG = null;
        this.gbH = null;
        this.gbI = null;
        this.gbk = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.ceh = (RelativeLayout) LayoutInflater.from(this.gbk.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.gbj = LayoutInflater.from(this.gbk.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.gbG = (RelativeLayout) this.ceh.findViewById(e.g.subpb_editor_tool_comment);
        this.dQw = (TextView) this.ceh.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dQw.setOnClickListener(this.mCommonClickListener);
        this.gbH = (ImageView) this.ceh.findViewById(e.g.subpb_editor_tool_more_img);
        this.gbI = (ImageView) this.ceh.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.gbI.setOnClickListener(this.mCommonClickListener);
        this.gbH.setOnClickListener(this.mCommonClickListener);
        this.dxG = (NoNetworkView) this.ceh.findViewById(e.g.view_no_network);
        aDw();
        awX();
        this.gbl = (RelativeLayout) this.ceh.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.ceh.findViewById(e.g.new_sub_pb_list);
        this.gbw = (ThreadSkinView) LayoutInflater.from(this.gbk.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.gbw);
        this.mListView.addHeaderView(this.gbj);
        this.dnP = BdListViewHelper.a(this.gbk.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.gbx = new e(this.gbk.getPageContext());
        this.gbx.DV();
        this.gbA = this.gbx.getView();
        this.mListView.setNextPage(this.gbx);
        this.gbx.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.gbO);
        this.mListView.setOnItemLongClickListener(this.gbN);
        this.mListView.setOnTouchListener(this.boq);
        this.mProgress = (ProgressBar) this.ceh.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gbj != null) {
            this.gbj.setVisibility(4);
        }
        if (this.gbl != null) {
            this.gbl.setVisibility(4);
        }
        this.gbp = com.baidu.tbadk.ala.b.uV().j(this.gbk.getActivity(), 4);
        if (this.gbp != null) {
            this.gbp.setVisibility(8);
            this.gbn.addView(this.gbp, 3);
        }
        this.gbM = new d(this.gbk, this.mListView);
        this.gbM.setFromCDN(this.mIsFromCDN);
        this.gbM.s(this.mCommonClickListener);
        this.gbM.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void awX() {
        this.gbn = (LinearLayout) this.gbj.findViewById(e.g.subpb_head_user_info_root);
        this.gbn.setOnClickListener(this.mCommonClickListener);
        this.gbo = (HeadImageView) this.gbj.findViewById(e.g.photo);
        this.gbo.setRadius(l.h(this.gbk.getActivity(), e.C0200e.ds30));
        this.gbo.setClickable(false);
        this.fVy = (ClickableHeaderImageView) this.gbj.findViewById(e.g.god_user_photo);
        this.fVy.setGodIconMargin(0);
        this.fVy.setGodIconWidth(e.C0200e.ds24);
        this.fVy.setRadius(l.h(this.gbk.getActivity(), e.C0200e.ds30));
        this.fVy.setClickable(false);
        this.aHt = (TextView) this.gbj.findViewById(e.g.user_name);
        this.gbq = (ImageView) this.gbj.findViewById(e.g.user_rank);
        this.gbq.setVisibility(8);
        this.fVq = (TextView) this.gbj.findViewById(e.g.floor_owner);
        this.gbm = (TextView) this.gbj.findViewById(e.g.see_subject);
        this.gbm.setOnClickListener(this.mCommonClickListener);
        this.gbr = (TextView) this.gbj.findViewById(e.g.floor);
        this.gbs = (TextView) this.gbj.findViewById(e.g.time);
        this.gbt = (EllipsizeRichTextView) this.gbj.findViewById(e.g.content_text);
        this.gbt.setOnClickListener(this.mCommonClickListener);
        al.h(this.gbt, e.d.cp_cont_b);
        this.gbt.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.gbt.setLineSpacing(0.0f, 1.25f);
        this.gbu = (TbImageView) this.gbj.findViewById(e.g.sub_pb_image);
        this.gbu.setOnClickListener(this.mCommonClickListener);
        this.gbv = (TextView) this.gbj.findViewById(e.g.advert);
        this.cOq = (PlayVoiceBntNew) this.gbj.findViewById(e.g.voice_btn);
        this.gbj.setOnTouchListener(this.boq);
        this.gbj.setOnClickListener(this.mCommonClickListener);
    }

    public void he(boolean z) {
        if (this.dnP != null && this.dnP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dnP.getLayoutParams();
            if (z) {
                aDA();
                layoutParams.height = l.h(this.gbk.getPageContext().getPageActivity(), e.C0200e.ds88);
            } else {
                layoutParams.height = l.h(this.gbk.getPageContext().getPageActivity(), e.C0200e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dnP.setLayoutParams(layoutParams);
        }
    }

    private void aDA() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0148b interfaceC0148b, boolean z) {
        if (this.fWi != null) {
            this.fWi.dismiss();
            this.fWi = null;
        }
        this.fWi = new com.baidu.tbadk.core.dialog.b(this.gbk.getPageContext().getPageActivity());
        if (z) {
            this.fWi.a(new String[]{this.gbk.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0148b);
        } else {
            this.fWi.a(new String[]{this.gbk.getPageContext().getString(e.j.save_to_emotion), this.gbk.getPageContext().getString(e.j.save_to_local)}, interfaceC0148b);
        }
        this.fWi.d(this.gbk.getPageContext());
        this.fWi.AE();
    }

    public void bE(View view) {
        this.fWf = view;
    }

    public View aDB() {
        return this.dnP;
    }

    public void aDw() {
        int h = l.h(this.gbk.getPageContext().getPageActivity(), e.C0200e.ds88);
        int h2 = l.h(this.gbk.getPageContext().getPageActivity(), e.C0200e.ds2);
        this.mNavigationBar = (NavigationBar) this.ceh.findViewById(e.g.view_navigation_bar);
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJu.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aJu != null && (this.aJu.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aJu.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.aJu.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aaO() {
        return this.mNavigationBar;
    }

    public void bC(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fVW == null) {
            this.fVW = new Dialog(this.gbk.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fVW.setCanceledOnTouchOutside(true);
            this.fVW.setCancelable(true);
            View inflate = LayoutInflater.from(this.gbk.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.gbk.getLayoutMode().onModeChanged(inflate);
            this.fVW.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fVW.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.gbk.getPageContext().getPageActivity()) * 0.9d);
            this.fVW.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fVW.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fVW.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fVW.findViewById(e.g.disable_reply_btn);
        int i = -1;
        if (sparseArray.get(e.g.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(e.g.tag_check_mute_from)).intValue();
        }
        if ("".equals(sparseArray.get(e.g.tag_del_post_id)) || i == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(e.g.tag_del_post_id, sparseArray.get(e.g.tag_del_post_id));
            sparseArray2.put(e.g.tag_del_post_type, sparseArray.get(e.g.tag_del_post_type));
            sparseArray2.put(e.g.tag_del_post_is_self, sparseArray.get(e.g.tag_del_post_is_self));
            sparseArray2.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fVW != null && (b.this.fVW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fVW, b.this.gbk.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(e.g.tag_del_post_id), ((Integer) sparseArray3.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(e.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(e.g.tag_forbid_user_name)) && "".equals(sparseArray.get(e.g.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(e.g.tag_forbid_user_name, sparseArray.get(e.g.tag_forbid_user_name));
            sparseArray3.put(e.g.tag_forbid_user_name_show, sparseArray.get(e.g.tag_forbid_user_name_show));
            sparseArray3.put(e.g.tag_forbid_user_portrait, sparseArray.get(e.g.tag_forbid_user_portrait));
            sparseArray3.put(e.g.tag_manage_user_identity, sparseArray.get(e.g.tag_manage_user_identity));
            sparseArray3.put(e.g.tag_forbid_user_post_id, sparseArray.get(e.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fVW != null && (b.this.fVW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fVW, b.this.gbk.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.gbB != null) {
                        b.this.gbB.m(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(e.j.un_mute);
            } else {
                textView3.setText(e.j.mute);
            }
            sparseArray4.put(e.g.tag_is_mem, sparseArray.get(e.g.tag_is_mem));
            sparseArray4.put(e.g.tag_user_mute_mute_userid, sparseArray.get(e.g.tag_user_mute_mute_userid));
            sparseArray4.put(e.g.tag_user_mute_mute_username, sparseArray.get(e.g.tag_user_mute_mute_username));
            sparseArray4.put(e.g.tag_user_mute_post_id, sparseArray.get(e.g.tag_user_mute_post_id));
            sparseArray4.put(e.g.tag_user_mute_thread_id, sparseArray.get(e.g.tag_user_mute_thread_id));
            sparseArray4.put(e.g.tag_user_mute_mute_nameshow, sparseArray.get(e.g.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fVW != null && (b.this.fVW instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fVW, b.this.gbk.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.gbk.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fVW, this.gbk.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(e.g.tag_del_post_id, str);
        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = e.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = e.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = e.j.report_thread_confirm;
            } else {
                i3 = e.j.del_thread_confirm;
            }
        }
        this.fVY = new com.baidu.tbadk.core.dialog.a(this.gbk.getPageContext().getPageActivity());
        this.fVY.cN(i3);
        this.fVY.H(sparseArray);
        this.fVY.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.gbC != null) {
                    b.this.gbC.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fVY.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fVY.be(true);
        this.fVY.b(this.gbk.getPageContext());
        if (z) {
            this.fVY.AB();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData ayn;
        if (this.gbk != null && sparseArray != null && this.gbj != null) {
            if (this.eaJ == null) {
                this.eaJ = new com.baidu.tieba.NEGFeedBack.e(this.gbk.getPageContext(), this.gbj);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.gaO != null && (ayn = this.gaO.ayn()) != null && ayn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayn.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.eaJ.setDefaultReasonArray(new String[]{this.gbk.getString(e.j.delete_thread_reason_1), this.gbk.getString(e.j.delete_thread_reason_2), this.gbk.getString(e.j.delete_thread_reason_3), this.gbk.getString(e.j.delete_thread_reason_4), this.gbk.getString(e.j.delete_thread_reason_5)});
            this.eaJ.setData(ahVar);
            this.eaJ.iP("4");
            this.eaJ.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    String i2 = ao.i(jSONArray);
                    if (b.this.gbC != null) {
                        b.this.gbC.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), i2});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(final boolean z) {
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
        this.gbB = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gbC = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.gbk.showToast(this.gbk.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.gbk.showToast(str);
        }
    }

    public void aQ(View view) {
        if (this.dnP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dnP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dnP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dnP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.gbk.getActivity(), e.C0200e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dnP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.KT() != null) {
            this.eYw = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ceh.addView(gVar.KT(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.gbc = aVar;
    }

    public void bkB() {
        if (this.mListView != null) {
            this.gbL = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kD(boolean z) {
        if (this.gaO == null || this.gaO.bkV() == null) {
            return false;
        }
        if (this.gaO.beF() != 0) {
            return false;
        }
        return (this.fZO == null || this.fZO.YL() == null || this.fZO.YL().yC() == null || !TextUtils.equals(this.fZO.YL().yC().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bkC() {
        if (this.gaO != null) {
            if ((!bkF() && this.gbA != null && this.gbA.isShown()) || v.I(this.gbE)) {
                this.gaO.lL(false);
            } else {
                this.gaO.lL(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.gaO = subPbModel;
    }

    public void bkD() {
        a(this.gbk);
        this.mListView.setNextPage(this.gbx);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.nr(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bkF() && this.gbA != null && this.gbA.isShown()) {
                i = (this.gbL - this.gbK) - 1;
            } else {
                i = this.gbL - this.gbK;
            }
            int H = v.H(this.gbE);
            if (i > H) {
                i = H;
            }
            ArrayList arrayList = new ArrayList(v.b(this.gbE, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.gbL + 2);
            this.mListView.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ceh;
    }

    public void bjt() {
        if (this.gby != null) {
            com.baidu.adp.lib.g.g.a(this.gby, this.gbk.getPageContext().getPageActivity());
        }
        if (this.fWh != null) {
            this.fWh.dismiss();
        }
        if (this.fVY != null) {
            this.fVY.dismiss();
        }
        if (this.fVW != null) {
            com.baidu.adp.lib.g.g.b(this.fVW, this.gbk.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fMn != null) {
            this.fMn.dismiss();
        }
    }

    public void bkE() {
        this.mListView.setNextPage(this.gbx);
        this.gbx.DY();
    }

    public void kw(boolean z) {
        this.fOu = z;
    }

    public void setIsFromPb(boolean z) {
        this.aVi = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.aVi && this.gbj != null) {
                this.gbj.setVisibility(8);
                this.mListView.removeHeaderView(this.gbj);
                this.gbK = 1;
            }
            this.fZO = jVar;
            if (this.gbj != null) {
                this.gbj.setVisibility(0);
            }
            if (this.gbl != null) {
                this.gbl.setVisibility(0);
            }
            if (jVar.bfa() != null) {
                this.gbD = jVar.bfa().getId();
                this.bnt = jVar.bfa().bBx();
                if (this.bnt > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.gbk.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.bnt)));
                    this.dQw.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.gbk.bkA() ? "PB" : null;
                if (jVar.bfa().yY() != null) {
                    this.gbw.setData(this.gbk.getPageContext(), jVar.bfa().yY(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bfg().getId(), jVar.bfg().getName(), jVar.YL().getId(), str));
                } else {
                    this.gbw.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.gbx.DY();
                this.gbM.setHasMoreData(true);
            } else {
                this.gbx.DZ();
                this.gbM.setHasMoreData(false);
            }
            this.gbE = jVar.bfe();
            if (this.gbE == null || this.gbE.size() <= gbi) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gbE.size() - gbi;
                sm(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gbE);
            if (v.I(this.gbE)) {
                this.mListView.setNextPage(null);
                if (this.aVi) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.gbx);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aVi) {
                arrayList.add(0, jVar.bfa());
            }
            this.gbM.a(this.fZO.YL(), arrayList);
            a(jVar.bfa(), jVar.aRK(), jVar.vm(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void sm(int i) {
        if (this.gbE != null) {
            if (this.gbE.size() <= i) {
                this.gbE.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gbE.iterator();
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

    public boolean bkF() {
        return this.gbM.hasMoreData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aVi) {
            this.fJY = postData;
            if (!StringUtils.isNull(postData.bBE())) {
                this.gbu.setVisibility(0);
                this.gbu.startLoad(postData.bBE(), 10, true);
            } else {
                this.gbu.setVisibility(8);
            }
            h bBG = postData.bBG();
            if (bBG != null && bBG.hea) {
                this.gbv.setVisibility(0);
            } else {
                this.gbv.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.gbj.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.gbj.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.gbr.setText((CharSequence) null);
            this.aHt.setText((CharSequence) null);
            this.fVq.setVisibility(8);
            if (!this.aVi) {
                c(postData.yC());
                if (z) {
                    this.fVq.setVisibility(0);
                    al.h(this.fVq, e.d.cp_link_tip_a);
                }
            }
            this.gbs.setText(ao.E(postData.getTime()));
            this.gbr.setText(String.format(this.gbk.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.bBx())));
            postData.yC().getUserTbVipInfoData();
            boolean a = a(this.gbt, postData.bBz());
            if (StringUtils.isNull(postData.bBE()) && !a && postData.Rb() != null) {
                this.cOq.setVisibility(0);
                this.cOq.setTag(postData.Rb());
                return;
            }
            this.cOq.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.y.it(name_show) > 14) {
                name_show = com.baidu.tbadk.util.y.o(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aHt.setText(aB(metaData.getSealPrefix(), name_show));
            } else {
                this.aHt.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.gbp != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.gbp.setVisibility(8);
                } else {
                    this.gbp.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aig = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.gbp.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fVy.setVisibility(0);
                this.gbo.setVisibility(8);
                this.fVy.setUserId(metaData.getUserId());
                this.fVy.setUserName(metaData.getUserName());
                this.fVy.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aHt, e.d.cp_cont_r);
            } else {
                this.fVy.setVisibility(8);
                this.gbo.setVisibility(0);
                this.gbo.setUserId(metaData.getUserId());
                this.gbo.setUserName(metaData.getUserName());
                this.gbo.setDefaultResource(e.f.transparent_bg);
                this.gbo.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.gbo.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aHt, e.d.cp_cont_c);
            }
            this.gbn.setTag(e.g.tag_user_id, metaData.getUserId());
            this.gbn.setTag(e.g.tag_user_name, metaData.getUserName());
            this.gbn.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.QT() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.QT().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Ra());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.da(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bJV());
                        continue;
                    case 17:
                        String str = next.Re().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Rj()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Ra() == null || tbRichTextData.Ra().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Ra());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gbk.getPageContext().getString(e.j.refresh_view_title_text), this.ajs));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.gbk.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.gbl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0200e.ds250), l.h(pageActivity, e.C0200e.ds480), l.h(pageActivity, e.C0200e.ds360)), dVar, a);
        }
        this.gbl.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eYw.LP();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.gbk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void jJ(int i) {
        b(NoDataViewFactory.d.G(i, e.j.refresh_view_title_text));
        if (this.gbc != null) {
            this.gbc.bF(this.ceh);
        }
        this.gbG.setVisibility(8);
    }

    public void nN(String str) {
        b(NoDataViewFactory.d.aA(str, this.gbk.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.gbc != null) {
            this.gbc.bF(this.ceh);
        }
        this.gbG.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.gbG.setVisibility(0);
            this.ceh.setOnTouchListener(null);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.ajs = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0262  */
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
                String userId2 = postData.yC().getUserId();
                boolean z8 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z8;
                    z = true;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.fZO != null && this.fZO.YL() != null && this.fZO.YL().yC() != null && postData.yC() != null) {
                String userId3 = this.fZO.YL().yC().getUserId();
                String userId4 = postData.yC().getUserId();
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
                    userId = postData.yC().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bBx() != 1 ? 0 : 1;
                    if (aq.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                        if (postData.yC() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yC().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yC().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yC().getPortrait());
                            z7 = true;
                        } else {
                            z7 = true;
                        }
                    } else {
                        sparseArray.put(e.g.tag_forbid_user_name, "");
                        sparseArray.put(e.g.tag_forbid_user_name_show, "");
                        sparseArray.put(e.g.tag_forbid_user_portrait, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(e.g.tag_del_post_is_self, true);
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(e.g.tag_del_post_is_self, false);
                        sparseArray.put(e.g.tag_del_post_type, 0);
                        sparseArray.put(e.g.tag_del_post_id, "");
                    }
                    sparseArray.put(e.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(e.g.tag_should_manage_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.yC() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yC().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yC().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yC().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yC() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yC().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.yC().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yC().getName_show());
                        }
                        if (this.fZO.YL() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fZO.YL().getId());
                        }
                        sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(e.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(e.g.tag_should_delete_visible, true);
                        sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(e.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(e.g.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(e.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.yC().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bBx() != 1) {
            }
            if (aq.k(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(e.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void lJ(boolean z) {
        if (this.fMn != null && this.fMn.bhY() != null) {
            if (z) {
                this.fMn.bhY().setText(e.j.remove_mark);
            } else {
                this.fMn.bhY().setText(e.j.mark);
            }
            this.fMn.refreshUI();
        }
    }

    public View bkG() {
        return this.gbA;
    }

    public void onChangeSkinType(int i) {
        this.gbk.getLayoutMode().setNightMode(i == 1);
        this.gbk.getLayoutMode().onModeChanged(this.ceh);
        this.gbk.getLayoutMode().onModeChanged(this.gbj);
        this.mNavigationBar.onChangeSkinType(this.gbk.getPageContext(), i);
        if (this.gbm != null) {
            al.h(this.gbm, e.d.goto_see_subject_color);
        }
        this.dxG.onChangeSkinType(this.gbk.getPageContext(), i);
        this.gbk.getLayoutMode().onModeChanged(this.gbA);
        al.h(this.gbt, e.d.cp_cont_b);
        this.gbt.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.eYw != null && this.eYw.KT() != null) {
            this.eYw.KT().onChangeSkinType(i);
        }
        this.gbx.ek(i);
        this.cOq.aUo();
        al.h(this.dQw, e.d.cp_cont_e);
        al.h(this.fVq, e.d.cp_link_tip_a);
        al.h(this.aHt, e.d.cp_cont_c);
        this.dQw.setAlpha(0.95f);
        if (this.fWf != null) {
            com.baidu.tbadk.o.a.a(this.gbk.getPageContext(), this.fWf);
        }
        if (this.gbM != null) {
            this.gbM.notifyDataSetChanged();
        }
    }

    public void bkH() {
        this.mProgress.setVisibility(0);
    }

    public void bkI() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gbx.DZ();
    }

    public void avu() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gbx.avu();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aRU = onLongClickListener;
        this.gbM.c(onLongClickListener);
    }

    public View bkJ() {
        return this.gbj;
    }

    public TextView aDC() {
        return this.dQw;
    }

    public ImageView bkK() {
        return this.gbH;
    }

    public ImageView bkL() {
        return this.gbI;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void sn(int i) {
    }

    public View bkM() {
        return this.gbm;
    }

    public View bkN() {
        return this.gbu;
    }

    public MorePopupWindow bkO() {
        return this.gby;
    }

    public void showLoadingDialog() {
        if (this.cXS == null) {
            this.cXS = new com.baidu.tbadk.core.view.d(this.gbk.getPageContext());
        }
        this.cXS.bz(true);
    }

    public void ajH() {
        if (this.cXS != null) {
            this.cXS.bz(false);
        }
    }

    public TextView bkP() {
        return this.gbt;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.gaS = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gbM.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.gbM != null) {
            this.gbM.notifyDataSetChanged();
        }
    }

    public y bkQ() {
        return this.fMn;
    }

    public void aCo() {
    }

    public void aCp() {
    }

    public void onActivityDestroy() {
    }

    public void bkR() {
        if (this.gbk.isPaused()) {
        }
    }

    public View bkS() {
        return this.gbn;
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.gbk.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
