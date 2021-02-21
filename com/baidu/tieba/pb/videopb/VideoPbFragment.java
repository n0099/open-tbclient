package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.r;
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
import com.google.android.material.appbar.AppBarLayout;
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
/* loaded from: classes2.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout ZM;
    private EditorTools acR;
    private ImageView ahC;
    private CustomViewPager eZd;
    public View fLW;
    private com.baidu.adp.lib.d.b<ImageView> fUl;
    private com.baidu.adp.lib.d.b<GifView> fUm;
    private com.baidu.adp.lib.d.b<TextView> fXB;
    private com.baidu.adp.lib.d.b<View> fXC;
    private com.baidu.adp.lib.d.b<LinearLayout> fXD;
    private com.baidu.adp.lib.d.b<RelativeLayout> fXE;
    private ImageView gYq;
    private com.baidu.tieba.callfans.a iya;
    private VoiceManager jgu;
    private com.baidu.tieba.frs.profession.permission.c jkQ;
    private com.baidu.tieba.f.b jlq;
    public View jxc;
    public am kSz;
    public ar kWC;
    private com.baidu.tieba.pb.videopb.c.a lKW;
    private MaskView lQg;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lRB;
    private View lRD;
    private View lRE;
    private View lRF;
    int lRH;
    private PbFakeFloorModel lRd;
    private PbActivity lRi;
    private g lSd;
    private com.baidu.tbadk.editortools.pb.e lSe;
    private com.baidu.tieba.frs.profession.permission.c lSg;
    private EmotionImageData lSh;
    private com.baidu.tbadk.core.view.c lSl;
    private View lZJ;
    private LinearLayout lZL;
    private HeadImageView lZM;
    private ImageView lZN;
    private ImageView lZO;
    private ImageView lZP;
    private com.baidu.tieba.pb.view.d lZQ;
    private TextView lZR;
    private TextView lZS;
    private int lZU;
    private int lZV;
    private View lZr;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private String maN;
    private r mau;
    private View mkA;
    private ValueAnimator mkB;
    private ValueAnimator mkC;
    public com.baidu.tieba.pb.videopb.b.a mkD;
    private float mkH;
    private float mkI;
    private boolean mkJ;
    private ObjectAnimator mkN;
    private ObjectAnimator mkO;
    private NewPagerSlidingTabBaseStrip mkl;
    private VideoPbFragmentAdapter mkm;
    private View mkn;
    private View mko;
    private VideoContainerLayout mkp;
    private com.baidu.tieba.pb.videopb.videoView.a mkq;
    private e mkr;
    private View mks;
    private View mkt;
    private TextView mkv;
    private TextView mkw;
    private ImageView mkx;
    private TBSpecificationBtn mky;
    private TbImageView mkz;
    private RelativeLayout rootView;
    public static int mkh = 0;
    public static int mki = 1;
    public static int mkj = 0;
    public static int mal = 3;
    public static int mam = 0;
    public static int man = 3;
    public static int mao = 4;
    public static int maq = 5;
    public static int mar = 6;
    private static final int kme = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int mkk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lTe = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void dd(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dmn();
            } else {
                com.baidu.tieba.pb.a.b.dmm();
            }
        }
    };
    private long lRq = 0;
    private boolean lRx = false;
    View.OnClickListener mku = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lKW == null || VideoPbFragment.this.lKW.dvo()) {
                if (VideoPbFragment.this.lKW != null) {
                    if (VideoPbFragment.this.lKW.isChushou) {
                        VideoPbFragment.this.eI(VideoPbFragment.this.lKW.thirdRoomId, VideoPbFragment.this.lKW.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lKW.dvp();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().getForum() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13713").dR("fid", VideoPbFragment.this.dmx().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dmx().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmx().getPbData().getThreadId()).v("obj_param1", VideoPbFragment.this.lKW.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13590").dR("obj_id", VideoPbFragment.this.lKW.getTitle()).dR("obj_name", VideoPbFragment.this.lKW.dvl()).ap("obj_type", 2).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmx().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lKW.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    bf.bsV().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lRQ = null;
    private com.baidu.tbadk.coreExtra.model.a faF = null;
    private ForumManageModel gev = null;
    private boolean lRu = false;
    private View lZK = null;
    private TextView kpu = null;
    private boolean lZG = false;
    private String fDL = null;
    private boolean lRT = false;
    private boolean lRU = false;
    private boolean lRV = false;
    private boolean lRw = false;
    int[] lRG = new int[2];
    private int lRI = -1;
    private int lRJ = Integer.MIN_VALUE;
    private int lSr = 0;
    private int mkF = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private boolean lRN = com.baidu.tbadk.a.d.biY();
    private final PbModel.a lSU = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qR;
            VideoPbFragment.this.dqT();
            VideoPbFragment.this.dqO();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vK(false);
            if (z && fVar != null) {
                cb dlg = fVar.dlg();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a dlL = fVar.dlL();
                if (dlL != null && !dlL.mmG) {
                    VideoPbFragment.this.a(dlL);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lRQ != null) {
                    VideoPbFragment.this.lRQ.ja(fVar.bjZ());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fDL = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fDL) && VideoPbFragment.this.lSe != null && VideoPbFragment.this.lSe.bBh() != null && (qR = VideoPbFragment.this.lSe.bBh().qR(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fDL)) {
                        ((View) qR).setOnClickListener(VideoPbFragment.this.fEx);
                    }
                }
                if (VideoPbFragment.this.kSz != null && dlg != null && dlg.bnQ() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dlg.bnQ());
                    VideoPbFragment.this.kSz.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dmx().doA());
                        jSONObject.put("fid", VideoPbFragment.this.dmx().getForumId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                }
                if (i != 0) {
                    com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                    lVar.setOpType("2");
                    lVar.start();
                }
                if ((!com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dup() != null) && VideoPbFragment.this.dun() != null) {
                    if (com.baidu.tbadk.a.d.bja()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dmx().getPbData().dli();
                            }
                            if (y.getCount(arrayList) == 0 || (y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dNF() == 1)) {
                                if (VideoPbFragment.this.dup().doa()) {
                                    VideoPbFragment.this.dup().PI(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dup().PI(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dup().PH(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dup().PH("");
                        }
                        VideoPbFragment.this.dup().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dmx().getPbData().dli();
                            }
                            if (y.getCount(arrayList2) == 0 || (y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dNF() == 1)) {
                                if (VideoPbFragment.this.dun().doa()) {
                                    VideoPbFragment.this.dun().PI(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dun().PI(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dun().PH(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dun().PH("");
                        }
                        VideoPbFragment.this.dun().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dMz().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0554a lSW = new a.InterfaceC0554a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0554a
        public void g(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dqT();
            if (z && VideoPbFragment.this.dmx() != null) {
                if (VideoPbFragment.this.lRQ != null) {
                    VideoPbFragment.this.lRQ.ja(z2);
                }
                VideoPbFragment.this.dmx().vo(z2);
                if (VideoPbFragment.this.dmx().bjZ()) {
                    VideoPbFragment.this.dnL();
                } else if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dup() != null) {
                    VideoPbFragment.this.dup().duY();
                } else if (VideoPbFragment.this.dun() != null) {
                    VideoPbFragment.this.dun().duY();
                }
                if (z2) {
                    if (VideoPbFragment.this.lRQ != null) {
                        if (VideoPbFragment.this.lRQ.bkc() != null && VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().dlg() != null && VideoPbFragment.this.dmx().getPbData().dlg().bnQ() != null) {
                            MarkData bkc = VideoPbFragment.this.lRQ.bkc();
                            MetaData bnQ = VideoPbFragment.this.dmx().getPbData().dlg().bnQ();
                            if (bkc != null && bnQ != null) {
                                if (!au.equals(TbadkCoreApplication.getCurrentAccount(), bnQ.getUserId()) && !bnQ.hadConcerned()) {
                                    VideoPbFragment.this.mkD.b(bnQ);
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
                    VideoPbFragment.this.dnI();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (VideoPbFragment.this.kWC == null || VideoPbFragment.this.kWC.drM() == null || !VideoPbFragment.this.kWC.drM().dWx()) {
                return !VideoPbFragment.this.FI(am.faA);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kWC.drM().dWz());
            if (VideoPbFragment.this.lSe != null && (VideoPbFragment.this.lSe.bCc() || VideoPbFragment.this.lSe.bCd())) {
                VideoPbFragment.this.lSe.a(false, VideoPbFragment.this.kWC.drP());
            }
            VideoPbFragment.this.kWC.vQ(true);
            return true;
        }
    };
    private final CustomMessageListener lSy = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dmx() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lSe != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lSe.bBV());
                }
                VideoPbFragment.this.dqs();
                VideoPbFragment.this.mkD.drk();
            }
        }
    };
    private CustomMessageListener lSB = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((q) eVar.getData());
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
    private final CustomMessageListener jhX = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.dod();
            }
        }
    };
    private CustomMessageListener lSV = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dnC();
            }
        }
    };
    private CustomMessageListener lSN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.mkD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mkD.lSm) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.mkD.ckx();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.mkD.getExtra();
                DataRes dataRes = aVar.nKz;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (au.isEmpty(str)) {
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
                    VideoPbFragment.this.mkD.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.mkD.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lSL = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mkD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mkD.lSm) {
                VideoPbFragment.this.mkD.ckx();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                f pbData = VideoPbFragment.this.dmx().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dlw().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lSl.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.mkD.Da(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.mkD.dnZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lSl.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lSM = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mkD != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mkD.lSm) {
                VideoPbFragment.this.mkD.ckx();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lSl.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lSl.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lSj = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (VideoPbFragment.this.kWC == null || VideoPbFragment.this.kWC.drN() == null || !VideoPbFragment.this.kWC.drN().dWx()) {
                return !VideoPbFragment.this.FI(am.faB);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kWC.drN().dWz());
            if (VideoPbFragment.this.mau != null && VideoPbFragment.this.mau.dnl() != null && VideoPbFragment.this.mau.dnl().bCd()) {
                VideoPbFragment.this.mau.dnl().a(VideoPbFragment.this.kWC.drP());
            }
            VideoPbFragment.this.kWC.vR(true);
            return true;
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId());
                }
                arVar.dR("tid", VideoPbFragment.this.dmx().doA());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            VideoPbFragment.this.cDb();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dmx() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dmx().PC(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dup() != null) {
                        VideoPbFragment.this.lSr = VideoPbFragment.this.dup().dqV();
                        VideoPbFragment.this.mkF = VideoPbFragment.this.dup().dvb();
                        VideoPbFragment.this.dmx().da(VideoPbFragment.this.lSr, VideoPbFragment.this.mkF);
                    } else if (VideoPbFragment.this.dun() != null) {
                        VideoPbFragment.this.lSr = VideoPbFragment.this.dun().dqV();
                        VideoPbFragment.this.mkF = VideoPbFragment.this.dun().dvb();
                        VideoPbFragment.this.dmx().da(VideoPbFragment.this.lSr, VideoPbFragment.this.mkF);
                    }
                }
                if (VideoPbFragment.this.eZd != null) {
                    if (com.baidu.tbadk.a.d.bja()) {
                        VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mkj);
                    } else {
                        VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mki);
                    }
                }
                VideoPbFragment.this.mkD.drk();
                VideoPbFragment.this.kWC.drL();
                if (VideoPbFragment.this.lSe != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lSe.bBV());
                }
                VideoPbFragment.this.dqo();
                VideoPbFragment.this.vK(true);
                VideoPbFragment.this.dmx().doW();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dup() != null) {
                                VideoPbFragment.this.dup().duY();
                            } else if (VideoPbFragment.this.dun() != null) {
                                VideoPbFragment.this.dun().duY();
                            }
                        }
                    } else if (VideoPbFragment.this.dmx().getHostMode()) {
                        f pbData = VideoPbFragment.this.dmx().getPbData();
                        if (pbData != null && pbData.dlg() != null && pbData.dlg().bnQ() != null && (userId = pbData.dlg().bnQ().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dmx().doN()) {
                            VideoPbFragment.this.dqR();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dmx().doN()) {
                        VideoPbFragment.this.dqR();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uZ(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lSe.bCc() || VideoPbFragment.this.lSe.bCd()) {
                    VideoPbFragment.this.lSe.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kWC.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kSz != null) {
                    VideoPbFragment.this.kSz.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Au(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fEx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fDL);
        }
    };
    private CustomMessageListener lSA = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lSe != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lSe.bBV());
                }
                VideoPbFragment.this.vK(false);
            }
        }
    };
    private int mkG = 0;
    private boolean mkK = true;
    private View.OnTouchListener mkL = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.mkG == 1) {
                if (!VideoPbFragment.this.mkK) {
                    VideoPbFragment.this.dur();
                    UtilHelper.showStatusBar(VideoPbFragment.this.doh(), VideoPbFragment.this.doh().getRootView());
                    VideoPbFragment.this.mkK = true;
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(VideoPbFragment.this.mkM);
                    com.baidu.adp.lib.f.e.mA().postDelayed(VideoPbFragment.this.mkM, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.mkG == 2 && (VideoPbFragment.this.mkK || VideoPbFragment.this.dut())) {
                VideoPbFragment.this.dus();
                UtilHelper.hideStatusBar(VideoPbFragment.this.doh(), VideoPbFragment.this.doh().getRootView());
                VideoPbFragment.this.mkK = false;
                if (VideoPbFragment.this.mkq != null) {
                    VideoPbFragment.this.mkq.wo(false);
                }
            }
            VideoPbFragment.this.mkG = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener jsN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.mkG = 0;
            VideoPbFragment.this.mkH = 0.0f;
            VideoPbFragment.this.mkI = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.mkH += f;
            VideoPbFragment.this.mkI += f2;
            if (VideoPbFragment.this.mkG == 0 && !VideoPbFragment.this.mkJ && VideoPbFragment.this.mkq != null && !VideoPbFragment.this.mkq.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.mkI) <= Math.abs(VideoPbFragment.this.mkH) || VideoPbFragment.this.mkI > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.mkI) > Math.abs(VideoPbFragment.this.mkH) && VideoPbFragment.this.mkI > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.mkG = 2;
                    }
                } else {
                    VideoPbFragment.this.mkG = 1;
                }
            }
            return true;
        }
    };
    private Runnable mkM = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.mkK && !VideoPbFragment.this.dut()) {
                VideoPbFragment.this.dus();
                UtilHelper.hideStatusBar(VideoPbFragment.this.doh(), VideoPbFragment.this.doh().getRootView());
                VideoPbFragment.this.mkK = false;
            }
        }
    };
    private final com.baidu.adp.base.e iyf = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dmx() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gev.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gev.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dmx().doW();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.mhA != 1002 || bVar.hlf) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.nzX, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gev.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gev.getLoadDataMode(), gVar.mSuccess, gVar.nzX, false);
                    VideoPbFragment.this.mkD.aZ(gVar.nAa);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.jlq.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lSS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dmx() != null) {
                    arVar.dR("tid", VideoPbFragment.this.dmx().doA());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (VideoPbFragment.this.kWC != null) {
                    VideoPbFragment.this.kWC.drK();
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
                if (VideoPbFragment.this.kSz != null) {
                    VideoPbFragment.this.kSz.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Au(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kWC != null) {
                if (VideoPbFragment.this.mau != null && VideoPbFragment.this.mau.dnl() != null && VideoPbFragment.this.mau.dnl().bCd()) {
                    VideoPbFragment.this.mau.dnl().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kWC.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fDO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBM() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public final View.OnClickListener aEh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v164, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean J;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                    arVar.dR("tid", VideoPbFragment.this.dmx().doA());
                    arVar.dR("fid", VideoPbFragment.this.dmx().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.ap("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    if (VideoPbFragment.this.lRu) {
                        VideoPbFragment.this.lRu = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.lRd != null && postData.bnQ() != null && postData.dNF() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.mau != null) {
                                    VideoPbFragment.this.mau.dnh();
                                }
                                q qVar = new q();
                                qVar.a(VideoPbFragment.this.dmx().getPbData().getForum());
                                qVar.setThreadData(VideoPbFragment.this.dmx().getPbData().dlg());
                                qVar.g(postData);
                                VideoPbFragment.this.lRd.d(qVar);
                                VideoPbFragment.this.lRd.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bnQ().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dmx().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lSe != null) {
                                    VideoPbFragment.this.vI(VideoPbFragment.this.lSe.bBV());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dun() != null && VideoPbFragment.this.dun().drg() != null && view == VideoPbFragment.this.dun().drg()) || ((com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dup() != null && VideoPbFragment.this.dup().drg() != null && view == VideoPbFragment.this.dup().drg()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dmx().vm(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bja()) {
                            VideoPbFragment.this.dup().dqS();
                        } else {
                            VideoPbFragment.this.dun().dqS();
                        }
                    }
                } else if (VideoPbFragment.this.mkD != null && VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpM()) {
                    VideoPbFragment.this.mkD.baM();
                } else if ((VideoPbFragment.this.mkD != null && ((VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpN()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.mkD.drk();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cDb();
                        VideoPbFragment.this.dqR();
                        if (view.getId() == R.id.owner_reply) {
                            J = VideoPbFragment.this.dmx().J(true, VideoPbFragment.this.dnP());
                        } else {
                            J = view.getId() == R.id.all_reply ? VideoPbFragment.this.dmx().J(false, VideoPbFragment.this.dnP()) : VideoPbFragment.this.dmx().Pz(VideoPbFragment.this.dnP());
                        }
                        view.setTag(Boolean.valueOf(J));
                        if (J) {
                            VideoPbFragment.this.dqN();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fLW) {
                    if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13266");
                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar2.dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId());
                            arVar2.dR("tid", VideoPbFragment.this.dmx().doA());
                            arVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(arVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lRi, VideoPbFragment.this.fLW);
                        VideoPbFragment.this.lRi.finish();
                    }
                } else if (view == VideoPbFragment.this.jxc && VideoPbFragment.this.mkD != null) {
                    if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
                        if (VideoPbFragment.this.dmx() == null || VideoPbFragment.this.dmx().getPbData() == null) {
                            l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        ArrayList<PostData> dli = VideoPbFragment.this.dmx().getPbData().dli();
                        if ((dli == null || dli.size() <= 0) && VideoPbFragment.this.dmx().doC()) {
                            l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dR("tid", VideoPbFragment.this.dmx().doA()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", VideoPbFragment.this.dmx().getForumId()));
                        VideoPbFragment.this.mkD.dnD();
                    }
                } else if (VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpR()) {
                    if (VideoPbFragment.this.dmx() != null) {
                        VideoPbFragment.this.mkD.drk();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cDb();
                            VideoPbFragment.this.dqR();
                            VideoPbFragment.this.dmx().FP(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.mkD != null && VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpN()) {
                    VideoPbFragment.this.mkD.baM();
                } else if (VideoPbFragment.this.mkD != null && ((VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpU()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.mkD.drk();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cDb();
                            VideoPbFragment.this.dqR();
                            VideoPbFragment.this.mkD.dS(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dmx().doU()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.mkD != null && VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpL()) {
                    if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().dlg() != null) {
                        VideoPbFragment.this.mkD.baM();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                        VideoPbFragment.this.mkD.Pu(VideoPbFragment.this.dmx().getPbData().dlg().bog());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.mkD != null) {
                        VideoPbFragment.this.mkD.i(sparseArray);
                    }
                } else if (VideoPbFragment.this.mkD != null && VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpV()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.B(true, false);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ap("obj_type", 0).ap("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ap("obj_type", 1).ap("obj_source", 1));
                    }
                    VideoPbFragment.this.mkD.dsr();
                } else if (VideoPbFragment.this.mkD != null && (view == VideoPbFragment.this.mkD.dqP() || (VideoPbFragment.this.mkD.dss() != null && (view == VideoPbFragment.this.mkD.dss().dpQ() || view == VideoPbFragment.this.mkD.dss().dpO())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if ((VideoPbFragment.this.dmx() != null || VideoPbFragment.this.dmx().getPbData() != null) && !VideoPbFragment.this.gev.dOA()) {
                        VideoPbFragment.this.mkD.drk();
                        if (VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpO()) {
                            if (VideoPbFragment.this.dmx().getPbData().dlg().bnL() == 1) {
                                i2 = 5;
                            } else {
                                i2 = 4;
                            }
                        } else if (VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpQ()) {
                            if (VideoPbFragment.this.dmx().getPbData().dlg().bnM() != 1) {
                                i2 = 6;
                            }
                        } else {
                            i2 = view == VideoPbFragment.this.mkD.dqP() ? 2 : 0;
                        }
                        ForumData forum = VideoPbFragment.this.dmx().getPbData().getForum();
                        String name = forum.getName();
                        String id = forum.getId();
                        String id2 = VideoPbFragment.this.dmx().getPbData().dlg().getId();
                        VideoPbFragment.this.showProgressBar();
                        VideoPbFragment.this.gev.c(id, name, id2, i2, VideoPbFragment.this.mkD.dqQ());
                    }
                } else if (VideoPbFragment.this.mkD != null && VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpT()) {
                    if (VideoPbFragment.this.dmx() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.mkD.drk();
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dmx().getPbData(), VideoPbFragment.this.dmx().doC(), 1);
                        if (b2 != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dmx().getPbData().getForum().getId(), VideoPbFragment.this.dmx().getPbData().getForum().getName(), VideoPbFragment.this.dmx().getPbData().dlg().getId(), String.valueOf(VideoPbFragment.this.dmx().getPbData().getUserData().getUserId()), (String) b2.get(R.id.tag_forbid_user_name), (String) b2.get(R.id.tag_forbid_user_name_show), (String) b2.get(R.id.tag_forbid_user_post_id), (String) b2.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.mkD != null && VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpP()) {
                    if (VideoPbFragment.this.dmx() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b3 = VideoPbFragment.this.b(VideoPbFragment.this.dmx().getPbData(), VideoPbFragment.this.dmx().doC(), 1);
                        if (b3 != null) {
                            if (StringUtils.isNull((String) b3.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.mkD.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.mkD.a(((Integer) b3.get(R.id.tag_del_post_type)).intValue(), (String) b3.get(R.id.tag_del_post_id), ((Integer) b3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b3.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b3.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.mkD.baM();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                        arVar3.dR("tid", VideoPbFragment.this.dmx().doA());
                        arVar3.dR("fid", VideoPbFragment.this.dmx().getForumId());
                        arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar3.ap("obj_locate", 4);
                        TiebaStatic.log(arVar3);
                    }
                    if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                        VideoPbFragment.this.lRD = view;
                    } else if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 3).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                        if (VideoPbFragment.this.mkD != null) {
                            VideoPbFragment.this.mkD.drk();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dNR() == 1) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                            }
                            if (postData2.nxT != null) {
                                com.baidu.tbadk.core.util.ar bsN = postData2.nxT.bsN();
                                bsN.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bsN.ap("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bsN.ap("obj_locate", 8);
                                }
                                TiebaStatic.log(bsN);
                            }
                            VideoPbFragment.this.cDb();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dmx() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13398");
                            arVar4.dR("tid", VideoPbFragment.this.dmx().doA());
                            arVar4.dR("fid", VideoPbFragment.this.dmx().getForumId());
                            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar4.ap("obj_locate", 6);
                            TiebaStatic.log(arVar4);
                        }
                        if (view.getId() == R.id.post_info_commont_img) {
                            if (!com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                VideoPbFragment.this.lRE = view;
                                return;
                            }
                        } else if (view.getId() == R.id.pb_post_reply && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                            VideoPbFragment.this.lRE = view;
                            return;
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nxT != null) {
                                    com.baidu.tbadk.core.util.ar bsN2 = postData4.nxT.bsN();
                                    bsN2.delete("obj_locate");
                                    bsN2.ap("obj_locate", 8);
                                    TiebaStatic.log(bsN2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", VideoPbFragment.this.dmx().doB()).dR("fid", VideoPbFragment.this.dmx().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).ap("obj_source", 1).ap("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.lRd != null && postData4.bnQ() != null && postData4.dNF() != 1) {
                                    if (VideoPbFragment.this.mau != null) {
                                        VideoPbFragment.this.mau.dnh();
                                    }
                                    if (VideoPbFragment.this.lRN && postData4.dNC() != null && postData4.dNC().size() != 0) {
                                        VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                        return;
                                    }
                                    q qVar2 = new q();
                                    qVar2.a(VideoPbFragment.this.dmx().getPbData().getForum());
                                    qVar2.setThreadData(VideoPbFragment.this.dmx().getPbData().dlg());
                                    qVar2.g(postData4);
                                    VideoPbFragment.this.lRd.d(qVar2);
                                    VideoPbFragment.this.lRd.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bnQ().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lSe != null) {
                                        VideoPbFragment.this.vI(VideoPbFragment.this.lSe.bBV());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.mkD != null && VideoPbFragment.this.dmx() != null) {
                        if (com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dun() != null) {
                            if (!com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dup() != null) {
                                VideoPbFragment.this.mkD.drk();
                                if (view.getId() != R.id.pb_editor_tool_collection || com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_shoucang"))) {
                                    if (VideoPbFragment.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dmx() != null) {
                                        VideoPbFragment.this.dnK();
                                        if (VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().dlg() != null && VideoPbFragment.this.dmx().getPbData().dlg().bnQ() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmx().doA()).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()).ap("obj_locate", 3).dR("uid", VideoPbFragment.this.dmx().getPbData().dlg().bnQ().getUserId()));
                                        }
                                        if (VideoPbFragment.this.dmx().getPbData().dlg() != null && VideoPbFragment.this.dmx().getPbData().dlg().bnQ() != null && VideoPbFragment.this.dmx().getPbData().dlg().bnQ().getUserId() != null && VideoPbFragment.this.lRQ != null) {
                                            int h = VideoPbFragment.this.mkD.h(VideoPbFragment.this.dmx().getPbData());
                                            cb dlg = VideoPbFragment.this.dmx().getPbData().dlg();
                                            if (!dlg.bmx()) {
                                                if (dlg.bmy()) {
                                                    i = 3;
                                                } else if (dlg.bpN()) {
                                                    i = 4;
                                                } else {
                                                    i = dlg.bpO() ? 5 : 1;
                                                }
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", VideoPbFragment.this.dmx().doA()).ap("obj_locate", 1).dR("obj_id", VideoPbFragment.this.dmx().getPbData().dlg().bnQ().getUserId()).ap("obj_type", VideoPbFragment.this.lRQ.bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                VideoPbFragment.this.lRF = view;
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.wl(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.mkD != null && VideoPbFragment.this.eZd != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().dlg() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        f pbData = VideoPbFragment.this.dmx().getPbData();
                        if (pbData.dlg().bnH() != 0) {
                            int currentItem = VideoPbFragment.this.eZd.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bja() && currentItem == VideoPbFragment.mkh) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mki);
                            } else if (com.baidu.tbadk.a.d.bja() || currentItem == VideoPbFragment.mki) {
                                if (!com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dun() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dup() != null) && VideoPbFragment.this.cFV() != null) {
                                    com.baidu.tbadk.core.util.ar dR = new com.baidu.tbadk.core.util.ar("c13403").dR("tid", VideoPbFragment.this.dmx().doA()).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cFV = VideoPbFragment.this.cFV();
                                    if (cFV != null) {
                                        boolean canScrollVertically = cFV.canScrollVertically(1);
                                        boolean canScrollVertically2 = cFV.canScrollVertically(-1);
                                        if (VideoPbFragment.this.ZM != null) {
                                            VideoPbFragment.this.ZM.setExpanded(false, true);
                                        }
                                        if (cFV.getLayoutManager() != null && (cFV.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cFV.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lRI != -1 || VideoPbFragment.this.lRJ != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lRI > 3 || (VideoPbFragment.this.lRI == 3 && VideoPbFragment.this.lRJ < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lRI, VideoPbFragment.this.lRJ + equipmentHeight);
                                                        cFV.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lRI >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lRI, VideoPbFragment.this.lRJ + (equipmentHeight / 2));
                                                        cFV.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lRI == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lRI, VideoPbFragment.this.lRJ + (equipmentHeight / 4));
                                                        cFV.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cFV.smoothScrollBy(0, -VideoPbFragment.this.lRJ);
                                                    }
                                                    dR.ap("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cFV.getFirstVisiblePosition();
                                                View childAt = cFV.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lRI = firstVisiblePosition;
                                                VideoPbFragment.this.lRJ = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cFV.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cFV.smoothScrollToPosition(0);
                                                } else {
                                                    cFV.smoothScrollToPosition(0);
                                                }
                                                dR.ap("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dR);
                                            com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                                            com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c12942");
                                            arVar5.ap("obj_type", 1);
                                            arVar5.ap("obj_locate", 4);
                                            arVar5.dR("tid", VideoPbFragment.this.dmx().doA());
                                            arVar5.dR(IntentConfig.NID, pbData.dlg().bmo());
                                            if (bR != null) {
                                                arVar5.dR("obj_cur_page", bR.getCurrentPageKey());
                                            }
                                            if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                                                arVar5.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                                            }
                                            TiebaStatic.log(arVar5);
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
                            if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().dlg() != null && VideoPbFragment.this.dmx().getPbData().dlg().bnQ() != null) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmx().doA()).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()).ap("obj_locate", 2).dR("uid", VideoPbFragment.this.dmx().getPbData().dlg().bnQ().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.wm(false);
                        VideoPbFragment.this.dny();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lSr >= 0) {
                        if (VideoPbFragment.this.dmx() != null) {
                            VideoPbFragment.this.dmx().dpm();
                        }
                        if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dup() != null && VideoPbFragment.this.dup().duW() != null) {
                            VideoPbFragment.this.dup().duW().setData(VideoPbFragment.this.dmx().getPbData());
                        } else if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dun() != null && VideoPbFragment.this.dun().duW() != null) {
                            VideoPbFragment.this.dun().duW().setData(VideoPbFragment.this.dmx().getPbData());
                        }
                        VideoPbFragment.this.lSr = 0;
                        VideoPbFragment.this.mkF = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dup() != null) {
                            VideoPbFragment.this.dup().dd(VideoPbFragment.this.dmx().dpp(), VideoPbFragment.this.dmx().dpq());
                            VideoPbFragment.this.dmx().da(0, 0);
                        } else if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dun() != null) {
                            VideoPbFragment.this.dun().dd(VideoPbFragment.this.dmx().dpp(), VideoPbFragment.this.dmx().dpq());
                            VideoPbFragment.this.dmx().da(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dmx() != null) {
                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                        arVar6.dR("tid", VideoPbFragment.this.dmx().doA());
                        arVar6.dR("fid", VideoPbFragment.this.dmx().getForumId());
                        arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar6.ap("obj_locate", 2);
                        TiebaStatic.log(arVar6);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bh.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.brQ().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dqs();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dqs();
                } else if (VideoPbFragment.this.mkD.dss() != null && view == VideoPbFragment.this.mkD.dss().dpS()) {
                    VideoPbFragment.this.mkD.drk();
                    if (VideoPbFragment.this.dmx() != null) {
                        VideoPbFragment.this.iya.setThreadId(VideoPbFragment.this.dmx().doA());
                    }
                    if (VideoPbFragment.this.dmx() == null || !VideoPbFragment.this.dmx().isPrivacy()) {
                        VideoPbFragment.this.iya.crW();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().getThreadId() != null && VideoPbFragment.this.dmx().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                            VideoPbFragment.this.iya.k(3, i3, VideoPbFragment.this.dmx().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dmx().getPbData() != null) {
                        VideoPbFragment.this.iya.k(3, 3, VideoPbFragment.this.dmx().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c13398");
                    arVar7.dR("tid", VideoPbFragment.this.dmx().doA());
                    arVar7.dR("fid", VideoPbFragment.this.dmx().getForumId());
                    arVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar7.ap("obj_locate", 7);
                    TiebaStatic.log(arVar7);
                    VideoPbFragment.this.mkD.wu(false);
                    VideoPbFragment.this.mkD.due().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lOs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.mkD != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.mkD.f(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.mkD.dL(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.mkD.f(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.mkD.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener juR = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            VideoPbFragment.this.mkD.wu(true);
            return VideoPbFragment.this.mkD.due().onLongClick(view);
        }
    };
    public SortSwitchButton.a lSQ = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            if (VideoPbFragment.this.mkD != null) {
                VideoPbFragment.this.mkD.drk();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dmx() == null || VideoPbFragment.this.dmx().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cDb();
                VideoPbFragment.this.dqR();
                if (VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().lKm != null && VideoPbFragment.this.dmx().getPbData().lKm.size() > i) {
                    int intValue = VideoPbFragment.this.dmx().getPbData().lKm.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dR("tid", VideoPbFragment.this.dmx().doB()).dR("fid", VideoPbFragment.this.dmx().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_type", FN(intValue)));
                    if (VideoPbFragment.this.dmx().FU(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int FN(int i) {
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
    private a mkE = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dnI() {
        if (dmx() != null && dmx().getPbData() != null && dmx().getPbData().dlg() != null) {
            cb dlg = dmx().getPbData().dlg();
            dlg.mRecomAbTag = dmx().dpw();
            dlg.mRecomWeight = dmx().dpu();
            dlg.mRecomSource = dmx().dpv();
            dlg.mRecomExtra = dmx().dpx();
            dlg.eUg = dmx().doI();
            if (dlg.getFid() == 0) {
                dlg.setFid(com.baidu.adp.lib.f.b.toLong(dmx().getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlg, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(boolean z) {
        if (dmx() != null && dmx().getPbData() != null && dmx().getPbData().dlg() != null) {
            cb dlg = dmx().getPbData().dlg();
            dlg.mRecomAbTag = dmx().dpw();
            dlg.mRecomWeight = dmx().dpu();
            dlg.mRecomSource = dmx().dpv();
            dlg.mRecomExtra = dmx().dpx();
            if (dlg.getFid() == 0) {
                dlg.setFid(com.baidu.adp.lib.f.b.toLong(dmx().getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlg, "c13563");
            TbPageTag ft = com.baidu.tbadk.pageInfo.c.ft(getContext());
            if (a2 != null && ft != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(ft.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.ap("reply_type", 1);
                if (z) {
                    a2.ap("obj_type", 2);
                } else {
                    a2.ap("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c fq = com.baidu.tbadk.pageExtra.d.fq(getContext());
                if (fq != null) {
                    a2.dR("obj_cur_page", fq.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                    a2.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
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
            if (au.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.nzX) ? bVar.nzX : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Au(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jF(true);
                aVar.b(getPageContext());
                aVar.bqx();
            } else {
                a(0, bVar.mSuccess, bVar.nzX, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iNt == 1) {
                    ArrayList<PostData> dli = dmx().getPbData().dli();
                    int size = dli.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dli.get(i).getId())) {
                            i++;
                        } else {
                            dli.remove(i);
                            break;
                        }
                    }
                    dmx().getPbData().dlg().nk(dmx().getPbData().dlg().bnH() - 1);
                    if (com.baidu.tbadk.a.d.bja() && dup() != null) {
                        dup().duY();
                    } else if (dun() != null) {
                        dun().duY();
                    }
                } else if (bVar.iNt == 0) {
                    dnJ();
                } else if (bVar.iNt == 2) {
                    ArrayList<PostData> dli2 = dmx().getPbData().dli();
                    int size2 = dli2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dli2.get(i2).dNC().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dli2.get(i2).dNC().get(i3).getId())) {
                                i3++;
                            } else {
                                dli2.get(i2).dNC().remove(i3);
                                dli2.get(i2).dNE();
                                z2 = true;
                                break;
                            }
                        }
                        dli2.get(i2).Tq(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bja() && dup() != null) {
                            dup().duY();
                        } else if (dun() != null) {
                            dun().duY();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dmx().getPbData().dlu().lLW;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dNC().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dNC().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dNC().remove(i2);
                    list.get(i).dNE();
                    z = true;
                    break;
                }
            }
            list.get(i).Tq(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bja() && dup() != null) {
                dup().duY();
            } else if (dun() != null) {
                dun().duY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null && dmx() != null && dmx().getPbData() != null && dmx().getPbData().dlg() != null) {
            a(this.gev.getLoadDataMode(), gVar.mSuccess, gVar.nzX, false);
            if (gVar.mSuccess) {
                this.lRT = true;
                if (i == 2 || i == 3) {
                    this.lRU = true;
                    this.lRV = false;
                } else if (i == 4 || i == 5) {
                    this.lRU = false;
                    this.lRV = true;
                }
                if (i == 2) {
                    dmx().getPbData().dlg().nn(1);
                    dmx().setIsGood(1);
                } else if (i == 3) {
                    dmx().getPbData().dlg().nn(0);
                    dmx().setIsGood(0);
                } else if (i == 4) {
                    dmx().getPbData().dlg().nm(1);
                    dmx().FO(1);
                } else if (i == 5) {
                    dmx().getPbData().dlg().nm(0);
                    dmx().FO(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.nzX)) {
                    string = gVar.nzX;
                } else {
                    string = getString(R.string.operation_failed);
                }
                l.showToast(getPageContext().getPageActivity(), string);
            }
            if (dmx().getPbData().dlg() != null && duo() != null) {
                duo().dvi();
            }
        }
    }

    private void dnJ() {
        if (dmx().doD() || dmx().doF()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dmx().doA());
            PbActivity pbActivity = this.lRi;
            PbActivity pbActivity2 = this.lRi;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dmx().doA()));
        if (dnM()) {
            this.lRi.finish();
        }
    }

    private boolean dnM() {
        if (dmx() == null) {
            return true;
        }
        if (dmx().getPbData() == null || !dmx().getPbData().dlJ()) {
            if (dmx().bjZ()) {
                final MarkData doV = dmx().doV();
                if (doV == null || !dmx().getIsFromMark() || cFV() == null) {
                    return true;
                }
                final MarkData FV = dmx().FV(cFV().getFirstVisiblePosition());
                if (FV == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", doV);
                    this.lRi.setResult(-1, intent);
                    return true;
                } else if (FV.getPostId() == null || FV.getPostId().equals(doV.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", doV);
                    this.lRi.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Au(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lRQ != null) {
                                if (VideoPbFragment.this.lRQ.bjZ()) {
                                    VideoPbFragment.this.lRQ.bka();
                                    VideoPbFragment.this.lRQ.ja(false);
                                }
                                VideoPbFragment.this.lRQ.a(FV);
                                VideoPbFragment.this.lRQ.ja(true);
                                VideoPbFragment.this.lRQ.bkb();
                            }
                            doV.setPostId(FV.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doV);
                            VideoPbFragment.this.lRi.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dmL();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, true));
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doV);
                            VideoPbFragment.this.lRi.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dmL();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, false));
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bqx();
                    return false;
                }
            } else if (dmx().getPbData() == null || dmx().getPbData().dli() == null || dmx().getPbData().dli().size() <= 0 || !dmx().getIsFromMark()) {
                return true;
            } else {
                this.lRi.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmL() {
        this.lRi.dmL();
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
    public void wl(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dmx() != null && this.mkD != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dmx().getPbData()) != null) {
                cb dlg = pbData.dlg();
                if (dlg != null && dlg.bnQ() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", dmx().doA()).dR("fid", pbData.getForumId()).ap("obj_locate", 4).dR("uid", dlg.bnQ().getUserId()));
                }
                if (dlg != null) {
                    if (dlg.bmx()) {
                        i = 2;
                    } else if (dlg.bmy()) {
                        i = 3;
                    } else if (dlg.bpN()) {
                        i = 4;
                    } else if (dlg.bpO()) {
                        i = 5;
                    }
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    arVar.dR("tid", dmx().doA());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("fid", dmx().getForumId());
                    if (!z) {
                        arVar.ap("obj_locate", 6);
                    } else {
                        arVar.ap("obj_locate", 5);
                    }
                    arVar.ap("obj_name", i);
                    arVar.ap("obj_type", 2);
                    if (dlg != null) {
                        if (dlg.bmx()) {
                            arVar.ap("obj_type", 10);
                        } else if (dlg.bmy()) {
                            arVar.ap("obj_type", 9);
                        } else if (dlg.bpO()) {
                            arVar.ap("obj_type", 8);
                        } else if (dlg.bpN()) {
                            arVar.ap("obj_type", 7);
                        } else if (dlg.isShareThread) {
                            arVar.ap("obj_type", 6);
                        } else if (dlg.threadType == 0) {
                            arVar.ap("obj_type", 1);
                        } else if (dlg.threadType == 40) {
                            arVar.ap("obj_type", 2);
                        } else if (dlg.threadType == 49) {
                            arVar.ap("obj_type", 3);
                        } else if (dlg.threadType == 54) {
                            arVar.ap("obj_type", 4);
                        } else {
                            arVar.ap("obj_type", 5);
                        }
                        arVar.dR(IntentConfig.NID, dlg.bmo());
                        arVar.ap(IntentConfig.CARD_TYPE, dlg.bpR());
                        arVar.dR(IntentConfig.RECOM_SOURCE, dlg.mRecomSource);
                        arVar.dR("ab_tag", dlg.mRecomAbTag);
                        arVar.dR("weight", dlg.mRecomWeight);
                        arVar.dR("extra", dlg.mRecomExtra);
                        arVar.dR(IntentConfig.NID, dlg.bmo());
                        if (dlg.getBaijiahaoData() != null && !au.isEmpty(dlg.getBaijiahaoData().oriUgcVid)) {
                            arVar.dR("obj_param6", dlg.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (doh() != null) {
                        com.baidu.tbadk.pageInfo.c.b(doh(), arVar);
                    }
                    TiebaStatic.log(arVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dmx().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dli = pbData.dli();
                        if ((dli == null || dli.size() <= 0) && dmx().doC()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.mkD.drk();
                        cDb();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                        if (!AntiHelper.d(getContext(), dlg)) {
                            if (this.lZQ != null) {
                                this.lZQ.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                FL(z ? 2 : 1);
                                return;
                            }
                            this.mkD.showLoadingDialog();
                            dmx().dpg().z(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", dmx().doA());
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.dR("fid", dmx().getForumId());
                if (!z) {
                }
                arVar2.ap("obj_name", i);
                arVar2.ap("obj_type", 2);
                if (dlg != null) {
                }
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (doh() != null) {
                }
                TiebaStatic.log(arVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dtU() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        M(videoPbViewModel.duz());
        N(videoPbViewModel.duz());
        if (dmx() != null && dmx().getPbData() != null) {
            boolean isFromMark = dmx().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dmx().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bjY() != null && !pbData.bjY().equals(L.getId()) && this.eZd != null) {
                    if (com.baidu.tbadk.a.d.bja()) {
                        this.eZd.setCurrentItem(mkj);
                    } else {
                        this.eZd.setCurrentItem(mki);
                    }
                }
            }
        }
        videoPbViewModel.duA().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                BdTypeRecyclerView cFV;
                if (cbVar != null && cbVar.boh() != null) {
                    if (VideoPbFragment.this.mkq.getVideoUrl() == null || !VideoPbFragment.this.mkq.getVideoUrl().equals(cbVar.boh().video_url)) {
                        if (!au.isEmpty(VideoPbFragment.this.mkq.getVideoUrl())) {
                            VideoPbFragment.this.lRw = true;
                            if (com.baidu.tbadk.a.d.bja()) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mkj);
                            } else {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mkh);
                            }
                            if (com.baidu.tbadk.a.d.bja() && (cFV = VideoPbFragment.this.cFV()) != null) {
                                cFV.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.mkr == null || !VideoPbFragment.this.mkr.isPlaying()) {
                            VideoPbFragment.this.dtV();
                            VideoPbFragment.this.aR(cbVar);
                        }
                        VideoPbFragment.this.dtW();
                        if (VideoPbFragment.this.mkr.duM()) {
                            VideoPbFragment.this.mkr.start();
                        }
                        boolean z = !au.equals(VideoPbFragment.this.mkq.getVideoUrl(), cbVar.boh().video_url);
                        VideoPbFragment.this.mkq.setData(cbVar);
                        if (com.baidu.tbadk.a.d.bja()) {
                            VideoPbFragment.this.mkq.ww(false);
                        } else {
                            VideoPbFragment.this.mkq.ww(VideoPbFragment.this.eZd.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.mkq.startPlay();
                            VideoPbFragment.this.mkq.dvz();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.mkq.setData(cbVar);
                }
            }
        });
        videoPbViewModel.duI().observe(this, new Observer<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eZd.setCurrentItem(num.intValue());
            }
        });
        videoPbViewModel.duE().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                VideoPbFragment.this.mkq.aW(cbVar);
            }
        });
        videoPbViewModel.duF().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                VideoPbFragment.this.mkq.aX(cbVar);
            }
        });
        videoPbViewModel.duG().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dug();
            }
        });
        videoPbViewModel.duH().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtV() {
        ViewGroup.LayoutParams layoutParams = this.mkt.getLayoutParams();
        layoutParams.height = 0;
        this.mkt.setLayoutParams(layoutParams);
        this.mkt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtW() {
        if (this.mkr == null) {
            this.mkr = new e(getBaseFragmentActivity(), this.mkp);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(doh()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.mkp.getOriginHeight() + statusBarHeight);
            final VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.mkr.b(videoPbViewModel.duB(), rect);
            if (this.mkr.duM()) {
                this.mkr.c(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bja()) {
                            if (videoPbViewModel.duC() || VideoPbFragment.this.dmx().dpz() == VideoPbFragment.mkj) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mkj);
                            }
                        } else if (videoPbViewModel.duC() || VideoPbFragment.this.dmx().dpz() == VideoPbFragment.mki) {
                            VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mki);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bja()) {
                            if (videoPbViewModel.duC() || VideoPbFragment.this.dmx().dpz() == VideoPbFragment.mkj) {
                                VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mkj);
                            }
                        } else if (videoPbViewModel.duC() || VideoPbFragment.this.dmx().dpz() == VideoPbFragment.mki) {
                            VideoPbFragment.this.eZd.setCurrentItem(VideoPbFragment.mki);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bja()) {
                if (videoPbViewModel.duC() || dmx().dpz() == mkj) {
                    this.eZd.setCurrentItem(mkj);
                }
            } else if (videoPbViewModel.duC() || dmx().dpz() == mki) {
                this.eZd.setCurrentItem(mki);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.mkJ && (this.mkK || dut())) {
            dus();
            UtilHelper.hideStatusBar(doh(), doh().getRootView());
            this.mkK = false;
            if (this.mkq != null) {
                this.mkq.wo(false);
            }
        }
        if (i == 4) {
            return this.mkq.dAH();
        }
        if (i == 24) {
            return this.mkq.dvw();
        }
        if (i == 25) {
            return this.mkq.dvx();
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
    public void aR(cb cbVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dpy;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (cbVar != null && cbVar.boh() != null) {
            int intValue = cbVar.boh().video_width.intValue();
            int intValue2 = cbVar.boh().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dmx() != null || (dpy = dmx().dpy()) == null) ? ceil : dpy.height();
                i = 0;
                layoutParams = this.mkp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.mkp.setLayoutParams(layoutParams);
                this.mkp.setMaxHeight(ceil);
                this.mkp.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.mkp.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bja()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mkl.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, mkk);
                    } else {
                        layoutParams3.height = mkk;
                    }
                    this.mkl.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bja()) {
                    ceil += mkk;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.ZM.setLayoutParams(layoutParams2);
                if (i == 0 && (this.ZM.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams()).getBehavior();
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
        if (dmx() != null) {
        }
        i = 0;
        layoutParams = this.mkp.getLayoutParams();
        if (layoutParams != null) {
        }
        this.mkp.setLayoutParams(layoutParams);
        this.mkp.setMaxHeight(ceil2);
        this.mkp.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.mkp.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bja()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bja()) {
        }
        if (layoutParams2 != null) {
        }
        this.ZM.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lRq = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lSl = new com.baidu.tbadk.core.view.c();
        this.lSl.toastTime = 1000L;
        if (this.mkD != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.mkD.lSm;
            userMuteAddAndDelCustomMessage.setTag(this.mkD.lSm);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.mkD.lSm;
            userMuteCheckCustomMessage.setTag(this.mkD.lSm);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.iya = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
    }

    private void initData() {
        this.lRQ = com.baidu.tbadk.baseEditMark.a.a(this.lRi);
        if (this.lRQ != null) {
            this.lRQ.a(this.lSW);
        }
        this.gev = new ForumManageModel(this.lRi);
        this.gev.setLoadDataCallBack(this.iyf);
        this.faF = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.mkD = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lSd = new g();
        d(this.lSd);
        this.lSe = (com.baidu.tbadk.editortools.pb.e) this.lSd.fg(getActivity());
        this.lSe.a(this.lRi.getPageContext());
        this.lSe.a(this.fDW);
        this.lSe.a(this.fDO);
        this.lSe.setFrom(1);
        this.lSe.a(this.lRi.getPageContext(), bundle);
        this.lSe.bBh().c(new k(getActivity()));
        this.lSe.bBh().kN(true);
        uY(true);
        this.lSe.a(dmx().doR(), dmx().doA(), dmx().dpi());
        registerListener(this.lSB);
        registerListener(this.lSV);
        registerListener(this.lSA);
        registerListener(this.lSy);
        registerListener(this.jhX);
        if (!dmx().doI()) {
            this.lSe.CV(dmx().doA());
        }
        if (dmx().dpj()) {
            this.lSe.CT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lSe.CT(dqu());
        }
        this.kWC = new ar();
        if (this.lSe.bBN() != null) {
            this.kWC.f(this.lSe.bBN().getInputView());
        }
        this.lSe.a(this.fDP);
        this.kSz = new am(getPageContext());
        this.kSz.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == am.faA) {
                        VideoPbFragment.this.lSe.a((String) null, (WriteData) null);
                    } else if (i == am.faB && VideoPbFragment.this.mau != null && VideoPbFragment.this.mau.dnl() != null) {
                        VideoPbFragment.this.mau.dnl().bCm();
                    } else if (i == am.faC) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lSh);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        initUI();
        return this.rootView;
    }

    private void initUI() {
        this.jlq = new com.baidu.tieba.f.b(getActivity());
        this.jlq.a(lTe);
        this.mkJ = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bEL();
        this.ZM = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.mkn = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.mkp = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.mkq = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.mkp);
        this.mkq.setStageType("2002");
        this.mkq.setUniqueId(getUniqueId());
        this.mkq.af(this);
        this.mkq.dT(doh().getRootView());
        this.mkq.dU(this.mks);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.mkl = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mkt = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eZd = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.mko = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.lQg = (MaskView) this.rootView.findViewById(R.id.mask_view);
        this.mko.setOnClickListener(this.aEh);
        dtY();
        dtX();
        dtZ();
        this.mkm = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eZd.setAdapter(this.mkm);
        this.mkl.setViewPager(this.eZd);
        this.mkl.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dup() != null) {
                        VideoPbFragment.this.dup().wv(false);
                    } else if (VideoPbFragment.this.dun() != null) {
                        VideoPbFragment.this.dun().wv(false);
                    }
                    if (VideoPbFragment.this.duo() != null) {
                        VideoPbFragment.this.duo().wv(true);
                        VideoPbFragment.this.Gv(VideoPbFragment.this.duo().dvc() != 0 ? 0 : 8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                    if (videoPbViewModel.duG() != null && videoPbViewModel.duG().getValue() != null && videoPbViewModel.duG().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.mkq.ww(z);
                    VideoPbFragment.this.dqs();
                    if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13592").dR("tid", VideoPbFragment.this.dmx().doA()).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.duo() != null) {
                        VideoPbFragment.this.duo().wv(false);
                    }
                    if (com.baidu.tbadk.a.d.bja() && VideoPbFragment.this.dup() != null) {
                        VideoPbFragment.this.dup().wv(true);
                        int dvc = VideoPbFragment.this.dup().dvc();
                        int dvd = VideoPbFragment.this.dup().dvd();
                        if (dvc != 0) {
                            VideoPbFragment.this.Gv(8);
                            VideoPbFragment.this.dup().Gv(0);
                        } else if (dvd != 0) {
                            VideoPbFragment.this.dup().Gv(8);
                            VideoPbFragment.this.Gv(0);
                        } else {
                            VideoPbFragment.this.dup().Gv(8);
                            VideoPbFragment.this.Gv(8);
                        }
                    } else if (VideoPbFragment.this.dun() != null) {
                        VideoPbFragment.this.dun().wv(true);
                        int dvc2 = VideoPbFragment.this.dun().dvc();
                        int dvd2 = VideoPbFragment.this.dun().dvd();
                        if (dvc2 != 0) {
                            VideoPbFragment.this.Gv(8);
                            VideoPbFragment.this.dun().Gv(0);
                        } else if (dvd2 != 0) {
                            VideoPbFragment.this.dun().Gv(8);
                            VideoPbFragment.this.Gv(0);
                        } else {
                            VideoPbFragment.this.dun().Gv(8);
                            VideoPbFragment.this.Gv(8);
                        }
                    }
                    VideoPbFragment.this.mkq.ww(false);
                    VideoPbFragment.this.ZM.setExpanded(false, true);
                    if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13593").dR("tid", VideoPbFragment.this.dmx().doA()).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.mkm.Gx(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lZr = this.rootView.findViewById(R.id.viewstub_progress);
        dua();
        bWu();
        if (!this.mkJ && this.mkK) {
            dus();
            UtilHelper.hideStatusBar(doh(), doh().getRootView());
            this.mkK = false;
        }
        if (com.baidu.tbadk.a.d.bja()) {
            this.mkl.getLayoutParams().height = 0;
        }
    }

    private void dtX() {
        this.mkv = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.mkz = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.mkw = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.mkx = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.mky = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.mkA = this.rootView.findViewById(R.id.ala_live_point);
        this.mkz.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.mkz.setConrers(15);
        this.mky.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.mkx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lKW == null || VideoPbFragment.this.lKW.dvo()) {
                    if (VideoPbFragment.this.lKW != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13608").dR("tid", VideoPbFragment.this.dmx().getPbData().getThreadId()));
                        VideoPbFragment.this.lKW.mmG = true;
                    }
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13591"));
                }
                VideoPbFragment.this.dui();
            }
        });
        this.mky.setOnClickListener(this.mku);
        this.mkt.setOnClickListener(this.mku);
    }

    private void dtY() {
        this.mkl.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.mkl.setContainerLayoutParams(layoutParams);
        this.mkl.setRectPaintColor(R.color.CAM_X0302);
        this.mkl.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.mkl.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.mkl.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.mkl.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.mkl.setExpandedTabLayoutParams(layoutParams2);
    }

    public void wm(boolean z) {
        if (this.ZM != null) {
            this.ZM.setExpanded(z);
        }
    }

    private void dtZ() {
        this.lZJ = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lZK = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lZU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lZV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lZM = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lZM.setVisibility(0);
        this.lZM.setIsRound(true);
        this.lZM.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.lZM.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lZM.setPlaceHolder(0);
        dqy();
        this.kpu = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lZL = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huitie"))) {
                    VideoPbFragment.this.wm(false);
                    VideoPbFragment.this.dny();
                    if (VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().dlg() != null && VideoPbFragment.this.dmx().getPbData().dlg().bnQ() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dR("tid", VideoPbFragment.this.dmx().doB()).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmx().doA()).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()).ap("obj_locate", 1).dR("uid", VideoPbFragment.this.dmx().getPbData().dlg().bnQ().getUserId()));
                    }
                }
            }
        });
        this.lZN = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lZN.setOnClickListener(this.aEh);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lZO = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lZO.setOnClickListener(this.aEh);
        if (booleanExtra) {
            this.lZO.setVisibility(8);
        } else {
            this.lZO.setVisibility(0);
        }
        this.lZP = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lZP.setOnClickListener(this.aEh);
        this.lZQ = new com.baidu.tieba.pb.view.d(this.lZP);
        this.lZQ.dvE();
        this.lZR = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lZR.setVisibility(0);
        vK(false);
    }

    public void wn(boolean z) {
        DetailInfoAndReplyFragment dup = dup();
        if (dup != null && dup.duW() != null && dup.duW().duS() != null && dup.duW().duR() != null) {
            dup.duW().duS().uT(z);
            dup.duW().duR().vS(z);
        }
        if (this.lQg != null) {
            this.lQg.setVisibility(z ? 0 : 8);
        }
    }

    private void dqy() {
        if (this.lZM != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lZM.setImageResource(0);
            this.lZM.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lZM.setImageResource(R.drawable.transparent_bg);
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cDc();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mks = this.rootView.findViewById(R.id.status_bar_background);
        if (this.mkJ) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(doh());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mks.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(doh());
            this.mks.setLayoutParams(layoutParams2);
            this.mks.setVisibility(0);
        }
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aEh);
        this.gYq = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsR().a(this.gYq, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jxc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aEh);
        this.ahC = (ImageView) this.jxc.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jxc.setLayoutParams(layoutParams3);
        SvgManager.bsR().a(this.ahC, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jxc.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.jsN);
        this.mNavigationBar.setOnTouchListener(this.mkL);
    }

    public void dua() {
        setEditorTools(this.lSe.bBh());
    }

    private void bWu() {
        this.lRd = new PbFakeFloorModel(getPageContext());
        this.mau = new r(getPageContext(), this.lRd, this.rootView);
        this.mau.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dqs();
            }
        });
        this.mau.a(this.lSS);
        this.lRd.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lRd.u(postData);
                if (com.baidu.tbadk.a.d.bja() || VideoPbFragment.this.dup() != null) {
                    VideoPbFragment.this.dup().duY();
                } else if (VideoPbFragment.this.dun() != null) {
                    VideoPbFragment.this.dun().duY();
                }
                VideoPbFragment.this.mau.dnh();
                VideoPbFragment.this.acR.bzD();
                VideoPbFragment.this.vK(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a Px;
        PostData L;
        String doA = dmx().doA();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dmx().getPbData() != null) {
            i = dmx().getPbData().dlv();
        }
        if (dun() != null && dun().dva() != null) {
            Px = dun().dva().Px(id);
        } else if (dup() != null && dup().dva() != null) {
            Px = dup().dva().Px(id);
        } else {
            return;
        }
        if (postData != null && dmx() != null && dmx().getPbData() != null && Px != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(doA, id, "pb", true, null, false, str, i, postData.dts(), dmx().getPbData().getAnti(), false, postData.bnQ().getIconInfo()).addBigImageData(Px.lNK, Px.eJM, Px.eJK, Px.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dmx().getForumId());
            addBigImageData.setBjhData(dmx().doK());
            addBigImageData.setKeyPageStartFrom(dmx().dpl());
            addBigImageData.setFromFrsForumId(dmx().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dmx().getPbData().dlP() != null) {
                addBigImageData.setHasForumRule(dmx().getPbData().dlP().has_forum_rule.intValue());
            }
            if (dmx().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dmx().getPbData().getUserData().getIs_manager());
            }
            if (dmx().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dmx().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dmx().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dmx().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dmx().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dmx().getPbData().getForum().getUser_level());
            }
            if (dmx() != null && (L = L(dmx().getPbData())) != null) {
                addBigImageData.setMainPostMaskVisibly(L.nxK || postData.nxK);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lRi = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dmx() != null) {
            dmx().aD(bundle);
        }
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
        getVoiceManager().onPause(getPageContext());
        this.mkq.sp(true);
        if (dmx() != null && !dmx().doI()) {
            this.lSe.CU(dmx().doA());
        }
        com.baidu.tbadk.BdToken.c.bhn().bhy();
        MessageManager.getInstance().unRegisterListener(this.lSL);
        MessageManager.getInstance().unRegisterListener(this.lSM);
        MessageManager.getInstance().unRegisterListener(this.lSN);
        MessageManager.getInstance().unRegisterListener(this.juR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.mkq.sp(false);
        dod();
        registerListener(this.lSL);
        registerListener(this.lSM);
        registerListener(this.lSN);
        registerListener(this.juR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.mkm != null && this.eZd != null) {
            this.mkm.Gx(z ? this.eZd.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        dqy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lZQ != null) {
            this.lZQ.onDestroy();
        }
        if (this.gev != null) {
            this.gev.cancelLoadData();
        }
        if (this.mkq != null) {
            this.mkq.onDestroy();
        }
        if (this.lRB != null) {
            this.lRB.cancelLoadData();
        }
        if (this.kSz != null) {
            this.kSz.onDestroy();
        }
        if (dmx() != null) {
            dmx().cancelLoadData();
            dmx().destory();
            if (dmx().dpf() != null) {
                dmx().dpf().onDestroy();
            }
        }
        if (this.lSe != null) {
            this.lSe.onDestroy();
        }
        this.lSl = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lRi);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ap.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ap.setBackgroundColor(this.mks, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mkl, R.color.CAM_X0207);
        if (this.mkl != null) {
            this.mkl.onChangeSkinType();
        }
        if (this.kWC != null) {
            this.kWC.onChangeSkinType();
        }
        if (this.mkr == null || !this.mkr.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.acR != null) {
            this.acR.onChangeSkinType(i);
        }
        if (this.mau != null) {
            this.mau.onChangeSkinType(i);
        }
        if (this.lZM != null) {
            this.lZM.setBorderColor(ap.getColor(R.color.CAM_X0401));
        }
        if (this.lZL != null) {
            this.lZL.setBackgroundDrawable(ap.aL(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
        }
        if (dmx() != null && dmx().bjZ()) {
            WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.lZN, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.bsR().a(this.mkx, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dmx() != null) {
            x(dmx().getPbData());
        }
        ap.setBackgroundResource(this.mkn, R.drawable.personalize_tab_shadow);
        ap.setBackgroundColor(this.mkt, R.color.CAM_X0206);
        ap.setBackgroundColor(this.lZK, R.color.CAM_X0207);
        ap.setBackgroundColor(this.lZJ, R.color.CAM_X0203);
        ap.setViewTextColor(this.mkw, R.color.CAM_X0109);
        ap.setViewTextColor(this.mkv, R.color.CAM_X0105);
        ap.setViewTextColor(this.kpu, R.color.CAM_X0109);
        ap.setViewTextColor(this.lZS, R.color.CAM_X0105);
        ap.setViewTextColor(this.lZR, R.color.CAM_X0107);
        ap.d(this.lZR, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bja() && dup() != null) {
            dup().onChangeSkinType(i);
        } else if (dun() != null) {
            dun().onChangeSkinType(i);
        }
        if (duo() != null) {
            duo().onChangeSkinType(i);
        }
        if (this.mkA != null) {
            this.mkA.setBackgroundDrawable(ap.aL(l.getDimens(this.mkA.getContext(), R.dimen.tbds32), ap.getColor(R.color.CAM_X0309)));
        }
        cDb();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        if (this.jgu != null) {
            this.jgu.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dof() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dog() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dmx() {
        return this.lRi.dmx();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity doh() {
        return this.lRi;
    }

    public com.baidu.tbadk.baseEditMark.a dub() {
        return this.lRQ;
    }

    public View.OnClickListener duc() {
        return this.aEh;
    }

    public View.OnClickListener dud() {
        return this.lOs;
    }

    public View.OnLongClickListener due() {
        return this.mOnLongClickListener;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.au.PM(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cFV() {
        Iterator<BaseFragment> it = this.mkm.dux().iterator();
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

    private void uY(boolean z) {
        this.lSe.kV(z);
        this.lSe.kW(z);
        this.lSe.kX(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.mkD != null) {
            if (z) {
                this.mkD.drk();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.mkD.drl();
            } else {
                this.mkD.drk();
            }
        }
    }

    public boolean FI(int i) {
        if (this.kSz == null || dmx() == null || dmx().getPbData() == null || dmx().getPbData().getAnti() == null) {
            return true;
        }
        return this.kSz.aK(dmx().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dnA() {
        if ((dmx() != null && dmx().getPbData().dlJ()) || this.kSz == null || dmx() == null || dmx().getPbData() == null || dmx().getPbData().getAnti() == null) {
            return true;
        }
        return this.kSz.ox(dmx().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dmx() != null) {
            gVar.setForumName(dmx().dmq());
            if (dmx().getPbData() != null && dmx().getPbData().getForum() != null) {
                gVar.a(dmx().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dmx());
        }
    }

    public void dqJ() {
        if (this.acR != null) {
            this.acR.display();
            if (this.lSe != null) {
                this.lSe.bBS();
            }
            drt();
        }
    }

    public com.baidu.tbadk.editortools.pb.e dnm() {
        return this.lSe;
    }

    private boolean dnx() {
        PbModel dmx = dmx();
        if (dmx == null || dmx.getPbData() == null) {
            return false;
        }
        cb dlg = dmx.getPbData().dlg();
        dmx.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dlg);
    }

    public void dny() {
        if (checkUpIsLogin() && dmx() != null && dmx().getPbData() != null && dmx().getPbData().getForum() != null && !dnx()) {
            if (dmx().getPbData().dlJ()) {
                cSt();
                return;
            }
            if (this.jkQ == null) {
                this.jkQ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jkQ.Ae(0);
                this.jkQ.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qM(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qN(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lSe != null && VideoPbFragment.this.lSe.bBh() != null) {
                                VideoPbFragment.this.lSe.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cSt();
                        }
                    }
                });
            }
            this.jkQ.G(dmx().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dmx().doA(), 0L));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lSe.onActivityResult(i, i2, intent);
        if (this.lRB != null) {
            this.lRB.onActivityResult(i, i2, intent);
        }
        if (this.mau != null) {
            this.mau.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dnK();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dCY().I(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lSh = emotionImageData;
                        if (FI(am.faC)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                default:
                    return;
                case 25055:
                    if (this.lRD != null) {
                        this.lRD.performClick();
                        return;
                    }
                    return;
                case 25056:
                    if (this.lRE != null) {
                        this.lRE.performClick();
                        return;
                    }
                    return;
                case 25057:
                    if (drJ() != null) {
                        drJ().performClick();
                        return;
                    }
                    return;
                case 25058:
                    if (this.lRF != null) {
                        this.lRF.performClick();
                        return;
                    }
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (doh() != null) {
            if (this.mkK && !TbSingleton.getInstance().isNotchScreen(doh()) && !TbSingleton.getInstance().isCutoutScreen(doh())) {
                dus();
                UtilHelper.hideStatusBar(doh(), doh().getRootView());
                this.mkK = false;
            }
            this.mkE.mkZ = z;
            duf();
            dug();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lRi;
        if (i == 0) {
            dqo();
            if (this.mau != null) {
                this.mau.dnh();
            }
            vK(false);
        }
        dqs();
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
                        this.lSe.resetData();
                        this.lSe.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lSe.c(writeData);
                        m qU = this.lSe.bBh().qU(6);
                        if (qU != null && qU.fBo != null) {
                            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lRi;
                        if (i == -1) {
                            this.lSe.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.mau != null && this.mau.dnl() != null) {
                            com.baidu.tbadk.editortools.pb.h dnl = this.mau.dnl();
                            dnl.setThreadData(dmx().getPbData().dlg());
                            dnl.c(writeData);
                            dnl.setVoiceModel(pbEditorData.getVoiceModel());
                            m qU2 = dnl.bBh().qU(6);
                            if (qU2 != null && qU2.fBo != null) {
                                qU2.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lRi;
                            if (i == -1) {
                                dnl.bCm();
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
                if (dmx() != null && !dmx().doI()) {
                    antiData.setBlock_forum_name(dmx().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dmx().getPbData().getForum().getId());
                    antiData.setUser_name(dmx().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dmx().getPbData().getUserData().getUserId());
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
                com.baidu.tieba.tbadkCore.writeModel.g.j(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.mkD != null) {
                this.mkD.Da(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void doj() {
        if (dmx() != null && this.lRi != null) {
            if (this.lSe == null || !this.lSe.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lSe = (com.baidu.tbadk.editortools.pb.e) dVar.fg(getContext());
                this.lSe.a(this.lRi.getPageContext());
                this.lSe.a(this.fDW);
                this.lSe.a(this.fDO);
                this.lSe.a(this.lRi.getPageContext(), this.lRi.getIntent() == null ? null : this.lRi.getIntent().getExtras());
                this.lSe.bBh().kN(true);
                setEditorTools(this.lSe.bBh());
                if (!dmx().doI()) {
                    this.lSe.CV(dmx().doA());
                }
                if (dmx().dpj()) {
                    this.lSe.CT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lSe.CT(dqu());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
        this.acR.setId(R.id.pb_editor);
        this.acR.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dqs();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acR.getParent() == null) {
            this.rootView.addView(this.acR, layoutParams);
        }
        this.acR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acR.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bwv() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bwv() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lSe.c((u) aVar.data);
                            VideoPbFragment.this.lSe.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dqo();
        this.lSe.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.acR != null && VideoPbFragment.this.acR.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kWC != null && VideoPbFragment.this.kWC.drM() != null) {
                    if (!VideoPbFragment.this.kWC.drM().dWy()) {
                        VideoPbFragment.this.kWC.vQ(false);
                    }
                    VideoPbFragment.this.kWC.drM().zu(false);
                }
            }
        });
    }

    public void cSt() {
        if (!checkUpIsLogin()) {
            if (dmx() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 2).dR("fid", dmx().getForumId()));
            }
        } else if (dnA()) {
            if (this.lSe != null && (this.lSe.bCc() || this.lSe.bCd())) {
                this.lSe.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acR != null) {
                dqJ();
                this.mkE.mkY = false;
                if (this.acR.qU(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.acR.qU(2).fBo, false, null);
                }
            }
            drt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dnx() && dnA()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lRG);
                this.lRH = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.mau != null && postData != null) {
                String str3 = "";
                if (postData.dNH() != null) {
                    str3 = postData.dNH().toString();
                }
                this.mau.Pr(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnQ().getName_show(), str3));
            }
            if (dmx() != null && dmx().getPbData() != null && dmx().getPbData().dlJ()) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lRi.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lRG[1] + VideoPbFragment.this.lRH) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFV() != null) {
                            VideoPbFragment.this.cFV().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.mau != null) {
                            VideoPbFragment.this.lSe.bBh().setVisibility(8);
                            VideoPbFragment.this.mau.j(str, str2, VideoPbFragment.this.dqu(), (VideoPbFragment.this.dmx() == null || VideoPbFragment.this.dmx().getPbData() == null || VideoPbFragment.this.dmx().getPbData().dlg() == null || !VideoPbFragment.this.dmx().getPbData().dlg().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnl = VideoPbFragment.this.mau.dnl();
                            if (dnl != null && VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                                dnl.a(VideoPbFragment.this.dmx().getPbData().getAnti());
                                dnl.setThreadData(VideoPbFragment.this.dmx().getPbData().dlg());
                            }
                            if (VideoPbFragment.this.kWC.drO() == null && VideoPbFragment.this.mau.dnl().bCu() != null) {
                                VideoPbFragment.this.mau.dnl().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kWC != null && VideoPbFragment.this.kWC.drN() != null) {
                                            if (!VideoPbFragment.this.kWC.drN().dWy()) {
                                                VideoPbFragment.this.kWC.vR(false);
                                            }
                                            VideoPbFragment.this.kWC.drN().zu(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kWC.g(VideoPbFragment.this.mau.dnl().bCu().getInputView());
                                VideoPbFragment.this.mau.dnl().a(VideoPbFragment.this.lSj);
                            }
                        }
                        VideoPbFragment.this.drt();
                    }
                }, 0L);
                return;
            }
            if (this.lSg == null) {
                this.lSg = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lSg.Ae(1);
                this.lSg.a(new AnonymousClass49(str, str2));
            }
            if (dmx() != null && dmx().getPbData() != null && dmx().getPbData().getForum() != null) {
                this.lSg.G(dmx().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dmx().doA(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lTn;
        final /* synthetic */ String lTo;

        AnonymousClass49(String str, String str2) {
            this.lTn = str;
            this.lTo = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lRG[1] + VideoPbFragment.this.lRH) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cFV() != null) {
                            VideoPbFragment.this.cFV().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.mau != null) {
                            VideoPbFragment.this.lSe.bBh().setVisibility(8);
                            VideoPbFragment.this.mau.j(AnonymousClass49.this.lTn, AnonymousClass49.this.lTo, VideoPbFragment.this.dqu(), (VideoPbFragment.this.dmx() == null || VideoPbFragment.this.dmx().getPbData() == null || VideoPbFragment.this.dmx().getPbData().dlg() == null || !VideoPbFragment.this.dmx().getPbData().dlg().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnl = VideoPbFragment.this.mau.dnl();
                            if (dnl != null && VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null) {
                                dnl.a(VideoPbFragment.this.dmx().getPbData().getAnti());
                                dnl.setThreadData(VideoPbFragment.this.dmx().getPbData().dlg());
                            }
                            if (VideoPbFragment.this.kWC.drO() == null && VideoPbFragment.this.mau.dnl().bCu() != null) {
                                VideoPbFragment.this.mau.dnl().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kWC != null && VideoPbFragment.this.kWC.drN() != null) {
                                            if (!VideoPbFragment.this.kWC.drN().dWy()) {
                                                VideoPbFragment.this.kWC.vR(false);
                                            }
                                            VideoPbFragment.this.kWC.drN().zu(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kWC.g(VideoPbFragment.this.mau.dnl().bCu().getInputView());
                                VideoPbFragment.this.mau.dnl().a(VideoPbFragment.this.lSj);
                            }
                        }
                        VideoPbFragment.this.drt();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData L;
        ad adVar;
        StringBuilder sb = null;
        if (fVar != null && (L = L(fVar)) != null) {
            String userId = L.bnQ().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlv()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (L.bnQ() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, L.bnQ().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, L.bnQ().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, L.bnQ().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, L.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlv()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bx> dlD = fVar.dlD();
                if (y.getCount(dlD) > 0) {
                    sb = new StringBuilder();
                    for (bx bxVar : dlD) {
                        if (bxVar != null && !StringUtils.isNull(bxVar.getForumName()) && (adVar = bxVar.ePM) != null && adVar.eNw && !adVar.eNx && (adVar.type == 1 || adVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bxVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void dnK() {
        MarkData FV;
        if (dmx() != null && dmx().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bja() || dun() != null) {
                if ((!com.baidu.tbadk.a.d.bja() || dup() != null) && this.lRQ != null) {
                    if (dmx().getPbData() != null && dmx().getPbData().dlJ()) {
                        FV = dmx().FV(0);
                    } else if (this.eZd != null && this.eZd.getCurrentItem() == mkh) {
                        FV = dmx().o(L(dmx().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bja()) {
                        FV = dmx().FV(dup().dqW());
                    } else {
                        FV = dmx().FV(dun().dqW());
                    }
                    if (FV != null) {
                        if (!FV.isApp() || (FV = dmx().FV(dun().dqW() + 1)) != null) {
                            dqR();
                            this.lRQ.a(FV);
                            if (!this.lRQ.bjZ()) {
                                this.lRQ.bkb();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lRQ.bka();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK(int i) {
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
            if (this.lRB == null) {
                this.lRB = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lRi);
                this.lRB.b(this.fDO);
                this.lRB.c(this.fDW);
            }
            this.lRB.a(emotionImageData, dmx(), dmx().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlt() != null) {
            return fVar.dlt();
        }
        if (!y.isEmpty(fVar.dli())) {
            Iterator<PostData> it = fVar.dli().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNF() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dlp();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnQ() != null && postData.bnQ().getUserTbVipInfoData() != null && postData.bnQ().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnQ().getGodUserData().setIntro(postData.bnQ().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlg() == null || fVar.dlg().bnQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnQ = fVar.dlg().bnQ();
        String userId = bnQ.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlg().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnQ;
        }
        postData.JE(1);
        postData.setId(fVar.dlg().bog());
        postData.setTitle(fVar.dlg().getTitle());
        postData.setTime(fVar.dlg().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnP() {
        ArrayList<PostData> dli;
        int count;
        int i;
        if (dmx() == null || dmx().getPbData() == null || dmx().getPbData().dli() == null || (count = y.getCount((dli = dmx().getPbData().dli()))) == 0) {
            return "";
        }
        if (dmx().doT()) {
            Iterator<PostData> it = dli.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dNF() == 1) {
                    return next.getId();
                }
            }
        }
        if (cFV() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bja()) {
            i = dup().dqV();
        } else {
            i = dun().dqV();
        }
        PostData postData = (PostData) y.getItem(dli, i);
        if (postData == null || postData.bnQ() == null) {
            return "";
        }
        if (dmx().PA(postData.bnQ().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) y.getItem(dli, i2);
            if (postData2 == null || postData2.bnQ() == null || postData2.bnQ().getUserId() == null) {
                break;
            } else if (dmx().PA(postData2.bnQ().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) y.getItem(dli, i3);
            if (postData3 == null || postData3.bnQ() == null || postData3.bnQ().getUserId() == null) {
                return "";
            }
            if (dmx().PA(postData3.bnQ().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnL() {
        if (dmx() != null) {
            com.baidu.tieba.pb.data.f pbData = dmx().getPbData();
            dmx().vo(true);
            if (this.lRQ != null) {
                pbData.Pl(this.lRQ.bjY());
            }
            if (com.baidu.tbadk.a.d.bja() && dup() != null) {
                dup().duY();
            } else if (dun() != null) {
                dun().duY();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dmx() != null) {
            dqT();
            dmx().vo(z);
            if (this.lRQ != null) {
                this.lRQ.ja(z);
                if (markData != null) {
                    this.lRQ.a(markData);
                }
            }
            if (dmx().bjZ()) {
                dnL();
            } else if (com.baidu.tbadk.a.d.bja() && dup() != null) {
                dup().duY();
            } else if (dun() != null) {
                dun().duY();
            }
        }
    }

    public void b(q qVar) {
        boolean z;
        MetaData metaData;
        if (dmx() != null && dmx().getPbData() != null && qVar.dlY() != null) {
            String id = qVar.dlY().getId();
            ArrayList<PostData> dli = dmx().getPbData().dli();
            int i = 0;
            while (true) {
                if (i >= dli.size()) {
                    z = true;
                    break;
                }
                PostData postData = dli.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dmh = qVar.dmh();
                    postData.JD(qVar.getTotalCount());
                    if (postData.dNC() == null || dmh == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dmh.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnQ() != null && (metaData = postData.getUserMap().get(next.bnQ().getUserId())) != null) {
                                next.a(metaData);
                                next.yw(true);
                                next.a(getPageContext(), dmx().PA(metaData.getUserId()));
                            }
                        }
                        z = dmh.size() != postData.dNC().size();
                        if (postData.dNC() != null && postData.dNC().size() < 2) {
                            postData.dNC().clear();
                            postData.dNC().addAll(dmh);
                        }
                    }
                    if (postData.dNy() != null) {
                        postData.dNz();
                    }
                }
            }
            if (!dmx().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bja() && dup() != null) {
                    dup().duY();
                } else if (dun() != null) {
                    dun().duY();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnC() {
        if (dmx() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.SA(dmx().getForumId()) && dmx().getPbData() != null && dmx().getPbData().getForum() != null) {
            if (dmx().getPbData().getForum().isLike() == 1) {
                dmx().dph().gr(dmx().getForumId(), dmx().doA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            cb dlg = fVar.dlg();
            if (dlg != null && dlg.bmz()) {
                doj();
            } else {
                d(this.lSd);
            }
            if (this.lSe != null) {
                vI(this.lSe.bBV());
                this.lSe.a(fVar.getAnti());
                this.lSe.a(fVar.getForum(), fVar.getUserData());
                this.lSe.setThreadData(dlg);
                if (dmx() != null) {
                    this.lSe.a(dmx().doR(), dmx().doA(), dmx().dpi());
                }
                if (dlg != null) {
                    this.lSe.kY(dlg.bpp());
                }
            }
        }
    }

    public void dqs() {
        reset();
        dqo();
        this.mau.dnh();
        vK(false);
    }

    private void reset() {
        if (this.lSe != null && this.acR != null) {
            com.baidu.tbadk.editortools.pb.a.bBK().setStatus(0);
            this.lSe.bCf();
            this.lSe.bBu();
            if (this.lSe.getWriteImagesInfo() != null) {
                this.lSe.getWriteImagesInfo().setMaxImagesAllowed(this.lSe.isBJH ? 1 : 9);
            }
            this.lSe.re(SendView.ALL);
            this.lSe.rf(SendView.ALL);
            com.baidu.tbadk.editortools.h qR = this.acR.qR(23);
            com.baidu.tbadk.editortools.h qR2 = this.acR.qR(2);
            com.baidu.tbadk.editortools.h qR3 = this.acR.qR(5);
            if (qR2 != null) {
                qR2.display();
            }
            if (qR3 != null) {
                qR3.display();
            }
            if (qR != null) {
                qR.hide();
            }
            this.acR.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null) {
            x(fVar);
            this.lZO.setVisibility(fVar.dlJ() ? 8 : 0);
            if (fVar.bjZ()) {
                WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Gd = Gd(fVar.dlg().bnH());
            if (this.lZR != null) {
                this.lZR.setText(Gd);
            }
            if (this.lZS != null) {
                this.lZS.setText(Gd);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dlg()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bd(fVar.dlg())) {
            if (this.lZQ != null) {
                this.lZQ.setEnable(false);
                this.lZQ.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lZP.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lZP.setLayoutParams(layoutParams);
            WebPManager.a(this.lZP, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lZQ == null || !this.lZQ.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lZP.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lZP.setLayoutParams(layoutParams2);
            WebPManager.a(this.lZP, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    private String Gd(int i) {
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
            return numberFormat.format(i / 10000.0f) + "W";
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + "W";
        } else {
            return "" + i;
        }
    }

    public void vK(boolean z) {
        if (this.lZK != null) {
            vI(this.lSe.bBV());
            if (this.lZG) {
                vz(z);
            } else {
                vA(z);
            }
            duf();
            dug();
        }
    }

    public void drt() {
        if (this.lZK != null) {
            this.lZJ.setVisibility(8);
            this.lZK.setVisibility(8);
            this.mkE.mkY = false;
            duf();
            dug();
        }
    }

    private void duf() {
        if (this.mkq != null) {
            if (this.mkE.duw()) {
                this.mkq.xp(false);
            } else {
                this.mkq.xp(this.mkq.isVertical() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dug() {
        if (this.mkq != null && this.eZd != null) {
            if (com.baidu.tbadk.a.d.bja()) {
                this.mkq.ww(false);
            } else if (this.eZd.getCurrentItem() != 0) {
                this.mkq.ww(false);
            } else if (this.mkE.duw()) {
                this.mkq.ww(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.mkq.ww(videoPbViewModel.duG() == null || videoPbViewModel.duG().getValue() == null || videoPbViewModel.duG().getValue().booleanValue());
                }
            }
        }
    }

    private void FL(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(doh(), dnB(), i);
    }

    private int dnB() {
        if (dmx() == null || dmx().getPbData() == null || dmx().getPbData().dlg() == null) {
            return -1;
        }
        return dmx().getPbData().dlg().boC();
    }

    public void vI(boolean z) {
        this.lZG = z;
    }

    public void vz(boolean z) {
        if (this.lZK != null && this.kpu != null) {
            this.kpu.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZK.startAnimation(alphaAnimation);
            }
            this.lZJ.setVisibility(0);
            this.lZK.setVisibility(0);
            this.mkE.mkY = true;
        }
    }

    public void vA(boolean z) {
        if (this.lZK != null && this.kpu != null) {
            this.kpu.setText(dqu());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZK.startAnimation(alphaAnimation);
            }
            this.lZJ.setVisibility(0);
            this.lZK.setVisibility(0);
            this.mkE.mkY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lKW == null) {
            this.lKW = aVar;
            this.mkv.setText(aVar.getTitle());
            this.mkw.setText(aVar.dvl());
            String dvm = aVar.dvm();
            TBSpecificationBtn tBSpecificationBtn = this.mky;
            if (TextUtils.isEmpty(dvm)) {
                dvm = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dvm);
            this.mkz.startLoad(aVar.getImage(), 10, false);
            this.mkA.setVisibility(aVar.dvo() ? 0 : 8);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lKW == null || VideoPbFragment.this.lKW.dvo()) {
                        if (VideoPbFragment.this.lKW != null && VideoPbFragment.this.dmx() != null && VideoPbFragment.this.dmx().getPbData() != null && VideoPbFragment.this.dmx().getPbData().getForum() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13712").dR("fid", VideoPbFragment.this.dmx().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dmx().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmx().getPbData().getThreadId()).v("obj_param1", VideoPbFragment.this.lKW.userId));
                        }
                    } else {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13608").dR("obj_id", VideoPbFragment.this.lKW.getTitle()).dR("obj_name", VideoPbFragment.this.lKW.dvl()).ap("obj_type", 2).dR("fid", VideoPbFragment.this.dmx().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmx().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.duh();
                }
            }, aVar.dvn().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duh() {
        ViewGroup.LayoutParams layoutParams = this.mkt.getLayoutParams();
        if (layoutParams != null) {
            if (this.mkB == null || !this.mkB.isRunning()) {
                this.mkt.setAlpha(0.0f);
                this.mkt.setVisibility(0);
                g(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dui() {
        if (this.mkt.getLayoutParams() != null) {
            if (this.mkB == null || !this.mkB.isRunning()) {
                duj();
            }
        }
    }

    private void duj() {
        final ViewGroup.LayoutParams layoutParams = this.mkt.getLayoutParams();
        if (layoutParams != null) {
            if (this.mkC == null || !this.mkC.isRunning()) {
                this.mkC = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.mkC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mkt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.mkC.setDuration(200L);
                this.mkC.start();
                this.mkC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.f(layoutParams);
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
    public void f(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.ZM.getLayoutParams();
        final int i = layoutParams2.height;
        this.mkB = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mkB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kme);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.kme);
                VideoPbFragment.this.mkt.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZM.setLayoutParams(layoutParams2);
            }
        });
        this.mkB.setDuration(300L);
        this.mkB.start();
        this.mkB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mkt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void g(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.ZM.getLayoutParams();
        final int i = layoutParams2.height;
        this.mkB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mkB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kme);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mkt.setLayoutParams(layoutParams);
                VideoPbFragment.this.ZM.setLayoutParams(layoutParams2);
            }
        });
        this.mkB.setDuration(300L);
        this.mkB.start();
        this.mkB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.duk();
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
    public void duk() {
        this.mkB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mkB.setDuration(300L);
        this.mkB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mkt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mkB.start();
    }

    public String dqu() {
        if (!au.isEmpty(this.maN)) {
            return this.maN;
        }
        this.maN = TbadkCoreApplication.getInst().getResources().getString(ao.dqk());
        return this.maN;
    }

    public void dqT() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bja() && dup() != null) {
            dup().endLoadData();
            dup().dqU();
        } else if (dun() != null) {
            dun().endLoadData();
            dun().dqU();
        }
    }

    public boolean dC(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bkT().isShowImages()) {
                    return Pw(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dmx() == null || dmx().getPbData() == null) {
                        return true;
                    }
                    if (this.mau != null) {
                        this.mau.dnh();
                    }
                    q qVar = new q();
                    qVar.a(dmx().getPbData().getForum());
                    qVar.setThreadData(dmx().getPbData().dlg());
                    qVar.g(postData);
                    this.lRd.d(qVar);
                    this.lRd.setPostId(postData.getId());
                    a(view, postData.bnQ().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lSe != null) {
                        vI(this.lSe.bBV());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dul() {
        if (this.lSe != null) {
            vI(this.lSe.bBV());
        }
        dqs();
        this.mkD.drk();
    }

    private boolean Pw(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("bubble_link", "");
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

    public void dqN() {
        if (this.lZr != null) {
            this.lZr.setVisibility(0);
        }
    }

    public void dqO() {
        if (this.lZr != null) {
            this.lZr.setVisibility(8);
        }
    }

    public void Gv(int i) {
        if (this.mkn != null) {
            this.mkn.setVisibility(i);
        }
    }

    public void dqR() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dnF() {
        return this.lSU;
    }

    public void dqo() {
        if (this.acR != null) {
            this.acR.hide();
        }
    }

    public void cDc() {
        if (this.lRi.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lRi.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null) {
            String valueOf = String.valueOf(fVar.dlg().bnH());
            if (fVar.dlg().bnH() == 0) {
                valueOf = "";
            }
            this.mkl.Eg(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.mkm.dux()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dmx() != null && dmx().getPbData() != null && dmx().getPbData().dlg() != null && dmx().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(mam)).intValue();
                if (intValue == man) {
                    if (!this.gev.dOA()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gev.TE(au.R(jSONArray));
                        }
                        this.gev.a(dmx().getPbData().getForum().getId(), dmx().getPbData().getForum().getName(), dmx().getPbData().dlg().getId(), str, intValue3, intValue2, booleanValue, dmx().getPbData().dlg().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == mao || intValue == mar) {
                    if (dmx().dpe() != null) {
                        dmx().dpe().FD(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == mao) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(String str, String str2) {
        bf.bsV().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIh() {
        if (this.fUl == null) {
            this.fUl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
                /* renamed from: c */
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
                /* renamed from: d */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
                /* renamed from: e */
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
        return this.fUl;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIi() {
        if (this.fXB == null) {
            this.fXB = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fXB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIj() {
        if (this.fUm == null) {
            this.fUm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cxg */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
                    gifView.bCN();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fUm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIk() {
        if (this.fXC == null) {
            this.fXC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dok */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dH */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dI */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).ccB();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fXC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIl() {
        if (this.fXD == null) {
            this.fXD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dom */
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
        return this.fXD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIm() {
        this.fXE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dol */
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
        return this.fXE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lRu = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.au.PM(str) && dmx() != null && dmx().doA() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").ap("obj_param1", 1).dR("post_id", dmx().doA()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fAm = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.au.drQ().h(getPageContext(), str);
        }
        this.lRu = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        com.baidu.tieba.pb.pb.main.au.drQ().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lRu = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mkD.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b duU = this.mkD.duU();
            if (duU == null) {
                this.mkD.dnw();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                duU.getItemView(1).setVisibility(8);
            } else {
                duU.getItemView(1).setVisibility(0);
            }
            duU.bqz();
            this.lRu = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bf.bsV().b(getPageContext(), new String[]{str});
            this.lRu = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dum() {
        return this.faF;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bFG() {
        return this.bST;
    }

    public ReplyFragment dun() {
        if (this.mkm == null || !(this.mkm.Gw(mki) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.mkm.Gw(mki);
    }

    public DetailInfoFragment duo() {
        if (this.mkm == null || !(this.mkm.Gw(mkh) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.mkm.Gw(mkh);
    }

    public DetailInfoAndReplyFragment dup() {
        if (this.mkm == null || !(this.mkm.Gw(mkj) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.mkm.Gw(mkj);
    }

    public boolean dmp() {
        PbModel dmx = this.lRi.dmx();
        if (dmx == null) {
            return false;
        }
        return dmx.dmp();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dls;
        PbModel dmx = this.lRi.dmx();
        if (dmx != null && dmx.getPbData() != null && !dmx.getPbData().dlJ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dmx.getPbData().dlg().getId();
            if (dmx.isShareThread() && dmx.getPbData().dlg().eTc != null) {
                historyMessage.threadName = dmx.getPbData().dlg().eTc.showText;
            } else {
                historyMessage.threadName = dmx.getPbData().dlg().getTitle();
            }
            if (dmx.isShareThread() && !dmp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dmx.getPbData().getForum().getName();
            }
            ArrayList<PostData> dli = dmx.getPbData().dli();
            int dqV = dun() != null ? dun().dqV() : 0;
            if (dli != null && dqV >= 0 && dqV < dli.size()) {
                historyMessage.postID = dli.get(dqV).getId();
            }
            historyMessage.isHostOnly = dmx.getHostMode();
            historyMessage.isSquence = dmx.doC();
            historyMessage.isShareThread = dmx.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lSe != null) {
            this.lSe.onDestroy();
        }
        if (dmx != null && (dmx.doD() || dmx.doF())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dmx.doA());
            if (this.lRT) {
                if (this.lRV) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dmx.cvp());
                }
                if (this.lRU) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dmx.getIsGood());
                }
            }
            if (dmx.getPbData() != null && System.currentTimeMillis() - this.lRq >= 40000 && (dls = dmx.getPbData().dls()) != null && !y.isEmpty(dls.getDataList())) {
                intent.putExtra("guess_like_data", dls);
            }
            PbActivity pbActivity = this.lRi;
            PbActivity pbActivity2 = this.lRi;
            pbActivity.setResult(-1, intent);
        }
        if (dnM()) {
            if (dmx != null) {
                com.baidu.tieba.pb.data.f pbData = dmx.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lRw) {
                        if (this.mkp != null) {
                            Rect rect = new Rect();
                            this.mkp.getGlobalVisibleRect(rect);
                            aj.dpZ().g(rect);
                        }
                        aj.dpZ().FZ(this.eZd.getCurrentItem());
                        BdTypeRecyclerView cFV = cFV();
                        Parcelable parcelable = null;
                        if (cFV != null) {
                            parcelable = cFV.onSaveInstanceState();
                        }
                        aj.dpZ().a(dmx.doL(), parcelable, dmx.doC(), dmx.getHostMode(), false);
                    }
                }
            } else {
                aj.dpZ().reset();
            }
            dmL();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mkq != null && !this.mkq.isVertical()) {
            if ((this.mkq.isFullScreen() && configuration.orientation == 1) || (!this.mkq.isFullScreen() && configuration.orientation == 2)) {
                this.mkq.wx(false);
            }
        }
    }

    public boolean cFC() {
        if (this.mkq == null) {
            return false;
        }
        return this.mkq.isVertical();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public boolean mkY;
        public boolean mkZ;

        private a() {
            this.mkZ = true;
        }

        public boolean duw() {
            return (this.mkY && this.mkZ) ? false : true;
        }
    }

    public void duq() {
        this.lRI = -1;
        this.lRJ = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dod() {
        if (dmx() != null && !au.isEmpty(dmx().doA())) {
            com.baidu.tbadk.BdToken.c.bhn().q(com.baidu.tbadk.BdToken.b.eCf, com.baidu.adp.lib.f.b.toLong(dmx().doA(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mko.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dur() {
        if (this.mkN == null) {
            this.mkN = ObjectAnimator.ofFloat(this.mks, "alpha", 0.0f, 1.0f);
            this.mkN.setDuration(200L);
        }
        this.mkN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dus() {
        if (this.mkO == null) {
            this.mkO = ObjectAnimator.ofFloat(this.mks, "alpha", 1.0f, 0.0f);
            this.mkO.setDuration(200L);
        }
        this.mkO.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dut() {
        return this.mkq != null && this.mkq.duu();
    }

    public boolean duu() {
        return this.mkK;
    }

    public void wo(boolean z) {
        this.mkK = z;
    }

    public void vf(boolean z) {
        this.lRx = z;
    }

    public boolean dob() {
        return this.lRx;
    }

    public LinearLayout drJ() {
        return this.lZL;
    }
}
