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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a implements KeyboardEventLayout.a {
    private static final int jYB = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aIH;
    private BdTypeListView faQ;
    private com.baidu.tbadk.core.view.a gKp;
    private TextView hDl;
    private e hQx;
    private View hcR;
    private NoNetworkView hiX;
    private n jXg;
    private SubPbView jYC;
    private LinearLayout jYD;
    private View jYE;
    private NewSubPbActivity jYF;
    private RelativeLayout jYG;
    private View jYK;
    private ThreadSkinView jYR;
    private d jYS;
    private View jYT;
    private View jYV;
    private View jYX;
    private BlankView jYY;
    private SubPbModel jYf;
    private ad jYi;
    private com.baidu.tbadk.core.dialog.b jZa;
    private ArrayList<PostData> jZd;
    private RelativeLayout jZe;
    private ImageView jZf;
    private ImageView jZg;
    private c jZj;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dyx = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView jYH = null;
    private LinearLayout jYI = null;
    private HeadImageView jYJ = null;
    private ClickableHeaderImageView jUD = null;
    private TextView dXU = null;
    private ImageView jYL = null;
    private TextView jUw = null;
    private TextView jYM = null;
    private TextView jYN = null;
    private EllipsizeRichTextView jYO = null;
    private TbImageView jYP = null;
    private PlayVoiceBntNew ahm = null;
    private TextView jYQ = null;
    private MorePopupWindow jYU = null;
    private com.baidu.tbadk.core.dialog.b jYW = null;
    private Dialog jYZ = null;
    private com.baidu.tbadk.core.dialog.a jRA = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a jZb = null;
    private NewSubPbActivity.a jZc = null;
    private h iQa = null;
    private int eDr = 0;
    private int jZh = 2;
    private int jZi = 0;
    private boolean elr = true;
    private com.baidu.tieba.pb.a.c efF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.nv(false);
            a.this.nv(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener jZk = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.jZd, i);
            if (view != null && view.getTag() != null) {
                if (a.this.jYi == null) {
                    a.this.jYi = new ad(a.this.jYF.getPageContext(), a.this.aIH);
                }
                a.this.jYi.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.ru(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.jYi.a(sparseArray, a.this.jYf.cCx(), z);
                if (z) {
                    a.this.jYi.cGu().setVisibility(0);
                    a.this.jYi.cGu().setTag(postData.getId());
                } else {
                    a.this.jYi.cGu().setVisibility(8);
                }
                a.this.jYi.cGs().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener jZl = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.jYF != null && bc.checkUpIsLogin(a.this.jYF.getPageContext().getPageActivity())) {
                if ((a.this.jYF.iPP == null || a.this.jYf == null || a.this.jYf.bUa() == null || a.this.jYF.iPP.kZ(a.this.jYf.bUa().replyPrivateFlag)) && a.this.jYf != null && a.this.iQa != null) {
                    a.this.cJo();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cJq();
                        a.this.jYf.cJP();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.iQa.setReplyId(str2);
                            a.this.iQa.yq(str);
                        }
                    }
                    a.this.cJp();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.jYC = null;
        this.jYE = null;
        this.faQ = null;
        this.jYF = null;
        this.hiX = null;
        this.jYG = null;
        this.jYK = null;
        this.jYS = null;
        this.jYX = null;
        this.aIH = null;
        this.mProgress = null;
        this.hDl = null;
        this.jZe = null;
        this.jZf = null;
        this.jZg = null;
        this.jYF = newSubPbActivity;
        this.aIH = onClickListener;
        this.jYC = (SubPbView) LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.jYE = LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.jYD = (LinearLayout) this.jYC.findViewById(R.id.navigation_bar_group);
        this.jZe = (RelativeLayout) this.jYC.findViewById(R.id.subpb_editor_tool_comment);
        this.hDl = (TextView) this.jYC.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hDl.setOnClickListener(this.aIH);
        this.jZf = (ImageView) this.jYC.findViewById(R.id.subpb_editor_tool_more_img);
        this.jZg = (ImageView) this.jYC.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.jZg.setOnClickListener(this.aIH);
        this.jZf.setOnClickListener(this.aIH);
        this.hiX = (NoNetworkView) this.jYC.findViewById(R.id.view_no_network);
        bZp();
        bvo();
        this.jYG = (RelativeLayout) this.jYC.findViewById(R.id.sub_pb_body_layout);
        this.faQ = (BdTypeListView) this.jYC.findViewById(R.id.new_sub_pb_list);
        this.jYR = (ThreadSkinView) LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.faQ.addHeaderView(this.jYR);
        this.faQ.addHeaderView(this.jYE);
        this.hcR = new TextView(newSubPbActivity.getActivity());
        this.hcR.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.faQ.addHeaderView(this.hcR, 0);
        this.jYC.setTopView(this.hcR);
        this.jYC.setNavigationView(this.jYD);
        this.jYC.setListView(this.faQ);
        this.jYC.setContentView(this.jYG);
        this.jYS = new d(this.jYF.getPageContext());
        this.jYS.setLineGone();
        this.jYX = this.jYS.getView();
        this.faQ.setNextPage(this.jYS);
        this.jYS.setOnClickListener(this.aIH);
        this.faQ.setOnItemClickListener(this.jZl);
        this.faQ.setOnItemLongClickListener(this.jZk);
        this.faQ.setOnTouchListener(this.efF);
        this.mProgress = (ProgressBar) this.jYC.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jYE != null) {
            this.jYE.setVisibility(4);
        }
        this.jYK = com.baidu.tbadk.ala.b.aMC().p(this.jYF.getActivity(), 4);
        if (this.jYK != null) {
            this.jYK.setVisibility(8);
            this.jYI.addView(this.jYK, 3);
        }
        this.jZj = new c(this.jYF, this.faQ);
        this.jZj.setFromCDN(this.mIsFromCDN);
        this.jZj.y(this.aIH);
        this.jZj.CY();
    }

    public ListView getListView() {
        return this.faQ;
    }

    public void bvo() {
        this.jYI = (LinearLayout) this.jYE.findViewById(R.id.subpb_head_user_info_root);
        this.jYI.setOnClickListener(this.aIH);
        this.jYJ = (HeadImageView) this.jYE.findViewById(R.id.photo);
        this.jYJ.setRadius(l.getDimens(this.jYF.getActivity(), R.dimen.ds30));
        this.jYJ.setClickable(false);
        this.jUD = (ClickableHeaderImageView) this.jYE.findViewById(R.id.god_user_photo);
        this.jUD.setGodIconMargin(0);
        this.jUD.setGodIconWidth(R.dimen.ds24);
        this.jUD.setRadius(l.getDimens(this.jYF.getActivity(), R.dimen.ds30));
        this.jUD.setClickable(false);
        this.dXU = (TextView) this.jYE.findViewById(R.id.user_name);
        this.jYL = (ImageView) this.jYE.findViewById(R.id.user_rank);
        this.jYL.setVisibility(8);
        this.jUw = (TextView) this.jYE.findViewById(R.id.floor_owner);
        this.jYH = (TextView) this.jYE.findViewById(R.id.see_subject);
        this.jYH.setOnClickListener(this.aIH);
        this.jYM = (TextView) this.jYE.findViewById(R.id.floor);
        this.jYN = (TextView) this.jYE.findViewById(R.id.time);
        this.jYO = (EllipsizeRichTextView) this.jYE.findViewById(R.id.content_text);
        this.jYO.setOnClickListener(this.aIH);
        am.setViewTextColor(this.jYO, (int) R.color.cp_cont_b);
        this.jYO.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.jYO.setLineSpacing(0.0f, 1.25f);
        this.jYP = (TbImageView) this.jYE.findViewById(R.id.sub_pb_image);
        this.jYP.setOnClickListener(this.aIH);
        this.jYQ = (TextView) this.jYE.findViewById(R.id.advert);
        this.ahm = (PlayVoiceBntNew) this.jYE.findViewById(R.id.voice_btn);
        this.jYE.setOnTouchListener(this.efF);
        this.jYE.setOnClickListener(this.aIH);
    }

    public void a(b.a aVar, boolean z) {
        if (this.jZa != null) {
            this.jZa.dismiss();
            this.jZa = null;
        }
        this.jZa = new com.baidu.tbadk.core.dialog.b(this.jYF.getPageContext().getPageActivity());
        if (z) {
            this.jZa.a(new String[]{this.jYF.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.jZa.a(new String[]{this.jYF.getPageContext().getString(R.string.save_to_emotion), this.jYF.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.jZa.d(this.jYF.getPageContext());
        this.jZa.aSU();
    }

    public void cN(View view) {
        this.jYT = view;
    }

    public void bZp() {
        int dimens = l.getDimens(this.jYF.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.jYF.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.jYC.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jYY != null) {
                    a.this.jYC.onFinish();
                } else {
                    a.this.jYF.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            layoutParams.leftMargin = dimens2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = dimens;
            layoutParams2.height = dimens;
            this.mBack.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.hideBottomLine();
    }

    public void cI(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.jYZ == null) {
            this.jYZ = new Dialog(this.jYF.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jYZ.setCanceledOnTouchOutside(true);
            this.jYZ.setCancelable(true);
            this.jYV = LayoutInflater.from(this.jYF.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.jYF.getLayoutMode().onModeChanged(this.jYV);
            this.jYZ.setContentView(this.jYV);
            WindowManager.LayoutParams attributes = this.jYZ.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.jYF.getPageContext().getPageActivity()) * 0.9d);
            this.jYZ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.jYZ.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.jYZ.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.jYZ.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jYZ != null && (a.this.jYZ instanceof Dialog)) {
                        g.b(a.this.jYZ, a.this.jYF.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jYZ != null && (a.this.jYZ instanceof Dialog)) {
                        g.b(a.this.jYZ, a.this.jYF.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.jZb != null) {
                        a.this.jZb.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jYZ != null && (a.this.jYZ instanceof Dialog)) {
                        g.b(a.this.jYZ, a.this.jYF.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.jYF.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.jYZ, this.jYF.getPageContext());
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
        this.jRA = new com.baidu.tbadk.core.dialog.a(this.jYF.getPageContext().getPageActivity());
        this.jRA.kD(i3);
        this.jRA.setYesButtonTag(sparseArray);
        this.jRA.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.jZc != null) {
                    a.this.jZc.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.jRA.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jRA.gW(true);
        this.jRA.b(this.jYF.getPageContext());
        if (z) {
            this.jRA.aST();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bUa;
        if (this.jYF != null && sparseArray != null && this.jYE != null) {
            if (this.hQx == null) {
                this.hQx = new e(this.jYF.getPageContext(), this.jYE);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.jYf != null && (bUa = this.jYf.bUa()) != null && bUa.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUa.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ak akVar = new ak();
            akVar.setFeedBackReasonMap(sparseArray2);
            this.hQx.setDefaultReasonArray(new String[]{this.jYF.getString(R.string.delete_thread_reason_1), this.jYF.getString(R.string.delete_thread_reason_2), this.jYF.getString(R.string.delete_thread_reason_3), this.jYF.getString(R.string.delete_thread_reason_4), this.jYF.getString(R.string.delete_thread_reason_5)});
            this.hQx.setData(akVar);
            this.hQx.zj("4");
            this.hQx.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    String O = aq.O(jSONArray);
                    if (a.this.jZc != null) {
                        a.this.jZc.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(final boolean z) {
        if (this.faQ != null) {
            if (!z) {
                this.faQ.setEnabled(z);
            } else {
                this.faQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.faQ.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.jZb = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.jZc = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.jYF.showToast(this.jYF.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.jYF.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bcW() != null) {
            this.iQa = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.jYG.addView(hVar.bcW(), layoutParams);
            this.iQa.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.cJJ();
                }
            });
        }
    }

    public void cJo() {
        if (this.faQ != null) {
            this.jZi = this.faQ.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.jYf == null || this.jYf.cJM() == null) {
            return false;
        }
        if (this.jYf.cCx() != 0) {
            return false;
        }
        return (this.jXg == null || this.jXg.aOi() == null || this.jXg.aOi().aQx() == null || !TextUtils.equals(this.jXg.aOi().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cJp() {
        if (this.jYf != null) {
            if ((!cJs() && this.jYX != null && this.jYX.isShown()) || v.isEmpty(this.jZd)) {
                this.jYf.sv(false);
            } else {
                this.jYf.sv(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.jYf = subPbModel;
    }

    public void ss(boolean z) {
        if (this.jYf != null && this.jYf.cJm() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.jYY = new BlankView(this.jYF.getPageContext().getPageActivity());
            this.jYD.addView(this.jYY, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.jYY.setVisibility(0);
            this.jYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jYF.finish();
                }
            });
            this.jYC.setBlankView(this.jYY);
        }
    }

    public void cJq() {
        b(this.jYF);
        this.faQ.setNextPage(this.jYS);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.ut(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cJs() && this.jYX != null && this.jYX.isShown()) {
                i = (this.jZi - this.jZh) - 1;
            } else {
                i = this.jZi - this.jZh;
            }
            int count = v.getCount(this.jZd);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(v.subList(this.jZd, 0, i));
            v.add(arrayList, postData2);
            v.add(arrayList, postData);
            this.faQ.smoothScrollToPosition(this.jZi + 2);
            this.faQ.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.faQ.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.faQ.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.jYC;
    }

    public void cHU() {
        if (this.jYU != null) {
            g.dismissPopupWindow(this.jYU, this.jYF.getPageContext().getPageActivity());
        }
        if (this.jYW != null) {
            this.jYW.dismiss();
        }
        if (this.jRA != null) {
            this.jRA.dismiss();
        }
        if (this.jYZ != null) {
            g.b(this.jYZ, this.jYF.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.jYi != null) {
            this.jYi.dismiss();
        }
    }

    public void cJr() {
        this.faQ.setNextPage(this.jYS);
        this.jYS.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.elr = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (nVar != null) {
            if (this.elr && this.jYE != null) {
                this.jYE.setVisibility(8);
                this.faQ.removeHeaderView(this.jYE);
                this.jZh = 1;
            }
            this.jXg = nVar;
            if (this.jXg.cDc() != null) {
                this.jXg.cDc().llJ = true;
            }
            if (this.jYE != null) {
                this.jYE.setVisibility(0);
            }
            if (nVar.aOi() != null && nVar.aOi().aSx()) {
                this.jYH.setText(R.string.view_original);
            } else {
                this.jYH.setText(R.string.view_subject);
            }
            if (nVar.cDc() != null) {
                this.eDr = nVar.cDc().ddu();
                if (this.eDr > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.jYF.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.eDr)));
                    if (this.jYF != null) {
                        this.hDl.setText(this.jYF.cHi());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.jYF.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.jYF.cJm() ? "PB" : null;
                if (nVar.cDc().aQU() != null) {
                    this.jYR.setData(this.jYF.getPageContext(), nVar.cDc().aQU(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.bdP().getId(), nVar.bdP().getName(), nVar.aOi().getId(), str));
                } else {
                    this.jYR.setData(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.jYS.startLoadData();
                this.jZj.setHasMoreData(true);
            } else {
                this.jYS.endLoadData();
                this.jZj.setHasMoreData(false);
            }
            this.jZd = nVar.cDg();
            if (this.jZd == null || this.jZd.size() <= jYB) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.jZd.size() - jYB;
                AI(size);
                int firstVisiblePosition = this.faQ.getFirstVisiblePosition() - size;
                View childAt = this.faQ.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jZd);
            if (v.isEmpty(this.jZd)) {
                this.faQ.setNextPage(null);
                if (this.elr) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.faQ.setNextPage(this.jYS);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(nVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.elr) {
                arrayList.add(0, nVar.cDc());
            }
            this.jZj.b(this.jXg.aOi(), arrayList);
            a(nVar, nVar.cDc(), nVar.coK(), nVar.aML(), i, z);
            if (i4 > 0) {
                this.faQ.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void AI(int i) {
        if (this.jZd != null) {
            if (this.jZd.size() <= i) {
                this.jZd.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.jZd.iterator();
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

    public boolean cJs() {
        return this.jZj.anV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.elr) {
            if (!StringUtils.isNull(postData.ddB())) {
                this.jYP.setVisibility(0);
                this.jYP.startLoad(postData.ddB(), 10, true);
            } else {
                this.jYP.setVisibility(8);
            }
            i ddD = postData.ddD();
            if (ddD != null && ddD.lkq) {
                this.jYQ.setVisibility(0);
            } else {
                this.jYQ.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.jYE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.jYE.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.jYM.setText((CharSequence) null);
            this.dXU.setText((CharSequence) null);
            this.jUw.setVisibility(8);
            if (!this.elr) {
                c(postData.aQx());
                if (z) {
                    this.jUw.setVisibility(0);
                    am.setViewTextColor(this.jUw, (int) R.color.cp_link_tip_a);
                }
            }
            this.jYN.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.jYF.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.ddu()));
            if (nVar.aOi() != null && nVar.aOi().aSx()) {
                this.jYM.setText((CharSequence) null);
            } else {
                this.jYM.setText(format);
            }
            postData.aQx().getUserTbVipInfoData();
            boolean a = a(this.jYO, postData.ddw());
            if (StringUtils.isNull(postData.ddB()) && !a && postData.biy() != null) {
                this.ahm.setVisibility(0);
                this.ahm.setTag(postData.biy());
                return;
            }
            this.ahm.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ae.getTextLength(name_show) > 14) {
                str = ae.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.dXU.setText(dk(metaData.getSealPrefix(), str));
            } else {
                this.dXU.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.jYK != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.jYK.setVisibility(8);
                } else {
                    this.jYK.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dxn = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.jYK.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.jUD.setVisibility(0);
                this.jYJ.setVisibility(8);
                this.jUD.setUserId(metaData.getUserId());
                this.jUD.setUserName(metaData.getUserName());
                this.jUD.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.dXU, (int) R.color.cp_cont_r);
            } else {
                this.jUD.setVisibility(8);
                this.jYJ.setVisibility(0);
                this.jYJ.setUserId(metaData.getUserId());
                this.jYJ.setUserName(metaData.getUserName());
                this.jYJ.setDefaultResource(R.drawable.transparent_bg);
                this.jYJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jYJ.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.dXU, (int) R.color.cp_cont_c);
            }
            this.jYI.setTag(R.id.tag_user_id, metaData.getUserId());
            this.jYI.setTag(R.id.tag_user_name, metaData.getUserName());
            this.jYI.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.biq() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.biq().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.bix());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.iI(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dlQ());
                        continue;
                    case 17:
                        String str = next.biB().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.j("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.biF()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bix() == null || tbRichTextData.bix().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bix());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jYF.getPageContext().getString(R.string.refresh_view_button_text), this.dyx));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.jYF.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.jYG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.faQ.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.iQa.bdV();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.jYF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void xA(int i) {
        b(NoDataViewFactory.d.dj(null, this.jYF.getResources().getString(R.string.refresh_view_title_text)));
        this.jZe.setVisibility(8);
    }

    public void Dh(String str) {
        b(NoDataViewFactory.d.dj(str, this.jYF.getPageContext().getString(R.string.refresh_view_title_text)));
        this.jZe.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.faQ.setVisibility(0);
            this.jZe.setVisibility(0);
            this.jYC.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        int i2;
        boolean z4;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            boolean z5 = false;
            boolean z6 = false;
            if (i != 0) {
                if (i != 3) {
                    z5 = true;
                    z6 = true;
                }
                String userId2 = postData.aQx().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.jXg != null && this.jXg.aOi() != null && this.jXg.aOi().aQx() != null && postData.aQx() != null) {
                String userId3 = this.jXg.aOi().aQx().getUserId();
                String userId4 = postData.aQx().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aQx().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.ddu() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
                        }
                    } else {
                        z4 = false;
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                    }
                    if (!z2) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z4));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z5) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aQx().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aQx().getName_show());
                        }
                        if (this.jXg.aOi() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jXg.aOi().getId());
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
            z2 = z6;
            z3 = false;
            userId = postData.aQx().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.ddu() == 1) {
            }
            if (!z5) {
            }
            if (!z2) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z4));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z5) {
            }
            if (!z) {
            }
            if (!z2) {
            }
        }
    }

    public void st(boolean z) {
        if (this.jYi != null && this.jYi.cGs() != null) {
            if (z) {
                this.jYi.cGs().setText(R.string.remove_mark);
            } else {
                this.jYi.cGs().setText(R.string.mark);
            }
        }
    }

    public View cJt() {
        return this.jYX;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.jYC, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.jYG, R.color.cp_bg_line_d);
        this.jYF.getLayoutMode().setNightMode(i == 1);
        this.jYF.getLayoutMode().onModeChanged(this.jYC);
        this.jYF.getLayoutMode().onModeChanged(this.jYE);
        this.mNavigationBar.onChangeSkinType(this.jYF.getPageContext(), i);
        if (this.jYH != null) {
            am.setViewTextColor(this.jYH, (int) R.color.goto_see_subject_color);
        }
        this.hiX.onChangeSkinType(this.jYF.getPageContext(), i);
        this.jYF.getLayoutMode().onModeChanged(this.jYX);
        am.setViewTextColor(this.jYO, (int) R.color.cp_cont_b);
        this.jYO.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.iQa != null && this.iQa.bcW() != null) {
            this.iQa.bcW().onChangeSkinType(i);
        }
        this.jYS.changeSkin(i);
        this.ahm.crm();
        am.setViewTextColor(this.hDl, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.jUw, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.dXU, (int) R.color.cp_cont_c);
        this.hDl.setAlpha(0.95f);
        if (this.jYT != null) {
            com.baidu.tbadk.q.a.a(this.jYF.getPageContext(), this.jYT);
        }
        if (this.jZj != null) {
            this.jZj.notifyDataSetChanged();
        }
        this.jYF.getLayoutMode().onModeChanged(this.jYV);
    }

    public void cJu() {
        this.mProgress.setVisibility(0);
    }

    public void cJv() {
        this.faQ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jYS.endLoadData();
    }

    public void bSd() {
        this.faQ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jYS.bSd();
    }

    public boolean cJw() {
        return this.jYC.cJw();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.jZj.c(onLongClickListener);
    }

    public View cJx() {
        return this.jYE;
    }

    public TextView bZu() {
        return this.hDl;
    }

    public ImageView cJy() {
        return this.jZf;
    }

    public ImageView cJz() {
        return this.jZg;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void AJ(int i) {
    }

    public View cJA() {
        return this.jYH;
    }

    public View cJB() {
        return this.jYP;
    }

    public MorePopupWindow cJC() {
        return this.jYU;
    }

    public void showLoadingDialog() {
        if (this.gKp == null) {
            this.gKp = new com.baidu.tbadk.core.view.a(this.jYF.getPageContext());
        }
        this.gKp.setDialogVisiable(true);
    }

    public void bGf() {
        if (this.gKp != null) {
            this.gKp.setDialogVisiable(false);
        }
    }

    public TextView cJD() {
        return this.jYO;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jZj.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.jZj != null) {
            this.jZj.notifyDataSetChanged();
        }
    }

    public ad cJE() {
        return this.jYi;
    }

    public void cbz() {
    }

    public void cbA() {
    }

    public void bZP() {
        this.jYC.onDestroy();
    }

    public void cJF() {
        if (this.jYF.isPaused()) {
        }
    }

    public View cJG() {
        return this.jYI;
    }

    private SpannableStringBuilder dk(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.jYF.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cJH() {
        if (this.iQa == null || this.iQa.bcW() == null) {
            return 0;
        }
        return this.iQa.bcW().getHeight();
    }

    public int cJI() {
        if (this.jYY == null) {
            return 0;
        }
        return this.jYY.getHeight();
    }

    public void cJJ() {
        if (this.hDl != null && this.iQa != null) {
            if (this.iQa.bea()) {
                this.hDl.setText(R.string.draft_to_send);
            } else {
                this.hDl.setText(this.jYF.cHi());
            }
        }
    }
}
