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
import com.baidu.tbadk.core.data.al;
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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class a implements KeyboardEventLayout.a {
    private static final int iPT = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener ahD;
    private BdTypeListView efM;
    private com.baidu.tbadk.core.view.a fKp;
    private View fYJ;
    private e gKU;
    private NoNetworkView geQ;
    private TextView gyz;
    private m iOD;
    private z iPC;
    private SubPbView iPU;
    private LinearLayout iPV;
    private View iPW;
    private NewSubPbActivity iPX;
    private RelativeLayout iPY;
    private SubPbModel iPz;
    private c iQB;
    private View iQc;
    private ThreadSkinView iQj;
    private d iQk;
    private View iQl;
    private View iQn;
    private View iQp;
    private BlankView iQq;
    private com.baidu.tbadk.core.dialog.b iQs;
    private ArrayList<PostData> iQv;
    private RelativeLayout iQw;
    private ImageView iQx;
    private ImageView iQy;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener cGJ = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView iPZ = null;
    private LinearLayout iQa = null;
    private HeadImageView iQb = null;
    private ClickableHeaderImageView iMd = null;
    private TextView bXt = null;
    private ImageView iQd = null;
    private TextView iLW = null;
    private TextView iQe = null;
    private TextView iQf = null;
    private EllipsizeRichTextView iQg = null;
    private TbImageView iQh = null;
    private PlayVoiceBntNew Ns = null;
    private TextView iQi = null;
    private MorePopupWindow iQm = null;
    private com.baidu.tbadk.core.dialog.b iQo = null;
    private Dialog iQr = null;
    private com.baidu.tbadk.core.dialog.a iJh = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a iQt = null;
    private NewSubPbActivity.a iQu = null;
    private h hKe = null;
    private int dKa = 0;
    private int iQz = 2;
    private int iQA = 0;
    private boolean dsE = true;
    private com.baidu.tieba.pb.a.c dmm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lD(false);
            a.this.lD(true);
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
    protected AdapterView.OnItemLongClickListener iQC = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.iQv, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (a.this.iPC == null) {
                a.this.iPC = new z(a.this.iPX.getPageContext(), a.this.ahD);
            }
            a.this.iPC.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean pw = a.this.pw(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            a.this.iPC.a(sparseArray, a.this.iPz.chW(), pw);
            if (pw) {
                a.this.iPC.clX().setVisibility(0);
                a.this.iPC.clX().setTag(postData.getId());
            } else {
                a.this.iPC.clX().setVisibility(8);
            }
            a.this.iPC.clV().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener iQD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bc.checkUpIsLogin(a.this.iPX.getPageContext().getPageActivity())) {
                if (a.this.iPX.hJV == null || a.this.iPz == null || a.this.iPz.bAs() == null || a.this.iPX.hJV.kb(a.this.iPz.bAs().replyPrivateFlag)) {
                    a.this.coQ();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.coS();
                        a.this.iPz.cpq();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.hKe.setReplyId(str2);
                            a.this.hKe.uW(str);
                        }
                    }
                    a.this.coR();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.iPU = null;
        this.iPW = null;
        this.efM = null;
        this.iPX = null;
        this.geQ = null;
        this.iPY = null;
        this.iQc = null;
        this.iQk = null;
        this.iQp = null;
        this.ahD = null;
        this.mProgress = null;
        this.gyz = null;
        this.iQw = null;
        this.iQx = null;
        this.iQy = null;
        this.iPX = newSubPbActivity;
        this.ahD = onClickListener;
        this.iPU = (SubPbView) LayoutInflater.from(this.iPX.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iPW = LayoutInflater.from(this.iPX.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.iPV = (LinearLayout) this.iPU.findViewById(R.id.navigation_bar_group);
        this.iQw = (RelativeLayout) this.iPU.findViewById(R.id.subpb_editor_tool_comment);
        this.gyz = (TextView) this.iPU.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gyz.setOnClickListener(this.ahD);
        this.iQx = (ImageView) this.iPU.findViewById(R.id.subpb_editor_tool_more_img);
        this.iQy = (ImageView) this.iPU.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iQy.setOnClickListener(this.ahD);
        this.iQx.setOnClickListener(this.ahD);
        this.geQ = (NoNetworkView) this.iPU.findViewById(R.id.view_no_network);
        bFD();
        bdv();
        this.iPY = (RelativeLayout) this.iPU.findViewById(R.id.sub_pb_body_layout);
        this.efM = (BdTypeListView) this.iPU.findViewById(R.id.new_sub_pb_list);
        this.iQj = (ThreadSkinView) LayoutInflater.from(this.iPX.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.efM.addHeaderView(this.iQj);
        this.efM.addHeaderView(this.iPW);
        this.fYJ = new TextView(newSubPbActivity.getActivity());
        this.fYJ.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.efM.addHeaderView(this.fYJ, 0);
        this.iPU.setTopView(this.fYJ);
        this.iPU.setNavigationView(this.iPV);
        this.iPU.setListView(this.efM);
        this.iPU.setContentView(this.iPY);
        this.iQk = new d(this.iPX.getPageContext());
        this.iQk.setLineGone();
        this.iQp = this.iQk.getView();
        this.efM.setNextPage(this.iQk);
        this.iQk.setOnClickListener(this.ahD);
        this.efM.setOnItemClickListener(this.iQD);
        this.efM.setOnItemLongClickListener(this.iQC);
        this.efM.setOnTouchListener(this.dmm);
        this.mProgress = (ProgressBar) this.iPU.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iPW != null) {
            this.iPW.setVisibility(4);
        }
        this.iQc = com.baidu.tbadk.ala.b.avT().u(this.iPX.getActivity(), 4);
        if (this.iQc != null) {
            this.iQc.setVisibility(8);
            this.iQa.addView(this.iQc, 3);
        }
        this.iQB = new c(this.iPX, this.efM);
        this.iQB.setFromCDN(this.mIsFromCDN);
        this.iQB.y(this.ahD);
        this.iQB.uR();
    }

    public ListView getListView() {
        return this.efM;
    }

    public void bdv() {
        this.iQa = (LinearLayout) this.iPW.findViewById(R.id.subpb_head_user_info_root);
        this.iQa.setOnClickListener(this.ahD);
        this.iQb = (HeadImageView) this.iPW.findViewById(R.id.photo);
        this.iQb.setRadius(l.getDimens(this.iPX.getActivity(), R.dimen.ds30));
        this.iQb.setClickable(false);
        this.iMd = (ClickableHeaderImageView) this.iPW.findViewById(R.id.god_user_photo);
        this.iMd.setGodIconMargin(0);
        this.iMd.setGodIconWidth(R.dimen.ds24);
        this.iMd.setRadius(l.getDimens(this.iPX.getActivity(), R.dimen.ds30));
        this.iMd.setClickable(false);
        this.bXt = (TextView) this.iPW.findViewById(R.id.user_name);
        this.iQd = (ImageView) this.iPW.findViewById(R.id.user_rank);
        this.iQd.setVisibility(8);
        this.iLW = (TextView) this.iPW.findViewById(R.id.floor_owner);
        this.iPZ = (TextView) this.iPW.findViewById(R.id.see_subject);
        this.iPZ.setOnClickListener(this.ahD);
        this.iQe = (TextView) this.iPW.findViewById(R.id.floor);
        this.iQf = (TextView) this.iPW.findViewById(R.id.time);
        this.iQg = (EllipsizeRichTextView) this.iPW.findViewById(R.id.content_text);
        this.iQg.setOnClickListener(this.ahD);
        am.setViewTextColor(this.iQg, (int) R.color.cp_cont_b);
        this.iQg.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.iQg.setLineSpacing(0.0f, 1.25f);
        this.iQh = (TbImageView) this.iPW.findViewById(R.id.sub_pb_image);
        this.iQh.setOnClickListener(this.ahD);
        this.iQi = (TextView) this.iPW.findViewById(R.id.advert);
        this.Ns = (PlayVoiceBntNew) this.iPW.findViewById(R.id.voice_btn);
        this.iPW.setOnTouchListener(this.dmm);
        this.iPW.setOnClickListener(this.ahD);
    }

    public void a(b.a aVar, boolean z) {
        if (this.iQs != null) {
            this.iQs.dismiss();
            this.iQs = null;
        }
        this.iQs = new com.baidu.tbadk.core.dialog.b(this.iPX.getPageContext().getPageActivity());
        if (z) {
            this.iQs.a(new String[]{this.iPX.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.iQs.a(new String[]{this.iPX.getPageContext().getString(R.string.save_to_emotion), this.iPX.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.iQs.d(this.iPX.getPageContext());
        this.iQs.aBX();
    }

    public void cA(View view) {
        this.iQl = view;
    }

    public void bFD() {
        int dimens = l.getDimens(this.iPX.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.iPX.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.iPU.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iQq != null) {
                    a.this.iPU.onFinish();
                } else {
                    a.this.iPX.finish();
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

    public void cw(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.iQr == null) {
            this.iQr = new Dialog(this.iPX.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iQr.setCanceledOnTouchOutside(true);
            this.iQr.setCancelable(true);
            this.iQn = LayoutInflater.from(this.iPX.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iPX.getLayoutMode().onModeChanged(this.iQn);
            this.iQr.setContentView(this.iQn);
            WindowManager.LayoutParams attributes = this.iQr.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.iPX.getPageContext().getPageActivity()) * 0.9d);
            this.iQr.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.iQr.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.iQr.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.iQr.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.iQr != null && (a.this.iQr instanceof Dialog)) {
                        g.b(a.this.iQr, a.this.iPX.getPageContext());
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
                    if (a.this.iQr != null && (a.this.iQr instanceof Dialog)) {
                        g.b(a.this.iQr, a.this.iPX.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.iQt != null) {
                        a.this.iQt.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.iQr != null && (a.this.iQr instanceof Dialog)) {
                        g.b(a.this.iQr, a.this.iPX.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.iPX.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.iQr, this.iPX.getPageContext());
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
        this.iJh = new com.baidu.tbadk.core.dialog.a(this.iPX.getPageContext().getPageActivity());
        this.iJh.jF(i3);
        this.iJh.setYesButtonTag(sparseArray);
        this.iJh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.iQu != null) {
                    a.this.iQu.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.iJh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iJh.fu(true);
        this.iJh.b(this.iPX.getPageContext());
        if (z) {
            this.iJh.aBW();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bAs;
        if (this.iPX != null && sparseArray != null && this.iPW != null) {
            if (this.gKU == null) {
                this.gKU = new e(this.iPX.getPageContext(), this.iPW);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.iPz != null && (bAs = this.iPz.bAs()) != null && bAs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bAs.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.gKU.setDefaultReasonArray(new String[]{this.iPX.getString(R.string.delete_thread_reason_1), this.iPX.getString(R.string.delete_thread_reason_2), this.iPX.getString(R.string.delete_thread_reason_3), this.iPX.getString(R.string.delete_thread_reason_4), this.iPX.getString(R.string.delete_thread_reason_5)});
            this.gKU.setData(alVar);
            this.gKU.vO("4");
            this.gKU.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void R(JSONArray jSONArray) {
                    String N = aq.N(jSONArray);
                    if (a.this.iQu != null) {
                        a.this.iQu.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), N});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(final boolean z) {
        if (this.efM != null) {
            if (!z) {
                this.efM.setEnabled(z);
            } else {
                this.efM.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.efM.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.iQt = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.iQu = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iPX.showToast(this.iPX.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iPX.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aLC() != null) {
            this.hKe = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.iPY.addView(hVar.aLC(), layoutParams);
            this.hKe.a(new v.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    a.this.cpk();
                }
            });
        }
    }

    public void coQ() {
        if (this.efM != null) {
            this.iQA = this.efM.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pw(boolean z) {
        if (this.iPz == null || this.iPz.cpn() == null) {
            return false;
        }
        if (this.iPz.chW() != 0) {
            return false;
        }
        return (this.iOD == null || this.iOD.axx() == null || this.iOD.axx().azE() == null || !TextUtils.equals(this.iOD.axx().azE().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void coR() {
        if (this.iPz != null) {
            if ((!coU() && this.iQp != null && this.iQp.isShown()) || com.baidu.tbadk.core.util.v.isEmpty(this.iQv)) {
                this.iPz.qz(false);
            } else {
                this.iPz.qz(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.iPz = subPbModel;
    }

    public void qw(boolean z) {
        if (this.iPz != null && this.iPz.coO() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.iQq = new BlankView(this.iPX.getPageContext().getPageActivity());
            this.iPV.addView(this.iQq, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.iQq.setVisibility(0);
            this.iQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.iPX.finish();
                }
            });
            this.iPU.setBlankView(this.iQq);
        }
    }

    public void coS() {
        b(this.iPX);
        this.efM.setNextPage(this.iQk);
    }

    public void s(PostData postData) {
        int i;
        if (postData != null) {
            postData.sx(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!coU() && this.iQp != null && this.iQp.isShown()) {
                i = (this.iQA - this.iQz) - 1;
            } else {
                i = this.iQA - this.iQz;
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.iQv);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.v.subList(this.iQv, 0, i));
            com.baidu.tbadk.core.util.v.add(arrayList, postData2);
            com.baidu.tbadk.core.util.v.add(arrayList, postData);
            this.efM.smoothScrollToPosition(this.iQA + 2);
            this.efM.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.efM.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.efM.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.iPU;
    }

    public void cny() {
        if (this.iQm != null) {
            g.dismissPopupWindow(this.iQm, this.iPX.getPageContext().getPageActivity());
        }
        if (this.iQo != null) {
            this.iQo.dismiss();
        }
        if (this.iJh != null) {
            this.iJh.dismiss();
        }
        if (this.iQr != null) {
            g.b(this.iQr, this.iPX.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iPC != null) {
            this.iPC.dismiss();
        }
    }

    public void coT() {
        this.efM.setNextPage(this.iQk);
        this.iQk.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dsE = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (mVar != null) {
            if (this.dsE && this.iPW != null) {
                this.iPW.setVisibility(8);
                this.efM.removeHeaderView(this.iPW);
                this.iQz = 1;
            }
            this.iOD = mVar;
            if (this.iPW != null) {
                this.iPW.setVisibility(0);
            }
            if (mVar.axx() != null && mVar.axx().aBC()) {
                this.iPZ.setText(R.string.view_original);
            } else {
                this.iPZ.setText(R.string.view_subject);
            }
            if (mVar.cix() != null) {
                this.dKa = mVar.cix().cIt();
                if (this.dKa > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iPX.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.dKa)));
                    if (this.iPX != null) {
                        this.gyz.setText(this.iPX.cmM());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.iPX.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.iPX.coO() ? "PB" : null;
                if (mVar.cix().azZ() != null) {
                    this.iQj.setData(this.iPX.getPageContext(), mVar.cix().azZ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aMv().getId(), mVar.aMv().getName(), mVar.axx().getId(), str));
                } else {
                    this.iQj.setData(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.iQk.startLoadData();
                this.iQB.setHasMoreData(true);
            } else {
                this.iQk.endLoadData();
                this.iQB.setHasMoreData(false);
            }
            this.iQv = mVar.ciB();
            if (this.iQv == null || this.iQv.size() <= iPT) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.iQv.size() - iPT;
                zd(size);
                int firstVisiblePosition = this.efM.getFirstVisiblePosition() - size;
                View childAt = this.efM.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iQv);
            if (com.baidu.tbadk.core.util.v.isEmpty(this.iQv)) {
                this.efM.setNextPage(null);
                if (this.dsE) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.efM.setNextPage(this.iQk);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(mVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.dsE) {
                arrayList.add(0, mVar.cix());
            }
            this.iQB.b(this.iOD.axx(), arrayList);
            a(mVar, mVar.cix(), mVar.bUI(), mVar.awd(), i, z);
            if (i4 > 0) {
                this.efM.setSelectionFromTop(i3, i2);
            }
            this.iPU.show();
        }
    }

    private void zd(int i) {
        if (this.iQv != null) {
            if (this.iQv.size() <= i) {
                this.iQv.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.iQv.iterator();
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

    public boolean coU() {
        return this.iQB.Zn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dsE) {
            if (!StringUtils.isNull(postData.cIA())) {
                this.iQh.setVisibility(0);
                this.iQh.startLoad(postData.cIA(), 10, true);
            } else {
                this.iQh.setVisibility(8);
            }
            i cIC = postData.cIC();
            if (cIC != null && cIC.kbq) {
                this.iQi.setVisibility(0);
            } else {
                this.iQi.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iPW.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iPW.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iQe.setText((CharSequence) null);
            this.bXt.setText((CharSequence) null);
            this.iLW.setVisibility(8);
            if (!this.dsE) {
                c(postData.azE());
                if (z) {
                    this.iLW.setVisibility(0);
                    am.setViewTextColor(this.iLW, (int) R.color.cp_link_tip_a);
                }
            }
            this.iQf.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.iPX.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cIt()));
            if (mVar.axx() != null && mVar.axx().aBC()) {
                this.iQe.setText((CharSequence) null);
            } else {
                this.iQe.setText(format);
            }
            postData.azE().getUserTbVipInfoData();
            boolean a = a(this.iQg, postData.cIv());
            if (StringUtils.isNull(postData.cIA()) && !a && postData.aRn() != null) {
                this.Ns.setVisibility(0);
                this.Ns.setTag(postData.aRn());
                return;
            }
            this.Ns.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ad.getTextLength(name_show) > 14) {
                str = ad.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.bXt.setText(cs(metaData.getSealPrefix(), str));
            } else {
                this.bXt.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.iQc != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iQc.setVisibility(8);
                } else {
                    this.iQc.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cFA = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iQc.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.iMd.setVisibility(0);
                this.iQb.setVisibility(8);
                this.iMd.setUserId(metaData.getUserId());
                this.iMd.setUserName(metaData.getUserName());
                this.iMd.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.bXt, (int) R.color.cp_cont_r);
            } else {
                this.iMd.setVisibility(8);
                this.iQb.setVisibility(0);
                this.iQb.setUserId(metaData.getUserId());
                this.iQb.setUserName(metaData.getUserName());
                this.iQb.setDefaultResource(R.drawable.transparent_bg);
                this.iQb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iQb.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.bXt, (int) R.color.cp_cont_c);
            }
            this.iQa.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iQa.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iQa.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.aRf() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.aRf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.aRm());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ha(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cQS());
                        continue;
                    case 17:
                        String str = next.aRq().mGifInfo.mSharpText;
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
        if (!tbRichTextData.aRv()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.aRm() == null || tbRichTextData.aRm().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.aRm());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iPX.getPageContext().getString(R.string.refresh_view_button_text), this.cGJ));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iPX.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iPY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.efM.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.hKe.aMB();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iPX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void wd(int i) {
        b(NoDataViewFactory.d.cr(null, this.iPX.getResources().getString(R.string.refresh_view_title_text)));
        this.iQw.setVisibility(8);
    }

    public void zm(String str) {
        b(NoDataViewFactory.d.cr(str, this.iPX.getPageContext().getString(R.string.refresh_view_title_text)));
        this.iQw.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.efM.setVisibility(0);
            this.iQw.setVisibility(0);
            this.iPU.setOnTouchListener(null);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        this.cGJ = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0295  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            boolean z6 = false;
            boolean z7 = false;
            if (i != 0) {
                if (i != 3) {
                    z6 = true;
                    z7 = true;
                }
                String userId2 = postData.azE().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.iOD != null && this.iOD.axx() != null && this.iOD.axx().azE() != null && postData.azE() != null) {
                String userId3 = this.iOD.axx().azE().getUserId();
                String userId4 = postData.azE().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.azE().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.cIt() == 1) {
                        i2 = 0;
                    }
                    if (ap.o(postData)) {
                        z4 = z6;
                    } else {
                        z2 = false;
                        z = false;
                        z4 = false;
                    }
                    if (!z4) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.azE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.azE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.azE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.azE().getPortrait());
                        }
                    } else {
                        z5 = false;
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                    }
                    if (!z2) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.azE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.azE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.azE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.azE().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.azE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.azE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azE().getName_show());
                        }
                        if (this.iOD.axx() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iOD.axx().getId());
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
            z2 = z7;
            z3 = false;
            userId = postData.azE().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.cIt() == 1) {
            }
            if (ap.o(postData)) {
            }
            if (!z4) {
            }
            if (!z2) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z4) {
            }
            if (!z) {
            }
            if (!z2) {
            }
        }
    }

    public void qx(boolean z) {
        if (this.iPC != null && this.iPC.clV() != null) {
            if (z) {
                this.iPC.clV().setText(R.string.remove_mark);
            } else {
                this.iPC.clV().setText(R.string.mark);
            }
        }
    }

    public View coV() {
        return this.iQp;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.iPU, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.iPY, R.color.cp_bg_line_d);
        this.iPX.getLayoutMode().setNightMode(i == 1);
        this.iPX.getLayoutMode().onModeChanged(this.iPU);
        this.iPX.getLayoutMode().onModeChanged(this.iPW);
        this.mNavigationBar.onChangeSkinType(this.iPX.getPageContext(), i);
        if (this.iPZ != null) {
            am.setViewTextColor(this.iPZ, (int) R.color.goto_see_subject_color);
        }
        this.geQ.onChangeSkinType(this.iPX.getPageContext(), i);
        this.iPX.getLayoutMode().onModeChanged(this.iQp);
        am.setViewTextColor(this.iQg, (int) R.color.cp_cont_b);
        this.iQg.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.hKe != null && this.hKe.aLC() != null) {
            this.hKe.aLC().onChangeSkinType(i);
        }
        this.iQk.changeSkin(i);
        this.Ns.bEM();
        am.setViewTextColor(this.gyz, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.iLW, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.bXt, (int) R.color.cp_cont_c);
        this.gyz.setAlpha(0.95f);
        if (this.iQl != null) {
            com.baidu.tbadk.q.a.a(this.iPX.getPageContext(), this.iQl);
        }
        if (this.iQB != null) {
            this.iQB.notifyDataSetChanged();
        }
        this.iPX.getLayoutMode().onModeChanged(this.iQn);
    }

    public void coW() {
        this.mProgress.setVisibility(0);
    }

    public void coX() {
        this.efM.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iQk.endLoadData();
    }

    public void byw() {
        this.efM.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iQk.byw();
    }

    public boolean coY() {
        return this.iPU.coY();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iQB.setLongClickListener(onLongClickListener);
    }

    public View coZ() {
        return this.iPW;
    }

    public TextView bFI() {
        return this.gyz;
    }

    public ImageView cpa() {
        return this.iQx;
    }

    public ImageView cpb() {
        return this.iQy;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void ze(int i) {
    }

    public View cpc() {
        return this.iPZ;
    }

    public View cpd() {
        return this.iQh;
    }

    public MorePopupWindow cpe() {
        return this.iQm;
    }

    public void showLoadingDialog() {
        if (this.fKp == null) {
            this.fKp = new com.baidu.tbadk.core.view.a(this.iPX.getPageContext());
        }
        this.fKp.setDialogVisiable(true);
    }

    public void bnJ() {
        if (this.fKp != null) {
            this.fKp.setDialogVisiable(false);
        }
    }

    public TextView cpf() {
        return this.iQg;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iQB.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.iQB != null) {
            this.iQB.notifyDataSetChanged();
        }
    }

    public z cpg() {
        return this.iPC;
    }

    public void bHJ() {
    }

    public void bHK() {
    }

    public void afZ() {
        this.iPU.onDestroy();
    }

    public void cph() {
        if (this.iPX.isPaused()) {
        }
    }

    public View cpi() {
        return this.iQa;
    }

    private SpannableStringBuilder cs(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iPX.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cpj() {
        if (this.hKe == null || this.hKe.aLC() == null) {
            return 0;
        }
        return this.hKe.aLC().getHeight();
    }

    public void cpk() {
        if (this.gyz != null && this.hKe != null) {
            if (this.hKe.aMG()) {
                this.gyz.setText(R.string.draft_to_send);
            } else {
                this.gyz.setText(this.iPX.cmM());
            }
        }
    }
}
