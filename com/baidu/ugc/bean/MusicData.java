package com.baidu.ugc.bean;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MusicData extends MusicBaseBean {
    public static final String MUSIC_DATA_KEY = "musicData";
    public static final String MUSIC_LOC_HOME_TAB = "music_home_";
    public static final String MUSIC_LOC_REC = "music_rec";
    public static final String MUSIC_LOC_SEARCH = "music_home_search";
    public static final long serialVersionUID = -2120437114458663204L;
    public String authorUk;
    public String bgAccompanimentLocalPath;
    public String bgAccompanimentUrl;
    public String bgKrcLocalPath;
    public String bgKrcUrl;
    public String bgOriginalLocalPath;
    public String bgOriginalUrl;
    public boolean bgRepairSwitch;
    public String bgSound;
    public int category;
    public long clipFrom;
    public long clipTo;
    public String collectStatus;
    public String duration;
    public String durationInt;
    public String ext;
    public String icon;
    public String id;
    public boolean isFollow;
    public boolean isLocalMusic;
    public boolean isMusicCompilation;
    public boolean isPlayedExceptH5;
    public String localPath;
    public String localTransCodePath;
    public double mKaraokeEndTime;
    public double mKaraokeStartTime;
    public int mProgress;
    public String musicAuthor;
    public String musicLabelUrl;
    public double musicLabelWh;
    public String musicLoc;
    public String musicName;
    public int played_web;
    public int rate;
    public double refrainEndTime;
    public double refrainStartTime;
    public String salt;
    public String singer;
    public long size;
    public String sk;
    public int sl;
    public String songShootCmd;
    public String soundSrc;
    public int startPosition;
    public String title;
    public String url;
    public String useNum;
    public String what;
    public boolean mIsUsing = false;
    public boolean mIsPlaying = false;
    public float mVolume = 1.0f;
    public int musicType = 0;

    public void d(String str) {
    }

    @Override // com.baidu.ugc.bean.MusicBaseBean
    public int getSpanSize() {
        return 5;
    }

    public MusicData() {
        this.type = 1;
    }

    public long getClipFrom() {
        return this.clipFrom;
    }

    public long getClipTo() {
        return this.clipTo;
    }

    public int getStartPosition() {
        return ((int) this.clipFrom) + this.startPosition;
    }

    public static MusicData parse(String str) {
        JSONObject jSONObject;
        MusicData musicData;
        boolean z;
        MusicData musicData2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            musicData = new MusicData();
        } catch (Exception e) {
            e = e;
        }
        try {
            musicData.id = jSONObject.optString(CloudMusicActivityConfig.MUSIC_ID);
            musicData.title = jSONObject.optString("music_title");
            musicData.singer = jSONObject.optString("music_singer");
            musicData.icon = jSONObject.optString("music_icon");
            musicData.url = jSONObject.optString("music_url");
            musicData.localPath = jSONObject.optString("music_local_path");
            musicData.sk = jSONObject.optString("sk");
            musicData.ext = jSONObject.optString("ext");
            musicData.startPosition = jSONObject.optInt("start_position");
            musicData.localTransCodePath = jSONObject.optString("music_local_transcode_path");
            boolean z2 = false;
            if (jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW) == 1) {
                z = true;
            } else {
                z = false;
            }
            musicData.isFollow = z;
            musicData.authorUk = jSONObject.optString("author_uk");
            musicData.musicName = jSONObject.optString("music_name");
            musicData.musicAuthor = jSONObject.optString("music_author");
            musicData.soundSrc = jSONObject.optString("sound_src");
            musicData.bgSound = jSONObject.optString("bg_sound");
            musicData.mVolume = (float) jSONObject.optDouble("volume", 1.0d);
            musicData.collectStatus = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS);
            musicData.mProgress = jSONObject.optInt("progress");
            musicData.musicType = jSONObject.optInt("ai_switch");
            musicData.isLocalMusic = jSONObject.optBoolean("local_music");
            musicData.musicLoc = jSONObject.optString("music_loc");
            musicData.bgAccompanimentUrl = jSONObject.optString("bgAccompanimentUrl");
            musicData.bgAccompanimentLocalPath = jSONObject.optString("bgAccompanimentLocalPath");
            musicData.bgOriginalLocalPath = jSONObject.optString("bgOriginalLocalPath");
            musicData.bgKrcUrl = jSONObject.optString("bgKrcUrl");
            musicData.bgRepairSwitch = jSONObject.optBoolean("bgRepairSwitch");
            musicData.bgKrcLocalPath = jSONObject.optString("bgKrcLocalPath");
            musicData.useNum = jSONObject.optString("use_num");
            musicData.durationInt = jSONObject.optString("duration_int");
            musicData.refrainStartTime = jSONObject.optDouble("refrain_start_time", 0.0d);
            musicData.refrainEndTime = jSONObject.optDouble("refrain_end_time", 0.0d);
            musicData.mKaraokeStartTime = jSONObject.optDouble("karaoke_start_time", 0.0d);
            musicData.mKaraokeEndTime = jSONObject.optDouble("karaoke_end_time", 0.0d);
            musicData.bgOriginalUrl = jSONObject.optString("bgOriginalUrl");
            musicData.bgOriginalLocalPath = jSONObject.optString("bgOriginalLocalPath");
            musicData.played_web = jSONObject.optInt("played_web");
            musicData.isPlayedExceptH5 = jSONObject.optBoolean("isPlayedExceptH5", false);
            if (jSONObject.optInt("music_compilation", 0) == 1) {
                z2 = true;
            }
            musicData.isMusicCompilation = z2;
            return musicData;
        } catch (Exception e2) {
            e = e2;
            musicData2 = musicData;
            e.printStackTrace();
            return musicData2;
        }
    }

    public static MusicData parseNetBean(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MusicData musicData = new MusicData();
        musicData.id = jSONObject.optString("id");
        musicData.icon = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        musicData.title = jSONObject.optString("name");
        musicData.singer = jSONObject.optString("singer");
        musicData.duration = jSONObject.optString("duration");
        musicData.collectStatus = jSONObject.optString(TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS);
        musicData.musicType = jSONObject.optInt("ai_switch");
        boolean z = false;
        if (jSONObject.optInt("music_compilation", 0) == 1) {
            z = true;
        }
        musicData.isMusicCompilation = z;
        JSONObject optJSONObject = jSONObject.optJSONObject("refrain_info");
        if (optJSONObject != null) {
            musicData.startPosition = optJSONObject.optInt("start_time");
        }
        return musicData;
    }

    public static String toJSON(MusicData musicData) {
        int i;
        if (musicData == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CloudMusicActivityConfig.MUSIC_ID, musicData.id);
            jSONObject.put("music_title", musicData.title);
            jSONObject.put("music_singer", musicData.singer);
            jSONObject.put("music_icon", musicData.icon);
            jSONObject.put("music_url", musicData.url);
            jSONObject.put("music_local_path", musicData.localPath);
            jSONObject.put("sk", musicData.sk);
            jSONObject.put("ext", musicData.ext);
            jSONObject.put("start_position", musicData.startPosition);
            jSONObject.put("music_local_transcode_path", musicData.localTransCodePath);
            if (musicData.isFollow) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put(TiebaStatic.Params.IS_FOLLOW, i);
            jSONObject.put("author_uk", musicData.authorUk);
            jSONObject.put("sound_src", musicData.soundSrc);
            jSONObject.put("bg_sound", musicData.bgSound);
            jSONObject.put("music_name", musicData.musicName);
            jSONObject.put("music_author", musicData.musicAuthor);
            jSONObject.put("volume", musicData.mVolume);
            jSONObject.put(TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, musicData.collectStatus);
            jSONObject.put("progress", musicData.mProgress);
            jSONObject.put("ai_switch", musicData.musicType);
            jSONObject.put("local_music", musicData.isLocalMusic);
            jSONObject.put("music_loc", musicData.musicLoc);
            jSONObject.put("bgAccompanimentUrl", musicData.bgAccompanimentUrl);
            jSONObject.put("bgAccompanimentLocalPath", musicData.bgAccompanimentLocalPath);
            jSONObject.put("bgOriginalLocalPath", musicData.bgOriginalLocalPath);
            jSONObject.put("bgKrcUrl", musicData.bgKrcUrl);
            jSONObject.put("bgRepairSwitch", musicData.bgRepairSwitch);
            jSONObject.put("bgKrcLocalPath", musicData.bgKrcLocalPath);
            jSONObject.put("use_num", musicData.useNum);
            jSONObject.put("duration_int", musicData.durationInt);
            jSONObject.put("refrain_start_time", musicData.refrainStartTime);
            jSONObject.put("refrain_end_time", musicData.refrainEndTime);
            jSONObject.put("karaoke_start_time", musicData.mKaraokeStartTime);
            jSONObject.put("karaoke_end_time", musicData.mKaraokeEndTime);
            jSONObject.put("bgOriginalUrl", musicData.bgOriginalUrl);
            jSONObject.put("bgOriginalLocalPath", musicData.bgOriginalLocalPath);
            jSONObject.put("played_web", musicData.played_web);
            jSONObject.put("isPlayedExceptH5", musicData.isPlayedExceptH5);
            jSONObject.put("music_compilation", musicData.isMusicCompilation);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String toJSONFromNetBean(MusicData musicData) {
        if (musicData == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", musicData.id);
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, musicData.icon);
            jSONObject.put("name", musicData.title);
            jSONObject.put("singer", musicData.singer);
            jSONObject.put("duration", musicData.duration);
            jSONObject.put(TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, musicData.collectStatus);
            jSONObject.put("ai_switch", musicData.musicType);
            jSONObject.put("ai_switch", musicData.musicType);
            jSONObject.put("music_compilation", musicData.isMusicCompilation);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("start_time", musicData.startPosition);
            jSONObject.put("refrain_info", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public long getMusicDuration() {
        long parseLong;
        long parseLong2;
        try {
            if (!TextUtils.isEmpty(this.duration)) {
                String[] split = this.duration.split(":");
                if (split.length == 1) {
                    return Long.parseLong(split[0]) * 1000;
                }
                if (split.length == 2) {
                    parseLong = Long.parseLong(split[1]);
                    long parseLong3 = Long.parseLong(split[0]);
                    Long.signum(parseLong3);
                    parseLong2 = parseLong3 * 60;
                } else if (split.length != 3) {
                    return 0L;
                } else {
                    parseLong = Long.parseLong(split[2]) + (Long.parseLong(split[1]) * 60);
                    parseLong2 = Long.parseLong(split[0]) * 3600;
                }
                return (parseLong + parseLong2) * 1000;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public void setClipFrom(long j) {
        this.clipFrom = j;
    }

    public void setClipTo(long j) {
        this.clipTo = j;
    }

    public void setStartPosition(int i) {
        this.startPosition = i - ((int) this.clipFrom);
    }
}
