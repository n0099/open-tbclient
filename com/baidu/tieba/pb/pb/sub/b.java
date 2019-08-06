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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.pb.pb.main.ap;
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
    private static final int iaU = TbadkCoreApplication.getInst().getListItemRule().amy();
    private RelativeLayout dMk;
    private com.baidu.tbadk.core.view.b eMz;
    private TextView fJS;
    private com.baidu.tieba.NEGFeedBack.e fWb;
    private View fgA;
    private NoNetworkView fql;
    private k hZz;
    private y iaB;
    private a iaM;
    private View iaV;
    private NewSubPbActivity iaW;
    private RelativeLayout iaX;
    private SubPbModel iay;
    private d ibC;
    private View ibb;
    private ThreadSkinView ibi;
    private e ibj;
    private View ibk;
    private View ibo;
    private com.baidu.tbadk.core.dialog.b ibq;
    private ArrayList<PostData> ibu;
    private String ibv;
    private RelativeLayout ibw;
    private ImageView ibx;
    private ImageView iby;
    private View.OnClickListener mCommonClickListener;
    private BdTypeListView mListView;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener bCn = null;
    private TbRichTextView.i iaD = null;
    private NavigationBar mNavigationBar = null;
    private View cfi = null;
    private TextView iaY = null;
    private LinearLayout iaZ = null;
    private HeadImageView iba = null;
    private ClickableHeaderImageView hUT = null;
    private TextView cdg = null;
    private ImageView ibc = null;
    private TextView hUL = null;
    private TextView ibd = null;
    private TextView ibe = null;
    private EllipsizeRichTextView ibf = null;
    private TbImageView ibg = null;
    private PlayVoiceBntNew Ym = null;
    private TextView ibh = null;
    private MorePopupWindow ibl = null;
    private am ibm = null;
    private com.baidu.tbadk.core.dialog.b ibn = null;
    private Dialog ibp = null;
    private com.baidu.tbadk.core.dialog.a hVt = null;
    private boolean hNN = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener coY = null;
    private NewSubPbActivity.a ibr = null;
    private NewSubPbActivity.a ibs = null;
    private g gWY = null;
    private String ibt = null;
    private int cMi = 0;
    private PostData hJo = null;
    private int ibz = 0;
    private int ibA = 2;
    private int ibB = 0;
    private boolean csy = true;
    private View.OnClickListener hNW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        b.this.iaW.c(sparseArray);
                        return;
                    }
                    b.this.cE(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    b.this.iaW.c(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c clA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.4
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            b.this.kB(false);
            b.this.bW(view);
            b.this.kB(true);
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
    protected AdapterView.OnItemLongClickListener ibD = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.c(b.this.ibu, i);
            if (view == null || view.getTag() == null) {
                return false;
            }
            if (b.this.iaB == null) {
                b.this.iaB = new y(b.this.iaW.getPageContext(), b.this.mCommonClickListener);
            }
            b.this.iaB.showDialog();
            SparseArray<Object> sparseArray = null;
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray == null) {
                return true;
            }
            boolean on = b.this.on(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) & TbadkCoreApplication.isLogin();
            b.this.iaB.a(sparseArray, b.this.iay.bSX(), on);
            if (on) {
                b.this.iaB.bWE().setVisibility(0);
                b.this.iaB.bWE().setTag(postData.getId());
            } else {
                b.this.iaB.bWE().setVisibility(8);
            }
            b.this.iaB.bWC().setVisibility(8);
            return false;
        }
    };
    protected AdapterView.OnItemClickListener ibE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (bd.cF(b.this.iaW.getPageContext().getPageActivity())) {
                if (b.this.iaW.gWQ == null || b.this.iay == null || b.this.iay.bli() == null || b.this.iaW.gWQ.m19if(b.this.iay.bli().replyPrivateFlag)) {
                    if (b.this.iaM != null) {
                        b.this.iaM.bqk();
                    }
                    b.this.bZi();
                    if (view == null || !(view.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.ibu, i);
                        if (postData == null) {
                            b.this.ibv = null;
                        } else {
                            b.this.ibv = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(R.id.tag_photo_username);
                            String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                            if (str != null) {
                                b.this.gWY.setReplyId(str2);
                                b.this.gWY.qx(str);
                            }
                        }
                        b.this.bZj();
                        return;
                    }
                    b.this.bZk();
                    b.this.iay.bZG();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dMk = null;
        this.iaV = null;
        this.mListView = null;
        this.iaW = null;
        this.fql = null;
        this.iaX = null;
        this.ibb = null;
        this.ibj = null;
        this.ibo = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.fJS = null;
        this.ibw = null;
        this.ibx = null;
        this.iby = null;
        this.iaW = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dMk = (RelativeLayout) LayoutInflater.from(this.iaW.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iaV = LayoutInflater.from(this.iaW.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.ibw = (RelativeLayout) this.dMk.findViewById(R.id.subpb_editor_tool_comment);
        this.fJS = (TextView) this.dMk.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fJS.setOnClickListener(this.mCommonClickListener);
        this.ibx = (ImageView) this.dMk.findViewById(R.id.subpb_editor_tool_more_img);
        this.iby = (ImageView) this.dMk.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iby.setOnClickListener(this.mCommonClickListener);
        this.ibx.setOnClickListener(this.mCommonClickListener);
        this.fql = (NoNetworkView) this.dMk.findViewById(R.id.view_no_network);
        bqs();
        bjX();
        this.iaX = (RelativeLayout) this.dMk.findViewById(R.id.sub_pb_body_layout);
        this.mListView = (BdTypeListView) this.dMk.findViewById(R.id.new_sub_pb_list);
        this.ibi = (ThreadSkinView) LayoutInflater.from(this.iaW.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.mListView.addHeaderView(this.ibi);
        this.mListView.addHeaderView(this.iaV);
        this.fgA = BdListViewHelper.a(this.iaW.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.ibj = new e(this.iaW.getPageContext());
        this.ibj.akC();
        this.ibo = this.ibj.getView();
        this.mListView.setNextPage(this.ibj);
        this.ibj.setOnClickListener(this.mCommonClickListener);
        this.mListView.setOnItemClickListener(this.ibE);
        this.mListView.setOnItemLongClickListener(this.ibD);
        this.mListView.setOnTouchListener(this.clA);
        this.mProgress = (ProgressBar) this.dMk.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iaV != null) {
            this.iaV.setVisibility(4);
        }
        if (this.iaX != null) {
            this.iaX.setVisibility(4);
        }
        this.ibb = com.baidu.tbadk.ala.b.aak().n(this.iaW.getActivity(), 4);
        if (this.ibb != null) {
            this.ibb.setVisibility(8);
            this.iaZ.addView(this.ibb, 3);
        }
        this.ibC = new d(this.iaW, this.mListView);
        this.ibC.setFromCDN(this.mIsFromCDN);
        this.ibC.v(this.mCommonClickListener);
        this.ibC.initAdapters();
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void bjX() {
        this.iaZ = (LinearLayout) this.iaV.findViewById(R.id.subpb_head_user_info_root);
        this.iaZ.setOnClickListener(this.mCommonClickListener);
        this.iba = (HeadImageView) this.iaV.findViewById(R.id.photo);
        this.iba.setRadius(l.g(this.iaW.getActivity(), R.dimen.ds30));
        this.iba.setClickable(false);
        this.hUT = (ClickableHeaderImageView) this.iaV.findViewById(R.id.god_user_photo);
        this.hUT.setGodIconMargin(0);
        this.hUT.setGodIconWidth(R.dimen.ds24);
        this.hUT.setRadius(l.g(this.iaW.getActivity(), R.dimen.ds30));
        this.hUT.setClickable(false);
        this.cdg = (TextView) this.iaV.findViewById(R.id.user_name);
        this.ibc = (ImageView) this.iaV.findViewById(R.id.user_rank);
        this.ibc.setVisibility(8);
        this.hUL = (TextView) this.iaV.findViewById(R.id.floor_owner);
        this.iaY = (TextView) this.iaV.findViewById(R.id.see_subject);
        this.iaY.setOnClickListener(this.mCommonClickListener);
        this.ibd = (TextView) this.iaV.findViewById(R.id.floor);
        this.ibe = (TextView) this.iaV.findViewById(R.id.time);
        this.ibf = (EllipsizeRichTextView) this.iaV.findViewById(R.id.content_text);
        this.ibf.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.am.j(this.ibf, R.color.cp_cont_b);
        this.ibf.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        this.ibf.setLineSpacing(0.0f, 1.25f);
        this.ibg = (TbImageView) this.iaV.findViewById(R.id.sub_pb_image);
        this.ibg.setOnClickListener(this.mCommonClickListener);
        this.ibh = (TextView) this.iaV.findViewById(R.id.advert);
        this.Ym = (PlayVoiceBntNew) this.iaV.findViewById(R.id.voice_btn);
        this.iaV.setOnTouchListener(this.clA);
        this.iaV.setOnClickListener(this.mCommonClickListener);
    }

    public void kD(boolean z) {
        if (this.fgA != null && this.fgA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fgA.getLayoutParams();
            if (z) {
                bqw();
                layoutParams.height = l.g(this.iaW.getPageContext().getPageActivity(), R.dimen.ds88);
            } else {
                layoutParams.height = l.g(this.iaW.getPageContext().getPageActivity(), R.dimen.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.fgA.setLayoutParams(layoutParams);
        }
    }

    private void bqw() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public void a(b.a aVar, boolean z) {
        if (this.ibq != null) {
            this.ibq.dismiss();
            this.ibq = null;
        }
        this.ibq = new com.baidu.tbadk.core.dialog.b(this.iaW.getPageContext().getPageActivity());
        if (z) {
            this.ibq.a(new String[]{this.iaW.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.ibq.a(new String[]{this.iaW.getPageContext().getString(R.string.save_to_emotion), this.iaW.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.ibq.d(this.iaW.getPageContext());
        this.ibq.agN();
    }

    public void cJ(View view) {
        this.ibk = view;
    }

    public View bqx() {
        return this.fgA;
    }

    public void bqs() {
        int g = l.g(this.iaW.getPageContext().getPageActivity(), R.dimen.ds88);
        int g2 = l.g(this.iaW.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.dMk.findViewById(R.id.view_navigation_bar);
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cfi.getLayoutParams();
            layoutParams.height = g;
            layoutParams.width = g;
            layoutParams.leftMargin = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cfi != null && (this.cfi.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cfi.getLayoutParams();
            layoutParams2.width = g;
            layoutParams2.height = g;
            this.cfi.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_back, R.drawable.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar aLj() {
        return this.mNavigationBar;
    }

    public void cE(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.ibp == null) {
            this.ibp = new Dialog(this.iaW.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.ibp.setCanceledOnTouchOutside(true);
            this.ibp.setCancelable(true);
            View inflate = LayoutInflater.from(this.iaW.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iaW.getLayoutMode().onModeChanged(inflate);
            this.ibp.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ibp.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.iaW.getPageContext().getPageActivity()) * 0.9d);
            this.ibp.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ibp.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.ibp.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.ibp.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ibp != null && (b.this.ibp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibp, b.this.iaW.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ibp != null && (b.this.ibp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibp, b.this.iaW.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && b.this.ibr != null) {
                        b.this.ibr.m(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ibp != null && (b.this.ibp instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.ibp, b.this.iaW.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        b.this.iaW.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.ibp, this.iaW.getPageContext());
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
        this.hVt = new com.baidu.tbadk.core.dialog.a(this.iaW.getPageContext().getPageActivity());
        this.hVt.hu(i3);
        this.hVt.ab(sparseArray);
        this.hVt.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.ibs != null) {
                    b.this.ibs.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.hVt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.hVt.dQ(true);
        this.hVt.b(this.iaW.getPageContext());
        if (z) {
            this.hVt.agK();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bli;
        if (this.iaW != null && sparseArray != null && this.iaV != null) {
            if (this.fWb == null) {
                this.fWb = new com.baidu.tieba.NEGFeedBack.e(this.iaW.getPageContext(), this.iaV);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.iay != null && (bli = this.iay.bli()) != null && bli.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bli.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray2);
            this.fWb.setDefaultReasonArray(new String[]{this.iaW.getString(R.string.delete_thread_reason_1), this.iaW.getString(R.string.delete_thread_reason_2), this.iaW.getString(R.string.delete_thread_reason_3), this.iaW.getString(R.string.delete_thread_reason_4), this.iaW.getString(R.string.delete_thread_reason_5)});
            this.fWb.setData(ajVar);
            this.fWb.rJ("4");
            this.fWb.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.b.10
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void C(JSONArray jSONArray) {
                    String y = aq.y(jSONArray);
                    if (b.this.ibs != null) {
                        b.this.ibs.m(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), y});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(final boolean z) {
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
        this.ibr = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.ibs = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iaW.showToast(this.iaW.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iaW.showToast(str);
        }
    }

    public void bW(View view) {
        if (this.fgA != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fgA.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fgA);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fgA.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.iaW.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fgA, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.asa() != null) {
            this.gWY = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dMk.addView(gVar.asa(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.iaM = aVar;
    }

    public void bZi() {
        if (this.mListView != null) {
            this.ibB = this.mListView.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean on(boolean z) {
        if (this.iay == null || this.iay.bZD() == null) {
            return false;
        }
        if (this.iay.bSX() != 0) {
            return false;
        }
        return (this.hZz == null || this.hZz.acy() == null || this.hZz.acy().aey() == null || !TextUtils.equals(this.hZz.acy().aey().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void bZj() {
        if (this.iay != null) {
            if ((!bZm() && this.ibo != null && this.ibo.isShown()) || v.aa(this.ibu)) {
                this.iay.ps(false);
            } else {
                this.iay.ps(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.iay = subPbModel;
    }

    public void bZk() {
        b(this.iaW);
        this.mListView.setNextPage(this.ibj);
    }

    public void p(PostData postData) {
        int i;
        if (postData != null) {
            postData.rd(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bZm() && this.ibo != null && this.ibo.isShown()) {
                i = (this.ibB - this.ibA) - 1;
            } else {
                i = this.ibB - this.ibA;
            }
            int Z = v.Z(this.ibu);
            if (i > Z) {
                i = Z;
            }
            ArrayList arrayList = new ArrayList(v.c(this.ibu, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.mListView.smoothScrollToPosition(this.ibB + 2);
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
        return this.dMk;
    }

    public void bXY() {
        if (this.ibl != null) {
            com.baidu.adp.lib.g.g.a(this.ibl, this.iaW.getPageContext().getPageActivity());
        }
        if (this.ibn != null) {
            this.ibn.dismiss();
        }
        if (this.hVt != null) {
            this.hVt.dismiss();
        }
        if (this.ibp != null) {
            com.baidu.adp.lib.g.g.b(this.ibp, this.iaW.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iaB != null) {
            this.iaB.dismiss();
        }
    }

    public void bZl() {
        this.mListView.setNextPage(this.ibj);
        this.ibj.akF();
    }

    public void og(boolean z) {
        this.hNN = z;
    }

    public void setIsFromPb(boolean z) {
        this.csy = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (kVar != null) {
            if (this.csy && this.iaV != null) {
                this.iaV.setVisibility(8);
                this.mListView.removeHeaderView(this.iaV);
                this.ibA = 1;
            }
            this.hZz = kVar;
            if (this.iaV != null) {
                this.iaV.setVisibility(0);
            }
            if (this.iaX != null) {
                this.iaX.setVisibility(0);
            }
            if (kVar.bTu() != null) {
                this.ibt = kVar.bTu().getId();
                this.cMi = kVar.bTu().cpL();
                if (this.cMi > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iaW.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.cMi)));
                    if (this.iaW != null) {
                        this.fJS.setText(this.iaW.bXn());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = this.iaW.bZg() ? "PB" : null;
                if (kVar.bTu().aeT() != null) {
                    this.ibi.setData(this.iaW.getPageContext(), kVar.bTu().aeT(), com.baidu.tieba.tbadkCore.d.a.f("PB", "c0132", kVar.bTA().getId(), kVar.bTA().getName(), kVar.acy().getId(), str));
                } else {
                    this.ibi.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.ibj.akF();
                this.ibC.setHasMoreData(true);
            } else {
                this.ibj.akG();
                this.ibC.setHasMoreData(false);
            }
            this.ibu = kVar.bTy();
            if (this.ibu == null || this.ibu.size() <= iaU) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.ibu.size() - iaU;
                yp(size);
                int firstVisiblePosition = this.mListView.getFirstVisiblePosition() - size;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.ibu);
            if (v.aa(this.ibu)) {
                this.mListView.setNextPage(null);
                if (this.csy) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.mListView.setNextPage(this.ibj);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(kVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.csy) {
                arrayList.add(0, kVar.bTu());
            }
            this.ibC.b(this.hZz.acy(), arrayList);
            a(kVar.bTu(), kVar.bFZ(), kVar.aaB(), i, z);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void yp(int i) {
        if (this.ibu != null) {
            if (this.ibu.size() <= i) {
                this.ibu.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.ibu.iterator();
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

    public boolean bZm() {
        return this.ibC.KB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.csy) {
            this.hJo = postData;
            if (!StringUtils.isNull(postData.cpS())) {
                this.ibg.setVisibility(0);
                this.ibg.startLoad(postData.cpS(), 10, true);
            } else {
                this.ibg.setVisibility(8);
            }
            i cpU = postData.cpU();
            if (cpU != null && cpU.jfL) {
                this.ibh.setVisibility(0);
            } else {
                this.ibh.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iaV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iaV.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.ibd.setText((CharSequence) null);
            this.cdg.setText((CharSequence) null);
            this.hUL.setVisibility(8);
            if (!this.csy) {
                c(postData.aey());
                if (z) {
                    this.hUL.setVisibility(0);
                    com.baidu.tbadk.core.util.am.j(this.hUL, R.color.cp_link_tip_a);
                }
            }
            this.ibe.setText(aq.aD(postData.getTime()));
            this.ibd.setText(String.format(this.iaW.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cpL())));
            postData.aey().getUserTbVipInfoData();
            boolean a = a(this.ibf, postData.cpN());
            if (StringUtils.isNull(postData.cpS()) && !a && postData.ayW() != null) {
                this.Ym.setVisibility(0);
                this.Ym.setTag(postData.ayW());
                return;
            }
            this.Ym.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.bk(metaData.getSealPrefix()) + 2 : 0) + ab.rn(name_show) > 14) {
                name_show = ab.p(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.cdg.setText(bY(metaData.getSealPrefix(), name_show));
            } else {
                this.cdg.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.ibb != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.ibb.setVisibility(8);
                } else {
                    this.ibb.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bAN = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.ibb.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.hUT.setVisibility(0);
                this.iba.setVisibility(8);
                this.hUT.setUserId(metaData.getUserId());
                this.hUT.setUserName(metaData.getUserName());
                this.hUT.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.j(this.cdg, R.color.cp_cont_r);
            } else {
                this.hUT.setVisibility(8);
                this.iba.setVisibility(0);
                this.iba.setUserId(metaData.getUserId());
                this.iba.setUserName(metaData.getUserName());
                this.iba.setDefaultResource(R.drawable.transparent_bg);
                this.iba.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iba.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.am.j(this.cdg, R.color.cp_cont_c);
            }
            this.iaZ.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iaZ.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iaZ.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.ayN() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.ayN().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.k(next.ayV());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.fV(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cyn());
                        continue;
                    case 17:
                        String str = next.ayZ().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.k("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.aze()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.ayV() == null || tbRichTextData.ayV().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.ayV());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iaW.getPageContext().getString(R.string.refresh_view_title_text), this.bCn));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iaW.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iaX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, R.drawable.new_pic_emotion_07, l.g(pageActivity, R.dimen.ds250), l.g(pageActivity, R.dimen.ds480), l.g(pageActivity, R.dimen.ds360)), dVar, a);
        }
        this.iaX.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.gWY.asX();
        com.baidu.tbadk.core.util.am.l(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iaW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void oX(int i) {
        b(NoDataViewFactory.d.ag(i, R.string.refresh_view_title_text));
        if (this.iaM != null) {
            this.iaM.cH(this.dMk);
        }
        this.ibw.setVisibility(8);
    }

    public void vq(String str) {
        b(NoDataViewFactory.d.bX(str, this.iaW.getPageContext().getString(R.string.refresh_view_title_text)));
        if (this.iaM != null) {
            this.iaM.cH(this.dMk);
        }
        this.ibw.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            this.ibw.setVisibility(0);
            this.dMk.setOnTouchListener(null);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0296  */
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
                String userId2 = postData.aey().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.hZz != null && this.hZz.acy() != null && this.hZz.acy().aey() != null && postData.aey() != null) {
                String userId3 = this.hZz.acy().aey().getUserId();
                String userId4 = postData.aey().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aey().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.cpL() == 1) {
                        i2 = 0;
                    }
                    if (ap.m(postData)) {
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
                        if (postData.aey() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aey().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aey().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aey().getPortrait());
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
                        if (postData.aey() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aey().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aey().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aey().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aey() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aey().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aey().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aey().getName_show());
                        }
                        if (this.hZz.acy() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.hZz.acy().getId());
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
            userId = postData.aey().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.cpL() == 1) {
            }
            if (ap.m(postData)) {
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

    public void pq(boolean z) {
        if (this.iaB != null && this.iaB.bWC() != null) {
            if (z) {
                this.iaB.bWC().setText(R.string.remove_mark);
            } else {
                this.iaB.bWC().setText(R.string.mark);
            }
        }
    }

    public View bZn() {
        return this.ibo;
    }

    public void onChangeSkinType(int i) {
        this.iaW.getLayoutMode().setNightMode(i == 1);
        this.iaW.getLayoutMode().onModeChanged(this.dMk);
        this.iaW.getLayoutMode().onModeChanged(this.iaV);
        this.mNavigationBar.onChangeSkinType(this.iaW.getPageContext(), i);
        if (this.iaY != null) {
            com.baidu.tbadk.core.util.am.j(this.iaY, R.color.goto_see_subject_color);
        }
        this.fql.onChangeSkinType(this.iaW.getPageContext(), i);
        this.iaW.getLayoutMode().onModeChanged(this.ibo);
        com.baidu.tbadk.core.util.am.j(this.ibf, R.color.cp_cont_b);
        this.ibf.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        if (this.gWY != null && this.gWY.asa() != null) {
            this.gWY.asa().onChangeSkinType(i);
        }
        this.ibj.iV(i);
        this.Ym.bIz();
        com.baidu.tbadk.core.util.am.j(this.fJS, R.color.cp_cont_e);
        com.baidu.tbadk.core.util.am.j(this.hUL, R.color.cp_link_tip_a);
        com.baidu.tbadk.core.util.am.j(this.cdg, R.color.cp_cont_c);
        this.fJS.setAlpha(0.95f);
        if (this.ibk != null) {
            com.baidu.tbadk.s.a.a(this.iaW.getPageContext(), this.ibk);
        }
        if (this.ibC != null) {
            this.ibC.notifyDataSetChanged();
        }
    }

    public void bZo() {
        this.mProgress.setVisibility(0);
    }

    public void bZp() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ibj.akG();
    }

    public void biz() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ibj.biz();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.coY = onLongClickListener;
        this.ibC.c(onLongClickListener);
    }

    public View bZq() {
        return this.iaV;
    }

    public TextView bqy() {
        return this.fJS;
    }

    public ImageView bZr() {
        return this.ibx;
    }

    public ImageView bZs() {
        return this.iby;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void yq(int i) {
    }

    public View bZt() {
        return this.iaY;
    }

    public View bZu() {
        return this.ibg;
    }

    public MorePopupWindow bZv() {
        return this.ibl;
    }

    public void showLoadingDialog() {
        if (this.eMz == null) {
            this.eMz = new com.baidu.tbadk.core.view.b(this.iaW.getPageContext());
        }
        this.eMz.ej(true);
    }

    public void aUB() {
        if (this.eMz != null) {
            this.eMz.ej(false);
        }
    }

    public TextView bZw() {
        return this.ibf;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.iaD = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.ibC.setOnImageClickListener(hVar);
    }

    public void notifyDataSetChanged() {
        if (this.ibC != null) {
            this.ibC.notifyDataSetChanged();
        }
    }

    public y bZx() {
        return this.iaB;
    }

    public void bsz() {
    }

    public void bsA() {
    }

    public void aFQ() {
    }

    public void bZy() {
        if (this.iaW.isPaused()) {
        }
    }

    public View bZz() {
        return this.iaZ;
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a((Context) this.iaW.getActivity(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int bZA() {
        if (this.gWY == null || this.gWY.asa() == null) {
            return 0;
        }
        return this.gWY.asa().getHeight();
    }
}
