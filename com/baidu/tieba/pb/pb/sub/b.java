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
    private static final int hBG = TbadkCoreApplication.getInst().getListItemRule().ags();
    private RelativeLayout dxV;
    private View eKQ;
    private NoNetworkView eUD;
    private com.baidu.tbadk.core.view.b erP;
    private TextView fnK;
    private com.baidu.tieba.NEGFeedBack.e fzr;
    private j hAo;
    private View hBH;
    private NewSubPbActivity hBI;
    private RelativeLayout hBJ;
    private View hBN;
    private ThreadSkinView hBU;
    private e hBV;
    private View hBW;
    private SubPbModel hBj;
    private y hBm;
    private a hBy;
    private View hCa;
    private com.baidu.tbadk.core.dialog.b hCc;
    private ArrayList<PostData> hCg;
    private String hCh;
    private RelativeLayout hCi;
    private ImageView hCj;
    private ImageView hCk;
    private d hCo;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bum = null;
    private TbRichTextView.i hBo = null;
    private NavigationBar mNavigationBar = null;
    private View bWc = null;
    private TextView hBK = null;
    private LinearLayout hBL = null;
    private HeadImageView hBM = null;
    private ClickableHeaderImageView hvY = null;
    private TextView bUb = null;
    private ImageView hBO = null;
    private TextView hvQ = null;
    private TextView hBP = null;
    private TextView hBQ = null;
    private EllipsizeRichTextView hBR = null;
    private TbImageView hBS = null;
    private PlayVoiceBntNew aaa = null;
    private TextView hBT = null;
    private MorePopupWindow hBX = null;
    private am hBY = null;
    private com.baidu.tbadk.core.dialog.b hBZ = null;
    private Dialog hCb = null;
    private com.baidu.tbadk.core.dialog.a hwy = null;
    private boolean hpa = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cfx = null;
    private NewSubPbActivity.a hCd = null;
    private NewSubPbActivity.a hCe = null;
    private g gyG = null;
    private String hCf = null;
    private int cCy = 0;
    private PostData hkE = null;
    private int hCl = 0;
    private int hCm = 2;
    private int hCn = 0;
    private boolean ciV = true;
    private View.OnClickListener hpj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hBI.c(sparseArray);
                        return;
                    }
                    b.this.cs(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.hBI.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c ccb = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
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
    protected AdapterView.OnItemLongClickListener hCp = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hCg, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hBm == null) {
                b.this.hBm = new y(b.this.hBI.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hBm.showDialog();
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
            b.this.hBm.a(sparseArray, b.this.hBj.bIi(), nj);
            if (nj) {
                b.this.hBm.bLG().setVisibility(0);
                b.this.hBm.bLG().setTag(postData.getId());
            } else {
                b.this.hBm.bLG().setVisibility(8);
            }
            b.this.hBm.bLE().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hCq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cZ(b.this.hBI.getPageContext().getPageActivity())) {
                if (b.this.hBI.gyy == null || b.this.hBj == null || b.this.hBj.bbG() == null || b.this.hBI.gyy.hl(b.this.hBj.bbG().replyPrivateFlag)) {
                    if (b.this.hBy != null) {
                        b.this.hBy.bgC();
                    }
                    b.this.bOg();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hCg, i);
                        if (postData == null) {
                            b.this.hCh = null;
                        } else {
                            b.this.hCh = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.gyG.setReplyId(str2);
                                b.this.gyG.oZ(str);
                            }
                        }
                        b.this.bOh();
                        return;
                    }
                    b.this.bOi();
                    b.this.hBj.bOE();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dxV = null;
        this.hBH = null;
        this.mListView = null;
        this.hBI = null;
        this.eUD = null;
        this.hBJ = null;
        this.hBN = null;
        this.hBV = null;
        this.hCa = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fnK = null;
        this.hCi = null;
        this.hCj = null;
        this.hCk = null;
        this.hBI = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dxV = (RelativeLayout) LayoutInflater.from(this.hBI.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.hBH = LayoutInflater.from(this.hBI.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.hCi = (RelativeLayout) this.dxV.findViewById(d.g.subpb_editor_tool_comment);
        this.fnK = (TextView) this.dxV.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.fnK.setOnClickListener(this.mCommonClickListener);
        this.hCj = (ImageView) this.dxV.findViewById(d.g.subpb_editor_tool_more_img);
        this.hCk = (ImageView) this.dxV.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.hCk.setOnClickListener(this.mCommonClickListener);
        this.hCj.setOnClickListener(this.mCommonClickListener);
        this.eUD = (NoNetworkView) this.dxV.findViewById(d.g.view_no_network);
        bgK();
        bar();
        this.hBJ = (RelativeLayout) this.dxV.findViewById(d.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dxV.findViewById(d.g.new_sub_pb_list);
        this.hBU = (ThreadSkinView) LayoutInflater.from(this.hBI.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hBU);
        this.mListView.addHeaderView(this.hBH);
        this.eKQ = BdListViewHelper.a(this.hBI.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hBV = new e(this.hBI.getPageContext());
        this.hBV.aew();
        this.hCa = this.hBV.getView();
        this.mListView.setNextPage(this.hBV);
        this.hBV.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hCq);
        this.mListView.setOnItemLongClickListener(this.hCp);
        this.mListView.setOnTouchListener(this.ccb);
        this.mProgress = (ProgressBar) this.dxV.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hBH != null) {
            this.hBH.setVisibility(4);
        }
        if (this.hBJ != null) {
            this.hBJ.setVisibility(4);
        }
        this.hBN = com.baidu.tbadk.ala.b.UH().n(this.hBI.getActivity(), 4);
        if (this.hBN != null) {
            this.hBN.setVisibility(8);
            this.hBL.addView(this.hBN, 3);
        }
        this.hCo = new d(this.hBI, this.mListView);
        this.hCo.setFromCDN(this.mIsFromCDN);
        this.hCo.t(this.mCommonClickListener);
        this.hCo.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bar() {
        this.hBL = (LinearLayout) this.hBH.findViewById(d.g.subpb_head_user_info_root);
        this.hBL.setOnClickListener(this.mCommonClickListener);
        this.hBM = (HeadImageView) this.hBH.findViewById(d.g.photo);
        this.hBM.setRadius(l.h(this.hBI.getActivity(), d.e.ds30));
        this.hBM.setClickable(false);
        this.hvY = (ClickableHeaderImageView) this.hBH.findViewById(d.g.god_user_photo);
        this.hvY.setGodIconMargin(0);
        this.hvY.setGodIconWidth(d.e.ds24);
        this.hvY.setRadius(l.h(this.hBI.getActivity(), d.e.ds30));
        this.hvY.setClickable(false);
        this.bUb = (TextView) this.hBH.findViewById(d.g.user_name);
        this.hBO = (ImageView) this.hBH.findViewById(d.g.user_rank);
        this.hBO.setVisibility(8);
        this.hvQ = (TextView) this.hBH.findViewById(d.g.floor_owner);
        this.hBK = (TextView) this.hBH.findViewById(d.g.see_subject);
        this.hBK.setOnClickListener(this.mCommonClickListener);
        this.hBP = (TextView) this.hBH.findViewById(d.g.floor);
        this.hBQ = (TextView) this.hBH.findViewById(d.g.time);
        this.hBR = (EllipsizeRichTextView) this.hBH.findViewById(d.g.content_text);
        this.hBR.setOnClickListener(this.mCommonClickListener);
        al.j(this.hBR, d.C0277d.cp_cont_b);
        this.hBR.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
        this.hBR.setLineSpacing(0.0f, 1.25f);
        this.hBS = (TbImageView) this.hBH.findViewById(d.g.sub_pb_image);
        this.hBS.setOnClickListener(this.mCommonClickListener);
        this.hBT = (TextView) this.hBH.findViewById(d.g.advert);
        this.aaa = (PlayVoiceBntNew) this.hBH.findViewById(d.g.voice_btn);
        this.hBH.setOnTouchListener(this.ccb);
        this.hBH.setOnClickListener(this.mCommonClickListener);
    }

    public void jH(boolean z) {
        if (this.eKQ != null && this.eKQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eKQ.getLayoutParams();
            if (z) {
                bgO();
                layoutParams.height = l.h(this.hBI.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.h(this.hBI.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.eKQ.setLayoutParams(layoutParams);
        }
    }

    private void bgO() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0225b interfaceC0225b, boolean z) {
        if (this.hCc != null) {
            this.hCc.dismiss();
            this.hCc = null;
        }
        this.hCc = new com.baidu.tbadk.core.dialog.b(this.hBI.getPageContext().getPageActivity());
        if (z) {
            this.hCc.a(new String[]{this.hBI.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0225b);
        } else {
            this.hCc.a(new String[]{this.hBI.getPageContext().getString(d.j.save_to_emotion), this.hBI.getPageContext().getString(d.j.save_to_local)}, interfaceC0225b);
        }
        this.hCc.d(this.hBI.getPageContext());
        this.hCc.aaZ();
    }

    public void cw(View view) {
        this.hBW = view;
    }

    public View bgP() {
        return this.eKQ;
    }

    public void bgK() {
        int h = l.h(this.hBI.getPageContext().getPageActivity(), d.e.ds88);
        int h2 = l.h(this.hBI.getPageContext().getPageActivity(), d.e.ds2);
        this.mNavigationBar = (NavigationBar) this.dxV.findViewById(d.g.view_navigation_bar);
        this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWc.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bWc != null && (this.bWc.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bWc.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.bWc.setLayoutParams(layoutParams2);
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
        if (this.hCb == null) {
            this.hCb = new Dialog(this.hBI.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hCb.setCanceledOnTouchOutside(true);
            this.hCb.setCancelable(true);
            View inflate = LayoutInflater.from(this.hBI.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.hBI.getLayoutMode().onModeChanged(inflate);
            this.hCb.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hCb.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.hBI.getPageContext().getPageActivity()) * 0.9d);
            this.hCb.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hCb.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.hCb.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.hCb.findViewById(d.g.disable_reply_btn);
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
                    if (b.this.hCb != null && (b.this.hCb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCb, b.this.hBI.getPageContext());
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
                    if (b.this.hCb != null && (b.this.hCb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCb, b.this.hBI.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hCd != null) {
                        b.this.hCd.m(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show), sparseArray4.get(d.g.tag_forbid_user_portrait)});
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
                    if (b.this.hCb != null && (b.this.hCb instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCb, b.this.hBI.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hBI.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hCb, this.hBI.getPageContext());
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
        this.hwy = new com.baidu.tbadk.core.dialog.a(this.hBI.getPageContext().getPageActivity());
        this.hwy.gC(i3);
        this.hwy.Z(sparseArray);
        this.hwy.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hCe != null) {
                    b.this.hCe.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hwy.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwy.dq(true);
        this.hwy.b(this.hBI.getPageContext());
        if (z) {
            this.hwy.aaW();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bbG;
        if (this.hBI != null && sparseArray != null && this.hBH != null) {
            if (this.fzr == null) {
                this.fzr = new com.baidu.tieba.NEGFeedBack.e(this.hBI.getPageContext(), this.hBH);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hBj != null && (bbG = this.hBj.bbG()) != null && bbG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbG.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fzr.setDefaultReasonArray(new String[]{this.hBI.getString(d.j.delete_thread_reason_1), this.hBI.getString(d.j.delete_thread_reason_2), this.hBI.getString(d.j.delete_thread_reason_3), this.hBI.getString(d.j.delete_thread_reason_4), this.hBI.getString(d.j.delete_thread_reason_5)});
            this.fzr.setData(ajVar);
            this.fzr.qj("4");
            this.fzr.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    String x = ap.x(jSONArray);
                    if (b.this.hCe != null) {
                        b.this.hCe.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type), x});
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
        this.hCd = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hCe = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hBI.showToast(this.hBI.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.hBI.showToast(str);
        }
    }

    public void bL(View view) {
        if (this.eKQ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eKQ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.eKQ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eKQ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.hBI.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.eKQ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.alP() != null) {
            this.gyG = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dxV.addView(gVar.alP(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hBy = aVar;
    }

    public void bOg() {
        if (this.mListView != null) {
            this.hCn = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBj == null || this.hBj.bOB() == null) {
            return false;
        }
        if (this.hBj.bIi() != 0) {
            return false;
        }
        return (this.hAo == null || this.hAo.WO() == null || this.hAo.WO().YO() == null || !TextUtils.equals(this.hAo.WO().YO().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bOh() {
        if (this.hBj != null) {
            if ((!bOk() && this.hCa != null && this.hCa.isShown()) || v.T(this.hCg)) {
                this.hBj.oo(false);
            } else {
                this.hBj.oo(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hBj = subPbModel;
    }

    public void bOi() {
        b(this.hBI);
        this.mListView.setNextPage(this.hBV);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.pX(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bOk() && this.hCa != null && this.hCa.isShown()) {
                i = (this.hCn - this.hCm) - 1;
            } else {
                i = this.hCn - this.hCm;
            }
            int S = v.S(this.hCg);
            if (i > S) {
                i = S;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hCg, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hCn + 2);
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
        return this.dxV;
    }

    public void bMX() {
        if (this.hBX != null) {
            com.baidu.adp.lib.g.g.a(this.hBX, this.hBI.getPageContext().getPageActivity());
        }
        if (this.hBZ != null) {
            this.hBZ.dismiss();
        }
        if (this.hwy != null) {
            this.hwy.dismiss();
        }
        if (this.hCb != null) {
            com.baidu.adp.lib.g.g.b(this.hCb, this.hBI.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hBm != null) {
            this.hBm.dismiss();
        }
    }

    public void bOj() {
        this.mListView.setNextPage(this.hBV);
        this.hBV.aez();
    }

    public void nc(boolean z) {
        this.hpa = z;
    }

    public void setIsFromPb(boolean z) {
        this.ciV = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.ciV && this.hBH != null) {
                this.hBH.setVisibility(8);
                this.mListView.removeHeaderView(this.hBH);
                this.hCm = 1;
            }
            this.hAo = jVar;
            if (this.hBH != null) {
                this.hBH.setVisibility(0);
            }
            if (this.hBJ != null) {
                this.hBJ.setVisibility(0);
            }
            if (jVar.bIA() != null) {
                this.hCf = jVar.bIA().getId();
                this.cCy = jVar.bIA().cep();
                if (this.cCy > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hBI.getResources().getString(d.j.subpb_floor_reply), Integer.valueOf(this.cCy)));
                    if (this.hBI != null) {
                        this.fnK.setText(this.hBI.bMo());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hBI.bOe() ? "PB" : null;
                if (jVar.bIA().Zj() != null) {
                    this.hBU.setData(this.hBI.getPageContext(), jVar.bIA().Zj(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bIG().getId(), jVar.bIG().getName(), jVar.WO().getId(), str));
                } else {
                    this.hBU.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.hBV.aez();
                this.hCo.setHasMoreData(true);
            } else {
                this.hBV.aeA();
                this.hCo.setHasMoreData(false);
            }
            this.hCg = jVar.bIE();
            if (this.hCg == null || this.hCg.size() <= hBG) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hCg.size() - hBG;
                wD(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hCg);
            if (v.T(this.hCg)) {
                this.mListView.setNextPage(null);
                if (this.ciV) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hBV);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.ciV) {
                arrayList.add(0, jVar.bIA());
            }
            this.hCo.b(this.hAo.WO(), arrayList);
            a(jVar.bIA(), jVar.bvr(), jVar.UY(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void wD(int i) {
        if (this.hCg != null) {
            if (this.hCg.size() <= i) {
                this.hCg.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hCg.iterator();
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
        return this.hCo.Hy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.ciV) {
            this.hkE = postData;
            if (!StringUtils.isNull(postData.cew())) {
                this.hBS.setVisibility(0);
                this.hBS.startLoad(postData.cew(), 10, true);
            } else {
                this.hBS.setVisibility(8);
            }
            i cey = postData.cey();
            if (cey != null && cey.iFu) {
                this.hBT.setVisibility(0);
            } else {
                this.hBT.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hBH.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hBH.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hBP.setText((CharSequence) null);
            this.bUb.setText((CharSequence) null);
            this.hvQ.setVisibility(8);
            if (!this.ciV) {
                c(postData.YO());
                if (z) {
                    this.hvQ.setVisibility(0);
                    al.j(this.hvQ, d.C0277d.cp_link_tip_a);
                }
            }
            this.hBQ.setText(ap.ao(postData.getTime()));
            this.hBP.setText(String.format(this.hBI.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.cep())));
            postData.YO().getUserTbVipInfoData();
            boolean a = a(this.hBR, postData.cer());
            if (StringUtils.isNull(postData.cew()) && !a && postData.asC() != null) {
                this.aaa.setVisibility(0);
                this.aaa.setTag(postData.asC());
                return;
            }
            this.aaa.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + ab.pN(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bUb.setText(bN(metaData.getSealPrefix(), name_show));
            } else {
                this.bUb.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.hBN != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hBN.setVisibility(8);
                } else {
                    this.hBN.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsN = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hBN.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hvY.setVisibility(0);
                this.hBM.setVisibility(8);
                this.hvY.setUserId(metaData.getUserId());
                this.hvY.setUserName(metaData.getUserName());
                this.hvY.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bUb, d.C0277d.cp_cont_r);
            } else {
                this.hvY.setVisibility(8);
                this.hBM.setVisibility(0);
                this.hBM.setUserId(metaData.getUserId());
                this.hBM.setUserName(metaData.getUserName());
                this.hBM.setDefaultResource(d.f.transparent_bg);
                this.hBM.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.hBM.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bUb, d.C0277d.cp_cont_c);
            }
            this.hBL.setTag(d.g.tag_user_id, metaData.getUserId());
            this.hBL.setTag(d.g.tag_user_name, metaData.getUserName());
            this.hBL.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hBI.getPageContext().getString(d.j.refresh_view_title_text), this.bum));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hBI.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hBJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.new_pic_emotion_07, l.h(pageActivity, d.e.ds250), l.h(pageActivity, d.e.ds480), l.h(pageActivity, d.e.ds360)), dVar, a);
        }
        this.hBJ.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gyG.amM();
        al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hBI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void nQ(int i) {
        b(NoDataViewFactory.d.ad(i, d.j.refresh_view_title_text));
        if (this.hBy != null) {
            this.hBy.cu(this.dxV);
        }
        this.hCi.setVisibility(8);
    }

    public void vj(String str) {
        b(NoDataViewFactory.d.bM(str, this.hBI.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.hBy != null) {
            this.hBy.cu(this.dxV);
        }
        this.hCi.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hCi.setVisibility(0);
            this.dxV.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bum = onClickListener;
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
            if (this.hAo != null && this.hAo.WO() != null && this.hAo.WO().YO() != null && postData.YO() != null) {
                String userId3 = this.hAo.WO().YO().getUserId();
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
                        if (this.hAo.WO() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hAo.WO().getId());
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
        if (this.hBm != null && this.hBm.bLE() != null) {
            if (z) {
                this.hBm.bLE().setText(d.j.remove_mark);
            } else {
                this.hBm.bLE().setText(d.j.mark);
            }
        }
    }

    public View bOl() {
        return this.hCa;
    }

    public void onChangeSkinType(int i) {
        this.hBI.getLayoutMode().setNightMode(i == 1);
        this.hBI.getLayoutMode().onModeChanged(this.dxV);
        this.hBI.getLayoutMode().onModeChanged(this.hBH);
        this.mNavigationBar.onChangeSkinType(this.hBI.getPageContext(), i);
        if (this.hBK != null) {
            al.j(this.hBK, d.C0277d.goto_see_subject_color);
        }
        this.eUD.onChangeSkinType(this.hBI.getPageContext(), i);
        this.hBI.getLayoutMode().onModeChanged(this.hCa);
        al.j(this.hBR, d.C0277d.cp_cont_b);
        this.hBR.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
        if (this.gyG != null && this.gyG.alP() != null) {
            this.gyG.alP().onChangeSkinType(i);
        }
        this.hBV.ib(i);
        this.aaa.bxS();
        al.j(this.fnK, d.C0277d.cp_cont_e);
        al.j(this.hvQ, d.C0277d.cp_link_tip_a);
        al.j(this.bUb, d.C0277d.cp_cont_c);
        this.fnK.setAlpha(0.95f);
        if (this.hBW != null) {
            com.baidu.tbadk.r.a.a(this.hBI.getPageContext(), this.hBW);
        }
        if (this.hCo != null) {
            this.hCo.notifyDataSetChanged();
        }
    }

    public void bOm() {
        this.mProgress.setVisibility(0);
    }

    public void bOn() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hBV.aeA();
    }

    public void aYS() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hBV.aYS();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfx = onLongClickListener;
        this.hCo.c(onLongClickListener);
    }

    public View bOo() {
        return this.hBH;
    }

    public TextView bgQ() {
        return this.fnK;
    }

    public ImageView bOp() {
        return this.hCj;
    }

    public ImageView bOq() {
        return this.hCk;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void wE(int i) {
    }

    public View bOr() {
        return this.hBK;
    }

    public View bOs() {
        return this.hBS;
    }

    public MorePopupWindow bOt() {
        return this.hBX;
    }

    public void showLoadingDialog() {
        if (this.erP == null) {
            this.erP = new com.baidu.tbadk.core.view.b(this.hBI.getPageContext());
        }
        this.erP.dJ(true);
    }

    public void aMt() {
        if (this.erP != null) {
            this.erP.dJ(false);
        }
    }

    public TextView bOu() {
        return this.hBR;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hBo = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCo.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hCo != null) {
            this.hCo.notifyDataSetChanged();
        }
    }

    public y bOv() {
        return this.hBm;
    }

    public void biO() {
    }

    public void biP() {
    }

    public void onActivityDestroy() {
    }

    public void bOw() {
        if (this.hBI.isPaused()) {
        }
    }

    public View bOx() {
        return this.hBL;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return n.a((Context) this.hBI.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
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
        if (this.gyG == null || this.gyG.alP() == null) {
            return 0;
        }
        return this.gyG.alP().getHeight();
    }
}
