package com.baidu.ugc.bean;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MusicData extends MusicBaseBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MUSIC_DATA_KEY = "musicdata";
    public static final String MUSIC_LOC_HOME_TAB = "music_home_";
    public static final String MUSIC_LOC_REC = "music_rec";
    public static final String MUSIC_LOC_SEARCH = "music_home_search";
    public static final long serialVersionUID = -2120437114458663204L;
    public transient /* synthetic */ FieldHolder $fh;
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
    public boolean isPlayedExceptH5;
    public String localPath;
    public String localTransCodePath;
    public boolean mIsPlaying;
    public boolean mIsUsing;
    public double mKaraokeEndTime;
    public double mKaraokeStartTime;
    public int mProgress;
    public float mVolume;
    public String musicAuthor;
    public String musicLabelUrl;
    public double musicLabelWh;
    public String musicLoc;
    public String musicName;
    public int musicType;
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

    public MusicData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsUsing = false;
        this.mIsPlaying = false;
        this.mVolume = 1.0f;
        this.musicType = 0;
        this.type = 1;
    }

    public static MusicData parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, str)) != null) {
            return (MusicData) invokeL.objValue;
        }
        MusicData musicData = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            MusicData musicData2 = new MusicData();
            try {
                musicData2.id = jSONObject.optString(CloudMusicActivityConfig.MUSIC_ID);
                musicData2.title = jSONObject.optString("music_title");
                musicData2.singer = jSONObject.optString("music_singer");
                musicData2.icon = jSONObject.optString("music_icon");
                musicData2.url = jSONObject.optString("music_url");
                musicData2.localPath = jSONObject.optString("music_local_path");
                musicData2.sk = jSONObject.optString(ContentUtil.RESULT_KEY_SK);
                musicData2.ext = jSONObject.optString("ext");
                musicData2.startPosition = jSONObject.optInt("start_position");
                musicData2.localTransCodePath = jSONObject.optString("music_local_transcode_path");
                boolean z = true;
                if (jSONObject.optInt(TiebaStatic.Params.IS_FOLLOW) != 1) {
                    z = false;
                }
                musicData2.isFollow = z;
                musicData2.authorUk = jSONObject.optString("author_uk");
                musicData2.musicName = jSONObject.optString("music_name");
                musicData2.musicAuthor = jSONObject.optString("music_author");
                musicData2.soundSrc = jSONObject.optString("sound_src");
                musicData2.bgSound = jSONObject.optString("bg_sound");
                musicData2.mVolume = (float) jSONObject.optDouble("volume", 1.0d);
                musicData2.collectStatus = jSONObject.optString("collect_status");
                musicData2.mProgress = jSONObject.optInt("progress");
                musicData2.musicType = jSONObject.optInt("ai_switch");
                musicData2.isLocalMusic = jSONObject.optBoolean("local_music");
                musicData2.musicLoc = jSONObject.optString("music_loc");
                musicData2.bgAccompanimentUrl = jSONObject.optString("bgAccompanimentUrl");
                musicData2.bgAccompanimentLocalPath = jSONObject.optString("bgAccompanimentLocalPath");
                musicData2.bgOriginalLocalPath = jSONObject.optString("bgOriginalLocalPath");
                musicData2.bgKrcUrl = jSONObject.optString("bgKrcUrl");
                musicData2.bgRepairSwitch = jSONObject.optBoolean("bgRepairSwitch");
                musicData2.bgKrcLocalPath = jSONObject.optString("bgKrcLocalPath");
                musicData2.useNum = jSONObject.optString("use_num");
                musicData2.durationInt = jSONObject.optString("duration_int");
                musicData2.refrainStartTime = jSONObject.optDouble("refrain_start_time", 0.0d);
                musicData2.refrainEndTime = jSONObject.optDouble("refrain_end_time", 0.0d);
                musicData2.mKaraokeStartTime = jSONObject.optDouble("karaoke_start_time", 0.0d);
                musicData2.mKaraokeEndTime = jSONObject.optDouble("karaoke_end_time", 0.0d);
                musicData2.bgOriginalUrl = jSONObject.optString("bgOriginalUrl");
                musicData2.bgOriginalLocalPath = jSONObject.optString("bgOriginalLocalPath");
                musicData2.played_web = jSONObject.optInt("played_web");
                musicData2.isPlayedExceptH5 = jSONObject.optBoolean("isPlayedExceptH5", false);
                return musicData2;
            } catch (Exception e2) {
                e = e2;
                musicData = musicData2;
                e.printStackTrace();
                return musicData;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static MusicData parseNetBean(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            MusicData musicData = new MusicData();
            musicData.id = jSONObject.optString("id");
            musicData.icon = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            musicData.title = jSONObject.optString("name");
            musicData.singer = jSONObject.optString("singer");
            musicData.duration = jSONObject.optString("duration");
            musicData.collectStatus = jSONObject.optString("collect_status");
            musicData.musicType = jSONObject.optInt("ai_switch");
            JSONObject optJSONObject = jSONObject.optJSONObject("refrain_info");
            if (optJSONObject != null) {
                musicData.startPosition = optJSONObject.optInt("start_time");
            }
            return musicData;
        }
        return (MusicData) invokeL.objValue;
    }

    public static String toJSON(MusicData musicData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, musicData)) == null) {
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
                jSONObject.put(ContentUtil.RESULT_KEY_SK, musicData.sk);
                jSONObject.put("ext", musicData.ext);
                jSONObject.put("start_position", musicData.startPosition);
                jSONObject.put("music_local_transcode_path", musicData.localTransCodePath);
                jSONObject.put(TiebaStatic.Params.IS_FOLLOW, musicData.isFollow ? 1 : 0);
                jSONObject.put("author_uk", musicData.authorUk);
                jSONObject.put("sound_src", musicData.soundSrc);
                jSONObject.put("bg_sound", musicData.bgSound);
                jSONObject.put("music_name", musicData.musicName);
                jSONObject.put("music_author", musicData.musicAuthor);
                jSONObject.put("volume", musicData.mVolume);
                jSONObject.put("collect_status", musicData.collectStatus);
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
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public long getClipFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.clipFrom : invokeV.longValue;
    }

    public long getClipTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.clipTo : invokeV.longValue;
    }

    public long getMusicDuration() {
        InterceptResult invokeV;
        long parseLong;
        long parseLong2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.bean.MusicBaseBean
    public int getSpanSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    public int getStartPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ((int) this.clipFrom) + this.startPosition : invokeV.intValue;
    }

    public void setClipFrom(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.clipFrom = j;
        }
    }

    public void setClipTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.clipTo = j;
        }
    }

    public void setStartPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.startPosition = i2 - ((int) this.clipFrom);
        }
    }
}
