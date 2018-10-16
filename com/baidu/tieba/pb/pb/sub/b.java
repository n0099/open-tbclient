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
    private static final int fZL = TbadkCoreApplication.getInst().getListItemRule().Fy();
    private com.baidu.tbadk.core.view.d cWM;
    private RelativeLayout cdS;
    private TextView dPt;
    private com.baidu.tieba.NEGFeedBack.e dZp;
    private View dmK;
    private NoNetworkView dwo;
    private y fKN;
    private View fUF;
    private com.baidu.tbadk.core.dialog.b fUI;
    private j fYo;
    private a fZF;
    private View fZM;
    private NewSubPbActivity fZN;
    private RelativeLayout fZO;
    private View fZS;
    private ThreadSkinView fZZ;
    private SubPbModel fZr;
    private e gaa;
    private View gad;
    private ArrayList<PostData> gah;
    private String gai;
    private RelativeLayout gaj;
    private ImageView gak;
    private ImageView gal;
    private d gap;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener aiF = null;
    private TbRichTextView.i fZv = null;
    private NavigationBar mNavigationBar = null;
    private View aIE = null;
    private TextView fZP = null;
    private LinearLayout fZQ = null;
    private HeadImageView fZR = null;
    private ClickableHeaderImageView fTY = null;
    private TextView aGD = null;
    private ImageView fZT = null;
    private TextView fTQ = null;
    private TextView fZU = null;
    private TextView fZV = null;
    private EllipsizeRichTextView fZW = null;
    private TbImageView fZX = null;
    private PlayVoiceBntNew cNk = null;
    private TextView fZY = null;
    private MorePopupWindow gab = null;
    private am gac = null;
    private com.baidu.tbadk.core.dialog.b fUH = null;
    private Dialog fUw = null;
    private com.baidu.tbadk.core.dialog.a fUy = null;
    private boolean fMU = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aRe = null;
    private NewSubPbActivity.a gae = null;
    private NewSubPbActivity.a gaf = null;
    private g eXd = null;
    private String gag = null;
    private int bmH = 0;
    private PostData fIz = null;
    private int gam = 0;
    private int gan = 2;
    private int gao = 0;
    private boolean aUs = true;
    private View.OnClickListener fNc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.fZN.b(sparseArray);
                        return;
                    }
                    b.this.bA(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.fZN.b(sparseArray);
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
    protected AdapterView.OnItemLongClickListener gaq = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.gah, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fKN == null) {
                b.this.fKN = new y(b.this.fZN.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fKN.showDialog();
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
            b.this.fKN.a(sparseArray, b.this.fZr.bfh(), ks);
            if (ks) {
                b.this.fKN.biD().setVisibility(0);
                b.this.fKN.biD().setTag(postData.getId());
            } else {
                b.this.fKN.biD().setVisibility(8);
            }
            b.this.fKN.biB().setVisibility(8);
            b.this.fKN.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener gar = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bI(b.this.fZN.getPageContext().getPageActivity())) {
                if (b.this.fZN.eWV == null || b.this.fZr == null || b.this.fZr.ayP() == null || b.this.fZN.eWV.di(b.this.fZr.ayP().replyPrivateFlag)) {
                    if (b.this.fZF != null) {
                        b.this.fZF.aDT();
                    }
                    b.this.blf();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.gah, i);
                        if (postData == null) {
                            b.this.gai = null;
                        } else {
                            b.this.gai = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.eXd.setReplyId(str2);
                                b.this.eXd.hF(str);
                            }
                        }
                        b.this.blg();
                        return;
                    }
                    b.this.blh();
                    b.this.fZr.blC();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.cdS = null;
        this.fZM = null;
        this.mListView = null;
        this.fZN = null;
        this.dwo = null;
        this.fZO = null;
        this.fZS = null;
        this.gaa = null;
        this.gad = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dPt = null;
        this.gaj = null;
        this.gak = null;
        this.gal = null;
        this.fZN = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.cdS = (RelativeLayout) LayoutInflater.from(this.fZN.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.fZM = LayoutInflater.from(this.fZN.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.gaj = (RelativeLayout) this.cdS.findViewById(e.g.subpb_editor_tool_comment);
        this.dPt = (TextView) this.cdS.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dPt.setOnClickListener(this.mCommonClickListener);
        this.gak = (ImageView) this.cdS.findViewById(e.g.subpb_editor_tool_more_img);
        this.gal = (ImageView) this.cdS.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.gal.setOnClickListener(this.mCommonClickListener);
        this.gak.setOnClickListener(this.mCommonClickListener);
        this.dwo = (NoNetworkView) this.cdS.findViewById(e.g.view_no_network);
        aEb();
        axx();
        this.fZO = (RelativeLayout) this.cdS.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.cdS.findViewById(e.g.new_sub_pb_list);
        this.fZZ = (ThreadSkinView) LayoutInflater.from(this.fZN.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.fZZ);
        this.mListView.addHeaderView(this.fZM);
        this.dmK = BdListViewHelper.a(this.fZN.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.gaa = new e(this.fZN.getPageContext());
        this.gaa.DL();
        this.gad = this.gaa.getView();
        this.mListView.setNextPage(this.gaa);
        this.gaa.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.gar);
        this.mListView.setOnItemLongClickListener(this.gaq);
        this.mListView.setOnTouchListener(this.bnE);
        this.mProgress = (ProgressBar) this.cdS.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fZM != null) {
            this.fZM.setVisibility(4);
        }
        if (this.fZO != null) {
            this.fZO.setVisibility(4);
        }
        this.fZS = com.baidu.tbadk.ala.b.uL().j(this.fZN.getActivity(), 4);
        if (this.fZS != null) {
            this.fZS.setVisibility(8);
            this.fZQ.addView(this.fZS, 3);
        }
        this.gap = new d(this.fZN, this.mListView);
        this.gap.setFromCDN(this.mIsFromCDN);
        this.gap.q(this.mCommonClickListener);
        this.gap.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void axx() {
        this.fZQ = (LinearLayout) this.fZM.findViewById(e.g.subpb_head_user_info_root);
        this.fZQ.setOnClickListener(this.mCommonClickListener);
        this.fZR = (HeadImageView) this.fZM.findViewById(e.g.photo);
        this.fZR.setRadius(l.h(this.fZN.getActivity(), e.C0175e.ds30));
        this.fZR.setClickable(false);
        this.fTY = (ClickableHeaderImageView) this.fZM.findViewById(e.g.god_user_photo);
        this.fTY.setGodIconMargin(0);
        this.fTY.setGodIconWidth(e.C0175e.ds24);
        this.fTY.setRadius(l.h(this.fZN.getActivity(), e.C0175e.ds30));
        this.fTY.setClickable(false);
        this.aGD = (TextView) this.fZM.findViewById(e.g.user_name);
        this.fZT = (ImageView) this.fZM.findViewById(e.g.user_rank);
        this.fZT.setVisibility(8);
        this.fTQ = (TextView) this.fZM.findViewById(e.g.floor_owner);
        this.fZP = (TextView) this.fZM.findViewById(e.g.see_subject);
        this.fZP.setOnClickListener(this.mCommonClickListener);
        this.fZU = (TextView) this.fZM.findViewById(e.g.floor);
        this.fZV = (TextView) this.fZM.findViewById(e.g.time);
        this.fZW = (EllipsizeRichTextView) this.fZM.findViewById(e.g.content_text);
        this.fZW.setOnClickListener(this.mCommonClickListener);
        al.h(this.fZW, e.d.cp_cont_b);
        this.fZW.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.fZW.setLineSpacing(0.0f, 1.25f);
        this.fZX = (TbImageView) this.fZM.findViewById(e.g.sub_pb_image);
        this.fZX.setOnClickListener(this.mCommonClickListener);
        this.fZY = (TextView) this.fZM.findViewById(e.g.advert);
        this.cNk = (PlayVoiceBntNew) this.fZM.findViewById(e.g.voice_btn);
        this.fZM.setOnTouchListener(this.bnE);
        this.fZM.setOnClickListener(this.mCommonClickListener);
    }

    public void gV(boolean z) {
        if (this.dmK != null && this.dmK.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dmK.getLayoutParams();
            if (z) {
                aEf();
                layoutParams.height = l.h(this.fZN.getPageContext().getPageActivity(), e.C0175e.ds88);
            } else {
                layoutParams.height = l.h(this.fZN.getPageContext().getPageActivity(), e.C0175e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dmK.setLayoutParams(layoutParams);
        }
    }

    private void aEf() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0124b interfaceC0124b, boolean z) {
        if (this.fUI != null) {
            this.fUI.dismiss();
            this.fUI = null;
        }
        this.fUI = new com.baidu.tbadk.core.dialog.b(this.fZN.getPageContext().getPageActivity());
        if (z) {
            this.fUI.a(new String[]{this.fZN.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0124b);
        } else {
            this.fUI.a(new String[]{this.fZN.getPageContext().getString(e.j.save_to_emotion), this.fZN.getPageContext().getString(e.j.save_to_local)}, interfaceC0124b);
        }
        this.fUI.d(this.fZN.getPageContext());
        this.fUI.Ax();
    }

    public void bC(View view) {
        this.fUF = view;
    }

    public View aEg() {
        return this.dmK;
    }

    public void aEb() {
        int h = l.h(this.fZN.getPageContext().getPageActivity(), e.C0175e.ds88);
        int h2 = l.h(this.fZN.getPageContext().getPageActivity(), e.C0175e.ds2);
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

    public NavigationBar aaD() {
        return this.mNavigationBar;
    }

    public void bA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fUw == null) {
            this.fUw = new Dialog(this.fZN.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.fUw.setCanceledOnTouchOutside(true);
            this.fUw.setCancelable(true);
            View inflate = LayoutInflater.from(this.fZN.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.fZN.getLayoutMode().onModeChanged(inflate);
            this.fUw.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fUw.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.fZN.getPageContext().getPageActivity()) * 0.9d);
            this.fUw.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUw.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.fUw.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUw.findViewById(e.g.disable_reply_btn);
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
                    if (b.this.fUw != null && (b.this.fUw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fUw, b.this.fZN.getPageContext());
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
                    if (b.this.fUw != null && (b.this.fUw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fUw, b.this.fZN.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.gae != null) {
                        b.this.gae.m(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
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
                    if (b.this.fUw != null && (b.this.fUw instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fUw, b.this.fZN.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.fZN.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fUw, this.fZN.getPageContext());
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
        this.fUy = new com.baidu.tbadk.core.dialog.a(this.fZN.getPageContext().getPageActivity());
        this.fUy.cz(i3);
        this.fUy.H(sparseArray);
        this.fUy.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.gaf != null) {
                    b.this.gaf.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fUy.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUy.aO(true);
        this.fUy.b(this.fZN.getPageContext());
        if (z) {
            this.fUy.Au();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData ayP;
        if (this.fZN != null && sparseArray != null && this.fZM != null) {
            if (this.dZp == null) {
                this.dZp = new com.baidu.tieba.NEGFeedBack.e(this.fZN.getPageContext(), this.fZM);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.fZr != null && (ayP = this.fZr.ayP()) != null && ayP.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayP.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.dZp.setDefaultReasonArray(new String[]{this.fZN.getString(e.j.delete_thread_reason_1), this.fZN.getString(e.j.delete_thread_reason_2), this.fZN.getString(e.j.delete_thread_reason_3), this.fZN.getString(e.j.delete_thread_reason_4), this.fZN.getString(e.j.delete_thread_reason_5)});
            this.dZp.setData(ahVar);
            this.dZp.iN("4");
            this.dZp.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void k(JSONArray jSONArray) {
                    String i2 = ao.i(jSONArray);
                    if (b.this.gaf != null) {
                        b.this.gaf.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), i2});
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
        this.gae = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gaf = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fZN.showToast(this.fZN.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.fZN.showToast(str);
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
                this.dmK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.fZN.getActivity(), e.C0175e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dmK, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.KH() != null) {
            this.eXd = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cdS.addView(gVar.KH(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fZF = aVar;
    }

    public void blf() {
        if (this.mListView != null) {
            this.gao = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ks(boolean z) {
        if (this.fZr == null || this.fZr.blz() == null) {
            return false;
        }
        if (this.fZr.bfh() != 0) {
            return false;
        }
        return (this.fYo == null || this.fYo.YA() == null || this.fYo.YA().yv() == null || !TextUtils.equals(this.fYo.YA().yv().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void blg() {
        if (this.fZr != null) {
            if ((!blj() && this.gad != null && this.gad.isShown()) || v.J(this.gah)) {
                this.fZr.lA(false);
            } else {
                this.fZr.lA(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fZr = subPbModel;
    }

    public void blh() {
        a(this.fZN);
        this.mListView.setNextPage(this.gaa);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.ng(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!blj() && this.gad != null && this.gad.isShown()) {
                i = (this.gao - this.gan) - 1;
            } else {
                i = this.gao - this.gan;
            }
            int I = v.I(this.gah);
            if (i > I) {
                i = I;
            }
            ArrayList arrayList = new ArrayList(v.b(this.gah, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.gao + 2);
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
        if (this.gab != null) {
            com.baidu.adp.lib.g.g.a(this.gab, this.fZN.getPageContext().getPageActivity());
        }
        if (this.fUH != null) {
            this.fUH.dismiss();
        }
        if (this.fUy != null) {
            this.fUy.dismiss();
        }
        if (this.fUw != null) {
            com.baidu.adp.lib.g.g.b(this.fUw, this.fZN.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fKN != null) {
            this.fKN.dismiss();
        }
    }

    public void bli() {
        this.mListView.setNextPage(this.gaa);
        this.gaa.DO();
    }

    public void kl(boolean z) {
        this.fMU = z;
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
            if (this.aUs && this.fZM != null) {
                this.fZM.setVisibility(8);
                this.mListView.removeHeaderView(this.fZM);
                this.gan = 1;
            }
            this.fYo = jVar;
            if (this.fZM != null) {
                this.fZM.setVisibility(0);
            }
            if (this.fZO != null) {
                this.fZO.setVisibility(0);
            }
            if (jVar.bfC() != null) {
                this.gag = jVar.bfC().getId();
                this.bmH = jVar.bfC().bCb();
                if (this.bmH > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fZN.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.bmH)));
                    this.dPt.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.fZN.ble() ? "PB" : null;
                if (jVar.bfC().yR() != null) {
                    this.fZZ.setData(this.fZN.getPageContext(), jVar.bfC().yR(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bfJ().getId(), jVar.bfJ().getName(), jVar.YA().getId(), str));
                } else {
                    this.fZZ.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.gaa.DO();
                this.gap.setHasMoreData(true);
            } else {
                this.gaa.DP();
                this.gap.setHasMoreData(false);
            }
            this.gah = jVar.bfG();
            if (this.gah == null || this.gah.size() <= fZL) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gah.size() - fZL;
                rT(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gah);
            if (v.J(this.gah)) {
                this.mListView.setNextPage(null);
                if (this.aUs) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.gaa);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aUs) {
                arrayList.add(0, jVar.bfC());
            }
            this.gap.a(this.fYo.YA(), arrayList);
            a(jVar.bfC(), jVar.aSn(), jVar.vc(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void rT(int i) {
        if (this.gah != null) {
            if (this.gah.size() <= i) {
                this.gah.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gah.iterator();
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
        return this.gap.hasMoreData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aUs) {
            this.fIz = postData;
            if (!StringUtils.isNull(postData.bCi())) {
                this.fZX.setVisibility(0);
                this.fZX.startLoad(postData.bCi(), 10, true);
            } else {
                this.fZX.setVisibility(8);
            }
            h bCk = postData.bCk();
            if (bCk != null && bCk.hcC) {
                this.fZY.setVisibility(0);
            } else {
                this.fZY.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fZM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fZM.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fZU.setText((CharSequence) null);
            this.aGD.setText((CharSequence) null);
            this.fTQ.setVisibility(8);
            if (!this.aUs) {
                c(postData.yv());
                if (z) {
                    this.fTQ.setVisibility(0);
                    al.h(this.fTQ, e.d.cp_link_tip_a);
                }
            }
            this.fZV.setText(ao.C(postData.getTime()));
            this.fZU.setText(String.format(this.fZN.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.bCb())));
            postData.yv().getUserTbVipInfoData();
            boolean a = a(this.fZW, postData.bCd());
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
            if (metaData.getAlaUserData() != null && this.fZS != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fZS.setVisibility(8);
                } else {
                    this.fZS.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aht = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fZS.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fTY.setVisibility(0);
                this.fZR.setVisibility(8);
                this.fTY.setUserId(metaData.getUserId());
                this.fTY.setUserName(metaData.getUserName());
                this.fTY.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aGD, e.d.cp_cont_r);
            } else {
                this.fTY.setVisibility(8);
                this.fZR.setVisibility(0);
                this.fZR.setUserId(metaData.getUserId());
                this.fZR.setUserName(metaData.getUserName());
                this.fZR.setDefaultResource(e.f.transparent_bg);
                this.fZR.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.fZR.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aGD, e.d.cp_cont_c);
            }
            this.fZQ.setTag(e.g.tag_user_id, metaData.getUserId());
            this.fZQ.setTag(e.g.tag_user_name, metaData.getUserName());
            this.fZQ.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fZN.getPageContext().getString(e.j.refresh_view_title_text), this.aiF));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fZN.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fZO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0175e.ds250), l.h(pageActivity, e.C0175e.ds480), l.h(pageActivity, e.C0175e.ds360)), dVar, a);
        }
        this.fZO.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eXd.LD();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fZN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void jq(int i) {
        b(NoDataViewFactory.d.G(i, e.j.refresh_view_title_text));
        if (this.fZF != null) {
            this.fZF.bD(this.cdS);
        }
        this.gaj.setVisibility(8);
    }

    public void nM(String str) {
        b(NoDataViewFactory.d.aA(str, this.fZN.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.fZF != null) {
            this.fZF.bD(this.cdS);
        }
        this.gaj.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.gaj.setVisibility(0);
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
            if (this.fYo != null && this.fYo.YA() != null && this.fYo.YA().yv() != null && postData.yv() != null) {
                String userId3 = this.fYo.YA().yv().getUserId();
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
                        if (this.fYo.YA() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.fYo.YA().getId());
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
        if (this.fKN != null && this.fKN.biB() != null) {
            if (z) {
                this.fKN.biB().setText(e.j.remove_mark);
            } else {
                this.fKN.biB().setText(e.j.mark);
            }
            this.fKN.refreshUI();
        }
    }

    public View blk() {
        return this.gad;
    }

    public void onChangeSkinType(int i) {
        this.fZN.getLayoutMode().setNightMode(i == 1);
        this.fZN.getLayoutMode().onModeChanged(this.cdS);
        this.fZN.getLayoutMode().onModeChanged(this.fZM);
        this.mNavigationBar.onChangeSkinType(this.fZN.getPageContext(), i);
        if (this.fZP != null) {
            al.h(this.fZP, e.d.goto_see_subject_color);
        }
        this.dwo.onChangeSkinType(this.fZN.getPageContext(), i);
        this.fZN.getLayoutMode().onModeChanged(this.gad);
        al.h(this.fZW, e.d.cp_cont_b);
        this.fZW.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.eXd != null && this.eXd.KH() != null) {
            this.eXd.KH().onChangeSkinType(i);
        }
        this.gaa.dW(i);
        this.cNk.aUR();
        al.h(this.dPt, e.d.cp_cont_e);
        al.h(this.fTQ, e.d.cp_link_tip_a);
        al.h(this.aGD, e.d.cp_cont_c);
        this.dPt.setAlpha(0.95f);
        if (this.fUF != null) {
            com.baidu.tbadk.o.a.a(this.fZN.getPageContext(), this.fUF);
        }
        if (this.gap != null) {
            this.gap.notifyDataSetChanged();
        }
    }

    public void bll() {
        this.mProgress.setVisibility(0);
    }

    public void blm() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gaa.DP();
    }

    public void avV() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gaa.avV();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aRe = onLongClickListener;
        this.gap.c(onLongClickListener);
    }

    public View bln() {
        return this.fZM;
    }

    public TextView aEh() {
        return this.dPt;
    }

    public ImageView blo() {
        return this.gak;
    }

    public ImageView blp() {
        return this.gal;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void rU(int i) {
    }

    public View blq() {
        return this.fZP;
    }

    public View blr() {
        return this.fZX;
    }

    public MorePopupWindow bls() {
        return this.gab;
    }

    public void showLoadingDialog() {
        if (this.cWM == null) {
            this.cWM = new com.baidu.tbadk.core.view.d(this.fZN.getPageContext());
        }
        this.cWM.bj(true);
    }

    public void akj() {
        if (this.cWM != null) {
            this.cWM.bj(false);
        }
    }

    public TextView blt() {
        return this.fZW;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fZv = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.gap.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.gap != null) {
            this.gap.notifyDataSetChanged();
        }
    }

    public y blu() {
        return this.fKN;
    }

    public void aCT() {
    }

    public void aCU() {
    }

    public void onActivityDestroy() {
    }

    public void blv() {
        if (this.fZN.isPaused()) {
        }
    }

    public View blw() {
        return this.fZQ;
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.fZN.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
