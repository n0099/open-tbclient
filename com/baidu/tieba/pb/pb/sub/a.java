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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class a implements KeyboardEventLayout.a {
    private static final int lqc = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aXk;
    private f.c eHp;
    private BdTypeListView fSo;
    private NoNetworkView fjl;
    private LinearLayout fjm;
    private com.baidu.tbadk.core.view.a hMa;
    private TextView iHp;
    private e iVq;
    private View ieu;
    private com.baidu.tieba.pb.view.d liQ;
    private View ljj;
    private LinearLayout ljl;
    private HeadImageView ljm;
    private p loK;
    private SubPbModel lpA;
    private ah lpD;
    private com.baidu.tbadk.core.dialog.b lqA;
    private ArrayList<PostData> lqD;
    private RelativeLayout lqE;
    private ImageView lqF;
    private ImageView lqG;
    private c lqJ;
    private SubPbView lqd;
    private View lqe;
    private NewSubPbActivity lqf;
    private RelativeLayout lqg;
    private View lqk;
    private ThreadSkinView lqr;
    private d lqs;
    private View lqt;
    private View lqv;
    private View lqx;
    private BlankView lqy;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener egY = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lqh = null;
    private LinearLayout lqi = null;
    private HeadImageView lqj = null;
    private TextView eig = null;
    private ImageView lql = null;
    private TextView llR = null;
    private TextView lqm = null;
    private TextView lqn = null;
    private EllipsizeRichTextView lqo = null;
    private TbImageView lqp = null;
    private PlayVoiceBntNew akv = null;
    private TextView lqq = null;
    private MorePopupWindow lqu = null;
    private com.baidu.tbadk.core.dialog.b lqw = null;
    private Dialog lqz = null;
    private com.baidu.tbadk.core.dialog.a liU = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lqB = null;
    private NewSubPbActivity.a lqC = null;
    private h kdj = null;
    private int fua = 0;
    private int lqH = 2;
    private int lqI = 0;
    private boolean eZv = true;
    private boolean kYN = com.baidu.tbadk.a.d.bdC();
    private com.baidu.tieba.pb.a.c eTx = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.7
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.pD(false);
            a.this.pD(true);
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
    protected AdapterView.OnItemLongClickListener lqK = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) y.getItem(a.this.lqD, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lpD == null) {
                    a.this.lpD = new ah(a.this.lqf.getPageContext(), a.this.aXk);
                }
                a.this.lpD.Pd();
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    return true;
                }
                PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                boolean z2 = a.this.tJ(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.lpD;
                int dcP = a.this.lpA.dcP();
                if (!a.this.kYN || postData2 == null || !postData2.mFf) {
                    z = false;
                }
                ahVar.a(sparseArray, dcP, z2, z);
                if (z2) {
                    a.this.lpD.dgP().setVisibility(0);
                    a.this.lpD.dgP().setTag(postData.getId());
                } else {
                    a.this.lpD.dgP().setVisibility(8);
                }
                a.this.lpD.dgN().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lqL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.lqf != null && bg.checkUpIsLogin(a.this.lqf.getPageContext().getPageActivity())) {
                if ((a.this.lqf.kdd == null || a.this.lpA == null || a.this.lpA.crF() == null || a.this.lqf.kdd.oy(a.this.lpA.crF().replyPrivateFlag)) && a.this.lpA != null && a.this.kdj != null) {
                    a.this.djN();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.djP();
                        a.this.lpA.dko();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kdj.setReplyId(str2);
                            a.this.kdj.Do(str);
                        }
                    }
                    a.this.djO();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.lqd = null;
        this.lqe = null;
        this.fSo = null;
        this.liQ = null;
        this.lqf = null;
        this.fjl = null;
        this.lqg = null;
        this.lqk = null;
        this.lqs = null;
        this.lqx = null;
        this.aXk = null;
        this.mProgress = null;
        this.iHp = null;
        this.lqE = null;
        this.lqF = null;
        this.lqG = null;
        this.lqf = newSubPbActivity;
        this.aXk = onClickListener;
        this.lqd = (SubPbView) LayoutInflater.from(this.lqf.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.lqe = LayoutInflater.from(this.lqf.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fjm = (LinearLayout) this.lqd.findViewById(R.id.navigation_bar_group);
        this.lqE = (RelativeLayout) this.lqd.findViewById(R.id.subpb_editor_tool_comment);
        this.iHp = (TextView) this.lqd.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.iHp.setOnClickListener(this.aXk);
        this.lqF = (ImageView) this.lqd.findViewById(R.id.subpb_editor_tool_more_img);
        this.lqG = (ImageView) this.lqd.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lqG.setOnClickListener(this.aXk);
        this.lqF.setOnClickListener(this.aXk);
        this.fjl = (NoNetworkView) this.lqd.findViewById(R.id.view_no_network);
        cxz();
        bOP();
        this.lqg = (RelativeLayout) this.lqd.findViewById(R.id.sub_pb_body_layout);
        this.fSo = (BdTypeListView) this.lqd.findViewById(R.id.new_sub_pb_list);
        this.lqr = (ThreadSkinView) LayoutInflater.from(this.lqf.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.fSo.addHeaderView(this.lqr);
        this.fSo.addHeaderView(this.lqe);
        this.ieu = new TextView(newSubPbActivity.getActivity());
        this.ieu.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.fSo.addHeaderView(this.ieu, 0);
        this.lqd.setTopView(this.ieu);
        this.lqd.setNavigationView(this.fjm);
        this.lqd.setListView(this.fSo);
        this.lqd.setContentView(this.lqg);
        this.lqs = new d(this.lqf.getPageContext());
        this.lqs.setLineGone();
        this.lqx = this.lqs.getView();
        this.fSo.setNextPage(this.lqs);
        this.lqs.setOnClickListener(this.aXk);
        this.fSo.setOnItemClickListener(this.lqL);
        this.fSo.setOnItemLongClickListener(this.lqK);
        this.fSo.setOnTouchListener(this.eTx);
        this.liQ = new com.baidu.tieba.pb.view.d(newSubPbActivity.getPageContext());
        this.liQ.createView();
        this.liQ.setListPullRefreshListener(this.eHp);
        this.liQ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.lqd.findViewById(R.id.progress);
        this.ljj = this.lqd.findViewById(R.id.view_comment_top_line);
        this.ljl = (LinearLayout) this.lqd.findViewById(R.id.pb_editer_tool_comment_layout);
        this.ljm = (HeadImageView) this.lqd.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.ljm.setVisibility(0);
        this.ljm.setIsRound(true);
        this.ljm.setBorderWidth(l.getDimens(this.lqf, R.dimen.tbds1));
        this.ljm.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.ljm.setPlaceHolder(1);
        this.ljm.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.ljm.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lqe != null) {
            this.lqe.setVisibility(4);
        }
        this.lqk = com.baidu.tbadk.ala.b.bdT().q(this.lqf.getActivity(), 4);
        if (this.lqk != null) {
            this.lqk.setVisibility(8);
            this.lqi.addView(this.lqk, 3);
        }
        this.lqJ = new c(this.lqf, this.fSo);
        this.lqJ.setFromCDN(this.mIsFromCDN);
        this.lqJ.A(this.aXk);
        this.lqJ.Le();
    }

    public ListView getListView() {
        return this.fSo;
    }

    public void bOP() {
        this.lqi = (LinearLayout) this.lqe.findViewById(R.id.subpb_head_user_info_root);
        this.lqi.setOnClickListener(this.aXk);
        this.lqj = (HeadImageView) this.lqe.findViewById(R.id.photo);
        this.lqj.setRadius(l.getDimens(this.lqf.getActivity(), R.dimen.tbds45));
        this.lqj.setClickable(false);
        this.eig = (TextView) this.lqe.findViewById(R.id.user_name);
        this.lql = (ImageView) this.lqe.findViewById(R.id.user_rank);
        this.lql.setVisibility(8);
        this.llR = (TextView) this.lqe.findViewById(R.id.floor_owner);
        this.lqh = (TextView) this.lqe.findViewById(R.id.see_subject);
        this.lqh.setOnClickListener(this.aXk);
        this.lqm = (TextView) this.lqe.findViewById(R.id.floor);
        this.lqn = (TextView) this.lqe.findViewById(R.id.time);
        this.lqo = (EllipsizeRichTextView) this.lqe.findViewById(R.id.content_text);
        this.lqo.setOnClickListener(this.aXk);
        ap.setViewTextColor(this.lqo, R.color.cp_cont_b);
        this.lqo.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.lqo.setLineSpacing(0.0f, 1.25f);
        this.lqp = (TbImageView) this.lqe.findViewById(R.id.sub_pb_image);
        this.lqp.setOnClickListener(this.aXk);
        this.lqq = (TextView) this.lqe.findViewById(R.id.advert);
        this.akv = (PlayVoiceBntNew) this.lqe.findViewById(R.id.voice_btn);
        this.lqe.setOnTouchListener(this.eTx);
        this.lqe.setOnClickListener(this.aXk);
    }

    public void a(b.InterfaceC0550b interfaceC0550b, boolean z) {
        if (this.lqA != null) {
            this.lqA.dismiss();
            this.lqA = null;
        }
        this.lqA = new com.baidu.tbadk.core.dialog.b(this.lqf.getPageContext().getPageActivity());
        if (z) {
            this.lqA.a(new String[]{this.lqf.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0550b);
        } else {
            this.lqA.a(new String[]{this.lqf.getPageContext().getString(R.string.save_to_emotion), this.lqf.getPageContext().getString(R.string.save_to_local)}, interfaceC0550b);
        }
        this.lqA.d(this.lqf.getPageContext());
        this.lqA.bkL();
    }

    public void dk(View view) {
        this.lqt = view;
    }

    public void cxz() {
        int dimens = l.getDimens(this.lqf.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.lqf.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.lqd.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lqy != null) {
                    a.this.lqd.onFinish();
                } else {
                    a.this.lqf.finish();
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

    public void dg(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.lqz == null) {
            this.lqz = new Dialog(this.lqf.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lqz.setCanceledOnTouchOutside(true);
            this.lqz.setCancelable(true);
            this.lqv = LayoutInflater.from(this.lqf.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.lqf.getLayoutMode().onModeChanged(this.lqv);
            this.lqz.setContentView(this.lqv);
            WindowManager.LayoutParams attributes = this.lqz.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.lqf.getPageContext().getPageActivity()) * 0.9d);
            this.lqz.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lqz.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lqz.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lqz.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lqz != null && (a.this.lqz instanceof Dialog)) {
                        g.b(a.this.lqz, a.this.lqf.getPageContext());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lqz != null && (a.this.lqz instanceof Dialog)) {
                        g.b(a.this.lqz, a.this.lqf.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lqB != null) {
                        a.this.lqB.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lqz != null && (a.this.lqz instanceof Dialog)) {
                        g.b(a.this.lqz, a.this.lqf.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.lqf.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lqz, this.lqf.getPageContext());
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
        this.liU = new com.baidu.tbadk.core.dialog.a(this.lqf.getPageContext().getPageActivity());
        this.liU.ob(i3);
        this.liU.setYesButtonTag(sparseArray);
        this.liU.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lqC != null) {
                    a.this.lqC.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.liU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.liU.iz(true);
        this.liU.b(this.lqf.getPageContext());
        if (z) {
            this.liU.bkJ();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData crF;
        if (this.lqf != null && sparseArray != null && this.lqe != null) {
            if (this.iVq == null) {
                this.iVq = new e(this.lqf.getPageContext(), this.lqe);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lpA != null && (crF = this.lpA.crF()) != null && crF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = crF.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray2);
            this.iVq.setDefaultReasonArray(new String[]{this.lqf.getString(R.string.delete_thread_reason_1), this.lqf.getString(R.string.delete_thread_reason_2), this.lqf.getString(R.string.delete_thread_reason_3), this.lqf.getString(R.string.delete_thread_reason_4), this.lqf.getString(R.string.delete_thread_reason_5)});
            this.iVq.setData(arVar);
            this.iVq.En("4");
            this.iVq.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    String R = at.R(jSONArray);
                    if (a.this.lqC != null) {
                        a.this.lqC.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), R});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(final boolean z) {
        if (this.fSo != null) {
            if (!z) {
                this.fSo.setEnabled(z);
            } else {
                this.fSo.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fSo.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lqB = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lqC = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.lqf.showToast(this.lqf.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.lqf.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bvf() != null) {
            this.kdj = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.lqg.addView(hVar.bvf(), layoutParams);
            this.kdj.a(new x.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    a.this.dki();
                }
            });
        }
    }

    public void djN() {
        if (this.fSo != null) {
            this.lqI = this.fSo.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tJ(boolean z) {
        if (this.lpA == null || this.lpA.dkl() == null) {
            return false;
        }
        if (this.lpA.dcP() != 0) {
            return false;
        }
        return (this.loK == null || this.loK.bfG() == null || this.loK.bfG().bih() == null || !TextUtils.equals(this.loK.bfG().bih().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void djO() {
        if (this.lpA != null) {
            if ((!djR() && this.lqx != null && this.lqx.isShown()) || y.isEmpty(this.lqD)) {
                this.lpA.uP(false);
            } else {
                this.lpA.uP(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lpA = subPbModel;
    }

    public void uM(boolean z) {
        if (this.lpA != null && this.lpA.djL() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lqy = new BlankView(this.lqf.getPageContext().getPageActivity());
            this.fjm.addView(this.lqy, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lqy.setVisibility(0);
            this.lqy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lqf.finish();
                }
            });
            this.lqd.setBlankView(this.lqy);
        }
    }

    public void djP() {
        b(this.lqf);
        this.fSo.setNextPage(this.lqs);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.wT(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!djR() && this.lqx != null && this.lqx.isShown()) {
                i = (this.lqI - this.lqH) - 1;
            } else {
                i = this.lqI - this.lqH;
            }
            int count = y.getCount(this.lqD);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(y.subList(this.lqD, 0, i));
            y.add(arrayList, postData2);
            y.add(arrayList, postData);
            this.fSo.smoothScrollToPosition(this.lqI + 2);
            this.fSo.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fSo.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.fSo.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.lqd;
    }

    public void dir() {
        if (this.lqu != null) {
            g.dismissPopupWindow(this.lqu, this.lqf.getPageContext().getPageActivity());
        }
        if (this.lqw != null) {
            this.lqw.dismiss();
        }
        if (this.liU != null) {
            this.liU.dismiss();
        }
        if (this.lqz != null) {
            g.b(this.lqz, this.lqf.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lpD != null) {
            this.lpD.dismiss();
        }
    }

    public void djQ() {
        this.fSo.setNextPage(this.lqs);
        this.lqs.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.eZv = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.eZv && this.lqe != null) {
                this.lqe.setVisibility(8);
                this.fSo.removeHeaderView(this.lqe);
                this.lqH = 1;
            }
            this.loK = pVar;
            if (this.loK.ddq() != null) {
                this.loK.ddq().mFf = true;
            }
            if (this.lqe != null) {
                this.lqe.setVisibility(0);
            }
            if (pVar.bfG() != null && pVar.bfG().bgR()) {
                this.lqh.setText(R.string.view_original);
            } else {
                this.lqh.setText(R.string.view_subject);
            }
            if (pVar.ddq() != null) {
                this.fua = pVar.ddq().dEp();
                if (this.fua > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.lqf.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fua)));
                    if (this.lqf != null) {
                        this.iHp.setText(this.lqf.dhF());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.lqf.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.lqf.djL()) {
                    str = "PB";
                }
                if (pVar.ddq().biD() != null) {
                    this.lqr.setData(this.lqf.getPageContext(), pVar.ddq().biD(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", pVar.bwh().getId(), pVar.bwh().getName(), pVar.bfG().getId(), str));
                } else {
                    this.lqr.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lqs.startLoadData();
                this.lqJ.setHasMoreData(true);
            } else {
                this.lqs.endLoadData();
                this.lqJ.setHasMoreData(false);
            }
            this.lqD = pVar.ddy();
            if (this.lqD == null || this.lqD.size() <= lqc) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lqD.size() - lqc;
                FN(size);
                int firstVisiblePosition = this.fSo.getFirstVisiblePosition() - size;
                View childAt = this.fSo.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lqD);
            if (y.isEmpty(this.lqD)) {
                this.fSo.setNextPage(null);
                if (this.eZv) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.fSo.setNextPage(this.lqs);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.eZv) {
                arrayList.add(0, pVar.ddq());
            }
            this.lqJ.a(this.loK.bfG(), arrayList);
            a(pVar, pVar.ddq(), pVar.SR(), pVar.bec(), i, z);
            if (i4 > 0) {
                this.fSo.setSelectionFromTop(i3, i2);
            } else if (z2 && !at.isEmpty(this.lqf.djM().dfN())) {
                String dfN = this.lqf.djM().dfN();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dfN.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.fSo.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.fSo.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.fSo.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.loK.ddv() > 1) {
                this.fSo.setPullRefresh(this.liQ);
                this.lqd.setEnableDragExit(false);
                return;
            }
            this.fSo.setPullRefresh(null);
            this.lqd.setEnableDragExit(true);
        }
    }

    private void FN(int i) {
        if (this.lqD != null) {
            if (this.lqD.size() <= i) {
                this.lqD.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lqD.iterator();
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

    public boolean djR() {
        return this.lqJ.aCp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eZv) {
            if (!StringUtils.isNull(postData.dEw())) {
                this.lqp.setVisibility(0);
                this.lqp.startLoad(postData.dEw(), 10, true);
            } else {
                this.lqp.setVisibility(8);
            }
            i dEy = postData.dEy();
            if (dEy != null && dEy.mDP) {
                this.lqq.setVisibility(0);
            } else {
                this.lqq.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.lqe.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.lqe.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.lqm.setText((CharSequence) null);
            this.eig.setText((CharSequence) null);
            this.llR.setVisibility(8);
            if (!this.eZv) {
                c(postData.bih());
                if (z) {
                    this.llR.setVisibility(0);
                    ap.setViewTextColor(this.llR, R.color.cp_link_tip_a);
                }
            }
            this.lqn.setText(at.getFormatTime(postData.getTime()));
            String format = String.format(this.lqf.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dEp()));
            if (pVar.bfG() != null && pVar.bfG().bgR()) {
                this.lqm.setText((CharSequence) null);
            } else {
                this.lqm.setText(format);
            }
            postData.bih().getUserTbVipInfoData();
            boolean a2 = a(this.lqo, postData.dEr());
            if (StringUtils.isNull(postData.dEw()) && !a2 && postData.bBy() != null) {
                this.akv.setVisibility(0);
                this.akv.setTag(postData.bBy());
                return;
            }
            this.akv.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + af.getTextLength(name_show) > 14) {
                str = af.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.eig.setText(dM(metaData.getSealPrefix(), str));
            } else {
                this.eig.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.lqk != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.lqk.setVisibility(8);
                } else {
                    this.lqk.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.efM = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.lqk.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ap.setViewTextColor(this.eig, R.color.cp_cont_r);
            } else {
                ap.setViewTextColor(this.eig, R.color.cp_cont_c);
            }
            this.lqj.setVisibility(0);
            this.lqj.setUserId(metaData.getUserId());
            this.lqj.setUserName(metaData.getUserName());
            this.lqj.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.lqj, metaData);
            this.lqj.startLoad(metaData.getAvater(), 28, false);
            this.lqi.setTag(R.id.tag_user_id, metaData.getUserId());
            this.lqi.setTag(R.id.tag_user_name, metaData.getUserName());
            this.lqi.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bBq() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bBq().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.o(next.bBx());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ky(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dMO());
                        continue;
                    case 17:
                        String str = next.bBB().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.o("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.bBG()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bBx() == null || tbRichTextData.bBx().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bBx());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.lqf.getPageContext().getString(R.string.refresh_view_button_text), this.egY));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.lqf.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.lqg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.fSo.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kdj.bwn();
        ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.lqf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void Ck(int i) {
        b(NoDataViewFactory.d.dL(null, this.lqf.getResources().getString(R.string.refresh_view_title_text)));
        this.lqE.setVisibility(8);
    }

    public void Id(String str) {
        b(NoDataViewFactory.d.dL(str, this.lqf.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lqE.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.fSo.setVisibility(0);
            this.lqE.setVisibility(0);
            this.lqd.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.egY = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025a  */
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
                String userId2 = postData.bih().getUserId();
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
            if (this.loK != null && this.loK.bfG() != null && this.loK.bfG().bih() != null && postData.bih() != null) {
                String userId3 = this.loK.bfG().bih().getUserId();
                String userId4 = postData.bih().getUserId();
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
                    userId = postData.bih().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dEp() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.bih() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bih().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bih().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bih().getPortrait());
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.bih() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bih().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bih().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bih().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bih() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bih().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bih().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bih().getName_show());
                        }
                        if (this.loK.bfG() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.loK.bfG().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.bih().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dEp() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void uN(boolean z) {
        if (this.lpD != null && this.lpD.dgN() != null) {
            if (z) {
                this.lpD.dgN().setText(R.string.remove_mark);
            } else {
                this.lpD.dgN().setText(R.string.mark);
            }
        }
    }

    public View djS() {
        return this.lqx;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.lqd, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.lqg, R.color.cp_bg_line_d);
        this.lqf.getLayoutMode().setNightMode(i == 1);
        this.lqf.getLayoutMode().onModeChanged(this.lqd);
        this.lqf.getLayoutMode().onModeChanged(this.lqe);
        this.mNavigationBar.onChangeSkinType(this.lqf.getPageContext(), i);
        if (this.lqh != null) {
            ap.setViewTextColor(this.lqh, R.color.goto_see_subject_color);
        }
        this.fjl.onChangeSkinType(this.lqf.getPageContext(), i);
        this.lqf.getLayoutMode().onModeChanged(this.lqx);
        ap.setViewTextColor(this.lqo, R.color.cp_cont_b);
        this.lqo.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        if (this.kdj != null && this.kdj.bvf() != null) {
            this.kdj.bvf().onChangeSkinType(i);
        }
        this.lqs.changeSkin(i);
        this.akv.changeSkin();
        ap.setViewTextColor(this.iHp, R.color.cp_cont_e);
        ap.setViewTextColor(this.llR, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.eig, R.color.cp_cont_c);
        this.iHp.setAlpha(0.95f);
        if (this.lqt != null) {
            com.baidu.tbadk.r.a.a(this.lqf.getPageContext(), this.lqt);
        }
        if (this.lqJ != null) {
            this.lqJ.notifyDataSetChanged();
        }
        this.lqf.getLayoutMode().onModeChanged(this.lqv);
        ap.setBackgroundResource(this.ljj, R.drawable.bottom_shadow);
        this.ljm.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.ljl.setBackgroundDrawable(ap.aN(l.getDimens(this.lqf, R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
    }

    public void djT() {
        this.mProgress.setVisibility(0);
    }

    public void djU() {
        this.fSo.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lqs.endLoadData();
    }

    public void cpD() {
        this.fSo.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lqs.cpD();
    }

    public boolean djV() {
        return this.lqd.djV();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lqJ.c(onLongClickListener);
    }

    public View djW() {
        return this.lqe;
    }

    public TextView cxE() {
        return this.iHp;
    }

    public ImageView djX() {
        return this.lqF;
    }

    public ImageView djY() {
        return this.lqG;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void FO(int i) {
    }

    public View djZ() {
        return this.lqh;
    }

    public View dka() {
        return this.lqp;
    }

    public MorePopupWindow dkb() {
        return this.lqu;
    }

    public void showLoadingDialog() {
        if (this.hMa == null) {
            this.hMa = new com.baidu.tbadk.core.view.a(this.lqf.getPageContext());
        }
        this.hMa.setDialogVisiable(true);
    }

    public void cbz() {
        if (this.hMa != null) {
            this.hMa.setDialogVisiable(false);
        }
    }

    public TextView dkc() {
        return this.lqo;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lqJ.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lqJ != null) {
            this.lqJ.notifyDataSetChanged();
        }
    }

    public ah dkd() {
        return this.lpD;
    }

    public void czS() {
    }

    public void czT() {
    }

    public void cyd() {
        this.lqd.onDestroy();
    }

    public void dke() {
        if (this.lqf.isPaused()) {
        }
    }

    public View dkf() {
        return this.lqi;
    }

    private SpannableStringBuilder dM(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.lqf.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dkg() {
        if (this.kdj == null || this.kdj.bvf() == null) {
            return 0;
        }
        return this.kdj.bvf().getHeight();
    }

    public int dkh() {
        if (this.lqy == null) {
            return 0;
        }
        return this.lqy.getHeight();
    }

    public void dki() {
        if (this.iHp != null && this.kdj != null) {
            if (this.kdj.bws()) {
                this.iHp.setText(R.string.draft_to_send);
            } else {
                this.iHp.setText(this.lqf.dhF());
            }
        }
    }

    public void tY(boolean z) {
        if (this.ljm != null) {
            this.ljm.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eHp = cVar;
        if (this.liQ != null) {
            this.liQ.setListPullRefreshListener(cVar);
        }
    }
}
