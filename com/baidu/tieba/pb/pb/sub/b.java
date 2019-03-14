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
    private static final int hBT = TbadkCoreApplication.getInst().getListItemRule().agv();
    private RelativeLayout dxP;
    private View eLd;
    private NoNetworkView eUQ;
    private com.baidu.tbadk.core.view.b esc;
    private TextView fnY;
    private com.baidu.tieba.NEGFeedBack.e fzD;
    private j hAB;
    private a hBL;
    private View hBU;
    private NewSubPbActivity hBV;
    private RelativeLayout hBW;
    private SubPbModel hBw;
    private y hBz;
    private d hCB;
    private View hCa;
    private ThreadSkinView hCh;
    private e hCi;
    private View hCj;
    private View hCn;
    private com.baidu.tbadk.core.dialog.b hCp;
    private ArrayList<PostData> hCt;
    private String hCu;
    private RelativeLayout hCv;
    private ImageView hCw;
    private ImageView hCx;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bui = null;
    private TbRichTextView.i hBB = null;
    private NavigationBar mNavigationBar = null;
    private View bVZ = null;
    private TextView hBX = null;
    private LinearLayout hBY = null;
    private HeadImageView hBZ = null;
    private ClickableHeaderImageView hwk = null;
    private TextView bTY = null;
    private ImageView hCb = null;
    private TextView hwc = null;
    private TextView hCc = null;
    private TextView hCd = null;
    private EllipsizeRichTextView hCe = null;
    private TbImageView hCf = null;
    private PlayVoiceBntNew ZY = null;
    private TextView hCg = null;
    private MorePopupWindow hCk = null;
    private am hCl = null;
    private com.baidu.tbadk.core.dialog.b hCm = null;
    private Dialog hCo = null;
    private com.baidu.tbadk.core.dialog.a hwK = null;
    private boolean hpm = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cfu = null;
    private NewSubPbActivity.a hCq = null;
    private NewSubPbActivity.a hCr = null;
    private g gyS = null;
    private String hCs = null;
    private int cCv = 0;
    private PostData hkQ = null;
    private int hCy = 0;
    private int hCz = 2;
    private int hCA = 0;
    private boolean ciS = true;
    private View.OnClickListener hpv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.hBV.c(sparseArray);
                        return;
                    }
                    b.this.cs(view);
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.hBV.c(sparseArray);
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
    protected AdapterView.OnItemLongClickListener hCC = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.hCt, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.hBz == null) {
                b.this.hBz = new y(b.this.hBV.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.hBz.showDialog();
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
            b.this.hBz.a(sparseArray, b.this.hBw.bIl(), nj);
            if (nj) {
                b.this.hBz.bLJ().setVisibility(0);
                b.this.hBz.bLJ().setTag(postData.getId());
            } else {
                b.this.hBz.bLJ().setVisibility(8);
            }
            b.this.hBz.bLH().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener hCD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.cZ(b.this.hBV.getPageContext().getPageActivity())) {
                if (b.this.hBV.gyK == null || b.this.hBw == null || b.this.hBw.bbI() == null || b.this.hBV.gyK.hm(b.this.hBw.bbI().replyPrivateFlag)) {
                    if (b.this.hBL != null) {
                        b.this.hBL.bgE();
                    }
                    b.this.bOj();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.hCt, i);
                        if (postData == null) {
                            b.this.hCu = null;
                        } else {
                            b.this.hCu = postData.getId();
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
                        b.this.bOk();
                        return;
                    }
                    b.this.bOl();
                    b.this.hBw.bOH();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dxP = null;
        this.hBU = null;
        this.mListView = null;
        this.hBV = null;
        this.eUQ = null;
        this.hBW = null;
        this.hCa = null;
        this.hCi = null;
        this.hCn = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fnY = null;
        this.hCv = null;
        this.hCw = null;
        this.hCx = null;
        this.hBV = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dxP = (RelativeLayout) LayoutInflater.from(this.hBV.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.hBU = LayoutInflater.from(this.hBV.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.hCv = (RelativeLayout) this.dxP.findViewById(d.g.subpb_editor_tool_comment);
        this.fnY = (TextView) this.dxP.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.fnY.setOnClickListener(this.mCommonClickListener);
        this.hCw = (ImageView) this.dxP.findViewById(d.g.subpb_editor_tool_more_img);
        this.hCx = (ImageView) this.dxP.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.hCx.setOnClickListener(this.mCommonClickListener);
        this.hCw.setOnClickListener(this.mCommonClickListener);
        this.eUQ = (NoNetworkView) this.dxP.findViewById(d.g.view_no_network);
        bgM();
        bat();
        this.hBW = (RelativeLayout) this.dxP.findViewById(d.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dxP.findViewById(d.g.new_sub_pb_list);
        this.hCh = (ThreadSkinView) LayoutInflater.from(this.hBV.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.hCh);
        this.mListView.addHeaderView(this.hBU);
        this.eLd = BdListViewHelper.a(this.hBV.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.hCi = new e(this.hBV.getPageContext());
        this.hCi.aez();
        this.hCn = this.hCi.getView();
        this.mListView.setNextPage(this.hCi);
        this.hCi.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.hCD);
        this.mListView.setOnItemLongClickListener(this.hCC);
        this.mListView.setOnTouchListener(this.cbY);
        this.mProgress = (ProgressBar) this.dxP.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hBU != null) {
            this.hBU.setVisibility(4);
        }
        if (this.hBW != null) {
            this.hBW.setVisibility(4);
        }
        this.hCa = com.baidu.tbadk.ala.b.UK().n(this.hBV.getActivity(), 4);
        if (this.hCa != null) {
            this.hCa.setVisibility(8);
            this.hBY.addView(this.hCa, 3);
        }
        this.hCB = new d(this.hBV, this.mListView);
        this.hCB.setFromCDN(this.mIsFromCDN);
        this.hCB.t(this.mCommonClickListener);
        this.hCB.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bat() {
        this.hBY = (LinearLayout) this.hBU.findViewById(d.g.subpb_head_user_info_root);
        this.hBY.setOnClickListener(this.mCommonClickListener);
        this.hBZ = (HeadImageView) this.hBU.findViewById(d.g.photo);
        this.hBZ.setRadius(l.h(this.hBV.getActivity(), d.e.ds30));
        this.hBZ.setClickable(false);
        this.hwk = (ClickableHeaderImageView) this.hBU.findViewById(d.g.god_user_photo);
        this.hwk.setGodIconMargin(0);
        this.hwk.setGodIconWidth(d.e.ds24);
        this.hwk.setRadius(l.h(this.hBV.getActivity(), d.e.ds30));
        this.hwk.setClickable(false);
        this.bTY = (TextView) this.hBU.findViewById(d.g.user_name);
        this.hCb = (ImageView) this.hBU.findViewById(d.g.user_rank);
        this.hCb.setVisibility(8);
        this.hwc = (TextView) this.hBU.findViewById(d.g.floor_owner);
        this.hBX = (TextView) this.hBU.findViewById(d.g.see_subject);
        this.hBX.setOnClickListener(this.mCommonClickListener);
        this.hCc = (TextView) this.hBU.findViewById(d.g.floor);
        this.hCd = (TextView) this.hBU.findViewById(d.g.time);
        this.hCe = (EllipsizeRichTextView) this.hBU.findViewById(d.g.content_text);
        this.hCe.setOnClickListener(this.mCommonClickListener);
        al.j(this.hCe, d.C0277d.cp_cont_b);
        this.hCe.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
        this.hCe.setLineSpacing(0.0f, 1.25f);
        this.hCf = (TbImageView) this.hBU.findViewById(d.g.sub_pb_image);
        this.hCf.setOnClickListener(this.mCommonClickListener);
        this.hCg = (TextView) this.hBU.findViewById(d.g.advert);
        this.ZY = (PlayVoiceBntNew) this.hBU.findViewById(d.g.voice_btn);
        this.hBU.setOnTouchListener(this.cbY);
        this.hBU.setOnClickListener(this.mCommonClickListener);
    }

    public void jH(boolean z) {
        if (this.eLd != null && this.eLd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eLd.getLayoutParams();
            if (z) {
                bgQ();
                layoutParams.height = l.h(this.hBV.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.h(this.hBV.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.eLd.setLayoutParams(layoutParams);
        }
    }

    private void bgQ() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0225b interfaceC0225b, boolean z) {
        if (this.hCp != null) {
            this.hCp.dismiss();
            this.hCp = null;
        }
        this.hCp = new com.baidu.tbadk.core.dialog.b(this.hBV.getPageContext().getPageActivity());
        if (z) {
            this.hCp.a(new String[]{this.hBV.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0225b);
        } else {
            this.hCp.a(new String[]{this.hBV.getPageContext().getString(d.j.save_to_emotion), this.hBV.getPageContext().getString(d.j.save_to_local)}, interfaceC0225b);
        }
        this.hCp.d(this.hBV.getPageContext());
        this.hCp.abc();
    }

    public void cw(View view) {
        this.hCj = view;
    }

    public View bgR() {
        return this.eLd;
    }

    public void bgM() {
        int h = l.h(this.hBV.getPageContext().getPageActivity(), d.e.ds88);
        int h2 = l.h(this.hBV.getPageContext().getPageActivity(), d.e.ds2);
        this.mNavigationBar = (NavigationBar) this.dxP.findViewById(d.g.view_navigation_bar);
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVZ.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bVZ != null && (this.bVZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bVZ.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.bVZ.setLayoutParams(layoutParams2);
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
        if (this.hCo == null) {
            this.hCo = new Dialog(this.hBV.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.hCo.setCanceledOnTouchOutside(true);
            this.hCo.setCancelable(true);
            View inflate = LayoutInflater.from(this.hBV.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.hBV.getLayoutMode().onModeChanged(inflate);
            this.hCo.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.hCo.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.hBV.getPageContext().getPageActivity()) * 0.9d);
            this.hCo.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.hCo.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.hCo.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.hCo.findViewById(d.g.disable_reply_btn);
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
                    if (b.this.hCo != null && (b.this.hCo instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCo, b.this.hBV.getPageContext());
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
                    if (b.this.hCo != null && (b.this.hCo instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCo, b.this.hBV.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.hCq != null) {
                        b.this.hCq.m(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id), sparseArray4.get(d.g.tag_forbid_user_name_show), sparseArray4.get(d.g.tag_forbid_user_portrait)});
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
                    if (b.this.hCo != null && (b.this.hCo instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.hCo, b.this.hBV.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.hBV.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.hCo, this.hBV.getPageContext());
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
        this.hwK = new com.baidu.tbadk.core.dialog.a(this.hBV.getPageContext().getPageActivity());
        this.hwK.gD(i3);
        this.hwK.ab(sparseArray);
        this.hwK.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.hCr != null) {
                    b.this.hCr.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hwK.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hwK.dq(true);
        this.hwK.b(this.hBV.getPageContext());
        if (z) {
            this.hwK.aaZ();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bbI;
        if (this.hBV != null && sparseArray != null && this.hBU != null) {
            if (this.fzD == null) {
                this.fzD = new com.baidu.tieba.NEGFeedBack.e(this.hBV.getPageContext(), this.hBU);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.hBw != null && (bbI = this.hBw.bbI()) != null && bbI.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bbI.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fzD.setDefaultReasonArray(new String[]{this.hBV.getString(d.j.delete_thread_reason_1), this.hBV.getString(d.j.delete_thread_reason_2), this.hBV.getString(d.j.delete_thread_reason_3), this.hBV.getString(d.j.delete_thread_reason_4), this.hBV.getString(d.j.delete_thread_reason_5)});
            this.fzD.setData(ajVar);
            this.fzD.qi("4");
            this.fzD.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void B(JSONArray jSONArray) {
                    String x = ap.x(jSONArray);
                    if (b.this.hCr != null) {
                        b.this.hCr.m(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type), x});
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
        this.hCq = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.hCr = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.hBV.showToast(this.hBV.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.hBV.showToast(str);
        }
    }

    public void bL(View view) {
        if (this.eLd != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eLd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.eLd);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eLd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.hBV.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.eLd, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.alS() != null) {
            this.gyS = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dxP.addView(gVar.alS(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.hBL = aVar;
    }

    public void bOj() {
        if (this.mListView != null) {
            this.hCA = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nj(boolean z) {
        if (this.hBw == null || this.hBw.bOE() == null) {
            return false;
        }
        if (this.hBw.bIl() != 0) {
            return false;
        }
        return (this.hAB == null || this.hAB.WR() == null || this.hAB.WR().YR() == null || !TextUtils.equals(this.hAB.WR().YR().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bOk() {
        if (this.hBw != null) {
            if ((!bOn() && this.hCn != null && this.hCn.isShown()) || v.T(this.hCt)) {
                this.hBw.oo(false);
            } else {
                this.hBw.oo(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.hBw = subPbModel;
    }

    public void bOl() {
        b(this.hBV);
        this.mListView.setNextPage(this.hCi);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.pX(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bOn() && this.hCn != null && this.hCn.isShown()) {
                i = (this.hCA - this.hCz) - 1;
            } else {
                i = this.hCA - this.hCz;
            }
            int S = v.S(this.hCt);
            if (i > S) {
                i = S;
            }
            ArrayList arrayList = new ArrayList(v.c(this.hCt, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.hCA + 2);
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
        return this.dxP;
    }

    public void bNa() {
        if (this.hCk != null) {
            com.baidu.adp.lib.g.g.a(this.hCk, this.hBV.getPageContext().getPageActivity());
        }
        if (this.hCm != null) {
            this.hCm.dismiss();
        }
        if (this.hwK != null) {
            this.hwK.dismiss();
        }
        if (this.hCo != null) {
            com.baidu.adp.lib.g.g.b(this.hCo, this.hBV.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.hBz != null) {
            this.hBz.dismiss();
        }
    }

    public void bOm() {
        this.mListView.setNextPage(this.hCi);
        this.hCi.aeC();
    }

    public void nc(boolean z) {
        this.hpm = z;
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
            if (this.ciS && this.hBU != null) {
                this.hBU.setVisibility(8);
                this.mListView.removeHeaderView(this.hBU);
                this.hCz = 1;
            }
            this.hAB = jVar;
            if (this.hBU != null) {
                this.hBU.setVisibility(0);
            }
            if (this.hBW != null) {
                this.hBW.setVisibility(0);
            }
            if (jVar.bID() != null) {
                this.hCs = jVar.bID().getId();
                this.cCv = jVar.bID().cet();
                if (this.cCv > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.hBV.getResources().getString(d.j.subpb_floor_reply), Integer.valueOf(this.cCv)));
                    if (this.hBV != null) {
                        this.fnY.setText(this.hBV.bMr());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.hBV.bOh() ? "PB" : null;
                if (jVar.bID().Zm() != null) {
                    this.hCh.setData(this.hBV.getPageContext(), jVar.bID().Zm(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bIJ().getId(), jVar.bIJ().getName(), jVar.WR().getId(), str));
                } else {
                    this.hCh.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.hCi.aeC();
                this.hCB.setHasMoreData(true);
            } else {
                this.hCi.aeD();
                this.hCB.setHasMoreData(false);
            }
            this.hCt = jVar.bIH();
            if (this.hCt == null || this.hCt.size() <= hBT) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.hCt.size() - hBT;
                wH(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hCt);
            if (v.T(this.hCt)) {
                this.mListView.setNextPage(null);
                if (this.ciS) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.hCi);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.ciS) {
                arrayList.add(0, jVar.bID());
            }
            this.hCB.b(this.hAB.WR(), arrayList);
            a(jVar.bID(), jVar.bvu(), jVar.Vb(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void wH(int i) {
        if (this.hCt != null) {
            if (this.hCt.size() <= i) {
                this.hCt.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.hCt.iterator();
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
        return this.hCB.HA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.ciS) {
            this.hkQ = postData;
            if (!StringUtils.isNull(postData.ceA())) {
                this.hCf.setVisibility(0);
                this.hCf.startLoad(postData.ceA(), 10, true);
            } else {
                this.hCf.setVisibility(8);
            }
            i ceC = postData.ceC();
            if (ceC != null && ceC.iFJ) {
                this.hCg.setVisibility(0);
            } else {
                this.hCg.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.hBU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.hBU.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.hCc.setText((CharSequence) null);
            this.bTY.setText((CharSequence) null);
            this.hwc.setVisibility(8);
            if (!this.ciS) {
                c(postData.YR());
                if (z) {
                    this.hwc.setVisibility(0);
                    al.j(this.hwc, d.C0277d.cp_link_tip_a);
                }
            }
            this.hCd.setText(ap.ao(postData.getTime()));
            this.hCc.setText(String.format(this.hBV.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.cet())));
            postData.YR().getUserTbVipInfoData();
            boolean a = a(this.hCe, postData.cev());
            if (StringUtils.isNull(postData.ceA()) && !a && postData.asF() != null) {
                this.ZY.setVisibility(0);
                this.ZY.setTag(postData.asF());
                return;
            }
            this.ZY.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + ab.pM(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bTY.setText(bN(metaData.getSealPrefix(), name_show));
            } else {
                this.bTY.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.hCa != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.hCa.setVisibility(8);
                } else {
                    this.hCa.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsJ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.hCa.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hwk.setVisibility(0);
                this.hBZ.setVisibility(8);
                this.hwk.setUserId(metaData.getUserId());
                this.hwk.setUserName(metaData.getUserName());
                this.hwk.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bTY, d.C0277d.cp_cont_r);
            } else {
                this.hwk.setVisibility(8);
                this.hBZ.setVisibility(0);
                this.hBZ.setUserId(metaData.getUserId());
                this.hBZ.setUserName(metaData.getUserName());
                this.hBZ.setDefaultResource(d.f.transparent_bg);
                this.hBZ.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.hBZ.startLoad(metaData.getPortrait(), 28, false);
                al.j(this.bTY, d.C0277d.cp_cont_c);
            }
            this.hBY.setTag(d.g.tag_user_id, metaData.getUserId());
            this.hBY.setTag(d.g.tag_user_name, metaData.getUserName());
            this.hBY.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.c.cna());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.hBV.getPageContext().getString(d.j.refresh_view_title_text), this.bui));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.hBV.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.hBW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.new_pic_emotion_07, l.h(pageActivity, d.e.ds250), l.h(pageActivity, d.e.ds480), l.h(pageActivity, d.e.ds360)), dVar, a);
        }
        this.hBW.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gyS.amP();
        al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.hBV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void nS(int i) {
        b(NoDataViewFactory.d.ad(i, d.j.refresh_view_title_text));
        if (this.hBL != null) {
            this.hBL.cu(this.dxP);
        }
        this.hCv.setVisibility(8);
    }

    public void vk(String str) {
        b(NoDataViewFactory.d.bM(str, this.hBV.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.hBL != null) {
            this.hBL.cu(this.dxP);
        }
        this.hCv.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.hCv.setVisibility(0);
            this.dxP.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bui = onClickListener;
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
            if (this.hAB != null && this.hAB.WR() != null && this.hAB.WR().YR() != null && postData.YR() != null) {
                String userId3 = this.hAB.WR().YR().getUserId();
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
                    int i2 = postData.cet() != 1 ? 0 : 1;
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
                        if (this.hAB.WR() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.hAB.WR().getId());
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
            if (postData.cet() != 1) {
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
        if (this.hBz != null && this.hBz.bLH() != null) {
            if (z) {
                this.hBz.bLH().setText(d.j.remove_mark);
            } else {
                this.hBz.bLH().setText(d.j.mark);
            }
        }
    }

    public View bOo() {
        return this.hCn;
    }

    public void onChangeSkinType(int i) {
        this.hBV.getLayoutMode().setNightMode(i == 1);
        this.hBV.getLayoutMode().onModeChanged(this.dxP);
        this.hBV.getLayoutMode().onModeChanged(this.hBU);
        this.mNavigationBar.onChangeSkinType(this.hBV.getPageContext(), i);
        if (this.hBX != null) {
            al.j(this.hBX, d.C0277d.goto_see_subject_color);
        }
        this.eUQ.onChangeSkinType(this.hBV.getPageContext(), i);
        this.hBV.getLayoutMode().onModeChanged(this.hCn);
        al.j(this.hCe, d.C0277d.cp_cont_b);
        this.hCe.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
        if (this.gyS != null && this.gyS.alS() != null) {
            this.gyS.alS().onChangeSkinType(i);
        }
        this.hCi.ic(i);
        this.ZY.bxV();
        al.j(this.fnY, d.C0277d.cp_cont_e);
        al.j(this.hwc, d.C0277d.cp_link_tip_a);
        al.j(this.bTY, d.C0277d.cp_cont_c);
        this.fnY.setAlpha(0.95f);
        if (this.hCj != null) {
            com.baidu.tbadk.r.a.a(this.hBV.getPageContext(), this.hCj);
        }
        if (this.hCB != null) {
            this.hCB.notifyDataSetChanged();
        }
    }

    public void bOp() {
        this.mProgress.setVisibility(0);
    }

    public void bOq() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hCi.aeD();
    }

    public void aYV() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.hCi.aYV();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfu = onLongClickListener;
        this.hCB.c(onLongClickListener);
    }

    public View bOr() {
        return this.hBU;
    }

    public TextView bgS() {
        return this.fnY;
    }

    public ImageView bOs() {
        return this.hCw;
    }

    public ImageView bOt() {
        return this.hCx;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void wI(int i) {
    }

    public View bOu() {
        return this.hBX;
    }

    public View bOv() {
        return this.hCf;
    }

    public MorePopupWindow bOw() {
        return this.hCk;
    }

    public void showLoadingDialog() {
        if (this.esc == null) {
            this.esc = new com.baidu.tbadk.core.view.b(this.hBV.getPageContext());
        }
        this.esc.dJ(true);
    }

    public void aME() {
        if (this.esc != null) {
            this.esc.dJ(false);
        }
    }

    public TextView bOx() {
        return this.hCe;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.hBB = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.hCB.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.hCB != null) {
            this.hCB.notifyDataSetChanged();
        }
    }

    public y bOy() {
        return this.hBz;
    }

    public void biQ() {
    }

    public void biR() {
    }

    public void onActivityDestroy() {
    }

    public void bOz() {
        if (this.hBV.isPaused()) {
        }
    }

    public View bOA() {
        return this.hBY;
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return n.a((Context) this.hBV.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
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
        if (this.gyS == null || this.gyS.alS() == null) {
            return 0;
        }
        return this.gyS.alS().getHeight();
    }
}
