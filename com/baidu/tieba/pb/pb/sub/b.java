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
    private static final int gkR = TbadkCoreApplication.getInst().getListItemRule().GP();
    private RelativeLayout cig;
    private NoNetworkView dGT;
    private TextView dZP;
    private com.baidu.tbadk.core.view.d dhu;
    private View dxd;
    private com.baidu.tieba.NEGFeedBack.e ekd;
    private y fVV;
    private View gfO;
    private com.baidu.tbadk.core.dialog.b gfR;
    private j gjy;
    private a gkL;
    private View gkS;
    private NewSubPbActivity gkT;
    private RelativeLayout gkU;
    private View gkY;
    private SubPbModel gkx;
    private ThreadSkinView glf;
    private e glg;
    private View glj;
    private ArrayList<PostData> gln;
    private String glo;
    private RelativeLayout glp;
    private ImageView glq;
    private ImageView glr;
    private d glv;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener amU = null;
    private TbRichTextView.i gkB = null;
    private NavigationBar mNavigationBar = null;
    private View aMW = null;
    private TextView gkV = null;
    private LinearLayout gkW = null;
    private HeadImageView gkX = null;
    private ClickableHeaderImageView gfh = null;
    private TextView aKV = null;
    private ImageView gkZ = null;
    private TextView geZ = null;
    private TextView gla = null;
    private TextView glb = null;
    private EllipsizeRichTextView glc = null;
    private TbImageView gld = null;
    private PlayVoiceBntNew cXN = null;
    private TextView gle = null;
    private MorePopupWindow glh = null;
    private am gli = null;
    private com.baidu.tbadk.core.dialog.b gfQ = null;
    private Dialog gfF = null;
    private com.baidu.tbadk.core.dialog.a gfH = null;
    private boolean fYc = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aVu = null;
    private NewSubPbActivity.a glk = null;
    private NewSubPbActivity.a gll = null;
    private g fic = null;
    private String glm = null;
    private int bqT = 0;
    private PostData fTG = null;
    private int gls = 0;
    private int glt = 2;
    private int glu = 0;
    private boolean aYI = true;
    private View.OnClickListener fYk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
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
                        b.this.gkT.b(sparseArray);
                        return;
                    }
                    b.this.bF(view);
                } else if (booleanValue2) {
                    sparseArray.put(e.g.tag_from, 0);
                    b.this.gkT.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c brQ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            b.this.hh(false);
            b.this.aT(view);
            b.this.hh(true);
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
    protected AdapterView.OnItemLongClickListener glw = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.d(b.this.gln, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.fVV == null) {
                b.this.fVV = new y(b.this.gkT.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.fVV.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean kJ = b.this.kJ(sparseArray.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.fVV.a(sparseArray, b.this.gkx.bhh(), kJ);
            if (kJ) {
                b.this.fVV.bkD().setVisibility(0);
                b.this.fVV.bkD().setTag(postData.getId());
            } else {
                b.this.fVV.bkD().setVisibility(8);
            }
            b.this.fVV.bkB().setVisibility(8);
            b.this.fVV.refreshUI();
            return false;
        }
    };
    protected AdapterView.OnItemClickListener glx = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ba.bJ(b.this.gkT.getPageContext().getPageActivity())) {
                if (b.this.gkT.fhU == null || b.this.gkx == null || b.this.gkx.aAM() == null || b.this.gkT.fhU.dK(b.this.gkx.aAM().replyPrivateFlag)) {
                    if (b.this.gkL != null) {
                        b.this.gkL.aFP();
                    }
                    b.this.bnf();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.d(b.this.gln, i);
                        if (postData == null) {
                            b.this.glo = null;
                        } else {
                            b.this.glo = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(e.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(e.g.tag_photo_userid);
                            if (str != null) {
                                b.this.fic.setReplyId(str2);
                                b.this.fic.hY(str);
                            }
                        }
                        b.this.bng();
                        return;
                    }
                    b.this.bnh();
                    b.this.gkx.bnC();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.cig = null;
        this.gkS = null;
        this.mListView = null;
        this.gkT = null;
        this.dGT = null;
        this.gkU = null;
        this.gkY = null;
        this.glg = null;
        this.glj = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dZP = null;
        this.glp = null;
        this.glq = null;
        this.glr = null;
        this.gkT = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.cig = (RelativeLayout) LayoutInflater.from(this.gkT.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_layout, (ViewGroup) null);
        this.gkS = LayoutInflater.from(this.gkT.getPageContext().getPageActivity()).inflate(e.h.new_sub_pb_head, (ViewGroup) null);
        this.glp = (RelativeLayout) this.cig.findViewById(e.g.subpb_editor_tool_comment);
        this.dZP = (TextView) this.cig.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dZP.setOnClickListener(this.mCommonClickListener);
        this.glq = (ImageView) this.cig.findViewById(e.g.subpb_editor_tool_more_img);
        this.glr = (ImageView) this.cig.findViewById(e.g.subpb_editor_tool_emotion_img);
        this.glr.setOnClickListener(this.mCommonClickListener);
        this.glq.setOnClickListener(this.mCommonClickListener);
        this.dGT = (NoNetworkView) this.cig.findViewById(e.g.view_no_network);
        aFX();
        azx();
        this.gkU = (RelativeLayout) this.cig.findViewById(e.g.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.cig.findViewById(e.g.new_sub_pb_list);
        this.glf = (ThreadSkinView) LayoutInflater.from(this.gkT.getPageContext().getPageActivity()).inflate(e.h.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.glf);
        this.mListView.addHeaderView(this.gkS);
        this.dxd = BdListViewHelper.a(this.gkT.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.glg = new e(this.gkT.getPageContext());
        this.glg.EZ();
        this.glj = this.glg.getView();
        this.mListView.setNextPage(this.glg);
        this.glg.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.glx);
        this.mListView.setOnItemLongClickListener(this.glw);
        this.mListView.setOnTouchListener(this.brQ);
        this.mProgress = (ProgressBar) this.cig.findViewById(e.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gkS != null) {
            this.gkS.setVisibility(4);
        }
        if (this.gkU != null) {
            this.gkU.setVisibility(4);
        }
        this.gkY = com.baidu.tbadk.ala.b.vZ().j(this.gkT.getActivity(), 4);
        if (this.gkY != null) {
            this.gkY.setVisibility(8);
            this.gkW.addView(this.gkY, 3);
        }
        this.glv = new d(this.gkT, this.mListView);
        this.glv.setFromCDN(this.mIsFromCDN);
        this.glv.s(this.mCommonClickListener);
        this.glv.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void azx() {
        this.gkW = (LinearLayout) this.gkS.findViewById(e.g.subpb_head_user_info_root);
        this.gkW.setOnClickListener(this.mCommonClickListener);
        this.gkX = (HeadImageView) this.gkS.findViewById(e.g.photo);
        this.gkX.setRadius(l.h(this.gkT.getActivity(), e.C0210e.ds30));
        this.gkX.setClickable(false);
        this.gfh = (ClickableHeaderImageView) this.gkS.findViewById(e.g.god_user_photo);
        this.gfh.setGodIconMargin(0);
        this.gfh.setGodIconWidth(e.C0210e.ds24);
        this.gfh.setRadius(l.h(this.gkT.getActivity(), e.C0210e.ds30));
        this.gfh.setClickable(false);
        this.aKV = (TextView) this.gkS.findViewById(e.g.user_name);
        this.gkZ = (ImageView) this.gkS.findViewById(e.g.user_rank);
        this.gkZ.setVisibility(8);
        this.geZ = (TextView) this.gkS.findViewById(e.g.floor_owner);
        this.gkV = (TextView) this.gkS.findViewById(e.g.see_subject);
        this.gkV.setOnClickListener(this.mCommonClickListener);
        this.gla = (TextView) this.gkS.findViewById(e.g.floor);
        this.glb = (TextView) this.gkS.findViewById(e.g.time);
        this.glc = (EllipsizeRichTextView) this.gkS.findViewById(e.g.content_text);
        this.glc.setOnClickListener(this.mCommonClickListener);
        al.h(this.glc, e.d.cp_cont_b);
        this.glc.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        this.glc.setLineSpacing(0.0f, 1.25f);
        this.gld = (TbImageView) this.gkS.findViewById(e.g.sub_pb_image);
        this.gld.setOnClickListener(this.mCommonClickListener);
        this.gle = (TextView) this.gkS.findViewById(e.g.advert);
        this.cXN = (PlayVoiceBntNew) this.gkS.findViewById(e.g.voice_btn);
        this.gkS.setOnTouchListener(this.brQ);
        this.gkS.setOnClickListener(this.mCommonClickListener);
    }

    public void hj(boolean z) {
        if (this.dxd != null && this.dxd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dxd.getLayoutParams();
            if (z) {
                aGb();
                layoutParams.height = l.h(this.gkT.getPageContext().getPageActivity(), e.C0210e.ds88);
            } else {
                layoutParams.height = l.h(this.gkT.getPageContext().getPageActivity(), e.C0210e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.dxd.setLayoutParams(layoutParams);
        }
    }

    private void aGb() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public void a(b.InterfaceC0158b interfaceC0158b, boolean z) {
        if (this.gfR != null) {
            this.gfR.dismiss();
            this.gfR = null;
        }
        this.gfR = new com.baidu.tbadk.core.dialog.b(this.gkT.getPageContext().getPageActivity());
        if (z) {
            this.gfR.a(new String[]{this.gkT.getPageContext().getString(e.j.save_to_emotion)}, interfaceC0158b);
        } else {
            this.gfR.a(new String[]{this.gkT.getPageContext().getString(e.j.save_to_emotion), this.gkT.getPageContext().getString(e.j.save_to_local)}, interfaceC0158b);
        }
        this.gfR.d(this.gkT.getPageContext());
        this.gfR.BI();
    }

    public void bH(View view) {
        this.gfO = view;
    }

    public View aGc() {
        return this.dxd;
    }

    public void aFX() {
        int h = l.h(this.gkT.getPageContext().getPageActivity(), e.C0210e.ds88);
        int h2 = l.h(this.gkT.getPageContext().getPageActivity(), e.C0210e.ds2);
        this.mNavigationBar = (NavigationBar) this.cig.findViewById(e.g.view_navigation_bar);
        this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMW.getLayoutParams();
            layoutParams.height = h;
            layoutParams.width = h;
            layoutParams.leftMargin = h2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aMW != null && (this.aMW.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aMW.getLayoutParams();
            layoutParams2.width = h;
            layoutParams2.height = h;
            this.aMW.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar abW() {
        return this.mNavigationBar;
    }

    public void bF(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.gfF == null) {
            this.gfF = new Dialog(this.gkT.getPageContext().getPageActivity(), e.k.common_alert_dialog);
            this.gfF.setCanceledOnTouchOutside(true);
            this.gfF.setCancelable(true);
            View inflate = LayoutInflater.from(this.gkT.getPageContext().getPageActivity()).inflate(e.h.forum_manage_dialog, (ViewGroup) null);
            this.gkT.getLayoutMode().onModeChanged(inflate);
            this.gfF.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.gfF.getWindow().getAttributes();
            attributes.width = (int) (l.aO(this.gkT.getPageContext().getPageActivity()) * 0.9d);
            this.gfF.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.gfF.findViewById(e.g.del_post_btn);
        TextView textView2 = (TextView) this.gfF.findViewById(e.g.forbid_user_btn);
        TextView textView3 = (TextView) this.gfF.findViewById(e.g.disable_reply_btn);
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
                    if (b.this.gfF != null && (b.this.gfF instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.gfF, b.this.gkT.getPageContext());
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
                    if (b.this.gfF != null && (b.this.gfF instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.gfF, b.this.gkT.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.glk != null) {
                        b.this.glk.m(new Object[]{sparseArray4.get(e.g.tag_manage_user_identity), sparseArray4.get(e.g.tag_forbid_user_name), sparseArray4.get(e.g.tag_forbid_user_post_id), sparseArray4.get(e.g.tag_forbid_user_name_show), sparseArray4.get(e.g.tag_forbid_user_portrait)});
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
                    if (b.this.gfF != null && (b.this.gfF instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.gfF, b.this.gkT.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.gkT.a(z, (String) sparseArray5.get(e.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.gfF, this.gkT.getPageContext());
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
        this.gfH = new com.baidu.tbadk.core.dialog.a(this.gkT.getPageContext().getPageActivity());
        this.gfH.db(i3);
        this.gfH.H(sparseArray);
        this.gfH.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.gll != null) {
                    b.this.gll.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.gfH.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.gfH.bf(true);
        this.gfH.b(this.gkT.getPageContext());
        if (z) {
            this.gfH.BF();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData aAM;
        if (this.gkT != null && sparseArray != null && this.gkS != null) {
            if (this.ekd == null) {
                this.ekd = new com.baidu.tieba.NEGFeedBack.e(this.gkT.getPageContext(), this.gkS);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.gkx != null && (aAM = this.gkx.aAM()) != null && aAM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aAM.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray2);
            this.ekd.setDefaultReasonArray(new String[]{this.gkT.getString(e.j.delete_thread_reason_1), this.gkT.getString(e.j.delete_thread_reason_2), this.gkT.getString(e.j.delete_thread_reason_3), this.gkT.getString(e.j.delete_thread_reason_4), this.gkT.getString(e.j.delete_thread_reason_5)});
            this.ekd.setData(ahVar);
            this.ekd.ji("4");
            this.ekd.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void m(JSONArray jSONArray) {
                    String i2 = ao.i(jSONArray);
                    if (b.this.gll != null) {
                        b.this.gll.m(new Object[]{sparseArray.get(e.g.tag_del_post_id), sparseArray.get(e.g.tag_manage_user_identity), sparseArray.get(e.g.tag_del_post_is_self), sparseArray.get(e.g.tag_del_post_type), i2});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(final boolean z) {
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
        this.glk = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gll = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.gkT.showToast(this.gkT.getResources().getString(e.j.delete_success));
        } else if (str != null && z2) {
            this.gkT.showToast(str);
        }
    }

    public void aT(View view) {
        if (this.dxd != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dxd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dxd);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dxd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.gkT.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dxd, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.LY() != null) {
            this.fic = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cig.addView(gVar.LY(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.gkL = aVar;
    }

    public void bnf() {
        if (this.mListView != null) {
            this.glu = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kJ(boolean z) {
        if (this.gkx == null || this.gkx.bnz() == null) {
            return false;
        }
        if (this.gkx.bhh() != 0) {
            return false;
        }
        return (this.gjy == null || this.gjy.ZT() == null || this.gjy.ZT().zG() == null || !TextUtils.equals(this.gjy.ZT().zG().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bng() {
        if (this.gkx != null) {
            if ((!bnj() && this.glj != null && this.glj.isShown()) || v.I(this.gln)) {
                this.gkx.lR(false);
            } else {
                this.gkx.lR(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.gkx = subPbModel;
    }

    public void bnh() {
        a(this.gkT);
        this.mListView.setNextPage(this.glg);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.nw(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bnj() && this.glj != null && this.glj.isShown()) {
                i = (this.glu - this.glt) - 1;
            } else {
                i = this.glu - this.glt;
            }
            int H = v.H(this.gln);
            if (i > H) {
                i = H;
            }
            ArrayList arrayList = new ArrayList(v.b(this.gln, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.glu + 2);
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
        return this.cig;
    }

    public void blX() {
        if (this.glh != null) {
            com.baidu.adp.lib.g.g.a(this.glh, this.gkT.getPageContext().getPageActivity());
        }
        if (this.gfQ != null) {
            this.gfQ.dismiss();
        }
        if (this.gfH != null) {
            this.gfH.dismiss();
        }
        if (this.gfF != null) {
            com.baidu.adp.lib.g.g.b(this.gfF, this.gkT.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fVV != null) {
            this.fVV.dismiss();
        }
    }

    public void bni() {
        this.mListView.setNextPage(this.glg);
        this.glg.Fc();
    }

    public void kC(boolean z) {
        this.fYc = z;
    }

    public void setIsFromPb(boolean z) {
        this.aYI = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (jVar != null) {
            if (this.aYI && this.gkS != null) {
                this.gkS.setVisibility(8);
                this.mListView.removeHeaderView(this.gkS);
                this.glt = 1;
            }
            this.gjy = jVar;
            if (this.gkS != null) {
                this.gkS.setVisibility(0);
            }
            if (this.gkU != null) {
                this.gkU.setVisibility(0);
            }
            if (jVar.bhC() != null) {
                this.glm = jVar.bhC().getId();
                this.bqT = jVar.bhC().bEj();
                if (this.bqT > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.gkT.getResources().getString(e.j.subpb_floor_reply), Integer.valueOf(this.bqT)));
                    this.dZP.setText(e.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.gkT.bne() ? "PB" : null;
                if (jVar.bhC().Ac() != null) {
                    this.glf.setData(this.gkT.getPageContext(), jVar.bhC().Ac(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", jVar.bhI().getId(), jVar.bhI().getName(), jVar.ZT().getId(), str));
                } else {
                    this.glf.setData(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.glg.Fc();
                this.glv.setHasMoreData(true);
            } else {
                this.glg.Fd();
                this.glv.setHasMoreData(false);
            }
            this.gln = jVar.bhG();
            if (this.gln == null || this.gln.size() <= gkR) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gln.size() - gkR;
                sT(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gln);
            if (v.I(this.gln)) {
                this.mListView.setNextPage(null);
                if (this.aYI) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.glg);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(jVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.aYI) {
                arrayList.add(0, jVar.bhC());
            }
            this.glv.a(this.gjy.ZT(), arrayList);
            a(jVar.bhC(), jVar.aUp(), jVar.wq(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void sT(int i) {
        if (this.gln != null) {
            if (this.gln.size() <= i) {
                this.gln.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gln.iterator();
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

    public boolean bnj() {
        return this.glv.hasMoreData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aYI) {
            this.fTG = postData;
            if (!StringUtils.isNull(postData.bEq())) {
                this.gld.setVisibility(0);
                this.gld.startLoad(postData.bEq(), 10, true);
            } else {
                this.gld.setVisibility(8);
            }
            h bEs = postData.bEs();
            if (bEs != null && bEs.hof) {
                this.gle.setVisibility(0);
            } else {
                this.gle.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.gkS.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.gkS.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(e.g.tag_clip_board, postData);
            sparseArray.put(e.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.gla.setText((CharSequence) null);
            this.aKV.setText((CharSequence) null);
            this.geZ.setVisibility(8);
            if (!this.aYI) {
                c(postData.zG());
                if (z) {
                    this.geZ.setVisibility(0);
                    al.h(this.geZ, e.d.cp_link_tip_a);
                }
            }
            this.glb.setText(ao.M(postData.getTime()));
            this.gla.setText(String.format(this.gkT.getPageContext().getString(e.j.is_floor), Integer.valueOf(postData.bEj())));
            postData.zG().getUserTbVipInfoData();
            boolean a = a(this.glc, postData.bEl());
            if (StringUtils.isNull(postData.bEq()) && !a && postData.Sj() != null) {
                this.cXN.setVisibility(0);
                this.cXN.setTag(postData.Sj());
                return;
            }
            this.cXN.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.bz(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.y.iM(name_show) > 14) {
                name_show = com.baidu.tbadk.util.y.q(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aKV.setText(aE(metaData.getSealPrefix(), name_show));
            } else {
                this.aKV.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.gkY != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.gkY.setVisibility(8);
                } else {
                    this.gkY.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.alI = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.gkY.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.gfh.setVisibility(0);
                this.gkX.setVisibility(8);
                this.gfh.setUserId(metaData.getUserId());
                this.gfh.setUserName(metaData.getUserName());
                this.gfh.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aKV, e.d.cp_cont_r);
            } else {
                this.gfh.setVisibility(8);
                this.gkX.setVisibility(0);
                this.gkX.setUserId(metaData.getUserId());
                this.gkX.setUserName(metaData.getUserName());
                this.gkX.setDefaultResource(e.f.transparent_bg);
                this.gkX.setDefaultErrorResource(e.f.icon_default_avatar100);
                this.gkX.startLoad(metaData.getPortrait(), 28, false);
                al.h(this.aKV, e.d.cp_cont_c);
            }
            this.gkW.setTag(e.g.tag_user_id, metaData.getUserId());
            this.gkW.setTag(e.g.tag_user_name, metaData.getUserName());
            this.gkW.setTag(e.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Sb() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Sb().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Si());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.db(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bMP());
                        continue;
                    case 17:
                        String str = next.Sm().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Sr()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Si() == null || tbRichTextData.Si().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Si());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.gkT.getPageContext().getString(e.j.refresh_view_title_text), this.amU));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.gkT.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.gkU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, e.f.pic_emotion07, l.h(pageActivity, e.C0210e.ds250), l.h(pageActivity, e.C0210e.ds480), l.h(pageActivity, e.C0210e.ds360)), dVar, a);
        }
        this.gkU.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.fic.MU();
        al.j(this.mNoDataView, e.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.gkT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void kf(int i) {
        b(NoDataViewFactory.d.H(i, e.j.refresh_view_title_text));
        if (this.gkL != null) {
            this.gkL.bI(this.cig);
        }
        this.glp.setVisibility(8);
    }

    public void or(String str) {
        b(NoDataViewFactory.d.aD(str, this.gkT.getPageContext().getString(e.j.refresh_view_title_text)));
        if (this.gkL != null) {
            this.gkL.bI(this.cig);
        }
        this.glp.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.glp.setVisibility(0);
            this.cig.setOnTouchListener(null);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.amU = onClickListener;
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
                String userId2 = postData.zG().getUserId();
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
            if (this.gjy != null && this.gjy.ZT() != null && this.gjy.ZT().zG() != null && postData.zG() != null) {
                String userId3 = this.gjy.ZT().zG().getUserId();
                String userId4 = postData.zG().getUserId();
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
                    userId = postData.zG().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bEj() != 1 ? 0 : 1;
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
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
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
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                            sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                        }
                    } else {
                        sparseArray.put(e.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(e.g.tag_user_mute_visible, true);
                        sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zG() != null) {
                            sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zG().getUserId());
                            sparseArray.put(e.g.tag_user_mute_mute_username, postData.zG().getUserName());
                            sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zG().getName_show());
                        }
                        if (this.gjy.ZT() != null) {
                            sparseArray.put(e.g.tag_user_mute_thread_id, this.gjy.ZT().getId());
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
            userId = postData.zG().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bEj() != 1) {
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

    public void lP(boolean z) {
        if (this.fVV != null && this.fVV.bkB() != null) {
            if (z) {
                this.fVV.bkB().setText(e.j.remove_mark);
            } else {
                this.fVV.bkB().setText(e.j.mark);
            }
            this.fVV.refreshUI();
        }
    }

    public View bnk() {
        return this.glj;
    }

    public void onChangeSkinType(int i) {
        this.gkT.getLayoutMode().setNightMode(i == 1);
        this.gkT.getLayoutMode().onModeChanged(this.cig);
        this.gkT.getLayoutMode().onModeChanged(this.gkS);
        this.mNavigationBar.onChangeSkinType(this.gkT.getPageContext(), i);
        if (this.gkV != null) {
            al.h(this.gkV, e.d.goto_see_subject_color);
        }
        this.dGT.onChangeSkinType(this.gkT.getPageContext(), i);
        this.gkT.getLayoutMode().onModeChanged(this.glj);
        al.h(this.glc, e.d.cp_cont_b);
        this.glc.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
        if (this.fic != null && this.fic.LY() != null) {
            this.fic.LY().onChangeSkinType(i);
        }
        this.glg.ey(i);
        this.cXN.aWT();
        al.h(this.dZP, e.d.cp_cont_e);
        al.h(this.geZ, e.d.cp_link_tip_a);
        al.h(this.aKV, e.d.cp_cont_c);
        this.dZP.setAlpha(0.95f);
        if (this.gfO != null) {
            com.baidu.tbadk.o.a.a(this.gkT.getPageContext(), this.gfO);
        }
        if (this.glv != null) {
            this.glv.notifyDataSetChanged();
        }
    }

    public void bnl() {
        this.mProgress.setVisibility(0);
    }

    public void bnm() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.glg.Fd();
    }

    public void axU() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.glg.axU();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVu = onLongClickListener;
        this.glv.c(onLongClickListener);
    }

    public View bnn() {
        return this.gkS;
    }

    public TextView aGd() {
        return this.dZP;
    }

    public ImageView bno() {
        return this.glq;
    }

    public ImageView bnp() {
        return this.glr;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void sU(int i) {
    }

    public View bnq() {
        return this.gkV;
    }

    public View bnr() {
        return this.gld;
    }

    public MorePopupWindow bns() {
        return this.glh;
    }

    public void showLoadingDialog() {
        if (this.dhu == null) {
            this.dhu = new com.baidu.tbadk.core.view.d(this.gkT.getPageContext());
        }
        this.dhu.bA(true);
    }

    public void aln() {
        if (this.dhu != null) {
            this.dhu.bA(false);
        }
    }

    public TextView bnt() {
        return this.glc;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.gkB = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.glv.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.glv != null) {
            this.glv.notifyDataSetChanged();
        }
    }

    public y bnu() {
        return this.fVV;
    }

    public void aEP() {
    }

    public void aEQ() {
    }

    public void onActivityDestroy() {
    }

    public void bnv() {
        if (this.gkT.isPaused()) {
        }
    }

    public View bnw() {
        return this.gkW;
    }

    private SpannableStringBuilder aE(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return o.a((Context) this.gkT.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
