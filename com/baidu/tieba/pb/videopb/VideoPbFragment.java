package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.arch.lifecycle.q;
import android.arch.lifecycle.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.media.ExifInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.s;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes9.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout CD;
    private EditorTools FO;
    private ImageView Lb;
    private CustomViewPager cYo;
    public View dGn;
    private com.baidu.adp.lib.d.b<ImageView> dMQ;
    private com.baidu.adp.lib.d.b<GifView> dMR;
    private com.baidu.adp.lib.d.b<TextView> dPF;
    private com.baidu.adp.lib.d.b<View> dPG;
    private com.baidu.adp.lib.d.b<LinearLayout> dPH;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPI;
    private ImageView eFf;
    private VoiceManager gpi;
    private com.baidu.tieba.frs.profession.permission.c gsJ;
    private com.baidu.tieba.f.b gtf;
    public aj hRk;
    private com.baidu.tieba.pb.videopb.c.a iEa;
    private PbFakeFloorModel iIL;
    private PbActivity iIO;
    private g iJC;
    private com.baidu.tbadk.editortools.pb.e iJD;
    private com.baidu.tieba.frs.profession.permission.c iJF;
    private EmotionImageData iJG;
    private com.baidu.tbadk.core.view.d iJK;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iJf;
    int iJi;
    public ap iJu;
    private View iPS;
    private s iQP;
    private View iQj;
    private ImageView iQl;
    private ImageView iQm;
    private ImageView iQn;
    private com.baidu.tieba.pb.view.c iQo;
    private TextView iQp;
    private int iQr;
    private int iQs;
    private String iRg;
    public View iVB;
    private ObjectAnimator jaC;
    private ObjectAnimator jaD;
    private NewPagerSlidingTabBaseStrip jab;
    private VideoPbFragmentAdapter jac;
    private View jad;
    private View jae;
    private VideoContainerLayout jaf;
    private com.baidu.tieba.pb.videopb.videoView.a jag;
    private f jah;
    private View jai;
    private View jaj;
    private TextView jal;
    private TextView jam;
    private ImageView jan;
    private TBSpecificationBtn jao;
    private TbImageView jap;
    private ValueAnimator jaq;
    private ValueAnimator jar;
    public com.baidu.tieba.pb.videopb.b.a jas;
    private float jaw;
    private float jax;
    private boolean jay;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int iZY = 0;
    public static int iZZ = 1;
    public static int iQH = 3;
    public static int iQI = 0;
    public static int iQJ = 3;
    public static int iQK = 4;
    public static int iQL = 5;
    public static int iQM = 6;
    private static final int hgT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int jaa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a iKz = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bl(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.clL();
            } else {
                com.baidu.tieba.pb.a.b.clK();
            }
        }
    };
    private long iIV = 0;
    View.OnClickListener jak = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.iEa != null) {
                TiebaStatic.log(new an("c13590").cx("obj_id", VideoPbFragment.this.iEa.getTitle()).cx("obj_name", VideoPbFragment.this.iEa.cuf()).X("obj_type", 2).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("tid", VideoPbFragment.this.clX().getPbData().getThreadId()));
                String link = VideoPbFragment.this.iEa.getLink();
                if (!TextUtils.isEmpty(link)) {
                    if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                        ba.aGK().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                        return;
                    }
                    Uri parse = Uri.parse(link);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                    }
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a iJo = null;
    private com.baidu.tbadk.coreExtra.model.a dap = null;
    private ForumManageModel fLt = null;
    private boolean iIZ = false;
    private View iQk = null;
    private TextView hiz = null;
    private boolean iQg = false;
    private String dyQ = null;
    private boolean iJr = false;
    private boolean iJs = false;
    private boolean iJt = false;
    private boolean iJb = false;
    int[] iJh = new int[2];
    private int iJj = -1;
    private int iJk = Integer.MIN_VALUE;
    private int iJQ = 0;
    private int jau = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private final PbModel.a iKp = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mo;
            VideoPbFragment.this.cqd();
            VideoPbFragment.this.bWK();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.qx(false);
            if (z && eVar != null) {
                bj ckP = eVar.ckP();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.G(eVar);
                com.baidu.tieba.pb.videopb.c.a clp = eVar.clp();
                if (clp != null) {
                    VideoPbFragment.this.a(clp);
                }
                VideoPbFragment.this.H(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.iJo != null) {
                    VideoPbFragment.this.iJo.fn(eVar.ayO());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.dyQ = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.dyQ) && VideoPbFragment.this.iJD != null && VideoPbFragment.this.iJD.aOy() != null && (mo = VideoPbFragment.this.iJD.aOy().mo(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.dyQ)) {
                        ((View) mo).setOnClickListener(VideoPbFragment.this.dzB);
                    }
                }
                if (VideoPbFragment.this.hRk != null && ckP != null && ckP.aCr() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(ckP.aCr());
                    VideoPbFragment.this.hRk.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.clX().cnU());
                        jSONObject.put("fid", VideoPbFragment.this.clX().getForumId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                }
                if (i != 0) {
                    k kVar = new k();
                    kVar.setOpType("2");
                    kVar.start();
                }
                if (VideoPbFragment.this.ctp() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                            arrayList = VideoPbFragment.this.clX().getPbData().ckR();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cLv() == 1)) {
                            if (VideoPbFragment.this.ctp().cny()) {
                                VideoPbFragment.this.ctp().Ge(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.ctp().Ge(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.ctp().Gd(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.ctp().Gd("");
                    }
                    VideoPbFragment.this.ctp().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.cKv().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0374a iKr = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cqd();
            if (z && VideoPbFragment.this.clX() != null) {
                if (VideoPbFragment.this.iJo != null) {
                    VideoPbFragment.this.iJo.fn(z2);
                }
                VideoPbFragment.this.clX().qd(z2);
                if (VideoPbFragment.this.clX().ayO()) {
                    VideoPbFragment.this.cnj();
                } else if (VideoPbFragment.this.ctp() != null) {
                    VideoPbFragment.this.ctp().cua();
                }
                if (z2) {
                    if (VideoPbFragment.this.iJo != null) {
                        if (VideoPbFragment.this.iJo.ayR() != null && VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.clX().getPbData().ckP() != null && VideoPbFragment.this.clX().getPbData().ckP().aCr() != null) {
                            MarkData ayR = VideoPbFragment.this.iJo.ayR();
                            MetaData aCr = VideoPbFragment.this.clX().getPbData().ckP().aCr();
                            if (ayR != null && aCr != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aCr.getUserId()) && !aCr.hadConcerned()) {
                                    VideoPbFragment.this.jas.b(aCr);
                                } else {
                                    VideoPbFragment.this.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    VideoPbFragment.this.cng();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyU = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOV() {
            if (VideoPbFragment.this.iJu == null || VideoPbFragment.this.iJu.cqT() == null || !VideoPbFragment.this.iJu.cqT().cUz()) {
                return !VideoPbFragment.this.yV(aj.dak);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iJu.cqT().cUB());
            if (VideoPbFragment.this.iJD != null && (VideoPbFragment.this.iJD.aPl() || VideoPbFragment.this.iJD.aPm())) {
                VideoPbFragment.this.iJD.a(false, VideoPbFragment.this.iJu.cqW());
            }
            VideoPbFragment.this.iJu.qC(true);
            return true;
        }
    };
    private final CustomMessageListener iJX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.clX() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.iJD != null) {
                    VideoPbFragment.this.qv(VideoPbFragment.this.iJD.aPe());
                }
                VideoPbFragment.this.cpG();
                VideoPbFragment.this.jas.cqu();
            }
        }
    };
    private CustomMessageListener iKa = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((com.baidu.tieba.pb.data.l) eVar.getData());
                        return;
                    case 1:
                        VideoPbFragment.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            VideoPbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            VideoPbFragment.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private final CustomMessageListener gqu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.cnA();
            }
        }
    };
    private CustomMessageListener iKq = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cna();
            }
        }
    };
    private CustomMessageListener iKl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.jas != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jas.iJL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.jas.bqx();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.jas.getExtra();
                DataRes dataRes = aVar.kww;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (aq.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    VideoPbFragment.this.jas.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.jas.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener iKj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.jas != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jas.iJL) {
                VideoPbFragment.this.jas.bqx();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clX().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.clc().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iJK.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.jas.vr(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.jas.cnx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.iJK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iKk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.jas != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jas.iJL) {
                VideoPbFragment.this.jas.bqx();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iJK.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.iJK.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b iJI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOV() {
            if (VideoPbFragment.this.iJu == null || VideoPbFragment.this.iJu.cqU() == null || !VideoPbFragment.this.iJu.cqU().cUz()) {
                return !VideoPbFragment.this.yV(aj.dal);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iJu.cqU().cUB());
            if (VideoPbFragment.this.iQP != null && VideoPbFragment.this.iQP.cmJ() != null && VideoPbFragment.this.iQP.cmJ().aPm()) {
                VideoPbFragment.this.iQP.cmJ().a(VideoPbFragment.this.iJu.cqW());
            }
            VideoPbFragment.this.iJu.qD(true);
            return true;
        }
    };
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                    anVar.cx("fid", VideoPbFragment.this.clX().getPbData().getForumId());
                }
                anVar.cx("tid", VideoPbFragment.this.clX().cnU());
                anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bEu();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.clX() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.clX().FY(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.ctp() != null) {
                        VideoPbFragment.this.iJQ = VideoPbFragment.this.ctp().cqf();
                        VideoPbFragment.this.jau = VideoPbFragment.this.ctp().cud();
                        VideoPbFragment.this.clX().cs(VideoPbFragment.this.iJQ, VideoPbFragment.this.jau);
                    }
                }
                if (VideoPbFragment.this.cYo != null) {
                    VideoPbFragment.this.cYo.setCurrentItem(VideoPbFragment.iZZ);
                }
                VideoPbFragment.this.jas.cqu();
                VideoPbFragment.this.iJu.cqS();
                if (VideoPbFragment.this.iJD != null) {
                    VideoPbFragment.this.qv(VideoPbFragment.this.iJD.aPe());
                }
                VideoPbFragment.this.cpC();
                VideoPbFragment.this.qx(true);
                VideoPbFragment.this.clX().coo();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.ctp() != null) {
                            VideoPbFragment.this.ctp().cua();
                        }
                    } else if (VideoPbFragment.this.clX().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.clX().getPbData();
                        if (pbData != null && pbData.ckP() != null && pbData.ckP().aCr() != null && (userId = pbData.ckP().aCr().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.clX().cof()) {
                            VideoPbFragment.this.cqb();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.clX().cof()) {
                        VideoPbFragment.this.cqb();
                    }
                    VideoPbFragment.this.cmZ();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.iJD.aPl() || VideoPbFragment.this.iJD.aPm()) {
                    VideoPbFragment.this.iJD.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.iJu.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.hRk != null) {
                    VideoPbFragment.this.hRk.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener dzB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.dyQ);
        }
    };
    private CustomMessageListener iJZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.iJD != null) {
                    VideoPbFragment.this.qv(VideoPbFragment.this.iJD.aPe());
                }
                VideoPbFragment.this.qx(false);
            }
        }
    };
    private int jav = 0;
    private boolean jaz = true;
    private View.OnTouchListener jaA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.jav == 1) {
                if (!VideoPbFragment.this.jaz) {
                    VideoPbFragment.this.ctt();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cnE(), VideoPbFragment.this.cnE().getRootView());
                    VideoPbFragment.this.jaz = true;
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(VideoPbFragment.this.jaB);
                    com.baidu.adp.lib.f.e.gx().postDelayed(VideoPbFragment.this.jaB, 3000L);
                }
            } else if (VideoPbFragment.this.jav == 2 && (VideoPbFragment.this.jaz || VideoPbFragment.this.ctv())) {
                VideoPbFragment.this.ctu();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cnE(), VideoPbFragment.this.cnE().getRootView());
                VideoPbFragment.this.jaz = false;
                if (VideoPbFragment.this.jag != null) {
                    VideoPbFragment.this.jag.qY(false);
                }
            }
            VideoPbFragment.this.jav = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener gzo = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.jav = 0;
            VideoPbFragment.this.jaw = 0.0f;
            VideoPbFragment.this.jax = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.jaw += f;
            VideoPbFragment.this.jax += f2;
            if (VideoPbFragment.this.jav == 0 && !VideoPbFragment.this.jay && VideoPbFragment.this.jag != null && !VideoPbFragment.this.jag.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.jax) <= Math.abs(VideoPbFragment.this.jaw) || VideoPbFragment.this.jax > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.jax) > Math.abs(VideoPbFragment.this.jaw) && VideoPbFragment.this.jax > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.jav = 2;
                    }
                } else {
                    VideoPbFragment.this.jav = 1;
                }
            }
            return true;
        }
    };
    private Runnable jaB = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.jaz && !VideoPbFragment.this.ctv()) {
                VideoPbFragment.this.ctu();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cnE(), VideoPbFragment.this.cnE().getRootView());
                VideoPbFragment.this.jaz = false;
            }
        }
    };
    private final com.baidu.adp.base.d fLy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.clX() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fLt.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fLt.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.clX().coo();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.iXu != 1002 || bVar.eMo) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.kkW, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fLt.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fLt.getLoadDataMode(), gVar.mSuccess, gVar.kkW, false);
                    VideoPbFragment.this.jas.aM(gVar.kkZ);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener dsa = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.gtf.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d iKn = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                    anVar.cx("fid", VideoPbFragment.this.clX().getPbData().getForumId());
                }
                if (VideoPbFragment.this.clX() != null) {
                    anVar.cx("tid", VideoPbFragment.this.clX().cnU());
                }
                anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.iJu != null) {
                    VideoPbFragment.this.iJu.cqR();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.hRk != null) {
                    VideoPbFragment.this.hRk.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.iJu != null) {
                if (VideoPbFragment.this.iQP != null && VideoPbFragment.this.iQP.cmJ() != null && VideoPbFragment.this.iQP.cmJ().aPm()) {
                    VideoPbFragment.this.iQP.cmJ().a(postWriteCallBackData);
                }
                VideoPbFragment.this.iJu.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dyT = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOW() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener avi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean v;
            int i2 = 2;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cx("tid", VideoPbFragment.this.clX().cnU());
                    anVar.cx("fid", VideoPbFragment.this.clX().getForumId());
                    anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.X("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.iIZ) {
                        VideoPbFragment.this.iIZ = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.iIL != null && postData.aCr() != null && postData.cLv() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.iQP != null) {
                                    VideoPbFragment.this.iQP.cmF();
                                }
                                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                lVar.a(VideoPbFragment.this.clX().getPbData().getForum());
                                lVar.setThreadData(VideoPbFragment.this.clX().getPbData().ckP());
                                lVar.f(postData);
                                VideoPbFragment.this.iIL.d(lVar);
                                VideoPbFragment.this.iIL.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aCr().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.clX().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.iJD != null) {
                                    VideoPbFragment.this.qv(VideoPbFragment.this.iJD.aPe());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.ctp() != null && VideoPbFragment.this.ctp().cqq() != null && view == VideoPbFragment.this.ctp().cqq()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.clX().qb(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.ctp().cqc();
                    }
                } else if (VideoPbFragment.this.jas != null && VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpc()) {
                    VideoPbFragment.this.jas.arX();
                } else if (VideoPbFragment.this.jas != null && ((VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpd()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.jas.cqu();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bEu();
                        VideoPbFragment.this.cqb();
                        if (view.getId() == R.id.owner_reply) {
                            v = VideoPbFragment.this.clX().v(true, VideoPbFragment.this.cnn());
                        } else {
                            v = view.getId() == R.id.all_reply ? VideoPbFragment.this.clX().v(false, VideoPbFragment.this.cnn()) : VideoPbFragment.this.clX().FV(VideoPbFragment.this.cnn());
                        }
                        view.setTag(Boolean.valueOf(v));
                        if (v) {
                            VideoPbFragment.this.bWL();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.dGn) {
                    if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cx("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cx("fid", VideoPbFragment.this.clX().getPbData().getForumId());
                            anVar2.cx("tid", VideoPbFragment.this.clX().cnU());
                            anVar2.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.iIO, VideoPbFragment.this.dGn);
                        VideoPbFragment.this.iIO.finish();
                    }
                } else if (view == VideoPbFragment.this.iVB && VideoPbFragment.this.jas != null) {
                    if (VideoPbFragment.this.clX() == null || VideoPbFragment.this.clX().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> ckR = VideoPbFragment.this.clX().getPbData().ckR();
                    if ((ckR == null || ckR.size() <= 0) && VideoPbFragment.this.clX().cnV()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cx("tid", VideoPbFragment.this.clX().cnU()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("fid", VideoPbFragment.this.clX().getForumId()));
                    VideoPbFragment.this.jas.cnb();
                } else if (VideoPbFragment.this.jas != null && VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpd()) {
                    VideoPbFragment.this.jas.arX();
                } else if (VideoPbFragment.this.jas != null && ((VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpj()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.jas.cqu();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bEu();
                            VideoPbFragment.this.cqb();
                            VideoPbFragment.this.jas.cG(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.clX().com()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.jas != null && VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpb()) {
                    if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.clX().getPbData().ckP() != null) {
                        VideoPbFragment.this.jas.arX();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.jas.FQ(VideoPbFragment.this.clX().getPbData().ckP().aCH());
                    }
                } else if (VideoPbFragment.this.jas != null && VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpk()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.w(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                    }
                    VideoPbFragment.this.jas.crx();
                } else if (VideoPbFragment.this.jas != null && (view == VideoPbFragment.this.jas.cpZ() || (VideoPbFragment.this.jas.cry() != null && (view == VideoPbFragment.this.jas.cry().cpg() || view == VideoPbFragment.this.jas.cry().cpe())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.clX() != null || VideoPbFragment.this.clX().getPbData() != null) {
                        if ((VideoPbFragment.this.clX().getPbData().clb() == 1 || VideoPbFragment.this.clX().getPbData().clb() == 3) && !VideoPbFragment.this.fLt.cMj()) {
                            VideoPbFragment.this.jas.cqu();
                            if (VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpe()) {
                                if (VideoPbFragment.this.clX().getPbData().ckP().aCm() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpg()) {
                                i = VideoPbFragment.this.clX().getPbData().ckP().aCn() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.jas.cpZ() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.clX().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.clX().getPbData().ckP().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fLt.b(id, name, id2, i, VideoPbFragment.this.jas.cqa());
                        }
                    }
                } else if (VideoPbFragment.this.jas != null && VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpi()) {
                    if (VideoPbFragment.this.clX() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.jas.cqu();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.clX().getPbData(), VideoPbFragment.this.clX().cnV(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.clX().getPbData().getForum().getId(), VideoPbFragment.this.clX().getPbData().getForum().getName(), VideoPbFragment.this.clX().getPbData().ckP().getId(), String.valueOf(VideoPbFragment.this.clX().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.jas != null && VideoPbFragment.this.jas.cry() != null && view == VideoPbFragment.this.jas.cry().cpf()) {
                    if (VideoPbFragment.this.clX() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.clX().getPbData(), VideoPbFragment.this.clX().cnV(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.jas.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.jas.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.jas.arX();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cx("tid", VideoPbFragment.this.clX().cnU());
                        anVar3.cx("fid", VideoPbFragment.this.clX().getForumId());
                        anVar3.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.X("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").X("obj_locate", 3).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                        if (VideoPbFragment.this.jas != null) {
                            VideoPbFragment.this.jas.cqu();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cLH() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.kjg != null) {
                                an aGC = postData2.kjg.aGC();
                                aGC.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aGC.X("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aGC.X("obj_locate", 8);
                                }
                                TiebaStatic.log(aGC);
                            }
                            String cnU = VideoPbFragment.this.clX().cnU();
                            String id3 = postData2.getId();
                            int clb = VideoPbFragment.this.clX().getPbData() != null ? VideoPbFragment.this.clX().getPbData().clb() : 0;
                            VideoPbFragment.this.bEu();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.ctp() != null && VideoPbFragment.this.ctp().cuc() != null) {
                                PbActivity.a FT = VideoPbFragment.this.ctp().cuc().FT(id3);
                                if (postData2 != null && VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null && FT != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnU, id3, "pb", true, null, false, null, clb, postData2.csv(), VideoPbFragment.this.clX().getPbData().getAnti(), false, postData2.aCr().getIconInfo()).addBigImageData(FT.iGa, FT.iGb, FT.iGc, FT.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.clX().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.clX().coc());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.clX().coD());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.clX().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.clX() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cx("tid", VideoPbFragment.this.clX().cnU());
                        anVar4.cx("fid", VideoPbFragment.this.clX().getForumId());
                        anVar4.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.X("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (postData3.kjg != null) {
                                    an aGC2 = postData3.kjg.aGC();
                                    aGC2.delete("obj_locate");
                                    aGC2.X("obj_locate", 8);
                                    TiebaStatic.log(aGC2);
                                }
                                if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.iIL != null && postData3.aCr() != null && postData3.cLv() != 1) {
                                    if (VideoPbFragment.this.iQP != null) {
                                        VideoPbFragment.this.iQP.cmF();
                                    }
                                    com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                                    lVar2.a(VideoPbFragment.this.clX().getPbData().getForum());
                                    lVar2.setThreadData(VideoPbFragment.this.clX().getPbData().ckP());
                                    lVar2.f(postData3);
                                    VideoPbFragment.this.iIL.d(lVar2);
                                    VideoPbFragment.this.iIL.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aCr().getUserId(), "");
                                    if (VideoPbFragment.this.iJD != null) {
                                        VideoPbFragment.this.qv(VideoPbFragment.this.iJD.aPe());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.jas != null && VideoPbFragment.this.clX() != null && VideoPbFragment.this.ctp() != null) {
                        VideoPbFragment.this.jas.cqu();
                        if (VideoPbFragment.this.yW(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.clX() != null) {
                            VideoPbFragment.this.cni();
                            if (VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.clX().getPbData().ckP() != null && VideoPbFragment.this.clX().getPbData().ckP().aCr() != null) {
                                TiebaStatic.log(new an("c13402").cx("tid", VideoPbFragment.this.clX().cnU()).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()).X("obj_locate", 3).cx("uid", VideoPbFragment.this.clX().getPbData().ckP().aCr().getUserId()));
                            }
                            if (VideoPbFragment.this.clX().getPbData().ckP() != null && VideoPbFragment.this.clX().getPbData().ckP().aCr() != null && VideoPbFragment.this.clX().getPbData().ckP().aCr().getUserId() != null && VideoPbFragment.this.iJo != null) {
                                int g = VideoPbFragment.this.jas.g(VideoPbFragment.this.clX().getPbData());
                                bj ckP = VideoPbFragment.this.clX().getPbData().ckP();
                                if (!ckP.aBg()) {
                                    if (ckP.aBh()) {
                                        i2 = 3;
                                    } else if (ckP.aEk()) {
                                        i2 = 4;
                                    } else {
                                        i2 = ckP.aEl() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cx("tid", VideoPbFragment.this.clX().cnU()).X("obj_locate", 1).cx("obj_id", VideoPbFragment.this.clX().getPbData().ckP().aCr().getUserId()).X("obj_type", VideoPbFragment.this.iJo.ayO() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.qW(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.jas != null && VideoPbFragment.this.cYo != null && VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.clX().getPbData().ckP() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.clX().getPbData().ckP().aCi() != 0) {
                            int currentItem = VideoPbFragment.this.cYo.getCurrentItem();
                            if (currentItem == VideoPbFragment.iZY) {
                                VideoPbFragment.this.cYo.setCurrentItem(VideoPbFragment.iZZ);
                            } else if (currentItem == VideoPbFragment.iZZ) {
                                if (VideoPbFragment.this.ctp() != null && VideoPbFragment.this.bGV() != null) {
                                    an cx = new an("c13403").cx("tid", VideoPbFragment.this.clX().cnU()).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bGV = VideoPbFragment.this.bGV();
                                    boolean canScrollVertically = bGV.canScrollVertically(1);
                                    boolean canScrollVertically2 = bGV.canScrollVertically(-1);
                                    if (VideoPbFragment.this.CD != null) {
                                        VideoPbFragment.this.CD.setExpanded(false, true);
                                    }
                                    if (bGV.getLayoutManager() != null && (bGV.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bGV.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.iJj != -1 || VideoPbFragment.this.iJk != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.iJj > 3 || (VideoPbFragment.this.iJj == 3 && VideoPbFragment.this.iJk < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iJj, VideoPbFragment.this.iJk + equipmentHeight);
                                                    bGV.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.iJj >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iJj, VideoPbFragment.this.iJk + (equipmentHeight / 2));
                                                    bGV.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.iJj == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iJj, VideoPbFragment.this.iJk + (equipmentHeight / 4));
                                                    bGV.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bGV.smoothScrollBy(0, -VideoPbFragment.this.iJk);
                                                }
                                                cx.X("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bGV.getFirstVisiblePosition();
                                            View childAt = bGV.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.iJj = firstVisiblePosition;
                                            VideoPbFragment.this.iJk = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bGV.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bGV.smoothScrollToPosition(0);
                                            } else {
                                                bGV.smoothScrollToPosition(0);
                                            }
                                            cx.X("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cx);
                                        TiebaStatic.log(new an("c12942").X("obj_type", 1).X("obj_locate", 4).cx("tid", VideoPbFragment.this.clX().cnU()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.clX().getPbData().ckP() != null && VideoPbFragment.this.clX().getPbData().ckP().aCr() != null) {
                                TiebaStatic.log(new an("c13402").cx("tid", VideoPbFragment.this.clX().cnU()).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()).X("obj_locate", 2).cx("uid", VideoPbFragment.this.clX().getPbData().ckP().aCr().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.qX(false);
                        VideoPbFragment.this.cmV();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.iJQ >= 0) {
                        if (VideoPbFragment.this.clX() != null) {
                            VideoPbFragment.this.clX().coE();
                        }
                        if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.ctp() != null && VideoPbFragment.this.ctp().cub() != null) {
                            VideoPbFragment.this.ctp().cub().setData(VideoPbFragment.this.clX().getPbData());
                        }
                        VideoPbFragment.this.iJQ = 0;
                        VideoPbFragment.this.jau = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.ctp() != null) {
                            VideoPbFragment.this.ctp().cv(VideoPbFragment.this.clX().coH(), VideoPbFragment.this.clX().coI());
                            VideoPbFragment.this.clX().cs(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.clX() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cx("tid", VideoPbFragment.this.clX().cnU());
                        anVar5.cx("fid", VideoPbFragment.this.clX().getForumId());
                        anVar5.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.X("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cpG();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cpG();
                }
            }
        }
    };
    private View.OnClickListener iGF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.jas != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.jas.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.jas.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.jas.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.jas.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a jat = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cng() {
        if (clX() != null && clX().getPbData() != null && clX().getPbData().ckP() != null) {
            bj ckP = clX().getPbData().ckP();
            ckP.mRecomAbTag = clX().coO();
            ckP.mRecomWeight = clX().coM();
            ckP.mRecomSource = clX().coN();
            ckP.mRecomExtra = clX().coP();
            if (ckP.getFid() == 0) {
                ckP.setFid(com.baidu.adp.lib.f.b.toLong(clX().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckP, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmZ() {
        if (clX() != null && clX().getPbData() != null && clX().getPbData().ckP() != null) {
            bj ckP = clX().getPbData().ckP();
            ckP.mRecomAbTag = clX().coO();
            ckP.mRecomWeight = clX().coM();
            ckP.mRecomSource = clX().coN();
            ckP.mRecomExtra = clX().coP();
            if (ckP.getFid() == 0) {
                ckP.setFid(com.baidu.adp.lib.f.b.toLong(clX().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckP, "c13563");
            if (a2 != null) {
                a2.X("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        hideProgressBar();
        if (z && z2) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z2) {
            if (aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.kkW) ? bVar.kkW : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sS(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fH(true);
                aVar.b(getPageContext());
                aVar.aEG();
            } else {
                a(0, bVar.mSuccess, bVar.kkW, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fYS == 1) {
                    ArrayList<PostData> ckR = clX().getPbData().ckR();
                    int size = ckR.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ckR.get(i).getId())) {
                            i++;
                        } else {
                            ckR.remove(i);
                            break;
                        }
                    }
                    clX().getPbData().ckP().jJ(clX().getPbData().ckP().aCi() - 1);
                    if (ctp() != null) {
                        ctp().cua();
                    }
                } else if (bVar.fYS == 0) {
                    cnh();
                } else if (bVar.fYS == 2) {
                    ArrayList<PostData> ckR2 = clX().getPbData().ckR();
                    int size2 = ckR2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ckR2.get(i2).cLs().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ckR2.get(i2).cLs().get(i3).getId())) {
                                i3++;
                            } else {
                                ckR2.get(i2).cLs().remove(i3);
                                ckR2.get(i2).cLu();
                                z2 = true;
                                break;
                            }
                        }
                        ckR2.get(i2).Jc(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && ctp() != null) {
                        ctp().cua();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = clX().getPbData().cla().iEF;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cLs().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cLs().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cLs().remove(i2);
                    list.get(i).cLu();
                    z = true;
                    break;
                }
            }
            list.get(i).Jc(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && ctp() != null) {
            ctp().cua();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && clX() != null && clX().getPbData() != null && clX().getPbData().ckP() != null) {
            a(this.fLt.getLoadDataMode(), gVar.mSuccess, gVar.kkW, false);
            if (gVar.mSuccess) {
                this.iJr = true;
                if (i == 2 || i == 3) {
                    this.iJs = true;
                    this.iJt = false;
                } else if (i == 4 || i == 5) {
                    this.iJs = false;
                    this.iJt = true;
                }
                if (i == 2) {
                    clX().getPbData().ckP().jM(1);
                    clX().setIsGood(1);
                } else if (i == 3) {
                    clX().getPbData().ckP().jM(0);
                    clX().setIsGood(0);
                } else if (i == 4) {
                    clX().getPbData().ckP().jL(1);
                    clX().yY(1);
                } else if (i == 5) {
                    clX().getPbData().ckP().jL(0);
                    clX().yY(0);
                }
            }
            if (clX().getPbData().ckP() != null && ctq() != null) {
                ctq().ctX();
            }
        }
    }

    private void cnh() {
        if (clX().cnW() || clX().cnY()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", clX().cnU());
            PbActivity pbActivity = this.iIO;
            PbActivity pbActivity2 = this.iIO;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, clX().cnU()));
        if (cnk()) {
            this.iIO.finish();
        }
    }

    private boolean cnk() {
        if (clX() == null) {
            return true;
        }
        if (clX().getPbData() == null || !clX().getPbData().cln()) {
            if (clX().ayO()) {
                final MarkData con = clX().con();
                if (con == null || !clX().getIsFromMark() || bGV() == null) {
                    return true;
                }
                final MarkData zf = clX().zf(bGV().getFirstVisiblePosition());
                if (zf == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", con);
                    this.iIO.setResult(-1, intent);
                    return true;
                } else if (zf.getPostId() == null || zf.getPostId().equals(con.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", con);
                    this.iIO.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.sS(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.iJo != null) {
                                if (VideoPbFragment.this.iJo.ayO()) {
                                    VideoPbFragment.this.iJo.ayP();
                                    VideoPbFragment.this.iJo.fn(false);
                                }
                                VideoPbFragment.this.iJo.a(zf);
                                VideoPbFragment.this.iJo.fn(true);
                                VideoPbFragment.this.iJo.ayQ();
                            }
                            con.setPostId(zf.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", con);
                            VideoPbFragment.this.iIO.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cmk();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", con);
                            VideoPbFragment.this.iIO.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cmk();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aEG();
                    return false;
                }
            } else if (clX().getPbData() == null || clX().getPbData().ckR() == null || clX().getPbData().ckR().size() <= 0 || !clX().getIsFromMark()) {
                return true;
            } else {
                this.iIO.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmk() {
        this.iIO.cmk();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void qW(boolean z) {
        com.baidu.tieba.pb.data.e pbData;
        int i;
        if (clX() != null && this.jas != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = clX().getPbData()) != null) {
                bj ckP = pbData.ckP();
                if (ckP != null && ckP.aCr() != null) {
                    TiebaStatic.log(new an("c13402").cx("tid", clX().cnU()).cx("fid", pbData.getForumId()).X("obj_locate", 4).cx("uid", ckP.aCr().getUserId()));
                }
                if (ckP != null) {
                    if (ckP.aBg()) {
                        i = 2;
                    } else if (ckP.aBh()) {
                        i = 3;
                    } else if (ckP.aEk()) {
                        i = 4;
                    } else if (ckP.aEl()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cx("tid", clX().cnU());
                    anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cx("fid", clX().getForumId());
                    if (!z) {
                        anVar.X("obj_locate", 6);
                    } else {
                        anVar.X("obj_locate", 5);
                    }
                    anVar.X("obj_name", i);
                    anVar.X("obj_type", 2);
                    if (ckP != null) {
                        if (ckP.aBg()) {
                            anVar.X("obj_type", 10);
                        } else if (ckP.aBh()) {
                            anVar.X("obj_type", 9);
                        } else if (ckP.aEl()) {
                            anVar.X("obj_type", 8);
                        } else if (ckP.aEk()) {
                            anVar.X("obj_type", 7);
                        } else if (ckP.isShareThread) {
                            anVar.X("obj_type", 6);
                        } else if (ckP.threadType == 0) {
                            anVar.X("obj_type", 1);
                        } else if (ckP.threadType == 40) {
                            anVar.X("obj_type", 2);
                        } else if (ckP.threadType == 49) {
                            anVar.X("obj_type", 3);
                        } else if (ckP.threadType == 54) {
                            anVar.X("obj_type", 4);
                        } else {
                            anVar.X("obj_type", 5);
                        }
                    }
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (clX().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> ckR = pbData.ckR();
                        if ((ckR == null || ckR.size() <= 0) && clX().cnV()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.jas.cqu();
                        bEu();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), ckP)) {
                            if (this.iQo != null) {
                                this.iQo.setEnable(false);
                                t(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                yX(z ? 2 : 1);
                                return;
                            }
                            this.jas.showLoadingDialog();
                            clX().coy().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cx("tid", clX().cnU());
                anVar2.cx("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cx("fid", clX().getForumId());
                if (!z) {
                }
                anVar2.X("obj_name", i);
                anVar2.X("obj_type", 2);
                if (ckP != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment csV() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        G(eVar.ctB());
        H(eVar.ctB());
        if (clX() != null && clX().getPbData() != null) {
            boolean isFromMark = clX().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = clX().getPbData();
            if (isFromMark) {
                PostData F = F(pbData);
                if (pbData.ayN() != null && !pbData.ayN().equals(F.getId()) && this.cYo != null) {
                    this.cYo.setCurrentItem(iZZ);
                }
            }
        }
        eVar.ctC().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.aCI() != null) {
                    if (VideoPbFragment.this.jag.getVideoUrl() == null || !VideoPbFragment.this.jag.getVideoUrl().equals(bjVar.aCI().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.jag.getVideoUrl())) {
                            VideoPbFragment.this.iJb = true;
                            VideoPbFragment.this.cYo.setCurrentItem(VideoPbFragment.iZY);
                        }
                        if (VideoPbFragment.this.jah == null || !VideoPbFragment.this.jah.isPlaying()) {
                            VideoPbFragment.this.csW();
                            VideoPbFragment.this.aM(bjVar);
                        }
                        VideoPbFragment.this.csX();
                        if (VideoPbFragment.this.jah.ctP()) {
                            VideoPbFragment.this.jah.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.jag.getVideoUrl(), bjVar.aCI().video_url);
                        VideoPbFragment.this.jag.setData(bjVar);
                        VideoPbFragment.this.jag.rf(VideoPbFragment.this.cYo.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.jag.startPlay();
                            VideoPbFragment.this.jag.cut();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.jag.setData(bjVar);
                }
            }
        });
        eVar.ctL().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.cYo.setCurrentItem(num.intValue());
            }
        });
        eVar.ctG().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.jag.aR(bjVar);
            }
        });
        eVar.ctH().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aN */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.jag.aS(bjVar);
            }
        });
        eVar.ctI().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cti();
            }
        });
        eVar.ctJ().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csW() {
        ViewGroup.LayoutParams layoutParams = this.jaj.getLayoutParams();
        layoutParams.height = 0;
        this.jaj.setLayoutParams(layoutParams);
        this.jaj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csX() {
        if (this.jah == null) {
            this.jah = new f(getBaseFragmentActivity(), this.jaf);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cnE()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.jaf.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.jah.b(eVar.ctD(), rect);
            if (this.jah.ctP()) {
                this.jah.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.ctE() || VideoPbFragment.this.clX().getTabIndex() == VideoPbFragment.iZZ) {
                            VideoPbFragment.this.cYo.setCurrentItem(VideoPbFragment.iZZ);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.ctE() || VideoPbFragment.this.clX().getTabIndex() == VideoPbFragment.iZZ) {
                            VideoPbFragment.this.cYo.setCurrentItem(VideoPbFragment.iZZ);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.ctE() || clX().getTabIndex() == iZZ) {
                this.cYo.setCurrentItem(iZZ);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.jay && (this.jaz || ctv())) {
            ctu();
            UtilHelper.hideStatusBar(cnE(), cnE().getRootView());
            this.jaz = false;
            if (this.jag != null) {
                this.jag.qY(false);
            }
        }
        if (i == 4) {
            return this.jag.onBackPress();
        }
        if (i == 24) {
            return this.jag.cup();
        }
        if (i == 25) {
            return this.jag.cuq();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aM(bj bjVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect coQ;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bjVar != null && bjVar.aCI() != null) {
            int intValue = bjVar.aCI().video_width.intValue();
            int intValue2 = bjVar.aCI().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (clX() != null || (coQ = clX().coQ()) == null) ? ceil : coQ.height();
                i = 0;
                layoutParams = this.jaf.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.jaf.setLayoutParams(layoutParams);
                this.jaf.setMaxHeight(ceil);
                this.jaf.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.jaf.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.jab.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, jaa);
                } else {
                    layoutParams2.height = jaa;
                }
                this.jab.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
                int i2 = ceil + jaa;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.CD.setLayoutParams(layoutParams3);
                if (i == 0 && (this.CD.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.CD.getLayoutParams()).getBehavior();
                    if (behavior instanceof VideoZoomBehavior) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i);
                        return;
                    }
                    return;
                }
            }
        }
        d = 1.7777777777777777d;
        if (d > 1.7777777777777777d) {
        }
        if (d >= equipmentHeight) {
        }
        int ceil2 = (int) Math.ceil(equipmentWidth / equipmentHeight);
        if (clX() != null) {
        }
        i = 0;
        layoutParams = this.jaf.getLayoutParams();
        if (layoutParams != null) {
        }
        this.jaf.setLayoutParams(layoutParams);
        this.jaf.setMaxHeight(ceil2);
        this.jaf.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.jaf.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.jab.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.jab.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
        int i22 = ceil2 + jaa;
        if (layoutParams3 != null) {
        }
        this.CD.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iIV = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.iJK = new com.baidu.tbadk.core.view.d();
        this.iJK.toastTime = 1000L;
        if (this.jas != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.jas.iJL;
            userMuteAddAndDelCustomMessage.setTag(this.jas.iJL);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.jas.iJL;
            userMuteCheckCustomMessage.setTag(this.jas.iJL);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
    }

    private void initData() {
        this.iJo = com.baidu.tbadk.baseEditMark.a.a(this.iIO);
        if (this.iJo != null) {
            this.iJo.a(this.iKr);
        }
        this.fLt = new ForumManageModel(this.iIO);
        this.fLt.setLoadDataCallBack(this.fLy);
        this.dap = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.jas = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.iJC = new g();
        d(this.iJC);
        this.iJD = (com.baidu.tbadk.editortools.pb.e) this.iJC.dU(getActivity());
        this.iJD.a(this.iIO.getPageContext());
        this.iJD.a(this.dza);
        this.iJD.a(this.dyT);
        this.iJD.a(this.iIO.getPageContext(), bundle);
        this.iJD.aOy().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iJD.aOy().gC(true);
        pQ(true);
        this.iJD.a(clX().coj(), clX().cnU(), clX().coA());
        registerListener(this.iKa);
        registerListener(this.iKq);
        registerListener(this.iJZ);
        registerListener(this.iJX);
        registerListener(this.gqu);
        if (!clX().coa()) {
            this.iJD.vm(clX().cnU());
        }
        if (clX().coB()) {
            this.iJD.vl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.iJD.vl(cpI());
        }
        this.iJu = new ap();
        if (this.iJD.aOX() != null) {
            this.iJu.e(this.iJD.aOX().getInputView());
        }
        this.iJD.a(this.dyU);
        this.hRk = new aj(getPageContext());
        this.hRk.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == aj.dak) {
                        VideoPbFragment.this.iJD.a((String) null, (WriteData) null);
                    } else if (i == aj.dal && VideoPbFragment.this.iQP != null && VideoPbFragment.this.iQP.cmJ() != null) {
                        VideoPbFragment.this.iQP.cmJ().aPt();
                    } else if (i == aj.dam) {
                        VideoPbFragment.this.c(VideoPbFragment.this.iJG);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        initUI();
        return this.rootView;
    }

    private void initUI() {
        this.gtf = new com.baidu.tieba.f.b(getActivity());
        this.gtf.a(iKz);
        this.jay = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bcO();
        this.CD = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.jad = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.jaf = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.jag = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.jaf);
        this.jag.setUniqueId(getUniqueId());
        this.jag.ad(this);
        this.jag.cH(cnE().getRootView());
        this.jag.cI(this.jai);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.jab = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.jaj = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.cYo = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.jae = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.jae.setOnClickListener(this.avi);
        csZ();
        csY();
        cta();
        this.jac = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.cYo.setAdapter(this.jac);
        this.jab.setViewPager(this.cYo);
        this.jab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.ctp() != null) {
                        VideoPbFragment.this.ctp().re(false);
                    }
                    if (VideoPbFragment.this.ctq() != null) {
                        VideoPbFragment.this.ctq().re(true);
                        VideoPbFragment.this.zD(VideoPbFragment.this.ctq().ctZ() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.ctI() != null && eVar.ctI().getValue() != null && eVar.ctI().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.jag.rf(z);
                    VideoPbFragment.this.cpG();
                    if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cx("tid", VideoPbFragment.this.clX().cnU()).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.ctq() != null) {
                        VideoPbFragment.this.ctq().re(false);
                    }
                    if (VideoPbFragment.this.ctp() != null) {
                        VideoPbFragment.this.ctp().re(true);
                        int ctZ = VideoPbFragment.this.ctp().ctZ();
                        int cue = VideoPbFragment.this.ctp().cue();
                        if (ctZ != 0) {
                            VideoPbFragment.this.zD(8);
                            VideoPbFragment.this.ctp().zD(0);
                        } else if (cue != 0) {
                            VideoPbFragment.this.ctp().zD(8);
                            VideoPbFragment.this.zD(0);
                        } else {
                            VideoPbFragment.this.ctp().zD(8);
                            VideoPbFragment.this.zD(8);
                        }
                    }
                    VideoPbFragment.this.jag.rf(false);
                    VideoPbFragment.this.CD.setExpanded(false, true);
                    if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").cx("tid", VideoPbFragment.this.clX().cnU()).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.jac.zF(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iPS = this.rootView.findViewById(R.id.viewstub_progress);
        ctb();
        ctc();
        if (!this.jay && this.jaz) {
            ctu();
            UtilHelper.hideStatusBar(cnE(), cnE().getRootView());
            this.jaz = false;
        }
    }

    private void csY() {
        this.jal = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.jap = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.jam = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.jan = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.jao = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.jap.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jap.setConrers(15);
        this.jao.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.jan.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.ctk();
            }
        });
        this.jao.setOnClickListener(this.jak);
        this.jaj.setOnClickListener(this.jak);
    }

    private void csZ() {
        this.jab.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.jab.setContainerLayoutParams(layoutParams);
        this.jab.setRectPaintColor(R.color.cp_link_tip_a);
        this.jab.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.jab.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.jab.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.jab.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.jab.setExpandedTabLayoutParams(layoutParams2);
    }

    public void qX(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    private void cta() {
        this.iQj = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.iQk = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.iQr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iQs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hiz = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hiz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.qX(false);
                VideoPbFragment.this.cmV();
                if (VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null && VideoPbFragment.this.clX().getPbData().ckP() != null && VideoPbFragment.this.clX().getPbData().ckP().aCr() != null) {
                    TiebaStatic.log(new an("c13402").cx("tid", VideoPbFragment.this.clX().cnU()).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()).X("obj_locate", 1).cx("uid", VideoPbFragment.this.clX().getPbData().ckP().aCr().getUserId()));
                }
            }
        });
        this.iQl = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iQl.setOnClickListener(this.avi);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iQm = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.iQm.setOnClickListener(this.avi);
        if (booleanExtra) {
            this.iQm.setVisibility(8);
        } else {
            this.iQm.setVisibility(0);
        }
        this.iQn = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.iQn.setOnClickListener(this.avi);
        this.iQo = new com.baidu.tieba.pb.view.c(this.iQn);
        this.iQo.cuD();
        this.iQp = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        qx(false);
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bEv();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.jai = this.rootView.findViewById(R.id.status_bar_background);
        if (this.jay) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cnE());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.jai.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cnE());
            this.jai.setLayoutParams(layoutParams2);
            this.jai.setVisibility(0);
        }
        this.dGn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.avi);
        this.eFf = (ImageView) this.dGn.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGG().a(this.eFf, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iVB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.avi);
        this.Lb = (ImageView) this.iVB.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.iVB.setLayoutParams(layoutParams3);
        SvgManager.aGG().a(this.Lb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iVB.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.gzo);
        this.mNavigationBar.setOnTouchListener(this.jaA);
    }

    public void ctb() {
        setEditorTools(this.iJD.aOy());
    }

    private void ctc() {
        this.iIL = new PbFakeFloorModel(getPageContext());
        this.iQP = new s(getPageContext(), this.iIL, this.rootView);
        this.iQP.a(this.iKn);
        this.iIL.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                VideoPbFragment.this.iIL.q(postData);
                if (VideoPbFragment.this.ctp() != null) {
                    VideoPbFragment.this.ctp().cua();
                }
                VideoPbFragment.this.iQP.cmF();
                VideoPbFragment.this.FO.aMV();
                VideoPbFragment.this.qx(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iIO = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (clX() != null) {
            clX().au(bundle);
        }
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
        getVoiceManager().onPause(getPageContext());
        this.jag.mR(true);
        if (clX() != null && !clX().coa()) {
            this.iJD.saveDraft(clX().cnU());
        }
        com.baidu.tbadk.BdToken.c.axC().axH();
        MessageManager.getInstance().unRegisterListener(this.iKj);
        MessageManager.getInstance().unRegisterListener(this.iKk);
        MessageManager.getInstance().unRegisterListener(this.iKl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.jag.mR(false);
        cnA();
        registerListener(this.iKj);
        registerListener(this.iKk);
        registerListener(this.iKl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jac != null && this.cYo != null) {
            this.jac.zF(z ? this.cYo.getCurrentItem() : -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.iQo != null) {
            this.iQo.onDestroy();
        }
        if (this.fLt != null) {
            this.fLt.cancelLoadData();
        }
        if (this.jag != null) {
            this.jag.onDestroy();
        }
        if (this.iJf != null) {
            this.iJf.cancelLoadData();
        }
        if (this.hRk != null) {
            this.hRk.onDestroy();
        }
        if (clX() != null) {
            clX().cancelLoadData();
            clX().destory();
            if (clX().cox() != null) {
                clX().cox().onDestroy();
            }
        }
        if (this.iJD != null) {
            this.iJD.onDestroy();
        }
        this.iJK = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iIO);
        this.jab.onChangeSkinType();
        am.setBackgroundColor(this.jab, R.color.cp_bg_line_h);
        this.iJu.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.jah == null || !this.jah.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.jai, R.color.cp_mask_b_alpha66);
        if (this.FO != null) {
            this.FO.onChangeSkinType(i);
        }
        if (this.iQP != null) {
            this.iQP.onChangeSkinType(i);
        }
        if (this.hiz != null) {
            am.setViewTextColor(this.hiz, (int) R.color.cp_cont_d);
            this.hiz.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.iQm != null && clX() != null) {
            if (clX().ayO()) {
                SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iQl != null) {
            SvgManager.aGG().a(this.iQl, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (clX() != null) {
            t(clX().getPbData());
        }
        am.setViewTextColor(this.iQp, (int) R.color.cp_cont_b);
        if (this.iQj != null) {
            am.setBackgroundResource(this.iQj, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.iQk, R.color.cp_bg_line_h);
        if (ctp() != null) {
            ctp().onChangeSkinType(i);
        }
        if (ctq() != null) {
            ctq().onChangeSkinType(i);
        }
        if (this.jad != null) {
            am.setBackgroundResource(this.jad, R.drawable.personalize_tab_shadow);
        }
        if (this.jaj != null) {
            am.setBackgroundColor(this.jaj, R.color.cp_bg_line_g);
        }
        if (this.jan != null) {
            SvgManager.aGG().a(this.jan, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jal != null) {
            am.setViewTextColor(this.jal, (int) R.color.cp_cont_b);
        }
        if (this.jam != null) {
            am.setViewTextColor(this.jam, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gpi == null) {
            this.gpi = VoiceManager.instance();
        }
        return this.gpi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEu() {
        if (this.gpi != null) {
            this.gpi.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cnC() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cnD() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clX() {
        return this.iIO.clX();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cnE() {
        return this.iIO;
    }

    public com.baidu.tbadk.baseEditMark.a ctd() {
        return this.iJo;
    }

    public View.OnClickListener cte() {
        return this.avi;
    }

    public View.OnClickListener ctf() {
        return this.iGF;
    }

    public View.OnLongClickListener ctg() {
        return this.jas.ctg();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.Gi(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.c(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    spannableStringBuilder.setSpan(objArr[i], spannableStringBuilder.getSpanStart(objArr[i]), spannableStringBuilder.length(), 18);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                    return;
                }
            }
        }
    }

    public BdTypeRecyclerView bGV() {
        Iterator<BaseFragment> it = this.jac.ctz().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void pQ(boolean z) {
        this.iJD.gG(z);
        this.iJD.gH(z);
        this.iJD.gI(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.jas != null) {
            if (z) {
                this.jas.cqu();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.jas.cqv();
            } else {
                this.jas.cqu();
            }
        }
    }

    public boolean yV(int i) {
        if (this.hRk == null || clX() == null || clX().getPbData() == null || clX().getPbData().getAnti() == null) {
            return true;
        }
        return this.hRk.ax(clX().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cmX() {
        if ((clX() != null && clX().getPbData().cln()) || this.hRk == null || clX() == null || clX().getPbData() == null || clX().getPbData().getAnti() == null) {
            return true;
        }
        return this.hRk.ks(clX().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && clX() != null) {
            gVar.setForumName(clX().clO());
            if (clX().getPbData() != null && clX().getPbData().getForum() != null) {
                gVar.a(clX().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(clX());
        }
    }

    public void cpW() {
        if (this.FO != null) {
            this.FO.display();
            if (this.iJD != null) {
                this.iJD.aPb();
            }
            cqE();
        }
    }

    private boolean cmU() {
        PbModel clX = clX();
        if (clX == null || clX.getPbData() == null) {
            return false;
        }
        bj ckP = clX.getPbData().ckP();
        clX.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), ckP);
    }

    public void cmV() {
        if (checkUpIsLogin() && clX() != null && clX().getPbData() != null && clX().getPbData().getForum() != null && !cmU()) {
            if (clX().getPbData().cln()) {
                bPQ();
                return;
            }
            if (this.gsJ == null) {
                this.gsJ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.gsJ.tV(0);
                this.gsJ.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lC(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lD(boolean z) {
                        if (z) {
                            VideoPbFragment.this.bPQ();
                        }
                    }
                });
            }
            this.gsJ.C(clX().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clX().cnU(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.iJD.onActivityResult(i, i2, intent);
        if (this.iJf != null) {
            this.iJf.onActivityResult(i, i2, intent);
        }
        if (this.iQP != null) {
            this.iQP.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cni();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cCv().B(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.iJG = emotionImageData;
                        if (yV(aj.dam)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                default:
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (cnE() != null) {
            if (this.jaz && !TbSingleton.getInstance().isNotchScreen(cnE()) && !TbSingleton.getInstance().isCutoutScreen(cnE())) {
                ctu();
                UtilHelper.hideStatusBar(cnE(), cnE().getRootView());
                this.jaz = false;
            }
            this.jat.jaM = z;
            cth();
            cti();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iIO;
        if (i == 0) {
            cpC();
            if (this.iQP != null) {
                this.iQP.cmF();
            }
            qx(false);
        }
        cpG();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.iJD.resetData();
                        this.iJD.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iJD.b(writeData);
                        com.baidu.tbadk.editortools.l mr = this.iJD.aOy().mr(6);
                        if (mr != null && mr.dxa != null) {
                            mr.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iIO;
                        if (i == -1) {
                            this.iJD.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iQP != null && this.iQP.cmJ() != null) {
                            com.baidu.tbadk.editortools.pb.h cmJ = this.iQP.cmJ();
                            cmJ.setThreadData(clX().getPbData().ckP());
                            cmJ.b(writeData);
                            cmJ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mr2 = cmJ.aOy().mr(6);
                            if (mr2 != null && mr2.dxa != null) {
                                mr2.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iIO;
                            if (i == -1) {
                                cmJ.aPt();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (clX() != null && !clX().coa()) {
                    antiData.setBlock_forum_name(clX().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(clX().getPbData().getForum().getId());
                    antiData.setUser_name(clX().getPbData().getUserData().getUserName());
                    antiData.setUser_id(clX().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.jas != null) {
                this.jas.vr(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cnG() {
        if (clX() != null && this.iIO != null) {
            if (this.iJD == null || !this.iJD.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.iJD = (com.baidu.tbadk.editortools.pb.e) dVar.dU(getContext());
                this.iJD.a(this.iIO.getPageContext());
                this.iJD.a(this.dza);
                this.iJD.a(this.dyT);
                this.iJD.a(this.iIO.getPageContext(), this.iIO.getIntent() == null ? null : this.iIO.getIntent().getExtras());
                this.iJD.aOy().gC(true);
                setEditorTools(this.iJD.aOy());
                if (!clX().coa()) {
                    this.iJD.vm(clX().cnU());
                }
                if (clX().coB()) {
                    this.iJD.vl(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.iJD.vl(cpI());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.FO.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.FO.getParent() == null) {
            this.rootView.addView(this.FO, layoutParams);
        }
        this.FO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.FO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJB() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJB() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.iJD.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.iJD.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cpC();
        this.iJD.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.FO != null && VideoPbFragment.this.FO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.iJu != null && VideoPbFragment.this.iJu.cqT() != null) {
                    if (!VideoPbFragment.this.iJu.cqT().cUA()) {
                        VideoPbFragment.this.iJu.qC(false);
                    }
                    VideoPbFragment.this.iJu.cqT().tO(false);
                }
            }
        });
    }

    public void bPQ() {
        if (!checkUpIsLogin()) {
            if (clX() != null) {
                TiebaStatic.log(new an("c10517").X("obj_locate", 2).cx("fid", clX().getForumId()));
            }
        } else if (cmX()) {
            if (this.iJD != null && (this.iJD.aPl() || this.iJD.aPm())) {
                this.iJD.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpW();
                this.jat.jaL = false;
                if (this.FO.mr(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.FO.mr(2).dxa, false, null);
                }
            }
            cqE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmU() && cmX()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iJh);
                this.iJi = ((View) view.getParent()).getMeasuredHeight();
            }
            if (clX() != null && clX().getPbData() != null && clX().getPbData().cln()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.iIO.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bGV().smoothScrollBy(0, (VideoPbFragment.this.iJh[1] + VideoPbFragment.this.iJi) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iQP != null) {
                            VideoPbFragment.this.iJD.aOy().setVisibility(8);
                            VideoPbFragment.this.iQP.g(str, str2, VideoPbFragment.this.cpI(), (VideoPbFragment.this.clX() == null || VideoPbFragment.this.clX().getPbData() == null || VideoPbFragment.this.clX().getPbData().ckP() == null || !VideoPbFragment.this.clX().getPbData().ckP().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmJ = VideoPbFragment.this.iQP.cmJ();
                            if (cmJ != null && VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                                cmJ.a(VideoPbFragment.this.clX().getPbData().getAnti());
                                cmJ.setThreadData(VideoPbFragment.this.clX().getPbData().ckP());
                            }
                            if (VideoPbFragment.this.iJu.cqV() == null && VideoPbFragment.this.iQP.cmJ().aPB() != null) {
                                VideoPbFragment.this.iQP.cmJ().aPB().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iJu != null && VideoPbFragment.this.iJu.cqU() != null) {
                                            if (!VideoPbFragment.this.iJu.cqU().cUA()) {
                                                VideoPbFragment.this.iJu.qD(false);
                                            }
                                            VideoPbFragment.this.iJu.cqU().tO(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iJu.f(VideoPbFragment.this.iQP.cmJ().aPB().getInputView());
                                VideoPbFragment.this.iQP.cmJ().a(VideoPbFragment.this.iJI);
                            }
                        }
                        VideoPbFragment.this.cqE();
                    }
                }, 0L);
                return;
            }
            if (this.iJF == null) {
                this.iJF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iJF.tV(1);
                this.iJF.a(new AnonymousClass43(str, str2));
            }
            if (clX() != null && clX().getPbData() != null && clX().getPbData().getForum() != null) {
                this.iJF.C(clX().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(clX().cnU(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$43  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass43 implements c.a {
        final /* synthetic */ String iKL;
        final /* synthetic */ String iKM;

        AnonymousClass43(String str, String str2) {
            this.iKL = str;
            this.iKM = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lD(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bGV().smoothScrollBy(0, (VideoPbFragment.this.iJh[1] + VideoPbFragment.this.iJi) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iQP != null) {
                            VideoPbFragment.this.iJD.aOy().setVisibility(8);
                            VideoPbFragment.this.iQP.g(AnonymousClass43.this.iKL, AnonymousClass43.this.iKM, VideoPbFragment.this.cpI(), (VideoPbFragment.this.clX() == null || VideoPbFragment.this.clX().getPbData() == null || VideoPbFragment.this.clX().getPbData().ckP() == null || !VideoPbFragment.this.clX().getPbData().ckP().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmJ = VideoPbFragment.this.iQP.cmJ();
                            if (cmJ != null && VideoPbFragment.this.clX() != null && VideoPbFragment.this.clX().getPbData() != null) {
                                cmJ.a(VideoPbFragment.this.clX().getPbData().getAnti());
                                cmJ.setThreadData(VideoPbFragment.this.clX().getPbData().ckP());
                            }
                            if (VideoPbFragment.this.iJu.cqV() == null && VideoPbFragment.this.iQP.cmJ().aPB() != null) {
                                VideoPbFragment.this.iQP.cmJ().aPB().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iJu != null && VideoPbFragment.this.iJu.cqU() != null) {
                                            if (!VideoPbFragment.this.iJu.cqU().cUA()) {
                                                VideoPbFragment.this.iJu.qD(false);
                                            }
                                            VideoPbFragment.this.iJu.cqU().tO(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iJu.f(VideoPbFragment.this.iQP.cmJ().aPB().getInputView());
                                VideoPbFragment.this.iQP.cmJ().a(VideoPbFragment.this.iJI);
                            }
                        }
                        VideoPbFragment.this.cqE();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData F;
        w wVar;
        StringBuilder sb = null;
        if (eVar != null && (F = F(eVar)) != null) {
            String userId = F.aCr().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.clb()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (F.aCr() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, F.aCr().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, F.aCr().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, F.aCr().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, F.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.clb()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cli = eVar.cli();
                if (v.getCount(cli) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cli) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cRd) != null && wVar.cOX && !wVar.cOY && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cni() {
        MarkData zf;
        if (clX() != null && clX().getPbData() != null && ctp() != null && this.iJo != null) {
            if (clX().getPbData() != null && clX().getPbData().cln()) {
                zf = clX().zf(0);
            } else if (this.cYo != null && this.cYo.getCurrentItem() == iZY) {
                zf = clX().l(F(clX().getPbData()));
            } else {
                zf = clX().zf(ctp().cqg());
            }
            if (zf != null) {
                if (!zf.isApp() || (zf = clX().zf(ctp().cqg() + 1)) != null) {
                    cqb();
                    this.iJo.a(zf);
                    if (!this.iJo.ayO()) {
                        this.iJo.ayQ();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iJo.ayP();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yW(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.iJf == null) {
                this.iJf = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iIO);
                this.iJf.b(this.dyT);
                this.iJf.c(this.dza);
            }
            this.iJf.a(emotionImageData, clX(), clX().getPbData());
        }
    }

    public PostData F(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckZ() != null) {
            return eVar.ckZ();
        }
        if (!v.isEmpty(eVar.ckR())) {
            Iterator<PostData> it = eVar.ckR().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLv() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckW();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCr() != null && postData.aCr().getUserTbVipInfoData() != null && postData.aCr().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCr().getGodUserData().setIntro(postData.aCr().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckP() == null || eVar.ckP().aCr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCr = eVar.ckP().aCr();
        String userId = aCr.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckP().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCr;
        }
        postData.CE(1);
        postData.setId(eVar.ckP().aCH());
        postData.setTitle(eVar.ckP().getTitle());
        postData.setTime(eVar.ckP().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cnn() {
        ArrayList<PostData> ckR;
        int count;
        int i;
        if (clX() == null || clX().getPbData() == null || clX().getPbData().ckR() == null || (count = v.getCount((ckR = clX().getPbData().ckR()))) == 0) {
            return "";
        }
        if (clX().col()) {
            Iterator<PostData> it = ckR.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cLv() == 1) {
                    return next.getId();
                }
            }
        }
        if (bGV() == null) {
            i = 0;
        } else {
            i = ctp().cqf();
        }
        PostData postData = (PostData) v.getItem(ckR, i);
        if (postData == null || postData.aCr() == null) {
            return "";
        }
        if (clX().FW(postData.aCr().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(ckR, i2);
            if (postData2 == null || postData2.aCr() == null || postData2.aCr().getUserId() == null) {
                break;
            } else if (clX().FW(postData2.aCr().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(ckR, i3);
            if (postData3 == null || postData3.aCr() == null || postData3.aCr().getUserId() == null) {
                return "";
            }
            if (clX().FW(postData3.aCr().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnj() {
        if (clX() != null) {
            com.baidu.tieba.pb.data.e pbData = clX().getPbData();
            clX().qd(true);
            if (this.iJo != null) {
                pbData.FJ(this.iJo.ayN());
            }
            if (ctp() != null) {
                ctp().cua();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (clX() != null) {
            cqd();
            clX().qd(z);
            if (this.iJo != null) {
                this.iJo.fn(z);
                if (markData != null) {
                    this.iJo.a(markData);
                }
            }
            if (clX().ayO()) {
                cnj();
            } else if (ctp() != null) {
                ctp().cua();
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (clX() != null && clX().getPbData() != null && lVar.clB() != null) {
            String id = lVar.clB().getId();
            ArrayList<PostData> ckR = clX().getPbData().ckR();
            int i = 0;
            while (true) {
                if (i >= ckR.size()) {
                    break;
                }
                PostData postData = ckR.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clF = lVar.clF();
                    postData.CD(lVar.getTotalCount());
                    if (postData.cLs() != null && clF != null) {
                        Iterator<PostData> it = clF.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCr() != null && (metaData = postData.getUserMap().get(next.aCr().getUserId())) != null) {
                                next.a(metaData);
                                next.sU(true);
                                next.a(getPageContext(), clX().FW(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clF.size() != postData.cLs().size();
                        postData.cLs().clear();
                        postData.cLs().addAll(clF);
                        z = z2;
                    }
                    if (postData.cLo() != null) {
                        postData.cLp();
                    }
                }
            }
            if (!clX().getIsFromMark() && z && ctp() != null) {
                ctp().cua();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cna() {
        if (clX() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Ix(clX().getForumId()) && clX().getPbData() != null && clX().getPbData().getForum() != null) {
            if (clX().getPbData().getForum().isLike() == 1) {
                clX().coz().et(clX().getForumId(), clX().cnU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bj ckP = eVar.ckP();
            if (ckP != null && ckP.aEm()) {
                cnG();
            } else {
                d(this.iJC);
            }
            if (this.iJD != null) {
                qv(this.iJD.aPe());
                this.iJD.a(eVar.getAnti());
                this.iJD.a(eVar.getForum(), eVar.getUserData());
                this.iJD.setThreadData(ckP);
                if (clX() != null) {
                    this.iJD.a(clX().coj(), clX().cnU(), clX().coA());
                }
                if (ckP != null) {
                    this.iJD.gJ(ckP.aDK());
                }
            }
        }
    }

    public void cpG() {
        reset();
        cpC();
        this.iQP.cmF();
        qx(false);
    }

    private void reset() {
        if (this.iJD != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aOU().setStatus(0);
            this.iJD.aPo();
            this.iJD.aOI();
            if (this.iJD.getWriteImagesInfo() != null) {
                this.iJD.getWriteImagesInfo().setMaxImagesAllowed(this.iJD.isBJH ? 1 : 9);
            }
            this.iJD.mx(SendView.ALL);
            this.iJD.my(SendView.ALL);
            com.baidu.tbadk.editortools.g mo = this.FO.mo(23);
            com.baidu.tbadk.editortools.g mo2 = this.FO.mo(2);
            com.baidu.tbadk.editortools.g mo3 = this.FO.mo(5);
            if (mo2 != null) {
                mo2.display();
            }
            if (mo3 != null) {
                mo3.display();
            }
            if (mo != null) {
                mo.hide();
            }
            this.FO.invalidate();
        }
    }

    public void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null) {
            t(eVar);
            if (eVar.ayO()) {
                SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGG().a(this.iQm, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iQp.setText(zn(eVar.ckP().aCi()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.ckP()));
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aZ(eVar.ckP())) {
            if (this.iQo != null) {
                this.iQo.setEnable(false);
                this.iQo.onDestroy();
            }
            SvgManager.aGG().a(this.iQn, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iQo == null || !this.iQo.isEnable()) {
            SvgManager.aGG().a(this.iQn, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String zn(int i) {
        if (i == 0) {
            return getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    public void qx(boolean z) {
        if (this.iQk != null) {
            qv(this.iJD.aPe());
            if (this.iQg) {
                qm(z);
            } else {
                qn(z);
            }
            cth();
            cti();
        }
    }

    public void cqE() {
        if (this.iQk != null) {
            this.iQj.setVisibility(8);
            this.iQk.setVisibility(8);
            this.jat.jaL = false;
            cth();
            cti();
        }
    }

    private void cth() {
        if (this.jag != null) {
            if (this.jat.cty()) {
                this.jag.rW(false);
            } else {
                this.jag.rW(this.jag.bis() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cti() {
        if (this.jag != null && this.cYo != null) {
            if (this.cYo.getCurrentItem() != 0) {
                this.jag.rf(false);
            } else if (this.jat.cty()) {
                this.jag.rf(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.jag.rf(eVar.ctI() == null || eVar.ctI().getValue() == null || eVar.ctI().getValue().booleanValue());
                }
            }
        }
    }

    private void yX(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cnE(), cmY(), i);
    }

    private int cmY() {
        if (clX() == null || clX().getPbData() == null || clX().getPbData().ckP() == null) {
            return -1;
        }
        return clX().getPbData().ckP().aDb();
    }

    public void qv(boolean z) {
        this.iQg = z;
    }

    public void qm(boolean z) {
        if (this.iQk != null && this.hiz != null) {
            this.hiz.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iQk.startAnimation(alphaAnimation);
            }
            this.iQj.setVisibility(0);
            this.iQk.setVisibility(0);
            this.jat.jaL = true;
        }
    }

    public void qn(boolean z) {
        if (this.iQk != null && this.hiz != null) {
            this.hiz.setText(cpI());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iQk.startAnimation(alphaAnimation);
            }
            this.iQj.setVisibility(0);
            this.iQk.setVisibility(0);
            this.jat.jaL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.iEa = aVar;
            this.jal.setText(aVar.getTitle());
            this.jam.setText(aVar.cuf());
            String cug = aVar.cug();
            TBSpecificationBtn tBSpecificationBtn = this.jao;
            if (TextUtils.isEmpty(cug)) {
                cug = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cug);
            this.jap.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cx("obj_id", VideoPbFragment.this.iEa.getTitle()).cx("obj_name", VideoPbFragment.this.iEa.cuf()).X("obj_type", 2).cx("fid", VideoPbFragment.this.clX().getPbData().getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("tid", VideoPbFragment.this.clX().getPbData().getThreadId()));
                    VideoPbFragment.this.ctj();
                }
            }, aVar.cuh().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctj() {
        ViewGroup.LayoutParams layoutParams = this.jaj.getLayoutParams();
        if (layoutParams != null) {
            if (this.jaq == null || !this.jaq.isRunning()) {
                this.jaj.setAlpha(0.0f);
                this.jaj.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctk() {
        if (this.jaj.getLayoutParams() != null) {
            if (this.jaq == null || !this.jaq.isRunning()) {
                ctl();
            }
        }
    }

    private void ctl() {
        final ViewGroup.LayoutParams layoutParams = this.jaj.getLayoutParams();
        if (layoutParams != null) {
            if (this.jar == null || !this.jar.isRunning()) {
                this.jar = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jar.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.jaj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.jar.setDuration(200L);
                this.jar.start();
                this.jar.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.e(layoutParams);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.CD.getLayoutParams();
        final int i = layoutParams2.height;
        this.jaq = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jaq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hgT);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.hgT);
                VideoPbFragment.this.jaj.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.jaq.setDuration(300L);
        this.jaq.start();
        this.jaq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.jaj.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void f(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.CD.getLayoutParams();
        final int i = layoutParams2.height;
        this.jaq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jaq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hgT);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.jaj.setLayoutParams(layoutParams);
                VideoPbFragment.this.CD.setLayoutParams(layoutParams2);
            }
        });
        this.jaq.setDuration(300L);
        this.jaq.start();
        this.jaq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.ctm();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctm() {
        this.jaq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jaq.setDuration(300L);
        this.jaq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.jaj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.jaq.start();
    }

    public String cpI() {
        if (!aq.isEmpty(this.iRg)) {
            return this.iRg;
        }
        this.iRg = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.am.cpx());
        return this.iRg;
    }

    public void cqd() {
        hideProgressBar();
        if (ctp() != null) {
            ctp().endLoadData();
            ctp().cqe();
        }
    }

    public boolean ct(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.azR().isShowImages()) {
                    return FS(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (clX() == null || clX().getPbData() == null) {
                        return true;
                    }
                    if (this.iQP != null) {
                        this.iQP.cmF();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(clX().getPbData().getForum());
                    lVar.setThreadData(clX().getPbData().ckP());
                    lVar.f(postData);
                    this.iIL.d(lVar);
                    this.iIL.setPostId(postData.getId());
                    b(view, postData.aCr().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iJD != null) {
                        qv(this.iJD.aPe());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void ctn() {
        if (this.iJD != null) {
            qv(this.iJD.aPe());
        }
        cpG();
        this.jas.cqu();
    }

    private boolean FS(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void bWL() {
        if (this.iPS != null) {
            this.iPS.setVisibility(0);
        }
    }

    public void bWK() {
        if (this.iPS != null) {
            this.iPS.setVisibility(8);
        }
    }

    public void zD(int i) {
        if (this.jad != null) {
            this.jad.setVisibility(i);
        }
    }

    public void cqb() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cnd() {
        return this.iKp;
    }

    public void cpC() {
        if (this.FO != null) {
            this.FO.hide();
        }
    }

    public void bEv() {
        if (this.iIO.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iIO.getCurrentFocus());
        }
    }

    public void H(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null) {
            String valueOf = String.valueOf(eVar.ckP().aCi());
            if (eVar.ckP().aCi() == 0) {
                valueOf = "";
            }
            this.jab.wk(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.jac.ctz()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (clX() != null && clX().getPbData() != null && clX().getPbData().ckP() != null && clX().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(iQI)).intValue();
                if (intValue == iQJ) {
                    if (!this.fLt.cMj()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fLt.Jh(aq.O(jSONArray));
                        }
                        this.fLt.a(clX().getPbData().getForum().getId(), clX().getPbData().getForum().getName(), clX().getPbData().ckP().getId(), str, intValue3, intValue2, booleanValue, clX().getPbData().ckP().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == iQK || intValue == iQM) {
                    if (clX().cow() != null) {
                        clX().cow().yQ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == iQK) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUE() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUF() {
        if (this.dMQ == null) {
            this.dMQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azR().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.azR().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.dMQ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUG() {
        if (this.dPF == null) {
            this.dPF = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUH() {
        if (this.dMR == null) {
            this.dMR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bHp */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.azR().isShowImages();
                    gifView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (i.azR().isShowImages()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.aPT();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMR;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUI() {
        if (this.dPG == null) {
            this.dPG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnH */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cw */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cMC();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dPG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUJ() {
        if (this.dPH == null) {
            this.dPH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnJ */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(VideoPbFragment.this.getPageContext().getPageActivity());
                    linearLayout.setId(R.id.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.dPH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUK() {
        this.dPI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnI */
            public RelativeLayout makeObject() {
                return new RelativeLayout(VideoPbFragment.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.dPI;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (as.Gi(str) && clX() != null && clX().cnU() != null) {
            TiebaStatic.log(new an("c11664").X("obj_param1", 1).cx("post_id", clX().cnU()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dwd = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqX().c(getPageContext(), str);
        }
        this.iIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqX().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.jas.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b ctS = this.jas.ctS();
            if (ctS == null) {
                this.jas.cmT();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                ctS.getItemView(1).setVisibility(8);
            } else {
                ctS.getItemView(1).setVisibility(0);
            }
            ctS.aEH();
            this.iIZ = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aGK().b(getPageContext(), new String[]{str});
            this.iIZ = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cto() {
        return this.dap;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener aSu() {
        return this.dsa;
    }

    public ReplyFragment ctp() {
        if (this.jac == null || !(this.jac.zE(iZZ) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.jac.zE(iZZ);
    }

    public DetailInfoFragment ctq() {
        if (this.jac == null || !(this.jac.zE(iZY) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.jac.zE(iZY);
    }

    public boolean clN() {
        PbModel clX = this.iIO.clX();
        if (clX == null) {
            return false;
        }
        return clX.clN();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckY;
        PbModel clX = this.iIO.clX();
        if (clX != null && clX.getPbData() != null && !clX.getPbData().cln()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = clX.getPbData().ckP().getId();
            if (clX.isShareThread() && clX.getPbData().ckP().cUe != null) {
                historyMessage.threadName = clX.getPbData().ckP().cUe.showText;
            } else {
                historyMessage.threadName = clX.getPbData().ckP().getTitle();
            }
            if (clX.isShareThread() && !clN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = clX.getPbData().getForum().getName();
            }
            ArrayList<PostData> ckR = clX.getPbData().ckR();
            int cqf = ctp() != null ? ctp().cqf() : 0;
            if (ckR != null && cqf >= 0 && cqf < ckR.size()) {
                historyMessage.postID = ckR.get(cqf).getId();
            }
            historyMessage.isHostOnly = clX.getHostMode();
            historyMessage.isSquence = clX.cnV();
            historyMessage.isShareThread = clX.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iJD != null) {
            this.iJD.onDestroy();
        }
        if (clX != null && (clX.cnW() || clX.cnY())) {
            Intent intent = new Intent();
            intent.putExtra("tid", clX.cnU());
            if (this.iJr) {
                if (this.iJt) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", clX.bxW());
                }
                if (this.iJs) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", clX.getIsGood());
                }
            }
            if (clX.getPbData() != null && System.currentTimeMillis() - this.iIV >= 40000 && (ckY = clX.getPbData().ckY()) != null && !v.isEmpty(ckY.getDataList())) {
                intent.putExtra("guess_like_data", ckY);
            }
            PbActivity pbActivity = this.iIO;
            PbActivity pbActivity2 = this.iIO;
            pbActivity.setResult(-1, intent);
        }
        if (cnk()) {
            if (clX != null) {
                com.baidu.tieba.pb.data.e pbData = clX.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.iJb) {
                        if (this.jaf != null) {
                            Rect rect = new Rect();
                            this.jaf.getGlobalVisibleRect(rect);
                            ah.cpm().h(rect);
                        }
                        ah.cpm().zj(this.cYo.getCurrentItem());
                        BdTypeRecyclerView bGV = bGV();
                        Parcelable parcelable = null;
                        if (bGV != null) {
                            parcelable = bGV.onSaveInstanceState();
                        }
                        ah.cpm().a(clX.cod(), parcelable, clX.cnV(), clX.getHostMode(), false);
                    }
                }
            } else {
                ah.cpm().reset();
            }
            cmk();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.jag != null && !this.jag.bis()) {
            if ((this.jag.isFullScreen() && configuration.orientation == 1) || (!this.jag.isFullScreen() && configuration.orientation == 2)) {
                this.jag.rg(false);
            }
        }
    }

    public boolean ctr() {
        if (this.jag == null) {
            return false;
        }
        return this.jag.bis();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean jaL;
        public boolean jaM;

        private a() {
            this.jaM = true;
        }

        public boolean cty() {
            return (this.jaL && this.jaM) ? false : true;
        }
    }

    public void cts() {
        this.iJj = -1;
        this.iJk = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnA() {
        if (clX() != null && !aq.isEmpty(clX().cnU())) {
            com.baidu.tbadk.BdToken.c.axC().o(com.baidu.tbadk.BdToken.b.cGX, com.baidu.adp.lib.f.b.toLong(clX().cnU(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.jae.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctt() {
        if (this.jaC == null) {
            this.jaC = ObjectAnimator.ofFloat(this.jai, "alpha", 0.0f, 1.0f);
            this.jaC.setDuration(200L);
        }
        this.jaC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctu() {
        if (this.jaD == null) {
            this.jaD = ObjectAnimator.ofFloat(this.jai, "alpha", 1.0f, 0.0f);
            this.jaD.setDuration(200L);
        }
        this.jaD.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctv() {
        return this.jag != null && this.jag.ctw();
    }

    public boolean ctw() {
        return this.jaz;
    }

    public void qY(boolean z) {
        this.jaz = z;
    }
}
