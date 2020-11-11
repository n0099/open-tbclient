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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.h;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.bb;
import com.baidu.tieba.pb.pb.main.v;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
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
/* loaded from: classes22.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, i, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Yh;
    private EditorTools abk;
    private ImageView agS;
    private CustomViewPager eLl;
    private com.baidu.adp.lib.d.b<ImageView> fFL;
    private com.baidu.adp.lib.d.b<GifView> fFM;
    private com.baidu.adp.lib.d.b<TextView> fJc;
    private com.baidu.adp.lib.d.b<View> fJd;
    private com.baidu.adp.lib.d.b<LinearLayout> fJe;
    private com.baidu.adp.lib.d.b<RelativeLayout> fJf;
    public View fxJ;
    private ImageView gFB;
    private com.baidu.tieba.callfans.a hYS;
    private VoiceManager iHo;
    private com.baidu.tieba.frs.profession.permission.c iLK;
    private com.baidu.tieba.f.b iMk;
    public am kvy;
    public bb kzD;
    private View lBJ;
    private LinearLayout lBL;
    private HeadImageView lBM;
    private ImageView lBN;
    private ImageView lBO;
    private ImageView lBP;
    private com.baidu.tieba.pb.view.c lBQ;
    private TextView lBR;
    private TextView lBS;
    private int lBU;
    private int lBV;
    private View lBs;
    private String lCJ;
    private v lCs;
    public View lHo;
    private NewPagerSlidingTabBaseStrip lLR;
    private VideoPbFragmentAdapter lLS;
    private View lLT;
    private View lLU;
    private VideoContainerLayout lLV;
    private com.baidu.tieba.pb.videopb.videoView.a lLW;
    private f lLX;
    private View lLY;
    private View lLZ;
    private TextView lMb;
    private TextView lMc;
    private ImageView lMd;
    private TBSpecificationBtn lMe;
    private TbImageView lMf;
    private View lMg;
    private ValueAnimator lMh;
    private ValueAnimator lMi;
    public com.baidu.tieba.pb.videopb.b.a lMj;
    private float lMn;
    private float lMo;
    private boolean lMp;
    private ObjectAnimator lMt;
    private ObjectAnimator lMu;
    private com.baidu.tieba.pb.videopb.c.a lnE;
    private com.baidu.tieba.pb.pb.main.emotion.model.a ltE;
    int ltH;
    private PbFakeFloorModel ltg;
    private PbActivity ltl;
    private g luc;
    private com.baidu.tbadk.editortools.pb.e lud;
    private com.baidu.tieba.frs.profession.permission.c luf;
    private EmotionImageData lug;
    private com.baidu.tbadk.core.view.c luk;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int lLN = 0;
    public static int lLO = 1;
    public static int lLP = 0;
    public static int lCk = 3;
    public static int lCl = 0;
    public static int lCm = 3;
    public static int lCn = 4;
    public static int lCo = 5;
    public static int lCp = 6;
    private static final int jGx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int lLQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lvd = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cG(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.djo();
            } else {
                com.baidu.tieba.pb.a.b.djn();
            }
        }
    };
    private long ltt = 0;
    private boolean ltA = false;
    View.OnClickListener lMa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lnE == null || VideoPbFragment.this.lnE.dsc()) {
                if (VideoPbFragment.this.lnE != null) {
                    if (VideoPbFragment.this.lnE.isChushou) {
                        VideoPbFragment.this.eC(VideoPbFragment.this.lnE.thirdRoomId, VideoPbFragment.this.lnE.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lnE.dsd();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dR("fid", VideoPbFragment.this.djz().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.djz().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.djz().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lnE.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dR("obj_id", VideoPbFragment.this.lnE.getTitle()).dR("obj_name", VideoPbFragment.this.lnE.drZ()).al("obj_type", 2).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.djz().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lnE.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.brr().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                    return;
                }
                Uri parse = Uri.parse(link);
                if (parse != null) {
                    UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a ltP = null;
    private com.baidu.tbadk.coreExtra.model.a eNr = null;
    private ForumManageModel hYQ = null;
    private boolean ltx = false;
    private View lBK = null;
    private TextView jKd = null;
    private boolean lBG = false;
    private String fpM = null;
    private boolean ltS = false;
    private boolean ltT = false;
    private boolean ltU = false;
    private boolean ltz = false;
    int[] ltG = new int[2];
    private int ltI = -1;
    private int ltJ = Integer.MIN_VALUE;
    private int luq = 0;
    private int lMl = Integer.MIN_VALUE;
    private boolean bFd = false;
    private boolean lrn = com.baidu.tbadk.a.d.bhV();
    private final PbModel.a luT = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            h rh;
            VideoPbFragment.this.dnK();
            VideoPbFragment.this.cTt();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.uS(false);
            if (z && fVar != null) {
                bw dik = fVar.dik();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.J(fVar);
                com.baidu.tieba.pb.videopb.c.a diP = fVar.diP();
                if (diP != null && !diP.lOm) {
                    VideoPbFragment.this.a(diP);
                }
                VideoPbFragment.this.K(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.ltP != null) {
                    VideoPbFragment.this.ltP.iq(fVar.biv());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fpM = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fpM) && VideoPbFragment.this.lud != null && VideoPbFragment.this.lud.bzx() != null && (rh = VideoPbFragment.this.lud.bzx().rh(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fpM)) {
                        ((View) rh).setOnClickListener(VideoPbFragment.this.fqy);
                    }
                }
                if (VideoPbFragment.this.kvy != null && dik != null && dik.bmA() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dik.bmA());
                    VideoPbFragment.this.kvy.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.djz().dlx());
                        jSONObject.put("fid", VideoPbFragment.this.djz().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bhX() || VideoPbFragment.this.drd() != null) && VideoPbFragment.this.drb() != null) {
                    if (com.baidu.tbadk.a.d.bhX()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                                arrayList = VideoPbFragment.this.djz().getPbData().dim();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dJZ() == 1)) {
                                if (VideoPbFragment.this.drd().dkX()) {
                                    VideoPbFragment.this.drd().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.drd().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.drd().PN(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.drd().PN("");
                        }
                        VideoPbFragment.this.drd().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.djz().getPbData().dim();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dJZ() == 1)) {
                                if (VideoPbFragment.this.drb().dkX()) {
                                    VideoPbFragment.this.drb().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.drb().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.drb().PN(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.drb().PN("");
                        }
                        VideoPbFragment.this.drb().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dIX().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0573a luV = new a.InterfaceC0573a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0573a
        public void d(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dnK();
            if (z && VideoPbFragment.this.djz() != null) {
                if (VideoPbFragment.this.ltP != null) {
                    VideoPbFragment.this.ltP.iq(z2);
                }
                VideoPbFragment.this.djz().ux(z2);
                if (VideoPbFragment.this.djz().biv()) {
                    VideoPbFragment.this.dkI();
                } else if (com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drd() != null) {
                    VideoPbFragment.this.drd().drM();
                } else if (VideoPbFragment.this.drb() != null) {
                    VideoPbFragment.this.drb().drM();
                }
                if (z2) {
                    if (VideoPbFragment.this.ltP != null) {
                        if (VideoPbFragment.this.ltP.biy() != null && VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().dik() != null && VideoPbFragment.this.djz().getPbData().dik().bmA() != null) {
                            MarkData biy = VideoPbFragment.this.ltP.biy();
                            MetaData bmA = VideoPbFragment.this.djz().getPbData().dik().bmA();
                            if (biy != null && bmA != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), bmA.getUserId()) && !bmA.hadConcerned()) {
                                    VideoPbFragment.this.lMj.b(bmA);
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
                    VideoPbFragment.this.dkF();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fpQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bAb() {
            if (VideoPbFragment.this.kzD == null || VideoPbFragment.this.kzD.doC() == null || !VideoPbFragment.this.kzD.doC().dSV()) {
                return !VideoPbFragment.this.FP(am.eNm);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kzD.doC().dSX());
            if (VideoPbFragment.this.lud != null && (VideoPbFragment.this.lud.bAs() || VideoPbFragment.this.lud.bAt())) {
                VideoPbFragment.this.lud.a(false, VideoPbFragment.this.kzD.doF());
            }
            VideoPbFragment.this.kzD.uY(true);
            return true;
        }
    };
    private final CustomMessageListener lux = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.djz() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lud != null) {
                    VideoPbFragment.this.uQ(VideoPbFragment.this.lud.bAl());
                }
                VideoPbFragment.this.dnm();
                VideoPbFragment.this.lMj.dob();
            }
        }
    };
    private CustomMessageListener luA = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((p) eVar.getData());
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
    private final CustomMessageListener iIQ = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bFd) {
                VideoPbFragment.this.dla();
            }
        }
    };
    private CustomMessageListener luU = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dkz();
            }
        }
    };
    private CustomMessageListener luM = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.lMj != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lMj.lul) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.lMj.chg();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.lMj.getExtra();
                DataRes dataRes = aVar.nlA;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (at.isEmpty(str)) {
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
                    VideoPbFragment.this.lMj.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.lMj.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener luK = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.lMj != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lMj.lul) {
                VideoPbFragment.this.lMj.chg();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.djz().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.diA().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.luk.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.lMj.DT(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.lMj.dkW();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.luk.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener luL = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.lMj != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lMj.lul) {
                VideoPbFragment.this.lMj.chg();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.luk.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.luk.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lui = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bAb() {
            if (VideoPbFragment.this.kzD == null || VideoPbFragment.this.kzD.doD() == null || !VideoPbFragment.this.kzD.doD().dSV()) {
                return !VideoPbFragment.this.FP(am.eNn);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kzD.doD().dSX());
            if (VideoPbFragment.this.lCs != null && VideoPbFragment.this.lCs.dkj() != null && VideoPbFragment.this.lCs.dkj().bAt()) {
                VideoPbFragment.this.lCs.dkj().a(VideoPbFragment.this.kzD.doF());
            }
            VideoPbFragment.this.kzD.uZ(true);
            return true;
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                    aqVar.dR("fid", VideoPbFragment.this.djz().getPbData().getForumId());
                }
                aqVar.dR("tid", VideoPbFragment.this.djz().dlx());
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cyK();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.djz() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.djz().PI(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drd() != null) {
                        VideoPbFragment.this.luq = VideoPbFragment.this.drd().dnM();
                        VideoPbFragment.this.lMl = VideoPbFragment.this.drd().drP();
                        VideoPbFragment.this.djz().db(VideoPbFragment.this.luq, VideoPbFragment.this.lMl);
                    } else if (VideoPbFragment.this.drb() != null) {
                        VideoPbFragment.this.luq = VideoPbFragment.this.drb().dnM();
                        VideoPbFragment.this.lMl = VideoPbFragment.this.drb().drP();
                        VideoPbFragment.this.djz().db(VideoPbFragment.this.luq, VideoPbFragment.this.lMl);
                    }
                }
                if (VideoPbFragment.this.eLl != null) {
                    if (com.baidu.tbadk.a.d.bhX()) {
                        VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLP);
                    } else {
                        VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLO);
                    }
                }
                VideoPbFragment.this.lMj.dob();
                VideoPbFragment.this.kzD.doB();
                if (VideoPbFragment.this.lud != null) {
                    VideoPbFragment.this.uQ(VideoPbFragment.this.lud.bAl());
                }
                VideoPbFragment.this.dni();
                VideoPbFragment.this.uS(true);
                VideoPbFragment.this.djz().dlS();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drd() != null) {
                                VideoPbFragment.this.drd().drM();
                            } else if (VideoPbFragment.this.drb() != null) {
                                VideoPbFragment.this.drb().drM();
                            }
                        }
                    } else if (VideoPbFragment.this.djz().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.djz().getPbData();
                        if (pbData != null && pbData.dik() != null && pbData.dik().bmA() != null && (userId = pbData.dik().bmA().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.djz().dlJ()) {
                            VideoPbFragment.this.dnI();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.djz().dlJ()) {
                        VideoPbFragment.this.dnI();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.ui(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lud.bAs() || VideoPbFragment.this.lud.bAt()) {
                    VideoPbFragment.this.lud.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kzD.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kvy != null) {
                    VideoPbFragment.this.kvy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bo(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new aq("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bpc();
                TiebaStatic.log(new aq("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fqy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fpM);
        }
    };
    private CustomMessageListener luz = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lud != null) {
                    VideoPbFragment.this.uQ(VideoPbFragment.this.lud.bAl());
                }
                VideoPbFragment.this.uS(false);
            }
        }
    };
    private int lMm = 0;
    private boolean lMq = true;
    private View.OnTouchListener lMr = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.lMm == 1) {
                if (!VideoPbFragment.this.lMq) {
                    VideoPbFragment.this.drg();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dle(), VideoPbFragment.this.dle().getRootView());
                    VideoPbFragment.this.lMq = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(VideoPbFragment.this.lMs);
                    com.baidu.adp.lib.f.e.mY().postDelayed(VideoPbFragment.this.lMs, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.lMm == 2 && (VideoPbFragment.this.lMq || VideoPbFragment.this.dri())) {
                VideoPbFragment.this.drh();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dle(), VideoPbFragment.this.dle().getRootView());
                VideoPbFragment.this.lMq = false;
                if (VideoPbFragment.this.lLW != null) {
                    VideoPbFragment.this.lLW.vu(false);
                }
            }
            VideoPbFragment.this.lMm = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener iTq = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.lMm = 0;
            VideoPbFragment.this.lMn = 0.0f;
            VideoPbFragment.this.lMo = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.lMn += f;
            VideoPbFragment.this.lMo += f2;
            if (VideoPbFragment.this.lMm == 0 && !VideoPbFragment.this.lMp && VideoPbFragment.this.lLW != null && !VideoPbFragment.this.lLW.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.lMo) <= Math.abs(VideoPbFragment.this.lMn) || VideoPbFragment.this.lMo > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.lMo) > Math.abs(VideoPbFragment.this.lMn) && VideoPbFragment.this.lMo > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.lMm = 2;
                    }
                } else {
                    VideoPbFragment.this.lMm = 1;
                }
            }
            return true;
        }
    };
    private Runnable lMs = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.lMq && !VideoPbFragment.this.dri()) {
                VideoPbFragment.this.drh();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dle(), VideoPbFragment.this.dle().getRootView());
                VideoPbFragment.this.lMq = false;
            }
        }
    };
    private final com.baidu.adp.base.d hYX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.djz() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.hYQ.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.hYQ.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.djz().dlS();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lJk != 1002 || bVar.gQx) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.QP, dVar.mZE, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.hYQ.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.hYQ.getLoadDataMode(), gVar.QP, gVar.mZE, false);
                    VideoPbFragment.this.lMj.bc(gVar.mZH);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener fzb = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.iMk.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d luR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                    aqVar.dR("fid", VideoPbFragment.this.djz().getPbData().getForumId());
                }
                if (VideoPbFragment.this.djz() != null) {
                    aqVar.dR("tid", VideoPbFragment.this.djz().dlx());
                }
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.kzD != null) {
                    VideoPbFragment.this.kzD.doA();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(VideoPbFragment.this.getPageContext(), postWriteCallBackData);
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.kvy != null) {
                    VideoPbFragment.this.kvy.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bo(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new aq("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bpc();
                TiebaStatic.log(new aq("c13745").al("obj_locate", 1).al("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kzD != null) {
                if (VideoPbFragment.this.lCs != null && VideoPbFragment.this.lCs.dkj() != null && VideoPbFragment.this.lCs.dkj().bAt()) {
                    VideoPbFragment.this.lCs.dkj().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kzD.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fpP = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bAc() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aFV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v149, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean B;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    aq aqVar = new aq("c13398");
                    aqVar.dR("tid", VideoPbFragment.this.djz().dlx());
                    aqVar.dR("fid", VideoPbFragment.this.djz().getForumId());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.al("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.ltx) {
                        VideoPbFragment.this.ltx = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.ltg != null && postData.bmA() != null && postData.dJZ() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lCs != null) {
                                    VideoPbFragment.this.lCs.dkf();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.djz().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.djz().getPbData().dik());
                                pVar.g(postData);
                                VideoPbFragment.this.ltg.d(pVar);
                                VideoPbFragment.this.ltg.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bmA().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.djz().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lud != null) {
                                    VideoPbFragment.this.uQ(VideoPbFragment.this.lud.bAl());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.drb() != null && VideoPbFragment.this.drb().dnX() != null && view == VideoPbFragment.this.drb().dnX()) || ((com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drd() != null && VideoPbFragment.this.drd().dnX() != null && view == VideoPbFragment.this.drd().dnX()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.djz().uv(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bhX()) {
                            VideoPbFragment.this.drd().dnJ();
                        } else {
                            VideoPbFragment.this.drb().dnJ();
                        }
                    }
                } else if (VideoPbFragment.this.lMj != null && VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmH()) {
                    VideoPbFragment.this.lMj.aZC();
                } else if ((VideoPbFragment.this.lMj != null && ((VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmI()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.lMj.dob();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cyK();
                        VideoPbFragment.this.dnI();
                        if (view.getId() == R.id.owner_reply) {
                            B = VideoPbFragment.this.djz().B(true, VideoPbFragment.this.dkM());
                        } else {
                            B = view.getId() == R.id.all_reply ? VideoPbFragment.this.djz().B(false, VideoPbFragment.this.dkM()) : VideoPbFragment.this.djz().PF(VideoPbFragment.this.dkM());
                        }
                        view.setTag(Boolean.valueOf(B));
                        if (B) {
                            VideoPbFragment.this.cTu();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fxJ) {
                    if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dR("fid", VideoPbFragment.this.djz().getPbData().getForumId());
                            aqVar2.dR("tid", VideoPbFragment.this.djz().dlx());
                            aqVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.ltl, VideoPbFragment.this.fxJ);
                        VideoPbFragment.this.ltl.finish();
                    }
                } else if (view == VideoPbFragment.this.lHo && VideoPbFragment.this.lMj != null) {
                    if (VideoPbFragment.this.djz() == null || VideoPbFragment.this.djz().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dim = VideoPbFragment.this.djz().getPbData().dim();
                    if ((dim == null || dim.size() <= 0) && VideoPbFragment.this.djz().dlz()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dR("tid", VideoPbFragment.this.djz().dlx()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", VideoPbFragment.this.djz().getForumId()));
                    VideoPbFragment.this.lMj.dkA();
                } else if (VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmM()) {
                    if (VideoPbFragment.this.djz() != null) {
                        VideoPbFragment.this.lMj.dob();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cyK();
                            VideoPbFragment.this.dnI();
                            VideoPbFragment.this.djz().FV(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.lMj != null && VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmI()) {
                    VideoPbFragment.this.lMj.aZC();
                } else if (VideoPbFragment.this.lMj != null && ((VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmP()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.lMj.dob();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cyK();
                            VideoPbFragment.this.dnI();
                            VideoPbFragment.this.lMj.dv(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.djz().dlQ()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.lMj != null && VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmG()) {
                    if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().dik() != null) {
                        VideoPbFragment.this.lMj.aZC();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.lMj.PA(VideoPbFragment.this.djz().getPbData().dik().bmR());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.lMj != null) {
                        VideoPbFragment.this.lMj.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.lMj != null && VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmQ()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.C(true, false);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 0).al("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 1).al("obj_source", 1));
                    }
                    VideoPbFragment.this.lMj.dph();
                } else if (VideoPbFragment.this.lMj != null && (view == VideoPbFragment.this.lMj.dnG() || (VideoPbFragment.this.lMj.dpi() != null && (view == VideoPbFragment.this.lMj.dpi().dmL() || view == VideoPbFragment.this.lMj.dpi().dmJ())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.djz() != null || VideoPbFragment.this.djz().getPbData() != null) {
                        if ((VideoPbFragment.this.djz().getPbData().diz() == 1 || VideoPbFragment.this.djz().getPbData().diz() == 3) && !VideoPbFragment.this.hYQ.dKK()) {
                            VideoPbFragment.this.lMj.dob();
                            if (VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmJ()) {
                                if (VideoPbFragment.this.djz().getPbData().dik().bmv() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmL()) {
                                if (VideoPbFragment.this.djz().getPbData().dik().bmw() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.lMj.dnG() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.djz().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.djz().getPbData().dik().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.hYQ.b(id, name, id2, i2, VideoPbFragment.this.lMj.dnH());
                        }
                    }
                } else if (VideoPbFragment.this.lMj != null && VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmO()) {
                    if (VideoPbFragment.this.djz() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.lMj.dob();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.djz().getPbData(), VideoPbFragment.this.djz().dlz(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.djz().getPbData().getForum().getId(), VideoPbFragment.this.djz().getPbData().getForum().getName(), VideoPbFragment.this.djz().getPbData().dik().getId(), String.valueOf(VideoPbFragment.this.djz().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.lMj != null && VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmK()) {
                    if (VideoPbFragment.this.djz() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.djz().getPbData(), VideoPbFragment.this.djz().dlz(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.lMj.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.lMj.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.lMj.aZC();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dR("tid", VideoPbFragment.this.djz().dlx());
                        aqVar3.dR("fid", VideoPbFragment.this.djz().getForumId());
                        aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.al("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").al("obj_locate", 3).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                        if (VideoPbFragment.this.lMj != null) {
                            VideoPbFragment.this.lMj.dob();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dKl() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.mXM != null) {
                                aq brj = postData2.mXM.brj();
                                brj.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    brj.al("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    brj.al("obj_locate", 8);
                                }
                                TiebaStatic.log(brj);
                            }
                            VideoPbFragment.this.cyK();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.djz() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dR("tid", VideoPbFragment.this.djz().dlx());
                            aqVar4.dR("fid", VideoPbFragment.this.djz().getForumId());
                            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.al("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.mXM != null) {
                                    aq brj2 = postData4.mXM.brj();
                                    brj2.delete("obj_locate");
                                    brj2.al("obj_locate", 8);
                                    TiebaStatic.log(brj2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dR("tid", VideoPbFragment.this.djz().dly()).dR("fid", VideoPbFragment.this.djz().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).al("obj_type", 3));
                                }
                                if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.ltg != null && postData4.bmA() != null && postData4.dJZ() != 1) {
                                    if (VideoPbFragment.this.lCs != null) {
                                        VideoPbFragment.this.lCs.dkf();
                                    }
                                    if ((VideoPbFragment.this.lrn || com.baidu.tbadk.a.d.bhL()) && postData4.dJW() != null && postData4.dJW().size() != 0) {
                                        if (com.baidu.tbadk.a.d.bhM()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.djz().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.djz().getPbData().dik());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.ltg.d(pVar2);
                                    VideoPbFragment.this.ltg.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bmA().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lud != null) {
                                        VideoPbFragment.this.uQ(VideoPbFragment.this.lud.bAl());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.lMj != null && VideoPbFragment.this.djz() != null) {
                        if (com.baidu.tbadk.a.d.bhX() || VideoPbFragment.this.drb() != null) {
                            if (!com.baidu.tbadk.a.d.bhX() || VideoPbFragment.this.drd() != null) {
                                VideoPbFragment.this.lMj.dob();
                                if (VideoPbFragment.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.djz() != null) {
                                    VideoPbFragment.this.dkH();
                                    if (VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().dik() != null && VideoPbFragment.this.djz().getPbData().dik().bmA() != null) {
                                        TiebaStatic.log(new aq("c13402").dR("tid", VideoPbFragment.this.djz().dlx()).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()).al("obj_locate", 3).dR("uid", VideoPbFragment.this.djz().getPbData().dik().bmA().getUserId()));
                                    }
                                    if (VideoPbFragment.this.djz().getPbData().dik() != null && VideoPbFragment.this.djz().getPbData().dik().bmA() != null && VideoPbFragment.this.djz().getPbData().dik().bmA().getUserId() != null && VideoPbFragment.this.ltP != null) {
                                        int h = VideoPbFragment.this.lMj.h(VideoPbFragment.this.djz().getPbData());
                                        bw dik = VideoPbFragment.this.djz().getPbData().dik();
                                        if (!dik.bli()) {
                                            if (dik.blj()) {
                                                i = 3;
                                            } else if (dik.bov()) {
                                                i = 4;
                                            } else {
                                                i = dik.bow() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dR("tid", VideoPbFragment.this.djz().dlx()).al("obj_locate", 1).dR("obj_id", VideoPbFragment.this.djz().getPbData().dik().bmA().getUserId()).al("obj_type", VideoPbFragment.this.ltP.biv() ? 0 : 1).al("obj_source", h).al("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vs(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.lMj != null && VideoPbFragment.this.eLl != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().dik() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.djz().getPbData();
                        if (pbData.dik().bmr() != 0) {
                            int currentItem = VideoPbFragment.this.eLl.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bhX() && currentItem == VideoPbFragment.lLN) {
                                VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLO);
                            } else if (com.baidu.tbadk.a.d.bhX() || currentItem == VideoPbFragment.lLO) {
                                if (!com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drb() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bhX() || VideoPbFragment.this.drd() != null) && VideoPbFragment.this.cBD() != null) {
                                    aq dR = new aq("c13403").dR("tid", VideoPbFragment.this.djz().dlx()).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cBD = VideoPbFragment.this.cBD();
                                    if (cBD != null) {
                                        boolean canScrollVertically = cBD.canScrollVertically(1);
                                        boolean canScrollVertically2 = cBD.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Yh != null) {
                                            VideoPbFragment.this.Yh.setExpanded(false, true);
                                        }
                                        if (cBD.getLayoutManager() != null && (cBD.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cBD.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.ltI != -1 || VideoPbFragment.this.ltJ != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.ltI > 3 || (VideoPbFragment.this.ltI == 3 && VideoPbFragment.this.ltJ < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.ltI, VideoPbFragment.this.ltJ + equipmentHeight);
                                                        cBD.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.ltI >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.ltI, VideoPbFragment.this.ltJ + (equipmentHeight / 2));
                                                        cBD.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.ltI == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.ltI, VideoPbFragment.this.ltJ + (equipmentHeight / 4));
                                                        cBD.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cBD.smoothScrollBy(0, -VideoPbFragment.this.ltJ);
                                                    }
                                                    dR.al("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cBD.getFirstVisiblePosition();
                                                View childAt = cBD.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.ltI = firstVisiblePosition;
                                                VideoPbFragment.this.ltJ = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cBD.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cBD.smoothScrollToPosition(0);
                                                } else {
                                                    cBD.smoothScrollToPosition(0);
                                                }
                                                dR.al("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dR);
                                            TiebaStatic.log(new aq("c12942").al("obj_type", 1).al("obj_locate", 4).dR("tid", VideoPbFragment.this.djz().dlx()).dR("nid", pbData.dik().getNid()));
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().dik() != null && VideoPbFragment.this.djz().getPbData().dik().bmA() != null) {
                                TiebaStatic.log(new aq("c13402").dR("tid", VideoPbFragment.this.djz().dlx()).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()).al("obj_locate", 2).dR("uid", VideoPbFragment.this.djz().getPbData().dik().bmA().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.vt(false);
                        VideoPbFragment.this.dkv();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.luq >= 0) {
                        if (VideoPbFragment.this.djz() != null) {
                            VideoPbFragment.this.djz().dmi();
                        }
                        if (com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drd() != null && VideoPbFragment.this.drd().drK() != null) {
                            VideoPbFragment.this.drd().drK().setData(VideoPbFragment.this.djz().getPbData());
                        } else if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.drb() != null && VideoPbFragment.this.drb().drK() != null) {
                            VideoPbFragment.this.drb().drK().setData(VideoPbFragment.this.djz().getPbData());
                        }
                        VideoPbFragment.this.luq = 0;
                        VideoPbFragment.this.lMl = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.djz() != null && VideoPbFragment.this.drd() != null) {
                            VideoPbFragment.this.drd().de(VideoPbFragment.this.djz().dml(), VideoPbFragment.this.djz().dmm());
                            VideoPbFragment.this.djz().db(0, 0);
                        } else if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.drb() != null) {
                            VideoPbFragment.this.drb().de(VideoPbFragment.this.djz().dml(), VideoPbFragment.this.djz().dmm());
                            VideoPbFragment.this.djz().db(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.djz() != null) {
                        aq aqVar5 = new aq("c13398");
                        aqVar5.dR("tid", VideoPbFragment.this.djz().dlx());
                        aqVar5.dR("fid", VideoPbFragment.this.djz().getForumId());
                        aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar5.al("obj_locate", 2);
                        TiebaStatic.log(aqVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bqh().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dnm();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dnm();
                } else if (VideoPbFragment.this.lMj.dpi() != null && view == VideoPbFragment.this.lMj.dpi().dmN()) {
                    VideoPbFragment.this.lMj.dob();
                    if (VideoPbFragment.this.djz() != null) {
                        VideoPbFragment.this.hYS.setThreadId(VideoPbFragment.this.djz().dlx());
                    }
                    if (VideoPbFragment.this.djz() == null || !VideoPbFragment.this.djz().isPrivacy()) {
                        VideoPbFragment.this.hYS.cnN();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().getThreadId() != null && VideoPbFragment.this.djz().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                            VideoPbFragment.this.hYS.l(3, i3, VideoPbFragment.this.djz().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.djz().getPbData() != null) {
                        VideoPbFragment.this.hYS.l(3, 3, VideoPbFragment.this.djz().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener lqF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.lMj != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.lMj.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.lMj.dp(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.lMj.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.lMj.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jWO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public SortSwitchButton.a luP = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zw(int i) {
            if (VideoPbFragment.this.lMj != null) {
                VideoPbFragment.this.lMj.dob();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.djz() == null || VideoPbFragment.this.djz().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cyK();
                VideoPbFragment.this.dnI();
                if (VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().lmT != null && VideoPbFragment.this.djz().getPbData().lmT.size() > i) {
                    int intValue = VideoPbFragment.this.djz().getPbData().lmT.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dR("tid", VideoPbFragment.this.djz().dly()).dR("fid", VideoPbFragment.this.djz().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_type", FT(intValue)));
                    if (VideoPbFragment.this.djz().Ga(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int FT(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 0;
        }
    };
    private a lMk = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dkF() {
        if (djz() != null && djz().getPbData() != null && djz().getPbData().dik() != null) {
            bw dik = djz().getPbData().dik();
            dik.mRecomAbTag = djz().dms();
            dik.mRecomWeight = djz().dmq();
            dik.mRecomSource = djz().dmr();
            dik.mRecomExtra = djz().dmt();
            if (dik.getFid() == 0) {
                dik.setFid(com.baidu.adp.lib.f.b.toLong(djz().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dik, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(boolean z) {
        if (djz() != null && djz().getPbData() != null && djz().getPbData().dik() != null) {
            bw dik = djz().getPbData().dik();
            dik.mRecomAbTag = djz().dms();
            dik.mRecomWeight = djz().dmq();
            dik.mRecomSource = djz().dmr();
            dik.mRecomExtra = djz().dmt();
            if (dik.getFid() == 0) {
                dik.setFid(com.baidu.adp.lib.f.b.toLong(djz().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dik, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (a2 != null && eu != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.al("reply_type", 1);
                if (z) {
                    a2.al("obj_type", 2);
                } else {
                    a2.al("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        hideProgressBar();
        if (z && z2) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z2) {
            if (at.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.mZE) ? bVar.mZE : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bo(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.iV(true);
                aVar.b(getPageContext());
                aVar.bpc();
            } else {
                a(0, bVar.QP, bVar.mZE, z);
            }
            if (bVar.QP) {
                if (bVar.ioi == 1) {
                    ArrayList<PostData> dim = djz().getPbData().dim();
                    int size = dim.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dim.get(i).getId())) {
                            i++;
                        } else {
                            dim.remove(i);
                            break;
                        }
                    }
                    djz().getPbData().dik().oj(djz().getPbData().dik().bmr() - 1);
                    if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
                        drd().drM();
                    } else if (drb() != null) {
                        drb().drM();
                    }
                } else if (bVar.ioi == 0) {
                    dkG();
                } else if (bVar.ioi == 2) {
                    ArrayList<PostData> dim2 = djz().getPbData().dim();
                    int size2 = dim2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dim2.get(i2).dJW().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dim2.get(i2).dJW().get(i3).getId())) {
                                i3++;
                            } else {
                                dim2.get(i2).dJW().remove(i3);
                                dim2.get(i2).dJY();
                                z2 = true;
                                break;
                            }
                        }
                        dim2.get(i2).SR(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
                            drd().drM();
                        } else if (drb() != null) {
                            drb().drM();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = djz().getPbData().diy().loD;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dJW().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dJW().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dJW().remove(i2);
                    list.get(i).dJY();
                    z = true;
                    break;
                }
            }
            list.get(i).SR(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
                drd().drM();
            } else if (drb() != null) {
                drb().drM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && djz() != null && djz().getPbData() != null && djz().getPbData().dik() != null) {
            a(this.hYQ.getLoadDataMode(), gVar.QP, gVar.mZE, false);
            if (gVar.QP) {
                this.ltS = true;
                if (i == 2 || i == 3) {
                    this.ltT = true;
                    this.ltU = false;
                } else if (i == 4 || i == 5) {
                    this.ltT = false;
                    this.ltU = true;
                }
                if (i == 2) {
                    djz().getPbData().dik().om(1);
                    djz().setIsGood(1);
                } else if (i == 3) {
                    djz().getPbData().dik().om(0);
                    djz().setIsGood(0);
                } else if (i == 4) {
                    djz().getPbData().dik().ol(1);
                    djz().FU(1);
                } else if (i == 5) {
                    djz().getPbData().dik().ol(0);
                    djz().FU(0);
                }
            }
            if (djz().getPbData().dik() != null && drc() != null) {
                drc().drW();
            }
        }
    }

    private void dkG() {
        if (djz().dlA() || djz().dlC()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", djz().dlx());
            PbActivity pbActivity = this.ltl;
            PbActivity pbActivity2 = this.ltl;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, djz().dlx()));
        if (dkJ()) {
            this.ltl.finish();
        }
    }

    private boolean dkJ() {
        if (djz() == null) {
            return true;
        }
        if (djz().getPbData() == null || !djz().getPbData().diN()) {
            if (djz().biv()) {
                final MarkData dlR = djz().dlR();
                if (dlR == null || !djz().getIsFromMark() || cBD() == null) {
                    return true;
                }
                final MarkData Gb = djz().Gb(cBD().getFirstVisiblePosition());
                if (Gb == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dlR);
                    this.ltl.setResult(-1, intent);
                    return true;
                } else if (Gb.getPostId() == null || Gb.getPostId().equals(dlR.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dlR);
                    this.ltl.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Bo(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.ltP != null) {
                                if (VideoPbFragment.this.ltP.biv()) {
                                    VideoPbFragment.this.ltP.biw();
                                    VideoPbFragment.this.ltP.iq(false);
                                }
                                VideoPbFragment.this.ltP.a(Gb);
                                VideoPbFragment.this.ltP.iq(true);
                                VideoPbFragment.this.ltP.bix();
                            }
                            dlR.setPostId(Gb.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlR);
                            VideoPbFragment.this.ltl.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.djM();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlR);
                            VideoPbFragment.this.ltl.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.djM();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bpc();
                    return false;
                }
            } else if (djz().getPbData() == null || djz().getPbData().dim() == null || djz().getPbData().dim().size() <= 0 || !djz().getIsFromMark()) {
                return true;
            } else {
                this.ltl.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djM() {
        this.ltl.djM();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void vs(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (djz() != null && this.lMj != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = djz().getPbData()) != null) {
                bw dik = pbData.dik();
                if (dik != null && dik.bmA() != null) {
                    TiebaStatic.log(new aq("c13402").dR("tid", djz().dlx()).dR("fid", pbData.getForumId()).al("obj_locate", 4).dR("uid", dik.bmA().getUserId()));
                }
                if (dik != null) {
                    if (dik.bli()) {
                        i = 2;
                    } else if (dik.blj()) {
                        i = 3;
                    } else if (dik.bov()) {
                        i = 4;
                    } else if (dik.bow()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dR("tid", djz().dlx());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dR("fid", djz().getForumId());
                    if (!z) {
                        aqVar.al("obj_locate", 6);
                    } else {
                        aqVar.al("obj_locate", 5);
                    }
                    aqVar.al("obj_name", i);
                    aqVar.al("obj_type", 2);
                    if (dik != null) {
                        if (dik.bli()) {
                            aqVar.al("obj_type", 10);
                        } else if (dik.blj()) {
                            aqVar.al("obj_type", 9);
                        } else if (dik.bow()) {
                            aqVar.al("obj_type", 8);
                        } else if (dik.bov()) {
                            aqVar.al("obj_type", 7);
                        } else if (dik.isShareThread) {
                            aqVar.al("obj_type", 6);
                        } else if (dik.threadType == 0) {
                            aqVar.al("obj_type", 1);
                        } else if (dik.threadType == 40) {
                            aqVar.al("obj_type", 2);
                        } else if (dik.threadType == 49) {
                            aqVar.al("obj_type", 3);
                        } else if (dik.threadType == 54) {
                            aqVar.al("obj_type", 4);
                        } else {
                            aqVar.al("obj_type", 5);
                        }
                        aqVar.dR("nid", dik.getNid());
                        aqVar.al(IntentConfig.CARD_TYPE, dik.boz());
                        aqVar.dR(IntentConfig.RECOM_SOURCE, dik.mRecomSource);
                        aqVar.dR("ab_tag", dik.mRecomAbTag);
                        aqVar.dR("weight", dik.mRecomWeight);
                        aqVar.dR("extra", dik.mRecomExtra);
                        aqVar.dR("nid", dik.getNid());
                        if (dik.getBaijiahaoData() != null && !at.isEmpty(dik.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dR("obj_param6", dik.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dle() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dle(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (djz().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dim = pbData.dim();
                        if ((dim == null || dim.size() <= 0) && djz().dlz()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.lMj.dob();
                        cyK();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), dik)) {
                            if (this.lBQ != null) {
                                this.lBQ.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                FR(z ? 2 : 1);
                                return;
                            }
                            this.lMj.showLoadingDialog();
                            djz().dmc().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dR("tid", djz().dlx());
                aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dR("fid", djz().getForumId());
                if (!z) {
                }
                aqVar2.al("obj_name", i);
                aqVar2.al("obj_type", 2);
                if (dik != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dle() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dqI() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.dro());
        K(eVar.dro());
        if (djz() != null && djz().getPbData() != null) {
            boolean isFromMark = djz().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = djz().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.biu() != null && !pbData.biu().equals(I.getId()) && this.eLl != null) {
                    if (com.baidu.tbadk.a.d.bhX()) {
                        this.eLl.setCurrentItem(lLP);
                    } else {
                        this.eLl.setCurrentItem(lLO);
                    }
                }
            }
        }
        eVar.drp().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                BdTypeRecyclerView cBD;
                if (bwVar != null && bwVar.bmS() != null) {
                    if (VideoPbFragment.this.lLW.getVideoUrl() == null || !VideoPbFragment.this.lLW.getVideoUrl().equals(bwVar.bmS().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.lLW.getVideoUrl())) {
                            VideoPbFragment.this.ltz = true;
                            if (com.baidu.tbadk.a.d.bhX()) {
                                VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLP);
                            } else {
                                VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLN);
                            }
                            if (com.baidu.tbadk.a.d.bhX() && (cBD = VideoPbFragment.this.cBD()) != null) {
                                cBD.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.lLX == null || !VideoPbFragment.this.lLX.isPlaying()) {
                            VideoPbFragment.this.dqJ();
                            VideoPbFragment.this.aN(bwVar);
                        }
                        VideoPbFragment.this.dqK();
                        if (VideoPbFragment.this.lLX.drC()) {
                            VideoPbFragment.this.lLX.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.lLW.getVideoUrl(), bwVar.bmS().video_url);
                        VideoPbFragment.this.lLW.setData(bwVar);
                        if (com.baidu.tbadk.a.d.bhX()) {
                            VideoPbFragment.this.lLW.vB(false);
                        } else {
                            VideoPbFragment.this.lLW.vB(VideoPbFragment.this.eLl.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.lLW.startPlay();
                            VideoPbFragment.this.lLW.dso();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.lLW.setData(bwVar);
                }
            }
        });
        eVar.dry().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: s */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eLl.setCurrentItem(num.intValue());
            }
        });
        eVar.drt().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.lLW.aS(bwVar);
            }
        });
        eVar.dru().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.lLW.aT(bwVar);
            }
        });
        eVar.drv().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dqU();
            }
        });
        eVar.drw().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqJ() {
        ViewGroup.LayoutParams layoutParams = this.lLZ.getLayoutParams();
        layoutParams.height = 0;
        this.lLZ.setLayoutParams(layoutParams);
        this.lLZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqK() {
        if (this.lLX == null) {
            this.lLX = new f(getBaseFragmentActivity(), this.lLV);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dle()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.lLV.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.lLX.b(eVar.drq(), rect);
            if (this.lLX.drC()) {
                this.lLX.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bhX()) {
                            if (eVar.drr() || VideoPbFragment.this.djz().getTabIndex() == VideoPbFragment.lLP) {
                                VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLP);
                            }
                        } else if (eVar.drr() || VideoPbFragment.this.djz().getTabIndex() == VideoPbFragment.lLO) {
                            VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLO);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bhX()) {
                            if (eVar.drr() || VideoPbFragment.this.djz().getTabIndex() == VideoPbFragment.lLP) {
                                VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLP);
                            }
                        } else if (eVar.drr() || VideoPbFragment.this.djz().getTabIndex() == VideoPbFragment.lLO) {
                            VideoPbFragment.this.eLl.setCurrentItem(VideoPbFragment.lLO);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bhX()) {
                if (eVar.drr() || djz().getTabIndex() == lLP) {
                    this.eLl.setCurrentItem(lLP);
                }
            } else if (eVar.drr() || djz().getTabIndex() == lLO) {
                this.eLl.setCurrentItem(lLO);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.lMp && (this.lMq || dri())) {
            drh();
            UtilHelper.hideStatusBar(dle(), dle().getRootView());
            this.lMq = false;
            if (this.lLW != null) {
                this.lLW.vu(false);
            }
        }
        if (i == 4) {
            return this.lLW.dxB();
        }
        if (i == 24) {
            return this.lLW.dsl();
        }
        if (i == 25) {
            return this.lLW.dsm();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aN(bw bwVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dmu;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bwVar != null && bwVar.bmS() != null) {
            int intValue = bwVar.bmS().video_width.intValue();
            int intValue2 = bwVar.bmS().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (djz() != null || (dmu = djz().dmu()) == null) ? ceil : dmu.height();
                i = 0;
                layoutParams = this.lLV.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.lLV.setLayoutParams(layoutParams);
                this.lLV.setMaxHeight(ceil);
                this.lLV.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.lLV.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bhX()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lLR.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, lLQ);
                    } else {
                        layoutParams3.height = lLQ;
                    }
                    this.lLR.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Yh.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bhX()) {
                    ceil += lLQ;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.Yh.setLayoutParams(layoutParams2);
                if (i == 0 && (this.Yh.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Yh.getLayoutParams()).getBehavior();
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
        if (djz() != null) {
        }
        i = 0;
        layoutParams = this.lLV.getLayoutParams();
        if (layoutParams != null) {
        }
        this.lLV.setLayoutParams(layoutParams);
        this.lLV.setMaxHeight(ceil2);
        this.lLV.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.lLV.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bhX()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.Yh.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bhX()) {
        }
        if (layoutParams2 != null) {
        }
        this.Yh.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.ltt = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.luk = new com.baidu.tbadk.core.view.c();
        this.luk.toastTime = 1000L;
        if (this.lMj != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.lMj.lul;
            userMuteAddAndDelCustomMessage.setTag(this.lMj.lul);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.lMj.lul;
            userMuteCheckCustomMessage.setTag(this.lMj.lul);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.hYS = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
    }

    private void initData() {
        this.ltP = com.baidu.tbadk.baseEditMark.a.a(this.ltl);
        if (this.ltP != null) {
            this.ltP.a(this.luV);
        }
        this.hYQ = new ForumManageModel(this.ltl);
        this.hYQ.setLoadDataCallBack(this.hYX);
        this.eNr = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lMj = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.luc = new g();
        d(this.luc);
        this.lud = (com.baidu.tbadk.editortools.pb.e) this.luc.ei(getActivity());
        this.lud.a(this.ltl.getPageContext());
        this.lud.a(this.fpW);
        this.lud.a(this.fpP);
        this.lud.setFrom(1);
        this.lud.a(this.ltl.getPageContext(), bundle);
        this.lud.bzx().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lud.bzx().kb(true);
        uh(true);
        this.lud.a(djz().dlN(), djz().dlx(), djz().dme());
        registerListener(this.luA);
        registerListener(this.luU);
        registerListener(this.luz);
        registerListener(this.lux);
        registerListener(this.iIQ);
        if (!djz().dlE()) {
            this.lud.DO(djz().dlx());
        }
        if (djz().dmf()) {
            this.lud.DM(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lud.DM(dno());
        }
        this.kzD = new bb();
        if (this.lud.bAd() != null) {
            this.kzD.e(this.lud.bAd().getInputView());
        }
        this.lud.a(this.fpQ);
        this.kvy = new am(getPageContext());
        this.kvy.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == am.eNm) {
                        VideoPbFragment.this.lud.a((String) null, (WriteData) null);
                    } else if (i == am.eNn && VideoPbFragment.this.lCs != null && VideoPbFragment.this.lCs.dkj() != null) {
                        VideoPbFragment.this.lCs.dkj().bAB();
                    } else if (i == am.eNo) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lug);
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
        this.iMk = new com.baidu.tieba.f.b(getActivity());
        this.iMk.a(lvd);
        this.lMp = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bCV();
        this.Yh = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.lLT = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.lLV = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.lLW = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.lLV);
        this.lLW.setStageType("2002");
        this.lLW.setUniqueId(getUniqueId());
        this.lLW.af(this);
        this.lLW.dw(dle().getRootView());
        this.lLW.dx(this.lLY);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.lLR = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.lLZ = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eLl = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.lLU = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.lLU.setOnClickListener(this.aFV);
        dqM();
        dqL();
        dqN();
        this.lLS = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eLl.setAdapter(this.lLS);
        this.lLR.setViewPager(this.eLl);
        this.lLR.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drd() != null) {
                        VideoPbFragment.this.drd().vA(false);
                    } else if (VideoPbFragment.this.drb() != null) {
                        VideoPbFragment.this.drb().vA(false);
                    }
                    if (VideoPbFragment.this.drc() != null) {
                        VideoPbFragment.this.drc().vA(true);
                        VideoPbFragment.this.GA(VideoPbFragment.this.drc().drQ() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.drv() != null && eVar.drv().getValue() != null && eVar.drv().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.lLW.vB(z);
                    VideoPbFragment.this.dnm();
                    if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dR("tid", VideoPbFragment.this.djz().dlx()).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.drc() != null) {
                        VideoPbFragment.this.drc().vA(false);
                    }
                    if (com.baidu.tbadk.a.d.bhX() && VideoPbFragment.this.drd() != null) {
                        VideoPbFragment.this.drd().vA(true);
                        int drQ = VideoPbFragment.this.drd().drQ();
                        int drR = VideoPbFragment.this.drd().drR();
                        if (drQ != 0) {
                            VideoPbFragment.this.GA(8);
                            VideoPbFragment.this.drd().GA(0);
                        } else if (drR != 0) {
                            VideoPbFragment.this.drd().GA(8);
                            VideoPbFragment.this.GA(0);
                        } else {
                            VideoPbFragment.this.drd().GA(8);
                            VideoPbFragment.this.GA(8);
                        }
                    } else if (VideoPbFragment.this.drb() != null) {
                        VideoPbFragment.this.drb().vA(true);
                        int drQ2 = VideoPbFragment.this.drb().drQ();
                        int drR2 = VideoPbFragment.this.drb().drR();
                        if (drQ2 != 0) {
                            VideoPbFragment.this.GA(8);
                            VideoPbFragment.this.drb().GA(0);
                        } else if (drR2 != 0) {
                            VideoPbFragment.this.drb().GA(8);
                            VideoPbFragment.this.GA(0);
                        } else {
                            VideoPbFragment.this.drb().GA(8);
                            VideoPbFragment.this.GA(8);
                        }
                    }
                    VideoPbFragment.this.lLW.vB(false);
                    VideoPbFragment.this.Yh.setExpanded(false, true);
                    if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dR("tid", VideoPbFragment.this.djz().dlx()).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.lLS.GC(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lBs = this.rootView.findViewById(R.id.viewstub_progress);
        dqO();
        bTR();
        if (!this.lMp && this.lMq) {
            drh();
            UtilHelper.hideStatusBar(dle(), dle().getRootView());
            this.lMq = false;
        }
        if (com.baidu.tbadk.a.d.bhX()) {
            this.lLR.getLayoutParams().height = 0;
        }
    }

    private void dqL() {
        this.lMb = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.lMf = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.lMc = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.lMd = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.lMe = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.lMg = this.rootView.findViewById(R.id.ala_live_point);
        this.lMf.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.lMf.setConrers(15);
        this.lMe.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.lMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lnE == null || VideoPbFragment.this.lnE.dsc()) {
                    if (VideoPbFragment.this.lnE != null) {
                        TiebaStatic.log(new aq("c13608").dR("tid", VideoPbFragment.this.djz().getPbData().getThreadId()));
                        VideoPbFragment.this.lnE.lOm = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.dqW();
            }
        });
        this.lMe.setOnClickListener(this.lMa);
        this.lLZ.setOnClickListener(this.lMa);
    }

    private void dqM() {
        this.lLR.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.lLR.setContainerLayoutParams(layoutParams);
        this.lLR.setRectPaintColor(R.color.cp_link_tip_a);
        this.lLR.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.lLR.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.lLR.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.lLR.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.lLR.setExpandedTabLayoutParams(layoutParams2);
    }

    public void vt(boolean z) {
        if (this.Yh != null) {
            this.Yh.setExpanded(z);
        }
    }

    private void dqN() {
        this.lBJ = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lBK = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lBU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lBV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lBM = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lBM.setVisibility(0);
        this.lBM.setIsRound(true);
        this.lBM.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.lBM.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.lBM.setPlaceHolder(1);
        this.lBM.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lBM.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jKd = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lBL = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lBL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.vt(false);
                VideoPbFragment.this.dkv();
                if (VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().dik() != null && VideoPbFragment.this.djz().getPbData().dik().bmA() != null) {
                    TiebaStatic.log(new aq("c13701").dR("tid", VideoPbFragment.this.djz().dly()).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dR("tid", VideoPbFragment.this.djz().dlx()).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()).al("obj_locate", 1).dR("uid", VideoPbFragment.this.djz().getPbData().dik().bmA().getUserId()));
                }
            }
        });
        this.lBN = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lBN.setOnClickListener(this.aFV);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lBO = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lBO.setOnClickListener(this.aFV);
        if (booleanExtra) {
            this.lBO.setVisibility(8);
        } else {
            this.lBO.setVisibility(0);
        }
        this.lBP = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lBP.setOnClickListener(this.aFV);
        this.lBQ = new com.baidu.tieba.pb.view.c(this.lBP);
        this.lBQ.dsx();
        this.lBR = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lBR.setVisibility(0);
        uS(false);
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cyL();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.lLY = this.rootView.findViewById(R.id.status_bar_background);
        if (this.lMp) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dle());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.lLY.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dle());
            this.lLY.setLayoutParams(layoutParams2);
            this.lLY.setVisibility(0);
        }
        this.fxJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aFV);
        this.gFB = (ImageView) this.fxJ.findViewById(R.id.widget_navi_back_button);
        SvgManager.brn().a(this.gFB, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.lHo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aFV);
        this.agS = (ImageView) this.lHo.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.lHo.setLayoutParams(layoutParams3);
        SvgManager.brn().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.lHo.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.iTq);
        this.mNavigationBar.setOnTouchListener(this.lMr);
    }

    public void dqO() {
        setEditorTools(this.lud.bzx());
    }

    private void bTR() {
        this.ltg = new PbFakeFloorModel(getPageContext());
        this.lCs = new v(getPageContext(), this.ltg, this.rootView);
        this.lCs.U(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dnm();
            }
        });
        this.lCs.a(this.luR);
        this.ltg.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.ltg.t(postData);
                if (com.baidu.tbadk.a.d.bhX() || VideoPbFragment.this.drd() != null) {
                    VideoPbFragment.this.drd().drM();
                } else if (VideoPbFragment.this.drb() != null) {
                    VideoPbFragment.this.drb().drM();
                }
                VideoPbFragment.this.lCs.dkf();
                VideoPbFragment.this.abk.bxU();
                VideoPbFragment.this.uS(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a PD;
        String dlx = djz().dlx();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (djz().getPbData() != null) {
            i = djz().getPbData().diz();
        }
        if (drb() != null && drb().drO() != null) {
            PD = drb().drO().PD(id);
        } else if (drd() != null && drd().drO() != null) {
            PD = drd().drO().PD(id);
        } else {
            return;
        }
        if (postData != null && djz() != null && djz().getPbData() != null && PD != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dlx, id, "pb", true, null, false, str, i, postData.dqh(), djz().getPbData().getAnti(), false, postData.bmA().getIconInfo()).addBigImageData(PD.lqa, PD.exw, PD.exu, PD.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(djz().getForumId());
            addBigImageData.setBjhData(djz().dlG());
            addBigImageData.setKeyPageStartFrom(djz().dmh());
            addBigImageData.setFromFrsForumId(djz().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ltl = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (djz() != null) {
            djz().aC(bundle);
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
        this.bFd = true;
        getVoiceManager().onPause(getPageContext());
        this.lLW.re(true);
        if (djz() != null && !djz().dlE()) {
            this.lud.DN(djz().dlx());
        }
        com.baidu.tbadk.BdToken.c.bgf().bgq();
        MessageManager.getInstance().unRegisterListener(this.luK);
        MessageManager.getInstance().unRegisterListener(this.luL);
        MessageManager.getInstance().unRegisterListener(this.luM);
        MessageManager.getInstance().unRegisterListener(this.jWO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bFd = false;
        getVoiceManager().onResume(getPageContext());
        this.lLW.re(false);
        dla();
        registerListener(this.luK);
        registerListener(this.luL);
        registerListener(this.luM);
        registerListener(this.jWO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.lLS != null && this.eLl != null) {
            this.lLS.GC(z ? this.eLl.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.lBM != null) {
            this.lBM.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lBQ != null) {
            this.lBQ.onDestroy();
        }
        if (this.hYQ != null) {
            this.hYQ.cancelLoadData();
        }
        if (this.lLW != null) {
            this.lLW.onDestroy();
        }
        if (this.ltE != null) {
            this.ltE.cancelLoadData();
        }
        if (this.kvy != null) {
            this.kvy.onDestroy();
        }
        if (djz() != null) {
            djz().cancelLoadData();
            djz().destory();
            if (djz().dmb() != null) {
                djz().dmb().onDestroy();
            }
        }
        if (this.lud != null) {
            this.lud.onDestroy();
        }
        this.luk = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.ltl);
        this.lLR.onChangeSkinType();
        ap.setBackgroundColor(this.lLR, R.color.cp_bg_line_h);
        this.kzD.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.lLX == null || !this.lLX.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        ap.setBackgroundColor(this.lLY, R.color.cp_mask_b_alpha66);
        if (this.abk != null) {
            this.abk.onChangeSkinType(i);
        }
        if (this.lCs != null) {
            this.lCs.onChangeSkinType(i);
        }
        if (this.jKd != null) {
            ap.setViewTextColor(this.jKd, R.color.cp_cont_d);
        }
        if (this.lBM != null) {
            this.lBM.setBorderColor(ap.getColor(R.color.cp_border_a));
        }
        if (this.lBL != null) {
            this.lBL.setBackgroundDrawable(ap.aO(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
        }
        if (this.lBO != null && djz() != null) {
            if (djz().biv()) {
                SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.lBN != null) {
            SvgManager.brn().a(this.lBN, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (djz() != null) {
            x(djz().getPbData());
        }
        if (this.lBR != null) {
            ap.c(this.lBR, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.lBR, R.color.cp_cont_j);
        }
        if (this.lBS != null) {
            ap.setViewTextColor(this.lBS, R.color.cp_cont_b);
        }
        if (this.lBJ != null) {
            ap.setBackgroundResource(this.lBJ, R.drawable.bottom_shadow);
        }
        ap.setBackgroundColor(this.lBK, R.color.cp_bg_line_h);
        if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
            drd().onChangeSkinType(i);
        } else if (drb() != null) {
            drb().onChangeSkinType(i);
        }
        if (drc() != null) {
            drc().onChangeSkinType(i);
        }
        if (this.lLT != null) {
            ap.setBackgroundResource(this.lLT, R.drawable.personalize_tab_shadow);
        }
        if (this.lLZ != null) {
            ap.setBackgroundColor(this.lLZ, R.color.cp_bg_line_g);
        }
        if (this.lMd != null) {
            SvgManager.brn().a(this.lMd, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.lMb != null) {
            ap.setViewTextColor(this.lMb, R.color.cp_cont_b);
        }
        if (this.lMc != null) {
            ap.setViewTextColor(this.lMc, R.color.cp_cont_d);
        }
        if (this.lMg != null) {
            this.lMg.setBackgroundDrawable(ap.aO(l.getDimens(this.lMg.getContext(), R.dimen.tbds32), ap.getColor(R.color.cp_other_c)));
        }
        cyK();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        if (this.iHo != null) {
            this.iHo.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dlc() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dld() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel djz() {
        return this.ltl.djz();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dle() {
        return this.ltl;
    }

    public com.baidu.tbadk.baseEditMark.a dqP() {
        return this.ltP;
    }

    public View.OnClickListener dqQ() {
        return this.aFV;
    }

    public View.OnClickListener dqR() {
        return this.lqF;
    }

    public View.OnLongClickListener dqS() {
        return this.lMj.dqS();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.be.PS(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.d(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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

    public BdTypeRecyclerView cBD() {
        Iterator<BaseFragment> it = this.lLS.drm().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof DetailInfoAndReplyFragment) {
                return ((DetailInfoAndReplyFragment) next).getListView();
            }
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void uh(boolean z) {
        this.lud.ki(z);
        this.lud.kj(z);
        this.lud.kk(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.lMj != null) {
            if (z) {
                this.lMj.dob();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.lMj.doc();
            } else {
                this.lMj.dob();
            }
        }
    }

    public boolean FP(int i) {
        if (this.kvy == null || djz() == null || djz().getPbData() == null || djz().getPbData().getAnti() == null) {
            return true;
        }
        return this.kvy.aN(djz().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dkx() {
        if ((djz() != null && djz().getPbData().diN()) || this.kvy == null || djz() == null || djz().getPbData() == null || djz().getPbData().getAnti() == null) {
            return true;
        }
        return this.kvy.oT(djz().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && djz() != null) {
            gVar.setForumName(djz().djr());
            if (djz().getPbData() != null && djz().getPbData().getForum() != null) {
                gVar.a(djz().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(djz());
        }
    }

    public void dnD() {
        if (this.abk != null) {
            this.abk.display();
            if (this.lud != null) {
                this.lud.bAi();
            }
            dol();
        }
    }

    public com.baidu.tbadk.editortools.pb.e dkk() {
        return this.lud;
    }

    private boolean dku() {
        PbModel djz = djz();
        if (djz == null || djz.getPbData() == null) {
            return false;
        }
        bw dik = djz.getPbData().dik();
        djz.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dik);
    }

    public void dkv() {
        if (checkUpIsLogin() && djz() != null && djz().getPbData() != null && djz().getPbData().getForum() != null && !dku()) {
            if (djz().getPbData().diN()) {
                cMc();
                return;
            }
            if (this.iLK == null) {
                this.iLK = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iLK.Ac(0);
                this.iLK.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pI(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pJ(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lud != null && VideoPbFragment.this.lud.bzx() != null) {
                                VideoPbFragment.this.lud.bzx().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cMc();
                        }
                    }
                });
            }
            this.iLK.G(djz().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(djz().dlx(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lud.onActivityResult(i, i2, intent);
        if (this.ltE != null) {
            this.ltE.onActivityResult(i, i2, intent);
        }
        if (this.lCs != null) {
            this.lCs.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dkH();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dzT().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lug = emotionImageData;
                        if (FP(am.eNo)) {
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
        if (dle() != null) {
            if (this.lMq && !TbSingleton.getInstance().isNotchScreen(dle()) && !TbSingleton.getInstance().isCutoutScreen(dle())) {
                drh();
                UtilHelper.hideStatusBar(dle(), dle().getRootView());
                this.lMq = false;
            }
            this.lMk.lMF = z;
            dqT();
            dqU();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.ltl;
        if (i == 0) {
            dni();
            if (this.lCs != null) {
                this.lCs.dkf();
            }
            uS(false);
        }
        dnm();
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
                        this.lud.resetData();
                        this.lud.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lud.b(writeData);
                        m rk = this.lud.bzx().rk(6);
                        if (rk != null && rk.fnp != null) {
                            rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.ltl;
                        if (i == -1) {
                            this.lud.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lCs != null && this.lCs.dkj() != null) {
                            com.baidu.tbadk.editortools.pb.h dkj = this.lCs.dkj();
                            dkj.setThreadData(djz().getPbData().dik());
                            dkj.b(writeData);
                            dkj.setVoiceModel(pbEditorData.getVoiceModel());
                            m rk2 = dkj.bzx().rk(6);
                            if (rk2 != null && rk2.fnp != null) {
                                rk2.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.ltl;
                            if (i == -1) {
                                dkj.bAB();
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
                if (djz() != null && !djz().dlE()) {
                    antiData.setBlock_forum_name(djz().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(djz().getPbData().getForum().getId());
                    antiData.setUser_name(djz().getPbData().getUserData().getUserName());
                    antiData.setUser_id(djz().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bR(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.lMj != null) {
                this.lMj.DT(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dlg() {
        if (djz() != null && this.ltl != null) {
            if (this.lud == null || !this.lud.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lud = (com.baidu.tbadk.editortools.pb.e) dVar.ei(getContext());
                this.lud.a(this.ltl.getPageContext());
                this.lud.a(this.fpW);
                this.lud.a(this.fpP);
                this.lud.a(this.ltl.getPageContext(), this.ltl.getIntent() == null ? null : this.ltl.getIntent().getExtras());
                this.lud.bzx().kb(true);
                setEditorTools(this.lud.bzx());
                if (!djz().dlE()) {
                    this.lud.DO(djz().dlx());
                }
                if (djz().dmf()) {
                    this.lud.DM(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lud.DM(dno());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
        this.abk.setId(R.id.pb_editor);
        this.abk.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dnm();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.abk.getParent() == null) {
            this.rootView.addView(this.abk, layoutParams);
        }
        this.abk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abk.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).buM() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).buM() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lud.c((u) aVar.data);
                            VideoPbFragment.this.lud.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dni();
        this.lud.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.abk != null && VideoPbFragment.this.abk.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kzD != null && VideoPbFragment.this.kzD.doC() != null) {
                    if (!VideoPbFragment.this.kzD.doC().dSW()) {
                        VideoPbFragment.this.kzD.uY(false);
                    }
                    VideoPbFragment.this.kzD.doC().yq(false);
                }
            }
        });
    }

    public void cMc() {
        if (!checkUpIsLogin()) {
            if (djz() != null) {
                TiebaStatic.log(new aq("c10517").al("obj_locate", 2).dR("fid", djz().getForumId()));
            }
        } else if (dkx()) {
            if (this.lud != null && (this.lud.bAs() || this.lud.bAt())) {
                this.lud.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abk != null) {
                dnD();
                this.lMk.lME = false;
                if (this.abk.rk(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.abk.rk(2).fnp, false, null);
                }
            }
            dol();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dku() && dkx()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.ltG);
                this.ltH = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lCs != null && postData != null) {
                String str3 = "";
                if (postData.dKb() != null) {
                    str3 = postData.dKb().toString();
                }
                this.lCs.Px(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bmA().getName_show(), str3));
            }
            if (djz() != null && djz().getPbData() != null && djz().getPbData().diN()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.ltl.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.ltG[1] + VideoPbFragment.this.ltH) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cBD() != null) {
                            VideoPbFragment.this.cBD().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lCs != null) {
                            VideoPbFragment.this.lud.bzx().setVisibility(8);
                            VideoPbFragment.this.lCs.h(str, str2, VideoPbFragment.this.dno(), (VideoPbFragment.this.djz() == null || VideoPbFragment.this.djz().getPbData() == null || VideoPbFragment.this.djz().getPbData().dik() == null || !VideoPbFragment.this.djz().getPbData().dik().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkj = VideoPbFragment.this.lCs.dkj();
                            if (dkj != null && VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                                dkj.a(VideoPbFragment.this.djz().getPbData().getAnti());
                                dkj.setThreadData(VideoPbFragment.this.djz().getPbData().dik());
                            }
                            if (VideoPbFragment.this.kzD.doE() == null && VideoPbFragment.this.lCs.dkj().bAJ() != null) {
                                VideoPbFragment.this.lCs.dkj().bAJ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kzD != null && VideoPbFragment.this.kzD.doD() != null) {
                                            if (!VideoPbFragment.this.kzD.doD().dSW()) {
                                                VideoPbFragment.this.kzD.uZ(false);
                                            }
                                            VideoPbFragment.this.kzD.doD().yq(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kzD.f(VideoPbFragment.this.lCs.dkj().bAJ().getInputView());
                                VideoPbFragment.this.lCs.dkj().a(VideoPbFragment.this.lui);
                            }
                        }
                        VideoPbFragment.this.dol();
                    }
                }, 0L);
                return;
            }
            if (this.luf == null) {
                this.luf = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.luf.Ac(1);
                this.luf.a(new AnonymousClass48(str, str2));
            }
            if (djz() != null && djz().getPbData() != null && djz().getPbData().getForum() != null) {
                this.luf.G(djz().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(djz().dlx(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$48  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass48 implements c.a {
        final /* synthetic */ String lvn;
        final /* synthetic */ String lvo;

        AnonymousClass48(String str, String str2) {
            this.lvn = str;
            this.lvo = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pI(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pJ(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.ltG[1] + VideoPbFragment.this.ltH) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cBD() != null) {
                            VideoPbFragment.this.cBD().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lCs != null) {
                            VideoPbFragment.this.lud.bzx().setVisibility(8);
                            VideoPbFragment.this.lCs.h(AnonymousClass48.this.lvn, AnonymousClass48.this.lvo, VideoPbFragment.this.dno(), (VideoPbFragment.this.djz() == null || VideoPbFragment.this.djz().getPbData() == null || VideoPbFragment.this.djz().getPbData().dik() == null || !VideoPbFragment.this.djz().getPbData().dik().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkj = VideoPbFragment.this.lCs.dkj();
                            if (dkj != null && VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null) {
                                dkj.a(VideoPbFragment.this.djz().getPbData().getAnti());
                                dkj.setThreadData(VideoPbFragment.this.djz().getPbData().dik());
                            }
                            if (VideoPbFragment.this.kzD.doE() == null && VideoPbFragment.this.lCs.dkj().bAJ() != null) {
                                VideoPbFragment.this.lCs.dkj().bAJ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kzD != null && VideoPbFragment.this.kzD.doD() != null) {
                                            if (!VideoPbFragment.this.kzD.doD().dSW()) {
                                                VideoPbFragment.this.kzD.uZ(false);
                                            }
                                            VideoPbFragment.this.kzD.doD().yq(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kzD.f(VideoPbFragment.this.lCs.dkj().bAJ().getInputView());
                                VideoPbFragment.this.lCs.dkj().a(VideoPbFragment.this.lui);
                            }
                        }
                        VideoPbFragment.this.dol();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData I;
        ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (I = I(fVar)) != null) {
            String userId = I.bmA().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.diz()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (I.bmA() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, I.bmA().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, I.bmA().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, I.bmA().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, I.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.diz()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> diH = fVar.diH();
                if (com.baidu.tbadk.core.util.y.getCount(diH) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : diH) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eDc) != null && abVar.eAP && !abVar.eAQ && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void dkH() {
        MarkData Gb;
        if (djz() != null && djz().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bhX() || drb() != null) {
                if ((!com.baidu.tbadk.a.d.bhX() || drd() != null) && this.ltP != null) {
                    if (djz().getPbData() != null && djz().getPbData().diN()) {
                        Gb = djz().Gb(0);
                    } else if (this.eLl != null && this.eLl.getCurrentItem() == lLN) {
                        Gb = djz().o(I(djz().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bhX()) {
                        Gb = djz().Gb(drd().dnN());
                    } else {
                        Gb = djz().Gb(drb().dnN());
                    }
                    if (Gb != null) {
                        if (!Gb.isApp() || (Gb = djz().Gb(drb().dnN() + 1)) != null) {
                            dnI();
                            this.ltP.a(Gb);
                            if (!this.ltP.biv()) {
                                this.ltP.bix();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.ltP.biw();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FQ(int i) {
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
            if (this.ltE == null) {
                this.ltE = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.ltl);
                this.ltE.b(this.fpP);
                this.ltE.c(this.fpW);
            }
            this.ltE.a(emotionImageData, djz(), djz().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dix() != null) {
            return fVar.dix();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dim())) {
            Iterator<PostData> it = fVar.dim().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dJZ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dit();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bmA() != null && postData.bmA().getUserTbVipInfoData() != null && postData.bmA().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bmA().getGodUserData().setIntro(postData.bmA().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dik() == null || fVar.dik().bmA() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bmA = fVar.dik().bmA();
        String userId = bmA.getUserId();
        HashMap<String, MetaData> userMap = fVar.dik().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bmA;
        }
        postData.JD(1);
        postData.setId(fVar.dik().bmR());
        postData.setTitle(fVar.dik().getTitle());
        postData.setTime(fVar.dik().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dkM() {
        ArrayList<PostData> dim;
        int count;
        int i;
        if (djz() == null || djz().getPbData() == null || djz().getPbData().dim() == null || (count = com.baidu.tbadk.core.util.y.getCount((dim = djz().getPbData().dim()))) == 0) {
            return "";
        }
        if (djz().dlP()) {
            Iterator<PostData> it = dim.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dJZ() == 1) {
                    return next.getId();
                }
            }
        }
        if (cBD() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bhX()) {
            i = drd().dnM();
        } else {
            i = drb().dnM();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dim, i);
        if (postData == null || postData.bmA() == null) {
            return "";
        }
        if (djz().PG(postData.bmA().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dim, i2);
            if (postData2 == null || postData2.bmA() == null || postData2.bmA().getUserId() == null) {
                break;
            } else if (djz().PG(postData2.bmA().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dim, i3);
            if (postData3 == null || postData3.bmA() == null || postData3.bmA().getUserId() == null) {
                return "";
            }
            if (djz().PG(postData3.bmA().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkI() {
        if (djz() != null) {
            com.baidu.tieba.pb.data.f pbData = djz().getPbData();
            djz().ux(true);
            if (this.ltP != null) {
                pbData.Pr(this.ltP.biu());
            }
            if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
                drd().drM();
            } else if (drb() != null) {
                drb().drM();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (djz() != null) {
            dnK();
            djz().ux(z);
            if (this.ltP != null) {
                this.ltP.iq(z);
                if (markData != null) {
                    this.ltP.a(markData);
                }
            }
            if (djz().biv()) {
                dkI();
            } else if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
                drd().drM();
            } else if (drb() != null) {
                drb().drM();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (djz() != null && djz().getPbData() != null && pVar.dja() != null) {
            String id = pVar.dja().getId();
            ArrayList<PostData> dim = djz().getPbData().dim();
            int i = 0;
            while (true) {
                if (i >= dim.size()) {
                    z = true;
                    break;
                }
                PostData postData = dim.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dji = pVar.dji();
                    postData.JC(pVar.getTotalCount());
                    if (postData.dJW() == null || dji == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dji.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bmA() != null && (metaData = postData.getUserMap().get(next.bmA().getUserId())) != null) {
                                next.a(metaData);
                                next.xu(true);
                                next.a(getPageContext(), djz().PG(metaData.getUserId()));
                            }
                        }
                        z = dji.size() != postData.dJW().size();
                        if (postData.dJW() != null && postData.dJW().size() < 2) {
                            postData.dJW().clear();
                            postData.dJW().addAll(dji);
                        }
                    }
                    if (postData.dJS() != null) {
                        postData.dJT();
                    }
                }
            }
            if (!djz().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
                    drd().drM();
                } else if (drb() != null) {
                    drb().drM();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkz() {
        if (djz() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Sb(djz().getForumId()) && djz().getPbData() != null && djz().getPbData().getForum() != null) {
            if (djz().getPbData().getForum().isLike() == 1) {
                djz().dmd().gi(djz().getForumId(), djz().dlx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bw dik = fVar.dik();
            if (dik != null && dik.blk()) {
                dlg();
            } else {
                d(this.luc);
            }
            if (this.lud != null) {
                uQ(this.lud.bAl());
                this.lud.a(fVar.getAnti());
                this.lud.a(fVar.getForum(), fVar.getUserData());
                this.lud.setThreadData(dik);
                if (djz() != null) {
                    this.lud.a(djz().dlN(), djz().dlx(), djz().dme());
                }
                if (dik != null) {
                    this.lud.kl(dik.bnX());
                }
            }
        }
    }

    public void dnm() {
        reset();
        dni();
        this.lCs.dkf();
        uS(false);
    }

    private void reset() {
        if (this.lud != null && this.abk != null) {
            com.baidu.tbadk.editortools.pb.a.bAa().setStatus(0);
            this.lud.bAv();
            this.lud.bzK();
            if (this.lud.getWriteImagesInfo() != null) {
                this.lud.getWriteImagesInfo().setMaxImagesAllowed(this.lud.isBJH ? 1 : 9);
            }
            this.lud.ru(SendView.ALL);
            this.lud.rv(SendView.ALL);
            h rh = this.abk.rh(23);
            h rh2 = this.abk.rh(2);
            h rh3 = this.abk.rh(5);
            if (rh2 != null) {
                rh2.display();
            }
            if (rh3 != null) {
                rh3.display();
            }
            if (rh != null) {
                rh.hide();
            }
            this.abk.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dik() != null) {
            x(fVar);
            this.lBO.setVisibility(fVar.diN() ? 8 : 0);
            if (fVar.biv()) {
                SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Gj = Gj(fVar.dik().bmr());
            if (this.lBR != null) {
                this.lBR.setText(Gj);
            }
            if (this.lBS != null) {
                this.lBS.setText(Gj);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dik()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.dik())) {
            if (this.lBQ != null) {
                this.lBQ.setEnable(false);
                this.lBQ.onDestroy();
            }
            SvgManager.brn().a(this.lBP, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.lBQ == null || !this.lBQ.isEnable()) {
            SvgManager.brn().a(this.lBP, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String Gj(int i) {
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

    public void uS(boolean z) {
        if (this.lBK != null) {
            uQ(this.lud.bAl());
            if (this.lBG) {
                uH(z);
            } else {
                uI(z);
            }
            dqT();
            dqU();
        }
    }

    public void dol() {
        if (this.lBK != null) {
            this.lBJ.setVisibility(8);
            this.lBK.setVisibility(8);
            this.lMk.lME = false;
            dqT();
            dqU();
        }
    }

    private void dqT() {
        if (this.lLW != null) {
            if (this.lMk.drl()) {
                this.lLW.wt(false);
            } else {
                this.lLW.wt(this.lLW.bXc() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqU() {
        if (this.lLW != null && this.eLl != null) {
            if (com.baidu.tbadk.a.d.bhX()) {
                this.lLW.vB(false);
            } else if (this.eLl.getCurrentItem() != 0) {
                this.lLW.vB(false);
            } else if (this.lMk.drl()) {
                this.lLW.vB(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.lLW.vB(eVar.drv() == null || eVar.drv().getValue() == null || eVar.drv().getValue().booleanValue());
                }
            }
        }
    }

    private void FR(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dle(), dky(), i);
    }

    private int dky() {
        if (djz() == null || djz().getPbData() == null || djz().getPbData().dik() == null) {
            return -1;
        }
        return djz().getPbData().dik().bnn();
    }

    public void uQ(boolean z) {
        this.lBG = z;
    }

    public void uH(boolean z) {
        if (this.lBK != null && this.jKd != null) {
            this.jKd.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lBK.startAnimation(alphaAnimation);
            }
            this.lBJ.setVisibility(0);
            this.lBK.setVisibility(0);
            this.lMk.lME = true;
        }
    }

    public void uI(boolean z) {
        if (this.lBK != null && this.jKd != null) {
            this.jKd.setText(dno());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lBK.startAnimation(alphaAnimation);
            }
            this.lBJ.setVisibility(0);
            this.lBK.setVisibility(0);
            this.lMk.lME = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lnE == null) {
            this.lnE = aVar;
            this.lMb.setText(aVar.getTitle());
            this.lMc.setText(aVar.drZ());
            String dsa = aVar.dsa();
            TBSpecificationBtn tBSpecificationBtn = this.lMe;
            if (TextUtils.isEmpty(dsa)) {
                dsa = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dsa);
            this.lMf.startLoad(aVar.getImage(), 10, false);
            this.lMg.setVisibility(aVar.dsc() ? 0 : 8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lnE == null || VideoPbFragment.this.lnE.dsc()) {
                        if (VideoPbFragment.this.lnE != null && VideoPbFragment.this.djz() != null && VideoPbFragment.this.djz().getPbData() != null && VideoPbFragment.this.djz().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dR("fid", VideoPbFragment.this.djz().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.djz().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.djz().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lnE.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dR("obj_id", VideoPbFragment.this.lnE.getTitle()).dR("obj_name", VideoPbFragment.this.lnE.drZ()).al("obj_type", 2).dR("fid", VideoPbFragment.this.djz().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.djz().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dqV();
                }
            }, aVar.dsb().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqV() {
        ViewGroup.LayoutParams layoutParams = this.lLZ.getLayoutParams();
        if (layoutParams != null) {
            if (this.lMh == null || !this.lMh.isRunning()) {
                this.lLZ.setAlpha(0.0f);
                this.lLZ.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqW() {
        if (this.lLZ.getLayoutParams() != null) {
            if (this.lMh == null || !this.lMh.isRunning()) {
                dqX();
            }
        }
    }

    private void dqX() {
        final ViewGroup.LayoutParams layoutParams = this.lLZ.getLayoutParams();
        if (layoutParams != null) {
            if (this.lMi == null || !this.lMi.isRunning()) {
                this.lMi = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.lMi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.lLZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.lMi.setDuration(200L);
                this.lMi.start();
                this.lMi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.d(layoutParams);
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
    public void d(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Yh.getLayoutParams();
        final int i = layoutParams2.height;
        this.lMh = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lMh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jGx);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.jGx);
                VideoPbFragment.this.lLZ.setLayoutParams(layoutParams);
                VideoPbFragment.this.Yh.setLayoutParams(layoutParams2);
            }
        });
        this.lMh.setDuration(300L);
        this.lMh.start();
        this.lMh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.lLZ.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Yh.getLayoutParams();
        final int i = layoutParams2.height;
        this.lMh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lMh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jGx);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.lLZ.setLayoutParams(layoutParams);
                VideoPbFragment.this.Yh.setLayoutParams(layoutParams2);
            }
        });
        this.lMh.setDuration(300L);
        this.lMh.start();
        this.lMh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dqY();
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
    public void dqY() {
        this.lMh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lMh.setDuration(300L);
        this.lMh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.lLZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.lMh.start();
    }

    public String dno() {
        if (!at.isEmpty(this.lCJ)) {
            return this.lCJ;
        }
        this.lCJ = TbadkCoreApplication.getInst().getResources().getString(ay.dnd());
        return this.lCJ;
    }

    public void dnK() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bhX() && drd() != null) {
            drd().endLoadData();
            drd().dnL();
        } else if (drb() != null) {
            drb().endLoadData();
            drb().dnL();
        }
    }

    public boolean di(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bjH().isShowImages()) {
                    return PC(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (djz() == null || djz().getPbData() == null) {
                        return true;
                    }
                    if (this.lCs != null) {
                        this.lCs.dkf();
                    }
                    p pVar = new p();
                    pVar.a(djz().getPbData().getForum());
                    pVar.setThreadData(djz().getPbData().dik());
                    pVar.g(postData);
                    this.ltg.d(pVar);
                    this.ltg.setPostId(postData.getId());
                    a(view, postData.bmA().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lud != null) {
                        uQ(this.lud.bAl());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dqZ() {
        if (this.lud != null) {
            uQ(this.lud.bAl());
        }
        dnm();
        this.lMj.dob();
    }

    private boolean PC(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("bubble_link", "");
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

    public void cTu() {
        if (this.lBs != null) {
            this.lBs.setVisibility(0);
        }
    }

    public void cTt() {
        if (this.lBs != null) {
            this.lBs.setVisibility(8);
        }
    }

    public void GA(int i) {
        if (this.lLT != null) {
            this.lLT.setVisibility(i);
        }
    }

    public void dnI() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dkC() {
        return this.luT;
    }

    public void dni() {
        if (this.abk != null) {
            this.abk.hide();
        }
    }

    public void cyL() {
        if (this.ltl.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.ltl.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dik() != null) {
            String valueOf = String.valueOf(fVar.dik().bmr());
            if (fVar.dik().bmr() == 0) {
                valueOf = "";
            }
            this.lLR.EL(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.lLS.drm()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (djz() != null && djz().getPbData() != null && djz().getPbData().dik() != null && djz().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lCl)).intValue();
                if (intValue == lCm) {
                    if (!this.hYQ.dKK()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.hYQ.ST(at.R(jSONArray));
                        }
                        this.hYQ.a(djz().getPbData().getForum().getId(), djz().getPbData().getForum().getName(), djz().getPbData().dik().getId(), str, intValue3, intValue2, booleanValue, djz().getPbData().dik().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lCn || intValue == lCp) {
                    if (djz().dma() != null) {
                        djz().dma().FL(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lCn) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(String str, String str2) {
        be.brr().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bGt() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bGu() {
        if (this.fFL == null) {
            this.fFL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGG */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bjH().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.bjH().isShowImages()) {
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
        return this.fFL;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bGv() {
        if (this.fJc == null) {
            this.fJc = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fJc;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bGw() {
        if (this.fFM == null) {
            this.fFM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: csS */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bjH().isShowImages();
                    gifView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.bjH().isShowImages()) {
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
                    gifView.bBb();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fFM;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bGx() {
        if (this.fJd == null) {
            this.fJd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlh */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dl */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dm */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bZl();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dn */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fJd;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bGy() {
        if (this.fJe == null) {
            this.fJe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlj */
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
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fJe;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bGz() {
        this.fJf = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dli */
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
        return this.fJf;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ltx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.be.PS(str) && djz() != null && djz().dlx() != null) {
            TiebaStatic.log(new aq("c11664").al("obj_param1", 1).dR("post_id", djz().dlx()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.fmn = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.be.doG().f(getPageContext(), str);
        }
        this.ltx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
        com.baidu.tieba.pb.pb.main.be.doG().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ltx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.lMj.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b drI = this.lMj.drI();
            if (drI == null) {
                this.lMj.dkt();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                drI.getItemView(1).setVisibility(8);
            } else {
                drI.getItemView(1).setVisibility(0);
            }
            drI.bpe();
            this.ltx = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aB(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.brr().b(getPageContext(), new String[]{str});
            this.ltx = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dra() {
        return this.eNr;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bDT() {
        return this.fzb;
    }

    public ReplyFragment drb() {
        if (this.lLS == null || !(this.lLS.GB(lLO) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.lLS.GB(lLO);
    }

    public DetailInfoFragment drc() {
        if (this.lLS == null || !(this.lLS.GB(lLN) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.lLS.GB(lLN);
    }

    public DetailInfoAndReplyFragment drd() {
        if (this.lLS == null || !(this.lLS.GB(lLP) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.lLS.GB(lLP);
    }

    public boolean djq() {
        PbModel djz = this.ltl.djz();
        if (djz == null) {
            return false;
        }
        return djz.djq();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData diw;
        PbModel djz = this.ltl.djz();
        if (djz != null && djz.getPbData() != null && !djz.getPbData().diN()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = djz.getPbData().dik().getId();
            if (djz.isShareThread() && djz.getPbData().dik().eGn != null) {
                historyMessage.threadName = djz.getPbData().dik().eGn.showText;
            } else {
                historyMessage.threadName = djz.getPbData().dik().getTitle();
            }
            if (djz.isShareThread() && !djq()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = djz.getPbData().getForum().getName();
            }
            ArrayList<PostData> dim = djz.getPbData().dim();
            int dnM = drb() != null ? drb().dnM() : 0;
            if (dim != null && dnM >= 0 && dnM < dim.size()) {
                historyMessage.postID = dim.get(dnM).getId();
            }
            historyMessage.isHostOnly = djz.getHostMode();
            historyMessage.isSquence = djz.dlz();
            historyMessage.isShareThread = djz.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lud != null) {
            this.lud.onDestroy();
        }
        if (djz != null && (djz.dlA() || djz.dlC())) {
            Intent intent = new Intent();
            intent.putExtra("tid", djz.dlx());
            if (this.ltS) {
                if (this.ltU) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", djz.crc());
                }
                if (this.ltT) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", djz.getIsGood());
                }
            }
            if (djz.getPbData() != null && System.currentTimeMillis() - this.ltt >= 40000 && (diw = djz.getPbData().diw()) != null && !com.baidu.tbadk.core.util.y.isEmpty(diw.getDataList())) {
                intent.putExtra("guess_like_data", diw);
            }
            PbActivity pbActivity = this.ltl;
            PbActivity pbActivity2 = this.ltl;
            pbActivity.setResult(-1, intent);
        }
        if (dkJ()) {
            if (djz != null) {
                com.baidu.tieba.pb.data.f pbData = djz.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.ltz) {
                        if (this.lLV != null) {
                            Rect rect = new Rect();
                            this.lLV.getGlobalVisibleRect(rect);
                            as.dmS().h(rect);
                        }
                        as.dmS().Gf(this.eLl.getCurrentItem());
                        BdTypeRecyclerView cBD = cBD();
                        Parcelable parcelable = null;
                        if (cBD != null) {
                            parcelable = cBD.onSaveInstanceState();
                        }
                        as.dmS().a(djz.dlH(), parcelable, djz.dlz(), djz.getHostMode(), false);
                    }
                }
            } else {
                as.dmS().reset();
            }
            djM();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lLW != null && !this.lLW.bXc()) {
            if ((this.lLW.isFullScreen() && configuration.orientation == 1) || (!this.lLW.isFullScreen() && configuration.orientation == 2)) {
                this.lLW.vC(false);
            }
        }
    }

    public boolean dre() {
        if (this.lLW == null) {
            return false;
        }
        return this.lLW.bXc();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        public boolean lME;
        public boolean lMF;

        private a() {
            this.lMF = true;
        }

        public boolean drl() {
            return (this.lME && this.lMF) ? false : true;
        }
    }

    public void drf() {
        this.ltI = -1;
        this.ltJ = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dla() {
        if (djz() != null && !at.isEmpty(djz().dlx())) {
            com.baidu.tbadk.BdToken.c.bgf().p(com.baidu.tbadk.BdToken.b.eqd, com.baidu.adp.lib.f.b.toLong(djz().dlx(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.lLU.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drg() {
        if (this.lMt == null) {
            this.lMt = ObjectAnimator.ofFloat(this.lLY, "alpha", 0.0f, 1.0f);
            this.lMt.setDuration(200L);
        }
        this.lMt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drh() {
        if (this.lMu == null) {
            this.lMu = ObjectAnimator.ofFloat(this.lLY, "alpha", 1.0f, 0.0f);
            this.lMu.setDuration(200L);
        }
        this.lMu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dri() {
        return this.lLW != null && this.lLW.drj();
    }

    public boolean drj() {
        return this.lMq;
    }

    public void vu(boolean z) {
        this.lMq = z;
    }

    public void uo(boolean z) {
        this.ltA = z;
    }

    public boolean dkY() {
        return this.ltA;
    }
}
