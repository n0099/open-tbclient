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
    private static final int hBZ = TbadkCoreApplication.getInst().getListItemRule().agv();
    private RelativeLayout dxT;
    private View eLh;
    private NoNetworkView eUU;
    private com.baidu.tbadk.core.view.b esg;
    private TextView fnZ;
    private com.baidu.tieba.NEGFeedBack.e fzE;
    private j hAH;
    private SubPbModel hBC;
    private y hBF;
    private a hBR;
    private String hCA;
    private RelativeLayout hCB;
    private ImageView hCC;
    private ImageView hCD;
    private d hCH;
    private View hCa;
    private NewSubPbActivity hCb;
    private RelativeLayout hCc;
    private View hCg;
    private ThreadSkinView hCn;
    private e hCo;
    private View hCp;
    private View hCt;
    private com.baidu.tbadk.core.dialog.b hCv;
    private ArrayList<PostData> hCz;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bug = null;
    private TbRichTextView.i hBH = null;
    private NavigationBar mNavigationBar = null;
    private View bVY = null;
    private TextView hCd = null;
    private LinearLayout hCe = null;
    private HeadImageView hCf = null;
    private ClickableHeaderImageView hwr = null;
    private TextView bTX = null;
    private ImageView hCh = null;
    private TextView hwj = null;
    private TextView hCi = null;
    private TextView hCj = null;
    private EllipsizeRichTextView hCk = null;
    private TbImageView hCl = null;
    private PlayVoiceBntNew ZX = null;
    private TextView hCm = null;
    private MorePopupWindow hCq = null;
    private am hCr = null;
    private com.baidu.tbadk.core.dialog.b hCs = null;
    private Dialog hCu = null;
    private com.baidu.tbadk.core.dialog.a hwR = null;
    private boolean hpt = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cfu = null;
    private NewSubPbActivity.a hCw = null;
    private NewSubPbActivity.a hCx = null;
    private g gyT = null;
    private String hCy = null;
    private int cCy = 0;
    private PostData hkR = null;
    private int hCE = 0;
    private int hCF = 2;
    private int hCG = 0;
    private boolean ciS = true;
    private View.OnClickListener hpC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hCb.c(sparseArray);
                        return;
                    }
                    b.this.cs(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.hCb.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cbY = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
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
    protected AdapterView.OnItemLongClickListener hCI = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hCz, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hBF == null) {
                b.this.hBF = new y(b.this.hCb.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hBF.showDialog();
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
            b.this.hBF.a(sparseArray, b.this.hBC.bIm(), nj);
            if (nj) {
                b.this.hBF.bLK().setVisibility(0);
                b.this.hBF.bLK().setTag(postData.getId());
            } else {
                b.this.hBF.bLK().setVisibility(8);
            }
            b.this.hBF.bLI().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hCJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cZ(b.this.hCb.getPageContext().getPageActivity())) {
                if (b.this.hCb.gyL == null || b.this.hBC == null || b.this.hBC.bbJ() == null || b.this.hCb.gyL.hm(b.this.hBC.bbJ().replyPrivateFlag)) {
                    if (b.this.hBR != null) {
                        b.this.hBR.bgF();
                    }
                    b.this.bOj();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hCz, i);
                        if (postData == null) {
                            b.this.hCA = null;
                        } else {
                            b.this.hCA = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.gyT.setReplyId(str2);
                                b.this.gyT.oY(str);
                            }
                        }
                        b.this.bOk();
                        return;
                    }
                    b.this.bOl();
                    b.this.hBC.bOH();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dxT = null;
        this.hCa = null;
        this.mListView = null;
        this.hCb = null;
        this.eUU = null;
        this.hCc = null;
        this.hCg = null;
        this.hCo = null;
        this.hCt = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fnZ = null;
        this.hCB = null;
        this.hCC = null;
        this.hCD = null;
        this.hCb = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dxT = (RelativeLayout) LayoutInflater.from(this.hCb.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.hCa = LayoutInflater.from(this.hCb.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.hCB = (RelativeLayout) this.dxT.findViewById(d.g.subpb_editor_tool_comment);
        this.fnZ = (TextView) this.dxT.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.fnZ.setOnClickListener(this.mCommonClickListener);
        this.hCC = (ImageView) this.dxT.findViewById(d.g.subpb_editor_tool_more_img);
        this.hCD = (ImageView) this.dxT.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.hCD.setOnClickListener(this.mCommonClickListener);
        this.hCC.setOnClickListener(this.mCommonClickListener);
        this.eUU = (NoNetworkView) this.dxT.findViewById(d.g.view_no_network);
        bgN();
        bau();
        this.hCc = (RelativeLayout) this.dxT.findViewById(d.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dxT.findViewById(d.g.new_sub_pb_list);
        this.hCn = (ThreadSkinView) LayoutInflater.from(this.hCb.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hCn);
        this.mListView.addHeaderView(this.hCa);
        this.eLh = BdListViewHelper.a(this.hCb.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hCo = new e(this.hCb.getPageContext());
        this.hCo.aez();
        this.hCt = this.hCo.getView();
        this.mListView.setNextPage(this.hCo);
        this.hCo.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hCJ);
        this.mListView.setOnItemLongClickListener(this.hCI);
        this.mListView.setOnTouchListener(this.cbY);
        this.mProgress = (ProgressBar) this.dxT.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hCa != null) {
            this.hCa.setVisibility(4);
        }
        if (this.hCc != null) {
            this.hCc.setVisibility(4);
        }
        this.hCg = com.baidu.tbadk.ala.b.UK().n(this.hCb.getActivity(), 4);
        if (this.hCg != null) {
            this.hCg.setVisibility(8);
            this.hCe.addView(this.hCg, 3);
        }
        this.hCH = new d(this.hCb, this.mListView);
        this.hCH.setFromCDN(this.mIsFromCDN);
        this.hCH.t(this.mCommonClickListener);
        this.hCH.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bau() {
        this.hCe = (LinearLayout) this.hCa.findViewById(d.g.subpb_head_user_info_root);
        this.hCe.setOnClickListener(this.mCommonClickListener);
        this.hCf = (HeadImageView) this.hCa.findViewById(d.g.photo);
        this.hCf.setRadius(l.h(this.hCb.getActivity(), d.e.ds30));
        this.hCf.setClickable(false);
        this.hwr = (ClickableHeaderImageView) this.hCa.findViewById(d.g.god_user_photo);
        this.hwr.setGodIconMargin(0);
        this.hwr.setGodIconWidth(d.e.ds24);
        this.hwr.setRadius(l.h(this.hCb.getActivity(), d.e.ds30));
        this.hwr.setClickable(false);
        this.bTX = (TextView) this.hCa.findViewById(d.g.user_name);
        this.hCh = (ImageView) this.hCa.findViewById(d.g.user_rank);
        this.hCh.setVisibility(8);
        this.hwj = (TextView) this.hCa.findViewById(d.g.floor_owner);
        this.hCd = (TextView) this.hCa.findViewById(d.g.see_subject);
        this.hCd.setOnClickListener(this.mCommonClickListener);
        this.hCi = (TextView) this.hCa.findViewById(d.g.floor);
        this.hCj = (TextView) this.hCa.findViewById(d.g.time);
        this.hCk = (EllipsizeRichTextView) this.hCa.findViewById(d.g.content_text);
        this.hCk.setOnClickListener(this.mCommonClickListener);
        al.j(this.hCk, d.C0236d.cp_cont_b);
        this.hCk.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
        this.hCk.setLineSpacing(0.0f, 1.25f);
        this.hCl = (TbImageView) this.hCa.findViewById(d.g.sub_pb_image);
        this.hCl.setOnClickListener(this.mCommonClickListener);
        this.hCm = (TextView) this.hCa.findViewById(d.g.advert);
        this.ZX = (PlayVoiceBntNew) this.hCa.findViewById(d.g.voice_btn);
        this.hCa.setOnTouchListener(this.cbY);
        this.hCa.setOnClickListener(this.mCommonClickListener);
    }

    public void jH(boolean z) {
        if (this.eLh != null && this.eLh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eLh.getLayoutParams();
            if (z) {
                bgR();
                layoutParams.height = l.h(this.hCb.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.h(this.hCb.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.eLh.setLayoutParams(layoutParams);
        }
    }

    private void bgR() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0191b interfaceC0191b, boolean z) {
        if (this.hCv != null) {
            this.hCv.dismiss();
            this.hCv = null;
        }
        this.hCv = new com.baidu.tbadk.core.dialog.b(this.hCb.getPageContext().getPageActivity());
        if (z) {
            this.hCv.a(new String[]{this.hCb.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0191b);
        } else {
            this.hCv.a(new String[]{this.hCb.getPageContext().getString(d.j.save_to_emotion), this.hCb.getPageContext().getString(d.j.save_to_local)}, interfaceC0191b);
        }
        this.hCv.d(this.hCb.getPageContext());
        this.hCv.abc();
    }

    public void cw(View view) {
        this.hCp = view;
    }

    public View bgS() {
        return this.eLh;
    }

    public void bgN() {
        int h = l.h(this.hCb.getPageContext().getPageActivity(), d.e.ds88);
        int h2 = l.h(this.hCb.getPageContext().getPageActivity(), d.e.ds2);
        this.mNavigationBar = (NavigationBar) this.dxT.findViewById(d.g.view_navigation_bar);
        this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVY.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bVY != null && (this.bVY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bVY.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.bVY.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aDq() {
        return this.mNavigationBar;
    }

    public void cs(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.hCu == null) {
            this.hCu = new Dialog(this.hCb.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hCu.setCanceledOnTouchOutside(true);
            this.hCu.setCancelable(true);
            View inflate = LayoutInflater.from(this.hCb.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.hCb.getLayoutMode().onModeChanged(inflate);
            this.hCu.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hCu.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.hCb.getPageContext().getPageActivity()) * 0.9d);
            this.hCu.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hCu.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.hCu.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.hCu.findViewById(d.g.disable_reply_btn);
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
                    if (b.this.hCu != null && (b.this.hCu instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCu, b.this.hCb.getPageContext());
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
                    if (b.this.hCu != null && (b.this.hCu instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCu, b.this.hCb.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hCw != null) {
                        b.this.hCw.m(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show), sparseArray4.get(d.g.tag_forbid_user_portrait)});
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
                    if (b.this.hCu != null && (b.this.hCu instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCu, b.this.hCb.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hCb.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hCu, this.hCb.getPageContext());
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
        this.hwR = new com.baidu.tbadk.core.dialog.a(this.hCb.getPageContext().getPageActivity());
        this.hwR.gD(i3);
        this.hwR.ab(sparseArray);
        this.hwR.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hCx != null) {
                    b.this.hCx.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hwR.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwR.dq(true);
        this.hwR.b(this.hCb.getPageContext());
        if (z) {
            this.hwR.aaZ();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bbJ;
        if (this.hCb != null && sparseArray != null && this.hCa != null) {
            if (this.fzE == null) {
                this.fzE = new com.baidu.tieba.NEGFeedBack.e(this.hCb.getPageContext(), this.hCa);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hBC != null && (bbJ = this.hBC.bbJ()) != null && bbJ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbJ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fzE.setDefaultReasonArray(new String[]{this.hCb.getString(d.j.delete_thread_reason_1), this.hCb.getString(d.j.delete_thread_reason_2), this.hCb.getString(d.j.delete_thread_reason_3), this.hCb.getString(d.j.delete_thread_reason_4), this.hCb.getString(d.j.delete_thread_reason_5)});
            this.fzE.setData(ajVar);
            this.fzE.qk("4");
            this.fzE.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    String x = ap.x(jSONArray);
                    if (b.this.hCx != null) {
                        b.this.hCx.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type), x});
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
        this.hCw = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hCx = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hCb.showToast(this.hCb.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.hCb.showToast(str);
        }
    }

    public void bL(View view) {
        if (this.eLh != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eLh.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.eLh);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eLh.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.hCb.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.eLh, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.alT() != null) {
            this.gyT = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dxT.addView(gVar.alT(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hBR = aVar;
    }

    public void bOj() {
        if (this.mListView != null) {
            this.hCG = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBC == null || this.hBC.bOE() == null) {
            return false;
        }
        if (this.hBC.bIm() != 0) {
            return false;
        }
        return (this.hAH == null || this.hAH.WR() == null || this.hAH.WR().YR() == null || !TextUtils.equals(this.hAH.WR().YR().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bOk() {
        if (this.hBC != null) {
            if ((!bOn() && this.hCt != null && this.hCt.isShown()) || v.T(this.hCz)) {
                this.hBC.oo(false);
            } else {
                this.hBC.oo(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hBC = subPbModel;
    }

    public void bOl() {
        b(this.hCb);
        this.mListView.setNextPage(this.hCo);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.pX(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bOn() && this.hCt != null && this.hCt.isShown()) {
                i = (this.hCG - this.hCF) - 1;
            } else {
                i = this.hCG - this.hCF;
            }
            int S = v.S(this.hCz);
            if (i > S) {
                i = S;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hCz, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hCG + 2);
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
        return this.dxT;
    }

    public void bNa() {
        if (this.hCq != null) {
            com.baidu.adp.lib.g.g.a(this.hCq, this.hCb.getPageContext().getPageActivity());
        }
        if (this.hCs != null) {
            this.hCs.dismiss();
        }
        if (this.hwR != null) {
            this.hwR.dismiss();
        }
        if (this.hCu != null) {
            com.baidu.adp.lib.g.g.b(this.hCu, this.hCb.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hBF != null) {
            this.hBF.dismiss();
        }
    }

    public void bOm() {
        this.mListView.setNextPage(this.hCo);
        this.hCo.aeC();
    }

    public void nc(boolean z) {
        this.hpt = z;
    }

    public void setIsFromPb(boolean z) {
        this.ciS = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.ciS && this.hCa != null) {
                this.hCa.setVisibility(8);
                this.mListView.removeHeaderView(this.hCa);
                this.hCF = 1;
            }
            this.hAH = jVar;
            if (this.hCa != null) {
                this.hCa.setVisibility(0);
            }
            if (this.hCc != null) {
                this.hCc.setVisibility(0);
            }
            if (jVar.bIE() != null) {
                this.hCy = jVar.bIE().getId();
                this.cCy = jVar.bIE().cer();
                if (this.cCy > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hCb.getResources().getString(d.j.subpb_floor_reply), Integer.valueOf(this.cCy)));
                    if (this.hCb != null) {
                        this.fnZ.setText(this.hCb.bMs());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hCb.bOh() ? "PB" : null;
                if (jVar.bIE().Zm() != null) {
                    this.hCn.setData(this.hCb.getPageContext(), jVar.bIE().Zm(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bIK().getId(), jVar.bIK().getName(), jVar.WR().getId(), str));
                } else {
                    this.hCn.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.hCo.aeC();
                this.hCH.setHasMoreData(true);
            } else {
                this.hCo.aeD();
                this.hCH.setHasMoreData(false);
            }
            this.hCz = jVar.bII();
            if (this.hCz == null || this.hCz.size() <= hBZ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hCz.size() - hBZ;
                wH(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hCz);
            if (v.T(this.hCz)) {
                this.mListView.setNextPage(null);
                if (this.ciS) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hCo);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.ciS) {
                arrayList.add(0, jVar.bIE());
            }
            this.hCH.b(this.hAH.WR(), arrayList);
            a(jVar.bIE(), jVar.bvv(), jVar.Vb(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void wH(int i) {
        if (this.hCz != null) {
            if (this.hCz.size() <= i) {
                this.hCz.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hCz.iterator();
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

    public boolean bOn() {
        return this.hCH.HA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.ciS) {
            this.hkR = postData;
            if (!StringUtils.isNull(postData.cey())) {
                this.hCl.setVisibility(0);
                this.hCl.startLoad(postData.cey(), 10, true);
            } else {
                this.hCl.setVisibility(8);
            }
            i ceA = postData.ceA();
            if (ceA != null && ceA.iFR) {
                this.hCm.setVisibility(0);
            } else {
                this.hCm.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hCa.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hCa.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hCi.setText((CharSequence) null);
            this.bTX.setText((CharSequence) null);
            this.hwj.setVisibility(8);
            if (!this.ciS) {
                c(postData.YR());
                if (z) {
                    this.hwj.setVisibility(0);
                    al.j(this.hwj, d.C0236d.cp_link_tip_a);
                }
            }
            this.hCj.setText(ap.ao(postData.getTime()));
            this.hCi.setText(String.format(this.hCb.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.cer())));
            postData.YR().getUserTbVipInfoData();
            boolean a = a(this.hCk, postData.cet());
            if (StringUtils.isNull(postData.cey()) && !a && postData.asG() != null) {
                this.ZX.setVisibility(0);
                this.ZX.setTag(postData.asG());
                return;
            }
            this.ZX.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + ab.pO(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bTX.setText(bN(metaData.getSealPrefix(), name_show));
            } else {
                this.bTX.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.hCg != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hCg.setVisibility(8);
                } else {
                    this.hCg.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsI = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hCg.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hwr.setVisibility(0);
                this.hCf.setVisibility(8);
                this.hwr.setUserId(metaData.getUserId());
                this.hwr.setUserName(metaData.getUserName());
                this.hwr.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bTX, d.C0236d.cp_cont_r);
            } else {
                this.hwr.setVisibility(8);
                this.hCf.setVisibility(0);
                this.hCf.setUserId(metaData.getUserId());
                this.hCf.setUserName(metaData.getUserName());
                this.hCf.setDefaultResource(d.f.transparent_bg);
                this.hCf.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.hCf.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bTX, d.C0236d.cp_cont_c);
            }
            this.hCe.setTag(d.g.tag_user_id, metaData.getUserId());
            this.hCe.setTag(d.g.tag_user_name, metaData.getUserName());
            this.hCe.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.asx() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.asx().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.asF());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fu(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cmX());
                        continue;
                    case 17:
                        String str = next.asJ().mGifInfo.mSharpText;
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
        if (!tbRichTextData.asO()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.asF() == null || tbRichTextData.asF().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.asF());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hCb.getPageContext().getString(d.j.refresh_view_title_text), this.bug));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hCb.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hCc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.new_pic_emotion_07, l.h(pageActivity, d.e.ds250), l.h(pageActivity, d.e.ds480), l.h(pageActivity, d.e.ds360)), dVar, a);
        }
        this.hCc.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gyT.amQ();
        al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hCb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void nS(int i) {
        b(NoDataViewFactory.d.ad(i, d.j.refresh_view_title_text));
        if (this.hBR != null) {
            this.hBR.cu(this.dxT);
        }
        this.hCB.setVisibility(8);
    }

    public void vm(String str) {
        b(NoDataViewFactory.d.bM(str, this.hCb.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.hBR != null) {
            this.hBR.cu(this.dxT);
        }
        this.hCB.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hCB.setVisibility(0);
            this.dxT.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bug = onClickListener;
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
                String userId2 = postData.YR().getUserId();
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
            if (this.hAH != null && this.hAH.WR() != null && this.hAH.WR().YR() != null && postData.YR() != null) {
                String userId3 = this.hAH.WR().YR().getUserId();
                String userId4 = postData.YR().getUserId();
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
                    userId = postData.YR().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.cer() != 1 ? 0 : 1;
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
                        if (postData.YR() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.YR().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.YR().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.YR().getPortrait());
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
                        if (postData.YR() != null) {
                            sparseArray.put(d.g.tag_forbid_user_name, postData.YR().getUserName());
                            sparseArray.put(d.g.tag_forbid_user_name_show, postData.YR().getName_show());
                            sparseArray.put(d.g.tag_forbid_user_portrait, postData.YR().getPortrait());
                        }
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.YR() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.YR().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.YR().getUserName());
                            sparseArray.put(d.g.tag_user_mute_mute_nameshow, postData.YR().getName_show());
                        }
                        if (this.hAH.WR() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hAH.WR().getId());
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
            userId = postData.YR().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.cer() != 1) {
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
        if (this.hBF != null && this.hBF.bLI() != null) {
            if (z) {
                this.hBF.bLI().setText(d.j.remove_mark);
            } else {
                this.hBF.bLI().setText(d.j.mark);
            }
        }
    }

    public View bOo() {
        return this.hCt;
    }

    public void onChangeSkinType(int i) {
        this.hCb.getLayoutMode().setNightMode(i == 1);
        this.hCb.getLayoutMode().onModeChanged(this.dxT);
        this.hCb.getLayoutMode().onModeChanged(this.hCa);
        this.mNavigationBar.onChangeSkinType(this.hCb.getPageContext(), i);
        if (this.hCd != null) {
            al.j(this.hCd, d.C0236d.goto_see_subject_color);
        }
        this.eUU.onChangeSkinType(this.hCb.getPageContext(), i);
        this.hCb.getLayoutMode().onModeChanged(this.hCt);
        al.j(this.hCk, d.C0236d.cp_cont_b);
        this.hCk.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
        if (this.gyT != null && this.gyT.alT() != null) {
            this.gyT.alT().onChangeSkinType(i);
        }
        this.hCo.ic(i);
        this.ZX.bxW();
        al.j(this.fnZ, d.C0236d.cp_cont_e);
        al.j(this.hwj, d.C0236d.cp_link_tip_a);
        al.j(this.bTX, d.C0236d.cp_cont_c);
        this.fnZ.setAlpha(0.95f);
        if (this.hCp != null) {
            com.baidu.tbadk.r.a.a(this.hCb.getPageContext(), this.hCp);
        }
        if (this.hCH != null) {
            this.hCH.notifyDataSetChanged();
        }
    }

    public void bOp() {
        this.mProgress.setVisibility(0);
    }

    public void bOq() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hCo.aeD();
    }

    public void aYW() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hCo.aYW();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfu = onLongClickListener;
        this.hCH.c(onLongClickListener);
    }

    public View bOr() {
        return this.hCa;
    }

    public TextView bgT() {
        return this.fnZ;
    }

    public ImageView bOs() {
        return this.hCC;
    }

    public ImageView bOt() {
        return this.hCD;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void wI(int i) {
    }

    public View bOu() {
        return this.hCd;
    }

    public View bOv() {
        return this.hCl;
    }

    public MorePopupWindow bOw() {
        return this.hCq;
    }

    public void showLoadingDialog() {
        if (this.esg == null) {
            this.esg = new com.baidu.tbadk.core.view.b(this.hCb.getPageContext());
        }
        this.esg.dJ(true);
    }

    public void aMF() {
        if (this.esg != null) {
            this.esg.dJ(false);
        }
    }

    public TextView bOx() {
        return this.hCk;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hBH = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCH.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hCH != null) {
            this.hCH.notifyDataSetChanged();
        }
    }

    public y bOy() {
        return this.hBF;
    }

    public void biR() {
    }

    public void biS() {
    }

    public void onActivityDestroy() {
    }

    public void bOz() {
        if (this.hCb.isPaused()) {
        }
    }

    public View bOA() {
        return this.hCe;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return n.a((Context) this.hCb.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bOB() {
        if (this.gyT == null || this.gyT.alT() == null) {
            return 0;
        }
        return this.gyT.alT().getHeight();
    }
}
