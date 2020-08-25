package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes2.dex */
public class PostData implements q, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> dZj;
    private SkinInfo ecY;
    private OriginalThreadInfo edE;
    private String edb;
    private Item eew;
    private TbRichTextVoiceInfo euF;
    private SmallTailInfo kTs;
    private String kxm;
    public int locate;
    private String meV;
    private ArrayList<PostData> meZ;
    public AlaLiveInfoCoreData mfA;
    private boolean mfE;
    public aq mfI;
    private com.baidu.tbadk.data.c mfg;
    private com.baidu.tbadk.data.f mfh;
    private i mfk;
    private bs mfl;
    public boolean mfn;
    private com.baidu.tbadk.widget.richText.j mfo;
    private String mfp;
    private String mfq;
    private TPointPost mfr;
    public int mfu;
    public boolean mfx;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId meM = BdUniqueId.gen();
    public static final BdUniqueId meN = BdUniqueId.gen();
    public static final BdUniqueId ecZ = BdUniqueId.gen();
    public static final BdUniqueId ebj = BdUniqueId.gen();
    public static final BdUniqueId ebo = BdUniqueId.gen();
    public static final BdUniqueId meO = BdUniqueId.gen();
    public static final BdUniqueId meP = BdUniqueId.gen();
    public static final BdUniqueId meQ = BdUniqueId.gen();
    public static final BdUniqueId meR = BdUniqueId.gen();
    public static final BdUniqueId meS = BdUniqueId.gen();
    public static boolean meT = false;
    private int meU = 0;
    private boolean mfa = false;
    private ArrayList<PostData> mfb = null;
    private TbRichText mfc = null;
    private boolean mff = false;
    private boolean mfi = false;
    private boolean mfj = false;
    public boolean mfm = false;
    public int ecy = 0;
    private boolean mfs = false;
    public boolean ibK = false;
    public boolean mft = false;
    public boolean mfv = false;
    public boolean mfw = true;
    public boolean mfy = false;
    public boolean mfz = false;
    private boolean mfB = false;
    private int mfC = 0;
    private boolean mfD = true;
    public boolean mfF = false;
    public boolean mfG = false;
    public boolean mfH = false;
    public boolean mfJ = false;
    public boolean mfK = false;
    private b mfL = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.mfI != null) {
                aq bjm = PostData.this.mfI.bjm();
                bjm.delete("obj_locate");
                bjm.ai("obj_locate", 7);
                TiebaStatic.log(bjm);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData ecb = new MetaData();
    private ArrayList<l> meW = new ArrayList<>();
    private ArrayList<l> meX = new ArrayList<>();
    private int meY = 0;
    private int ecJ = 0;
    private PraiseData ecm = new PraiseData();
    private ax mfd = new ax();
    private c mfe = new c();
    private ArrayList<com.baidu.tbadk.data.c> ecV = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes2.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.meZ = null;
        this.mfu = 0;
        this.meZ = new ArrayList<>();
        this.mfu = 0;
    }

    public void vY(boolean z) {
        this.mfE = z;
    }

    public boolean dwx() {
        return this.mfE;
    }

    public ArrayList<PostData> dwy() {
        return this.mfb;
    }

    public void dwz() {
        this.mfb.clear();
        this.mfb = null;
        this.mfa = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.mfb == null) {
                this.mfb = new ArrayList<>();
                if (y.getCount(this.meZ) > 2) {
                    this.mfb.addAll(y.subList(this.meZ, 0, 2));
                } else {
                    this.mfb.addAll(this.meZ);
                }
            }
            this.mfb.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.meZ != null) {
            this.meZ.add(postData);
            dwD();
        }
    }

    public void QN(String str) {
        if (this.mfb != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.mfb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.mfb.remove(next);
                    return;
                }
            }
        }
    }

    public void vZ(boolean z) {
        this.mfD = z;
    }

    public boolean dwA() {
        return this.mfD;
    }

    public void wa(boolean z) {
        this.mfa = z;
    }

    public boolean dwB() {
        return this.mfa;
    }

    public ArrayList<PostData> dwC() {
        return this.meZ;
    }

    public void dwD() {
        this.meY++;
    }

    public void dwE() {
        this.meY--;
    }

    public void HO(int i) {
        this.meY = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dwF() {
        return this.floor_num;
    }

    public void HP(int i) {
        this.floor_num = i;
    }

    public boolean dwG() {
        return this.mfj;
    }

    public void wb(boolean z) {
        this.mfj = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData beE() {
        return this.ecb;
    }

    public void a(MetaData metaData) {
        this.ecb = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ecm = praiseData;
    }

    public TbRichText dwH() {
        return this.mfc;
    }

    public void c(TbRichText tbRichText) {
        this.mfc = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo ddj() {
        return this.kTs;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.kTs = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dwI() {
        return this.mfh;
    }

    public SkinInfo bfa() {
        return this.ecY;
    }

    public void wc(boolean z) {
        this.mfB = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.mfc != null && this.mfc.bxw() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.ecb != null && this.ecb.getIs_bawu() == 1) {
                    if (this.mfE) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.ecb.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.ecb.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.ecb.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.ecb.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = beE().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mM().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.mM().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.mfc.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.ecb.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.ecb.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.ecb == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.ecb.getName_show() + str + "：");
                str2 = this.ecb.getUserName();
                str3 = this.ecb.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.ecb.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.ecb.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.mfL), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.ecb != null && this.ecb.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.ecb != null && this.ecb.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.ecb != null) {
                        int i3 = 0;
                        if (this.ecb.getName_show() != null) {
                            i3 = this.ecb.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bxw = this.mfc.bxw();
            if (bxw != null && bxw.size() > 0) {
                TbRichTextData tbRichTextData2 = bxw.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bxD() != null) {
                    if (this.mfB) {
                        int indexOf = tbRichTextData2.bxD().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bxD().delete(0, indexOf + 1);
                        }
                        this.mfB = false;
                    }
                    tbRichTextData2.rp(sb.length());
                    tbRichTextData2.bxD().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bxw.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bxw.get(i5) == null || bxw.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bxE = bxw.get(i5).bxE();
                            bxw.remove(i5);
                            tbRichTextVoiceInfo = bxE;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.rp(sb.length());
                    tbRichTextData.n(spannableString);
                    bxw.add(0, tbRichTextData);
                }
            }
            this.mfF = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.is(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.oy(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.Ay(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dwJ() {
        return this.meY;
    }

    public void fE(Context context) {
        int type;
        int i;
        int i2;
        if (this.meW != null) {
            int i3 = -1;
            int size = this.meX.size();
            if (size > 0) {
                try {
                    i3 = this.meX.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.meW.size()) {
                l lVar = this.meW.get(i4);
                if (l.dl(i5, lVar.getType())) {
                    this.meX.get(size - 1).b(lVar.fD(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.meX.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fD(context));
                        this.meX.add(lVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void fF(Context context) {
        try {
            if (this.mfc != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.mfc.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.meX == null || this.meX.size() == 0) {
                fE(context);
            }
            ArrayList<l> arrayList = this.meX;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dwp() != null) {
                            sb.append((CharSequence) next.dwp());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String BP = TbFaceManager.bsV().BP(next.getText());
                        if (BP != null) {
                            sb.append("[");
                            sb.append(BP);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dwo())) {
                        sb.append("[").append(next.dwo()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.mfi = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ecb = metaData;
                }
                if (this.ecb.getUserId() == null || this.ecb.getUserId().length() <= 0 || this.ecb.getUserId().equals("0")) {
                    this.ecb = metaData2;
                }
                this.mfc = TbRichTextView.a(context, subPostList.content, z);
                if (this.mfc != null) {
                    this.mfc.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.meV = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ecb = metaData;
                }
                this.ibK = post.need_log.intValue() == 1;
                this.mft = post.img_num_abtest.intValue() == 1;
                this.mfl = new bs();
                this.mfl.parserProtobuf(post.from_forum);
                if (this.ecb.getUserId() == null || this.ecb.getUserId().length() <= 0 || this.ecb.getUserId().equals("0")) {
                    this.ecb.parserProtobuf(post.author);
                }
                if (this.ecb != null && context != null) {
                    this.mfp = this.ecb.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.mfq = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.ecb.getLevel_id()));
                }
                this.mff = post.is_ntitle.intValue() == 1;
                this.meY = post.sub_post_number.intValue();
                this.mfk = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.mfJ = post.is_wonderful_post.intValue() == 1;
                this.mfG = post.is_top_agree_post.intValue() == 1;
                this.dZj = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eew = post.item;
                }
                this.mfc = TbRichTextView.a(context, list, true);
                if (this.mfc != null) {
                    this.mfc.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.mfc.ro(this.floor_num);
                    if (this.ecb != null) {
                        this.mfc.setAuthorId(this.ecb.getUserId());
                    }
                    int count = y.getCount(this.dZj);
                    if (this.floor_num == 1 && count != 0 && this.dZj != null) {
                        ArrayList<TbRichTextData> bxw = this.mfc.bxw();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bxw, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bxw, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.dZj, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.o(com.baidu.tbadk.widget.richText.e.G(i, false));
                            }
                        } else {
                            for (int size = this.dZj.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.dZj.get(size);
                                if (headItem2 != null) {
                                    a(bxw, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eew != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eew));
                        y.add(this.mfc.bxw(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.mfi = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.vY(this.mfE);
                            postData.a(subPostList, context);
                            this.meZ.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.mfe.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.mfg = new com.baidu.tbadk.data.c();
                    this.mfg.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.mfh = new com.baidu.tbadk.data.f();
                    this.mfh.a(post.lbs_info);
                }
                this.ecJ = post.storecount.intValue();
                this.mfd.a(post.present);
                this.ecm.setUserMap(this.userMap);
                this.ecm.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.kTs = new SmallTailInfo();
                    this.kTs.id = post.signature.signature_id.intValue();
                    this.kTs.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.kTs.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.kTs.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.kTs.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.ecV.add(cVar);
                    }
                }
                this.ecY = post.skin_info;
                this.edb = post.lego_card;
                this.mfr = post.tpoint_post;
                if (post.agree != null) {
                    this.mfs = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.mfs = false;
                }
                this.mfz = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.edE = new OriginalThreadInfo();
                    this.edE.a(post.origin_thread_info);
                } else {
                    this.edE = null;
                }
                this.mfC = post.is_fold.intValue();
                this.kxm = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.G(i, true));
        }
        tbRichTextData.n(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes2.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> mfR;
        private b mfS;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.mfR = new SoftReference<>(context);
            this.mfS = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mfR != null && this.mfR.get() != null) {
                if (this.mfS != null) {
                    this.mfS.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mfR.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fG(Context context) {
        ArrayList<TbRichTextData> bxw;
        if (this.mfc == null || (bxw = this.mfc.bxw()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bxw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bxD().toString());
            } else if (next.getType() == 17) {
                String str = next.bxH().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dwK() {
        ArrayList<TbRichTextData> bxw;
        String str;
        if (this.mfc == null || (bxw = this.mfc.bxw()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bxw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bxD().toString());
                } else if (next.getType() == 17) {
                    if (next.bxH() != null && next.bxH().mGifInfo != null && (str = next.bxH().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dwL() {
        ArrayList<TbRichTextData> bxw;
        if (this.mfc != null && (bxw = this.mfc.bxw()) != null) {
            Iterator<TbRichTextData> it = bxw.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bxC().getWidth();
                    preLoadImageInfo.height = next.bxC().getHeight();
                    preLoadImageInfo.imgUrl = next.bxC().bxS();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bxI().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bxI().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bxI().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dwM() {
        k dwm;
        PreLoadImageInfo dwL = dwL();
        if (dwL != null && !StringUtils.isNull(dwL.imgUrl)) {
            return dwL.imgUrl;
        }
        if (this.mfk != null && (dwm = this.mfk.dwm()) != null && !StringUtils.isNull(dwm.dwn())) {
            return dwm.dwn();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bxw;
        if (this.mfc == null || (bxw = this.mfc.bxw()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bxw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bxC().getWidth();
                preLoadImageInfo.height = next.bxC().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bxC().bxX()) {
                    preLoadImageInfo.imgUrl = next.bxC().bxT();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bxC().bxS();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bxH() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bxH().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bxH().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bxH();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.ecb == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.ecb.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.meU == 52) {
            return meQ;
        }
        if (this.meU == 1) {
            return ecZ;
        }
        if (this.meU == 36) {
            return ebj;
        }
        if (this.meU == 40 || this.meU == 50) {
            return ebo;
        }
        if (this.meU == 41) {
            return meO;
        }
        if (this.meU == 53) {
            return meR;
        }
        if (dwF() == 1) {
            return meM;
        }
        return meN;
    }

    public void setPostType(int i) {
        this.meU = i;
    }

    public ax dwN() {
        return this.mfd;
    }

    public void a(ax axVar) {
        this.mfd = axVar;
    }

    public i dwO() {
        return this.mfk;
    }

    public com.baidu.tbadk.widget.richText.j bxG() {
        if (this.mfo != null) {
            return this.mfo;
        }
        if (this.mfc != null && y.getCount(this.mfc.bxw()) > 0) {
            Iterator<TbRichTextData> it = this.mfc.bxw().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.mfo = next.bxG();
                    return this.mfo;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bxE() {
        if (this.euF != null) {
            return this.euF;
        }
        if (this.mfc != null && y.getCount(this.mfc.bxw()) > 0) {
            Iterator<TbRichTextData> it = this.mfc.bxw().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.euF = next.bxE();
                    return this.euF;
                }
            }
        }
        return null;
    }

    public String dwP() {
        return this.mfp;
    }

    public String bfO() {
        return this.edb;
    }

    public void bfQ() {
        if (this.ecy == 0) {
            this.ecy = 1;
        }
    }

    public long bgd() {
        return this.agreeData.disAgreeNum;
    }

    public int bgf() {
        return this.agreeData.agreeType;
    }

    public AgreeData bgv() {
        return this.agreeData;
    }

    public OriginalThreadInfo dwQ() {
        return this.edE;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.edE = originalThreadInfo;
    }

    public int dwR() {
        return this.mfC;
    }

    public String cVw() {
        return this.kxm;
    }
}
