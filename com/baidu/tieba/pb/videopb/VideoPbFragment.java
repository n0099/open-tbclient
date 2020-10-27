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
    private CustomViewPager eFw;
    private com.baidu.adp.lib.d.b<TextView> fDm;
    private com.baidu.adp.lib.d.b<View> fDn;
    private com.baidu.adp.lib.d.b<LinearLayout> fDo;
    private com.baidu.adp.lib.d.b<RelativeLayout> fDp;
    public View frR;
    private com.baidu.adp.lib.d.b<ImageView> fzV;
    private com.baidu.adp.lib.d.b<GifView> fzW;
    private ImageView gzN;
    private com.baidu.tieba.callfans.a hSV;
    private VoiceManager iBr;
    private com.baidu.tieba.frs.profession.permission.c iFN;
    private com.baidu.tieba.f.b iGn;
    public am kpC;
    public bb ktH;
    public View lBs;
    private NewPagerSlidingTabBaseStrip lFV;
    private VideoPbFragmentAdapter lFW;
    private View lFX;
    private View lFY;
    private VideoContainerLayout lFZ;
    private com.baidu.tieba.pb.videopb.videoView.a lGa;
    private f lGb;
    private View lGc;
    private View lGd;
    private TextView lGf;
    private TextView lGg;
    private ImageView lGh;
    private TBSpecificationBtn lGi;
    private TbImageView lGj;
    private View lGk;
    private ValueAnimator lGl;
    private ValueAnimator lGm;
    public com.baidu.tieba.pb.videopb.b.a lGn;
    private float lGr;
    private float lGs;
    private boolean lGt;
    private ObjectAnimator lGx;
    private ObjectAnimator lGy;
    private com.baidu.tieba.pb.videopb.c.a lhH;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lnD;
    int lnG;
    private PbFakeFloorModel lnf;
    private PbActivity lnl;
    private g lob;
    private com.baidu.tbadk.editortools.pb.e lod;
    private com.baidu.tieba.frs.profession.permission.c lof;
    private EmotionImageData loh;
    private com.baidu.tbadk.core.view.c lol;
    private View lvM;
    private LinearLayout lvO;
    private HeadImageView lvP;
    private ImageView lvQ;
    private ImageView lvR;
    private ImageView lvS;
    private com.baidu.tieba.pb.view.c lvT;
    private TextView lvU;
    private TextView lvV;
    private int lvX;
    private int lvY;
    private View lvv;
    private String lwM;
    private v lwv;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int lFR = 0;
    public static int lFS = 1;
    public static int lFT = 0;
    public static int lwn = 3;
    public static int lwo = 0;
    public static int lwp = 3;
    public static int lwq = 4;
    public static int lwr = 5;
    public static int lws = 6;
    private static final int jAA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int lFU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lpg = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cz(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dgM();
            } else {
                com.baidu.tieba.pb.a.b.dgL();
            }
        }
    };
    private long lns = 0;
    private boolean lnz = false;
    View.OnClickListener lGe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lhH == null || VideoPbFragment.this.lhH.dpA()) {
                if (VideoPbFragment.this.lhH != null) {
                    if (VideoPbFragment.this.lhH.isChushou) {
                        VideoPbFragment.this.eC(VideoPbFragment.this.lhH.thirdRoomId, VideoPbFragment.this.lhH.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lhH.dpB();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dR("fid", VideoPbFragment.this.dgX().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dgX().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dgX().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lhH.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dR("obj_id", VideoPbFragment.this.lhH.getTitle()).dR("obj_name", VideoPbFragment.this.lhH.dpx()).aj("obj_type", 2).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dgX().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lhH.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.boR().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lnO = null;
    private com.baidu.tbadk.coreExtra.model.a eHC = null;
    private ForumManageModel hST = null;
    private boolean lnw = false;
    private View lvN = null;
    private TextView jEf = null;
    private boolean lvJ = false;
    private String fjU = null;
    private boolean lnR = false;
    private boolean lnS = false;
    private boolean lnT = false;
    private boolean lny = false;
    int[] lnF = new int[2];
    private int lnH = -1;
    private int lnI = Integer.MIN_VALUE;
    private int los = 0;
    private int lGp = Integer.MIN_VALUE;
    private boolean byS = false;
    private boolean llm = com.baidu.tbadk.a.d.bfv();
    private final PbModel.a loW = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            h qX;
            VideoPbFragment.this.dlh();
            VideoPbFragment.this.cQS();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.uJ(false);
            if (z && fVar != null) {
                bw dfI = fVar.dfI();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.J(fVar);
                com.baidu.tieba.pb.videopb.c.a dgn = fVar.dgn();
                if (dgn != null && !dgn.lIq) {
                    VideoPbFragment.this.a(dgn);
                }
                VideoPbFragment.this.K(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lnO != null) {
                    VideoPbFragment.this.lnO.ih(fVar.bfV());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fjU = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fjU) && VideoPbFragment.this.lod != null && VideoPbFragment.this.lod.bwY() != null && (qX = VideoPbFragment.this.lod.bwY().qX(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fjU)) {
                        ((View) qX).setOnClickListener(VideoPbFragment.this.fkG);
                    }
                }
                if (VideoPbFragment.this.kpC != null && dfI != null && dfI.bka() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dfI.bka());
                    VideoPbFragment.this.kpC.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dgX().diV());
                        jSONObject.put("fid", VideoPbFragment.this.dgX().getForumId());
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
                if ((!com.baidu.tbadk.a.d.bfx() || VideoPbFragment.this.doB() != null) && VideoPbFragment.this.doz() != null) {
                    if (com.baidu.tbadk.a.d.bfx()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dgX().getPbData().dfK();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dHx() == 1)) {
                                if (VideoPbFragment.this.doB().div()) {
                                    VideoPbFragment.this.doB().Px(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.doB().Px(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.doB().Pw(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.doB().Pw("");
                        }
                        VideoPbFragment.this.doB().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dgX().getPbData().dfK();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dHx() == 1)) {
                                if (VideoPbFragment.this.doz().div()) {
                                    VideoPbFragment.this.doz().Px(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.doz().Px(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.doz().Pw(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.doz().Pw("");
                        }
                        VideoPbFragment.this.doz().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dGv().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0561a loY = new a.InterfaceC0561a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0561a
        public void d(boolean z, boolean z2, String str) {
            VideoPbFragment.this.dlh();
            if (z && VideoPbFragment.this.dgX() != null) {
                if (VideoPbFragment.this.lnO != null) {
                    VideoPbFragment.this.lnO.ih(z2);
                }
                VideoPbFragment.this.dgX().uo(z2);
                if (VideoPbFragment.this.dgX().bfV()) {
                    VideoPbFragment.this.dig();
                } else if (com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doB() != null) {
                    VideoPbFragment.this.doB().dpk();
                } else if (VideoPbFragment.this.doz() != null) {
                    VideoPbFragment.this.doz().dpk();
                }
                if (z2) {
                    if (VideoPbFragment.this.lnO != null) {
                        if (VideoPbFragment.this.lnO.bfY() != null && VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().dfI() != null && VideoPbFragment.this.dgX().getPbData().dfI().bka() != null) {
                            MarkData bfY = VideoPbFragment.this.lnO.bfY();
                            MetaData bka = VideoPbFragment.this.dgX().getPbData().dfI().bka();
                            if (bfY != null && bka != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), bka.getUserId()) && !bka.hadConcerned()) {
                                    VideoPbFragment.this.lGn.b(bka);
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
                    VideoPbFragment.this.did();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fjY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bxC() {
            if (VideoPbFragment.this.ktH == null || VideoPbFragment.this.ktH.dlZ() == null || !VideoPbFragment.this.ktH.dlZ().dQt()) {
                return !VideoPbFragment.this.FC(am.eHx);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.ktH.dlZ().dQv());
            if (VideoPbFragment.this.lod != null && (VideoPbFragment.this.lod.bxT() || VideoPbFragment.this.lod.bxU())) {
                VideoPbFragment.this.lod.a(false, VideoPbFragment.this.ktH.dmc());
            }
            VideoPbFragment.this.ktH.uP(true);
            return true;
        }
    };
    private final CustomMessageListener loA = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dgX() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lod != null) {
                    VideoPbFragment.this.uH(VideoPbFragment.this.lod.bxM());
                }
                VideoPbFragment.this.dkK();
                VideoPbFragment.this.lGn.dly();
            }
        }
    };
    private CustomMessageListener loD = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener iCT = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.byS) {
                VideoPbFragment.this.diy();
            }
        }
    };
    private CustomMessageListener loX = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dhX();
            }
        }
    };
    private CustomMessageListener loP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.lGn != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lGn.lom) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.lGn.ceD();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.lGn.getExtra();
                DataRes dataRes = aVar.nfE;
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
                    VideoPbFragment.this.lGn.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.lGn.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener loN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.lGn != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lGn.lom) {
                VideoPbFragment.this.lGn.ceD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dgX().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dfY().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lol.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.lGn.DF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.lGn.diu();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lol.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener loO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.lGn != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.lGn.lom) {
                VideoPbFragment.this.lGn.ceD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lol.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lol.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b loj = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bxC() {
            if (VideoPbFragment.this.ktH == null || VideoPbFragment.this.ktH.dma() == null || !VideoPbFragment.this.ktH.dma().dQt()) {
                return !VideoPbFragment.this.FC(am.eHy);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.ktH.dma().dQv());
            if (VideoPbFragment.this.lwv != null && VideoPbFragment.this.lwv.dhH() != null && VideoPbFragment.this.lwv.dhH().bxU()) {
                VideoPbFragment.this.lwv.dhH().a(VideoPbFragment.this.ktH.dmc());
            }
            VideoPbFragment.this.ktH.uQ(true);
            return true;
        }
    };
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                    aqVar.dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId());
                }
                aqVar.dR("tid", VideoPbFragment.this.dgX().diV());
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cwj();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dgX() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dgX().Pr(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doB() != null) {
                        VideoPbFragment.this.los = VideoPbFragment.this.doB().dlj();
                        VideoPbFragment.this.lGp = VideoPbFragment.this.doB().dpn();
                        VideoPbFragment.this.dgX().cZ(VideoPbFragment.this.los, VideoPbFragment.this.lGp);
                    } else if (VideoPbFragment.this.doz() != null) {
                        VideoPbFragment.this.los = VideoPbFragment.this.doz().dlj();
                        VideoPbFragment.this.lGp = VideoPbFragment.this.doz().dpn();
                        VideoPbFragment.this.dgX().cZ(VideoPbFragment.this.los, VideoPbFragment.this.lGp);
                    }
                }
                if (VideoPbFragment.this.eFw != null) {
                    if (com.baidu.tbadk.a.d.bfx()) {
                        VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFT);
                    } else {
                        VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFS);
                    }
                }
                VideoPbFragment.this.lGn.dly();
                VideoPbFragment.this.ktH.dlY();
                if (VideoPbFragment.this.lod != null) {
                    VideoPbFragment.this.uH(VideoPbFragment.this.lod.bxM());
                }
                VideoPbFragment.this.dkG();
                VideoPbFragment.this.uJ(true);
                VideoPbFragment.this.dgX().djq();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doB() != null) {
                                VideoPbFragment.this.doB().dpk();
                            } else if (VideoPbFragment.this.doz() != null) {
                                VideoPbFragment.this.doz().dpk();
                            }
                        }
                    } else if (VideoPbFragment.this.dgX().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dgX().getPbData();
                        if (pbData != null && pbData.dfI() != null && pbData.dfI().bka() != null && (userId = pbData.dfI().bka().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dgX().djh()) {
                            VideoPbFragment.this.dlf();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dgX().djh()) {
                        VideoPbFragment.this.dlf();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.tZ(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lod.bxT() || VideoPbFragment.this.lod.bxU()) {
                    VideoPbFragment.this.lod.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.ktH.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kpC != null) {
                    VideoPbFragment.this.kpC.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Ba(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ba(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bmC();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fkG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fjU);
        }
    };
    private CustomMessageListener loC = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lod != null) {
                    VideoPbFragment.this.uH(VideoPbFragment.this.lod.bxM());
                }
                VideoPbFragment.this.uJ(false);
            }
        }
    };
    private int lGq = 0;
    private boolean lGu = true;
    private View.OnTouchListener lGv = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.lGq == 1) {
                if (!VideoPbFragment.this.lGu) {
                    VideoPbFragment.this.doE();
                    UtilHelper.showStatusBar(VideoPbFragment.this.diC(), VideoPbFragment.this.diC().getRootView());
                    VideoPbFragment.this.lGu = true;
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(VideoPbFragment.this.lGw);
                    com.baidu.adp.lib.f.e.mY().postDelayed(VideoPbFragment.this.lGw, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.lGq == 2 && (VideoPbFragment.this.lGu || VideoPbFragment.this.doG())) {
                VideoPbFragment.this.doF();
                UtilHelper.hideStatusBar(VideoPbFragment.this.diC(), VideoPbFragment.this.diC().getRootView());
                VideoPbFragment.this.lGu = false;
                if (VideoPbFragment.this.lGa != null) {
                    VideoPbFragment.this.lGa.vl(false);
                }
            }
            VideoPbFragment.this.lGq = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener iNt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.lGq = 0;
            VideoPbFragment.this.lGr = 0.0f;
            VideoPbFragment.this.lGs = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.lGr += f;
            VideoPbFragment.this.lGs += f2;
            if (VideoPbFragment.this.lGq == 0 && !VideoPbFragment.this.lGt && VideoPbFragment.this.lGa != null && !VideoPbFragment.this.lGa.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.lGs) <= Math.abs(VideoPbFragment.this.lGr) || VideoPbFragment.this.lGs > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.lGs) > Math.abs(VideoPbFragment.this.lGr) && VideoPbFragment.this.lGs > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.lGq = 2;
                    }
                } else {
                    VideoPbFragment.this.lGq = 1;
                }
            }
            return true;
        }
    };
    private Runnable lGw = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.lGu && !VideoPbFragment.this.doG()) {
                VideoPbFragment.this.doF();
                UtilHelper.hideStatusBar(VideoPbFragment.this.diC(), VideoPbFragment.this.diC().getRootView());
                VideoPbFragment.this.lGu = false;
            }
        }
    };
    private final com.baidu.adp.base.d hTa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dgX() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.hST.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.hST.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dgX().djq();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lDo != 1002 || bVar.gKL) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.QP, dVar.mTG, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.hST.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.hST.getLoadDataMode(), gVar.QP, gVar.mTG, false);
                    VideoPbFragment.this.lGn.bc(gVar.mTJ);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener ftj = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.iGn.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d loU = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                    aqVar.dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dgX() != null) {
                    aqVar.dR("tid", VideoPbFragment.this.dgX().diV());
                }
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.ktH != null) {
                    VideoPbFragment.this.ktH.dlX();
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
                if (VideoPbFragment.this.kpC != null) {
                    VideoPbFragment.this.kpC.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Ba(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ba(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bmC();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.ktH != null) {
                if (VideoPbFragment.this.lwv != null && VideoPbFragment.this.lwv.dhH() != null && VideoPbFragment.this.lwv.dhH().bxU()) {
                    VideoPbFragment.this.lwv.dhH().a(postWriteCallBackData);
                }
                VideoPbFragment.this.ktH.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fjX = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bxD() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aFf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
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
                    aqVar.dR("tid", VideoPbFragment.this.dgX().diV());
                    aqVar.dR("fid", VideoPbFragment.this.dgX().getForumId());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.aj("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.lnw) {
                        VideoPbFragment.this.lnw = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.lnf != null && postData.bka() != null && postData.dHx() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.lwv != null) {
                                    VideoPbFragment.this.lwv.dhD();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.dgX().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.dgX().getPbData().dfI());
                                pVar.g(postData);
                                VideoPbFragment.this.lnf.d(pVar);
                                VideoPbFragment.this.lnf.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bka().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dgX().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lod != null) {
                                    VideoPbFragment.this.uH(VideoPbFragment.this.lod.bxM());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.doz() != null && VideoPbFragment.this.doz().dlu() != null && view == VideoPbFragment.this.doz().dlu()) || ((com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doB() != null && VideoPbFragment.this.doB().dlu() != null && view == VideoPbFragment.this.doB().dlu()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dgX().um(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bfx()) {
                            VideoPbFragment.this.doB().dlg();
                        } else {
                            VideoPbFragment.this.doz().dlg();
                        }
                    }
                } else if (VideoPbFragment.this.lGn != null && VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkf()) {
                    VideoPbFragment.this.lGn.aXc();
                } else if ((VideoPbFragment.this.lGn != null && ((VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkg()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.lGn.dly();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cwj();
                        VideoPbFragment.this.dlf();
                        if (view.getId() == R.id.owner_reply) {
                            B = VideoPbFragment.this.dgX().B(true, VideoPbFragment.this.dik());
                        } else {
                            B = view.getId() == R.id.all_reply ? VideoPbFragment.this.dgX().B(false, VideoPbFragment.this.dik()) : VideoPbFragment.this.dgX().Po(VideoPbFragment.this.dik());
                        }
                        view.setTag(Boolean.valueOf(B));
                        if (B) {
                            VideoPbFragment.this.cQT();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.frR) {
                    if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId());
                            aqVar2.dR("tid", VideoPbFragment.this.dgX().diV());
                            aqVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lnl, VideoPbFragment.this.frR);
                        VideoPbFragment.this.lnl.finish();
                    }
                } else if (view == VideoPbFragment.this.lBs && VideoPbFragment.this.lGn != null) {
                    if (VideoPbFragment.this.dgX() == null || VideoPbFragment.this.dgX().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> dfK = VideoPbFragment.this.dgX().getPbData().dfK();
                    if ((dfK == null || dfK.size() <= 0) && VideoPbFragment.this.dgX().diX()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dR("tid", VideoPbFragment.this.dgX().diV()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", VideoPbFragment.this.dgX().getForumId()));
                    VideoPbFragment.this.lGn.dhY();
                } else if (VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkk()) {
                    if (VideoPbFragment.this.dgX() != null) {
                        VideoPbFragment.this.lGn.dly();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cwj();
                            VideoPbFragment.this.dlf();
                            VideoPbFragment.this.dgX().FI(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.lGn != null && VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkg()) {
                    VideoPbFragment.this.lGn.aXc();
                } else if (VideoPbFragment.this.lGn != null && ((VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkn()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.lGn.dly();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cwj();
                            VideoPbFragment.this.dlf();
                            VideoPbFragment.this.lGn.dq(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dgX().djo()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.lGn != null && VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dke()) {
                    if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().dfI() != null) {
                        VideoPbFragment.this.lGn.aXc();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.lGn.Pj(VideoPbFragment.this.dgX().getPbData().dfI().bkr());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.lGn != null) {
                        VideoPbFragment.this.lGn.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.lGn != null && VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dko()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.C(true, false);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 0).aj("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 1).aj("obj_source", 1));
                    }
                    VideoPbFragment.this.lGn.dmE();
                } else if (VideoPbFragment.this.lGn != null && (view == VideoPbFragment.this.lGn.dld() || (VideoPbFragment.this.lGn.dmF() != null && (view == VideoPbFragment.this.lGn.dmF().dkj() || view == VideoPbFragment.this.lGn.dmF().dkh())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.dgX() != null || VideoPbFragment.this.dgX().getPbData() != null) {
                        if ((VideoPbFragment.this.dgX().getPbData().dfX() == 1 || VideoPbFragment.this.dgX().getPbData().dfX() == 3) && !VideoPbFragment.this.hST.dIi()) {
                            VideoPbFragment.this.lGn.dly();
                            if (VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkh()) {
                                if (VideoPbFragment.this.dgX().getPbData().dfI().bjV() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkj()) {
                                if (VideoPbFragment.this.dgX().getPbData().dfI().bjW() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.lGn.dld() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.dgX().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.dgX().getPbData().dfI().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.hST.b(id, name, id2, i2, VideoPbFragment.this.lGn.dle());
                        }
                    }
                } else if (VideoPbFragment.this.lGn != null && VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkm()) {
                    if (VideoPbFragment.this.dgX() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.lGn.dly();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.dgX().getPbData(), VideoPbFragment.this.dgX().diX(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dgX().getPbData().getForum().getId(), VideoPbFragment.this.dgX().getPbData().getForum().getName(), VideoPbFragment.this.dgX().getPbData().dfI().getId(), String.valueOf(VideoPbFragment.this.dgX().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.lGn != null && VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dki()) {
                    if (VideoPbFragment.this.dgX() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dgX().getPbData(), VideoPbFragment.this.dgX().diX(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.lGn.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.lGn.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.lGn.aXc();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dR("tid", VideoPbFragment.this.dgX().diV());
                        aqVar3.dR("fid", VideoPbFragment.this.dgX().getForumId());
                        aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.aj("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").aj("obj_locate", 3).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                        if (VideoPbFragment.this.lGn != null) {
                            VideoPbFragment.this.lGn.dly();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dHJ() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.mRJ != null) {
                                aq boJ = postData2.mRJ.boJ();
                                boJ.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    boJ.aj("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    boJ.aj("obj_locate", 8);
                                }
                                TiebaStatic.log(boJ);
                            }
                            VideoPbFragment.this.cwj();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dgX() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dR("tid", VideoPbFragment.this.dgX().diV());
                            aqVar4.dR("fid", VideoPbFragment.this.dgX().getForumId());
                            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.aj("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.mRJ != null) {
                                    aq boJ2 = postData4.mRJ.boJ();
                                    boJ2.delete("obj_locate");
                                    boJ2.aj("obj_locate", 8);
                                    TiebaStatic.log(boJ2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dR("tid", VideoPbFragment.this.dgX().diW()).dR("fid", VideoPbFragment.this.dgX().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).aj("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.lnf != null && postData4.bka() != null && postData4.dHx() != 1) {
                                    if (VideoPbFragment.this.lwv != null) {
                                        VideoPbFragment.this.lwv.dhD();
                                    }
                                    if ((VideoPbFragment.this.llm || com.baidu.tbadk.a.d.bfl()) && postData4.dHu() != null && postData4.dHu().size() != 0) {
                                        if (com.baidu.tbadk.a.d.bfm()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.dgX().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.dgX().getPbData().dfI());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.lnf.d(pVar2);
                                    VideoPbFragment.this.lnf.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bka().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lod != null) {
                                        VideoPbFragment.this.uH(VideoPbFragment.this.lod.bxM());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.lGn != null && VideoPbFragment.this.dgX() != null) {
                        if (com.baidu.tbadk.a.d.bfx() || VideoPbFragment.this.doz() != null) {
                            if (!com.baidu.tbadk.a.d.bfx() || VideoPbFragment.this.doB() != null) {
                                VideoPbFragment.this.lGn.dly();
                                if (VideoPbFragment.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dgX() != null) {
                                    VideoPbFragment.this.dif();
                                    if (VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().dfI() != null && VideoPbFragment.this.dgX().getPbData().dfI().bka() != null) {
                                        TiebaStatic.log(new aq("c13402").dR("tid", VideoPbFragment.this.dgX().diV()).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()).aj("obj_locate", 3).dR("uid", VideoPbFragment.this.dgX().getPbData().dfI().bka().getUserId()));
                                    }
                                    if (VideoPbFragment.this.dgX().getPbData().dfI() != null && VideoPbFragment.this.dgX().getPbData().dfI().bka() != null && VideoPbFragment.this.dgX().getPbData().dfI().bka().getUserId() != null && VideoPbFragment.this.lnO != null) {
                                        int h = VideoPbFragment.this.lGn.h(VideoPbFragment.this.dgX().getPbData());
                                        bw dfI = VideoPbFragment.this.dgX().getPbData().dfI();
                                        if (!dfI.biI()) {
                                            if (dfI.biJ()) {
                                                i = 3;
                                            } else if (dfI.blV()) {
                                                i = 4;
                                            } else {
                                                i = dfI.blW() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dR("tid", VideoPbFragment.this.dgX().diV()).aj("obj_locate", 1).dR("obj_id", VideoPbFragment.this.dgX().getPbData().dfI().bka().getUserId()).aj("obj_type", VideoPbFragment.this.lnO.bfV() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.vj(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.lGn != null && VideoPbFragment.this.eFw != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().dfI() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dgX().getPbData();
                        if (pbData.dfI().bjR() != 0) {
                            int currentItem = VideoPbFragment.this.eFw.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bfx() && currentItem == VideoPbFragment.lFR) {
                                VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFS);
                            } else if (com.baidu.tbadk.a.d.bfx() || currentItem == VideoPbFragment.lFS) {
                                if (!com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doz() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bfx() || VideoPbFragment.this.doB() != null) && VideoPbFragment.this.czc() != null) {
                                    aq dR = new aq("c13403").dR("tid", VideoPbFragment.this.dgX().diV()).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView czc = VideoPbFragment.this.czc();
                                    if (czc != null) {
                                        boolean canScrollVertically = czc.canScrollVertically(1);
                                        boolean canScrollVertically2 = czc.canScrollVertically(-1);
                                        if (VideoPbFragment.this.Yh != null) {
                                            VideoPbFragment.this.Yh.setExpanded(false, true);
                                        }
                                        if (czc.getLayoutManager() != null && (czc.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) czc.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lnH != -1 || VideoPbFragment.this.lnI != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lnH > 3 || (VideoPbFragment.this.lnH == 3 && VideoPbFragment.this.lnI < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lnH, VideoPbFragment.this.lnI + equipmentHeight);
                                                        czc.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lnH >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lnH, VideoPbFragment.this.lnI + (equipmentHeight / 2));
                                                        czc.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lnH == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lnH, VideoPbFragment.this.lnI + (equipmentHeight / 4));
                                                        czc.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        czc.smoothScrollBy(0, -VideoPbFragment.this.lnI);
                                                    }
                                                    dR.aj("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = czc.getFirstVisiblePosition();
                                                View childAt = czc.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lnH = firstVisiblePosition;
                                                VideoPbFragment.this.lnI = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && czc.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    czc.smoothScrollToPosition(0);
                                                } else {
                                                    czc.smoothScrollToPosition(0);
                                                }
                                                dR.aj("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dR);
                                            TiebaStatic.log(new aq("c12942").aj("obj_type", 1).aj("obj_locate", 4).dR("tid", VideoPbFragment.this.dgX().diV()).dR("nid", pbData.dfI().getNid()));
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
                            if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().dfI() != null && VideoPbFragment.this.dgX().getPbData().dfI().bka() != null) {
                                TiebaStatic.log(new aq("c13402").dR("tid", VideoPbFragment.this.dgX().diV()).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()).aj("obj_locate", 2).dR("uid", VideoPbFragment.this.dgX().getPbData().dfI().bka().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.vk(false);
                        VideoPbFragment.this.dhT();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.los >= 0) {
                        if (VideoPbFragment.this.dgX() != null) {
                            VideoPbFragment.this.dgX().djG();
                        }
                        if (com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doB() != null && VideoPbFragment.this.doB().dpi() != null) {
                            VideoPbFragment.this.doB().dpi().setData(VideoPbFragment.this.dgX().getPbData());
                        } else if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.doz() != null && VideoPbFragment.this.doz().dpi() != null) {
                            VideoPbFragment.this.doz().dpi().setData(VideoPbFragment.this.dgX().getPbData());
                        }
                        VideoPbFragment.this.los = 0;
                        VideoPbFragment.this.lGp = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.dgX() != null && VideoPbFragment.this.doB() != null) {
                            VideoPbFragment.this.doB().dc(VideoPbFragment.this.dgX().djJ(), VideoPbFragment.this.dgX().djK());
                            VideoPbFragment.this.dgX().cZ(0, 0);
                        } else if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.doz() != null) {
                            VideoPbFragment.this.doz().dc(VideoPbFragment.this.dgX().djJ(), VideoPbFragment.this.dgX().djK());
                            VideoPbFragment.this.dgX().cZ(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dgX() != null) {
                        aq aqVar5 = new aq("c13398");
                        aqVar5.dR("tid", VideoPbFragment.this.dgX().diV());
                        aqVar5.dR("fid", VideoPbFragment.this.dgX().getForumId());
                        aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar5.aj("obj_locate", 2);
                        TiebaStatic.log(aqVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bnH().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dkK();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dkK();
                } else if (VideoPbFragment.this.lGn.dmF() != null && view == VideoPbFragment.this.lGn.dmF().dkl()) {
                    VideoPbFragment.this.lGn.dly();
                    if (VideoPbFragment.this.dgX() != null) {
                        VideoPbFragment.this.hSV.setThreadId(VideoPbFragment.this.dgX().diV());
                    }
                    if (VideoPbFragment.this.dgX() == null || !VideoPbFragment.this.dgX().isPrivacy()) {
                        VideoPbFragment.this.hSV.clm();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().getThreadId() != null && VideoPbFragment.this.dgX().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                            VideoPbFragment.this.hSV.l(3, i3, VideoPbFragment.this.dgX().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dgX().getPbData() != null) {
                        VideoPbFragment.this.hSV.l(3, 3, VideoPbFragment.this.dgX().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener lkE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.lGn != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.lGn.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.lGn.dk(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.lGn.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.lGn.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jQR = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public SortSwitchButton.a loS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zj(int i) {
            if (VideoPbFragment.this.lGn != null) {
                VideoPbFragment.this.lGn.dly();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dgX() == null || VideoPbFragment.this.dgX().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cwj();
                VideoPbFragment.this.dlf();
                if (VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().lgX != null && VideoPbFragment.this.dgX().getPbData().lgX.size() > i) {
                    int intValue = VideoPbFragment.this.dgX().getPbData().lgX.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dR("tid", VideoPbFragment.this.dgX().diW()).dR("fid", VideoPbFragment.this.dgX().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).aj("obj_type", FG(intValue)));
                    if (VideoPbFragment.this.dgX().FN(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int FG(int i) {
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
    private a lGo = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void did() {
        if (dgX() != null && dgX().getPbData() != null && dgX().getPbData().dfI() != null) {
            bw dfI = dgX().getPbData().dfI();
            dfI.mRecomAbTag = dgX().djQ();
            dfI.mRecomWeight = dgX().djO();
            dfI.mRecomSource = dgX().djP();
            dfI.mRecomExtra = dgX().djR();
            if (dfI.getFid() == 0) {
                dfI.setFid(com.baidu.adp.lib.f.b.toLong(dgX().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dfI, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(boolean z) {
        if (dgX() != null && dgX().getPbData() != null && dgX().getPbData().dfI() != null) {
            bw dfI = dgX().getPbData().dfI();
            dfI.mRecomAbTag = dgX().djQ();
            dfI.mRecomWeight = dgX().djO();
            dfI.mRecomSource = dgX().djP();
            dfI.mRecomExtra = dgX().djR();
            if (dfI.getFid() == 0) {
                dfI.setFid(com.baidu.adp.lib.f.b.toLong(dgX().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dfI, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (a2 != null && eu != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.aj("reply_type", 1);
                if (z) {
                    a2.aj("obj_type", 2);
                } else {
                    a2.aj("obj_type", 1);
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
            String string = !TextUtils.isEmpty(bVar.mTG) ? bVar.mTG : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Ba(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.iM(true);
                aVar.b(getPageContext());
                aVar.bmC();
            } else {
                a(0, bVar.QP, bVar.mTG, z);
            }
            if (bVar.QP) {
                if (bVar.iij == 1) {
                    ArrayList<PostData> dfK = dgX().getPbData().dfK();
                    int size = dfK.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dfK.get(i).getId())) {
                            i++;
                        } else {
                            dfK.remove(i);
                            break;
                        }
                    }
                    dgX().getPbData().dfI().nZ(dgX().getPbData().dfI().bjR() - 1);
                    if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
                        doB().dpk();
                    } else if (doz() != null) {
                        doz().dpk();
                    }
                } else if (bVar.iij == 0) {
                    die();
                } else if (bVar.iij == 2) {
                    ArrayList<PostData> dfK2 = dgX().getPbData().dfK();
                    int size2 = dfK2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dfK2.get(i2).dHu().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dfK2.get(i2).dHu().get(i3).getId())) {
                                i3++;
                            } else {
                                dfK2.get(i2).dHu().remove(i3);
                                dfK2.get(i2).dHw();
                                z2 = true;
                                break;
                            }
                        }
                        dfK2.get(i2).SA(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
                            doB().dpk();
                        } else if (doz() != null) {
                            doz().dpk();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dgX().getPbData().dfW().liC;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dHu().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dHu().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dHu().remove(i2);
                    list.get(i).dHw();
                    z = true;
                    break;
                }
            }
            list.get(i).SA(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
                doB().dpk();
            } else if (doz() != null) {
                doz().dpk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && dgX() != null && dgX().getPbData() != null && dgX().getPbData().dfI() != null) {
            a(this.hST.getLoadDataMode(), gVar.QP, gVar.mTG, false);
            if (gVar.QP) {
                this.lnR = true;
                if (i == 2 || i == 3) {
                    this.lnS = true;
                    this.lnT = false;
                } else if (i == 4 || i == 5) {
                    this.lnS = false;
                    this.lnT = true;
                }
                if (i == 2) {
                    dgX().getPbData().dfI().oc(1);
                    dgX().setIsGood(1);
                } else if (i == 3) {
                    dgX().getPbData().dfI().oc(0);
                    dgX().setIsGood(0);
                } else if (i == 4) {
                    dgX().getPbData().dfI().ob(1);
                    dgX().FH(1);
                } else if (i == 5) {
                    dgX().getPbData().dfI().ob(0);
                    dgX().FH(0);
                }
            }
            if (dgX().getPbData().dfI() != null && doA() != null) {
                doA().dpu();
            }
        }
    }

    private void die() {
        if (dgX().diY() || dgX().dja()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dgX().diV());
            PbActivity pbActivity = this.lnl;
            PbActivity pbActivity2 = this.lnl;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dgX().diV()));
        if (dih()) {
            this.lnl.finish();
        }
    }

    private boolean dih() {
        if (dgX() == null) {
            return true;
        }
        if (dgX().getPbData() == null || !dgX().getPbData().dgl()) {
            if (dgX().bfV()) {
                final MarkData djp = dgX().djp();
                if (djp == null || !dgX().getIsFromMark() || czc() == null) {
                    return true;
                }
                final MarkData FO = dgX().FO(czc().getFirstVisiblePosition());
                if (FO == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", djp);
                    this.lnl.setResult(-1, intent);
                    return true;
                } else if (FO.getPostId() == null || FO.getPostId().equals(djp.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", djp);
                    this.lnl.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.Ba(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lnO != null) {
                                if (VideoPbFragment.this.lnO.bfV()) {
                                    VideoPbFragment.this.lnO.bfW();
                                    VideoPbFragment.this.lnO.ih(false);
                                }
                                VideoPbFragment.this.lnO.a(FO);
                                VideoPbFragment.this.lnO.ih(true);
                                VideoPbFragment.this.lnO.bfX();
                            }
                            djp.setPostId(FO.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", djp);
                            VideoPbFragment.this.lnl.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dhk();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", djp);
                            VideoPbFragment.this.lnl.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dhk();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bmC();
                    return false;
                }
            } else if (dgX().getPbData() == null || dgX().getPbData().dfK() == null || dgX().getPbData().dfK().size() <= 0 || !dgX().getIsFromMark()) {
                return true;
            } else {
                this.lnl.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhk() {
        this.lnl.dhk();
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
    public void vj(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dgX() != null && this.lGn != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dgX().getPbData()) != null) {
                bw dfI = pbData.dfI();
                if (dfI != null && dfI.bka() != null) {
                    TiebaStatic.log(new aq("c13402").dR("tid", dgX().diV()).dR("fid", pbData.getForumId()).aj("obj_locate", 4).dR("uid", dfI.bka().getUserId()));
                }
                if (dfI != null) {
                    if (dfI.biI()) {
                        i = 2;
                    } else if (dfI.biJ()) {
                        i = 3;
                    } else if (dfI.blV()) {
                        i = 4;
                    } else if (dfI.blW()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dR("tid", dgX().diV());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dR("fid", dgX().getForumId());
                    if (!z) {
                        aqVar.aj("obj_locate", 6);
                    } else {
                        aqVar.aj("obj_locate", 5);
                    }
                    aqVar.aj("obj_name", i);
                    aqVar.aj("obj_type", 2);
                    if (dfI != null) {
                        if (dfI.biI()) {
                            aqVar.aj("obj_type", 10);
                        } else if (dfI.biJ()) {
                            aqVar.aj("obj_type", 9);
                        } else if (dfI.blW()) {
                            aqVar.aj("obj_type", 8);
                        } else if (dfI.blV()) {
                            aqVar.aj("obj_type", 7);
                        } else if (dfI.isShareThread) {
                            aqVar.aj("obj_type", 6);
                        } else if (dfI.threadType == 0) {
                            aqVar.aj("obj_type", 1);
                        } else if (dfI.threadType == 40) {
                            aqVar.aj("obj_type", 2);
                        } else if (dfI.threadType == 49) {
                            aqVar.aj("obj_type", 3);
                        } else if (dfI.threadType == 54) {
                            aqVar.aj("obj_type", 4);
                        } else {
                            aqVar.aj("obj_type", 5);
                        }
                        aqVar.dR("nid", dfI.getNid());
                        aqVar.aj(IntentConfig.CARD_TYPE, dfI.blZ());
                        aqVar.dR(IntentConfig.RECOM_SOURCE, dfI.mRecomSource);
                        aqVar.dR("ab_tag", dfI.mRecomAbTag);
                        aqVar.dR("weight", dfI.mRecomWeight);
                        aqVar.dR("extra", dfI.mRecomExtra);
                        aqVar.dR("nid", dfI.getNid());
                        if (dfI.getBaijiahaoData() != null && !at.isEmpty(dfI.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dR("obj_param6", dfI.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (diC() != null) {
                        com.baidu.tbadk.pageInfo.c.b(diC(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dgX().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dfK = pbData.dfK();
                        if ((dfK == null || dfK.size() <= 0) && dgX().diX()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.lGn.dly();
                        cwj();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), dfI)) {
                            if (this.lvT != null) {
                                this.lvT.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                FE(z ? 2 : 1);
                                return;
                            }
                            this.lGn.showLoadingDialog();
                            dgX().djA().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dR("tid", dgX().diV());
                aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dR("fid", dgX().getForumId());
                if (!z) {
                }
                aqVar2.aj("obj_name", i);
                aqVar2.aj("obj_type", 2);
                if (dfI != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (diC() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dog() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.doM());
        K(eVar.doM());
        if (dgX() != null && dgX().getPbData() != null) {
            boolean isFromMark = dgX().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dgX().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.bfU() != null && !pbData.bfU().equals(I.getId()) && this.eFw != null) {
                    if (com.baidu.tbadk.a.d.bfx()) {
                        this.eFw.setCurrentItem(lFT);
                    } else {
                        this.eFw.setCurrentItem(lFS);
                    }
                }
            }
        }
        eVar.doN().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                BdTypeRecyclerView czc;
                if (bwVar != null && bwVar.bks() != null) {
                    if (VideoPbFragment.this.lGa.getVideoUrl() == null || !VideoPbFragment.this.lGa.getVideoUrl().equals(bwVar.bks().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.lGa.getVideoUrl())) {
                            VideoPbFragment.this.lny = true;
                            if (com.baidu.tbadk.a.d.bfx()) {
                                VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFT);
                            } else {
                                VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFR);
                            }
                            if (com.baidu.tbadk.a.d.bfx() && (czc = VideoPbFragment.this.czc()) != null) {
                                czc.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.lGb == null || !VideoPbFragment.this.lGb.isPlaying()) {
                            VideoPbFragment.this.doh();
                            VideoPbFragment.this.aN(bwVar);
                        }
                        VideoPbFragment.this.doi();
                        if (VideoPbFragment.this.lGb.dpa()) {
                            VideoPbFragment.this.lGb.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.lGa.getVideoUrl(), bwVar.bks().video_url);
                        VideoPbFragment.this.lGa.setData(bwVar);
                        if (com.baidu.tbadk.a.d.bfx()) {
                            VideoPbFragment.this.lGa.vs(false);
                        } else {
                            VideoPbFragment.this.lGa.vs(VideoPbFragment.this.eFw.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.lGa.startPlay();
                            VideoPbFragment.this.lGa.dpM();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.lGa.setData(bwVar);
                }
            }
        });
        eVar.doW().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: s */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.eFw.setCurrentItem(num.intValue());
            }
        });
        eVar.doR().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.lGa.aS(bwVar);
            }
        });
        eVar.doS().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.lGa.aT(bwVar);
            }
        });
        eVar.doT().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dos();
            }
        });
        eVar.doU().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doh() {
        ViewGroup.LayoutParams layoutParams = this.lGd.getLayoutParams();
        layoutParams.height = 0;
        this.lGd.setLayoutParams(layoutParams);
        this.lGd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doi() {
        if (this.lGb == null) {
            this.lGb = new f(getBaseFragmentActivity(), this.lFZ);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(diC()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.lFZ.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.lGb.b(eVar.doO(), rect);
            if (this.lGb.dpa()) {
                this.lGb.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bfx()) {
                            if (eVar.doP() || VideoPbFragment.this.dgX().getTabIndex() == VideoPbFragment.lFT) {
                                VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFT);
                            }
                        } else if (eVar.doP() || VideoPbFragment.this.dgX().getTabIndex() == VideoPbFragment.lFS) {
                            VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFS);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bfx()) {
                            if (eVar.doP() || VideoPbFragment.this.dgX().getTabIndex() == VideoPbFragment.lFT) {
                                VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFT);
                            }
                        } else if (eVar.doP() || VideoPbFragment.this.dgX().getTabIndex() == VideoPbFragment.lFS) {
                            VideoPbFragment.this.eFw.setCurrentItem(VideoPbFragment.lFS);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bfx()) {
                if (eVar.doP() || dgX().getTabIndex() == lFT) {
                    this.eFw.setCurrentItem(lFT);
                }
            } else if (eVar.doP() || dgX().getTabIndex() == lFS) {
                this.eFw.setCurrentItem(lFS);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.lGt && (this.lGu || doG())) {
            doF();
            UtilHelper.hideStatusBar(diC(), diC().getRootView());
            this.lGu = false;
            if (this.lGa != null) {
                this.lGa.vl(false);
            }
        }
        if (i == 4) {
            return this.lGa.duZ();
        }
        if (i == 24) {
            return this.lGa.dpJ();
        }
        if (i == 25) {
            return this.lGa.dpK();
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
        Rect djS;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bwVar != null && bwVar.bks() != null) {
            int intValue = bwVar.bks().video_width.intValue();
            int intValue2 = bwVar.bks().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dgX() != null || (djS = dgX().djS()) == null) ? ceil : djS.height();
                i = 0;
                layoutParams = this.lFZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.lFZ.setLayoutParams(layoutParams);
                this.lFZ.setMaxHeight(ceil);
                this.lFZ.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.lFZ.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bfx()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lFV.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, lFU);
                    } else {
                        layoutParams3.height = lFU;
                    }
                    this.lFV.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.Yh.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bfx()) {
                    ceil += lFU;
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
        if (dgX() != null) {
        }
        i = 0;
        layoutParams = this.lFZ.getLayoutParams();
        if (layoutParams != null) {
        }
        this.lFZ.setLayoutParams(layoutParams);
        this.lFZ.setMaxHeight(ceil2);
        this.lFZ.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.lFZ.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bfx()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.Yh.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bfx()) {
        }
        if (layoutParams2 != null) {
        }
        this.Yh.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lns = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lol = new com.baidu.tbadk.core.view.c();
        this.lol.toastTime = 1000L;
        if (this.lGn != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.lGn.lom;
            userMuteAddAndDelCustomMessage.setTag(this.lGn.lom);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.lGn.lom;
            userMuteCheckCustomMessage.setTag(this.lGn.lom);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.hSV = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
    }

    private void initData() {
        this.lnO = com.baidu.tbadk.baseEditMark.a.a(this.lnl);
        if (this.lnO != null) {
            this.lnO.a(this.loY);
        }
        this.hST = new ForumManageModel(this.lnl);
        this.hST.setLoadDataCallBack(this.hTa);
        this.eHC = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lGn = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.lob = new g();
        d(this.lob);
        this.lod = (com.baidu.tbadk.editortools.pb.e) this.lob.ei(getActivity());
        this.lod.a(this.lnl.getPageContext());
        this.lod.a(this.fke);
        this.lod.a(this.fjX);
        this.lod.setFrom(1);
        this.lod.a(this.lnl.getPageContext(), bundle);
        this.lod.bwY().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lod.bwY().jS(true);
        tY(true);
        this.lod.a(dgX().djl(), dgX().diV(), dgX().djC());
        registerListener(this.loD);
        registerListener(this.loX);
        registerListener(this.loC);
        registerListener(this.loA);
        registerListener(this.iCT);
        if (!dgX().djc()) {
            this.lod.DA(dgX().diV());
        }
        if (dgX().djD()) {
            this.lod.Dy(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lod.Dy(dkM());
        }
        this.ktH = new bb();
        if (this.lod.bxE() != null) {
            this.ktH.e(this.lod.bxE().getInputView());
        }
        this.lod.a(this.fjY);
        this.kpC = new am(getPageContext());
        this.kpC.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == am.eHx) {
                        VideoPbFragment.this.lod.a((String) null, (WriteData) null);
                    } else if (i == am.eHy && VideoPbFragment.this.lwv != null && VideoPbFragment.this.lwv.dhH() != null) {
                        VideoPbFragment.this.lwv.dhH().byc();
                    } else if (i == am.eHz) {
                        VideoPbFragment.this.c(VideoPbFragment.this.loh);
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
        this.iGn = new com.baidu.tieba.f.b(getActivity());
        this.iGn.a(lpg);
        this.lGt = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bAw();
        this.Yh = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.lFX = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.lFZ = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.lGa = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.lFZ);
        this.lGa.setStageType("2002");
        this.lGa.setUniqueId(getUniqueId());
        this.lGa.af(this);
        this.lGa.dr(diC().getRootView());
        this.lGa.ds(this.lGc);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.lFV = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.lGd = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.eFw = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.lFY = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.lFY.setOnClickListener(this.aFf);
        dok();
        doj();
        dol();
        this.lFW = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.eFw.setAdapter(this.lFW);
        this.lFV.setViewPager(this.eFw);
        this.lFV.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doB() != null) {
                        VideoPbFragment.this.doB().vr(false);
                    } else if (VideoPbFragment.this.doz() != null) {
                        VideoPbFragment.this.doz().vr(false);
                    }
                    if (VideoPbFragment.this.doA() != null) {
                        VideoPbFragment.this.doA().vr(true);
                        VideoPbFragment.this.Gn(VideoPbFragment.this.doA().dpo() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.doT() != null && eVar.doT().getValue() != null && eVar.doT().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.lGa.vs(z);
                    VideoPbFragment.this.dkK();
                    if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dR("tid", VideoPbFragment.this.dgX().diV()).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.doA() != null) {
                        VideoPbFragment.this.doA().vr(false);
                    }
                    if (com.baidu.tbadk.a.d.bfx() && VideoPbFragment.this.doB() != null) {
                        VideoPbFragment.this.doB().vr(true);
                        int dpo = VideoPbFragment.this.doB().dpo();
                        int dpp = VideoPbFragment.this.doB().dpp();
                        if (dpo != 0) {
                            VideoPbFragment.this.Gn(8);
                            VideoPbFragment.this.doB().Gn(0);
                        } else if (dpp != 0) {
                            VideoPbFragment.this.doB().Gn(8);
                            VideoPbFragment.this.Gn(0);
                        } else {
                            VideoPbFragment.this.doB().Gn(8);
                            VideoPbFragment.this.Gn(8);
                        }
                    } else if (VideoPbFragment.this.doz() != null) {
                        VideoPbFragment.this.doz().vr(true);
                        int dpo2 = VideoPbFragment.this.doz().dpo();
                        int dpp2 = VideoPbFragment.this.doz().dpp();
                        if (dpo2 != 0) {
                            VideoPbFragment.this.Gn(8);
                            VideoPbFragment.this.doz().Gn(0);
                        } else if (dpp2 != 0) {
                            VideoPbFragment.this.doz().Gn(8);
                            VideoPbFragment.this.Gn(0);
                        } else {
                            VideoPbFragment.this.doz().Gn(8);
                            VideoPbFragment.this.Gn(8);
                        }
                    }
                    VideoPbFragment.this.lGa.vs(false);
                    VideoPbFragment.this.Yh.setExpanded(false, true);
                    if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dR("tid", VideoPbFragment.this.dgX().diV()).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.lFW.Gp(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.lvv = this.rootView.findViewById(R.id.viewstub_progress);
        dom();
        bRs();
        if (!this.lGt && this.lGu) {
            doF();
            UtilHelper.hideStatusBar(diC(), diC().getRootView());
            this.lGu = false;
        }
        if (com.baidu.tbadk.a.d.bfx()) {
            this.lFV.getLayoutParams().height = 0;
        }
    }

    private void doj() {
        this.lGf = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.lGj = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.lGg = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.lGh = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.lGi = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.lGk = this.rootView.findViewById(R.id.ala_live_point);
        this.lGj.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.lGj.setConrers(15);
        this.lGi.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.lGh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lhH == null || VideoPbFragment.this.lhH.dpA()) {
                    if (VideoPbFragment.this.lhH != null) {
                        TiebaStatic.log(new aq("c13608").dR("tid", VideoPbFragment.this.dgX().getPbData().getThreadId()));
                        VideoPbFragment.this.lhH.lIq = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.dou();
            }
        });
        this.lGi.setOnClickListener(this.lGe);
        this.lGd.setOnClickListener(this.lGe);
    }

    private void dok() {
        this.lFV.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.lFV.setContainerLayoutParams(layoutParams);
        this.lFV.setRectPaintColor(R.color.cp_link_tip_a);
        this.lFV.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.lFV.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.lFV.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.lFV.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.lFV.setExpandedTabLayoutParams(layoutParams2);
    }

    public void vk(boolean z) {
        if (this.Yh != null) {
            this.Yh.setExpanded(z);
        }
    }

    private void dol() {
        this.lvM = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.lvN = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.lvX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lvY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lvP = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lvP.setVisibility(0);
        this.lvP.setIsRound(true);
        this.lvP.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.lvP.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.lvP.setPlaceHolder(1);
        this.lvP.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lvP.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jEf = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lvO = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lvO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.vk(false);
                VideoPbFragment.this.dhT();
                if (VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().dfI() != null && VideoPbFragment.this.dgX().getPbData().dfI().bka() != null) {
                    TiebaStatic.log(new aq("c13701").dR("tid", VideoPbFragment.this.dgX().diW()).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dR("tid", VideoPbFragment.this.dgX().diV()).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()).aj("obj_locate", 1).dR("uid", VideoPbFragment.this.dgX().getPbData().dfI().bka().getUserId()));
                }
            }
        });
        this.lvQ = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lvQ.setOnClickListener(this.aFf);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lvR = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.lvR.setOnClickListener(this.aFf);
        if (booleanExtra) {
            this.lvR.setVisibility(8);
        } else {
            this.lvR.setVisibility(0);
        }
        this.lvS = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.lvS.setOnClickListener(this.aFf);
        this.lvT = new com.baidu.tieba.pb.view.c(this.lvS);
        this.lvT.dpV();
        this.lvU = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lvU.setVisibility(0);
        uJ(false);
    }

    private void bAw() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cwk();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.lGc = this.rootView.findViewById(R.id.status_bar_background);
        if (this.lGt) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(diC());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.lGc.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(diC());
            this.lGc.setLayoutParams(layoutParams2);
            this.lGc.setVisibility(0);
        }
        this.frR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aFf);
        this.gzN = (ImageView) this.frR.findViewById(R.id.widget_navi_back_button);
        SvgManager.boN().a(this.gzN, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.lBs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aFf);
        this.agS = (ImageView) this.lBs.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.lBs.setLayoutParams(layoutParams3);
        SvgManager.boN().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.lBs.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.iNt);
        this.mNavigationBar.setOnTouchListener(this.lGv);
    }

    public void dom() {
        setEditorTools(this.lod.bwY());
    }

    private void bRs() {
        this.lnf = new PbFakeFloorModel(getPageContext());
        this.lwv = new v(getPageContext(), this.lnf, this.rootView);
        this.lwv.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dkK();
            }
        });
        this.lwv.a(this.loU);
        this.lnf.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lnf.t(postData);
                if (com.baidu.tbadk.a.d.bfx() || VideoPbFragment.this.doB() != null) {
                    VideoPbFragment.this.doB().dpk();
                } else if (VideoPbFragment.this.doz() != null) {
                    VideoPbFragment.this.doz().dpk();
                }
                VideoPbFragment.this.lwv.dhD();
                VideoPbFragment.this.abk.bvv();
                VideoPbFragment.this.uJ(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a Pm;
        String diV = dgX().diV();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dgX().getPbData() != null) {
            i = dgX().getPbData().dfX();
        }
        if (doz() != null && doz().dpm() != null) {
            Pm = doz().dpm().Pm(id);
        } else if (doB() != null && doB().dpm() != null) {
            Pm = doB().dpm().Pm(id);
        } else {
            return;
        }
        if (postData != null && dgX() != null && dgX().getPbData() != null && Pm != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(diV, id, "pb", true, null, false, str, i, postData.dnF(), dgX().getPbData().getAnti(), false, postData.bka().getIconInfo()).addBigImageData(Pm.ljZ, Pm.erD, Pm.erB, Pm.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dgX().getForumId());
            addBigImageData.setBjhData(dgX().dje());
            addBigImageData.setKeyPageStartFrom(dgX().djF());
            addBigImageData.setFromFrsForumId(dgX().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lnl = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dgX() != null) {
            dgX().aC(bundle);
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
        this.byS = true;
        getVoiceManager().onPause(getPageContext());
        this.lGa.qV(true);
        if (dgX() != null && !dgX().djc()) {
            this.lod.Dz(dgX().diV());
        }
        com.baidu.tbadk.BdToken.c.bdF().bdQ();
        MessageManager.getInstance().unRegisterListener(this.loN);
        MessageManager.getInstance().unRegisterListener(this.loO);
        MessageManager.getInstance().unRegisterListener(this.loP);
        MessageManager.getInstance().unRegisterListener(this.jQR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.byS = false;
        getVoiceManager().onResume(getPageContext());
        this.lGa.qV(false);
        diy();
        registerListener(this.loN);
        registerListener(this.loO);
        registerListener(this.loP);
        registerListener(this.jQR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.lFW != null && this.eFw != null) {
            this.lFW.Gp(z ? this.eFw.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.lvP != null) {
            this.lvP.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.lvT != null) {
            this.lvT.onDestroy();
        }
        if (this.hST != null) {
            this.hST.cancelLoadData();
        }
        if (this.lGa != null) {
            this.lGa.onDestroy();
        }
        if (this.lnD != null) {
            this.lnD.cancelLoadData();
        }
        if (this.kpC != null) {
            this.kpC.onDestroy();
        }
        if (dgX() != null) {
            dgX().cancelLoadData();
            dgX().destory();
            if (dgX().djz() != null) {
                dgX().djz().onDestroy();
            }
        }
        if (this.lod != null) {
            this.lod.onDestroy();
        }
        this.lol = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lnl);
        this.lFV.onChangeSkinType();
        ap.setBackgroundColor(this.lFV, R.color.cp_bg_line_h);
        this.ktH.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.lGb == null || !this.lGb.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        ap.setBackgroundColor(this.lGc, R.color.cp_mask_b_alpha66);
        if (this.abk != null) {
            this.abk.onChangeSkinType(i);
        }
        if (this.lwv != null) {
            this.lwv.onChangeSkinType(i);
        }
        if (this.jEf != null) {
            ap.setViewTextColor(this.jEf, R.color.cp_cont_d);
        }
        if (this.lvP != null) {
            this.lvP.setBorderColor(ap.getColor(R.color.cp_border_a));
        }
        if (this.lvO != null) {
            this.lvO.setBackgroundDrawable(ap.aO(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
        }
        if (this.lvR != null && dgX() != null) {
            if (dgX().bfV()) {
                SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.lvQ != null) {
            SvgManager.boN().a(this.lvQ, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (dgX() != null) {
            x(dgX().getPbData());
        }
        if (this.lvU != null) {
            ap.c(this.lvU, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.lvU, R.color.cp_cont_j);
        }
        if (this.lvV != null) {
            ap.setViewTextColor(this.lvV, R.color.cp_cont_b);
        }
        if (this.lvM != null) {
            ap.setBackgroundResource(this.lvM, R.drawable.bottom_shadow);
        }
        ap.setBackgroundColor(this.lvN, R.color.cp_bg_line_h);
        if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
            doB().onChangeSkinType(i);
        } else if (doz() != null) {
            doz().onChangeSkinType(i);
        }
        if (doA() != null) {
            doA().onChangeSkinType(i);
        }
        if (this.lFX != null) {
            ap.setBackgroundResource(this.lFX, R.drawable.personalize_tab_shadow);
        }
        if (this.lGd != null) {
            ap.setBackgroundColor(this.lGd, R.color.cp_bg_line_g);
        }
        if (this.lGh != null) {
            SvgManager.boN().a(this.lGh, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.lGf != null) {
            ap.setViewTextColor(this.lGf, R.color.cp_cont_b);
        }
        if (this.lGg != null) {
            ap.setViewTextColor(this.lGg, R.color.cp_cont_d);
        }
        if (this.lGk != null) {
            this.lGk.setBackgroundDrawable(ap.aO(l.getDimens(this.lGk.getContext(), R.dimen.tbds32), ap.getColor(R.color.cp_other_c)));
        }
        cwj();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iBr == null) {
            this.iBr = VoiceManager.instance();
        }
        return this.iBr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        if (this.iBr != null) {
            this.iBr.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment diA() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment diB() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dgX() {
        return this.lnl.dgX();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity diC() {
        return this.lnl;
    }

    public com.baidu.tbadk.baseEditMark.a don() {
        return this.lnO;
    }

    public View.OnClickListener doo() {
        return this.aFf;
    }

    public View.OnClickListener dop() {
        return this.lkE;
    }

    public View.OnLongClickListener doq() {
        return this.lGn.doq();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.be.PB(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView czc() {
        Iterator<BaseFragment> it = this.lFW.doK().iterator();
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

    private void tY(boolean z) {
        this.lod.jZ(z);
        this.lod.ka(z);
        this.lod.kb(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.lGn != null) {
            if (z) {
                this.lGn.dly();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.lGn.dlz();
            } else {
                this.lGn.dly();
            }
        }
    }

    public boolean FC(int i) {
        if (this.kpC == null || dgX() == null || dgX().getPbData() == null || dgX().getPbData().getAnti() == null) {
            return true;
        }
        return this.kpC.aN(dgX().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dhV() {
        if ((dgX() != null && dgX().getPbData().dgl()) || this.kpC == null || dgX() == null || dgX().getPbData() == null || dgX().getPbData().getAnti() == null) {
            return true;
        }
        return this.kpC.oJ(dgX().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dgX() != null) {
            gVar.setForumName(dgX().dgP());
            if (dgX().getPbData() != null && dgX().getPbData().getForum() != null) {
                gVar.a(dgX().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dgX());
        }
    }

    public void dla() {
        if (this.abk != null) {
            this.abk.display();
            if (this.lod != null) {
                this.lod.bxJ();
            }
            dlI();
        }
    }

    public com.baidu.tbadk.editortools.pb.e dhI() {
        return this.lod;
    }

    private boolean dhS() {
        PbModel dgX = dgX();
        if (dgX == null || dgX.getPbData() == null) {
            return false;
        }
        bw dfI = dgX.getPbData().dfI();
        dgX.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dfI);
    }

    public void dhT() {
        if (checkUpIsLogin() && dgX() != null && dgX().getPbData() != null && dgX().getPbData().getForum() != null && !dhS()) {
            if (dgX().getPbData().dgl()) {
                cJB();
                return;
            }
            if (this.iFN == null) {
                this.iFN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iFN.zP(0);
                this.iFN.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pz(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pA(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lod != null && VideoPbFragment.this.lod.bwY() != null) {
                                VideoPbFragment.this.lod.bwY().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cJB();
                        }
                    }
                });
            }
            this.iFN.G(dgX().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dgX().diV(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lod.onActivityResult(i, i2, intent);
        if (this.lnD != null) {
            this.lnD.onActivityResult(i, i2, intent);
        }
        if (this.lwv != null) {
            this.lwv.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dif();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dxr().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.loh = emotionImageData;
                        if (FC(am.eHz)) {
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
        if (diC() != null) {
            if (this.lGu && !TbSingleton.getInstance().isNotchScreen(diC()) && !TbSingleton.getInstance().isCutoutScreen(diC())) {
                doF();
                UtilHelper.hideStatusBar(diC(), diC().getRootView());
                this.lGu = false;
            }
            this.lGo.lGJ = z;
            dor();
            dos();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lnl;
        if (i == 0) {
            dkG();
            if (this.lwv != null) {
                this.lwv.dhD();
            }
            uJ(false);
        }
        dkK();
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
                        this.lod.resetData();
                        this.lod.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lod.b(writeData);
                        m ra = this.lod.bwY().ra(6);
                        if (ra != null && ra.fhv != null) {
                            ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lnl;
                        if (i == -1) {
                            this.lod.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lwv != null && this.lwv.dhH() != null) {
                            com.baidu.tbadk.editortools.pb.h dhH = this.lwv.dhH();
                            dhH.setThreadData(dgX().getPbData().dfI());
                            dhH.b(writeData);
                            dhH.setVoiceModel(pbEditorData.getVoiceModel());
                            m ra2 = dhH.bwY().ra(6);
                            if (ra2 != null && ra2.fhv != null) {
                                ra2.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lnl;
                            if (i == -1) {
                                dhH.byc();
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
                if (dgX() != null && !dgX().djc()) {
                    antiData.setBlock_forum_name(dgX().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dgX().getPbData().getForum().getId());
                    antiData.setUser_name(dgX().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dgX().getPbData().getUserData().getUserId());
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
        if (AntiHelper.bN(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.lGn != null) {
                this.lGn.DF(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void diE() {
        if (dgX() != null && this.lnl != null) {
            if (this.lod == null || !this.lod.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lod = (com.baidu.tbadk.editortools.pb.e) dVar.ei(getContext());
                this.lod.a(this.lnl.getPageContext());
                this.lod.a(this.fke);
                this.lod.a(this.fjX);
                this.lod.a(this.lnl.getPageContext(), this.lnl.getIntent() == null ? null : this.lnl.getIntent().getExtras());
                this.lod.bwY().jS(true);
                setEditorTools(this.lod.bwY());
                if (!dgX().djc()) {
                    this.lod.DA(dgX().diV());
                }
                if (dgX().djD()) {
                    this.lod.Dy(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lod.Dy(dkM());
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
                VideoPbFragment.this.dkK();
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
                    if (((u) aVar.data).bsm() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bsm() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lod.c((u) aVar.data);
                            VideoPbFragment.this.lod.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dkG();
        this.lod.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
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
                if (VideoPbFragment.this.ktH != null && VideoPbFragment.this.ktH.dlZ() != null) {
                    if (!VideoPbFragment.this.ktH.dlZ().dQu()) {
                        VideoPbFragment.this.ktH.uP(false);
                    }
                    VideoPbFragment.this.ktH.dlZ().yh(false);
                }
            }
        });
    }

    public void cJB() {
        if (!checkUpIsLogin()) {
            if (dgX() != null) {
                TiebaStatic.log(new aq("c10517").aj("obj_locate", 2).dR("fid", dgX().getForumId()));
            }
        } else if (dhV()) {
            if (this.lod != null && (this.lod.bxT() || this.lod.bxU())) {
                this.lod.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abk != null) {
                dla();
                this.lGo.lGI = false;
                if (this.abk.ra(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.abk.ra(2).fhv, false, null);
                }
            }
            dlI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dhS() && dhV()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lnF);
                this.lnG = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.lwv != null && postData != null) {
                String str3 = "";
                if (postData.dHz() != null) {
                    str3 = postData.dHz().toString();
                }
                this.lwv.Pg(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bka().getName_show(), str3));
            }
            if (dgX() != null && dgX().getPbData() != null && dgX().getPbData().dgl()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lnl.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lnF[1] + VideoPbFragment.this.lnG) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.czc() != null) {
                            VideoPbFragment.this.czc().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lwv != null) {
                            VideoPbFragment.this.lod.bwY().setVisibility(8);
                            VideoPbFragment.this.lwv.h(str, str2, VideoPbFragment.this.dkM(), (VideoPbFragment.this.dgX() == null || VideoPbFragment.this.dgX().getPbData() == null || VideoPbFragment.this.dgX().getPbData().dfI() == null || !VideoPbFragment.this.dgX().getPbData().dfI().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dhH = VideoPbFragment.this.lwv.dhH();
                            if (dhH != null && VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                                dhH.a(VideoPbFragment.this.dgX().getPbData().getAnti());
                                dhH.setThreadData(VideoPbFragment.this.dgX().getPbData().dfI());
                            }
                            if (VideoPbFragment.this.ktH.dmb() == null && VideoPbFragment.this.lwv.dhH().byk() != null) {
                                VideoPbFragment.this.lwv.dhH().byk().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.ktH != null && VideoPbFragment.this.ktH.dma() != null) {
                                            if (!VideoPbFragment.this.ktH.dma().dQu()) {
                                                VideoPbFragment.this.ktH.uQ(false);
                                            }
                                            VideoPbFragment.this.ktH.dma().yh(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.ktH.f(VideoPbFragment.this.lwv.dhH().byk().getInputView());
                                VideoPbFragment.this.lwv.dhH().a(VideoPbFragment.this.loj);
                            }
                        }
                        VideoPbFragment.this.dlI();
                    }
                }, 0L);
                return;
            }
            if (this.lof == null) {
                this.lof = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lof.zP(1);
                this.lof.a(new AnonymousClass48(str, str2));
            }
            if (dgX() != null && dgX().getPbData() != null && dgX().getPbData().getForum() != null) {
                this.lof.G(dgX().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dgX().diV(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$48  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass48 implements c.a {
        final /* synthetic */ String lpq;
        final /* synthetic */ String lpr;

        AnonymousClass48(String str, String str2) {
            this.lpq = str;
            this.lpr = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pz(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pA(boolean z) {
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
                        int i = (VideoPbFragment.this.lnF[1] + VideoPbFragment.this.lnG) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.czc() != null) {
                            VideoPbFragment.this.czc().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.lwv != null) {
                            VideoPbFragment.this.lod.bwY().setVisibility(8);
                            VideoPbFragment.this.lwv.h(AnonymousClass48.this.lpq, AnonymousClass48.this.lpr, VideoPbFragment.this.dkM(), (VideoPbFragment.this.dgX() == null || VideoPbFragment.this.dgX().getPbData() == null || VideoPbFragment.this.dgX().getPbData().dfI() == null || !VideoPbFragment.this.dgX().getPbData().dfI().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dhH = VideoPbFragment.this.lwv.dhH();
                            if (dhH != null && VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null) {
                                dhH.a(VideoPbFragment.this.dgX().getPbData().getAnti());
                                dhH.setThreadData(VideoPbFragment.this.dgX().getPbData().dfI());
                            }
                            if (VideoPbFragment.this.ktH.dmb() == null && VideoPbFragment.this.lwv.dhH().byk() != null) {
                                VideoPbFragment.this.lwv.dhH().byk().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.ktH != null && VideoPbFragment.this.ktH.dma() != null) {
                                            if (!VideoPbFragment.this.ktH.dma().dQu()) {
                                                VideoPbFragment.this.ktH.uQ(false);
                                            }
                                            VideoPbFragment.this.ktH.dma().yh(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.ktH.f(VideoPbFragment.this.lwv.dhH().byk().getInputView());
                                VideoPbFragment.this.lwv.dhH().a(VideoPbFragment.this.loj);
                            }
                        }
                        VideoPbFragment.this.dlI();
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
            String userId = I.bka().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dfX()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (I.bka() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, I.bka().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, I.bka().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, I.bka().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, I.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dfX()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> dgf = fVar.dgf();
                if (com.baidu.tbadk.core.util.y.getCount(dgf) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : dgf) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.exk) != null && abVar.euW && !abVar.euX && (abVar.type == 1 || abVar.type == 2)) {
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
    public void dif() {
        MarkData FO;
        if (dgX() != null && dgX().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bfx() || doz() != null) {
                if ((!com.baidu.tbadk.a.d.bfx() || doB() != null) && this.lnO != null) {
                    if (dgX().getPbData() != null && dgX().getPbData().dgl()) {
                        FO = dgX().FO(0);
                    } else if (this.eFw != null && this.eFw.getCurrentItem() == lFR) {
                        FO = dgX().o(I(dgX().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bfx()) {
                        FO = dgX().FO(doB().dlk());
                    } else {
                        FO = dgX().FO(doz().dlk());
                    }
                    if (FO != null) {
                        if (!FO.isApp() || (FO = dgX().FO(doz().dlk() + 1)) != null) {
                            dlf();
                            this.lnO.a(FO);
                            if (!this.lnO.bfV()) {
                                this.lnO.bfX();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lnO.bfW();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FD(int i) {
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
            if (this.lnD == null) {
                this.lnD = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lnl);
                this.lnD.b(this.fjX);
                this.lnD.c(this.fke);
            }
            this.lnD.a(emotionImageData, dgX(), dgX().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dfV() != null) {
            return fVar.dfV();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dfK())) {
            Iterator<PostData> it = fVar.dfK().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dHx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dfR();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bka() != null && postData.bka().getUserTbVipInfoData() != null && postData.bka().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bka().getGodUserData().setIntro(postData.bka().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dfI() == null || fVar.dfI().bka() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bka = fVar.dfI().bka();
        String userId = bka.getUserId();
        HashMap<String, MetaData> userMap = fVar.dfI().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bka;
        }
        postData.Jq(1);
        postData.setId(fVar.dfI().bkr());
        postData.setTitle(fVar.dfI().getTitle());
        postData.setTime(fVar.dfI().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dik() {
        ArrayList<PostData> dfK;
        int count;
        int i;
        if (dgX() == null || dgX().getPbData() == null || dgX().getPbData().dfK() == null || (count = com.baidu.tbadk.core.util.y.getCount((dfK = dgX().getPbData().dfK()))) == 0) {
            return "";
        }
        if (dgX().djn()) {
            Iterator<PostData> it = dfK.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dHx() == 1) {
                    return next.getId();
                }
            }
        }
        if (czc() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bfx()) {
            i = doB().dlj();
        } else {
            i = doz().dlj();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dfK, i);
        if (postData == null || postData.bka() == null) {
            return "";
        }
        if (dgX().Pp(postData.bka().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dfK, i2);
            if (postData2 == null || postData2.bka() == null || postData2.bka().getUserId() == null) {
                break;
            } else if (dgX().Pp(postData2.bka().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dfK, i3);
            if (postData3 == null || postData3.bka() == null || postData3.bka().getUserId() == null) {
                return "";
            }
            if (dgX().Pp(postData3.bka().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dig() {
        if (dgX() != null) {
            com.baidu.tieba.pb.data.f pbData = dgX().getPbData();
            dgX().uo(true);
            if (this.lnO != null) {
                pbData.Pa(this.lnO.bfU());
            }
            if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
                doB().dpk();
            } else if (doz() != null) {
                doz().dpk();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dgX() != null) {
            dlh();
            dgX().uo(z);
            if (this.lnO != null) {
                this.lnO.ih(z);
                if (markData != null) {
                    this.lnO.a(markData);
                }
            }
            if (dgX().bfV()) {
                dig();
            } else if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
                doB().dpk();
            } else if (doz() != null) {
                doz().dpk();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (dgX() != null && dgX().getPbData() != null && pVar.dgy() != null) {
            String id = pVar.dgy().getId();
            ArrayList<PostData> dfK = dgX().getPbData().dfK();
            int i = 0;
            while (true) {
                if (i >= dfK.size()) {
                    z = true;
                    break;
                }
                PostData postData = dfK.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dgG = pVar.dgG();
                    postData.Jp(pVar.getTotalCount());
                    if (postData.dHu() == null || dgG == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dgG.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bka() != null && (metaData = postData.getUserMap().get(next.bka().getUserId())) != null) {
                                next.a(metaData);
                                next.xl(true);
                                next.a(getPageContext(), dgX().Pp(metaData.getUserId()));
                            }
                        }
                        z = dgG.size() != postData.dHu().size();
                        if (postData.dHu() != null && postData.dHu().size() < 2) {
                            postData.dHu().clear();
                            postData.dHu().addAll(dgG);
                        }
                    }
                    if (postData.dHq() != null) {
                        postData.dHr();
                    }
                }
            }
            if (!dgX().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
                    doB().dpk();
                } else if (doz() != null) {
                    doz().dpk();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhX() {
        if (dgX() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.RK(dgX().getForumId()) && dgX().getPbData() != null && dgX().getPbData().getForum() != null) {
            if (dgX().getPbData().getForum().isLike() == 1) {
                dgX().djB().gi(dgX().getForumId(), dgX().diV());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bw dfI = fVar.dfI();
            if (dfI != null && dfI.biK()) {
                diE();
            } else {
                d(this.lob);
            }
            if (this.lod != null) {
                uH(this.lod.bxM());
                this.lod.a(fVar.getAnti());
                this.lod.a(fVar.getForum(), fVar.getUserData());
                this.lod.setThreadData(dfI);
                if (dgX() != null) {
                    this.lod.a(dgX().djl(), dgX().diV(), dgX().djC());
                }
                if (dfI != null) {
                    this.lod.kc(dfI.blx());
                }
            }
        }
    }

    public void dkK() {
        reset();
        dkG();
        this.lwv.dhD();
        uJ(false);
    }

    private void reset() {
        if (this.lod != null && this.abk != null) {
            com.baidu.tbadk.editortools.pb.a.bxB().setStatus(0);
            this.lod.bxW();
            this.lod.bxl();
            if (this.lod.getWriteImagesInfo() != null) {
                this.lod.getWriteImagesInfo().setMaxImagesAllowed(this.lod.isBJH ? 1 : 9);
            }
            this.lod.rk(SendView.ALL);
            this.lod.rl(SendView.ALL);
            h qX = this.abk.qX(23);
            h qX2 = this.abk.qX(2);
            h qX3 = this.abk.qX(5);
            if (qX2 != null) {
                qX2.display();
            }
            if (qX3 != null) {
                qX3.display();
            }
            if (qX != null) {
                qX.hide();
            }
            this.abk.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dfI() != null) {
            x(fVar);
            this.lvR.setVisibility(fVar.dgl() ? 8 : 0);
            if (fVar.bfV()) {
                SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.boN().a(this.lvR, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String FW = FW(fVar.dfI().bjR());
            if (this.lvU != null) {
                this.lvU.setText(FW);
            }
            if (this.lvV != null) {
                this.lvV.setText(FW);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dfI()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.dfI())) {
            if (this.lvT != null) {
                this.lvT.setEnable(false);
                this.lvT.onDestroy();
            }
            SvgManager.boN().a(this.lvS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.lvT == null || !this.lvT.isEnable()) {
            SvgManager.boN().a(this.lvS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String FW(int i) {
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

    public void uJ(boolean z) {
        if (this.lvN != null) {
            uH(this.lod.bxM());
            if (this.lvJ) {
                uy(z);
            } else {
                uz(z);
            }
            dor();
            dos();
        }
    }

    public void dlI() {
        if (this.lvN != null) {
            this.lvM.setVisibility(8);
            this.lvN.setVisibility(8);
            this.lGo.lGI = false;
            dor();
            dos();
        }
    }

    private void dor() {
        if (this.lGa != null) {
            if (this.lGo.doJ()) {
                this.lGa.wk(false);
            } else {
                this.lGa.wk(this.lGa.bUC() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dos() {
        if (this.lGa != null && this.eFw != null) {
            if (com.baidu.tbadk.a.d.bfx()) {
                this.lGa.vs(false);
            } else if (this.eFw.getCurrentItem() != 0) {
                this.lGa.vs(false);
            } else if (this.lGo.doJ()) {
                this.lGa.vs(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.lGa.vs(eVar.doT() == null || eVar.doT().getValue() == null || eVar.doT().getValue().booleanValue());
                }
            }
        }
    }

    private void FE(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(diC(), dhW(), i);
    }

    private int dhW() {
        if (dgX() == null || dgX().getPbData() == null || dgX().getPbData().dfI() == null) {
            return -1;
        }
        return dgX().getPbData().dfI().bkN();
    }

    public void uH(boolean z) {
        this.lvJ = z;
    }

    public void uy(boolean z) {
        if (this.lvN != null && this.jEf != null) {
            this.jEf.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lvN.startAnimation(alphaAnimation);
            }
            this.lvM.setVisibility(0);
            this.lvN.setVisibility(0);
            this.lGo.lGI = true;
        }
    }

    public void uz(boolean z) {
        if (this.lvN != null && this.jEf != null) {
            this.jEf.setText(dkM());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lvN.startAnimation(alphaAnimation);
            }
            this.lvM.setVisibility(0);
            this.lvN.setVisibility(0);
            this.lGo.lGI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lhH == null) {
            this.lhH = aVar;
            this.lGf.setText(aVar.getTitle());
            this.lGg.setText(aVar.dpx());
            String dpy = aVar.dpy();
            TBSpecificationBtn tBSpecificationBtn = this.lGi;
            if (TextUtils.isEmpty(dpy)) {
                dpy = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dpy);
            this.lGj.startLoad(aVar.getImage(), 10, false);
            this.lGk.setVisibility(aVar.dpA() ? 0 : 8);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lhH == null || VideoPbFragment.this.lhH.dpA()) {
                        if (VideoPbFragment.this.lhH != null && VideoPbFragment.this.dgX() != null && VideoPbFragment.this.dgX().getPbData() != null && VideoPbFragment.this.dgX().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dR("fid", VideoPbFragment.this.dgX().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dgX().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dgX().getPbData().getThreadId()).w("obj_param1", VideoPbFragment.this.lhH.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dR("obj_id", VideoPbFragment.this.lhH.getTitle()).dR("obj_name", VideoPbFragment.this.lhH.dpx()).aj("obj_type", 2).dR("fid", VideoPbFragment.this.dgX().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dgX().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dot();
                }
            }, aVar.dpz().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dot() {
        ViewGroup.LayoutParams layoutParams = this.lGd.getLayoutParams();
        if (layoutParams != null) {
            if (this.lGl == null || !this.lGl.isRunning()) {
                this.lGd.setAlpha(0.0f);
                this.lGd.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dou() {
        if (this.lGd.getLayoutParams() != null) {
            if (this.lGl == null || !this.lGl.isRunning()) {
                dov();
            }
        }
    }

    private void dov() {
        final ViewGroup.LayoutParams layoutParams = this.lGd.getLayoutParams();
        if (layoutParams != null) {
            if (this.lGm == null || !this.lGm.isRunning()) {
                this.lGm = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.lGm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.lGd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.lGm.setDuration(200L);
                this.lGm.start();
                this.lGm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
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
        this.lGl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lGl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jAA);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.jAA);
                VideoPbFragment.this.lGd.setLayoutParams(layoutParams);
                VideoPbFragment.this.Yh.setLayoutParams(layoutParams2);
            }
        });
        this.lGl.setDuration(300L);
        this.lGl.start();
        this.lGl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.lGd.setVisibility(8);
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
        this.lGl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lGl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.jAA);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.lGd.setLayoutParams(layoutParams);
                VideoPbFragment.this.Yh.setLayoutParams(layoutParams2);
            }
        });
        this.lGl.setDuration(300L);
        this.lGl.start();
        this.lGl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dow();
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
    public void dow() {
        this.lGl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lGl.setDuration(300L);
        this.lGl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.lGd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.lGl.start();
    }

    public String dkM() {
        if (!at.isEmpty(this.lwM)) {
            return this.lwM;
        }
        this.lwM = TbadkCoreApplication.getInst().getResources().getString(ay.dkB());
        return this.lwM;
    }

    public void dlh() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bfx() && doB() != null) {
            doB().endLoadData();
            doB().dli();
        } else if (doz() != null) {
            doz().endLoadData();
            doz().dli();
        }
    }

    public boolean dd(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bhh().isShowImages()) {
                    return Pl(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dgX() == null || dgX().getPbData() == null) {
                        return true;
                    }
                    if (this.lwv != null) {
                        this.lwv.dhD();
                    }
                    p pVar = new p();
                    pVar.a(dgX().getPbData().getForum());
                    pVar.setThreadData(dgX().getPbData().dfI());
                    pVar.g(postData);
                    this.lnf.d(pVar);
                    this.lnf.setPostId(postData.getId());
                    a(view, postData.bka().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lod != null) {
                        uH(this.lod.bxM());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dox() {
        if (this.lod != null) {
            uH(this.lod.bxM());
        }
        dkK();
        this.lGn.dly();
    }

    private boolean Pl(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("bubble_link", "");
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

    public void cQT() {
        if (this.lvv != null) {
            this.lvv.setVisibility(0);
        }
    }

    public void cQS() {
        if (this.lvv != null) {
            this.lvv.setVisibility(8);
        }
    }

    public void Gn(int i) {
        if (this.lFX != null) {
            this.lFX.setVisibility(i);
        }
    }

    public void dlf() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dia() {
        return this.loW;
    }

    public void dkG() {
        if (this.abk != null) {
            this.abk.hide();
        }
    }

    public void cwk() {
        if (this.lnl.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lnl.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dfI() != null) {
            String valueOf = String.valueOf(fVar.dfI().bjR());
            if (fVar.dfI().bjR() == 0) {
                valueOf = "";
            }
            this.lFV.Ex(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.lFW.doK()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dgX() != null && dgX().getPbData() != null && dgX().getPbData().dfI() != null && dgX().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(lwo)).intValue();
                if (intValue == lwp) {
                    if (!this.hST.dIi()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.hST.SC(at.R(jSONArray));
                        }
                        this.hST.a(dgX().getPbData().getForum().getId(), dgX().getPbData().getForum().getName(), dgX().getPbData().dfI().getId(), str, intValue3, intValue2, booleanValue, dgX().getPbData().dfI().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == lwq || intValue == lws) {
                    if (dgX().djy() != null) {
                        dgX().djy().Fy(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == lwq) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(String str, String str2) {
        be.boR().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bDU() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bDV() {
        if (this.fzV == null) {
            this.fzV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bEh */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bhh().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bhh().isShowImages()) {
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
        return this.fzV;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bDW() {
        if (this.fDm == null) {
            this.fDm = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fDm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bDX() {
        if (this.fzW == null) {
            this.fzW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cqr */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bhh().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bhh().isShowImages()) {
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
                    gifView.byC();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fzW;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bDY() {
        if (this.fDn == null) {
            this.fDn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: diF */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dg */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dh */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bWJ();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: di */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fDn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bDZ() {
        if (this.fDo == null) {
            this.fDo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: diH */
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
        return this.fDo;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bEa() {
        this.fDp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: diG */
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
        return this.fDp;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lnw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.be.PB(str) && dgX() != null && dgX().diV() != null) {
            TiebaStatic.log(new aq("c11664").aj("obj_param1", 1).dR("post_id", dgX().diV()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.fgu = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.be.dmd().f(getPageContext(), str);
        }
        this.lnw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
        com.baidu.tieba.pb.pb.main.be.dmd().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lnw = true;
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
            this.lGn.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dpg = this.lGn.dpg();
            if (dpg == null) {
                this.lGn.dhR();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dpg.getItemView(1).setVisibility(8);
            } else {
                dpg.getItemView(1).setVisibility(0);
            }
            dpg.bmE();
            this.lnw = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aB(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.boR().b(getPageContext(), new String[]{str});
            this.lnw = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a doy() {
        return this.eHC;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bBu() {
        return this.ftj;
    }

    public ReplyFragment doz() {
        if (this.lFW == null || !(this.lFW.Go(lFS) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.lFW.Go(lFS);
    }

    public DetailInfoFragment doA() {
        if (this.lFW == null || !(this.lFW.Go(lFR) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.lFW.Go(lFR);
    }

    public DetailInfoAndReplyFragment doB() {
        if (this.lFW == null || !(this.lFW.Go(lFT) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.lFW.Go(lFT);
    }

    public boolean dgO() {
        PbModel dgX = this.lnl.dgX();
        if (dgX == null) {
            return false;
        }
        return dgX.dgO();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dfU;
        PbModel dgX = this.lnl.dgX();
        if (dgX != null && dgX.getPbData() != null && !dgX.getPbData().dgl()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dgX.getPbData().dfI().getId();
            if (dgX.isShareThread() && dgX.getPbData().dfI().eAy != null) {
                historyMessage.threadName = dgX.getPbData().dfI().eAy.showText;
            } else {
                historyMessage.threadName = dgX.getPbData().dfI().getTitle();
            }
            if (dgX.isShareThread() && !dgO()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dgX.getPbData().getForum().getName();
            }
            ArrayList<PostData> dfK = dgX.getPbData().dfK();
            int dlj = doz() != null ? doz().dlj() : 0;
            if (dfK != null && dlj >= 0 && dlj < dfK.size()) {
                historyMessage.postID = dfK.get(dlj).getId();
            }
            historyMessage.isHostOnly = dgX.getHostMode();
            historyMessage.isSquence = dgX.diX();
            historyMessage.isShareThread = dgX.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lod != null) {
            this.lod.onDestroy();
        }
        if (dgX != null && (dgX.diY() || dgX.dja())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dgX.diV());
            if (this.lnR) {
                if (this.lnT) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dgX.coB());
                }
                if (this.lnS) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dgX.getIsGood());
                }
            }
            if (dgX.getPbData() != null && System.currentTimeMillis() - this.lns >= 40000 && (dfU = dgX.getPbData().dfU()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dfU.getDataList())) {
                intent.putExtra("guess_like_data", dfU);
            }
            PbActivity pbActivity = this.lnl;
            PbActivity pbActivity2 = this.lnl;
            pbActivity.setResult(-1, intent);
        }
        if (dih()) {
            if (dgX != null) {
                com.baidu.tieba.pb.data.f pbData = dgX.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lny) {
                        if (this.lFZ != null) {
                            Rect rect = new Rect();
                            this.lFZ.getGlobalVisibleRect(rect);
                            as.dkq().h(rect);
                        }
                        as.dkq().FS(this.eFw.getCurrentItem());
                        BdTypeRecyclerView czc = czc();
                        Parcelable parcelable = null;
                        if (czc != null) {
                            parcelable = czc.onSaveInstanceState();
                        }
                        as.dkq().a(dgX.djf(), parcelable, dgX.diX(), dgX.getHostMode(), false);
                    }
                }
            } else {
                as.dkq().reset();
            }
            dhk();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lGa != null && !this.lGa.bUC()) {
            if ((this.lGa.isFullScreen() && configuration.orientation == 1) || (!this.lGa.isFullScreen() && configuration.orientation == 2)) {
                this.lGa.vt(false);
            }
        }
    }

    public boolean doC() {
        if (this.lGa == null) {
            return false;
        }
        return this.lGa.bUC();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a {
        public boolean lGI;
        public boolean lGJ;

        private a() {
            this.lGJ = true;
        }

        public boolean doJ() {
            return (this.lGI && this.lGJ) ? false : true;
        }
    }

    public void doD() {
        this.lnH = -1;
        this.lnI = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diy() {
        if (dgX() != null && !at.isEmpty(dgX().diV())) {
            com.baidu.tbadk.BdToken.c.bdF().q(com.baidu.tbadk.BdToken.b.ekj, com.baidu.adp.lib.f.b.toLong(dgX().diV(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.lFY.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doE() {
        if (this.lGx == null) {
            this.lGx = ObjectAnimator.ofFloat(this.lGc, "alpha", 0.0f, 1.0f);
            this.lGx.setDuration(200L);
        }
        this.lGx.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doF() {
        if (this.lGy == null) {
            this.lGy = ObjectAnimator.ofFloat(this.lGc, "alpha", 1.0f, 0.0f);
            this.lGy.setDuration(200L);
        }
        this.lGy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doG() {
        return this.lGa != null && this.lGa.doH();
    }

    public boolean doH() {
        return this.lGu;
    }

    public void vl(boolean z) {
        this.lGu = z;
    }

    public void uf(boolean z) {
        this.lnz = z;
    }

    public boolean diw() {
        return this.lnz;
    }
}
