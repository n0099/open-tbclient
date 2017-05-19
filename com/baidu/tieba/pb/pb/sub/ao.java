package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.ec;
import com.baidu.tieba.pb.pb.main.fh;
import com.baidu.tieba.pb.pb.main.fl;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ao {
    private static final int eqX = TbadkCoreApplication.m9getInst().getListItemRule().xO();
    private BdListView Im;
    private View bKL;
    private NoNetworkView bLL;
    private View.OnClickListener coZ;
    private RelativeLayout ebt;
    private ec egy;
    private com.baidu.tbadk.core.view.a eov;
    private com.baidu.tieba.pb.data.l epO;
    private SubPbModel eqD;
    private b eqR;
    private View eqY;
    private ba eqZ;
    private NewSubPbActivity era;
    private RelativeLayout erb;
    private TextView erc;
    private View erg;
    private ThreadSkinView erm;
    private bb ern;
    private View erq;
    private ArrayList<PostData> eru;
    private String erv;
    private TextView erw;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.y mNoDataView = null;
    private TbRichTextView.e eqI = null;
    private View.OnClickListener QS = null;
    private TbRichTextView.f eqH = null;
    private NavigationBar mNavigationBar = null;
    private View aor = null;
    private TextView erd = null;
    private LinearLayout ere = null;
    private HeadImageView erf = null;
    private ClickableHeaderImageView ent = null;
    private TextView amB = null;
    private ImageView erh = null;
    private TextView enj = null;
    private TextView eri = null;
    private TextView eeX = null;
    private EllipsizeRichTextView erj = null;
    private TbImageView erk = null;
    private PlayVoiceBntNew bvC = null;
    private TextView erl = null;
    private MorePopupWindow ero = null;
    private fh erp = null;
    private com.baidu.tbadk.core.dialog.c eoj = null;
    private Dialog enO = null;
    private com.baidu.tbadk.core.dialog.a enQ = null;
    private boolean eez = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cmT = null;
    private NewSubPbActivity.a err = null;
    private NewSubPbActivity.a ers = null;
    private ArrayList<IconData> eeD = null;
    private ArrayList<IconData> cSi = null;
    private com.baidu.tbadk.editortools.pb.n dhG = null;
    private String ert = null;
    private int aMW = 0;
    private PostData edM = null;
    private int erx = 0;
    private int ery = 2;
    private int erz = 0;
    private boolean eqS = true;
    protected HashMap<Long, HashSet<String>> erA = new HashMap<>();
    protected final b.a erB = new ap(this);
    private View.OnClickListener eeE = new at(this);
    private com.baidu.tieba.pb.a.d eeF = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener erC = new av(this);
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ebt = null;
        this.eqY = null;
        this.Im = null;
        this.eqZ = null;
        this.era = null;
        this.bLL = null;
        this.erb = null;
        this.erc = null;
        this.erg = null;
        this.ern = null;
        this.erq = null;
        this.coZ = null;
        this.mProgress = null;
        this.erw = null;
        this.era = newSubPbActivity;
        this.coZ = onClickListener;
        this.ebt = (RelativeLayout) LayoutInflater.from(this.era.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_layout, (ViewGroup) null);
        this.eqY = LayoutInflater.from(this.era.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_head, (ViewGroup) null);
        this.erc = (TextView) this.ebt.findViewById(w.h.no_reply_list_view);
        this.erw = (TextView) this.ebt.findViewById(w.h.subpb_editor_tool_reply_text);
        this.erw.setOnClickListener(this.coZ);
        this.bLL = (NoNetworkView) this.ebt.findViewById(w.h.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.af(this.era.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60);
        aMK();
        aMH();
        this.erb = (RelativeLayout) this.ebt.findViewById(w.h.sub_pb_body_layout);
        this.Im = (BdListView) this.ebt.findViewById(w.h.new_sub_pb_list);
        this.erm = (ThreadSkinView) LayoutInflater.from(this.era.getPageContext().getPageActivity()).inflate(w.j.thread_skin_layout, (ViewGroup) null);
        this.Im.addHeaderView(this.erm);
        this.Im.addHeaderView(this.eqY);
        this.bKL = BdListViewHelper.a(this.era.getActivity(), this.Im, BdListViewHelper.HeadType.DEFAULT);
        this.eqZ = new ba(this.era.getPageContext().getPageActivity());
        this.eqZ.J(this.eeE);
        this.eqZ.setIsFromCDN(this.mIsFromCDN);
        this.eqZ.iO(true);
        this.Im.setAdapter((ListAdapter) this.eqZ);
        this.ern = new bb(this.era.getPageContext());
        this.erq = this.ern.getView();
        this.Im.setNextPage(this.ern);
        this.ern.setOnClickListener(this.coZ);
        this.Im.setOnItemClickListener(this.erC);
        this.Im.setOnTouchListener(this.eeF);
        this.mProgress = (ProgressBar) this.ebt.findViewById(w.h.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.eqY != null) {
            this.eqY.setVisibility(4);
        }
        if (this.erb != null) {
            this.erb.setVisibility(4);
        }
        this.erg = com.baidu.tbadk.ala.c.nH().h(this.era.getActivity(), 4);
        if (this.erg != null) {
            this.erg.setVisibility(8);
            this.ere.addView(this.erg, 3);
        }
    }

    public ListView getListView() {
        return this.Im;
    }

    public void aMH() {
        this.ere = (LinearLayout) this.eqY.findViewById(w.h.subpb_head_user_info_root);
        this.ere.setOnClickListener(this.coZ);
        this.erf = (HeadImageView) this.eqY.findViewById(w.h.photo);
        this.erf.setRadius(com.baidu.adp.lib.util.k.g(this.era.getActivity(), w.f.ds30));
        this.erf.setClickable(false);
        this.ent = (ClickableHeaderImageView) this.eqY.findViewById(w.h.god_user_photo);
        this.ent.setGodIconMargin(0);
        this.ent.setGodIconWidth(w.f.ds24);
        this.ent.setRadius(com.baidu.adp.lib.util.k.g(this.era.getActivity(), w.f.ds30));
        this.amB = (TextView) this.eqY.findViewById(w.h.user_name);
        this.erh = (ImageView) this.eqY.findViewById(w.h.user_rank);
        this.erh.setVisibility(8);
        this.enj = (TextView) this.eqY.findViewById(w.h.floor_owner);
        this.erd = (TextView) this.eqY.findViewById(w.h.see_subject);
        this.erd.setOnClickListener(this.coZ);
        this.eri = (TextView) this.eqY.findViewById(w.h.floor);
        this.eeX = (TextView) this.eqY.findViewById(w.h.time);
        this.erj = (EllipsizeRichTextView) this.eqY.findViewById(w.h.content_text);
        this.erj.setOnClickListener(this.coZ);
        com.baidu.tbadk.core.util.aq.i(this.erj, w.e.cp_cont_b);
        this.erj.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        this.erj.setLineSpacing(0.0f, 1.25f);
        this.erk = (TbImageView) this.eqY.findViewById(w.h.sub_pb_image);
        this.erk.setOnClickListener(this.coZ);
        this.erl = (TextView) this.eqY.findViewById(w.h.advert);
        this.bvC = (PlayVoiceBntNew) this.eqY.findViewById(w.h.voice_btn);
        this.eqY.setOnTouchListener(this.eeF);
        this.eqY.setOnClickListener(this.coZ);
    }

    public void iM(boolean z) {
        if (this.bKL != null && this.bKL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bKL.getLayoutParams();
            if (z) {
                aMI();
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.era.getPageContext().getPageActivity(), w.f.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.era.getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bKL.setLayoutParams(layoutParams);
        }
    }

    private void aMI() {
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_close, w.g.subpb_navigationbar_close);
    }

    public View aMJ() {
        return this.bKL;
    }

    public void aMK() {
        this.mNavigationBar = (NavigationBar) this.ebt.findViewById(w.h.view_navigation_bar);
        this.aor = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aor.getLayoutParams();
            int g = com.baidu.adp.lib.util.k.g(this.era.getPageContext().getPageActivity(), w.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aor != null && (this.aor.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aor.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aor.setPadding(com.baidu.adp.lib.util.k.g(this.era.getPageContext().getPageActivity(), w.f.ds32), this.aor.getPaddingTop(), this.aor.getPaddingRight(), this.aor.getPaddingBottom());
            this.aor.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_back, w.g.subpb_navigationbar_back);
    }

    public NavigationBar JH() {
        return this.mNavigationBar;
    }

    public void aW(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.enO == null) {
            this.enO = new Dialog(this.era.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.enO.setCanceledOnTouchOutside(true);
            this.enO.setCancelable(true);
            View inflate = LayoutInflater.from(this.era.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
            this.era.getLayoutMode().t(inflate);
            this.enO.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.enO.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.era.getPageContext().getPageActivity()) * 0.9d);
            this.enO.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.enO.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.enO.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.enO.findViewById(w.h.disable_reply_btn);
        if ("".equals(sparseArray.get(w.h.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(w.h.tag_del_post_id, sparseArray.get(w.h.tag_del_post_id));
            sparseArray2.put(w.h.tag_del_post_type, sparseArray.get(w.h.tag_del_post_type));
            sparseArray2.put(w.h.tag_del_post_is_self, sparseArray.get(w.h.tag_del_post_is_self));
            sparseArray2.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            textView.setOnClickListener(new ax(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(w.h.tag_forbid_user_name, sparseArray.get(w.h.tag_forbid_user_name));
            sparseArray3.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            sparseArray3.put(w.h.tag_forbid_user_post_id, sparseArray.get(w.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ay(this));
        }
        if (!((sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(w.l.un_mute);
            } else {
                textView3.setText(w.l.mute);
            }
            sparseArray4.put(w.h.tag_is_mem, sparseArray.get(w.h.tag_is_mem));
            sparseArray4.put(w.h.tag_user_mute_mute_userid, sparseArray.get(w.h.tag_user_mute_mute_userid));
            sparseArray4.put(w.h.tag_user_mute_mute_username, sparseArray.get(w.h.tag_user_mute_mute_username));
            sparseArray4.put(w.h.tag_user_mute_post_id, sparseArray.get(w.h.tag_user_mute_post_id));
            sparseArray4.put(w.h.tag_user_mute_thread_id, sparseArray.get(w.h.tag_user_mute_thread_id));
            textView3.setOnClickListener(new az(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.enO, this.era.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.enQ = new com.baidu.tbadk.core.dialog.a(this.era.getPageContext().getPageActivity());
        this.enQ.bX(i3);
        this.enQ.A(sparseArray);
        this.enQ.a(w.l.dialog_ok, new aq(this, sparseArray));
        this.enQ.b(w.l.dialog_cancel, new ar(this));
        this.enQ.as(true);
        this.enQ.b(this.era.getPageContext());
        this.enQ.td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ix(boolean z) {
        if (this.Im != null) {
            if (!z) {
                this.Im.setEnabled(z);
            } else {
                this.Im.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.eoj != null) {
            this.eoj.dismiss();
            this.eoj = null;
        }
        if (z) {
            string = this.era.getResources().getString(w.l.remove_mark);
        } else {
            string = this.era.getResources().getString(w.l.mark);
        }
        this.eoj = new com.baidu.tbadk.core.dialog.c(this.era.getPageContext().getPageActivity());
        this.eoj.ca(w.l.operation);
        this.eoj.a(new String[]{this.era.getResources().getString(w.l.copy), string}, bVar);
        this.eoj.d(this.era.getPageContext());
        this.eoj.tg();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.err = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.ers = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.era.showToast(this.era.getResources().getString(w.l.delete_success));
        } else if (str != null && z2) {
            this.era.showToast(str);
        }
    }

    public void aV(View view) {
        if (this.bKL != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bKL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Im != null) {
                    this.Im.removeHeaderView(this.bKL);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bKL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.era.getActivity(), w.f.ds98)));
            } else if (this.Im != null) {
                this.Im.addHeaderView(this.bKL, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.n nVar) {
        if (nVar != null && nVar.Cs() != null) {
            this.dhG = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ebt.addView(nVar.Cs(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eqR = bVar;
    }

    public void aML() {
        if (this.Im != null) {
            this.erz = this.Im.getLastVisiblePosition();
        }
    }

    public void aMM() {
        if (this.eqD != null) {
            if ((!aMP() && this.erq != null && this.erq.isShown()) || com.baidu.tbadk.core.util.x.r(this.eru)) {
                this.eqD.iQ(false);
            } else {
                this.eqD.iQ(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eqD = subPbModel;
    }

    public void aMN() {
        a(this.era);
        this.Im.setNextPage(this.ern);
    }

    public void l(PostData postData) {
        int i;
        if (postData != null) {
            postData.kX(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aMP() && this.erq != null && this.erq.isShown()) {
                i = (this.erz - this.ery) - 1;
            } else {
                i = this.erz - this.ery;
            }
            int q = com.baidu.tbadk.core.util.x.q(this.eru);
            if (i > q) {
                i = q;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.x.a(this.eru, 0, i));
            com.baidu.tbadk.core.util.x.b(arrayList, postData2);
            com.baidu.tbadk.core.util.x.b(arrayList, postData);
            this.eqZ.setDatas(arrayList);
            this.eqZ.notifyDataSetChanged();
            this.Im.smoothScrollToPosition(this.erz + 2);
            this.Im.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Im.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Im.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ebt;
    }

    public void auE() {
        if (this.ero != null) {
            com.baidu.adp.lib.g.j.a(this.ero, this.era.getPageContext().getPageActivity());
        }
        if (this.eoj != null) {
            this.eoj.dismiss();
        }
        if (this.enQ != null) {
            this.enQ.dismiss();
        }
        if (this.enO != null) {
            com.baidu.adp.lib.g.j.b(this.enO, this.era.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.egy != null) {
            this.egy.dismiss();
        }
    }

    public void aMO() {
        this.Im.setNextPage(this.ern);
        this.ern.wo();
    }

    public void hL(boolean z) {
        this.eez = z;
    }

    public void setIsFromPb(boolean z) {
        this.eqS = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.l lVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (lVar != null) {
            if (this.eqS && this.eqY != null) {
                this.eqZ.iP(true);
                this.eqY.setVisibility(8);
                this.Im.removeHeaderView(this.eqY);
                this.ery = 1;
            }
            this.epO = lVar;
            this.eqZ.m(this.epO.JB());
            if (this.eqY != null) {
                this.eqY.setVisibility(0);
            }
            if (this.erb != null) {
                this.erb.setVisibility(0);
            }
            if (lVar.aIr() != null) {
                this.ert = lVar.aIr().getId();
                this.aMW = lVar.aIr().bgM();
                if (this.aMW > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.era.getResources().getString(w.l.subpb_floor_reply_count), com.baidu.tbadk.core.util.au.x(lVar.getTotalCount())));
                    this.erw.setText(w.l.add_floor_reply_tip);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.era.aMG()) {
                    str = "PB";
                }
                if (lVar.aIr().rT() != null) {
                    this.erm.a(this.era.getPageContext(), lVar.aIr().rT(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", lVar.aIx().getId(), lVar.aIx().getName(), lVar.JB().getId(), str));
                } else {
                    this.erm.a(null, null, null);
                }
            }
            if (lVar.hasMore()) {
                this.ern.wo();
                this.eqZ.setHasMoreData(true);
            } else {
                this.ern.wp();
                this.eqZ.setHasMoreData(false);
            }
            this.eru = lVar.aIv();
            if (com.baidu.tbadk.core.util.x.r(this.eru)) {
                this.Im.setNextPage(null);
                if (this.eqS) {
                    this.erc.setVisibility(0);
                }
            } else {
                this.Im.setNextPage(this.ern);
                if (this.eqS) {
                    this.erc.setVisibility(8);
                }
            }
            if (this.eru == null || this.eru.size() <= eqX) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eru.size() - eqX;
                ot(size);
                int firstVisiblePosition = this.Im.getFirstVisiblePosition() - size;
                View childAt = this.Im.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eqZ.setDatas(this.eru);
            boolean z2 = false;
            if (lVar.JB() != null && lVar.JB().getAuthor() != null && (userId = lVar.JB().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eqZ.A(i, z2);
            this.eqZ.notifyDataSetChanged();
            a(lVar.aIr(), lVar.aqM(), lVar.nL(), i, z);
            if (i4 > 0) {
                this.Im.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void ot(int i) {
        if (this.eru != null) {
            if (this.eru.size() <= i) {
                this.eru.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eru.iterator();
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

    public boolean aMP() {
        return this.eqZ.bDh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eqS) {
            this.edM = postData;
            if (!StringUtils.isNull(postData.bgS())) {
                this.erk.setVisibility(0);
                this.erk.c(postData.bgS(), 10, true);
            } else {
                this.erk.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bgU = postData.bgU();
            if (bgU != null && bgU.ftS) {
                this.erl.setVisibility(0);
            } else {
                this.erl.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eqY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eqY.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eri.setText((CharSequence) null);
            this.amB.setText((CharSequence) null);
            this.enj.setVisibility(8);
            if (!this.eqS) {
                a(postData.getAuthor());
                if (z) {
                    this.enj.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.i(this.enj, w.e.cp_link_tip_a);
                }
            }
            this.eeX.setText(com.baidu.tbadk.core.util.au.q(postData.getTime()));
            if (this.eez) {
                int i2 = w.g.img_default_100;
            } else {
                int i3 = w.g.icon_click;
            }
            this.eri.setText(String.format(this.era.getPageContext().getString(w.l.is_floor), Integer.valueOf(postData.bgM())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.erj, postData.aui());
            if (StringUtils.isNull(postData.bgS()) && !a && postData.HK() != null) {
                this.bvC.setVisibility(0);
                this.bvC.setTag(postData.HK());
                return;
            }
            this.bvC.setVisibility(8);
        }
    }

    private void a(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int go = com.baidu.tbadk.util.x.go(name_show);
            com.baidu.tbadk.core.util.aq.i(this.amB, w.e.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aF(metaData.getSealPrefix()) + 2 : 0) + go > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.x.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.amB.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.amB.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.erg != null) {
                if (metaData.getAlaUserData().anchor_live == 0 && metaData.getAlaUserData().enter_live == 0) {
                    this.erg.setVisibility(8);
                } else {
                    this.erg.setVisibility(0);
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.Qj = metaData.getAlaUserData();
                    bVar.type = 4;
                    this.erg.setTag(bVar);
                }
            }
            if (metaData.isGod()) {
                this.ent.setVisibility(0);
                this.erf.setVisibility(8);
                this.ent.setUserId(metaData.getUserId());
                this.ent.setUserName(metaData.getUserName());
                this.ent.c(metaData.getPortrait(), 28, false);
            } else {
                this.ent.setVisibility(8);
                this.erf.setVisibility(0);
                this.erf.setUserId(metaData.getUserId());
                this.erf.setUserName(metaData.getUserName());
                this.erf.setDefaultResource(w.g.transparent_bg);
                this.erf.setDefaultErrorResource(w.g.icon_default_avatar100);
                this.erf.c(metaData.getPortrait(), 28, false);
            }
            this.ere.setTag(w.h.tag_user_id, metaData.getUserId());
            this.ere.setTag(w.h.tag_user_name, metaData.getUserName());
            this.ere.setTag(w.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.HC() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.HC().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.HJ());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cf(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.bkT());
                        continue;
                    case 17:
                        String str = next.HN().mGifInfo.mSharpText;
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
        if (!tbRichTextData.HS()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.HJ() == null || tbRichTextData.HJ().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.HJ());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.era.getPageContext().getString(w.l.refresh_view_title_text), this.QS));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.era.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.erb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, w.g.pic_emotion07, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds300), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds480), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds360)), dVar, a);
        }
        this.erb.setVisibility(0);
        this.Im.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dhG.Dq();
        com.baidu.tbadk.core.util.aq.k(this.mNoDataView, w.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.era.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fS(int i) {
        a(NoDataViewFactory.d.C(i, w.l.refresh_view_title_text));
        if (this.eqR != null) {
            this.eqR.aX(this.ebt);
        }
        this.erw.setVisibility(8);
    }

    public void nT(String str) {
        a(NoDataViewFactory.d.ae(str, this.era.getPageContext().getString(w.l.refresh_view_title_text)));
        if (this.eqR != null) {
            this.eqR.aX(this.ebt);
        }
        this.erw.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Im.setVisibility(0);
            this.erw.setVisibility(0);
            this.ebt.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.QS = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ff  */
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
                String userId2 = postData.getAuthor().getUserId();
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
            if (this.epO != null && this.epO.JB() != null && this.epO.JB().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.epO.JB().getAuthor().getUserId();
                String userId4 = postData.getAuthor().getUserId();
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
                    userId = postData.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bgM() != 1 ? 0 : 1;
                    if (fl.h(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(w.h.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_del_post_is_self, true);
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(w.h.tag_del_post_is_self, false);
                        sparseArray.put(w.h.tag_del_post_type, 0);
                        sparseArray.put(w.h.tag_del_post_id, "");
                    }
                    sparseArray.put(w.h.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(w.h.tag_should_manage_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(w.h.tag_user_mute_visible, true);
                        sparseArray.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.epO.JB() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.epO.JB().getId());
                        }
                        sparseArray.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(w.h.tag_should_delete_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(w.h.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bgM() != 1) {
            }
            if (fl.h(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(w.h.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void iN(boolean z) {
        if (this.egy != null && this.egy.aKy() != null) {
            if (z) {
                this.egy.aKy().setText(w.l.remove_mark);
            } else {
                this.egy.aKy().setText(w.l.mark);
            }
            this.egy.refreshUI();
        }
    }

    public View aMQ() {
        return this.erq;
    }

    public void onChangeSkinType(int i) {
        this.era.getLayoutMode().ai(i == 1);
        this.era.getLayoutMode().t(this.ebt);
        this.era.getLayoutMode().t(this.eqY);
        this.mNavigationBar.onChangeSkinType(this.era.getPageContext(), i);
        if (this.erd != null) {
            com.baidu.tbadk.core.util.aq.i(this.erd, w.e.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.aq.i(this.erc, w.e.cp_cont_d);
        this.bLL.onChangeSkinType(this.era.getPageContext(), i);
        this.era.getLayoutMode().t(this.erq);
        com.baidu.tbadk.core.util.aq.i(this.erj, w.e.cp_cont_b);
        this.erj.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        if (this.dhG != null && this.dhG.Cs() != null) {
            this.dhG.Cs().onChangeSkinType(i);
        }
        this.ern.di(i);
        this.bvC.aYC();
        com.baidu.tbadk.core.util.aq.i(this.erw, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.erw, w.g.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.aq.i(this.enj, w.e.cp_link_tip_a);
        com.baidu.tbadk.core.util.aq.i(this.amB, w.e.cp_cont_c);
        this.erw.setAlpha(0.95f);
        if (this.eqZ != null) {
            this.eqZ.notifyDataSetChanged();
        }
    }

    public void aMR() {
        this.mProgress.setVisibility(0);
    }

    public void aMS() {
        this.Im.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ern.wp();
    }

    public void XY() {
        this.Im.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.ern.XY();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmT = onLongClickListener;
        this.eqY.setOnLongClickListener(this.cmT);
    }

    public View aMT() {
        return this.eqY;
    }

    public TextView aMU() {
        return this.erw;
    }

    public void nU(String str) {
        int nV = this.eqZ.nV(str);
        if (nV > -1) {
            this.eqZ.ou(nV);
            if (nV > 2) {
                this.Im.setSelection(nV - 2);
            } else {
                this.Im.setSelection(nV);
            }
            this.Im.invalidate();
        }
    }

    public View aMV() {
        return this.erd;
    }

    public View aMW() {
        return this.erk;
    }

    public MorePopupWindow aMX() {
        return this.ero;
    }

    public void asr() {
        if (this.eov == null) {
            this.eov = new com.baidu.tbadk.core.view.a(this.era.getPageContext());
        }
        this.eov.aI(true);
    }

    public void aGA() {
        if (this.eov != null) {
            this.eov.aI(false);
        }
    }

    public TextView aMY() {
        return this.erj;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eqH = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eqI = eVar;
    }

    public ec aMZ() {
        return this.egy;
    }

    public void aaR() {
    }

    public void aaS() {
    }

    public void onActivityDestroy() {
    }

    public void aNa() {
        if (this.era.aMF()) {
        }
    }

    public View aNb() {
        return this.ere;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.ap.a((Context) this.era.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
