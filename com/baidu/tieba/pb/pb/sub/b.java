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
    private static final int hBY = TbadkCoreApplication.getInst().getListItemRule().agv();
    private RelativeLayout dxT;
    private View eLh;
    private NoNetworkView eUU;
    private com.baidu.tbadk.core.view.b esg;
    private TextView fnZ;
    private com.baidu.tieba.NEGFeedBack.e fzE;
    private j hAG;
    private SubPbModel hBB;
    private y hBE;
    private a hBQ;
    private View hBZ;
    private RelativeLayout hCA;
    private ImageView hCB;
    private ImageView hCC;
    private d hCG;
    private NewSubPbActivity hCa;
    private RelativeLayout hCb;
    private View hCf;
    private ThreadSkinView hCm;
    private e hCn;
    private View hCo;
    private View hCs;
    private com.baidu.tbadk.core.dialog.b hCu;
    private ArrayList<PostData> hCy;
    private String hCz;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bug = null;
    private TbRichTextView.i hBG = null;
    private NavigationBar mNavigationBar = null;
    private View bVY = null;
    private TextView hCc = null;
    private LinearLayout hCd = null;
    private HeadImageView hCe = null;
    private ClickableHeaderImageView hwq = null;
    private TextView bTX = null;
    private ImageView hCg = null;
    private TextView hwi = null;
    private TextView hCh = null;
    private TextView hCi = null;
    private EllipsizeRichTextView hCj = null;
    private TbImageView hCk = null;
    private PlayVoiceBntNew ZX = null;
    private TextView hCl = null;
    private MorePopupWindow hCp = null;
    private am hCq = null;
    private com.baidu.tbadk.core.dialog.b hCr = null;
    private Dialog hCt = null;
    private com.baidu.tbadk.core.dialog.a hwQ = null;
    private boolean hps = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cfu = null;
    private NewSubPbActivity.a hCv = null;
    private NewSubPbActivity.a hCw = null;
    private g gyS = null;
    private String hCx = null;
    private int cCy = 0;
    private PostData hkQ = null;
    private int hCD = 0;
    private int hCE = 2;
    private int hCF = 0;
    private boolean ciS = true;
    private View.OnClickListener hpB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hCa.c(sparseArray);
                        return;
                    }
                    b.this.cs(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.hCa.c(sparseArray);
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
    protected AdapterView.OnItemLongClickListener hCH = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hCy, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hBE == null) {
                b.this.hBE = new y(b.this.hCa.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hBE.showDialog();
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
            b.this.hBE.a(sparseArray, b.this.hBB.bIl(), nj);
            if (nj) {
                b.this.hBE.bLJ().setVisibility(0);
                b.this.hBE.bLJ().setTag(postData.getId());
            } else {
                b.this.hBE.bLJ().setVisibility(8);
            }
            b.this.hBE.bLH().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hCI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cZ(b.this.hCa.getPageContext().getPageActivity())) {
                if (b.this.hCa.gyK == null || b.this.hBB == null || b.this.hBB.bbI() == null || b.this.hCa.gyK.hm(b.this.hBB.bbI().replyPrivateFlag)) {
                    if (b.this.hBQ != null) {
                        b.this.hBQ.bgE();
                    }
                    b.this.bOi();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hCy, i);
                        if (postData == null) {
                            b.this.hCz = null;
                        } else {
                            b.this.hCz = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.gyS.setReplyId(str2);
                                b.this.gyS.oY(str);
                            }
                        }
                        b.this.bOj();
                        return;
                    }
                    b.this.bOk();
                    b.this.hBB.bOG();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dxT = null;
        this.hBZ = null;
        this.mListView = null;
        this.hCa = null;
        this.eUU = null;
        this.hCb = null;
        this.hCf = null;
        this.hCn = null;
        this.hCs = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fnZ = null;
        this.hCA = null;
        this.hCB = null;
        this.hCC = null;
        this.hCa = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dxT = (RelativeLayout) LayoutInflater.from(this.hCa.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.hBZ = LayoutInflater.from(this.hCa.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.hCA = (RelativeLayout) this.dxT.findViewById(d.g.subpb_editor_tool_comment);
        this.fnZ = (TextView) this.dxT.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.fnZ.setOnClickListener(this.mCommonClickListener);
        this.hCB = (ImageView) this.dxT.findViewById(d.g.subpb_editor_tool_more_img);
        this.hCC = (ImageView) this.dxT.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.hCC.setOnClickListener(this.mCommonClickListener);
        this.hCB.setOnClickListener(this.mCommonClickListener);
        this.eUU = (NoNetworkView) this.dxT.findViewById(d.g.view_no_network);
        bgM();
        bat();
        this.hCb = (RelativeLayout) this.dxT.findViewById(d.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dxT.findViewById(d.g.new_sub_pb_list);
        this.hCm = (ThreadSkinView) LayoutInflater.from(this.hCa.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hCm);
        this.mListView.addHeaderView(this.hBZ);
        this.eLh = BdListViewHelper.a(this.hCa.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hCn = new e(this.hCa.getPageContext());
        this.hCn.aez();
        this.hCs = this.hCn.getView();
        this.mListView.setNextPage(this.hCn);
        this.hCn.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hCI);
        this.mListView.setOnItemLongClickListener(this.hCH);
        this.mListView.setOnTouchListener(this.cbY);
        this.mProgress = (ProgressBar) this.dxT.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hBZ != null) {
            this.hBZ.setVisibility(4);
        }
        if (this.hCb != null) {
            this.hCb.setVisibility(4);
        }
        this.hCf = com.baidu.tbadk.ala.b.UK().n(this.hCa.getActivity(), 4);
        if (this.hCf != null) {
            this.hCf.setVisibility(8);
            this.hCd.addView(this.hCf, 3);
        }
        this.hCG = new d(this.hCa, this.mListView);
        this.hCG.setFromCDN(this.mIsFromCDN);
        this.hCG.t(this.mCommonClickListener);
        this.hCG.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bat() {
        this.hCd = (LinearLayout) this.hBZ.findViewById(d.g.subpb_head_user_info_root);
        this.hCd.setOnClickListener(this.mCommonClickListener);
        this.hCe = (HeadImageView) this.hBZ.findViewById(d.g.photo);
        this.hCe.setRadius(l.h(this.hCa.getActivity(), d.e.ds30));
        this.hCe.setClickable(false);
        this.hwq = (ClickableHeaderImageView) this.hBZ.findViewById(d.g.god_user_photo);
        this.hwq.setGodIconMargin(0);
        this.hwq.setGodIconWidth(d.e.ds24);
        this.hwq.setRadius(l.h(this.hCa.getActivity(), d.e.ds30));
        this.hwq.setClickable(false);
        this.bTX = (TextView) this.hBZ.findViewById(d.g.user_name);
        this.hCg = (ImageView) this.hBZ.findViewById(d.g.user_rank);
        this.hCg.setVisibility(8);
        this.hwi = (TextView) this.hBZ.findViewById(d.g.floor_owner);
        this.hCc = (TextView) this.hBZ.findViewById(d.g.see_subject);
        this.hCc.setOnClickListener(this.mCommonClickListener);
        this.hCh = (TextView) this.hBZ.findViewById(d.g.floor);
        this.hCi = (TextView) this.hBZ.findViewById(d.g.time);
        this.hCj = (EllipsizeRichTextView) this.hBZ.findViewById(d.g.content_text);
        this.hCj.setOnClickListener(this.mCommonClickListener);
        al.j(this.hCj, d.C0236d.cp_cont_b);
        this.hCj.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
        this.hCj.setLineSpacing(0.0f, 1.25f);
        this.hCk = (TbImageView) this.hBZ.findViewById(d.g.sub_pb_image);
        this.hCk.setOnClickListener(this.mCommonClickListener);
        this.hCl = (TextView) this.hBZ.findViewById(d.g.advert);
        this.ZX = (PlayVoiceBntNew) this.hBZ.findViewById(d.g.voice_btn);
        this.hBZ.setOnTouchListener(this.cbY);
        this.hBZ.setOnClickListener(this.mCommonClickListener);
    }

    public void jH(boolean z) {
        if (this.eLh != null && this.eLh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eLh.getLayoutParams();
            if (z) {
                bgQ();
                layoutParams.height = l.h(this.hCa.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.h(this.hCa.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.eLh.setLayoutParams(layoutParams);
        }
    }

    private void bgQ() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0191b interfaceC0191b, boolean z) {
        if (this.hCu != null) {
            this.hCu.dismiss();
            this.hCu = null;
        }
        this.hCu = new com.baidu.tbadk.core.dialog.b(this.hCa.getPageContext().getPageActivity());
        if (z) {
            this.hCu.a(new String[]{this.hCa.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0191b);
        } else {
            this.hCu.a(new String[]{this.hCa.getPageContext().getString(d.j.save_to_emotion), this.hCa.getPageContext().getString(d.j.save_to_local)}, interfaceC0191b);
        }
        this.hCu.d(this.hCa.getPageContext());
        this.hCu.abc();
    }

    public void cw(View view) {
        this.hCo = view;
    }

    public View bgR() {
        return this.eLh;
    }

    public void bgM() {
        int h = l.h(this.hCa.getPageContext().getPageActivity(), d.e.ds88);
        int h2 = l.h(this.hCa.getPageContext().getPageActivity(), d.e.ds2);
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

    public NavigationBar aDp() {
        return this.mNavigationBar;
    }

    public void cs(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.hCt == null) {
            this.hCt = new Dialog(this.hCa.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hCt.setCanceledOnTouchOutside(true);
            this.hCt.setCancelable(true);
            View inflate = LayoutInflater.from(this.hCa.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.hCa.getLayoutMode().onModeChanged(inflate);
            this.hCt.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hCt.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.hCa.getPageContext().getPageActivity()) * 0.9d);
            this.hCt.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hCt.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.hCt.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.hCt.findViewById(d.g.disable_reply_btn);
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
                    if (b.this.hCt != null && (b.this.hCt instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCt, b.this.hCa.getPageContext());
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
                    if (b.this.hCt != null && (b.this.hCt instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCt, b.this.hCa.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hCv != null) {
                        b.this.hCv.m(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show), sparseArray4.get(d.g.tag_forbid_user_portrait)});
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
                    if (b.this.hCt != null && (b.this.hCt instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCt, b.this.hCa.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hCa.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hCt, this.hCa.getPageContext());
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
        this.hwQ = new com.baidu.tbadk.core.dialog.a(this.hCa.getPageContext().getPageActivity());
        this.hwQ.gD(i3);
        this.hwQ.ab(sparseArray);
        this.hwQ.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hCw != null) {
                    b.this.hCw.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hwQ.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwQ.dq(true);
        this.hwQ.b(this.hCa.getPageContext());
        if (z) {
            this.hwQ.aaZ();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bbI;
        if (this.hCa != null && sparseArray != null && this.hBZ != null) {
            if (this.fzE == null) {
                this.fzE = new com.baidu.tieba.NEGFeedBack.e(this.hCa.getPageContext(), this.hBZ);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hBB != null && (bbI = this.hBB.bbI()) != null && bbI.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbI.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fzE.setDefaultReasonArray(new String[]{this.hCa.getString(d.j.delete_thread_reason_1), this.hCa.getString(d.j.delete_thread_reason_2), this.hCa.getString(d.j.delete_thread_reason_3), this.hCa.getString(d.j.delete_thread_reason_4), this.hCa.getString(d.j.delete_thread_reason_5)});
            this.fzE.setData(ajVar);
            this.fzE.qj("4");
            this.fzE.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    String x = ap.x(jSONArray);
                    if (b.this.hCw != null) {
                        b.this.hCw.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type), x});
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
        this.hCv = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hCw = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hCa.showToast(this.hCa.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.hCa.showToast(str);
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
                this.eLh.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.hCa.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.eLh, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.alT() != null) {
            this.gyS = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dxT.addView(gVar.alT(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hBQ = aVar;
    }

    public void bOi() {
        if (this.mListView != null) {
            this.hCF = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBB == null || this.hBB.bOD() == null) {
            return false;
        }
        if (this.hBB.bIl() != 0) {
            return false;
        }
        return (this.hAG == null || this.hAG.WR() == null || this.hAG.WR().YR() == null || !TextUtils.equals(this.hAG.WR().YR().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bOj() {
        if (this.hBB != null) {
            if ((!bOm() && this.hCs != null && this.hCs.isShown()) || v.T(this.hCy)) {
                this.hBB.oo(false);
            } else {
                this.hBB.oo(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hBB = subPbModel;
    }

    public void bOk() {
        b(this.hCa);
        this.mListView.setNextPage(this.hCn);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.pX(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bOm() && this.hCs != null && this.hCs.isShown()) {
                i = (this.hCF - this.hCE) - 1;
            } else {
                i = this.hCF - this.hCE;
            }
            int S = v.S(this.hCy);
            if (i > S) {
                i = S;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hCy, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hCF + 2);
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

    public void bMZ() {
        if (this.hCp != null) {
            com.baidu.adp.lib.g.g.a(this.hCp, this.hCa.getPageContext().getPageActivity());
        }
        if (this.hCr != null) {
            this.hCr.dismiss();
        }
        if (this.hwQ != null) {
            this.hwQ.dismiss();
        }
        if (this.hCt != null) {
            com.baidu.adp.lib.g.g.b(this.hCt, this.hCa.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hBE != null) {
            this.hBE.dismiss();
        }
    }

    public void bOl() {
        this.mListView.setNextPage(this.hCn);
        this.hCn.aeC();
    }

    public void nc(boolean z) {
        this.hps = z;
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
            if (this.ciS && this.hBZ != null) {
                this.hBZ.setVisibility(8);
                this.mListView.removeHeaderView(this.hBZ);
                this.hCE = 1;
            }
            this.hAG = jVar;
            if (this.hBZ != null) {
                this.hBZ.setVisibility(0);
            }
            if (this.hCb != null) {
                this.hCb.setVisibility(0);
            }
            if (jVar.bID() != null) {
                this.hCx = jVar.bID().getId();
                this.cCy = jVar.bID().ceq();
                if (this.cCy > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hCa.getResources().getString(d.j.subpb_floor_reply), Integer.valueOf(this.cCy)));
                    if (this.hCa != null) {
                        this.fnZ.setText(this.hCa.bMr());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hCa.bOg() ? "PB" : null;
                if (jVar.bID().Zm() != null) {
                    this.hCm.setData(this.hCa.getPageContext(), jVar.bID().Zm(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bIJ().getId(), jVar.bIJ().getName(), jVar.WR().getId(), str));
                } else {
                    this.hCm.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.hCn.aeC();
                this.hCG.setHasMoreData(true);
            } else {
                this.hCn.aeD();
                this.hCG.setHasMoreData(false);
            }
            this.hCy = jVar.bIH();
            if (this.hCy == null || this.hCy.size() <= hBY) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hCy.size() - hBY;
                wH(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hCy);
            if (v.T(this.hCy)) {
                this.mListView.setNextPage(null);
                if (this.ciS) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hCn);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.ciS) {
                arrayList.add(0, jVar.bID());
            }
            this.hCG.b(this.hAG.WR(), arrayList);
            a(jVar.bID(), jVar.bvu(), jVar.Vb(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void wH(int i) {
        if (this.hCy != null) {
            if (this.hCy.size() <= i) {
                this.hCy.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hCy.iterator();
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

    public boolean bOm() {
        return this.hCG.HA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.ciS) {
            this.hkQ = postData;
            if (!StringUtils.isNull(postData.cex())) {
                this.hCk.setVisibility(0);
                this.hCk.startLoad(postData.cex(), 10, true);
            } else {
                this.hCk.setVisibility(8);
            }
            i cez = postData.cez();
            if (cez != null && cez.iFQ) {
                this.hCl.setVisibility(0);
            } else {
                this.hCl.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hBZ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hBZ.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hCh.setText((CharSequence) null);
            this.bTX.setText((CharSequence) null);
            this.hwi.setVisibility(8);
            if (!this.ciS) {
                c(postData.YR());
                if (z) {
                    this.hwi.setVisibility(0);
                    al.j(this.hwi, d.C0236d.cp_link_tip_a);
                }
            }
            this.hCi.setText(ap.ao(postData.getTime()));
            this.hCh.setText(String.format(this.hCa.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.ceq())));
            postData.YR().getUserTbVipInfoData();
            boolean a = a(this.hCj, postData.ces());
            if (StringUtils.isNull(postData.cex()) && !a && postData.asF() != null) {
                this.ZX.setVisibility(0);
                this.ZX.setTag(postData.asF());
                return;
            }
            this.ZX.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + ab.pN(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bTX.setText(bN(metaData.getSealPrefix(), name_show));
            } else {
                this.bTX.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.hCf != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hCf.setVisibility(8);
                } else {
                    this.hCf.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsI = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hCf.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hwq.setVisibility(0);
                this.hCe.setVisibility(8);
                this.hwq.setUserId(metaData.getUserId());
                this.hwq.setUserName(metaData.getUserName());
                this.hwq.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bTX, d.C0236d.cp_cont_r);
            } else {
                this.hwq.setVisibility(8);
                this.hCe.setVisibility(0);
                this.hCe.setUserId(metaData.getUserId());
                this.hCe.setUserName(metaData.getUserName());
                this.hCe.setDefaultResource(d.f.transparent_bg);
                this.hCe.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.hCe.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bTX, d.C0236d.cp_cont_c);
            }
            this.hCd.setTag(d.g.tag_user_id, metaData.getUserId());
            this.hCd.setTag(d.g.tag_user_name, metaData.getUserName());
            this.hCd.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.asw() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.asw().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.asE());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fu(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cmN());
                        continue;
                    case 17:
                        String str = next.asI().mGifInfo.mSharpText;
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
        if (!tbRichTextData.asN()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.asE() == null || tbRichTextData.asE().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.asE());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hCa.getPageContext().getString(d.j.refresh_view_title_text), this.bug));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hCa.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hCb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.new_pic_emotion_07, l.h(pageActivity, d.e.ds250), l.h(pageActivity, d.e.ds480), l.h(pageActivity, d.e.ds360)), dVar, a);
        }
        this.hCb.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gyS.amQ();
        al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hCa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void nS(int i) {
        b(NoDataViewFactory.d.ad(i, d.j.refresh_view_title_text));
        if (this.hBQ != null) {
            this.hBQ.cu(this.dxT);
        }
        this.hCA.setVisibility(8);
    }

    public void vl(String str) {
        b(NoDataViewFactory.d.bM(str, this.hCa.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.hBQ != null) {
            this.hBQ.cu(this.dxT);
        }
        this.hCA.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hCA.setVisibility(0);
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
            if (this.hAG != null && this.hAG.WR() != null && this.hAG.WR().YR() != null && postData.YR() != null) {
                String userId3 = this.hAG.WR().YR().getUserId();
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
                    int i2 = postData.ceq() != 1 ? 0 : 1;
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
                        if (this.hAG.WR() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hAG.WR().getId());
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
            if (postData.ceq() != 1) {
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
        if (this.hBE != null && this.hBE.bLH() != null) {
            if (z) {
                this.hBE.bLH().setText(d.j.remove_mark);
            } else {
                this.hBE.bLH().setText(d.j.mark);
            }
        }
    }

    public View bOn() {
        return this.hCs;
    }

    public void onChangeSkinType(int i) {
        this.hCa.getLayoutMode().setNightMode(i == 1);
        this.hCa.getLayoutMode().onModeChanged(this.dxT);
        this.hCa.getLayoutMode().onModeChanged(this.hBZ);
        this.mNavigationBar.onChangeSkinType(this.hCa.getPageContext(), i);
        if (this.hCc != null) {
            al.j(this.hCc, d.C0236d.goto_see_subject_color);
        }
        this.eUU.onChangeSkinType(this.hCa.getPageContext(), i);
        this.hCa.getLayoutMode().onModeChanged(this.hCs);
        al.j(this.hCj, d.C0236d.cp_cont_b);
        this.hCj.setLinkTextColor(al.getColor(d.C0236d.cp_link_tip_c));
        if (this.gyS != null && this.gyS.alT() != null) {
            this.gyS.alT().onChangeSkinType(i);
        }
        this.hCn.ic(i);
        this.ZX.bxV();
        al.j(this.fnZ, d.C0236d.cp_cont_e);
        al.j(this.hwi, d.C0236d.cp_link_tip_a);
        al.j(this.bTX, d.C0236d.cp_cont_c);
        this.fnZ.setAlpha(0.95f);
        if (this.hCo != null) {
            com.baidu.tbadk.r.a.a(this.hCa.getPageContext(), this.hCo);
        }
        if (this.hCG != null) {
            this.hCG.notifyDataSetChanged();
        }
    }

    public void bOo() {
        this.mProgress.setVisibility(0);
    }

    public void bOp() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hCn.aeD();
    }

    public void aYV() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hCn.aYV();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfu = onLongClickListener;
        this.hCG.c(onLongClickListener);
    }

    public View bOq() {
        return this.hBZ;
    }

    public TextView bgS() {
        return this.fnZ;
    }

    public ImageView bOr() {
        return this.hCB;
    }

    public ImageView bOs() {
        return this.hCC;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void wI(int i) {
    }

    public View bOt() {
        return this.hCc;
    }

    public View bOu() {
        return this.hCk;
    }

    public MorePopupWindow bOv() {
        return this.hCp;
    }

    public void showLoadingDialog() {
        if (this.esg == null) {
            this.esg = new com.baidu.tbadk.core.view.b(this.hCa.getPageContext());
        }
        this.esg.dJ(true);
    }

    public void aME() {
        if (this.esg != null) {
            this.esg.dJ(false);
        }
    }

    public TextView bOw() {
        return this.hCj;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hBG = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCG.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hCG != null) {
            this.hCG.notifyDataSetChanged();
        }
    }

    public y bOx() {
        return this.hBE;
    }

    public void biQ() {
    }

    public void biR() {
    }

    public void onActivityDestroy() {
    }

    public void bOy() {
        if (this.hCa.isPaused()) {
        }
    }

    public View bOz() {
        return this.hCd;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return n.a((Context) this.hCa.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bOA() {
        if (this.gyS == null || this.gyS.alT() == null) {
            return 0;
        }
        return this.gyS.alT().getHeight();
    }
}
