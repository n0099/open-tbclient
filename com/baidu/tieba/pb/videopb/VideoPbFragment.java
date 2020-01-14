package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.z;
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
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.pb.pb.main.t;
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
/* loaded from: classes7.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Ck;
    private EditorTools Fv;
    private ImageView KG;
    private CustomViewPager cTX;
    public View dBI;
    private com.baidu.adp.lib.d.b<ImageView> dIh;
    private com.baidu.adp.lib.d.b<GifView> dIi;
    private com.baidu.adp.lib.d.b<TextView> dKV;
    private com.baidu.adp.lib.d.b<View> dKW;
    private com.baidu.adp.lib.d.b<LinearLayout> dKX;
    private com.baidu.adp.lib.d.b<RelativeLayout> dKY;
    private ImageView eAe;
    private VoiceManager gmi;
    private com.baidu.tieba.frs.profession.permission.c gpJ;
    private com.baidu.tieba.f.b gql;
    public aj hNy;
    private com.baidu.tieba.pb.videopb.c.a iAv;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iFM;
    int iFP;
    private PbFakeFloorModel iFs;
    private PbActivity iFv;
    public as iGb;
    private g iGj;
    private com.baidu.tbadk.editortools.pb.e iGk;
    private com.baidu.tieba.frs.profession.permission.c iGm;
    private EmotionImageData iGn;
    private com.baidu.tbadk.core.view.d iGr;
    private View iMJ;
    private t iNF;
    private String iNW;
    private View iNa;
    private ImageView iNc;
    private ImageView iNd;
    private ImageView iNe;
    private TextView iNf;
    private int iNh;
    private int iNi;
    public View iSr;
    private NewPagerSlidingTabBaseStrip iWX;
    private VideoPbFragmentAdapter iWY;
    private View iWZ;
    private View iXa;
    private VideoContainerLayout iXb;
    private com.baidu.tieba.pb.videopb.videoView.a iXc;
    private f iXd;
    private View iXe;
    private TextView iXg;
    private TextView iXh;
    private ImageView iXi;
    private TBSpecificationBtn iXj;
    private TbImageView iXk;
    private ValueAnimator iXl;
    private ValueAnimator iXm;
    public com.baidu.tieba.pb.videopb.b.a iXn;
    public NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int iWU = 0;
    public static int iWV = 1;
    public static int iNx = 3;
    public static int iNy = 0;
    public static int iNz = 3;
    public static int iNA = 4;
    public static int iNB = 5;
    public static int iNC = 6;
    private static final int hdi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int iWW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a iHh = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // com.baidu.tieba.f.b.a
        public void bc(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cjP();
            } else {
                com.baidu.tieba.pb.a.b.cjO();
            }
        }
    };
    private long iFC = 0;
    View.OnClickListener iXf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.iAv != null) {
                TiebaStatic.log(new an("c13590").cp("obj_id", VideoPbFragment.this.iAv.getTitle()).cp("obj_name", VideoPbFragment.this.iAv.cso()).Z("obj_type", 2).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("tid", VideoPbFragment.this.ckc().getPbData().getThreadId()));
                String link = VideoPbFragment.this.iAv.getLink();
                if (!TextUtils.isEmpty(link)) {
                    if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                        ba.aEt().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a iFV = null;
    private com.baidu.tbadk.coreExtra.model.a cVY = null;
    private ForumManageModel fHZ = null;
    private boolean iFG = false;
    private View iNb = null;
    private TextView heK = null;
    private boolean iMX = false;
    private String duj = null;
    private boolean iFY = false;
    private boolean iFZ = false;
    private boolean iGa = false;
    private boolean iFI = false;
    int[] iFO = new int[2];
    private int iFQ = -1;
    private int iFR = Integer.MIN_VALUE;
    private int iGx = 0;
    private int iXp = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private final PbModel.a iGX = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.g lU;
            VideoPbFragment.this.coo();
            VideoPbFragment.this.bUO();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.qo(false);
            if (z && fVar != null) {
                bj ciS = fVar.ciS();
                if (ciS == null || !ciS.aBV()) {
                    VideoPbFragment.this.d(VideoPbFragment.this.iGj);
                } else {
                    VideoPbFragment.this.clO();
                }
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                com.baidu.tieba.pb.videopb.c.a cju = fVar.cju();
                if (cju != null) {
                    VideoPbFragment.this.a(cju);
                }
                VideoPbFragment.this.F(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                if (VideoPbFragment.this.iGk != null) {
                    VideoPbFragment.this.qm(VideoPbFragment.this.iGk.aMB());
                }
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.iGk != null) {
                    VideoPbFragment.this.iGk.a(fVar.getAnti());
                    VideoPbFragment.this.iGk.a(fVar.getForum(), fVar.getUserData());
                    VideoPbFragment.this.iGk.setThreadData(ciS);
                    if (VideoPbFragment.this.ckc() != null) {
                        VideoPbFragment.this.iGk.a(VideoPbFragment.this.ckc().cmr(), VideoPbFragment.this.ckc().cmc(), VideoPbFragment.this.ckc().cmL());
                    }
                    if (ciS != null) {
                        VideoPbFragment.this.iGk.gB(ciS.aBr());
                    }
                }
                if (VideoPbFragment.this.iFV != null) {
                    VideoPbFragment.this.iFV.ff(fVar.aww());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.duj = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.duj) && VideoPbFragment.this.iGk != null && VideoPbFragment.this.iGk.aLV() != null && (lU = VideoPbFragment.this.iGk.aLV().lU(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.duj)) {
                        ((View) lU).setOnClickListener(VideoPbFragment.this.duU);
                    }
                }
                if (VideoPbFragment.this.hNy != null && ciS != null && ciS.azX() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(ciS.azX());
                    VideoPbFragment.this.hNy.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.ckc().cmc());
                        jSONObject.put("fid", VideoPbFragment.this.ckc().getForumId());
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
                if (VideoPbFragment.this.crC() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                            arrayList = VideoPbFragment.this.ckc().getPbData().ciU();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cJz() == 1)) {
                            if (VideoPbFragment.this.crC().clG()) {
                                VideoPbFragment.this.crC().FO(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.crC().FO(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.crC().FN(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.crC().FN("");
                    }
                    VideoPbFragment.this.crC().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.r.c.cIu().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0364a iGZ = new a.InterfaceC0364a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0364a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.coo();
            if (z && VideoPbFragment.this.ckc() != null) {
                if (VideoPbFragment.this.iFV != null) {
                    VideoPbFragment.this.iFV.ff(z2);
                }
                VideoPbFragment.this.ckc().pU(z2);
                if (VideoPbFragment.this.ckc().aww()) {
                    VideoPbFragment.this.clr();
                } else if (VideoPbFragment.this.crC() != null) {
                    VideoPbFragment.this.crC().csj();
                }
                if (z2) {
                    if (VideoPbFragment.this.iFV != null) {
                        if (VideoPbFragment.this.iFV.awz() != null && VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.ckc().getPbData().ciS() != null && VideoPbFragment.this.ckc().getPbData().ciS().azX() != null) {
                            MarkData awz = VideoPbFragment.this.iFV.awz();
                            MetaData azX = VideoPbFragment.this.ckc().getPbData().ciS().azX();
                            if (awz != null && azX != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), azX.getUserId()) && !azX.hadConcerned()) {
                                    VideoPbFragment.this.iXn.b(azX);
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
                    VideoPbFragment.this.clo();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b dun = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aMs() {
            if (VideoPbFragment.this.iGb == null || VideoPbFragment.this.iGb.cpd() == null || !VideoPbFragment.this.iGb.cpd().cSO()) {
                return !VideoPbFragment.this.yG(aj.cVT);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iGb.cpd().cSQ());
            if (VideoPbFragment.this.iGk != null && (VideoPbFragment.this.iGk.aMI() || VideoPbFragment.this.iGk.aMJ())) {
                VideoPbFragment.this.iGk.a(false, VideoPbFragment.this.iGb.cpg());
            }
            VideoPbFragment.this.iGb.qt(true);
            return true;
        }
    };
    private final CustomMessageListener iGE = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.ckc() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.iGk != null) {
                    VideoPbFragment.this.qm(VideoPbFragment.this.iGk.aMB());
                }
                VideoPbFragment.this.cnR();
                VideoPbFragment.this.iXn.coF();
            }
        }
    };
    private CustomMessageListener iGH = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.f fVar = (com.baidu.tieba.pb.f) customResponsedMessage.getData();
                switch (fVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((m) fVar.getData());
                        return;
                    case 1:
                        VideoPbFragment.this.a((ForumManageModel.b) fVar.getData(), false);
                        return;
                    case 2:
                        if (fVar.getData() == null) {
                            VideoPbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            VideoPbFragment.this.a(true, (MarkData) fVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private final CustomMessageListener gnu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.clI();
            }
        }
    };
    private CustomMessageListener iGY = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.clh();
            }
        }
    };
    private CustomMessageListener iGT = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.iXn != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iXn.iGs) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.iXn.boJ();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.iXn.getExtra();
                DataRes dataRes = aVar.ktH;
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
                    VideoPbFragment.this.iXn.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.iXn.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener iGR = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iXn != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iXn.iGs) {
                VideoPbFragment.this.iXn.boJ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.ckc().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cjf().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iGr.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.iXn.uZ(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.iXn.clF();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.iGr.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iGS = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.iXn != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.iXn.iGs) {
                VideoPbFragment.this.iXn.boJ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.iGr.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.iGr.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b iGp = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aMs() {
            if (VideoPbFragment.this.iGb == null || VideoPbFragment.this.iGb.cpe() == null || !VideoPbFragment.this.iGb.cpe().cSO()) {
                return !VideoPbFragment.this.yG(aj.cVU);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.iGb.cpe().cSQ());
            if (VideoPbFragment.this.iNF != null && VideoPbFragment.this.iNF.ckR() != null && VideoPbFragment.this.iNF.ckR().aMJ()) {
                VideoPbFragment.this.iNF.ckR().a(VideoPbFragment.this.iGb.cpg());
            }
            VideoPbFragment.this.iGb.qu(true);
            return true;
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                    anVar.cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId());
                }
                anVar.cp("tid", VideoPbFragment.this.ckc().cmc());
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bCF();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.ckc() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.ckc().FJ(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.crC() != null) {
                        VideoPbFragment.this.iGx = VideoPbFragment.this.crC().coq();
                        VideoPbFragment.this.iXp = VideoPbFragment.this.crC().csm();
                        VideoPbFragment.this.ckc().cq(VideoPbFragment.this.iGx, VideoPbFragment.this.iXp);
                    }
                }
                if (VideoPbFragment.this.cTX != null) {
                    VideoPbFragment.this.cTX.setCurrentItem(VideoPbFragment.iWV);
                }
                VideoPbFragment.this.iXn.coF();
                VideoPbFragment.this.iGb.cpc();
                if (VideoPbFragment.this.iGk != null) {
                    VideoPbFragment.this.qm(VideoPbFragment.this.iGk.aMB());
                }
                VideoPbFragment.this.cnN();
                VideoPbFragment.this.qo(true);
                VideoPbFragment.this.ckc().cmx();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.crC() != null) {
                            VideoPbFragment.this.crC().csj();
                        }
                    } else if (VideoPbFragment.this.ckc().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.ckc().getPbData();
                        if (pbData != null && pbData.ciS() != null && pbData.ciS().azX() != null && (userId = pbData.ciS().azX().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.ckc().cmn()) {
                            VideoPbFragment.this.com();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.ckc().cmn()) {
                        VideoPbFragment.this.com();
                    }
                    VideoPbFragment.this.clg();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.iGk.aMI() || VideoPbFragment.this.iGk.aMJ()) {
                    VideoPbFragment.this.iGk.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.iGb.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.hNy != null) {
                    VideoPbFragment.this.hNy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (zVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener duU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.duj);
        }
    };
    private CustomMessageListener iGG = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.iGk != null) {
                    VideoPbFragment.this.qm(VideoPbFragment.this.iGk.aMB());
                }
                VideoPbFragment.this.qo(false);
            }
        }
    };
    private final com.baidu.adp.base.d fIe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.ckc() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.fHZ.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.fHZ.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.ckc().cmx();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.iUh != 1002 || bVar.eHK) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.kif, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.fHZ.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.fHZ.getLoadDataMode(), gVar.mSuccess, gVar.kif, false);
                    VideoPbFragment.this.iXn.aM(gVar.kii);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.gql.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d iGV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                    anVar.cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId());
                }
                if (VideoPbFragment.this.ckc() != null) {
                    anVar.cp("tid", VideoPbFragment.this.ckc().cmc());
                }
                anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.iGb != null) {
                    VideoPbFragment.this.iGb.cpb();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.hNy != null) {
                    VideoPbFragment.this.hNy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.iGb != null) {
                if (VideoPbFragment.this.iNF != null && VideoPbFragment.this.iNF.ckR() != null && VideoPbFragment.this.iNF.ckR().aMJ()) {
                    VideoPbFragment.this.iNF.ckR().a(postWriteCallBackData);
                }
                VideoPbFragment.this.iGb.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dum = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aMt() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener arL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean u;
            int i2 = 2;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cp("tid", VideoPbFragment.this.ckc().cmc());
                    anVar.cp("fid", VideoPbFragment.this.ckc().getForumId());
                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.Z("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.iFG) {
                        VideoPbFragment.this.iFG = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.iFs != null && postData.azX() != null && postData.cJz() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.iNF != null) {
                                    VideoPbFragment.this.iNF.ckN();
                                }
                                m mVar = new m();
                                mVar.a(VideoPbFragment.this.ckc().getPbData().getForum());
                                mVar.setThreadData(VideoPbFragment.this.ckc().getPbData().ciS());
                                mVar.f(postData);
                                VideoPbFragment.this.iFs.d(mVar);
                                VideoPbFragment.this.iFs.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.azX().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.ckc().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.iGk != null) {
                                    VideoPbFragment.this.qm(VideoPbFragment.this.iGk.aMB());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.crC() != null && VideoPbFragment.this.crC().coB() != null && view == VideoPbFragment.this.crC().coB()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.ckc().pS(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.crC().con();
                    }
                } else if (VideoPbFragment.this.iXn != null && VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnm()) {
                    VideoPbFragment.this.iXn.apF();
                } else if (VideoPbFragment.this.iXn != null && ((VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnn()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.iXn.coF();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bCF();
                        VideoPbFragment.this.com();
                        if (view.getId() == R.id.owner_reply) {
                            u = VideoPbFragment.this.ckc().u(true, VideoPbFragment.this.clv());
                        } else {
                            u = view.getId() == R.id.all_reply ? VideoPbFragment.this.ckc().u(false, VideoPbFragment.this.clv()) : VideoPbFragment.this.ckc().FG(VideoPbFragment.this.clv());
                        }
                        view.setTag(Boolean.valueOf(u));
                        if (u) {
                            VideoPbFragment.this.bUP();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.dBI) {
                    if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId());
                            anVar2.cp("tid", VideoPbFragment.this.ckc().cmc());
                            anVar2.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.iFv, VideoPbFragment.this.dBI);
                        VideoPbFragment.this.iFv.finish();
                    }
                } else if (view == VideoPbFragment.this.iSr && VideoPbFragment.this.iXn != null) {
                    if (VideoPbFragment.this.ckc() == null || VideoPbFragment.this.ckc().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> ciU = VideoPbFragment.this.ckc().getPbData().ciU();
                    if ((ciU == null || ciU.size() <= 0) && VideoPbFragment.this.ckc().cmd()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cp("tid", VideoPbFragment.this.ckc().cmc()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", VideoPbFragment.this.ckc().getForumId()));
                    VideoPbFragment.this.iXn.clj();
                } else if (VideoPbFragment.this.iXn != null && VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnn()) {
                    VideoPbFragment.this.iXn.apF();
                } else if (VideoPbFragment.this.iXn != null && ((VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnt()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.iXn.coF();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bCF();
                            VideoPbFragment.this.com();
                            VideoPbFragment.this.iXn.cH(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.ckc().cmv()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.iXn != null && VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnl()) {
                    if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.ckc().getPbData().ciS() != null) {
                        VideoPbFragment.this.iXn.apF();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.iXn.FA(VideoPbFragment.this.ckc().getPbData().ciS().aAn());
                    }
                } else if (VideoPbFragment.this.iXn != null && VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnu()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.s(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 0).Z("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).Z("obj_type", 1).Z("obj_source", 1));
                    }
                    VideoPbFragment.this.iXn.cpH();
                } else if (VideoPbFragment.this.iXn != null && (view == VideoPbFragment.this.iXn.cok() || (VideoPbFragment.this.iXn.cpI() != null && (view == VideoPbFragment.this.iXn.cpI().cnq() || view == VideoPbFragment.this.iXn.cpI().cno())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.ckc() != null || VideoPbFragment.this.ckc().getPbData() != null) {
                        if ((VideoPbFragment.this.ckc().getPbData().cje() == 1 || VideoPbFragment.this.ckc().getPbData().cje() == 3) && !VideoPbFragment.this.fHZ.cKo()) {
                            VideoPbFragment.this.iXn.coF();
                            if (VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cno()) {
                                if (VideoPbFragment.this.ckc().getPbData().ciS().azS() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnq()) {
                                i = VideoPbFragment.this.ckc().getPbData().ciS().azT() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.iXn.cok() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.ckc().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.ckc().getPbData().ciS().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.fHZ.b(id, name, id2, i, VideoPbFragment.this.iXn.col());
                        }
                    }
                } else if (VideoPbFragment.this.iXn != null && VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cns()) {
                    if (VideoPbFragment.this.ckc() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.iXn.coF();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.ckc().getPbData(), VideoPbFragment.this.ckc().cmd(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.ckc().getPbData().getForum().getId(), VideoPbFragment.this.ckc().getPbData().getForum().getName(), VideoPbFragment.this.ckc().getPbData().ciS().getId(), String.valueOf(VideoPbFragment.this.ckc().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.iXn != null && VideoPbFragment.this.iXn.cpI() != null && view == VideoPbFragment.this.iXn.cpI().cnp()) {
                    if (VideoPbFragment.this.ckc() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.ckc().getPbData(), VideoPbFragment.this.ckc().cmd(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.iXn.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.iXn.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.iXn.apF();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cp("tid", VideoPbFragment.this.ckc().cmc());
                        anVar3.cp("fid", VideoPbFragment.this.ckc().getForumId());
                        anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.Z("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").Z("obj_locate", 3).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                        if (VideoPbFragment.this.iXn != null) {
                            VideoPbFragment.this.iXn.coF();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cJL() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.kgo != null) {
                                an aEl = postData2.kgo.aEl();
                                aEl.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aEl.Z("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aEl.Z("obj_locate", 8);
                                }
                                TiebaStatic.log(aEl);
                            }
                            String cmc = VideoPbFragment.this.ckc().cmc();
                            String id3 = postData2.getId();
                            int cje = VideoPbFragment.this.ckc().getPbData() != null ? VideoPbFragment.this.ckc().getPbData().cje() : 0;
                            VideoPbFragment.this.bCF();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.crC() != null && VideoPbFragment.this.crC().csl() != null) {
                                PbActivity.a FE = VideoPbFragment.this.crC().csl().FE(id3);
                                if (postData2 != null && VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null && FE != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cmc, id3, "pb", true, null, false, null, cje, postData2.cqG(), VideoPbFragment.this.ckc().getPbData().getAnti(), false, postData2.azX().getIconInfo()).addBigImageData(FE.iCC, FE.iCD, FE.iCE, FE.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.ckc().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.ckc().cmk());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.ckc().cmO());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.ckc().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.ckc() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cp("tid", VideoPbFragment.this.ckc().cmc());
                        anVar4.cp("fid", VideoPbFragment.this.ckc().getForumId());
                        anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.Z("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (postData3.kgo != null) {
                                    an aEl2 = postData3.kgo.aEl();
                                    aEl2.delete("obj_locate");
                                    aEl2.Z("obj_locate", 8);
                                    TiebaStatic.log(aEl2);
                                }
                                if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.iFs != null && postData3.azX() != null && postData3.cJz() != 1) {
                                    if (VideoPbFragment.this.iNF != null) {
                                        VideoPbFragment.this.iNF.ckN();
                                    }
                                    m mVar2 = new m();
                                    mVar2.a(VideoPbFragment.this.ckc().getPbData().getForum());
                                    mVar2.setThreadData(VideoPbFragment.this.ckc().getPbData().ciS());
                                    mVar2.f(postData3);
                                    VideoPbFragment.this.iFs.d(mVar2);
                                    VideoPbFragment.this.iFs.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.azX().getUserId(), "");
                                    if (VideoPbFragment.this.iGk != null) {
                                        VideoPbFragment.this.qm(VideoPbFragment.this.iGk.aMB());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.iXn != null && VideoPbFragment.this.ckc() != null && VideoPbFragment.this.crC() != null) {
                        VideoPbFragment.this.iXn.coF();
                        if (VideoPbFragment.this.yH(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.ckc() != null) {
                            VideoPbFragment.this.clq();
                            if (VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.ckc().getPbData().ciS() != null && VideoPbFragment.this.ckc().getPbData().ciS().azX() != null) {
                                TiebaStatic.log(new an("c13402").cp("tid", VideoPbFragment.this.ckc().cmc()).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()).Z("obj_locate", 3).cp("uid", VideoPbFragment.this.ckc().getPbData().ciS().azX().getUserId()));
                            }
                            if (VideoPbFragment.this.ckc().getPbData().ciS() != null && VideoPbFragment.this.ckc().getPbData().ciS().azX() != null && VideoPbFragment.this.ckc().getPbData().ciS().azX().getUserId() != null && VideoPbFragment.this.iFV != null) {
                                int g = VideoPbFragment.this.iXn.g(VideoPbFragment.this.ckc().getPbData());
                                bj ciS = VideoPbFragment.this.ckc().getPbData().ciS();
                                if (!ciS.ayL()) {
                                    if (ciS.aBS()) {
                                        i2 = 3;
                                    } else if (ciS.aBT()) {
                                        i2 = 4;
                                    } else {
                                        i2 = ciS.aBU() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cp("tid", VideoPbFragment.this.ckc().cmc()).Z("obj_locate", 1).cp("obj_id", VideoPbFragment.this.ckc().getPbData().ciS().azX().getUserId()).Z("obj_type", VideoPbFragment.this.iFV.aww() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.crh();
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.iXn != null && VideoPbFragment.this.cTX != null && VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.ckc().getPbData().ciS() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.ckc().getPbData().ciS().azO() != 0) {
                            int currentItem = VideoPbFragment.this.cTX.getCurrentItem();
                            if (currentItem == VideoPbFragment.iWU) {
                                VideoPbFragment.this.cTX.setCurrentItem(VideoPbFragment.iWV);
                            } else if (currentItem == VideoPbFragment.iWV) {
                                if (VideoPbFragment.this.crC() != null && VideoPbFragment.this.bFb() != null) {
                                    an cp = new an("c13403").cp("tid", VideoPbFragment.this.ckc().cmc()).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bFb = VideoPbFragment.this.bFb();
                                    boolean canScrollVertically = bFb.canScrollVertically(1);
                                    boolean canScrollVertically2 = bFb.canScrollVertically(-1);
                                    if (VideoPbFragment.this.Ck != null) {
                                        VideoPbFragment.this.Ck.setExpanded(false, true);
                                    }
                                    if (bFb.getLayoutManager() != null && (bFb.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bFb.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.iFQ != -1 || VideoPbFragment.this.iFR != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.iFQ > 3 || (VideoPbFragment.this.iFQ == 3 && VideoPbFragment.this.iFR < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iFQ, VideoPbFragment.this.iFR + equipmentHeight);
                                                    bFb.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.iFQ >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iFQ, VideoPbFragment.this.iFR + (equipmentHeight / 2));
                                                    bFb.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.iFQ == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.iFQ, VideoPbFragment.this.iFR + (equipmentHeight / 4));
                                                    bFb.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bFb.smoothScrollBy(0, -VideoPbFragment.this.iFR);
                                                }
                                                cp.Z("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bFb.getFirstVisiblePosition();
                                            View childAt = bFb.getChildAt(0);
                                            int top = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.iFQ = firstVisiblePosition;
                                            VideoPbFragment.this.iFR = top;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && bFb.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bFb.smoothScrollToPosition(0);
                                            } else {
                                                bFb.smoothScrollToPosition(0);
                                            }
                                            cp.Z("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cp);
                                        TiebaStatic.log(new an("c12942").Z("obj_type", 1).Z("obj_locate", 4).cp("tid", VideoPbFragment.this.ckc().cmc()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.ckc().getPbData().ciS() != null && VideoPbFragment.this.ckc().getPbData().ciS().azX() != null) {
                                TiebaStatic.log(new an("c13402").cp("tid", VideoPbFragment.this.ckc().cmc()).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()).Z("obj_locate", 2).cp("uid", VideoPbFragment.this.ckc().getPbData().ciS().azX().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.qO(false);
                        VideoPbFragment.this.clc();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.iGx >= 0) {
                        if (VideoPbFragment.this.ckc() != null) {
                            VideoPbFragment.this.ckc().cmP();
                        }
                        if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.crC() != null && VideoPbFragment.this.crC().csk() != null) {
                            VideoPbFragment.this.crC().csk().setData(VideoPbFragment.this.ckc().getPbData());
                        }
                        VideoPbFragment.this.iGx = 0;
                        VideoPbFragment.this.iXp = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.crC() != null) {
                            VideoPbFragment.this.crC().ct(VideoPbFragment.this.ckc().cmS(), VideoPbFragment.this.ckc().cmT());
                            VideoPbFragment.this.ckc().cq(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.ckc() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cp("tid", VideoPbFragment.this.ckc().cmc());
                        anVar5.cp("fid", VideoPbFragment.this.ckc().getForumId());
                        anVar5.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.Z("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aDr().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cnR();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cnR();
                }
            }
        }
    };
    private View.OnClickListener iDj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.iXn != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.iXn.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.iXn.cB(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.iXn.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.iXn.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a iXo = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void clo() {
        if (ckc() != null && ckc().getPbData() != null && ckc().getPbData().ciS() != null) {
            bj ciS = ckc().getPbData().ciS();
            ciS.mRecomAbTag = ckc().cmZ();
            ciS.mRecomWeight = ckc().cmX();
            ciS.mRecomSource = ckc().cmY();
            ciS.mRecomExtra = ckc().cna();
            if (ciS.getFid() == 0) {
                ciS.setFid(com.baidu.adp.lib.f.b.toLong(ckc().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ciS, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clg() {
        if (ckc() != null && ckc().getPbData() != null && ckc().getPbData().ciS() != null) {
            bj ciS = ckc().getPbData().ciS();
            ciS.mRecomAbTag = ckc().cmZ();
            ciS.mRecomWeight = ckc().cmX();
            ciS.mRecomSource = ckc().cmY();
            ciS.mRecomExtra = ckc().cna();
            if (ciS.getFid() == 0) {
                ciS.setFid(com.baidu.adp.lib.f.b.toLong(ckc().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ciS, "c13563");
            if (a2 != null) {
                a2.Z("reply_type", 1);
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
            String string = !TextUtils.isEmpty(bVar.kif) ? bVar.kif : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sC(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fz(true);
                aVar.b(getPageContext());
                aVar.aCp();
            } else {
                a(0, bVar.mSuccess, bVar.kif, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fVU == 1) {
                    ArrayList<PostData> ciU = ckc().getPbData().ciU();
                    int size = ciU.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ciU.get(i).getId())) {
                            i++;
                        } else {
                            ciU.remove(i);
                            break;
                        }
                    }
                    ckc().getPbData().ciS().js(ckc().getPbData().ciS().azO() - 1);
                    if (crC() != null) {
                        crC().csj();
                    }
                } else if (bVar.fVU == 0) {
                    clp();
                } else if (bVar.fVU == 2) {
                    ArrayList<PostData> ciU2 = ckc().getPbData().ciU();
                    int size2 = ciU2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ciU2.get(i2).cJw().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ciU2.get(i2).cJw().get(i3).getId())) {
                                i3++;
                            } else {
                                ciU2.get(i2).cJw().remove(i3);
                                ciU2.get(i2).cJy();
                                z2 = true;
                                break;
                            }
                        }
                        ciU2.get(i2).IN(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && crC() != null) {
                        crC().csj();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = ckc().getPbData().cjd().iAX;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cJw().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cJw().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cJw().remove(i2);
                    list.get(i).cJy();
                    z = true;
                    break;
                }
            }
            list.get(i).IN(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && crC() != null) {
            crC().csj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && ckc() != null && ckc().getPbData() != null && ckc().getPbData().ciS() != null) {
            a(this.fHZ.getLoadDataMode(), gVar.mSuccess, gVar.kif, false);
            if (gVar.mSuccess) {
                this.iFY = true;
                if (i == 2 || i == 3) {
                    this.iFZ = true;
                    this.iGa = false;
                } else if (i == 4 || i == 5) {
                    this.iFZ = false;
                    this.iGa = true;
                }
                if (i == 2) {
                    ckc().getPbData().ciS().jv(1);
                    ckc().setIsGood(1);
                } else if (i == 3) {
                    ckc().getPbData().ciS().jv(0);
                    ckc().setIsGood(0);
                } else if (i == 4) {
                    ckc().getPbData().ciS().ju(1);
                    ckc().yK(1);
                } else if (i == 5) {
                    ckc().getPbData().ciS().ju(0);
                    ckc().yK(0);
                }
            }
            if (ckc().getPbData().ciS() != null && crD() != null) {
                crD().csg();
            }
        }
    }

    private void clp() {
        if (ckc().cme() || ckc().cmg()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", ckc().cmc());
            PbActivity pbActivity = this.iFv;
            PbActivity pbActivity2 = this.iFv;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ckc().cmc()));
        if (cls()) {
            this.iFv.finish();
        }
    }

    private boolean cls() {
        if (ckc() == null) {
            return true;
        }
        if (ckc().getPbData() == null || !ckc().getPbData().cjs()) {
            if (ckc().aww()) {
                final MarkData cmw = ckc().cmw();
                if (cmw == null || !ckc().getIsFromMark() || bFb() == null) {
                    return true;
                }
                final MarkData yR = ckc().yR(bFb().getFirstVisiblePosition());
                if (yR == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cmw);
                    this.iFv.setResult(-1, intent);
                    return true;
                } else if (yR.getPostId() == null || yR.getPostId().equals(cmw.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cmw);
                    this.iFv.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.sC(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.iFV != null) {
                                if (VideoPbFragment.this.iFV.aww()) {
                                    VideoPbFragment.this.iFV.awx();
                                    VideoPbFragment.this.iFV.ff(false);
                                }
                                VideoPbFragment.this.iFV.a(yR);
                                VideoPbFragment.this.iFV.ff(true);
                                VideoPbFragment.this.iFV.awy();
                            }
                            cmw.setPostId(yR.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cmw);
                            VideoPbFragment.this.iFv.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.ckr();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cmw);
                            VideoPbFragment.this.iFv.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.ckr();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aCp();
                    return false;
                }
            } else if (ckc().getPbData() == null || ckc().getPbData().ciU() == null || ckc().getPbData().ciU().size() <= 0 || !ckc().getIsFromMark()) {
                return true;
            } else {
                this.iFv.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckr() {
        this.iFv.ckr();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void crh() {
        int i = 4;
        if (ckc() != null && this.iXn != null) {
            if (ShareSwitch.isOn() || checkUpIsLogin()) {
                if (ckc().getPbData() != null && ckc().getPbData().ciS() != null && ckc().getPbData().ciS().azX() != null) {
                    TiebaStatic.log(new an("c13402").cp("tid", ckc().cmc()).cp("fid", ckc().getPbData().getForumId()).Z("obj_locate", 4).cp("uid", ckc().getPbData().ciS().azX().getUserId()));
                }
                if (ckc().getPbData() != null && ckc().getPbData().ciS() != null) {
                    bj ciS = ckc().getPbData().ciS();
                    if (ciS.ayL()) {
                        i = 2;
                    } else if (ciS.aBS()) {
                        i = 3;
                    } else if (!ciS.aBT()) {
                        if (ciS.aBU()) {
                            i = 5;
                        }
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cp("tid", ckc().cmc());
                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cp("fid", ckc().getForumId());
                    anVar.Z("obj_locate", 5);
                    anVar.Z("obj_name", i);
                    anVar.Z("obj_type", 2);
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (ckc().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> ciU = ckc().getPbData().ciU();
                        if ((ciU == null || ciU.size() <= 0) && ckc().cmd()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.iXn.coF();
                        bCF();
                        TiebaStatic.log(new an("c11939"));
                        if (ShareSwitch.isOn()) {
                            yJ(6);
                            return;
                        }
                        this.iXn.showLoadingDialog();
                        ckc().cmJ().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cp("tid", ckc().cmc());
                anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cp("fid", ckc().getForumId());
                anVar2.Z("obj_locate", 5);
                anVar2.Z("obj_name", i);
                anVar2.Z("obj_type", 2);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cri() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        F(eVar.crK());
        if (ckc() != null && ckc().getPbData() != null) {
            boolean isFromMark = ckc().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = ckc().getPbData();
            if (isFromMark) {
                PostData E = E(pbData);
                if (pbData.awv() != null && !pbData.awv().equals(E.getId()) && this.cTX != null) {
                    this.cTX.setCurrentItem(iWV);
                }
            }
        }
        eVar.crL().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aJ */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.aAo() != null) {
                    if (VideoPbFragment.this.iXc.getVideoUrl() == null || !VideoPbFragment.this.iXc.getVideoUrl().equals(bjVar.aAo().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.iXc.getVideoUrl())) {
                            VideoPbFragment.this.iFI = true;
                            VideoPbFragment.this.cTX.setCurrentItem(VideoPbFragment.iWU);
                        }
                        if (VideoPbFragment.this.iXd == null || !VideoPbFragment.this.iXd.isPlaying()) {
                            VideoPbFragment.this.crj();
                            VideoPbFragment.this.aI(bjVar);
                        }
                        VideoPbFragment.this.crk();
                        if (VideoPbFragment.this.iXd.crY()) {
                            VideoPbFragment.this.iXd.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.iXc.getVideoUrl(), bjVar.aAo().video_url);
                        VideoPbFragment.this.iXc.setData(bjVar);
                        VideoPbFragment.this.iXc.csv();
                        VideoPbFragment.this.iXc.qU(VideoPbFragment.this.cTX.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.iXc.startPlay();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.iXc.setData(bjVar);
                }
            }
        });
        eVar.crU().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.cTX.setCurrentItem(num.intValue());
            }
        });
        eVar.crP().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aJ */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iXc.aN(bjVar);
            }
        });
        eVar.crQ().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aJ */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.iXc.aO(bjVar);
            }
        });
        eVar.crR().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.crv();
            }
        });
        eVar.crS().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crj() {
        ViewGroup.LayoutParams layoutParams = this.iXe.getLayoutParams();
        layoutParams.height = 0;
        this.iXe.setLayoutParams(layoutParams);
        this.iXe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crk() {
        if (this.iXd == null) {
            this.iXd = new f(getBaseFragmentActivity(), this.iXb);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(clM()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.iXb.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.iXd.b(eVar.crM(), rect);
            if (this.iXd.crY()) {
                this.iXd.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.crN() || VideoPbFragment.this.ckc().getTabIndex() == VideoPbFragment.iWV) {
                            VideoPbFragment.this.cTX.setCurrentItem(VideoPbFragment.iWV);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.crN() || VideoPbFragment.this.ckc().getTabIndex() == VideoPbFragment.iWV) {
                            VideoPbFragment.this.cTX.setCurrentItem(VideoPbFragment.iWV);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.crN() || ckc().getTabIndex() == iWV) {
                this.cTX.setCurrentItem(iWV);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return this.iXc.onBackPress();
        }
        if (i == 24) {
            return this.iXc.csA();
        }
        if (i == 25) {
            return this.iXc.csB();
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
    public void aI(bj bjVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect cnb;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bjVar != null && bjVar.aAo() != null) {
            int intValue = bjVar.aAo().video_width.intValue();
            int intValue2 = bjVar.aAo().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (ckc() != null || (cnb = ckc().cnb()) == null) ? ceil : cnb.height();
                i = 0;
                layoutParams = this.iXb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.iXb.setLayoutParams(layoutParams);
                this.iXb.setMaxHeight(ceil);
                this.iXb.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.iXb.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.iWX.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, iWW);
                } else {
                    layoutParams2.height = iWW;
                }
                this.iWX.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.Ck.getLayoutParams();
                int i2 = ceil + iWW;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.Ck.setLayoutParams(layoutParams3);
                if (i == 0 && (this.Ck.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Ck.getLayoutParams()).getBehavior();
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
        if (ckc() != null) {
        }
        i = 0;
        layoutParams = this.iXb.getLayoutParams();
        if (layoutParams != null) {
        }
        this.iXb.setLayoutParams(layoutParams);
        this.iXb.setMaxHeight(ceil2);
        this.iXb.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.iXb.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.iWX.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.iWX.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.Ck.getLayoutParams();
        int i22 = ceil2 + iWW;
        if (layoutParams3 != null) {
        }
        this.Ck.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iFC = System.currentTimeMillis();
        super.onCreate(bundle);
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.iGr = new com.baidu.tbadk.core.view.d();
        this.iGr.toastTime = 1000L;
        if (this.iXn != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.iXn.iGs;
            userMuteAddAndDelCustomMessage.setTag(this.iXn.iGs);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.iXn.iGs;
            userMuteCheckCustomMessage.setTag(this.iXn.iGs);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
    }

    private void initData() {
        this.iFV = com.baidu.tbadk.baseEditMark.a.a(this.iFv);
        if (this.iFV != null) {
            this.iFV.a(this.iGZ);
        }
        this.fHZ = new ForumManageModel(this.iFv);
        this.fHZ.setLoadDataCallBack(this.fIe);
        this.cVY = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iXn = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.iGj = new g();
        d(this.iGj);
        this.iGk = (com.baidu.tbadk.editortools.pb.e) this.iGj.dR(getActivity());
        this.iGk.a(this.iFv.getPageContext());
        this.iGk.a(this.dut);
        this.iGk.a(this.dum);
        this.iGk.a(this.iFv.getPageContext(), bundle);
        this.iGk.aLV().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iGk.aLV().gu(true);
        pH(true);
        this.iGk.a(ckc().cmr(), ckc().cmc(), ckc().cmL());
        registerListener(this.iGH);
        registerListener(this.iGY);
        registerListener(this.iGG);
        registerListener(this.iGE);
        registerListener(this.gnu);
        if (!ckc().cmi()) {
            this.iGk.uU(ckc().cmc());
        }
        if (ckc().cmM()) {
            this.iGk.uT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.iGk.uT(cnT());
        }
        this.iGb = new as();
        if (this.iGk.aMu() != null) {
            this.iGb.e(this.iGk.aMu().getInputView());
        }
        this.iGk.a(this.dun);
        this.hNy = new aj(getPageContext());
        this.hNy.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            @Override // com.baidu.tbadk.core.util.aj.a
            public void k(boolean z, int i) {
                if (z) {
                    if (i == aj.cVT) {
                        VideoPbFragment.this.iGk.a((String) null, (WriteData) null);
                    } else if (i == aj.cVU && VideoPbFragment.this.iNF != null && VideoPbFragment.this.iNF.ckR() != null) {
                        VideoPbFragment.this.iNF.ckR().aMQ();
                    } else if (i == aj.cVV) {
                        VideoPbFragment.this.c(VideoPbFragment.this.iGn);
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
        this.gql = new com.baidu.tieba.f.b(getActivity());
        this.gql.a(iHh);
        bas();
        this.Ck = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.iWZ = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.iXb = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.iXc = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.iXb);
        this.iXc.setUniqueId(getUniqueId());
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.iWX = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.iXe = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.cTX = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.iXa = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.iXa.setOnClickListener(this.arL);
        crm();
        crl();
        crn();
        this.iWY = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.cTX.setAdapter(this.iWY);
        this.iWX.setViewPager(this.cTX);
        this.iWX.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.crC() != null) {
                        VideoPbFragment.this.crC().qT(false);
                    }
                    if (VideoPbFragment.this.crD() != null) {
                        VideoPbFragment.this.crD().qT(true);
                        VideoPbFragment.this.zp(VideoPbFragment.this.crD().csi() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.crR() != null && eVar.crR().getValue() != null && eVar.crR().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.iXc.qU(z);
                    VideoPbFragment.this.cnR();
                    if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cp("tid", VideoPbFragment.this.ckc().cmc()).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()));
                        return;
                    }
                    return;
                }
                if (VideoPbFragment.this.crD() != null) {
                    VideoPbFragment.this.crD().qT(false);
                }
                if (VideoPbFragment.this.crC() != null) {
                    VideoPbFragment.this.crC().qT(true);
                    int csi = VideoPbFragment.this.crC().csi();
                    int csn = VideoPbFragment.this.crC().csn();
                    if (csi != 0) {
                        VideoPbFragment.this.zp(8);
                        VideoPbFragment.this.crC().zp(0);
                    } else if (csn != 0) {
                        VideoPbFragment.this.crC().zp(8);
                        VideoPbFragment.this.zp(0);
                    } else {
                        VideoPbFragment.this.crC().zp(8);
                        VideoPbFragment.this.zp(8);
                    }
                }
                VideoPbFragment.this.iXc.qU(false);
                VideoPbFragment.this.Ck.setExpanded(false, true);
                if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                    TiebaStatic.log(new an("c13593").cp("tid", VideoPbFragment.this.ckc().cmc()).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()));
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.iMJ = this.rootView.findViewById(R.id.viewstub_progress);
        cro();
        crp();
    }

    private void crl() {
        this.iXg = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.iXk = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.iXh = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.iXi = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.iXj = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.iXk.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iXk.setConrers(15);
        this.iXj.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.iXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.crx();
            }
        });
        this.iXj.setOnClickListener(this.iXf);
        this.iXe.setOnClickListener(this.iXf);
    }

    private void crm() {
        this.iWX.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.iWX.setContainerLayoutParams(layoutParams);
        this.iWX.setRectPaintColor(R.color.cp_link_tip_a);
        this.iWX.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.iWX.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.iWX.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.iWX.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.iWX.setExpandedTabLayoutParams(layoutParams2);
    }

    public void qO(boolean z) {
        if (this.Ck != null) {
            this.Ck.setExpanded(z);
        }
    }

    private void crn() {
        this.iNa = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.iNb = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.iNh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iNi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.heK = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.heK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.qO(false);
                VideoPbFragment.this.clc();
                if (VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null && VideoPbFragment.this.ckc().getPbData().ciS() != null && VideoPbFragment.this.ckc().getPbData().ciS().azX() != null) {
                    TiebaStatic.log(new an("c13402").cp("tid", VideoPbFragment.this.ckc().cmc()).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()).Z("obj_locate", 1).cp("uid", VideoPbFragment.this.ckc().getPbData().ciS().azX().getUserId()));
                }
            }
        });
        this.iNc = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iNc.setOnClickListener(this.arL);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iNd = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.iNd.setOnClickListener(this.arL);
        if (booleanExtra) {
            this.iNd.setVisibility(8);
        } else {
            this.iNd.setVisibility(0);
        }
        this.iNe = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.iNe.setOnClickListener(this.arL);
        this.iNf = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        qo(false);
    }

    private void bas() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bCG();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            this.mNavigationBar.setStatusBarVisibility(8);
        }
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(clM());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        }
        this.dBI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.arL);
        this.eAe = (ImageView) this.dBI.findViewById(R.id.widget_navi_back_button);
        SvgManager.aEp().a(this.eAe, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iSr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.arL);
        this.KG = (ImageView) this.iSr.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams2.rightMargin = dimens2;
        this.iSr.setLayoutParams(layoutParams2);
        SvgManager.aEp().a(this.KG, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iSr.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
    }

    public void cro() {
        setEditorTools(this.iGk.aLV());
    }

    private void crp() {
        this.iFs = new PbFakeFloorModel(getPageContext());
        this.iNF = new t(getPageContext(), this.iFs, this.rootView);
        this.iNF.a(this.iGV);
        this.iFs.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void q(PostData postData) {
                VideoPbFragment.this.iFs.r(postData);
                if (VideoPbFragment.this.crC() != null) {
                    VideoPbFragment.this.crC().csj();
                }
                VideoPbFragment.this.iNF.ckN();
                VideoPbFragment.this.Fv.aKs();
                VideoPbFragment.this.qo(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iFv = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (ckc() != null) {
            ckc().au(bundle);
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
        this.iXc.mJ(true);
        if (ckc() != null && !ckc().cmi()) {
            this.iGk.saveDraft(ckc().cmc());
        }
        com.baidu.tbadk.BdToken.c.avj().avo();
        MessageManager.getInstance().unRegisterListener(this.iGR);
        MessageManager.getInstance().unRegisterListener(this.iGS);
        MessageManager.getInstance().unRegisterListener(this.iGT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.iXc.mJ(false);
        clI();
        registerListener(this.iGR);
        registerListener(this.iGS);
        registerListener(this.iGT);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.r.c.cIu().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.fHZ != null) {
            this.fHZ.cancelLoadData();
        }
        if (this.iXc != null) {
            this.iXc.onDestroy();
        }
        if (this.iFM != null) {
            this.iFM.cancelLoadData();
        }
        if (this.hNy != null) {
            this.hNy.onDestroy();
        }
        if (ckc() != null) {
            ckc().cancelLoadData();
            ckc().destory();
            if (ckc().cmI() != null) {
                ckc().cmI().onDestroy();
            }
        }
        if (this.iGk != null) {
            this.iGk.onDestroy();
        }
        this.iGr = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.iFv);
        this.iWX.onChangeSkinType();
        am.setBackgroundColor(this.iWX, R.color.cp_bg_line_h);
        this.iGb.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.iXd == null || !this.iXd.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        if (this.Fv != null) {
            this.Fv.onChangeSkinType(i);
        }
        if (this.iNF != null) {
            this.iNF.onChangeSkinType(i);
        }
        if (this.heK != null) {
            am.setViewTextColor(this.heK, (int) R.color.cp_cont_d);
            this.heK.setBackgroundDrawable(am.ay(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.iNd != null && ckc() != null) {
            if (ckc().aww()) {
                SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iNe != null) {
            SvgManager.aEp().a(this.iNe, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iNc != null) {
            SvgManager.aEp().a(this.iNc, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.iNf, (int) R.color.cp_cont_b);
        if (this.iNa != null) {
            am.setBackgroundResource(this.iNa, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.iNb, R.color.cp_bg_line_h);
        if (crC() != null) {
            crC().onChangeSkinType(i);
        }
        if (crD() != null) {
            crD().onChangeSkinType(i);
        }
        if (this.iWZ != null) {
            am.setBackgroundResource(this.iWZ, R.drawable.personalize_tab_shadow);
        }
        if (this.iXe != null) {
            am.setBackgroundColor(this.iXe, R.color.cp_bg_line_g);
        }
        if (this.iXi != null) {
            SvgManager.aEp().a(this.iXi, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.iXg != null) {
            am.setViewTextColor(this.iXg, (int) R.color.cp_cont_b);
        }
        if (this.iXh != null) {
            am.setViewTextColor(this.iXh, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCF() {
        if (this.gmi != null) {
            this.gmi.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment clK() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment clL() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel ckc() {
        return this.iFv.ckc();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity clM() {
        return this.iFv;
    }

    public com.baidu.tbadk.baseEditMark.a crq() {
        return this.iFV;
    }

    public View.OnClickListener crr() {
        return this.arL;
    }

    public View.OnClickListener crs() {
        return this.iDj;
    }

    public View.OnLongClickListener crt() {
        return this.iXn.crt();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.FS(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView bFb() {
        Iterator<BaseFragment> it = this.iWY.crI().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void pH(boolean z) {
        this.iGk.gy(z);
        this.iGk.gz(z);
        this.iGk.gA(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.iXn != null) {
            if (z) {
                this.iXn.coF();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.iXn.coG();
            } else {
                this.iXn.coF();
            }
        }
    }

    public boolean yG(int i) {
        if (this.hNy == null || ckc() == null || ckc().getPbData() == null || ckc().getPbData().getAnti() == null) {
            return true;
        }
        return this.hNy.ax(ckc().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cle() {
        if ((ckc() != null && ckc().getPbData().cjs()) || this.hNy == null || ckc() == null || ckc().getPbData() == null || ckc().getPbData().getAnti() == null) {
            return true;
        }
        return this.hNy.kb(ckc().getPbData().getAnti().replyPrivateFlag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g gVar) {
        if (gVar != null && ckc() != null) {
            gVar.setForumName(ckc().cjS());
            if (ckc().getPbData() != null && ckc().getPbData().getForum() != null) {
                gVar.a(ckc().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(ckc());
        }
    }

    public void coh() {
        if (this.Fv != null) {
            this.Fv.display();
            if (this.iGk != null) {
                this.iGk.aMy();
            }
            coO();
        }
    }

    public void clc() {
        if (checkUpIsLogin() && ckc() != null && ckc().getPbData() != null && ckc().getPbData().getForum() != null) {
            if (ckc().getPbData().cjs()) {
                bNT();
                return;
            }
            if (this.gpJ == null) {
                this.gpJ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.gpJ.tJ(0);
                this.gpJ.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lt(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void s(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lu(boolean z) {
                        if (z) {
                            VideoPbFragment.this.bNT();
                        }
                    }
                });
            }
            this.gpJ.C(ckc().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(ckc().cmc(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.iGk.onActivityResult(i, i2, intent);
        if (this.iFM != null) {
            this.iFM.onActivityResult(i, i2, intent);
        }
        if (this.iNF != null) {
            this.iNF.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    clq();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.n.a.cAC().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.iGn = emotionImageData;
                        if (yG(aj.cVV)) {
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
        if (clM() != null) {
            clM().cko();
        }
        this.iXo.iXy = z;
        cru();
        crv();
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iFv;
        if (i == 0) {
            cnN();
            if (this.iNF != null) {
                this.iNF.ckN();
            }
            qo(false);
        }
        cnR();
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
                        this.iGk.resetData();
                        this.iGk.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iGk.b(writeData);
                        com.baidu.tbadk.editortools.l lX = this.iGk.aLV().lX(6);
                        if (lX != null && lX.dss != null) {
                            lX.dss.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iFv;
                        if (i == -1) {
                            this.iGk.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iNF != null && this.iNF.ckR() != null) {
                            com.baidu.tbadk.editortools.pb.h ckR = this.iNF.ckR();
                            ckR.setThreadData(ckc().getPbData().ciS());
                            ckR.b(writeData);
                            ckR.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l lX2 = ckR.aLV().lX(6);
                            if (lX2 != null && lX2.dss != null) {
                                lX2.dss.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iFv;
                            if (i == -1) {
                                ckR.aMQ();
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
                if (ckc() != null && !ckc().cmi()) {
                    antiData.setBlock_forum_name(ckc().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(ckc().getPbData().getForum().getId());
                    antiData.setUser_name(ckc().getPbData().getUserData().getUserName());
                    antiData.setUser_id(ckc().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bc(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.iXn != null) {
                this.iXn.uZ(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void clO() {
        if (ckc() != null) {
            if (this.iGk == null || !this.iGk.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.iGk = (com.baidu.tbadk.editortools.pb.e) dVar.dR(getContext());
                this.iGk.a(this.iFv.getPageContext());
                this.iGk.a(this.dut);
                this.iGk.a(this.dum);
                this.iGk.a(this.iFv.getPageContext(), this.iFv.getIntent() == null ? null : this.iFv.getIntent().getExtras());
                this.iGk.aLV().gu(true);
                setEditorTools(this.iGk.aLV());
                if (!ckc().cmi()) {
                    this.iGk.uU(ckc().cmc());
                }
                if (ckc().cmM()) {
                    this.iGk.uT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.iGk.uT(cnT());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
        this.Fv.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Fv.getParent() == null) {
            this.rootView.addView(this.Fv, layoutParams);
        }
        this.Fv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Fv.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof p) {
                    if (((p) aVar.data).aHc() == EmotionGroupType.BIG_EMOTION || ((p) aVar.data).aHc() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.iGk.c((p) aVar.data);
                            VideoPbFragment.this.iGk.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cnN();
        this.iGk.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.Fv != null && VideoPbFragment.this.Fv.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.iGb != null && VideoPbFragment.this.iGb.cpd() != null) {
                    if (!VideoPbFragment.this.iGb.cpd().cSP()) {
                        VideoPbFragment.this.iGb.qt(false);
                    }
                    VideoPbFragment.this.iGb.cpd().tD(false);
                }
            }
        });
    }

    public void bNT() {
        if (!checkUpIsLogin()) {
            if (ckc() != null) {
                TiebaStatic.log(new an("c10517").Z("obj_locate", 2).cp("fid", ckc().getForumId()));
            }
        } else if (cle()) {
            if (this.iGk != null && (this.iGk.aMI() || this.iGk.aMJ())) {
                this.iGk.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Fv != null) {
                coh();
                this.iXo.iXx = false;
                if (this.Fv.lX(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.Fv.lX(2).dss, false, null);
                }
            }
            coO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && cle()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iFO);
                this.iFP = ((View) view.getParent()).getMeasuredHeight();
            }
            if (ckc() != null && ckc().getPbData() != null && ckc().getPbData().cjs()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.iFv.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bFb().smoothScrollBy(0, (VideoPbFragment.this.iFO[1] + VideoPbFragment.this.iFP) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iNF != null) {
                            VideoPbFragment.this.iGk.aLV().setVisibility(8);
                            VideoPbFragment.this.iNF.g(str, str2, VideoPbFragment.this.cnT(), (VideoPbFragment.this.ckc() == null || VideoPbFragment.this.ckc().getPbData() == null || VideoPbFragment.this.ckc().getPbData().ciS() == null || !VideoPbFragment.this.ckc().getPbData().ciS().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h ckR = VideoPbFragment.this.iNF.ckR();
                            if (ckR != null && VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                                ckR.a(VideoPbFragment.this.ckc().getPbData().getAnti());
                                ckR.setThreadData(VideoPbFragment.this.ckc().getPbData().ciS());
                            }
                            if (VideoPbFragment.this.iGb.cpf() == null && VideoPbFragment.this.iNF.ckR().aMY() != null) {
                                VideoPbFragment.this.iNF.ckR().aMY().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iGb != null && VideoPbFragment.this.iGb.cpe() != null) {
                                            if (!VideoPbFragment.this.iGb.cpe().cSP()) {
                                                VideoPbFragment.this.iGb.qu(false);
                                            }
                                            VideoPbFragment.this.iGb.cpe().tD(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iGb.f(VideoPbFragment.this.iNF.ckR().aMY().getInputView());
                                VideoPbFragment.this.iNF.ckR().a(VideoPbFragment.this.iGp);
                            }
                        }
                        VideoPbFragment.this.coO();
                    }
                }, 0L);
                return;
            }
            if (this.iGm == null) {
                this.iGm = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iGm.tJ(1);
                this.iGm.a(new AnonymousClass40(str, str2));
            }
            if (ckc() != null && ckc().getPbData() != null && ckc().getPbData().getForum() != null) {
                this.iGm.C(ckc().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(ckc().cmc(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$40  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String iHt;
        final /* synthetic */ String iHu;

        AnonymousClass40(String str, String str2) {
            this.iHt = str;
            this.iHu = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lt(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void s(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lu(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bFb().smoothScrollBy(0, (VideoPbFragment.this.iFO[1] + VideoPbFragment.this.iFP) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.iNF != null) {
                            VideoPbFragment.this.iGk.aLV().setVisibility(8);
                            VideoPbFragment.this.iNF.g(AnonymousClass40.this.iHt, AnonymousClass40.this.iHu, VideoPbFragment.this.cnT(), (VideoPbFragment.this.ckc() == null || VideoPbFragment.this.ckc().getPbData() == null || VideoPbFragment.this.ckc().getPbData().ciS() == null || !VideoPbFragment.this.ckc().getPbData().ciS().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h ckR = VideoPbFragment.this.iNF.ckR();
                            if (ckR != null && VideoPbFragment.this.ckc() != null && VideoPbFragment.this.ckc().getPbData() != null) {
                                ckR.a(VideoPbFragment.this.ckc().getPbData().getAnti());
                                ckR.setThreadData(VideoPbFragment.this.ckc().getPbData().ciS());
                            }
                            if (VideoPbFragment.this.iGb.cpf() == null && VideoPbFragment.this.iNF.ckR().aMY() != null) {
                                VideoPbFragment.this.iNF.ckR().aMY().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.iGb != null && VideoPbFragment.this.iGb.cpe() != null) {
                                            if (!VideoPbFragment.this.iGb.cpe().cSP()) {
                                                VideoPbFragment.this.iGb.qu(false);
                                            }
                                            VideoPbFragment.this.iGb.cpe().tD(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.iGb.f(VideoPbFragment.this.iNF.ckR().aMY().getInputView());
                                VideoPbFragment.this.iNF.ckR().a(VideoPbFragment.this.iGp);
                            }
                        }
                        VideoPbFragment.this.coO();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData E;
        w wVar;
        StringBuilder sb = null;
        if (fVar != null && (E = E(fVar)) != null) {
            String userId = E.azX().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, E.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cje()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (E.azX() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, E.azX().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, E.azX().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, E.azX().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, E.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, E.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cje()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cjm = fVar.cjm();
                if (v.getCount(cjm) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cjm) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cML) != null && wVar.cKF && !wVar.cKG && (wVar.type == 1 || wVar.type == 2)) {
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
    public void clq() {
        MarkData yR;
        if (ckc() != null && ckc().getPbData() != null && crC() != null && this.iFV != null) {
            if (ckc().getPbData() != null && ckc().getPbData().cjs()) {
                yR = ckc().yR(0);
            } else if (this.cTX != null && this.cTX.getCurrentItem() == iWU) {
                yR = ckc().l(E(ckc().getPbData()));
            } else {
                yR = ckc().yR(crC().cor());
            }
            if (yR != null) {
                if (!yR.isApp() || (yR = ckc().yR(crC().cor() + 1)) != null) {
                    com();
                    this.iFV.a(yR);
                    if (!this.iFV.aww()) {
                        this.iFV.awy();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iFV.awx();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yH(int i) {
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
            if (this.iFM == null) {
                this.iFM = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iFv);
                this.iFM.b(this.dum);
                this.iFM.c(this.dut);
            }
            this.iFM.a(emotionImageData, ckc(), ckc().getPbData());
        }
    }

    public PostData E(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cjc() != null) {
            return fVar.cjc();
        }
        if (!v.isEmpty(fVar.ciU())) {
            Iterator<PostData> it = fVar.ciU().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cJz() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.ciZ();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.azX() != null && postData.azX().getUserTbVipInfoData() != null && postData.azX().getUserTbVipInfoData().getvipIntro() != null) {
            postData.azX().getGodUserData().setIntro(postData.azX().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.ciS() == null || fVar.ciS().azX() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azX = fVar.ciS().azX();
        String userId = azX.getUserId();
        HashMap<String, MetaData> userMap = fVar.ciS().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azX;
        }
        postData.Cq(1);
        postData.setId(fVar.ciS().aAn());
        postData.setTitle(fVar.ciS().getTitle());
        postData.setTime(fVar.ciS().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String clv() {
        ArrayList<PostData> ciU;
        int count;
        int i;
        if (ckc() == null || ckc().getPbData() == null || ckc().getPbData().ciU() == null || (count = v.getCount((ciU = ckc().getPbData().ciU()))) == 0) {
            return "";
        }
        if (ckc().cmu()) {
            Iterator<PostData> it = ciU.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cJz() == 1) {
                    return next.getId();
                }
            }
        }
        if (bFb() == null) {
            i = 0;
        } else {
            i = crC().coq();
        }
        PostData postData = (PostData) v.getItem(ciU, i);
        if (postData == null || postData.azX() == null) {
            return "";
        }
        if (ckc().FH(postData.azX().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(ciU, i2);
            if (postData2 == null || postData2.azX() == null || postData2.azX().getUserId() == null) {
                break;
            } else if (ckc().FH(postData2.azX().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(ciU, i3);
            if (postData3 == null || postData3.azX() == null || postData3.azX().getUserId() == null) {
                return "";
            }
            if (ckc().FH(postData3.azX().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clr() {
        if (ckc() != null) {
            com.baidu.tieba.pb.data.f pbData = ckc().getPbData();
            ckc().pU(true);
            if (this.iFV != null) {
                pbData.Ft(this.iFV.awv());
            }
            if (crC() != null) {
                crC().csj();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (ckc() != null) {
            coo();
            ckc().pU(z);
            if (this.iFV != null) {
                this.iFV.ff(z);
                if (markData != null) {
                    this.iFV.a(markData);
                }
            }
            if (ckc().aww()) {
                clr();
            } else if (crC() != null) {
                crC().csj();
            }
        }
    }

    public void b(m mVar) {
        MetaData metaData;
        boolean z = true;
        if (ckc() != null && ckc().getPbData() != null && mVar.cjF() != null) {
            String id = mVar.cjF().getId();
            ArrayList<PostData> ciU = ckc().getPbData().ciU();
            int i = 0;
            while (true) {
                if (i >= ciU.size()) {
                    break;
                }
                PostData postData = ciU.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cjJ = mVar.cjJ();
                    postData.Cp(mVar.getTotalCount());
                    if (postData.cJw() != null && cjJ != null) {
                        Iterator<PostData> it = cjJ.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.azX() != null && (metaData = postData.getUserMap().get(next.azX().getUserId())) != null) {
                                next.a(metaData);
                                next.sK(true);
                                next.a(getPageContext(), ckc().FH(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cjJ.size() != postData.cJw().size();
                        postData.cJw().clear();
                        postData.cJw().addAll(cjJ);
                        z = z2;
                    }
                    if (postData.cJs() != null) {
                        postData.cJt();
                    }
                }
            }
            if (!ckc().getIsFromMark() && z && crC() != null) {
                crC().csj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clh() {
        if (ckc() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Ii(ckc().getForumId()) && ckc().getPbData() != null && ckc().getPbData().getForum() != null) {
            if (ckc().getPbData().getForum().isLike() == 1) {
                ckc().cmK().em(ckc().getForumId(), ckc().cmc());
            }
        }
    }

    public void cnR() {
        reset();
        cnN();
        this.iNF.ckN();
        qo(false);
    }

    private void reset() {
        if (this.iGk != null && this.Fv != null) {
            com.baidu.tbadk.editortools.pb.a.aMr().setStatus(0);
            this.iGk.aML();
            this.iGk.aMf();
            if (this.iGk.getWriteImagesInfo() != null) {
                this.iGk.getWriteImagesInfo().setMaxImagesAllowed(this.iGk.isBJH ? 1 : 9);
            }
            this.iGk.md(SendView.ALL);
            this.iGk.me(SendView.ALL);
            com.baidu.tbadk.editortools.g lU = this.Fv.lU(23);
            com.baidu.tbadk.editortools.g lU2 = this.Fv.lU(2);
            com.baidu.tbadk.editortools.g lU3 = this.Fv.lU(5);
            if (lU2 != null) {
                lU2.display();
            }
            if (lU3 != null) {
                lU3.display();
            }
            if (lU != null) {
                lU.hide();
            }
            this.Fv.invalidate();
        }
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.ciS() != null) {
            if (fVar.aww()) {
                SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iNf.setText(yZ(fVar.ciS().azO()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.ciS()));
        }
    }

    private String yZ(int i) {
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

    public void qo(boolean z) {
        if (this.iNb != null) {
            qm(this.iGk.aMB());
            if (this.iMX) {
                qd(z);
            } else {
                qe(z);
            }
            cru();
            crv();
        }
    }

    public void coO() {
        if (this.iNb != null) {
            this.iNa.setVisibility(8);
            this.iNb.setVisibility(8);
            this.iXo.iXx = false;
            cru();
            crv();
        }
    }

    private void cru() {
        if (this.iXc != null) {
            if (this.iXo.crH()) {
                this.iXc.rN(false);
            } else {
                this.iXc.rN(this.iXc.bgb() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crv() {
        if (this.iXc != null && this.cTX != null) {
            if (this.cTX.getCurrentItem() != 0) {
                this.iXc.qU(false);
            } else if (this.iXo.crH()) {
                this.iXc.qU(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.iXc.qU(eVar.crR() == null || eVar.crR().getValue() == null || eVar.crR().getValue().booleanValue());
                }
            }
        }
    }

    private void yJ(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(clM(), clf(), i);
    }

    private int clf() {
        if (ckc() == null || ckc().getPbData() == null || ckc().getPbData().ciS() == null) {
            return -1;
        }
        return ckc().getPbData().ciS().aAH();
    }

    public void qm(boolean z) {
        this.iMX = z;
    }

    public void qd(boolean z) {
        if (this.iNb != null && this.heK != null) {
            this.heK.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iNb.startAnimation(alphaAnimation);
            }
            this.iNa.setVisibility(0);
            this.iNb.setVisibility(0);
            this.iXo.iXx = true;
        }
    }

    public void qe(boolean z) {
        if (this.iNb != null && this.heK != null) {
            this.heK.setText(cnT());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iNb.startAnimation(alphaAnimation);
            }
            this.iNa.setVisibility(0);
            this.iNb.setVisibility(0);
            this.iXo.iXx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.iAv = aVar;
            this.iXg.setText(aVar.getTitle());
            this.iXh.setText(aVar.cso());
            String csp = aVar.csp();
            TBSpecificationBtn tBSpecificationBtn = this.iXj;
            if (TextUtils.isEmpty(csp)) {
                csp = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(csp);
            this.iXk.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cp("obj_id", VideoPbFragment.this.iAv.getTitle()).cp("obj_name", VideoPbFragment.this.iAv.cso()).Z("obj_type", 2).cp("fid", VideoPbFragment.this.ckc().getPbData().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("tid", VideoPbFragment.this.ckc().getPbData().getThreadId()));
                    VideoPbFragment.this.crw();
                }
            }, aVar.csq().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crw() {
        ViewGroup.LayoutParams layoutParams = this.iXe.getLayoutParams();
        if (layoutParams != null) {
            if (this.iXl == null || !this.iXl.isRunning()) {
                this.iXe.setAlpha(0.0f);
                this.iXe.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crx() {
        if (this.iXe.getLayoutParams() != null) {
            if (this.iXl == null || !this.iXl.isRunning()) {
                cry();
            }
        }
    }

    private void cry() {
        final ViewGroup.LayoutParams layoutParams = this.iXe.getLayoutParams();
        if (layoutParams != null) {
            if (this.iXm == null || !this.iXm.isRunning()) {
                this.iXm = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iXm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.iXe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.iXm.setDuration(200L);
                this.iXm.start();
                this.iXm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
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
        final ViewGroup.LayoutParams layoutParams2 = this.Ck.getLayoutParams();
        final int i = layoutParams2.height;
        this.iXl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.iXl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hdi);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.hdi);
                VideoPbFragment.this.iXe.setLayoutParams(layoutParams);
                VideoPbFragment.this.Ck.setLayoutParams(layoutParams2);
            }
        });
        this.iXl.setDuration(300L);
        this.iXl.start();
        this.iXl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.iXe.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.Ck.getLayoutParams();
        final int i = layoutParams2.height;
        this.iXl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iXl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hdi);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.iXe.setLayoutParams(layoutParams);
                VideoPbFragment.this.Ck.setLayoutParams(layoutParams2);
            }
        });
        this.iXl.setDuration(300L);
        this.iXl.start();
        this.iXl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.crz();
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
    public void crz() {
        this.iXl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iXl.setDuration(300L);
        this.iXl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.iXe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iXl.start();
    }

    public String cnT() {
        if (!aq.isEmpty(this.iNW)) {
            return this.iNW;
        }
        this.iNW = TbadkCoreApplication.getInst().getResources().getString(ap.cnI());
        return this.iNW;
    }

    public void coo() {
        hideProgressBar();
        if (crC() != null) {
            crC().endLoadData();
            crC().cop();
        }
    }

    public boolean cu(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.axy().isShowImages()) {
                    return FD(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (ckc() == null || ckc().getPbData() == null) {
                        return true;
                    }
                    if (this.iNF != null) {
                        this.iNF.ckN();
                    }
                    m mVar = new m();
                    mVar.a(ckc().getPbData().getForum());
                    mVar.setThreadData(ckc().getPbData().ciS());
                    mVar.f(postData);
                    this.iFs.d(mVar);
                    this.iFs.setPostId(postData.getId());
                    b(view, postData.azX().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iGk != null) {
                        qm(this.iGk.aMB());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void crA() {
        if (this.iGk != null) {
            qm(this.iGk.aMB());
        }
        cnR();
        this.iXn.coF();
    }

    private boolean FD(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("bubble_link", "");
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

    public void bUP() {
        this.iMJ.setVisibility(0);
    }

    public void bUO() {
        this.iMJ.setVisibility(8);
    }

    public void zp(int i) {
        if (this.iWZ != null) {
            this.iWZ.setVisibility(i);
        }
    }

    public void com() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cll() {
        return this.iGX;
    }

    public void cnN() {
        if (this.Fv != null) {
            this.Fv.hide();
        }
    }

    public void bCG() {
        if (this.iFv.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iFv.getCurrentFocus());
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.ciS() != null) {
            String valueOf = String.valueOf(fVar.ciS().azO());
            if (fVar.ciS().azO() == 0) {
                valueOf = "";
            }
            this.iWX.vO(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.iWY.crI()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (ckc() != null && ckc().getPbData() != null && ckc().getPbData().ciS() != null && ckc().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(iNy)).intValue();
                if (intValue == iNz) {
                    if (!this.fHZ.cKo()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.fHZ.IT(aq.O(jSONArray));
                        }
                        this.fHZ.a(ckc().getPbData().getForum().getId(), ckc().getPbData().getForum().getName(), ckc().getPbData().ciS().getId(), str, intValue3, intValue2, booleanValue, ckc().getPbData().ciS().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == iNA || intValue == iNC) {
                    if (ckc().cmH() != null) {
                        ckc().cmH().yB(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == iNA) {
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
    public int aSg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aSh() {
        if (this.dIh == null) {
            this.dIh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aSt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.axy().isShowImages();
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
                        if (i.axy().isShowImages()) {
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
        return this.dIh;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aSi() {
        if (this.dKV == null) {
            this.dKV = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dKV;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aSj() {
        if (this.dIi == null) {
            this.dIi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bFv */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.axy().isShowImages();
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
                    if (i.axy().isShowImages()) {
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
                    gifView.aNq();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dIi;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aSk() {
        if (this.dKW == null) {
            this.dKW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: clP */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cKK();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cz */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dKW;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aSl() {
        if (this.dKX == null) {
            this.dKX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: clR */
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
        return this.dKX;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aSm() {
        this.dKY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: clQ */
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
        return this.dKY;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iFG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (av.FS(str) && ckc() != null && ckc().cmc() != null) {
            TiebaStatic.log(new an("c11664").Z("obj_param1", 1).cp("post_id", ckc().cmc()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.drv = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            av.cph().c(getPageContext(), str);
        }
        this.iFG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        av.cph().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iFG = true;
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
            this.iXn.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b csb = this.iXn.csb();
            if (csb == null) {
                this.iXn.clb();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                csb.getItemView(1).setVisibility(8);
            } else {
                csb.getItemView(1).setVisibility(0);
            }
            csb.aCq();
            this.iFG = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aEt().b(getPageContext(), new String[]{str});
            this.iFG = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a crB() {
        return this.cVY;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener aPW() {
        return this.dnp;
    }

    public ReplyFragment crC() {
        if (this.iWY == null || !(this.iWY.zq(iWV) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.iWY.zq(iWV);
    }

    public DetailInfoFragment crD() {
        if (this.iWY == null || !(this.iWY.zq(iWU) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.iWY.zq(iWU);
    }

    public boolean cjR() {
        PbModel ckc = this.iFv.ckc();
        if (ckc == null) {
            return false;
        }
        return ckc.cjR();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cjb;
        PbModel ckc = this.iFv.ckc();
        if (ckc != null && ckc.getPbData() != null && !ckc.getPbData().cjs()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = ckc.getPbData().ciS().getId();
            if (ckc.isShareThread() && ckc.getPbData().ciS().cPN != null) {
                historyMessage.threadName = ckc.getPbData().ciS().cPN.showText;
            } else {
                historyMessage.threadName = ckc.getPbData().ciS().getTitle();
            }
            if (ckc.isShareThread() && !cjR()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = ckc.getPbData().getForum().getName();
            }
            ArrayList<PostData> ciU = ckc.getPbData().ciU();
            int coq = crC() != null ? crC().coq() : 0;
            if (ciU != null && coq >= 0 && coq < ciU.size()) {
                historyMessage.postID = ciU.get(coq).getId();
            }
            historyMessage.isHostOnly = ckc.getHostMode();
            historyMessage.isSquence = ckc.cmd();
            historyMessage.isShareThread = ckc.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iGk != null) {
            this.iGk.onDestroy();
        }
        if (ckc != null && (ckc.cme() || ckc.cmg())) {
            Intent intent = new Intent();
            intent.putExtra("tid", ckc.cmc());
            if (this.iFY) {
                if (this.iGa) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", ckc.bwl());
                }
                if (this.iFZ) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", ckc.getIsGood());
                }
            }
            if (ckc.getPbData() != null && System.currentTimeMillis() - this.iFC >= 40000 && (cjb = ckc.getPbData().cjb()) != null && !v.isEmpty(cjb.getDataList())) {
                intent.putExtra("guess_like_data", cjb);
            }
            PbActivity pbActivity = this.iFv;
            PbActivity pbActivity2 = this.iFv;
            pbActivity.setResult(-1, intent);
        }
        if (cls()) {
            if (ckc != null) {
                com.baidu.tieba.pb.data.f pbData = ckc.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.iFI) {
                        if (this.iXb != null) {
                            Rect rect = new Rect();
                            this.iXb.getGlobalVisibleRect(rect);
                            ak.cnx().h(rect);
                        }
                        ak.cnx().yV(this.cTX.getCurrentItem());
                        BdTypeRecyclerView bFb = bFb();
                        Parcelable parcelable = null;
                        if (bFb != null) {
                            parcelable = bFb.onSaveInstanceState();
                        }
                        ak.cnx().a(ckc.cml(), parcelable, ckc.cmd(), ckc.getHostMode(), false);
                    }
                }
            } else {
                ak.cnx().reset();
            }
            ckr();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.iXc != null && !this.iXc.bgb()) {
            if ((this.iXc.isFullScreen() && configuration.orientation == 1) || (!this.iXc.isFullScreen() && configuration.orientation == 2)) {
                this.iXc.qV(false);
            }
        }
    }

    public boolean crE() {
        if (this.iXc == null) {
            return false;
        }
        return this.iXc.bgb();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.r.c.cIu().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        public boolean iXx;
        public boolean iXy;

        private a() {
            this.iXy = true;
        }

        public boolean crH() {
            return (this.iXx && this.iXy) ? false : true;
        }
    }

    public void crF() {
        this.iFQ = -1;
        this.iFR = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clI() {
        if (ckc() != null && !aq.isEmpty(ckc().cmc())) {
            com.baidu.tbadk.BdToken.c.avj().o(com.baidu.tbadk.BdToken.b.cCM, com.baidu.adp.lib.f.b.toLong(ckc().cmc(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.iXa.setVisibility(z ? 0 : 8);
    }
}
