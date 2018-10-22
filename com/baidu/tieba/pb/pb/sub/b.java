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
    private static final int fZM = TbadkCoreApplication.getInst().getListItemRule().Fy();
    private com.baidu.tbadk.core.view.d cWM;
    private RelativeLayout cdS;
    private TextView dPt;
    private com.baidu.tieba.NEGFeedBack.e dZq;
    private View dmK;
    private NoNetworkView dwo;
    private y fKO;
    private View fUG;
    private com.baidu.tbadk.core.dialog.b fUJ;
    private j fYp;
    private a fZG;
    private View fZN;
    private NewSubPbActivity fZO;
    private RelativeLayout fZP;
    private View fZT;
    private SubPbModel fZs;
    private ThreadSkinView gaa;
    private e gab;
    private View gae;
    private ArrayList<PostData> gai;
    private String gaj;
    private RelativeLayout gak;
    private ImageView gal;
    private ImageView gam;
    private d gaq;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener aiF = null;
    private TbRichTextView.i fZw = null;
    private NavigationBar mNavigationBar = null;
    private View aIE = null;
    private TextView fZQ = null;
    private LinearLayout fZR = null;
    private HeadImageView fZS = null;
    private ClickableHeaderImageView fTZ = null;
    private TextView aGD = null;
    private ImageView fZU = null;
    private TextView fTR = null;
    private TextView fZV = null;
    private TextView fZW = null;
    private EllipsizeRichTextView fZX = null;
    private TbImageView fZY = null;
    private PlayVoiceBntNew cNk = null;
    private TextView fZZ = null;
    private MorePopupWindow gac = null;
    private am gad = null;
    private com.baidu.tbadk.core.dialog.b fUI = null;
    private Dialog fUx = null;
    private com.baidu.tbadk.core.dialog.a fUz = null;
    private boolean fMV = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aRe = null;
    private NewSubPbActivity.a gaf = null;
    private NewSubPbActivity.a gag = null;
    private g eXe = null;
    private String gah = null;
    private int bmH = 0;
    private PostData fIA = null;
    private int gan = 0;
    private int gao = 2;
    private int gap = 0;
    private boolean aUs = true;
    private View.OnClickListener fNd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.fZO.b(sparseArray);
                        return;
                    }
                    b.this.bA(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.fZO.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bnE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.gT(false);
            b.this.aO(view);
            b.this.gT(true);
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
    protected AdapterView.OnItemLongClickListener gar = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.gai, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fKO == null) {
                b.this.fKO = new y(b.this.fZO.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fKO.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean ks = b.this.ks(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.fKO.a(sparseArray, b.this.fZs.bfh(), ks);
            if (ks) {
                b.this.fKO.biD().setVisibility(0);
                b.this.fKO.biD().setTag(postData.getId());
            } else {
                b.this.fKO.biD().setVisibility(8);
            }
            b.this.fKO.biB().setVisibility(8);
            b.this.fKO.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener gas = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bI(b.this.fZO.getPageContext().getPageActivity())) {
                if (b.this.fZO.eWW == null || b.this.fZs == null || b.this.fZs.ayQ() == null || b.this.fZO.eWW.di(b.this.fZs.ayQ().replyPrivateFlag)) {
                    if (b.this.fZG != null) {
                        b.this.fZG.aDU();
                    }
                    b.this.blf();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.gai, i);
                        if (postData == null) {
                            b.this.gaj = null;
                        } else {
                            b.this.gaj = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eXe.setReplyId(str2);
                                b.this.eXe.hF(str);
                            }
                        }
                        b.this.blg();
                        return;
                    }
                    b.this.blh();
                    b.this.fZs.blC();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.cdS = null;
        this.fZN = null;
        this.mListView = null;
        this.fZO = null;
        this.dwo = null;
        this.fZP = null;
        this.fZT = null;
        this.gab = null;
        this.gae = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dPt = null;
        this.gak = null;
        this.gal = null;
        this.gam = null;
        this.fZO = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.cdS = (RelativeLayout) LayoutInflater.from(this.fZO.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.fZN = LayoutInflater.from(this.fZO.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.gak = (RelativeLayout) this.cdS.findViewById(e.g.subpb_editor_tool_comment);
        this.dPt = (TextView) this.cdS.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dPt.setOnClickListener(this.mCommonClickListener);
        this.gal = (ImageView) this.cdS.findViewById(e.g.subpb_editor_tool_more_img);
        this.gam = (ImageView) this.cdS.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.gam.setOnClickListener(this.mCommonClickListener);
        this.gal.setOnClickListener(this.mCommonClickListener);
        this.dwo = (NoNetworkView) this.cdS.findViewById(e.g.view_no_network);
        aEc();
        axy();
        this.fZP = (RelativeLayout) this.cdS.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.cdS.findViewById(e.g.new_sub_pb_list);
        this.gaa = (ThreadSkinView) LayoutInflater.from(this.fZO.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.gaa);
        this.mListView.addHeaderView(this.fZN);
        this.dmK = BdListViewHelper.a(this.fZO.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.gab = new e(this.fZO.getPageContext());
        this.gab.DL();
        this.gae = this.gab.getView();
        this.mListView.setNextPage(this.gab);
        this.gab.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.gas);
        this.mListView.setOnItemLongClickListener(this.gar);
        this.mListView.setOnTouchListener(this.bnE);
        this.mProgress = (ProgressBar) this.cdS.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fZN != null) {
            this.fZN.setVisibility(4);
        }
        if (this.fZP != null) {
            this.fZP.setVisibility(4);
        }
        this.fZT = com.baidu.tbadk.ala.b.uL().j(this.fZO.getActivity(), 4);
        if (this.fZT != null) {
            this.fZT.setVisibility(8);
            this.fZR.addView(this.fZT, 3);
        }
        this.gaq = new d(this.fZO, this.mListView);
        this.gaq.setFromCDN(this.mIsFromCDN);
        this.gaq.q(this.mCommonClickListener);
        this.gaq.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void axy() {
        this.fZR = (LinearLayout) this.fZN.findViewById(e.g.subpb_head_user_info_root);
        this.fZR.setOnClickListener(this.mCommonClickListener);
        this.fZS = (HeadImageView) this.fZN.findViewById(e.g.photo);
        this.fZS.setRadius(l.h(this.fZO.getActivity(), e.C0175e.ds30));
        this.fZS.setClickable(false);
        this.fTZ = (ClickableHeaderImageView) this.fZN.findViewById(e.g.god_user_photo);
        this.fTZ.setGodIconMargin(0);
        this.fTZ.setGodIconWidth(e.C0175e.ds24);
        this.fTZ.setRadius(l.h(this.fZO.getActivity(), e.C0175e.ds30));
        this.fTZ.setClickable(false);
        this.aGD = (TextView) this.fZN.findViewById(e.g.user_name);
        this.fZU = (ImageView) this.fZN.findViewById(e.g.user_rank);
        this.fZU.setVisibility(8);
        this.fTR = (TextView) this.fZN.findViewById(e.g.floor_owner);
        this.fZQ = (TextView) this.fZN.findViewById(e.g.see_subject);
        this.fZQ.setOnClickListener(this.mCommonClickListener);
        this.fZV = (TextView) this.fZN.findViewById(e.g.floor);
        this.fZW = (TextView) this.fZN.findViewById(e.g.time);
        this.fZX = (EllipsizeRichTextView) this.fZN.findViewById(e.g.content_text);
        this.fZX.setOnClickListener(this.mCommonClickListener);
        al.h(this.fZX, e.d.cp_cont_b);
        this.fZX.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.fZX.setLineSpacing(0.0f, 1.25f);
        this.fZY = (TbImageView) this.fZN.findViewById(e.g.sub_pb_image);
        this.fZY.setOnClickListener(this.mCommonClickListener);
        this.fZZ = (TextView) this.fZN.findViewById(e.g.advert);
        this.cNk = (PlayVoiceBntNew) this.fZN.findViewById(e.g.voice_btn);
        this.fZN.setOnTouchListener(this.bnE);
        this.fZN.setOnClickListener(this.mCommonClickListener);
    }

    public void gV(boolean z) {
        if (this.dmK != null && this.dmK.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dmK.getLayoutParams();
            if (z) {
                aEg();
                layoutParams.height = l.h(this.fZO.getPageContext().getPageActivity(), e.C0175e.ds88);
            } else {
                layoutParams.height = l.h(this.fZO.getPageContext().getPageActivity(), e.C0175e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dmK.setLayoutParams(layoutParams);
        }
    }

    private void aEg() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0124b interfaceC0124b, boolean z) {
        if (this.fUJ != null) {
            this.fUJ.dismiss();
            this.fUJ = null;
        }
        this.fUJ = new com.baidu.tbadk.core.dialog.b(this.fZO.getPageContext().getPageActivity());
        if (z) {
            this.fUJ.a(new String[]{this.fZO.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0124b);
        } else {
            this.fUJ.a(new String[]{this.fZO.getPageContext().getString(e.j.save_to_emotion), this.fZO.getPageContext().getString(e.j.save_to_local)}, interfaceC0124b);
        }
        this.fUJ.d(this.fZO.getPageContext());
        this.fUJ.Ax();
    }

    public void bC(View view) {
        this.fUG = view;
    }

    public View aEh() {
        return this.dmK;
    }

    public void aEc() {
        int h = l.h(this.fZO.getPageContext().getPageActivity(), e.C0175e.ds88);
        int h2 = l.h(this.fZO.getPageContext().getPageActivity(), e.C0175e.ds2);
        this.mNavigationBar = (NavigationBar) this.cdS.findViewById(e.g.view_navigation_bar);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIE.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aIE != null && (this.aIE.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aIE.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.aIE.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aaE() {
        return this.mNavigationBar;
    }

    public void bA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fUx == null) {
            this.fUx = new Dialog(this.fZO.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fUx.setCanceledOnTouchOutside(true);
            this.fUx.setCancelable(true);
            View inflate = LayoutInflater.from(this.fZO.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.fZO.getLayoutMode().onModeChanged(inflate);
            this.fUx.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fUx.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.fZO.getPageContext().getPageActivity()) * 0.9d);
            this.fUx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUx.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fUx.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUx.findViewById(e.g.disable_reply_btn);
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
                    if (b.this.fUx != null && (b.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fUx, b.this.fZO.getPageContext());
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
                    if (b.this.fUx != null && (b.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fUx, b.this.fZO.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.gaf != null) {
                        b.this.gaf.m(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
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
                    if (b.this.fUx != null && (b.this.fUx instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fUx, b.this.fZO.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.fZO.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fUx, this.fZO.getPageContext());
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
        this.fUz = new com.baidu.tbadk.core.dialog.a(this.fZO.getPageContext().getPageActivity());
        this.fUz.cz(i3);
        this.fUz.H(sparseArray);
        this.fUz.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.gag != null) {
                    b.this.gag.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fUz.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUz.aO(true);
        this.fUz.b(this.fZO.getPageContext());
        if (z) {
            this.fUz.Au();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData ayQ;
        if (this.fZO != null && sparseArray != null && this.fZN != null) {
            if (this.dZq == null) {
                this.dZq = new com.baidu.tieba.NEGFeedBack.e(this.fZO.getPageContext(), this.fZN);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.fZs != null && (ayQ = this.fZs.ayQ()) != null && ayQ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayQ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.dZq.setDefaultReasonArray(new String[]{this.fZO.getString(e.j.delete_thread_reason_1), this.fZO.getString(e.j.delete_thread_reason_2), this.fZO.getString(e.j.delete_thread_reason_3), this.fZO.getString(e.j.delete_thread_reason_4), this.fZO.getString(e.j.delete_thread_reason_5)});
            this.dZq.setData(ahVar);
            this.dZq.iN("4");
            this.dZq.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void k(JSONArray jSONArray) {
                    String i2 = ao.i(jSONArray);
                    if (b.this.gag != null) {
                        b.this.gag.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), i2});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT(final boolean z) {
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
        this.gaf = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gag = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fZO.showToast(this.fZO.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.fZO.showToast(str);
        }
    }

    public void aO(View view) {
        if (this.dmK != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dmK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dmK);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dmK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.fZO.getActivity(), e.C0175e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dmK, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.KH() != null) {
            this.eXe = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cdS.addView(gVar.KH(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fZG = aVar;
    }

    public void blf() {
        if (this.mListView != null) {
            this.gap = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ks(boolean z) {
        if (this.fZs == null || this.fZs.blz() == null) {
            return false;
        }
        if (this.fZs.bfh() != 0) {
            return false;
        }
        return (this.fYp == null || this.fYp.YB() == null || this.fYp.YB().yv() == null || !TextUtils.equals(this.fYp.YB().yv().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void blg() {
        if (this.fZs != null) {
            if ((!blj() && this.gae != null && this.gae.isShown()) || v.J(this.gai)) {
                this.fZs.lA(false);
            } else {
                this.fZs.lA(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fZs = subPbModel;
    }

    public void blh() {
        a(this.fZO);
        this.mListView.setNextPage(this.gab);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.ng(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!blj() && this.gae != null && this.gae.isShown()) {
                i = (this.gap - this.gao) - 1;
            } else {
                i = this.gap - this.gao;
            }
            int I = v.I(this.gai);
            if (i > I) {
                i = I;
            }
            ArrayList arrayList = new ArrayList(v.b(this.gai, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.gap + 2);
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
        return this.cdS;
    }

    public void bjW() {
        if (this.gac != null) {
            com.baidu.adp.lib.g.g.a(this.gac, this.fZO.getPageContext().getPageActivity());
        }
        if (this.fUI != null) {
            this.fUI.dismiss();
        }
        if (this.fUz != null) {
            this.fUz.dismiss();
        }
        if (this.fUx != null) {
            com.baidu.adp.lib.g.g.b(this.fUx, this.fZO.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fKO != null) {
            this.fKO.dismiss();
        }
    }

    public void bli() {
        this.mListView.setNextPage(this.gab);
        this.gab.DO();
    }

    public void kl(boolean z) {
        this.fMV = z;
    }

    public void setIsFromPb(boolean z) {
        this.aUs = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.aUs && this.fZN != null) {
                this.fZN.setVisibility(8);
                this.mListView.removeHeaderView(this.fZN);
                this.gao = 1;
            }
            this.fYp = jVar;
            if (this.fZN != null) {
                this.fZN.setVisibility(0);
            }
            if (this.fZP != null) {
                this.fZP.setVisibility(0);
            }
            if (jVar.bfC() != null) {
                this.gah = jVar.bfC().getId();
                this.bmH = jVar.bfC().bCb();
                if (this.bmH > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fZO.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.bmH)));
                    this.dPt.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.fZO.ble() ? "PB" : null;
                if (jVar.bfC().yR() != null) {
                    this.gaa.setData(this.fZO.getPageContext(), jVar.bfC().yR(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bfJ().getId(), jVar.bfJ().getName(), jVar.YB().getId(), str));
                } else {
                    this.gaa.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.gab.DO();
                this.gaq.setHasMoreData(true);
            } else {
                this.gab.DP();
                this.gaq.setHasMoreData(false);
            }
            this.gai = jVar.bfG();
            if (this.gai == null || this.gai.size() <= fZM) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gai.size() - fZM;
                rT(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gai);
            if (v.J(this.gai)) {
                this.mListView.setNextPage(null);
                if (this.aUs) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.gab);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aUs) {
                arrayList.add(0, jVar.bfC());
            }
            this.gaq.a(this.fYp.YB(), arrayList);
            a(jVar.bfC(), jVar.aSn(), jVar.vc(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void rT(int i) {
        if (this.gai != null) {
            if (this.gai.size() <= i) {
                this.gai.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gai.iterator();
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

    public boolean blj() {
        return this.gaq.hasMoreData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aUs) {
            this.fIA = postData;
            if (!StringUtils.isNull(postData.bCi())) {
                this.fZY.setVisibility(0);
                this.fZY.startLoad(postData.bCi(), 10, true);
            } else {
                this.fZY.setVisibility(8);
            }
            h bCk = postData.bCk();
            if (bCk != null && bCk.hcD) {
                this.fZZ.setVisibility(0);
            } else {
                this.fZZ.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fZN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fZN.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fZV.setText((CharSequence) null);
            this.aGD.setText((CharSequence) null);
            this.fTR.setVisibility(8);
            if (!this.aUs) {
                c(postData.yv());
                if (z) {
                    this.fTR.setVisibility(0);
                    al.h(this.fTR, e.d.cp_link_tip_a);
                }
            }
            this.fZW.setText(ao.C(postData.getTime()));
            this.fZV.setText(String.format(this.fZO.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.bCb())));
            postData.yv().getUserTbVipInfoData();
            boolean a = a(this.fZX, postData.bCd());
            if (StringUtils.isNull(postData.bCi()) && !a && postData.QS() != null) {
                this.cNk.setVisibility(0);
                this.cNk.setTag(postData.QS());
                return;
            }
            this.cNk.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.y.is(name_show) > 14) {
                name_show = com.baidu.tbadk.util.y.o(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aGD.setText(aB(metaData.getSealPrefix(), name_show));
            } else {
                this.aGD.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fZT != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fZT.setVisibility(8);
                } else {
                    this.fZT.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aht = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fZT.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fTZ.setVisibility(0);
                this.fZS.setVisibility(8);
                this.fTZ.setUserId(metaData.getUserId());
                this.fTZ.setUserName(metaData.getUserName());
                this.fTZ.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aGD, e.d.cp_cont_r);
            } else {
                this.fTZ.setVisibility(8);
                this.fZS.setVisibility(0);
                this.fZS.setUserId(metaData.getUserId());
                this.fZS.setUserName(metaData.getUserName());
                this.fZS.setDefaultResource(e.f.transparent_bg);
                this.fZS.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.fZS.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aGD, e.d.cp_cont_c);
            }
            this.fZR.setTag(e.g.tag_user_id, metaData.getUserId());
            this.fZR.setTag(e.g.tag_user_name, metaData.getUserName());
            this.fZR.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.QK() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.QK().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.QR());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cJ(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bKw());
                        continue;
                    case 17:
                        String str = next.QV().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Ra()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.QR() == null || tbRichTextData.QR().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.QR());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fZO.getPageContext().getString(e.j.refresh_view_title_text), this.aiF));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fZO.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fZP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0175e.ds250), l.h(pageActivity, e.C0175e.ds480), l.h(pageActivity, e.C0175e.ds360)), dVar, a);
        }
        this.fZP.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eXe.LD();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fZO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void jq(int i) {
        b(NoDataViewFactory.d.G(i, e.j.refresh_view_title_text));
        if (this.fZG != null) {
            this.fZG.bD(this.cdS);
        }
        this.gak.setVisibility(8);
    }

    public void nM(String str) {
        b(NoDataViewFactory.d.aA(str, this.fZO.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.fZG != null) {
            this.fZG.bD(this.cdS);
        }
        this.gak.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.gak.setVisibility(0);
            this.cdS.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aiF = onClickListener;
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
                String userId2 = postData.yv().getUserId();
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
            if (this.fYp != null && this.fYp.YB() != null && this.fYp.YB().yv() != null && postData.yv() != null) {
                String userId3 = this.fYp.YB().yv().getUserId();
                String userId4 = postData.yv().getUserId();
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
                    userId = postData.yv().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bCb() != 1 ? 0 : 1;
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
                        if (postData.yv() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yv().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yv().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yv().getPortrait());
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
                        if (postData.yv() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.yv().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.yv().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.yv().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.yv() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yv().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.yv().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yv().getName_show());
                        }
                        if (this.fYp.YB() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fYp.YB().getId());
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
            userId = postData.yv().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bCb() != 1) {
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

    public void ly(boolean z) {
        if (this.fKO != null && this.fKO.biB() != null) {
            if (z) {
                this.fKO.biB().setText(e.j.remove_mark);
            } else {
                this.fKO.biB().setText(e.j.mark);
            }
            this.fKO.refreshUI();
        }
    }

    public View blk() {
        return this.gae;
    }

    public void onChangeSkinType(int i) {
        this.fZO.getLayoutMode().setNightMode(i == 1);
        this.fZO.getLayoutMode().onModeChanged(this.cdS);
        this.fZO.getLayoutMode().onModeChanged(this.fZN);
        this.mNavigationBar.onChangeSkinType(this.fZO.getPageContext(), i);
        if (this.fZQ != null) {
            al.h(this.fZQ, e.d.goto_see_subject_color);
        }
        this.dwo.onChangeSkinType(this.fZO.getPageContext(), i);
        this.fZO.getLayoutMode().onModeChanged(this.gae);
        al.h(this.fZX, e.d.cp_cont_b);
        this.fZX.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.eXe != null && this.eXe.KH() != null) {
            this.eXe.KH().onChangeSkinType(i);
        }
        this.gab.dW(i);
        this.cNk.aUR();
        al.h(this.dPt, e.d.cp_cont_e);
        al.h(this.fTR, e.d.cp_link_tip_a);
        al.h(this.aGD, e.d.cp_cont_c);
        this.dPt.setAlpha(0.95f);
        if (this.fUG != null) {
            com.baidu.tbadk.o.a.a(this.fZO.getPageContext(), this.fUG);
        }
        if (this.gaq != null) {
            this.gaq.notifyDataSetChanged();
        }
    }

    public void bll() {
        this.mProgress.setVisibility(0);
    }

    public void blm() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gab.DP();
    }

    public void avW() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gab.avW();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aRe = onLongClickListener;
        this.gaq.c(onLongClickListener);
    }

    public View bln() {
        return this.fZN;
    }

    public TextView aEi() {
        return this.dPt;
    }

    public ImageView blo() {
        return this.gal;
    }

    public ImageView blp() {
        return this.gam;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void rU(int i) {
    }

    public View blq() {
        return this.fZQ;
    }

    public View blr() {
        return this.fZY;
    }

    public MorePopupWindow bls() {
        return this.gac;
    }

    public void showLoadingDialog() {
        if (this.cWM == null) {
            this.cWM = new com.baidu.tbadk.core.view.d(this.fZO.getPageContext());
        }
        this.cWM.bj(true);
    }

    public void akk() {
        if (this.cWM != null) {
            this.cWM.bj(false);
        }
    }

    public TextView blt() {
        return this.fZX;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fZw = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gaq.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.gaq != null) {
            this.gaq.notifyDataSetChanged();
        }
    }

    public y blu() {
        return this.fKO;
    }

    public void aCU() {
    }

    public void aCV() {
    }

    public void onActivityDestroy() {
    }

    public void blv() {
        if (this.fZO.isPaused()) {
        }
    }

    public View blw() {
        return this.fZR;
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.fZO.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
